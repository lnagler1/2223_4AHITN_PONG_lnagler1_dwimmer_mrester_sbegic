package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameController {
    private Player player1;
    private Player player2;
    private boolean gameStarted;
    private int scoreP2;
    private int scoreP1;
    String currentKey = "justInitialized";
    Thread t = new Thread();
    private GraphicsContext graphicsContext;
    Canvas canvas;
    MenueController m = new MenueController();
    PlayField playField = PlayField.getInstance();
    Ball ball;
    CheckScore checkScores = new CheckScore();
    KI roboter;
    KI roboter2;



    public GameController(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        roboter = new KI(this.player2);
        roboter2 = new KI(this.player1);

    }

    public void loadPlayField() {

        PlayField playField = PlayField.getInstance();

        canvas = new Canvas(playField.getWidth(), playField.getHeight());

        ball = new Ball();
        Group root = new Group();
        root.getChildren().add(canvas);
        Stage stage = new Stage();
        stage.setTitle("Pong");
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        /**
         * @author lnagler1
         * If weither, W or S are pressed a new Thread is started, which changes the Y coordinate of the bar
         * each 20 milliseconds.
         */
        stage.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {

            // if S is pressed
            if (keyEvent.getCode() == KeyCode.S && player1.getBar().checkContact2LowerWall()) {

                if (t == null || !t.isAlive()) {
                    t = new Thread() {
                        public void run() {
                            currentKey = "S";
                            try {
                                while (true && player1.getBar().checkContact2LowerWall()) {
                                    player1.getBar().setYCord(10);
                                    TimeUnit.MILLISECONDS.sleep(20);
                                }
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                        }

                    };
                    t.start();
                }
            }

            // if W is pressed
            if (keyEvent.getCode() == KeyCode.W && player1.getBar().checkContact2UpperWall()) {

                if (t == null || !t.isAlive()) {
                    t = new Thread() {
                        public void run() {
                            currentKey = "W";
                            try {
                                while (true && player1.getBar().checkContact2UpperWall()) {
                                    player1.getBar().setYCord(-10);
                                    TimeUnit.MILLISECONDS.sleep(20);
                                }
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                        }

                    };
                    t.start();
                }
            }
        });

        stage.addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> {
            if (t.isAlive()){
                t.interrupt();
            }
        });


        graphicsContext = canvas.getGraphicsContext2D();
        startGame();
    }


    public void startGame() {
        PlayField playField = PlayField.getInstance();

        playField.setGc(graphicsContext);
        playField.paintBackground();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(0.1), e -> run(graphicsContext)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        canvas.setOnMouseClicked(e -> gameStarted = true);
        timeline.play();
    }


    private void run(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, playField.width, playField.height);

        int xBallPosition = ball.getxBallPostition();
        // System.out.println(xBallPosition);
        int yBallPosition = ball.getyBallPosition();
        float xBallSpeed = ball.getxBallSpeed();
        float yBallSpeed = ball.getyBallSpeed();
        int width = playField.getWidth();
        int height = playField.getHeight();
        gc.setFill(Color.BLUE);
        gc.fillText(scoreP1 + "      " + scoreP2, width / 2, 100);


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
        }

        if (ball.yCollision(height)) {
            //  System.out.println("Oben/unten abgebounced");
            ball.setyBallSpeed(yBallSpeed * -1);
        }
        if (ball.xCollision(width)) {
            //System.out.println("Links/Rechts abgebounced");
            String WhoScored = checkScores.checkIfScored(ball.getxBallPostition() ,this.player1.getBar().getXCord(),this.player2.getBar().getXCord(),this.player2.getBar().getWidht());
            if (WhoScored.equals("p1")){
                this.scoreP1++;
            }else {
                this.scoreP2++;
            }

            gameStarted = false;
            ball.resetBall();

            ball.setxBallSpeed(xBallSpeed * -1);
        }
        ball.checkContact2Player1(player1);
        ball.checkContact2Player2(player2);
        /*
        if (xBallPosition < 'xBarPositionPlayer1' - 'BarWidth'){
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
        }
        */
        player1.setBar(graphicsContext);
        player2.setBar(graphicsContext);
        ball.setBall(gc);
        roboter.chaseBall(ball.getyBallPosition());
        roboter2.chaseBall(ball.getyBallPosition());
    }

}
