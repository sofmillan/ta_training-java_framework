package com.epam.training.sofia_millan.framework.task1.utils;


import java.text.NumberFormat;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class providing functions for string manipulation and conversion.
 * @author Sofía Millán
 */
public class Utils {

    /**
     * Returns the current time as a string formatted as {@code yyyy-MM-dd_HH-mm-ss}.
     * @return the current time formatted as a string.
     */
    public static String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
