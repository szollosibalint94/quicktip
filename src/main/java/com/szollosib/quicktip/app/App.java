package com.szollosib.quicktip.app;

import java.util.List;
import java.util.Scanner;

import com.szollosib.quicktip.domain.TipPanel;
import com.szollosib.quicktip.service.QuickTip;
import com.szollosib.quicktip.service.QuickTipFirstMethod;

public class App {
    public static Scanner in;
    public static String consoleInput = "something";

    public App() {
    }

    public static void main (String[] args) {
        in = new Scanner(System.in);
        System.out.println("Use a method ID to generate a quicktip (1,2,3). With writing e or q, you can exit the program.");
        while (!consoleInput.equals("e") || !consoleInput.equals("q"))
            readMethodIdFromConsole();
        // fix exit
    }

    public static void readMethodIdFromConsole()
    {
        consoleInput = in.nextLine();
        switch (consoleInput)
        {
            case "1":
            case "2":
            case "3":
                generateQuickTipExample(Integer.parseInt(consoleInput));
                System.out.println("Write your next command:");
                break;
            case "e":
            case "q":
                System.out.println("The program will now exit.");
                break;
            default:
                System.out.println("Wrong input. Please try again!");
                break;
        }
    }

    public static void generateQuickTipExample(int methodId)
    {
        QuickTip quickTip;
        switch(methodId)
        {
            default:
                quickTip = new QuickTipFirstMethod();
                break;
            /*case 2:
                quickTip = new QuickTipSecondMethod();
                break;*/
        }
        quickTip.importXmlValues();
        TipPanel firstPanel = quickTip.generateOutput(quickTip.numberSet(), quickTip.numOfRandValues(), quickTip.numOfPanels());
        System.out.println(firstPanel.toString());
    }
}
