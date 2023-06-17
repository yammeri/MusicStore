package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/MusicStore";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "qwerty123";
    private static final Logger logger = LogManager.getLogger(ConnectionFactory.class);

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            logger.error("Не удалось подключиться в базе:\n", e.getMessage());
            return null;
        }
    }
}
