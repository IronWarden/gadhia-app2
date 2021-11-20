import java.util.regex.Pattern;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Rishi Gadhia
 */
public class Validate {

    public boolean validateSerialNumber(String serialNumber) {
        String regexPattern = "^[A]+-\\w{3}-\\w{3}-\\w{3}";
        return Pattern.matches(regexPattern, serialNumber );
    }

    public boolean validateName(String name ) {
        if(name.length() < 2 || name.length() > 256) {
            return true;
        }
        else
            return false;
    }

    public boolean validateValue(String value) {
        String regexPattern = "^[$]+\\d+";
        return Pattern.matches(regexPattern, value);
    }


}
