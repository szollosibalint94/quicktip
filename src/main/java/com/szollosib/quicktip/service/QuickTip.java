package com.szollosib.quicktip.service;

import com.szollosib.quicktip.domain.TipPanel;

public interface QuickTip{
     void importXmlValues();
     int numberSet();
     int numOfRandValues();
     int numOfPanels();
     TipPanel generateOutput(int numberSet, int numOfRandValues, int numOfPanels);
}
