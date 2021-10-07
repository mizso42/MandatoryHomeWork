package application.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    private static String resoursesPath = "src/main/resources/";

    public static List<String> readSQLFileWithoutEmptyLines(String fileName) {
        try {
            Scanner scan = new Scanner(new File(resoursesPath + fileName));
            StringBuilder line = new StringBuilder();

            while (scan.hasNextLine()) {
                line.append(scan.nextLine().strip());
            }

            List<String> queries = Arrays.asList(line.toString().split(";"));
            queries.forEach(query -> query += ";");

            return queries;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
