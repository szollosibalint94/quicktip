package com.szollosib.quicktip.app;

import java.util.Scanner;

import com.szollosib.quicktip.domain.Method;
import com.szollosib.quicktip.service.QuickTipFirstMethod;
import com.szollosib.quicktip.service.QuickTipMethod;
import com.szollosib.quicktip.service.QuickTipSecondMethod;
import com.szollosib.quicktip.service.QuickTipThirdMethod;

public class ConsoleHandler {
    private static Scanner in;
    private static String commandInput = "something";
    private static int numOfTickets = 0;

    private static String FIRST_METHOD_FILE_PATH = "src/main/resources/quicktip1_params.xml";
    private static String SECOND_METHOD_FILE_PATH = "src/main/resources/quicktip2_params.xml";
    private static String THIRD_METHOD_FILE_PATH = "src/main/resources/quicktip3_params.xml";

    public static void LaunchConsoleApp() throws Exception  {
        in = new Scanner(System.in);
        System.out.println("Use a method ID to generate quicktips (1,2,3). With writing e or q, you can exit the program.");
        while (!commandInput.equals("e") || !commandInput.equals("q"))
            readMethodIdFromConsole();
    }

    public static void readMethodIdFromConsole() throws Exception {
        commandInput = in.nextLine();
        switch (commandInput)
        {
            case "1":
            case "2":
            case "3":
                System.out.println("How many tickets do you want to generate?");
                try {
                    numOfTickets = Integer.parseInt(in.nextLine());
                }
                catch (Exception e) {
                    System.out.println("Wrong input. Please try again!");
                }
                for (int i = 0; i < numOfTickets; i++)
                    generateQuickTipExample(Integer.parseInt(commandInput));
                System.out.println("Write your next command:");
                break;
            case "e":
            case "q":
                System.out.println("The program will now exit.");
                System.exit(0);
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
            case THIRD_METHOD:
                quickTip = new QuickTipThirdMethod(THIRD_METHOD_FILE_PATH);
                break;
            default:
                throw new Exception("Wrong method ID.");
        }
        quickTip.importXmlValues();
        System.out.println(quickTip.generateOutput(quickTip.numberSet(), quickTip.numOfRandValues(), quickTip.numOfPanels()).toString());
    }
}
