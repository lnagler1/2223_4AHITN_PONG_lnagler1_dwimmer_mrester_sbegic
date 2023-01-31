package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

public class KI {
    Player player;
    double length;

    public KI(Player player) {
        this.player = player;
        length = player.getBar().getLenght();
    }

    public void chaseBall(int yBallPosition){
        int diff =0;

        diff = (int) ((player.getBar().getYCord() + length/2) - yBallPosition);
        if (diff > 0 && player.getBar().checkContact2UpperWall()){
            player.getBar().setYCord(-3); //original 4
        }else if (diff < 0 && player.getBar().checkContact2LowerWall()){
            player.getBar().setYCord(+3); //original 4
        }

    }
}
