package com.szollosib.quicktip.service;

import java.util.ArrayList;
import java.util.List;

import com.szollosib.quicktip.domain.TipPanel;
import com.szollosib.quicktip.domain.TipTicket;

public class QuickTipSecondMethod extends QuickTipMethod {

    public QuickTipSecondMethod(String filepath) {
        super(filepath);
    }

    @Override
    public int numberSet() {
        return 90;
    }

    @Override public int numOfRandValues() {
        return xmlValues.get(0);
    }

    @Override public int numOfPanels() {
        return xmlValues.get(1);
    }

    @Override public TipTicket generateOutput(int numberSet, int numOfRandValues, int numOfPanels) {
        List<Integer> randomNumbers;
        TipTicket tipTicket = new TipTicket();
        for (int i = 0; i < numOfPanels; i++) {
            randomNumbers = new ArrayList<>();
            for (int j = 0; j < numOfRandValues; j++) {
                randomNumbers.add(randNum.generateRandomNumber(numberSet));
            }
            tipTicket.addLotteryPanel(new TipPanel(randomNumbers));
        }
        return tipTicket;
    }
}
