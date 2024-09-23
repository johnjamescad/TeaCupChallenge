package com.teacuptechsystems.challenge;

public enum Speed {
        OFF,
        ONE,
        TWO,
        THREE;

    private static final int COUNT = Speed.values().length;

    public int getSpeedValue() {
        return ordinal();
    }

    public Speed increaseSpeed() {
        int next = (ordinal() + 1) % COUNT;
        return values()[next];
    }
}

