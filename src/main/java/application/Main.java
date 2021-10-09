package application;

import application.database.DBEngine;
import application.model.Admin;
import application.model.User;

public class Main {
    public static void main(String[] args) {

        User dummy = new Admin(new User(1, "name", "emil", "pwd"));
        System.out.println(dummy.getClass().getSimpleName());
    }
}
