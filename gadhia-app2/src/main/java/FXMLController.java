/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class FXMLController implements Initializable {

    @FXML
    TableView<Item> tableView;
    @FXML
    TableColumn<Item,String> itemNumber;
    @FXML
    TableColumn<Item,String> itemName;
    @FXML
    TableColumn<Item,String> itemValue;

    @FXML
    TextField itemNumberTextField;
    @FXML
    TextField itemMonetaryValueTextField;
    @FXML
    TextField itemNameTextField;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // sets up columns
        itemNumber.setCellValueFactory(new PropertyValueFactory<Item, String>("serialNumber"));
        itemName.setCellValueFactory(new PropertyValueFactory<Item, String>("Name"));
        itemValue.setCellValueFactory(new PropertyValueFactory<Item, String>("Value"));

        // load data
        tableView.setItems(getItem());

        // update the table for editing
        tableView.setEditable(true);
        itemNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        itemName.setCellFactory(TextFieldTableCell.forTableColumn());
        itemValue.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    public void editName(TableColumn.CellEditEvent event) {
        Item item = tableView.getSelectionModel().getSelectedItem();
        String name = event.getNewValue().toString();
        if(name.length() < 2 || name.length() > 256) {
            invalidNameAlert();
        }
        else
            item.setName(event.getNewValue().toString());
    }

    public void editSerialNumber(TableColumn.CellEditEvent event) {
        Item item = tableView.getSelectionModel().getSelectedItem();

       // iterate through the list of items and if they match we throw an error, else we add it
        for(Item item1 : items) {
            if(item1.getSerialNumber().equals(event.getNewValue().toString())) {
                duplicateAlert();
            }
            else
                item.setSerialNumber(event.getNewValue().toString());
        }
    }

    public void editMonetaryValue(TableColumn.CellEditEvent event) {
        Item item = tableView.getSelectionModel().getSelectedItem();


        String regex = "^[$]+\\d+";
        // if the pattern matches we add
        if(Pattern.matches(regex, event.getNewValue().toString())) {
            item.setValue(event.getNewValue().toString());
        }

        else
            invalidValueAlert();
    }

    public void validateSerialNumber() {
        Validate validate = new Validate();
        boolean match = validate.validateSerialNumber(itemNumberTextField.getText());

        if(!match) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Number");
            alert.setContentText("Please check your serial number");
            alert.showAndWait();
        }
    }

    public void validateName() {
        Validate validate = new Validate();
        boolean match = validate.validateName(itemNameTextField.getText());
        // if match is true it is valid, else it is false
        // if not true we alert the user
        if(!match) {
            invalidNameAlert();
        }
    }

    public void validateValue() {
        Validate validate = new Validate();
        boolean match = validate.validateValue(itemMonetaryValueTextField.getText());
        // if they don't match we alert the user
        if(!match) {
            invalidValueAlert();
        }

    }

    // adding an item to the list
    public void onButtonPush() {

        Item item = new Item(itemNumberTextField.getText(), itemNameTextField.getText(),
                itemMonetaryValueTextField.getText());

        items.add(item);
    }


    public void onClear() {
        items.clear();
    }

    public void onDelete() {
        items.remove(tableView.getSelectionModel().getSelectedItem());
    }

    // adding an item to the list
    ObservableList<Item> items = FXCollections.observableArrayList();
    public ObservableList<Item> getItem() {

        items.add(new Item("0000", "Ronald", "$10"));

        return items;

    }

    // helper functions
    public void duplicateAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Duplicate Serial Number");
        alert.setContentText("You have duplicate serial number");
        alert.showAndWait();
    }

    public void invalidValueAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Monetary Value");
        alert.setContentText("Please check your value");
        alert.showAndWait();
    }

    public void invalidNameAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Name");
        alert.setContentText("Please check your name");
        alert.showAndWait();

    }


}
