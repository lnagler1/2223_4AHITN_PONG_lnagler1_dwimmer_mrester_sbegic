package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Highscore {

//Highscore
    private String name;
    private int score;

     Highscore(ResultSet results) throws SQLException {
        this.name = setName(results.getString("name"));
        this.score = setScore(results.getInt("score"));

    }
    public static ObservableList<Highscore> getList() {
        ObservableList<Highscore> list = FXCollections.observableArrayList();

        Connection db = DbInstance.getInstance();
        try {
            PreparedStatement statement =
                    db.prepareStatement("SELECT * FROM pong");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                list.add(new Highscore(resultSet));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
       return this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int setScore(int score) {
       return this.score = score;
    }
}
