package fileIO;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
    public static String buildFilePathWithCurrentDir(String fileName) {
        String userDir = System.getProperty("user.dir");
        return userDir + File.separator + fileName;
    }

    public static Date convertStringToDate (String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.parse(date);
    }
}
