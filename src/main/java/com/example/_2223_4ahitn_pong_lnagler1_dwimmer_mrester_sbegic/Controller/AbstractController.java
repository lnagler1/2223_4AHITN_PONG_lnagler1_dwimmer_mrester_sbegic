package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.util.ArrayList;

public abstract class AbstractController implements PublisherInterface<Boolean> {

    private Stage stage = null;
    private ArrayList<SubscriberInterface<Boolean>> list = new ArrayList<>();
    // <T extends Abstrac ... macht den code typsicherer
    public <T extends AbstractController> T loadFxmlFile(String path, String title, Window owner, Class<T> classOfController) throws IOException {
        URL fxmlLocation = getClass().getResource("highscores.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        //FXMLLoader fxmlLoader = new FXMLLoader(AbstractController.class.getResource(path));
        //Parent scene = loader.load();

        T controller = loader.getController();


        Stage stage = new Stage();
       // stage.setScene(new Scene(scene));
        stage.setTitle(title);

        controller.setStage(stage);

        if (owner != null) {
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(owner);
        }

        stage.show();

        return controller;
    }

    public void setStage(Stage s){
        this.stage = s;
    }

    public void closeWindow(){
        if (stage != null) {
            stage.close();
        }
    }
/*
    @Override
    public void addSubscriber(SubscriberInterface<Boolean> sub) {
        list.add(sub);
    }

    @Override
    public void removeSubscriber(SubscriberInterface<Boolean> sub) {
        list.remove(sub);
    }

    public void notifySubscribers(Boolean what) {
        for (SubscriberInterface<Boolean> sub : list) {
            sub.notify(what);
        }
    }
*/
}

