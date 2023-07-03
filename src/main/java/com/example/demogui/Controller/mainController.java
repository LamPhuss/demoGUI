package com.example.demogui.Controller;

import com.example.demogui.Entity.*;
import com.example.demogui.Entity.Character;
import com.example.demogui.FxmlLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;

public class mainController implements Initializable {
    @FXML
    public TableColumn<Entity, String> nameCol;
    @FXML
    public TableColumn<Entity, String> desCol;
    @FXML
    private TableView<Entity> tableView;

    @FXML
    private BorderPane mainBorder;

    @FXML
    private TextField searchBar;

    @FXML
    private Button backButton;
    ObservableList<Entity> selectedList = FXCollections.observableArrayList();

    ObservableList<Character> characters = FXCollections.observableArrayList(
            new Character("Lý Thường Kiệt", "Tướng quân thời Lý", "13-09-1019", "17-08-1105", "Nhà Lý", Arrays.asList("Lý Nhật Tôn"), Arrays.asList("Tết Đoan Ngọ"), Arrays.asList("Thăng Long")),
            new Character("Trần Hưng Đạo", "Tướng quân thời Trần", "01-02-1228", "07-07-1300", "Nhà Trần", Arrays.asList("Trần Thánh Tông"), Arrays.asList("Lễ hội Đền Hùng"), Arrays.asList("Thăng Long", "Chi Lăng")),
            new Character("Lê Lợi", "Vua nhà Lê thứ nhất", "13-08-1385", "07-11-1433", "Nhà Hậu Lê", Arrays.asList("Lê Nguyên Khánh"), Arrays.asList("Tết Nguyên Đán"), Arrays.asList("Đông Kinh"))
    );
    ObservableList<Place> monument = FXCollections.observableArrayList(
            new Place("Đền Hùng", "Đền thờ tổ tiên của dân tộc Việt Nam", "đền", Arrays.asList("Lạc Long Quân", "Âu Cơ"), Arrays.asList("Lễ hội đền Hùng"), Arrays.asList("Đánh Tây Âu"), Arrays.asList("Văn Lang", "Âu Lạc", "Nhà Hùng")),
            new Place("Thành cổ Quảng Trị", "Di tích lịch sử về cuộc chiến tranh Việt Nam", "thành cổ", Arrays.asList("Ngô Đình Diệm"), Arrays.asList(), Arrays.asList("Trận Quảng Trị"), Arrays.asList("Bắc Việt")),
            new Place("Lăng Chủ tịch Hồ Chí Minh", "Nghĩa trang và di tích lịch sử về Chủ tịch Hồ Chí Minh", "lăng", Arrays.asList("Hồ Chí Minh"), Arrays.asList(), Arrays.asList("Chiến tranh Việt Nam"), Arrays.asList("Việt Nam Cộng hòa", "Cộng hòa Xã hội Chủ nghĩa Việt Nam"))
    );
    ObservableList<Festival> festival = FXCollections.observableArrayList(
            new Festival("Hội Đền Hùng", "Lễ hội tổ chức để tôn vinh các vua Hùng", "01-04", Arrays.asList("Phú Thọ"), Arrays.asList("Nhà Lý", "Nhà Trần", "Nhà Hậu Lê"), Arrays.asList("Lạc Long Quân", "Âu Cơ", "Hùng Vương"), Arrays.asList("Khởi đầu dân tộc", "Vua Hùng kính yêu")),
            new Festival("Lễ hội Đình Làng Việt", "Lễ hội văn hóa dân gian", "01-07", Arrays.asList("Hà Nội", "Hải Phòng", "Thái Nguyên", "Ninh Bình"), Arrays.asList("Nhà Hậu Lê", "Nhà Tây Sơn", "Nhà Nguyễn"), Arrays.asList("Nguyễn Bỉnh Khiêm", "Lê Hữu Trác", "Nguyễn Du"), Arrays.asList("Truyền thống văn hóa dân gian")),
            new Festival("Lễ hội Chọi Trâu", "Lễ hội tôn vinh trâu bò", "01-09", Arrays.asList("Hải Phòng"), Arrays.asList("Nhà Lý", "Nhà Trần", "Nhà Hậu Lê"), Arrays.asList("Lý Thường Kiệt", "Trần Hưng Đạo", "Lê Lợi"), Arrays.asList("Tôn vinh trâu bò")),
            new Festival("Lễ hội Trống Đồng Việt Nam", "Lễ hội trống đồng", "10-11", Arrays.asList("Bắc Ninh"), Arrays.asList("Nhà Tây Sơn", "Nhà Nguyễn"), Arrays.asList("Trương Vĩnh Ký", "Vũ Đình An", "Phan Huy Chú"), Arrays.asList("Tôn vinh trống đồng"))
    );
    ObservableList<Government> governments = FXCollections.observableArrayList(
            new Government("Lý Dynasty",
                    "The Lý dynasty was a Vietnamese dynasty that ruled from 1009 to 1225.",
                    "22-2-1009", "31-12-1225",
                    "Monarchy", List.of("Lý Thái Tổ", "Lý Thánh Tông"),
                    List.of("Tết", "Trùng Khánh Festival"),
                    List.of("Thăng Long", "Ho Citadel"),
                    List.of("Lý–Song War", "Mông Cổ invasions")),
            new Government("Trần Dynasty",
                    "The Trần dynasty was a Vietnamese dynasty that ruled from 1225 to 1400.",
                    "1-1-1225", "7-8-1400",
                    "Monarchy", List.of("Trần Thái Tông", "Trần Nhan Tông" ,"Trần Hưng Đạo"),
                    List.of("Tết", "Trùng Khánh Festival"),
                    List.of("Thăng Long", "Hồ Citadel"),
                    List.of("Mông Cổ invasions", "Champa–Đại Việt War")),
            new Government("Hồ Dynasty",
                    "The Hồ dynasty was a short-lived Vietnamese dynasty that ruled from 1400 to 1407.",
                    "7-8-1400","17-3-1407",
                    "Monarchy", List.of("Hồ Quý Ly", "Hồ Hán Thương"),
                    List.of("Tết", "Trùng Khánh Festival"),
                    List.of("Thăng Long", "Tây Đô"),
                    List.of("Ming–Hồ War")),
            new Government("Lê Dynasty",
                    "The Lê dynasty was a Vietnamese dynasty that ruled from 1428 to 1789.",
                    "1-1-1428", "30-9-1789",
                    "Monarchy", List.of("Lê Lợi", "Lê Thánh Tông"),
                    List.of("Tết", "Trùng Khánh Festival"),
                    List.of("Thăng Long", "Huế"),
                    List.of("Ming–Lê War", "Tây Sơn Rebellion")),
            new Government("Nguyễn Dynasty",
                    "The Nguyễn dynasty was the last Vietnamese dynasty, ruling from 1802 to 1945.",
                    "31-3-1802", "30-8-1945",
                    "Monarchy", List.of("Gia Long", "Bảo Đại"),
                    List.of("Tết", "Mid-Autumn Festival"),
                    List.of("Huế", "Saigon"),
                    List.of("Tây Sơn Rebellion", "French Indochina War"))
    );
    ObservableList<Event> events = FXCollections.observableArrayList(
            new Event("Đánh Bạch Đằng", "Kỷ niệm chiến thắng của quân Đại Việt trước quân Minh", "1288", List.of("Bạch Đằng", "Hải Dương")),
            new Event("Chiến dịch Hồ Chí Minh", "Chiến dịch giải phóng miền Nam", "1975", List.of("Khánh Hòa, Bình Thuận, Đồng Nai, Long An, Tây Ninh", "Việt Nam Cộng hòa, Cộng hòa Xã hội Chủ nghĩa Việt Nam")),
            new Event("Chiến dịch Điện Biên Phủ", "Chiến dịch giải phóng miền Bắc", "1954", List.of("Điện Biên"))

    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        // Bắt sự kiện nhấp chuột trên các dòng của bảng
        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Kiểm tra xem người dùng đã nhấp đúp chuột hay chưa
                Entity selectedEntity = tableView.getSelectionModel().getSelectedItem();
                if (selectedEntity != null) {
                    String checkedName = selectedEntity.getName();
                    ObservableList<Entity> govCheck = FXCollections.observableArrayList(governments);
                    ObservableList<Entity> chrCheck = FXCollections.observableArrayList(characters);
                    ObservableList<Entity> monuCheck = FXCollections.observableArrayList(monument);
                    ObservableList<Entity> fesCheck = FXCollections.observableArrayList(festival);
                    ObservableList<Entity> evnCheck = FXCollections.observableArrayList(events);
                    if (checkEntityInList(checkedName,chrCheck)) {
                        FxmlLoader object = new FxmlLoader();
                        Pane view = object.getPane("figureScene",selectedEntity);
                        mainBorder.setCenter(view);
                        searchBar.setVisible(false);
                        backButton.setVisible(true);
                    }
                    if (checkEntityInList(checkedName, govCheck)) {
                        FxmlLoader object = new FxmlLoader();
                        Pane view = object.getPane("governmentScene",selectedEntity);
                        mainBorder.setCenter(view);
                        searchBar.setVisible(false);
                        backButton.setVisible(true);

                    }
                    if (checkEntityInList(checkedName,monuCheck)) {
                        FxmlLoader object = new FxmlLoader();
                        Pane view = object.getPane("placeScene",selectedEntity);
                        mainBorder.setCenter(view);
                        searchBar.setVisible(false);
                        backButton.setVisible(true);
                    }
                    if (checkEntityInList(checkedName,fesCheck)) {
                        FxmlLoader object = new FxmlLoader();
                        Pane view = object.getPane("festivalScene",selectedEntity);
                        mainBorder.setCenter(view);
                        searchBar.setVisible(false);
                        backButton.setVisible(true);
                    }
                    if (checkEntityInList(checkedName,evnCheck)) {
                        FxmlLoader object = new FxmlLoader();
                        Pane view = object.getPane("eventScene",selectedEntity);
                        mainBorder.setCenter(view);
                        searchBar.setVisible(false);
                        backButton.setVisible(true);
                    }
                }
            }
        });*/


    }

    void tableViewAction(){
        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Kiểm tra xem người dùng đã nhấp đúp chuột hay chưa
                Entity selectedEntity = tableView.getSelectionModel().getSelectedItem();
                if (selectedEntity != null) {
                    String checkedName = selectedEntity.getName();
                    ObservableList<Entity> govCheck = FXCollections.observableArrayList(governments);
                    ObservableList<Entity> chrCheck = FXCollections.observableArrayList(characters);
                    ObservableList<Entity> monuCheck = FXCollections.observableArrayList(monument);
                    ObservableList<Entity> fesCheck = FXCollections.observableArrayList(festival);
                    ObservableList<Entity> evnCheck = FXCollections.observableArrayList(events);
                    if (checkEntityInList(checkedName,chrCheck)) {
                        FxmlLoader object = new FxmlLoader();
                        Pane view = object.getPane("figureScene",selectedEntity);
                        mainBorder.setCenter(view);
                        searchBar.setVisible(false);
                        backButton.setVisible(true);
                    }
                    if (checkEntityInList(checkedName, govCheck)) {
                        FxmlLoader object = new FxmlLoader();
                        Pane view = object.getPane("governmentScene",selectedEntity);
                        mainBorder.setCenter(view);
                        searchBar.setVisible(false);
                        backButton.setVisible(true);

                    }
                    if (checkEntityInList(checkedName,monuCheck)) {
                        FxmlLoader object = new FxmlLoader();
                        Pane view = object.getPane("placeScene",selectedEntity);
                        mainBorder.setCenter(view);
                        searchBar.setVisible(false);
                        backButton.setVisible(true);
                    }
                    if (checkEntityInList(checkedName,fesCheck)) {
                        FxmlLoader object = new FxmlLoader();
                        Pane view = object.getPane("festivalScene",selectedEntity);
                        mainBorder.setCenter(view);
                        searchBar.setVisible(false);
                        backButton.setVisible(true);
                    }
                    if (checkEntityInList(checkedName,evnCheck)) {
                        FxmlLoader object = new FxmlLoader();
                        Pane view = object.getPane("eventScene",selectedEntity);
                        mainBorder.setCenter(view);
                        searchBar.setVisible(false);
                        backButton.setVisible(true);
                    }
                }
            }
        });
    }

    @FXML
    void search(ActionEvent event) {

        FilteredList<Entity> filteredList = new FilteredList<>(selectedList, b -> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(entity -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String searchKeyWord = newValue.toLowerCase();
                if (entity.getName().toLowerCase().indexOf(searchKeyWord) > -1) {
                    return true;
                } else if (entity.getDescription().toLowerCase().indexOf(searchKeyWord) > -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Entity> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedList);
    }

    @FXML
    void showCharacterList(ActionEvent event) {
        // Tạo danh sách muốn hiển thị
        selectedList.clear();
        selectedList.addAll(characters);
        nameCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("name"));
        desCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("description"));
        tableView.setItems(selectedList);
        tableViewAction();
    }

    @FXML
    public void showDynastyList(ActionEvent event) {
        selectedList.clear();
        selectedList.addAll(governments);
        nameCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("name"));
        desCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("description"));
        tableView.setItems(selectedList);
        tableViewAction();
    }

    @FXML
    public void showMonumentList(ActionEvent event) {

        selectedList.clear();
        selectedList.addAll(monument);
        // Hiển thị danh sách lên ListView
        nameCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("name"));
        desCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("description"));
        tableView.setItems(selectedList);
        tableViewAction();
    }

    @FXML
    public void showFestivalList(ActionEvent event) {

        selectedList.clear();
        selectedList.addAll(festival);
        // Hiển thị danh sách lên ListView
        nameCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("name"));
        desCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("description"));
        tableView.setItems(selectedList);
        tableViewAction();
    }

    @FXML
    public void showEventList(ActionEvent event) {

        selectedList.clear();
        selectedList.addAll(events);
        // Hiển thị danh sách lên ListView
        nameCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("name"));
        desCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("description"));
        tableView.setItems(selectedList);
        tableViewAction();
    }


    public void setHyperLink(Hyperlink itemToHyperlink){


        itemToHyperlink.setOnAction(event -> {
            ObservableList<Entity> govCheck = FXCollections.observableArrayList(governments);
            ObservableList<Entity> chrCheck = FXCollections.observableArrayList(characters);
            ObservableList<Entity> monuCheck = FXCollections.observableArrayList(monument);
            ObservableList<Entity> fesCheck = FXCollections.observableArrayList(festival);
            ObservableList<Entity> evnCheck = FXCollections.observableArrayList(events);
            Entity foundEntity = null;

            for (Entity entity : chrCheck) {
                if (entity.getName().equals(itemToHyperlink.getText())) {
                    foundEntity = entity;
                    break;
                }
            }
            System.out.println(foundEntity.getDescription());
            if (checkEntityInList(itemToHyperlink.getText(),chrCheck)) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPane("figureScene",foundEntity);
                mainBorder.setCenter(view);
                searchBar.setVisible(false);
                backButton.setVisible(true);
            }
            /*
            if (checkEntityInList(itemToHyperlink.getText(), govCheck)) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPane("governmentScene",foundEntity);
                mainBorder.setCenter(view);
                searchBar.setVisible(false);
                backButton.setVisible(true);

            }

            if (checkEntityInList(itemToHyperlink.getText(),monuCheck)) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPane("placeScene",itemToHyperlink);
                mainBorder.setCenter(view);
                searchBar.setVisible(false);
                backButton.setVisible(true);
            }
            if (checkEntityInList(itemToHyperlink.getText(),fesCheck)) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPane("festivalScene",itemToHyperlink);
                mainBorder.setCenter(view);
                searchBar.setVisible(false);
                backButton.setVisible(true);
            }
            if (checkEntityInList(itemToHyperlink.getText(),evnCheck)) {
                FxmlLoader object = new FxmlLoader();
                Pane view = object.getPane("eventScene",itemToHyperlink);
                mainBorder.setCenter(view);
                searchBar.setVisible(false);
                backButton.setVisible(true);
            }*/
        });
    }

    public void backAction(ActionEvent Event) {
        //listView.setVisible(true);
        searchBar.setVisible(true);
        mainBorder.setCenter(tableView);
        backButton.setVisible(false);
    }
    public boolean checkEntityInList(String name , ObservableList<Entity> checkList){
        return checkList.stream()
                .map(Entity::getName)
                .anyMatch(name::equals);
    }
}