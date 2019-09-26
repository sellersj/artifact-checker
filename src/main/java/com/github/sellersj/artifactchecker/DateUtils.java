package com.github.sellersj.artifactchecker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * From https://stackoverflow.com/a/27323328
 *
 */
public class DateUtils {

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * @param string to parse
     * @param formatter the formatter to use
     * @return the date if we have it
     */
    public static Date parseToDate(String string, DateTimeFormatter formatter) {
        Date date = null;
        try {
            LocalDateTime dateTime = LocalDateTime.parse(string, formatter);
            date = asDate(dateTime);
        } catch (Exception e) {
            // don't log anything
        }
        return date;
    }
}