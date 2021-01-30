package com.szollosib.quicktip.service;

import java.util.List;

public interface QuickTip {
    public int numberSet();
    public int numOfRandValues();
    public <T> List<T> generateOutput(int numberSet, int numOfRandValues);
}
