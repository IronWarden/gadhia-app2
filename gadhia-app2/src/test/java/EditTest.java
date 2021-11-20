/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditTest {
    @Test
    void test_if_single_item_can_be_deleted() {
        Edit edit = new Edit();
        ObservableList<Item> items = FXCollections.observableArrayList();
        items.add(new Item("0", "john", "$10"));
        Item item1 = new Item("0", "john", "$10");
        edit.deletingSingleItem(items, item1);

        // assert false since the item is deleted
        assertFalse(items.contains(item1));
    }

    @Test
    void test_if_item_name_can_be_edited() {
        Edit edit = new Edit();
        Item item = new Item("0000", "Xbox", "$400");
        String name = "PS5";
        edit.addEditedItemName(item, name);
        assertEquals(name, item.getName());
    }

    @Test
    void test_if_serial_number_can_be_edited() {
        Edit edit = new Edit();
        Item item = new Item("1111", "d", "12");
        String serialNumber = "777";
        edit.addEditedSerialNumber(item, serialNumber);
        assertEquals(serialNumber, item.getSerialNumber());

    }

    @Test
    void test_if_monetary_value_can_be_edited() {
        Edit edit = new Edit();
        Item item = new Item("234", "dd", "124");
        String value = "$44";
        edit.addEditedItemMonetaryValue(item, value);
        assertEquals(value, item.getValue());
    }

    @Test
    void test_if_list_is_sorted_by_name() {
        Edit edit = new Edit();
        ObservableList<Item> items = FXCollections.observableArrayList();
        items.add(new Item("1", "d", "1"));
        items.add(new Item("1", "cddd", "1"));
        Item item3 = new Item("1", "e", "1");
        Item item4 = new Item("1", "e", "1");
        items.add(item3);
        items.add(item4);

        // the first index will have to be cddd because it starts with c
        edit.sortListByName(items);
        assertEquals("cddd", items.get(0).getName());

    }

    @Test
    void test_if_list_is_sorted_by_serial_number() {
        Edit edit = new Edit();
        ObservableList<Item> items = FXCollections.observableArrayList();
        items.add(new Item("Z", "d", "1"));
        items.add(new Item("A", "d", "1"));


        edit.sortListBySerialNumber(items);
        assertEquals("A", items.get(0).getSerialNumber());
    }

    @Test
    void test_if_is_sorted_by_value() {
        Edit edit = new Edit();
        ObservableList<Item> items = FXCollections.observableArrayList();
        items.add(new Item("d", "d", "$50"));
        items.add(new Item("d", "d", "$10"));

        edit.sortListByValue(items);
        // sorted from least to greatest
        assertEquals("$10", items.get(0).getValue());
    }



}