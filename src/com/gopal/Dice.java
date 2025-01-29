package com.gopal;

import java.util.Random;

public class Dice {
    private final int maxValue;
    private final Random random;

    public Dice(int maxValue) {
        super();
        this.maxValue = maxValue;
        random = new Random();
    }

    public int generateRandom() {
        return this.random.nextInt(1, maxValue + 1);
    }

}