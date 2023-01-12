package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.Ball;
import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.Bar;
import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.PlayField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.Random;

public class GameController {
    private final int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    private final int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
    private boolean gameStarted;
    private int scoreP2;
    private int scoreP1;
    private GraphicsContext graphicsContext;
    Canvas canvas;
    PlayField playField = PlayField.getInstance();
    Ball ball;

    private Bar bar = new Bar();

    public void loadPlayField() {
        setWidthAndHeight();
        ball = new Ball();
        Group root = new Group();
        canvas = new Canvas(playField.getWidth(), playField.getHeight());
        root.getChildren().add(canvas);
        Stage stage = new Stage();
        stage.setTitle("Pong");
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        graphicsContext = canvas.getGraphicsContext2D();
        startGame();
    }


    public void startGame() {
        PlayField playField = PlayField.getInstance();

        playField.setGc(graphicsContext);
        playField.paintBackground();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), e -> run(graphicsContext)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        canvas.setOnMouseClicked(e -> gameStarted = true);
        timeline.play();
    }

    private void run(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRoundRect(ball.getxBallPostition(), ball.getyBallPosition(), ball.getRadius(), ball.getRadius(), 0, 0);


        int xBallPosition = ball.getxBallPostition();
        System.out.println(xBallPosition);
        int yBallPosition = ball.getyBallPosition();
        int xBallSpeed = ball.getxBallSpeed();
        int yBallSpeed = ball.getyBallSpeed();
        int width = playField.getWidth();
        int height = playField.getHeight();

        if (gameStarted) {
            xBallPosition += xBallSpeed;
            ball.setxBallPosition(xBallPosition);
            yBallPosition += yBallSpeed;
            ball.setyBallPosition(yBallPosition);
            ball.setBall(gc);
            if (xBallPosition < width - (width / 4)) {
                // set the bar on yBallPosition - height of bar / 2
            } else {
                // yBarPosition = yBallPosition > yBarPosition + barHeight / 2 ?yBarPosition +=1: yBarPosition - 1;
            }
        } else {
            xBallPosition = width / 2;
            yBallPosition = height / 2;
            xBallSpeed = new Random().nextInt(2) == 0 ? 1 : -1;
            yBallSpeed = new Random().nextInt(2) == 0 ? 1 : -1;
        }
        if (ball.yCollision(height)) {
            ball.setyBallSpeed(yBallSpeed * -1);
        }
        if (ball.xCollision(width)) {
            ball.setxBallSpeed(xBallSpeed * -1);
        }
        /*if (xBallPosition < 'xBarPositionPlayer1' - 'BarWidth'){
            scoreP2++;
            gameStarted = false;
        }
        if (xBallPosition < 'xBarPositionPlayer2' - 'BarWidth'){
            scoreP1++;
            gameStarted = false;
        }
        if( ((xBallPosition + ball.getRadius() > 'xBarPositionPlayer2')
                && yBallPosition >= 'yBarPositionPlayer2'
                && yBallPosition <= 'yBarPositionPlayer2' + 'BarHeight') ||
                ((xBallPosition < 'xBarPositionPlayer1' + 'BarWidth')
                        && yBallPosition >= 'yBarPositionPlayer1'
                        && yBallPosition <= 'yBarPositionPlayer1' + 'BarHeight')){
            yBallSpeed += 1 * Math.signum(yBallSpeed);
            xBallSpeed += 1 * Math.signum(xBallSpeed);
            xBallSpeed *= -1;
            yBallSpeed *= -1;
        }*/
        gc.fillText(scoreP1 + " " + scoreP2, width / 2, 100);
        ;
        bar.setBar(graphicsContext);
        ball.setBall(gc);
    }

    public void setWidthAndHeight() {
        PlayField playField = PlayField.getInstance();
        if (screenWidth <= 800 && screenHeight <= 600) {
            playField.setWidth(600);
            playField.setHeight(400);
            setBarMeassures(playField.height, playField.width);
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            playField.setWidth(800);
            playField.setHeight(600);
            setBarMeassures(playField.height, playField.width);
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            playField.setWidth(1000);
            playField.setHeight(700);
            setBarMeassures(playField.height, playField.width);
        }
    }

    public void setBarMeassures(int length, int width){
        bar.setLenght(length/4.5);
        bar.setWidht(width/35);
        bar.setLeftRectXCord();
        bar.setLeftRectYCord();
        bar.setRightRectXCord();
        bar.setRightRectYCord();
    }
}
