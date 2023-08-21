package br.com.will.despesas.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    // Singleton
    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
