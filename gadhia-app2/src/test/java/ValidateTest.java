/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {
    @Test
    void test_if_serial_number_is_valid(){
        Validate validate = new Validate();
        boolean match = validate.validateSerialNumber("A-XB1-24A-XY3");

        //since the serial number is valid we assert true if true
        assertTrue(match);

    }

    @Test
    void test_if_monetary_value_is_valid() {
        Validate validate = new Validate();
        boolean match = validate.validateValue("$10");
        assertTrue(match);
    }

    @Test
    void test_if_item_name_is_valid() {
        Validate validate = new Validate();
        // the method will return false
        boolean match = validate.validateName("R");

        // assert false because item names must be atleast two letters

        assertFalse(match);
    }


}