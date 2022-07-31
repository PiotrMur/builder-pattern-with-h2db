package com.example.h2jdbc;

import java.sql.*;

public class CreateH2Db {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/mem:e49a1fa2-0fed-4890-8c61-61c2ec6c28cf";

    static final String USER = "sa";
    static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        Statement stmt = null;

        try {
            //Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE NewDB(ID INT PRIMARY KEY, NAME VARCHAR(255));";
            stmt.executeUpdate(sql);
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

