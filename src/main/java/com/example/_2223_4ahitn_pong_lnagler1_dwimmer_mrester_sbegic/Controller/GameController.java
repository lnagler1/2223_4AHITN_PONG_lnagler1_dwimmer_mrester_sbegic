package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.Ball;
import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.PlayField;
import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.Random;

public class GameController {
    private Player player1;
    private Player player2;
    private int width;
    private int height;
    private boolean gameStarted;
    private int scoreP2;
    private int scoreP1;
    private GraphicsContext graphicsContext;
    Canvas canvas;
    MenueController m = new MenueController();

    public GameController(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void loadPlayField() {

        PlayField playField = PlayField.getInstance();
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
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), e -> run(graphicsContext)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        canvas.setOnMouseClicked(e -> gameStarted = true);
        playField.setBackground();
        timeline.play();
    }

    private void run(GraphicsContext gc) {
        PlayField playField = PlayField.getInstance();
        Ball ball = new Ball();
        playField.setBackground();

        int xBallPosition = ball.getxBallPostition();
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
            ball.setBall();
            if (xBallPosition < width - (width / 4)) {
                // set the bar on yBallPosition - height of bar / 2
            } else {
                // yBarPosition = yBallPosition > yBarPosition + barHeight / 2 ?yBarPosition +=1: yBarPosition - 1;
            }
        } else {
            Effect glow = new Glow(100.0);
            gc.setEffect(glow);
            gc.setStroke(Color.ORANGE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setFont(Font.font(java.awt.Font.SERIF, 46));
            gc.strokeText("Click to start", width / 2, height / 2);
            xBallPosition = width / 2;
            yBallPosition = height / 2;
            xBallSpeed = new Random().nextInt(2) == 0 ? 1 : -1;
            yBallSpeed = new Random().nextInt(2) == 0 ? 1 : -1;
        }
        if (yBallPosition > height || yBallPosition < 0) {
            yBallSpeed *= -1;
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
        player1.setBar(graphicsContext);
        //player2.setBar(graphicsContext); //Ist derzeit noch NULL aufgrund fehlender Eingabe
        ball.setBall();
    }
}
