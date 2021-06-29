package com.java.austin.yahoo.stock;

import com.litesoftwares.coingecko.CoinGeckoApiClient;
import com.litesoftwares.coingecko.constant.Currency;
import com.litesoftwares.coingecko.domain.Coins.CoinFullData;
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CryptoTracker {

    public static String CryptoTicker;
    public static boolean firstExecute = true;
    public static CoinGeckoApiClient client = new CoinGeckoApiClientImpl();

    public static int CryptoMenu() {
        Scanner scnr = new Scanner(System.in);
        int userInput;
        int returnVal = -1;

        Map<String, Map<String, Double>> Bitcoin = client.getPrice("bitcoin",Currency.USD);
        double BitcoinPrice = Bitcoin.get("bitcoin").get(Currency.USD);

        Map<String, Map<String, Double>> Ethereum = client.getPrice("ethereum",Currency.USD);
        double EthereumPrice = Ethereum.get("ethereum").get(Currency.USD);


        if (firstExecute == true) {
            System.out.println("Crypto market at a glance (USD): ");
            System.out.println("Bitcoin: " + BitcoinPrice + ", Ethereum: " + EthereumPrice);
            System.out.println();
            System.out.println("Please chose a cryptocurrency: ");
            System.out.print("Selection: ");
            CryptoTicker = scnr.next();
            CryptoTicker = CryptoTicker.toLowerCase();
            firstExecute = false;
            System.out.println();
        }

        System.out.println("MAIN MENU: ");
        System.out.println("Please select an option");
        System.out.println("1: Print current price");
        System.out.println("2: Print Summary");
        System.out.println("3: Switch to Stock Market");
        System.out.println("4: Change crypto ticker");
        System.out.println("0: Quit");
        System.out.print("Selection: ");
        userInput = scnr.nextInt();
        System.out.println();

        switch (userInput) {

            case 0:
                returnVal = 0;
                break;

            case 1:
                printPrice(CryptoTicker);
                returnVal = 1;
                break;

            case 2:
                printSummary();
                returnVal = 1;
                break;

            case 3:
                System.out.println("Switching to Stock Market...");
                returnVal = 2;
                break;

            case 4:
                System.out.println("Please chose a cryptocurrency: ");
                CryptoTicker = scnr.next();
                CryptoTicker = CryptoTicker.toLowerCase();
                returnVal = 1;
                break;

            default:
                break;
        }

    return returnVal;
    }

    public static void printPrice(String Ticker) {

        Map<String, Map<String, Double>> coin = client.getPrice(CryptoTicker, Currency.USD);
        double coinPrice = coin.get(CryptoTicker).get(Currency.USD);
        System.out.println(CryptoTicker + " price: " + coinPrice);

    }

    public static void printSummary() {

        List<List<String>> coinVolume = client.getExchangesVolumeChart(CryptoTicker, 1);
        System.out.println(coinVolume);

    }

    public static void compareCrypto() {

        Scanner scnr = new Scanner(System.in);
        System.out.print("Choose a ticker to compare " + CryptoTicker + " with: ");
        String compareTicker = scnr.next();



    }


}
