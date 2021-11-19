/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // sets up columns
        itemNumber.setCellValueFactory(new PropertyValueFactory<Item, String>("serialNumber"));
        itemName.setCellValueFactory(new PropertyValueFactory<Item, String>("Name"));
        itemValue.setCellValueFactory(new PropertyValueFactory<Item, String>("Value"));

        // load data
        tableView.setItems(getItem());


    }




    public ObservableList<Item> getItem() {
        ObservableList<Item> items = FXCollections.observableArrayList();
        items.add(new Item("0000", "Ronald", "$10"));

        return items;

    }

    @FXML
    private void editValue() {

    }

    private void addItem() {
       // Item item = new Item()
    }











}
