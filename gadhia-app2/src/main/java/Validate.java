/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */
import java.util.regex.Pattern;


public class Validate {

    // validates the serial number by returning a boolean
    public boolean validateSerialNumber(String serialNumber) {
        String regexPattern = "^[a-zA-z]+-\\w{3}-\\w{3}-\\w{3}";
        return Pattern.matches(regexPattern, serialNumber );
    }
    // validates name by returning a boolean
    public boolean validateName(String name ) {
        return name.length() >= 2 && name.length() <= 256;
    }
    // validates the monetary value by returning a boolean
    public boolean validateValue(String value) {
        String regexPattern = "^[$]+\\d+";
        return Pattern.matches(regexPattern, value);
    }


}
