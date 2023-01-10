package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

public class CheckScore {

    Ball ballPos = new Ball();
    Bar barPos = new Bar();
    int scoreP2 = 0;
    int scoreP1 = 0;
    boolean gameStarted;

    public void checkIfScored() {
        if (ballPos.getxBallPostition() < barPos.getLeftRectXCord() - barPos.getWidht()) {
            scoreP2++;
            gameStarted = false;
        }
        if (ballPos.getxBallPostition() < barPos.getRightRectXCord() - barPos.getWidht()) {
            scoreP1++;
            gameStarted = false;
        }
    }

    public Ball getBallPos() {
        return ballPos;
    }

    public Bar getBarPos() {
        return barPos;
    }
}
