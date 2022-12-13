package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bar {
    private double length;
    private double width;
    private final Color color;

    private PlayField playField = PlayField.getInstance();

    public Bar() {
        this.length = 0;
        this.width = 0;
        this.color = Color.WHITE;
    }

    public void setBar(GraphicsContext graphicsContext) {
        graphicsContext.setFill(this.color);
        graphicsContext.fillRect(this.width, playField.height / 2 - this.length / 2, this.width, this.length);

        graphicsContext.setFill(this.color);
        graphicsContext.fillRect(playField.width - this.width * 2, playField.height / 2 - this.length / 2, this.width, this.length);
    }

    public double getLenght() {
        return this.length;
    }

    public void setLenght(double lenght) {
        this.length = lenght;
    }

    public double getWidht() {
        return width;
    }

    public void setWidht(int widht) {
        this.width = widht;
    }
}
