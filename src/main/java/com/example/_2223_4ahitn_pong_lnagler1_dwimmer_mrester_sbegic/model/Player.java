package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class Player {
    private String name;
    private Bar bar;
    private PlayField playField;
    private final int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    private final int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();


    public Player(CharSequence name, Color color) {
        this.name = (String) name;
        this.playField = PlayField.getInstance();
        setWidthAndHeight();
        this.bar = new Bar(this.playField.getHeight(), this.playField.getWidth(), color);
    }

    public void setBar(GraphicsContext graphicsContext) {
        graphicsContext.setFill(this.bar.getColor());
        graphicsContext.fillRect(this.bar.getXCord(), this.bar.getYCord(), this.bar.getWidht(), this.bar.getLenght());
    }

    public void setWidthAndHeight() {
        if (screenWidth <= 800 && screenHeight <= 600) {
            this.playField.setWidth(600);
            this.playField.setHeight(400);
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            this.playField.setWidth(800);
            this.playField.setHeight(600);
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            this.playField.setWidth(1000);
            this.playField.setHeight(700);
        }
    }

    public Bar getBar() {
        return bar;
    }

    public String getName() {
        return name;
    }

}
