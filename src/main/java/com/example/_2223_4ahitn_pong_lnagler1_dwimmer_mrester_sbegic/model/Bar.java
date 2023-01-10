package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bar {
    private double length;
    private double width;
    private final Color color;
    private double leftRectXCord;
    private double leftRectYCord;
    private double rightRectXCord;
    private double rightRectYCord;

    private PlayField playField = PlayField.getInstance();
    //private Ball ball = Ball.getInstace();

    public Bar() {
        this.length = 0;
        this.width = 0;
        this.color = Color.WHITE;
    }

    public void setBar(GraphicsContext graphicsContext) {
        graphicsContext.setFill(this.color);
        graphicsContext.fillRect(leftRectXCord, leftRectYCord, this.width, this.length);

        graphicsContext.setFill(this.color);
        graphicsContext.fillRect(rightRectXCord, rightRectYCord, this.width, this.length);
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


    public double getLeftRectXCord() {
        return leftRectXCord;
    }

    public void setLeftRectXCord() {
        this.leftRectXCord = this.width;
    }

    public double getLeftRectYCord() {
        return leftRectYCord;
    }

    public void setLeftRectYCord() {
        this.leftRectYCord = playField.height / 2 - this.length / 2;
    }

    public double getRightRectXCord() {
        return rightRectXCord;
    }

    public void setRightRectXCord() {
        this.rightRectXCord = playField.width - this.width * 2;
    }


    public double getRightRectYCord() {
        return rightRectYCord;
    }

    public void setRightRectYCord() {
        this.rightRectYCord = playField.height / 2 - this.length / 2;
    }
}
