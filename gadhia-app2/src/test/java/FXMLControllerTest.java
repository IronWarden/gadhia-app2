/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FXMLControllerTest {
    @Test
    void test_if_list_is_cleared() {
        FXMLController fxmlController = new FXMLController();
        fxmlController.items.add(new Item("0000000", "Edward", "$10"));
        fxmlController.onClear();

        assertFalse(fxmlController.items.contains(new Item("0000000", "Edward", "$10")));
    }


}