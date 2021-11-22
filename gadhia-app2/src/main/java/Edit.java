/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */


import javafx.collections.ObservableList;

import java.util.Comparator;


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
        items.sort(Comparator.comparing(Item::getName));
    }

    public void sortListBySerialNumber(ObservableList<Item> items) {
        items.sort(Comparator.comparing(Item::getSerialNumber));
    }

    public void sortListByValue(ObservableList<Item> items) {
        items.sort(Comparator.comparing(Item::getValue));
    }


    public void deletingSingleItem(ObservableList<Item> items, Item removedItem) {
        items.remove(removedItem);
    }


}
