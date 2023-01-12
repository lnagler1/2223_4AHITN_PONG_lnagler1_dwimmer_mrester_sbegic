package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.paint.Color;

public class Bar {
    private double barLength;
    private double barWidth;
    private final Color color;
    private double xCord;
    private double yCord;
    private static int checkPlayer = 1;
    private PlayField playField = PlayField.getInstance();

    public Bar(int playfieldHeight, int playfieldWidth, Color color) {
        setLenght(playfieldHeight/4.5);
        setWidht(playfieldWidth/35);
        this.color = color;
        setXCord();
        setYCord();
    }

    public void checkContact2Ball() {
       /* if (ball.getxCords() == this.leftRectXCord && ball.getYCords() == this.leftRectYCord){
            // play Pong sound
            // shoot ball in random opposite direction in a certain angle based on the point of impact on the bar
        } else if (ball.getxCords() == this.rightRectXCord && ball.getYCords() == this.rightRectYCord){
            // play Pong sound
            // shoot ball in random opposite direction in a certain angle based on the point of impact on the bar
        } */
    }

    public double getLenght() {
        return this.barLength;
    }

    public void setLenght(double lenght) {
        this.barLength = lenght;
    }

    public double getWidht() {
        return barWidth;
    }

    public void setWidht(int widht) {
        this.barWidth = widht;
    }

    public void setXCord() {

        if(checkPlayer == 1) {
            this.xCord = this.barWidth;
            checkPlayer++;
        } else if(checkPlayer == 2){
            this.xCord = playField.width - this.barWidth * 2;
            checkPlayer++;
        }
    }

    public void setYCord() {
        this.yCord = playField.height / 2 - this.barLength / 2;
    }

    public double getXCord() {
        return xCord;
    }

    public double getYCord() {
        return yCord;
    }

    public Color getColor() {
        return color;
    }
}
