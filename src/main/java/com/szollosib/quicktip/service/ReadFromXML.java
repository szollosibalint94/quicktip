package com.szollosib.quicktip.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadFromXML {
    public String getFilePath()
    {
        File file = new File("src/main/resources/quicktip1_params.xml");
        return file.getAbsolutePath();
    }

    public List<Integer> getValueFromXml(int methodId)
    {
        List<Integer> xmlValues = new ArrayList<>();
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bMaxRandValue = false;
                boolean bRandNumCount = false;
                boolean bNumOfPanels = false;

                public void startElement(String uri, String localName,String qName,
                    Attributes attributes) throws SAXException {
                    //System.out.println("Start Element :" + qName);

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

                public void endElement(String uri, String localName,
                    String qName) throws SAXException {

                    //System.out.println("End Element :" + qName);

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bMaxRandValue) {
                        //System.out.println("Max Random value : " + new String(ch, start, length));
                        xmlValues.add(Integer.parseInt(new String(ch, start, length)));
                        bMaxRandValue = false;
                    }

                    if (bRandNumCount) {
                        //System.out.println("Random number count : " + new String(ch, start, length));
                        xmlValues.add(Integer.parseInt(new String(ch, start, length)));
                        bRandNumCount = false;
                    }

                    if (bNumOfPanels) {
                        //System.out.println("Number of panels : " + new String(ch, start, length));
                        xmlValues.add(Integer.parseInt(new String(ch, start, length)));
                        bNumOfPanels = false;
                    }
                }
            };
            saxParser.parse(getFilePath(), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlValues;
    }



}
