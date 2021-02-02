package com.szollosib.quicktip.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadFromXML {

    public List<Integer> getValueFromXml(String filePath) {
        List<Integer> xmlValues = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = createHandler(xmlValues);
            saxParser.parse(filePath, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlValues;
    }

    private DefaultHandler createHandler(List<Integer> xmlValues) {
        return new DefaultHandler() {

            boolean bMaxRandValue = false;
            boolean bRandNumCount = false;
            boolean bNumOfPanels = false;

            public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {

                if (qName.equalsIgnoreCase("MAXRANDOMVALUE")) {
                    bMaxRandValue = true;
                }

                if (qName.equalsIgnoreCase("RANDOMNUMBERCOUNT")) {
                    bRandNumCount = true;
                }

                if (qName.equalsIgnoreCase("NUMOFPANELS")) {
                    bNumOfPanels = true;
                }
            }

            public void characters(char ch[], int start, int length) throws SAXException {

                if (bMaxRandValue) {
                    xmlValues.add(Integer.parseInt(new String(ch, start, length)));
                    bMaxRandValue = false;
                }

                if (bRandNumCount) {
                    xmlValues.add(Integer.parseInt(new String(ch, start, length)));
                    bRandNumCount = false;
                }

                if (bNumOfPanels) {
                    xmlValues.add(Integer.parseInt(new String(ch, start, length)));
                    bNumOfPanels = false;
                }
            }
        };
    }
}
