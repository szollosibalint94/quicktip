package com.szollosib.quicktip.domain;

import java.util.ArrayList;
import java.util.List;

public class TipTicket extends TipPanel {
    private List<TipPanel> lotteryPanels = new ArrayList<>();

    public void addLotteryPanel(TipPanel tipPanel) {
        lotteryPanels.add(tipPanel);
    }

    @Override
    public String toString() {
        return String.format(lotteryPanels.toString());
    }
}
