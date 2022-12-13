package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;

public class AbstractController implements PublisherInterface<Boolean> {

    private Stage stage = null;

    private ArrayList<SubscriberInterface<Boolean>> list = new ArrayList<>();

    public <T> T loadFxmlFile(String path, String title, Window owner, Class<T> classOfController) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AbstractController.class.getResource(path));
        Parent scene = fxmlLoader.load();

        T controller = fxmlLoader.getController();

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(scene));

        if (owner != null) {
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(owner);
        }

        stage.show();

        return controller;
    }


    public void setStage(Stage s) {
        this.stage = s;
    }

    public void closeWindow() {
        if (stage != null) {
            stage.close();
        }
    }

    @Override
    public void addSubscriber(SubscriberInterface<Boolean> sub) {
        this.list.add(sub);
    }

    @Override
    public void removeSubscriber(SubscriberInterface<Boolean> sub) {
        this.list.remove(sub);
    }

    @Override
    public void notifySubscriber(Boolean what) {
        for (SubscriberInterface<Boolean> sub : list) {
            sub.notify(what);
        }
    }
}
