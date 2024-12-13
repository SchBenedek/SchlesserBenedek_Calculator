package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HelloController {
    @FXML
    private Label eredemeny;

    @FXML
    private Button hozzaad;
    @FXML
    private Button kivon;
    @FXML
    private Button szoroz;
    @FXML
    private Button oszt;
    @FXML
    private Button szazalek;
    @FXML
    private TextField egyikSzam;
    @FXML
    private TextField masikSzam;


    @FXML
    protected void onHelloButtonClick() {
        eredemeny.setText("Welcome to JavaFX Application!");
    }

    public void check(){
        if(egyikSzam.getText().isEmpty() || masikSzam.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Minden mezőt ki kell tölteni!");
            alert.setHeaderText(null);

            alert.showAndWait();
        }
        if(!egyikSzam.getText().matches("^[0-9]+$") || !masikSzam.getText().matches("^[0-9]+$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Csak számot!");
            alert.setHeaderText(null);
        }
    }
    public void plusz(ActionEvent actionEvent) {
        double egyikSzamInt = Integer.parseInt(egyikSzam.getText());
        double masikSzamInt = Integer.parseInt(masikSzam.getText());
        double eredmenyInt = egyikSzamInt + masikSzamInt;
        eredemeny.setText(String.valueOf(eredmenyInt));
    }

    public void minus(ActionEvent actionEvent) {
        double egyikSzamInt = Integer.parseInt(egyikSzam.getText());
        double masikSzamInt = Integer.parseInt(masikSzam.getText());
        double eredmenyInt = egyikSzamInt - masikSzamInt;
        eredemeny.setText(String.valueOf(eredmenyInt));
    }

    public void szorzas(ActionEvent actionEvent) {
        double egyikSzamInt = Integer.parseInt(egyikSzam.getText());
        double masikSzamInt = Integer.parseInt(masikSzam.getText());
        double eredmenyInt = egyikSzamInt * masikSzamInt;
        eredemeny.setText(String.valueOf(eredmenyInt));
    }

    public void osztas(ActionEvent actionEvent) {
        if(masikSzam.getText().equals("0")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("0-val nem lehet osztani!");
            alert.setHeaderText(null);
        }
        else {
            double egyikSzamInt = Integer.parseInt(egyikSzam.getText());
            double masikSzamInt = Integer.parseInt(masikSzam.getText());
            double eredmenyInt = Math.round((egyikSzamInt / masikSzamInt) * 100.0) / 100.0;
            eredemeny.setText(String.valueOf(eredmenyInt));
        }
    }

    public void szazal(ActionEvent actionEvent) {
        if(masikSzam.getText().equals("0")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("0-val nem lehet osztani");
            alert.setHeaderText(null);
        }
        else {
            double egyikSzamInt = Integer.parseInt(egyikSzam.getText());
            double masikSzamInt = Integer.parseInt(masikSzam.getText());
            double eredmenyInt = Math.round((egyikSzamInt % masikSzamInt) * 100.0) / 100.0;
            eredemeny.setText(String.valueOf(eredmenyInt));
        }
    }
}