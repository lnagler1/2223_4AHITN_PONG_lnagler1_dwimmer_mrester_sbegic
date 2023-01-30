package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {
    PlayField playField = PlayField.getInstance();
    private int radius;
    private float xBallSpeed;
    private float yBallSpeed;
    private int xBallPosition;
    private int yBallPosition;

    public Ball() {
        setRadius();
        xBallSpeed = 3;
        yBallSpeed = 0;
        xBallPosition = playField.getWidth() / 2;
        yBallPosition = playField.getHeight() / 2;
    }

    public void resetBall() {
        xBallSpeed = 3;
        yBallSpeed = 0;
        xBallPosition = playField.getWidth() / 2;
        yBallPosition = playField.getHeight() / 2;
        setBall(playField.getGc());
    }

    public void setBall(GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        gc.fillRoundRect(xBallPosition, yBallPosition, radius, radius, 90, 90);
    }

    public void checkContact2Player1(Player player) {
        double yCord = player.getBar().getYCord();
        double xCord = player.getBar().getXCord();
        double barWidth = player.getBar().getWidht();
        double barLength = player.getBar().getLenght();


        if ((xBallPosition + 2 < xCord + barWidth)
                && (yBallPosition + radius >= yCord && yBallPosition <= yCord + barLength)) {
            rebound(player);
            xBallSpeed *= -1;
            System.out.println(xBallPosition + " " + xCord);
            System.out.println("Vallah");
        }

    }

    //maybe reflexionsgesetz für bewegtes Abprallen https://de.wikipedia.org/wiki/Reflexion_%28Physik%29#Reflexionsgesetz (Unter Bewegte Spiegelfläche)
    public void checkContact2Player2(Player player) {
        double yCord = player.getBar().getYCord();
        double xCord = player.getBar().getXCord();
        double barWidth = player.getBar().getWidht();
        double barLength = player.getBar().getLenght();


        if ((xBallPosition + 2 > xCord - barWidth)
                && (yBallPosition >= yCord && yBallPosition <= yCord + barLength)) {
            xBallSpeed *= -1;
            rebound(player);
            System.out.println(xBallPosition + " " + xCord);

        }

    }

    public void rebound(Player player) {
        int max = 5;
        double mid = player.getBar().getYCord() + (player.getBar().getLenght() / 2);
        float reboundChances = (float) (max / (player.getBar().getLenght() / 2));
        int reboundPoint = (int) (this.yBallPosition - mid);
        System.out.println(reboundPoint     +     "        "      +    mid);
        System.out.println(reboundPoint * reboundChances);
        yBallSpeed = reboundPoint * reboundChances;

        if (yBallSpeed < 1) {
            if (yBallSpeed < 0) {
                yBallSpeed -= 1;
                return;
            }
            yBallSpeed += 1;
        }
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

    public float getxBallSpeed() {
        return xBallSpeed;
    }

    public void setxBallSpeed(float xBallSpeed) {
        this.xBallSpeed = xBallSpeed;
    }

    public float getyBallSpeed() {
        return yBallSpeed;
    }

    public void setyBallSpeed(float yBallSpeed) {
        this.yBallSpeed = yBallSpeed;
    }
}
