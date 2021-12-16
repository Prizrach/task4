package app.sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class SqlHelper {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem:app;DB_CLOSE_DELAY=-1";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";

    // return DriverManager.getConnection("jdbc:h2:file:~/scripts;INIT=RUNSCRIPT FROM '~/createTables.sql'\\;RUNSCRIPT FROM '~/insertProducts.sql'");

    public static Connection connection = getConnection();

    public static Connection getConnection() {
        try{
           Class.forName(DB_DRIVER);
           connection =  DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void initDB() {
        try (PreparedStatement ps = connection.prepareStatement("" +
                "CREATE TABLE User\n" +
                "(\n" +
                "  id       int AUTO_INCREMENT PRIMARY KEY,\n" +
                "  login    text NOT NULL,\n" +
                "  password text\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE `ORDER`\n" +
                "(\n" +
                "  id          int AUTO_INCREMENT PRIMARY KEY,\n" +
                "  user_id     int,\n" +
                "  total_price double NOT NULL,\n" +
                "  CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES USER (ID)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE Good\n" +
                "(\n" +
                "  id    int AUTO_INCREMENT PRIMARY KEY,\n" +
                "  title text   NOT NULL,\n" +
                "  price double NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE Order_Good\n" +
                "(\n" +
                "  id       int AUTO_INCREMENT PRIMARY KEY,\n" +
                "  order_id int,\n" +
                "  good_id  int,\n" +
                "  CONSTRAINT order_id FOREIGN KEY (order_id) REFERENCES `ORDER` (ID),\n" +
                "  CONSTRAINT good_id FOREIGN KEY (good_id) REFERENCES GOOD (ID)\n" +
                ");")) {

            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement ps = connection.prepareStatement("" +
                "INSERT INTO GOOD (TITLE, Price)\n" +
                "VALUES ('Lays', 1.0);\n" +
                "INSERT INTO GOOD (TITLE, Price)\n" +
                "VALUES ('Coca-Cola', 2.0);\n" +
                "INSERT INTO GOOD (TITLE, Price)\n" +
                "VALUES ('Sprite', 2.0);\n" +
                "INSERT INTO GOOD (TITLE, Price)\n" +
                "VALUES ('Fanta', 2.0);\n")) {

            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

