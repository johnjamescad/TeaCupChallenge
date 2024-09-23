package com.teacuptechsystems.challenge;

public enum Direction {
    FORWARD(true),
    REVERSE(false);

    private final boolean direction;

    private Direction(boolean direction) {
        this.direction = direction;
    }

    public boolean getValue() {
        return this.direction;
    }

    public Direction changeDirection() {
        if (this == FORWARD) {
            return REVERSE;
        } else {
            return FORWARD;
        }
    }
}

