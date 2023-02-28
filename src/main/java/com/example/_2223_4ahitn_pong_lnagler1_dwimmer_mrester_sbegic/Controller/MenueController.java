package com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.Controller;

import com.example._2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic.model.Player;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenueController {
    public TextField tfPlayerName;
    public ChoiceBox cbBar;
    public Button btFinish;
    public Button btExit;
    public CheckBox checkBoxVersusKi;
    Player player1;
    Player player2;
    int count = 0;
    String temporaryName;
    Hashtable<String, Color> color_dict = new Hashtable<String, Color>();

    public MediaPlayer mediaPlayer;
    public Media media;

    public void initialize() {
        cbBar.setItems(FXCollections.observableArrayList("BLUE", "RED", "YELLOW", "GREEN"));
        cbBar.setValue("BLUE");

        color_dict.put("BLUE", Color.BLUE);
        color_dict.put("RED", Color.RED);
        color_dict.put("YELLOW", Color.YELLOW);
        color_dict.put("GREEN", Color.GREEN);
        media = new Media(new File("src/main/resources/com/example/_2223_4ahitn_pong_lnagler1_dwimmer_mrester_sbegic/sounds/backgroundMusic.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.025);
        mediaPlayer.setAutoPlay(true);
    }

    public void onFinishButtonClicked(ActionEvent actionEvent) {

        String name = tfPlayerName.getText();
        String color = (String) cbBar.getSelectionModel().getSelectedItem();
        Pattern pattern = Pattern.compile("\\W");
        Matcher matcher = pattern.matcher(name);
        boolean pat1 = matcher.find();

        if (name.equals("") || name.equals(temporaryName) || pat1) {
            System.out.println("Error");
            //logs.InputError();
            Stage window = new Stage();

            //Window
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Input-Error");


            //Label
            Label label = new Label();
            label.setText("Missing or Invalid Input-Parameters!");
            label.setStyle("-fx-font-size: 30");
            label.setTextFill(Color.WHITE);

            //Button
            Button btn_close = new Button("OK");
            btn_close.setMinSize(80, 30);
            btn_close.setOnAction(e -> window.close());
            btn_close.setStyle("-fx-background-color: WHITE");

            //Vbox / Layout
            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, btn_close);
            layout.setAlignment(Pos.CENTER);
            layout.setStyle("-fx-background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSropdEHx6PYFHHNyPavR0-UNv4UDc8wX4yhg&usqp=CAU'); -fx-background-repeat: no-repeat; -fx-background-size: 500 500; -fx-background-position: center center;");

            Scene scene = new Scene(layout, 500, 400);
            window.setScene(scene);
            window.showAndWait();

        } else {
            Stage stage = (Stage) btFinish.getScene().getWindow();
            if (count == 0) {
                player1 = new Player(name, color_dict.get(color));
                temporaryName = name;
                count++;
                tfPlayerName.clear();
                stage.close();
                stage.show();
                cbBar.setValue("BLUE");
                if (checkBoxVersusKi.isSelected()){

                    player2 = new Player("NPC", color_dict.get("BLUE"));
                    count = 2;
                    stage.close();
                }else{
                    stage.close();
                    stage.show();
                }


            } else if (count == 1) {
                player2 = new Player(name, color_dict.get(color));
                count++;
                stage.close();
            }

            if (count== 2){
                GameController g = new GameController(player1, player2, checkBoxVersusKi.isSelected());
                g.loadPlayField();
            }

        }
    }

    public void closeMenue() {
        Stage s = (Stage) btExit.getScene().getWindow();
        s.close();
    }


}
