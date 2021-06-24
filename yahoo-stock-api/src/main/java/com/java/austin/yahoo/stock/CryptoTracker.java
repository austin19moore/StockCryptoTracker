package com.java.austin.yahoo.stock;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class CryptoTracker {

    public static int CryptoMenu() {
        Scanner scnr = new Scanner(System.in);
        int userInput;
        int returnVal = -1;
        System.out.println();

        System.out.println("MAIN MENU: ");
        System.out.println("Please select an option");
        System.out.println("1: Print current price");
        System.out.println("2: Print Summary");
        System.out.println("3: Compare");
        System.out.println("4: Switch to Stock Market");
        System.out.println("0: Quit");
        System.out.println();

        userInput = scnr.nextInt();
        System.out.println();

        switch (userInput) {

            case 0:
                returnVal = 0;
                break;

            case 1:

                returnVal = 1;
                break;

            case 2:

                returnVal = 2;
                break;

            case 3:

                returnVal = 3;
                break;

            case 4:
                System.out.println("Switching to Stock Market...");

                returnVal = 4;
                break;

            default:
                returnVal = -1;
                break;
        }
        System.out.println();


        if (returnVal == 4) {
            returnVal = 9;
        }

    return returnVal;
    }
}
