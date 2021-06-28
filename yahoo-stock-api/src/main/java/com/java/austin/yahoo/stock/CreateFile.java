package com.java.austin.yahoo.stock;

import com.litesoftwares.coingecko.CoinGeckoApiClient;
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class CreateFile {

    public static CoinGeckoApiClient client = new CoinGeckoApiClientImpl();

    public static void createFile() {
        try {
            File myObj = new File("coinlist.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        try {
            FileWriter Writer = new FileWriter("coinlist.txt");
            Writer.write(String.valueOf(client.getCoinList()));

        } catch (IOException e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }


    }
}