const express = require('express');
const path = require('path');

const app = express();
const PORT = 3000;
app.use(express.json());
app.use(express.static(path.join(__dirname, 'public'))); // serves index.html

// ----- Models -----
class SmartDevice {
    constructor(name) {
        this.name = name;
        this.status = 'OFF';
    }

    turnOn() {
        this.status = 'ON';
    }

    turnOff() {
        this.status = 'OFF';
    }

    getStatus() {
        return this.status;
    }
}

class SmartLight extends SmartDevice {
    constructor(name) {
        super(name);
    }
}

class SmartThermostat extends SmartDevice {
    constructor(name) {
        super(name);
        this.temperature = 22;
    }

    increaseTemperature() {
        this.temperature += 1;
    }

    decreaseTemperature() {
        this.temperature -= 1;
    }

    getTemperature() {
        return this.temperature;
    }
}

class Home {
    constructor() {
        this.rooms = {
            1: { name: 'Living Room', devices: {} },
            2: { name: 'Bedroom', devices: {} },
            3: { name: 'Kitchen', devices: {} }
        };
    }

    addDevice(roomId, device) {
        if (this.rooms[roomId]) {
            this.rooms[roomId].devices[device.name] = device;
        }
    }

    getDevice(roomId, deviceType) {
        return this.rooms[roomId]?.devices[deviceType];
    }

    getRoomStatus(roomId) {
        const room = this.rooms[roomId];
        if (!room) return null;

        const light = room.devices['light'];
        const thermostat = room.devices['thermostat'];

        return {
            id: roomId,
            name: room.name,
            light: light ? light.getStatus() : 'NOT INSTALLED',
            temperature: thermostat ? thermostat.getTemperature() : 'NOT INSTALLED'
        };
    }

    getAllRoomsStatus() {
        return Object.keys(this.rooms).map(roomId => this.getRoomStatus(roomId));
    }
}

const home = new Home();

// ----- Routes -----

// Get status of all rooms
app.get('/api/rooms', (req, res) => {
    res.json({ rooms: home.getAllRoomsStatus() });
});

// Get status of a particular room
app.get('/api/rooms/:roomId', (req, res) => {
    const roomId = req.params.roomId;
    const status = home.getRoomStatus(roomId);
    if (!status) return res.status(404).json({ error: 'Room not found' });
    res.json(status);
});

// Add smart light to room
app.post('/api/rooms/:roomId/devices/light', (req, res) => {
    const roomId = req.params.roomId;
    home.addDevice(roomId, new SmartLight('light'));
    res.json({ message: 'Smart light added' });
});

// Add smart thermostat to room
app.post('/api/rooms/:roomId/devices/thermostat', (req, res) => {
    const roomId = req.params.roomId;
    home.addDevice(roomId, new SmartThermostat('thermostat'));
    res.json({ message: 'Smart thermostat added' });
});

// Set light ON or OFF
app.post('/api/rooms/:roomId/light/:status', (req, res) => {
    const { roomId, status } = req.params;
    const light = home.getDevice(roomId, 'light');

    if (!light) return res.status(404).json({ error: 'Light not found in this room' });

    if (status === 'ON') light.turnOn();
    else if (status === 'OFF') light.turnOff();
    else return res.status(400).json({ error: 'Invalid status' });

    res.json({ message: `Light turned ${status}` });
});

// Adjust thermostat temperature
app.post('/api/rooms/:roomId/temperature/:action', (req, res) => {
    const { roomId, action } = req.params;
    const thermostat = home.getDevice(roomId, 'thermostat');

    if (!thermostat) return res.status(404).json({ error: 'Thermostat not found in this room' });

    if (action === 'increase') thermostat.increaseTemperature();
    else if (action === 'decrease') thermostat.decreaseTemperature();
    else return res.status(400).json({ error: 'Invalid action' });

    res.json({ message: `Temperature ${action}d` });
});

// ----- Start Server -----
app.listen(PORT, () => {
    console.log(`🚀 Smart Home API running at http://localhost:${PORT}`);
});
