package com.example.login;


import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    private static final String INSERT_QUERY = "INSERT INTO registrierung (id, name, email, passwort) VALUES (?, ?, ?, ?)";

    public User get(long id){return null;}



    public void insertRecord(User user) {


        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            //TODO set id from database

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void saveRecord(User user){

    }

    public void updateRecord(User user){

    }

    public void deleteRecord(User user) {

    }


    public void insertRecord(String name, String email, String passwort) {
    }
}
