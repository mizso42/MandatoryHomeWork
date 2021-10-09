package application.module;

import application.database.DBEngine;
import application.model.User;
import application.util.Encryption;
import application.util.UserIO;

public class Controller {

    private User currentUser;
    private DBEngine engine = new DBEngine();

    public void logIn() {
        do {
            String userName = UserIO.getString("Enter username:");
            String pwdHash = Encryption.hashEncrypt(UserIO.getString("Enter password:"));
            currentUser = engine.auth(userName, pwdHash);

            if (currentUser.getId() <= 0)
                UserIO.error(currentUser.getUserName());

        } while (currentUser.getId() <= 0);
    }

    public void logOut() {
        currentUser = null;
    }

    public void register() {
        String userName = UserIO.getString("Enter username:");
        //TODO check userName against DB
        String emilAddress = UserIO.getString("Enter e-mail address:");
        //TODO check emilAddress against DB
        boolean isMatch;
        do {
            String pwd;
            boolean isStrong;
            do {
                pwd = UserIO.getString("Enter password:");
                isStrong = pwd.length() > 7;
                //TODO properly check pwd strength
            } while (isStrong);
            pwd = Encryption.hashEncrypt(pwd);
            String pwd2 = Encryption.hashEncrypt(UserIO.getString("Reenter password:"));
            isMatch = pwd.equals(pwd2);
        } while (!isMatch);

    }

    public void createNewBlog() {

    }
}
