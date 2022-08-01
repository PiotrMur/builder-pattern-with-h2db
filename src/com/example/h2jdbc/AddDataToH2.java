package com.example.h2jdbc;

import com.example.h2jdbc.entities.*;

import java.sql.*;

public class AddDataToH2 {

    static final String DB_URL = "jdbc:h2:tcp://localhost/mem:e49a1fa2-0fed-4890-8c61-61c2ec6c28cf";
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmnt = null;

        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmnt = conn.createStatement();


            //showEmployees(stmnt);

            String sqlRowsCounter = "SELECT COUNT('id') FROM Employee";
            ResultSet resultSet = stmnt.executeQuery(sqlRowsCounter);
            resultSet.next();
            int id = resultSet.getInt(1);
            String firstName = "Piotr";
            String lastName = "Michalski";
            String age = "36";
            String street = "Korzystna";
            String city = "Szczecin";

            PersonalData personalData = new PersonalDataBuilder(firstName, lastName).age(age).build();
            Address address = new AddressBuilder(street).city(city).build();
            Employee employee = new Employee(personalData, address);

            String sqlInsertation = "INSERT INTO Employee(id, first_name, last_name, age, street, city) " +
                    "VALUES("+(id+1) + "," +
                    employee.getPersonalData().getFirstName() + ","+
                    employee.getPersonalData().getLastName()+","+
                    employee.getPersonalData().getAge()+","+
                    employee.getAddress().getStreet()+"," +
                    employee.getAddress().getCity()+ ");";

            stmnt.execute(sqlInsertation);

            conn.close();
            stmnt.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static void showEmployees(Statement stmnt) throws SQLException {
        String sqlQuery = "SELECT * FROM EMPLOYEE";
        ResultSet sqlQueryResult = stmnt.executeQuery(sqlQuery);
        while(sqlQueryResult.next()){
            String id = sqlQueryResult.getString("id");
            String firstName = sqlQueryResult.getString("first_name");
            String lastName = sqlQueryResult.getString("last_name");
            String age = sqlQueryResult.getString("age");
            String street = sqlQueryResult.getString("street");
            String city = sqlQueryResult.getString("city");
            System.out.println(id + ". " + firstName + " " + lastName + " " + age + " " +street + " " + city );
        }
    }
}
