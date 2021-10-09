package application;

import application.database.DBEngine;
import application.model.Admin;
import application.model.User;
import application.module.Controller;

public class Main {
    public static void main(String[] args) {

        Controller ctr = new Controller();
        ctr.logIn();
    }
}
