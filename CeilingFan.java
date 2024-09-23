package com.teacuptechsystems.challenge;

public class CeilingFan {
    private Direction direction;
    private Speed setting;

    public CeilingFan() {
        this.direction = Direction.FORWARD;
        this.setting = Speed.OFF;
    }

    public void pullDirectionCord() {
        direction = direction.changeDirection();
    }

    public void pullSpeedCord() {
        setting = setting.increaseSpeed();
    }

    public boolean isOn() {
        return Speed.OFF != setting;
    }

    public boolean isOff() {
        return Speed.OFF == setting;
    }

    public int getSpeed() {
        return setting.getSpeedValue();
    }

    public Direction getDirection() {
        return direction;
    }
}

