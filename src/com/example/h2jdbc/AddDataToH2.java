package com.example.h2jdbc;

import java.sql.*;

public class AddDataToH2 {

    static final String DB_URL = "jdbc:h2:tcp://localhost/mem:e49a1fa2-0fed-4890-8c61-61c2ec6c28cf";
    static final String JDBC_DRIVER = "";

    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmnt = null;

        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmnt = conn.createStatement();
            String sqlQuery = "INSERT INTO TEST VALUES(5, 'Mariusz');";
            stmnt.execute(sqlQuery);

            conn.close();
            stmnt.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
