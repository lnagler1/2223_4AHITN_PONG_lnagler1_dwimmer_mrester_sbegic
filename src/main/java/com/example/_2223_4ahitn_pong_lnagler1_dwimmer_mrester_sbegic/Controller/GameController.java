package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Classes.Bar;
import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.PlayField;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
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
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
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
        PlayField playField = new PlayField();
        playField.setBackground(graphicsContext, width, height);
        bar.setBar(graphicsContext);
    }

    public void setWidthAndHeight() {
        if (screenWidth <= 800 && screenHeight <= 600) {
            this.width = 600;
            this.height = 400;
            setBarMeassures(height, width);
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            this.width = 800;
            this.height = 600;
            setBarMeassures(height, width);
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            this.width = 1000;
            this.height = 800;
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
