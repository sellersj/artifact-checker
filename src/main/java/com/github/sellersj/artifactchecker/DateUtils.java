package com.github.sellersj.artifactchecker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * From https://stackoverflow.com/a/27323328
 *
 */
public class DateUtils {

    /** A logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

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
            LOGGER.debug(String.format("Could not parse date %s", string), e);
        }
        return date;
    }
}