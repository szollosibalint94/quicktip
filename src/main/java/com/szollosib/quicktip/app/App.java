package com.szollosib.quicktip.app;

import java.util.List;

import com.szollosib.quicktip.domain.TipPanel;
import com.szollosib.quicktip.service.QuickTipFirstMethod;
import com.szollosib.quicktip.service.ReadFromXML;

public class App {
    public App() {
    }

    public static void main (String[] args) {
        /*ReadFromXML readFromXml = new ReadFromXML();
        List<Integer> xmlValues =  readFromXml.getValueFromXml(1);
        for(int i = 0; i < xmlValues.size(); i++) {
            System.out.println(xmlValues.get(i));
        }*/
        QuickTipFirstMethod quicktip = new QuickTipFirstMethod();
        quicktip.importXmlValues();
        TipPanel firstPanel = quicktip.generateOutput(quicktip.numberSet(), quicktip.numOfRandValues(), quicktip.numOfPanels());
        System.out.println(firstPanel.toString());
    }
}
