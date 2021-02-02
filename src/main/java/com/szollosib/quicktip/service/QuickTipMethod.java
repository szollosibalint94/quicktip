package com.szollosib.quicktip.service;

import java.util.List;

public abstract class QuickTipMethod implements QuickTip {
    protected RandNum randNum = new RandNum();
    protected List<Integer> xmlValues;
    private String filepath;

    public QuickTipMethod(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void importXmlValues() {
        ReadFromXML xmlReader = new ReadFromXML();
        xmlValues = xmlReader.getValueFromXml(this.filepath);
    }
}
