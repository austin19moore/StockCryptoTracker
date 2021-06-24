package com.java.austin.yahoo.stock;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import static com.java.austin.yahoo.stock.CryptoTracker.CryptoMenu;

public class StockTracker
{

    public static int menu(String chosenStock) throws IOException {
    Scanner scnr = new Scanner(System.in);
    int userInput;
    int returnVal = -1;
    System.out.println();

    System.out.println("MAIN MENU: ");
    System.out.println("Please select an option");
    System.out.println("1: Print current price");
    System.out.println("2: Print Summary");
    System.out.println("3: Compare");
    System.out.println("4: Switch to Cryptocurrency");
    System.out.println("0: Quit");
    System.out.println();

    userInput = scnr.nextInt();
    System.out.println();


    switch (userInput) {

        case 0:
            returnVal = 0;
            break;

        case 1:
            printStock(chosenStock);
            returnVal = 1;
            break;

        case 2:
            printSummary(chosenStock);
            returnVal = 2;
            break;

        case 3:
            compareStocks(chosenStock);
            returnVal = 3;
            break;

        case 4:
            System.out.println("Switching to Cryptocurrency...");

            returnVal = 4;
            break;

        default:
            returnVal = -1;
            break;
    }
    System.out.println();
        return returnVal;
    }

    public static Stock getStock(String stockName) throws IOException {
        return YahooFinance.get(stockName);
    }

    public static void printStock(String userStock) throws IOException {
        System.out.println(StockTracker.getStock(userStock));

    }

    public static void printSummary(String chosenStock) throws IOException {

        Stock Stock = YahooFinance.get(chosenStock);

        BigDecimal price = Stock.getQuote().getPrice();
        BigDecimal change = Stock.getQuote().getChangeInPercent();
        BigDecimal peg = Stock.getStats().getPeg();
        BigDecimal dividend = Stock.getDividend().getAnnualYieldPercent();

        Stock.print();

    }

    public static void compareStocks(String chosenStock) throws IOException {
        Scanner scnr = new Scanner(System.in);
        String userInput;
        System.out.print("Please enter a stock ticker to compare with: ");
        System.out.println();

        userInput = scnr.next();

        Stock firstStock = YahooFinance.get(chosenStock);
        Stock secondStock = YahooFinance.get(userInput);



    }

    public static void main( String[] args ) throws IOException {
    Scanner scnr = new Scanner(System.in);
    String chosenStock;
    int menuOption = 1;
    System.out.print("Please enter a stock ticker: ");
    chosenStock = scnr.next();
    System.out.println();


    while (menuOption != 0) {

        if (menuOption == 9) {
            menuOption = CryptoMenu();
        } else {

        menuOption = menu(chosenStock);

        if (menuOption == -1) {
            System.out.println("Please enter a valid option!");
            System.out.println();

        }
        }
    }

    System.out.println("Thank you for using the stock tracker!");

    }
}
