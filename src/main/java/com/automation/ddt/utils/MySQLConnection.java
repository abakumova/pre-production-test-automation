package com.automation.ddt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

    private static StringBuilder inputMessage = new StringBuilder();

    public static String connectToDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/logindata";
        String username = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM data");
            while (resultSet.next()) {
                inputMessage.append(resultSet.getString(2));
            }
        }
        return inputMessage.toString();
    }
}