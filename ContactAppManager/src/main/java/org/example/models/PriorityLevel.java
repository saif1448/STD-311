package org.example.models;

import lombok.Data;
import lombok.Getter;

@Getter
public enum PriorityLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int level;
    PriorityLevel(int level) {
        this.level = level;
    }
}
