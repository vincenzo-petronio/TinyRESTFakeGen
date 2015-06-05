package it.localhost.app.web.tinyrestfakegen;

import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 
 */
public class DateUtils {
    
    public static LocalDate getRandomDate() throws DAOException {
        long start = Timestamp.valueOf("1980-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2015-01-01 00:15:00").getTime();
        long diff = end - start + 1;
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant instant = Instant.ofEpochSecond(start + (long)(Math.random() * diff));
        LocalDateTime randomDate = LocalDateTime.ofInstant(instant, ZoneId.of("UTC-06:00")); 
        String r = randomDate.format(format);
        LocalDate date = null;
        try {
//            System.out.println("format: " + r);
            date = LocalDate.parse(r, format);
//            System.out.println("parse: " + date.toString());
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return date;
    }
}
