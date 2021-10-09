package application.util;

import java.util.Scanner;

public class UserIO {

    //Inputs
    private static Scanner scan = new Scanner(System.in);

    public static String getString(String question) {
        System.out.println(question);
        return scan.nextLine();
    }

    public static int getInt(String question) {
        System.out.println(question);
        int i = scan.nextInt();
        scan.nextLine();
        return i;
    }

    //Outputs
    public static void error(String message) {
        System.out.println(message);
    }
}
