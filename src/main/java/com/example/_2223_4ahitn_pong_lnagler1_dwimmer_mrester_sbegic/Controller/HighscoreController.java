package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.Highscore;
import javafx.scene.control.ListView;

public class HighscoreController {

    public ListView<Highscore> highscoreListView;


    public void initialize(){
        highscoreListView.setItems(Highscore.getList());


    }



}
