package com.example.demogui.Controller;

import com.example.demogui.Entity.Character;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class characterController implements Initializable {

    @FXML
    public Label chrName;
    @FXML
    public Label chBirth;
    @FXML
    public Label chrDeath;
    @FXML
    public Label chrGov;
    @FXML
    public Label chrRel;
    @FXML
    public Label chrFes;
    @FXML
    public Label chrPlace;
    @FXML
    public Label chrDes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setLabel(Character character){
        chrName.setText(character.getName());
        chBirth.setText(character.getcBirth());
        chrDeath.setText(character.getcDeath());
        chrDes.setText(character.getDescription());
    }

}
