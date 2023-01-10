package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PlayField {
    private static PlayField instance = null;
    public int height;
    public int width;
    public GraphicsContext gc;

    public void setBackground() {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void setGc(GraphicsContext graphicsContext) {
        this.gc = graphicsContext;
    }

    public GraphicsContext getGc() {
        return this.gc;
    }

    public static PlayField getInstance() {
        if (instance == null) {
            instance = new PlayField();
        }
        return instance;
    }


}