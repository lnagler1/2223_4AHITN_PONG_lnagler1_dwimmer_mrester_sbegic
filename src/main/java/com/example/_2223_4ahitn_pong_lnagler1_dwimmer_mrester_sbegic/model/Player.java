package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class Player {
    private String name;
    private Bar bar;
    private final int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    private final int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
    private int playfieldHeight;
    private int playfieldWidth;

    public Player(CharSequence name, Color color) {
        setWidthAndHeight();
        this.name = (String) name;
        this.bar = new Bar(playfieldHeight, playfieldWidth, color);
    }

    public void setBar(GraphicsContext graphicsContext) {
        graphicsContext.setFill(this.bar.getColor());
        graphicsContext.fillRect(this.bar.getxCord(), this.bar.getyCord(), this.bar.getWidht(), this.bar.getLenght());
    }

    public void setWidthAndHeight() {
        if (screenWidth <= 800 && screenHeight <= 600) {
            this.playfieldWidth = 600;
            playfieldHeight = 400;
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            playfieldWidth = 800;
            playfieldHeight = 600;
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            playfieldWidth = 1000;
            playfieldHeight = 700;
        }
    }

    public Bar getBar() {
        return bar;
    }

    public String getName() {
        return name;
    }

}
