/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

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
    @FXML
    TextField filteredField;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // sets up columns
        itemNumber.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        itemValue.setCellValueFactory(new PropertyValueFactory<>("Value"));

        // load data
        tableView.setItems(getItem());

        // update the table for editing
        tableView.setEditable(true);
        itemNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        itemName.setCellFactory(TextFieldTableCell.forTableColumn());
        itemValue.setCellFactory(TextFieldTableCell.forTableColumn());


        // Initalize FilteredList
        initializeFilteredList();

    }

    public void editName(TableColumn.CellEditEvent<Item, String> event) {
        Item item = tableView.getSelectionModel().getSelectedItem();
        Edit edit = new Edit();

        // first make sure the name is valid
        Validate validate = new Validate();
         boolean match = validate.validateName(event.getNewValue());
        // if the name is valid we set the name, if match is false we alert the user
        if(!match) {
            invalidNameAlert();
        }
        else
            edit.addEditedItemName(item, event.getNewValue());
    }

    public void editSerialNumber(TableColumn.CellEditEvent<Item, String> event) {
        Item item = tableView.getSelectionModel().getSelectedItem();
        Edit edit = new Edit();
        // check to see if they match
        boolean match = edit.editSerialNumber(items, event.getNewValue());

        // if they match we can alert the user
        if(match)
            duplicateAlert();
        // else  we can add it
        else
            edit.addEditedSerialNumber(item, event.getNewValue());
    }


    public void editMonetaryValue(TableColumn.CellEditEvent<Item, String> event) {
        Item item = tableView.getSelectionModel().getSelectedItem();
        Edit edit = new Edit();

        Validate validate = new Validate();
        boolean match = validate.validateValue(event.getNewValue());

        // if the pattern matches we add
        if(match) {
            edit.addEditedItemMonetaryValue(item, event.getNewValue());

        }
        // otherwise, alert the user
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



    // handle sorting
    public void sortListByName() {
        Edit edit = new Edit();
        edit.sortListByName(items);
    }

    public void sortListBySerialNumber() {
        Edit edit = new Edit();
        edit.sortListBySerialNumber(items);
    }

    public void sortListByValue() {
        Edit edit = new Edit();
        edit.sortListByValue(items);
    }



    public void onClear() {
        items.clear();
    }

    public void onDelete() {
        Edit edit = new Edit();
        edit.deletingSingleItem(items, tableView.getSelectionModel().getSelectedItem());
    }

    public void onSave() {
        FileChooser fileChooser = new FileChooser();
        Options options = new Options();
        // Adding File Name Filters
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TSV Files", "*.txt"),
                new FileChooser.ExtensionFilter("HTML Files", "*.html"));

        File saveFile = fileChooser.showSaveDialog(new Stage());
        if(saveFile != null) {
            if(saveFile.

        }
        options.saveFileTSV();
    }



    ObservableList<Item> items = FXCollections.observableArrayList();
    public ObservableList<Item> getItem() {

        items.add(new Item("0000", "Ronald", "$10"));

        return items;

    }



    public void initializeFilteredList() {
        // Wrap the ObservableList in a FilteredList display all data
        FilteredList<Item> filteredData = new FilteredList<>(items, b -> true);

        // set the filter Predicate whenever the filter changes
        filteredField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Item -> {
                // If the filter text is empty, display all persons
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (Item.getSerialNumber().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter match serial number
                }
                if(Item.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches item name
                }
                else
                    return false;
            });
        });

        // Wrap the Filtered List in a Sorted List
        SortedList<Item> sortedData = new SortedList<>(filteredData);

        // bind SortedList comparator to the TableView comparator
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());

        // Add sorted data to the table
        tableView.setItems(sortedData);
    }

    // functions for alerting the user
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
