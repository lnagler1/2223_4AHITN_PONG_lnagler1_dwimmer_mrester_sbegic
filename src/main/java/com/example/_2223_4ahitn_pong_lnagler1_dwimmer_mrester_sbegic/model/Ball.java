package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {
    PlayField playField = PlayField.getInstance();
    private int radius;
    private int xBallSpeed = 1;
    private int yBallSpeed = 1;
    private int xBallPosition = playField.getWidth() / 2;
    private int yBallPosition = playField.getHeight() / 2;

    public void setBall() {
        setRadius();
        GraphicsContext gc = playField.getGc();
        gc.setFill(Color.BLUE);
        gc.fillOval(xBallPosition, yBallPosition, radius, radius);
    }


    public void setRadius() {
        this.radius = (playField.getWidth() + playField.getHeight()) / 50;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setxBallPosition(int position) {
        this.xBallPosition = position;
    }

    public int getxBallPostition() {
        return xBallPosition;
    }

    public void setyBallPosition(int position) {
        this.yBallPosition = position;
    }

    public int getyBallPosition() {
        return yBallPosition;
    }

    public int getxBallSpeed() {
        return xBallSpeed;
    }

    public void setxBallSpeed(int xBallSpeed) {
        this.xBallSpeed = xBallSpeed;
    }

    public int getyBallSpeed() {
        return yBallSpeed;
    }

    public void setyBallSpeed(int yBallSpeed) {
        this.yBallSpeed = yBallSpeed;
    }
}
