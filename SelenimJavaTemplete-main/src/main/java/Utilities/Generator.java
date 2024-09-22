package Utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Generator {


    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = RANDOM.nextInt(ALPHANUMERIC_STRING.length());
            sb.append(ALPHANUMERIC_STRING.charAt(index));
        }
        return sb.toString();
    }
    public static String getDatePlusDays(int days) {
        LocalDate datePlusDays = LocalDate.now().plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return datePlusDays.format(formatter);
    }


}