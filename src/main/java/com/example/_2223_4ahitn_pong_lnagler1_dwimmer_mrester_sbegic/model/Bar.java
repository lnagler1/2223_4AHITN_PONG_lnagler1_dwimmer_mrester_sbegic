package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.paint.Color;

public class Bar {
    private double length;
    private double width;
    private final Color color;
    private double xCord;
    private double yCord;

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
        return this.length;
    }

    public void setLenght(double lenght) {
        this.length = lenght;
    }

    public double getWidht() {
        return width;
    }

    public void setWidht(int widht) {
        this.width = widht;
    }

    public void setXCord() {
        this.xCord = playField.width - this.width * 2;
    }

    public void setYCord() {
        this.yCord = playField.height / 2 - this.length / 2;
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
