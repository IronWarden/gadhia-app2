/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void test_if_item_object_is_created() {
        Item item = new Item("S-40A-ZBD-E47", "Ron", "$10");

        // an inventory item has a serial number
        assertEquals("S-40A-ZBD-E47", item.getSerialNumber());
        // an inventory item has a name
        assertEquals("Ron", item.getName());
        // an inventory item has monetary value
        assertEquals("$10", item.getValue());

    }
}