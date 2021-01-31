package com.szollosib.quicktip.app;

import com.szollosib.quicktip.service.XMLReader;

public class App {
    public App() {
    }

    public static void main (String[] args) {
        XMLReader xmlReader = new XMLReader();
        xmlReader.getValueFromXml(1);
    }
}
