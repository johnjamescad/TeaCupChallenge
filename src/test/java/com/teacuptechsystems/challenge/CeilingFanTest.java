package com.teacuptechsystems.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CeilingFanTest {
    private CeilingFan fan;

    private static final int[] EXPECTED_SPEED = {
        0, 1, 2, 3, 0, 1, 2, 3, 0, 1
    };

    private static final Direction[] EXPECTED_DIRECTION = {
        Direction.FORWARD,
        Direction.REVERSE,
        Direction.FORWARD,
        Direction.REVERSE,
        Direction.FORWARD,
        Direction.REVERSE,
        Direction.FORWARD,
        Direction.REVERSE,
        Direction.FORWARD,
        Direction.REVERSE
    };

    private static final boolean[] EXPECTED_ON_STATE = {
        false, true, true, true, false, true, true, true, false, true
    };

    @Before
    public void init() {
        fan = new CeilingFan();
    }

    @Test
    public void increaseSpeedInForwardDirection() {
        int limit = EXPECTED_SPEED.length - 1;
        for (int i = 0; i < limit; ++i) {
            Assert.assertEquals(getMessage(i), EXPECTED_SPEED[i], fan.getSpeed());
            Assert.assertEquals(getMessage(i), EXPECTED_ON_STATE[i], fan.isOn());
            Assert.assertEquals(Direction.FORWARD, fan.getDirection());
            fan.pullSpeedCord();
        }
        Assert.assertEquals(Direction.FORWARD, fan.getDirection());
    }

    @Test
    public void increaseSpeedInReverseDirection() {
        Assert.assertEquals(Direction.FORWARD, fan.getDirection());
        fan.pullDirectionCord();
        int limit = EXPECTED_SPEED.length - 1;
        for (int i = 0; i < limit; ++i) {
            Assert.assertEquals(getMessage(i), EXPECTED_SPEED[i], fan.getSpeed());
            Assert.assertEquals(getMessage(i), EXPECTED_ON_STATE[i], fan.isOn());
            Assert.assertEquals(Direction.REVERSE, fan.getDirection());
            fan.pullSpeedCord();
        }
        Assert.assertEquals(Direction.REVERSE, fan.getDirection());
    }

    @Test
    public void increaseSpeedWithDirectionChange() {
        int limit = EXPECTED_SPEED.length - 1;
        for (int i = 0; i < limit; ++i) {
            Assert.assertEquals(getMessage(i), EXPECTED_SPEED[i], fan.getSpeed());
            Assert.assertEquals(getMessage(i), EXPECTED_ON_STATE[i], fan.isOn());
            Assert.assertEquals(getMessage(i), EXPECTED_DIRECTION[i], fan.getDirection());
            fan.pullSpeedCord();
            fan.pullDirectionCord();
        }
    }

    private String getMessage(int i) {
        return "Failed after " + i + " pulls.";
    }
}

