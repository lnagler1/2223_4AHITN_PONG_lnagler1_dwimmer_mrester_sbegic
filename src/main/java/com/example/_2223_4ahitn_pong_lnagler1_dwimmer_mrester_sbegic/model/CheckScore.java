package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

public class CheckScore {

    Ball ballPos = new Ball();
    int scoreP2 = 0;
    int scoreP1 = 0;
    boolean gameStarted;

    public void checkIfScored(double getXballPos, double leftRectXCord, double rightRectXCord, double getWidht) {
        if (getXballPos < (leftRectXCord - getWidht)) {
            scoreP2++;
            System.out.println("SCORE PLAYER 2");
            gameStarted = false;
        } else if (getXballPos < (rightRectXCord + getWidht)) {
            scoreP1++;
            System.out.println("SCORE PLAYER 1 MESSSII");
            gameStarted = false;
        }
    }

    public Ball getBallPos() {
        return ballPos;
    }

    /*
    public Bar getBarPos() {
        return barPos;
    }

     */
}
