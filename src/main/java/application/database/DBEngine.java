package application.database;

import application.util.FileHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
                    System.out.println("Error during creating database.");;
                }
            }
        } else {
            System.out.println("Error during loading queries.");
        }
    }
}
