package application.module;

import application.database.DBEngine;
import application.model.User;
import application.util.Encryption;

public class Controller {

    private static User currentUser;
    private static DBEngine engine = new DBEngine();

    public static void logIn(String userName, String pwd) {
        currentUser = engine.auth(userName, Encryption.hashEncrypt(pwd));
    }

    public static void logOut() {
        currentUser = null;
    }

    public static void createNewBlog() {

    }
}
