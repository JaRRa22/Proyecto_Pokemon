package org.Proyecto_Pokemon.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection("http://localhost/phpmyadmin/index.php?route=/database/structure&db=pokemon");
        return connection;
    }
}


