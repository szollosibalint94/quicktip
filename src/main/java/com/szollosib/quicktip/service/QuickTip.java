package com.szollosib.quicktip.service;

import java.util.List;

import com.szollosib.quicktip.domain.TipPanel;

public interface QuickTip<T> {
    public void importXmlValues();
    public int numberSet();
    public int numOfRandValues();
    public int numOfPanels();
    public TipPanel generateOutput(int numberSet, int numOfRandValues, int numOfPanels);
}
