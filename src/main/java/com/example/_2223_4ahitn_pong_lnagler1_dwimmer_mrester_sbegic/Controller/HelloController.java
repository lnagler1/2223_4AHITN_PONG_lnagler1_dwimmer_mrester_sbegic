package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

import javafx.scene.control.Label;

public class HelloController {
    public Label moveToPlayField;


    public void onClickedMove(){
        GameController g = new GameController();
        g.loadPlayField();
    }
}