package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

public class CheckScore {

    Ball ballPos = new Ball();
    String score = "";
    boolean gameStarted;

    public String checkIfScored(double getXballPos, double leftRectXCord, double rightRectXCord, double getWidht) {
        if (getXballPos < (leftRectXCord - getWidht)) {
            score = "p2";
            System.out.println("SCORE PLAYER 2");
            gameStarted = false;
        } else if (getXballPos < (rightRectXCord + getWidht)) {
            score = "p1";
            System.out.println("SCORE PLAYER 1 MESSSII");
            gameStarted = false;
        }
        return score;
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
