package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {
    PlayField playField = PlayField.getInstance();
    private int radius;
    private int xBallSpeed = 2;
    private int yBallSpeed = 2;
    private int xBallPosition = playField.getWidth() / 2;
    private int yBallPosition = playField.getHeight() / 2;

    public void setBall(GraphicsContext gc) {
        setRadius();
        gc.setFill(Color.BLUE);
        gc.fillRoundRect(xBallPosition, yBallPosition, radius, radius, 90, 90);
    }

    public boolean yCollision(int height) {
        return yBallPosition + radius > height || yBallPosition < 0;
    }

    public boolean xCollision(int width) {
        return xBallPosition + radius > width || xBallPosition < 0;
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
