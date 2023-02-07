package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbInstance {

    private DbInstance() {
    }

    private static Connection connection = null;

    public synchronized static Connection getInstance() {
        if (connection == null) {
            try {
                // erzeuge neue Verbinung zur Datenbank
                connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/pong", "pong", "pong");
            } catch (SQLException throwables) {
            }
        }
        return connection;
    }
}
