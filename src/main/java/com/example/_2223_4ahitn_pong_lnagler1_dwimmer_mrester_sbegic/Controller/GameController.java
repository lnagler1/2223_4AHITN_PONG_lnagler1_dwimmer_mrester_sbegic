package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.PlayField;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameController {
    private final int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    private final int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
    private int width;
    private int height;
    private GraphicsContext graphicsContext;

    private Bar bar = new Bar();

    public void loadPlayField() {
        setWidthAndHeight();
        PlayField playField = PlayField.getInstance();
        Group root = new Group();
        Canvas canvas = new Canvas(playField.getWidth(), playField.getHeight());
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
        Ball ball = new Ball();
        playField.setGc(graphicsContext);
        playField.setBackground();
        ball.setBall();
    }

    public void setWidthAndHeight(){
        PlayField playField = PlayField.getInstance();
        if (screenWidth <= 800 && screenHeight <= 600) {
            playField.setWidth(600);
            playField.setHeight(400);
            setBarMeassures(height, width);
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            playField.setWidth(800);
            playField.setHeight(600);
            setBarMeassures(height, width);
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            playField.setWidth(1000);
            playField.setHeight(700);
            setBarMeassures(height, width);
        }
        System.out.println(screenWidth);
        System.out.println(bar.getLenght());
        System.out.println(bar.getWidht());
    }

    public void setBarMeassures(int length, int width){
        bar.setLenght(length/4.5);
        bar.setWidht(width/33);
    }
}
