/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */

// class deals with options such as saving and loading

import javafx.collections.ObservableList;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class Options {

    // saving the file as a TSV
    public void saveFileTSV(File saveFile, ObservableList<Item> items) {
        try{
            PrintWriter writer = new PrintWriter(saveFile);

            // heading
            writer.println("\tSerial Number" + "\tName" + "\tValue");
            int i = 0;
            // write as a file
            while(items.size() > i) {
                String itemName = items.get(i).getName();
                String itemNumber = items.get(i).getSerialNumber();
                String itemValue = items.get(i).getValue();


                writer.println("\t" + itemNumber + "\t" + itemName + "\t" + itemValue);
                i++;

            }
            writer.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFileHTML(File saveFile, ObservableList<Item> items) {
        try{
            PrintWriter writer = new PrintWriter(saveFile);
            writer.format("<!DOCTYPE html>%n<html lang=\"en\">%n<head>%n");
            writer.format("<meta author=>%n");
            writer.format("<title> </title>%n");

            writer.format("Serial Number  Name   Value%n<div></div></head>%n");
            writer.format("<body>%n");
            String s1 = null;

            int i = 0;
            // write as a file
            while(items.size() > i) {
                String itemName = items.get(i).getName();
                String itemNumber = items.get(i).getSerialNumber();
                String itemValue = items.get(i).getValue();

                s1 = itemNumber + " " + itemName + " " + itemValue;

                i++;

            }
            assert s1 != null;
            writer.format(s1);
            writer.format("%n</body>%n</html>");
            writer.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
