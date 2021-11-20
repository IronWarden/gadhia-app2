/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */

import javafx.beans.property.SimpleStringProperty;

public class Item {
    private SimpleStringProperty serialNumber;
    private SimpleStringProperty Name;
    private SimpleStringProperty Value;

    public Item(String serialNumber, String Name, String Value){
        this.setSerialNumber(serialNumber);
        this.setName(Name);
        this.setValue(Value);

    }


    public String getSerialNumber() {
        return serialNumber.get();
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = new SimpleStringProperty(serialNumber);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String name) {
        this.Name = new SimpleStringProperty(name);
    }

    public String getValue() {
        return Value.get();
    }

    public void setValue(String value) {
       this.Value = new SimpleStringProperty(value);
    }


}
