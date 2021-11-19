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
        this.setSerialNumber(new SimpleStringProperty(serialNumber));
        this.setName(new SimpleStringProperty(Name));
        this.setValue(new SimpleStringProperty(Value));

    }


    public String getSerialNumber() {
        return serialNumber.get();
    }

    public void setSerialNumber(SimpleStringProperty serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return Name.get();
    }

    public void setName(SimpleStringProperty name) {
        this.Name = name;
    }

    public String getValue() {
        return Value.get();
    }

    public void setValue(SimpleStringProperty value) {
       this.Value = value;
    }


}
