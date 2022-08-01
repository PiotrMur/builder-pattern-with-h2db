package com.example.h2jdbc;

import java.sql.*;

public class CreateH2Db {

    static final String DB_URL = "jdbc:h2:tcp://localhost/mem:e49a1fa2-0fed-4890-8c61-61c2ec6c28cf";

    static final String USER = "sa";
    static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        Statement stmt = null;

        try {

            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE Employee(" +
                    "ID INTEGER AUTO_INCREMENT, " +
                    "first_name VARCHAR(128), " +
                    "last_name VARCHAR(128), " +
                    "age VARCHAR(128), " +
                    "street VARCHAR(128), " +
                    "city VARCHAR(128), " +
                    "PRIMARY KEY(ID));";
            stmt.execute(sql);
            System.out.println("Created table in given database...");

            conn.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }

        }

    }
}

