package com.szollosib.quicktip.service;

import java.util.Random;

public class RandNum {
    public int GenerateRandomNumber(int MaxInterval)
    {
        Random rand = new Random();
        return rand.nextInt(MaxInterval + 1);
    }
}
