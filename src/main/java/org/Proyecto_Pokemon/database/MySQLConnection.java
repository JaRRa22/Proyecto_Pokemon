package org.Proyecto_Pokemon.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon","gonzalo","1234");
        return connection;
    }
}


