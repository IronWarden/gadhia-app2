/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// this class will deal with editing components of the item object and tableview such as sorting
public class Edit {

    public boolean editSerialNumber(ObservableList<Item> items, String serialNumber) {
        for(Item item : items) {
            if(item.getSerialNumber().equals(serialNumber))
                return true;
        }
        return false;
    }

    public void addEditedItemName(Item item, String name) {
        item.setName(name);
    }

    public void addEditedSerialNumber(Item item, String serialNumber) {
        item.setSerialNumber(serialNumber);
    }

    public void addEditedItemMonetaryValue(Item item, String value) {
        item.setValue(value);
    }



    public void sortListByName(ObservableList<Item> items) {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void sortListBySerialNumber(ObservableList<Item> items) {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getSerialNumber().compareTo(o2.getSerialNumber());
            }
        });
    }

    public void sortListByValue(ObservableList<Item> items) {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
    }


    public void deletingSingleItem(ObservableList<Item> items, Item removedItem) {
        items.remove(removedItem);
    }


}
