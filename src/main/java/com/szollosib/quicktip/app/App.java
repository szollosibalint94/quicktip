package com.szollosib.quicktip.app;

import java.util.Scanner;

import com.szollosib.quicktip.domain.Method;
import com.szollosib.quicktip.domain.TipPanel;
import com.szollosib.quicktip.service.QuickTipFirstMethod;
import com.szollosib.quicktip.service.QuickTipMethod;
import com.szollosib.quicktip.service.QuickTipSecondMethod;

public class App {
    public static Scanner in;
    public static String consoleInput = "something";

    private static String FIRST_METHOD_FILE_PATH = "src/main/resources/quicktip1_params.xml";
    private static String SECOND_METHOD_FILE_PATH = "src/main/resources/quicktip2_params.xml";
    public App() {
    }

    public static void main (String[] args) throws Exception {
        in = new Scanner(System.in);
        System.out.println("Use a method ID to generate a quicktip (1,2,3). With writing e or q, you can exit the program.");
        while (!consoleInput.equals("e") || !consoleInput.equals("q"))
            readMethodIdFromConsole();
        // fix exit
    }

    public static void readMethodIdFromConsole() throws Exception {
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

    public static void generateQuickTipExample(int methodId) throws Exception {
        QuickTipMethod quickTip;
        Method method = Method.getByValue(methodId);

        switch(method) {
            case FIRST_METHOD:
                quickTip = new QuickTipFirstMethod(FIRST_METHOD_FILE_PATH);
                break;
            case SECOND_METHOD:
                quickTip = new QuickTipSecondMethod(SECOND_METHOD_FILE_PATH);
                break;
            default:
                throw new Exception("ASD");
        }

        quickTip.importXmlValues();
        TipPanel firstPanel = quickTip.generateOutput(quickTip.numberSet(), quickTip.numOfRandValues(), quickTip.numOfPanels());
        System.out.println(firstPanel.toString());
    }
}
