package com.szollosib.quicktip.service;

import java.util.Random;

public class RandNum {
    public int generateRandomNumber(int maxInterval)
    {
        Random rand = new Random();
        return rand.nextInt(maxInterval + 1);
    }
}
