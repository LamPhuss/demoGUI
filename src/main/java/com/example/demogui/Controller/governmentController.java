package com.example.demogui.Controller;

import com.example.demogui.Entity.Entity;
import com.example.demogui.Entity.Government;
import com.example.demogui.FxmlLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class governmentController implements Initializable {
    @FXML
    public Label gdEnd;
    @FXML
    public Label gType;
    @FXML
    public Label gFigure;
    @FXML
    public Label gFes;
    @FXML
    public Label gPlace;
    @FXML
    public Label gEvent;
    @FXML
    private Label gName;
    @FXML
    private Label gDes;
    @FXML
    private Label gdFound;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setLabel(Government government) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demogui/mainScene.fxml"));
        Parent root = loader.load();
        mainController mainController = loader.getController();
        /*
        FXMLLoader loader = new FXMLLoader();
        String fxmlPath = "/com/example/demogui/mainScene.fxml";
        URL fxmlUrl = getClass().getResource(fxmlPath);
        if (fxmlUrl == null) {
            System.err.println("FXML file not found: " + fxmlPath);
            // Xử lý lỗi ở đây (ví dụ: hiển thị thông báo lỗi cho người dùng)
        } else {
            // Tiếp tục xử lý sau khi load FXML thành công
        }*/
        gName.setText(government.getName());
        gdFound.setText(government.getGovDateFounded());
        gdEnd.setText(government.getGovDateEnded());
        gType.setText(government.getGovType());
        HBox hbox = new HBox();

        for (String keyword : government.getGovFigures()) {
            Hyperlink hyperlink = new Hyperlink(keyword);
            mainController.setHyperLink(hyperlink);
            hbox.getChildren().add(hyperlink);
        }
        gFigure.setGraphic(hbox);
        //gFigure.setText(String.join(",",government.getGovFigures()));
        gFes.setText(String.join(",",government.getGovFestivals()));
        gPlace.setText(String.join(",",government.getGovPlaces()));
        gEvent.setText(String.join(",",government.getGovEvents()));
        gDes.setText(government.getDescription());
    }

    /*public void setHyperLink(Hyperlink itemToHyperlink){

        itemToHyperlink.setOnAction(event -> {
            ObservableList<Entity> govCheck = FXCollections.observableArrayList(governments);
            ObservableList<Entity> chrCheck = FXCollections.observableArrayList(characters);
            ObservableList<Entity> monuCheck = FXCollections.observableArrayList(monument);
            ObservableList<Entity> fesCheck = FXCollections.observableArrayList(festival);
            ObservableList<Entity> evnCheck = FXCollections.observableArrayList(events);
            if (checkEntityInList(itemToHyperlink,chrCheck)) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPane("figureScene",itemToHyperlink);
                mainBorder.setCenter(view);
                searchBar.setVisible(false);
                backButton.setVisible(true);
            }
            if (checkEntityInList(itemToHyperlink, govCheck)) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPane("governmentScene",itemToHyperlink);
                mainBorder.setCenter(view);
                searchBar.setVisible(false);
                backButton.setVisible(true);

            }
            if (checkEntityInList(itemToHyperlink,monuCheck)) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPane("placeScene",itemToHyperlink);
                mainBorder.setCenter(view);
                searchBar.setVisible(false);
                backButton.setVisible(true);
            }
            if (checkEntityInList(itemToHyperlink,fesCheck)) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPane("festivalScene",itemToHyperlink);
                mainBorder.setCenter(view);
                searchBar.setVisible(false);
                backButton.setVisible(true);
            }
            if (checkEntityInList(itemToHyperlink,evnCheck)) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPane("eventScene",itemToHyperlink);
                mainBorder.setCenter(view);
                searchBar.setVisible(false);
                backButton.setVisible(true);
            }
        });
    }*/
}
