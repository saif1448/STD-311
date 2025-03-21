const express = require('express');
const cors = require('cors');
const http = require('http');
const WebSocket = require('ws');

const app = express();
const server = http.createServer(app);
const wss = new WebSocket.Server({ server });

const port = 3000;

app.use(cors());
app.use(express.json());
app.use(express.static('public'));

// Initial states for rooms
let rooms = {
    1: { light: 'OFF', temperature: 22 },
    2: { light: 'OFF', temperature: 22 },
    3: { light: 'OFF', temperature: 22 }
};

// WebSocket connection handler
wss.on('connection', ws => {
    console.log('Client connected');
    ws.on('close', () => console.log('Client disconnected'));
});

// Function to broadcast updates to all connected clients
function broadcast() {
    wss.clients.forEach(client => {
        if (client.readyState === WebSocket.OPEN) {
            client.send(JSON.stringify({ rooms }));
        }
    });
}

// Endpoint to update light status
app.post('/api/light/:room/:status', (req, res) => {
    const roomId = req.params.room;
    const status = req.params.status.toUpperCase();
    if (rooms[roomId]) {
        if (status === 'TOGGLE') {
            rooms[roomId].light = rooms[roomId].light === 'ON' ? 'OFF' : 'ON';
        } else {
            rooms[roomId].light = status;
        }
        broadcast(); // Notify WebSocket clients with the updated state
        res.json({ message: `Room ${roomId} light turned ${rooms[roomId].light}`, status: rooms[roomId].light, rooms });
    } else {
        res.status(404).json({ error: 'Room not found' });
    }
});

// Endpoint to update temperature
app.post('/api/temperature/:room/:action', (req, res) => {
    const roomId = req.params.room;
    const action = req.params.action;
    if (rooms[roomId]) {
        if (action === 'increase') {
            rooms[roomId].temperature += 1;
        } else if (action === 'decrease') {
            rooms[roomId].temperature -= 1;
        }
        broadcast(); // Notify WebSocket clients with the updated state
        res.json({ message: `Room ${roomId} temperature set to ${rooms[roomId].temperature}°C`, temperature: rooms[roomId].temperature, rooms });
    } else {
        res.status(404).json({ error: 'Room not found' });
    }
});

// Endpoint to get room status
app.get('/api/status', (req, res) => {
    res.json(rooms);
});

// Start the server and WebSocket server
server.listen(port, () => {
    console.log(`Smart Home API listening at http://localhost:${port}`);
});
