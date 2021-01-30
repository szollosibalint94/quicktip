package com.szollosib.quicktip.domain;

import java.util.List;

public class TipTicket {
    public TipTicket(List<TipPanel> lotteryPanels) {
        this.lotteryPanels = lotteryPanels;
    }

    private List<TipPanel> lotteryPanels;

    public List<TipPanel> getLotteryPanels() {
        return lotteryPanels;
    }

    public void setLotteryPanels(List<TipPanel> lotteryPanels) {
        this.lotteryPanels = lotteryPanels;
    }

    @Override
    public String toString() { return String.format(lotteryPanels.toString());}
}
