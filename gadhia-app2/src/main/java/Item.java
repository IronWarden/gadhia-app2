/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */

import javafx.beans.property.SimpleStringProperty;

public class Item {
    private String serialNumber;
    private String name;
    private String value;

    // creates an item object
    public Item(String serialNumber, String name, String value){
        this.setSerialNumber(serialNumber);
        this.setName(name);
        this.setValue(value);

    }


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
       this.value = value;
    }


}
