package it.localhost.app.web.tinyrestfakegen;

import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 
 */
public class DateUtils {
    
    public static LocalDate getRandomDate() throws DAOException {
        long start = Timestamp.valueOf("1980-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2015-01-01 00:00:00").getTime();
        long diff = end - start + 1;
        Timestamp randomTimeStamp = new Timestamp(start + (long)(Math.random() * diff));
        LocalDate date = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.ITALIAN);
            date = LocalDate.parse(randomTimeStamp.toString(), formatter);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return date;
    }
}
