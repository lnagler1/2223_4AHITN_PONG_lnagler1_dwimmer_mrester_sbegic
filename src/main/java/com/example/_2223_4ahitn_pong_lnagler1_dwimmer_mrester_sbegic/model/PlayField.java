package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PlayField {
    public void setBackground(GraphicsContext graphicsContext, int width, int height) {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0,0,width,height);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(Font.font(25));
    }
}
