package application.database;

import application.model.Admin;
import application.model.Moderator;
import application.model.User;
import application.util.FileHandler;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DBEngine {

    private Connection connection;

    private String dbUrl = System.getenv("DB_URL") != null ?
                            System.getenv("DB_URL") : "jdbc:mysql://localhost:3306/";
    private String dbProperties = System.getenv("DB_PROPERTIES") != null ?
                            System.getenv("DB_PROPERTIES") : "?useUnicode=yes&characterEncoding=UTF-8";

    public DBEngine() {
        connection = connect();
        if (isConnected())
            createDB();
    }

    public boolean isConnected() {
        return connection != null;
    }

    private Connection connect() {
        String url = dbUrl /* + System.getenv(dbName) */ + dbProperties;

        Properties properties = new Properties();
        properties.put("user", System.getenv("DB_USER"));
        properties.put("password", System.getenv("DB_PWD"));

        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            System.out.println("An error occurred during connecting database.\n" +
                "Please check if the environment variables have been set up correctly.");
            return null;
        }
    }

    public void createDB() {
        List<String> queries = FileHandler.readSQLFileWithoutEmptyLines("DB_query.sql");

        if (queries != null) {
            for (String query : queries) {
                try {
                    Statement statement = connection.createStatement();
                    statement.execute(query);
                } catch (SQLException e) {
                    System.out.println("Error during creating database.");
                }
            }
        } else {
            System.out.println("Error during loading queries.");
        }
    }

    public User auth(String userName, String pwdHash) {
        User user = new User();

        //TODO query builder
        String query = "SELECT * FROM user WHERE user_name = '" + userName + "'";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                if (rs.getString("pwd_hash").equals(pwdHash)) {
                    user = new User(rs.getLong("id"),
                            rs.getString("user_name"),
                            rs.getString("emil_address"),
                            rs.getString("pwd_hash"),
                            rs.getBytes("pic")); //TODO load lists

                    switch (rs.getString("role")) {
                        case "admin" -> user = new Admin(user);
                        case "moderator" -> user = new Moderator(user);
                        default -> {}
                    }
                } else {
                    user = new User(-2);
                }
            } else {
                user = new User(-1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
