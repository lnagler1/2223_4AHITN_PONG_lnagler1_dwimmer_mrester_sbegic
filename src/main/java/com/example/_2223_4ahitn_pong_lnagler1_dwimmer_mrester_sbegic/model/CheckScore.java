package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller.GameController;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class CheckScore {
    String score = "";
    boolean gameStarted;
    private Media media;
    private MediaPlayer mediaPlayer;

    public String checkIfScored(double getXballPos, double leftRectXCord, double rightRectXCord, double getWidht) {
        if (getXballPos < (leftRectXCord - getWidht)) {
            playScoreSound();
            score = "p2";
            System.out.println("SCORE PLAYER 2");
            gameStarted = false;

        } else if (getXballPos < (rightRectXCord + getWidht)) {
            playScoreSound();
            score = "p1";
            System.out.println("SCORE PLAYER 1");
            gameStarted = false;

        }
        return score;
    }

    private void playScoreSound() {
        this.media = new Media(
                new File(
                        "src/main/resources/com/example/_2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic/sounds/scoreSound.mp3").toURI().toString());
        this.mediaPlayer = new MediaPlayer(this.media);
        this.mediaPlayer.play();
    }
}
