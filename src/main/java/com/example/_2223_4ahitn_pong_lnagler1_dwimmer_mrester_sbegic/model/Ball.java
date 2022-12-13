package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {
    public int radius;
    PlayField playField = PlayField.getInstance();

    public void setBall(){
        setRadius();
        GraphicsContext gc = playField.getGc();
        gc.setFill(Color.BLUE);
        gc.fillOval(300,300, radius, radius);
    }




    public void setRadius(){
        this.radius = (playField.getWidth() + playField.getHeight()) / 50;
    }

    public int getRadius(){
        return this.radius;
    }
}
