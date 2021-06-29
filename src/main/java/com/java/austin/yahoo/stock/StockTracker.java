package com.java.austin.yahoo.stock;

import java.util.Scanner;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import java.io.IOException;
import java.math.BigDecimal;
import static com.java.austin.yahoo.stock.CryptoTracker.CryptoMenu;


public class StockTracker
{
    public static String stockTicker;
    public static boolean firstExecute = true;

    public static int menu() throws IOException {
    Scanner scnr = new Scanner(System.in);
    int userInput;
    int returnVal = -1;

        Stock SPY = YahooFinance.get("SPY");
        BigDecimal SPYPrice = SPY.getQuote().getPrice();

        Stock NASDAQ = YahooFinance.get("NDAQ");
        BigDecimal NASDAQPrice = NASDAQ.getQuote().getPrice();


        if (firstExecute == true) {
            System.out.println("Stock market at a glance: (USD)");
            System.out.println("S&P 500: " + SPYPrice + ", NASDAQ: " + NASDAQPrice);
            System.out.println();

            System.out.println("Please chose a stock ticker: (ex. AMD, SPY)");
            System.out.print("Selection: ");
            stockTicker = scnr.next();
            firstExecute = false;
            System.out.println();
        }

    System.out.println("MAIN MENU: ");
    System.out.println("Please select an option");
    System.out.println("1: Print current price");
    System.out.println("2: Print Summary");
    System.out.println("3: Switch to Cryptocurrency");
    System.out.println("4: Change ticker");
    System.out.println("0: Quit");
    System.out.print("Selection: ");
    userInput = scnr.nextInt();
    System.out.println();


    switch (userInput) {

        case 0:
            returnVal = 0;
            break;

        case 1:
            printStock(stockTicker);
            returnVal = 2;
            break;

        case 2:
            printSummary(stockTicker);
            returnVal = 2;
            break;

        case 3:
            System.out.println("Switching to Cryptocurrency...");
            returnVal = 1;
            break;

        case 4:
            System.out.println("Please choose the new ticker: ");
            stockTicker = scnr.next();
            returnVal = 2;
            break;

        default:
            break;
    }
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


    public static void main( String[] args ) throws IOException {
        Scanner scnr = new Scanner(System.in);
        int userVal = 0;


        while ((userVal != 1) && (userVal != 2)){
            System.out.println("Choose between cryptocurrency and stock markets: ");
            System.out.println("Cryptocurrency: 1: ");
            System.out.println("Stock Market: 2: ");
            System.out.print("Selection: ");
            userVal = scnr.nextInt();

            if (userVal == 1) {
                userVal = CryptoMenu();
            } else if (userVal == 2) {
                userVal = menu();
            } else {
                System.out.println("Please choose a valid option...");
                System.out.println();
            }
        }

        while (userVal != 0) {

            if (userVal == 1) {
                userVal = CryptoMenu();
            } else if (userVal == 2) {
                userVal = menu();
            } else {
                System.out.println("Menu return value invalid");
                break;
            }

        }

        System.out.println("Thank you for using the Stock Crypto Tracker!");

    }
}
