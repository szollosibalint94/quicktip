package com.szollosib.quicktip.service;

import java.util.ArrayList;
import java.util.List;

import com.szollosib.quicktip.domain.TipPanel;

public class QuickTipFirstMethod extends QuickTipMethod {

    public QuickTipFirstMethod(String filepath) {
        super(filepath);
    }

    @Override
    public int numberSet() {
        return randNum.generateRandomNumber(xmlValues.get(0));
    }

    @Override public int numOfRandValues() {
        return xmlValues.get(1);
    }

    @Override public int numOfPanels() {
        return 1;
    }

    @Override public TipPanel generateOutput(int numberSet, int numOfRandValues, int numOfPanels) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < numOfRandValues; i++) {
            randomNumbers.add(randNum.generateRandomNumber(numberSet));
        }
        return new TipPanel(randomNumbers);
    }
}
