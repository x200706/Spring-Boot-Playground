package org.example.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTool {
    public String localDateToString(LocalDate localDate) {
        //LocalDate轉成LocalDateTime
        LocalDateTime localDateTime = localDate.atStartOfDay();
        //LocalDateTime轉成String
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return dateTimeFormatter.format(localDateTime);
    }
}
