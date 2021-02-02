package com.szollosib.quicktip.domain;

import java.util.List;

public class TipPanel {
    private List<Integer> lotteryNumbers;

    public TipPanel() {}

    public TipPanel(List<Integer> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public void setLotteryNumbers(List<Integer> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    @Override
    public String toString() {
        return String.format(lotteryNumbers.toString());
    }
}
