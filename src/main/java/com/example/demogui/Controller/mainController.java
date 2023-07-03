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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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
            new Character("Lý Thường Kiệt", "Tướng quân thời Lý", "13-09-1019", "17-08-1105", Arrays.asList("Nhà Lý"), Arrays.asList("Lý Nhật Tôn"), Arrays.asList("Tết Đoan Ngọ"), Arrays.asList("Thăng Long")),
            new Character("Trần Hưng Đạo", "Tướng quân thời Trần", "01-02-1228", "07-07-1300", Arrays.asList("Nhà Trần"), Arrays.asList("Trần Thánh Tông"), Arrays.asList("Lễ hội Đền Hùng"), Arrays.asList("Thăng Long", "Chi Lăng")),
            new Character("Lê Lợi", "Vua nhà Lê thứ nhất", "13-08-1385", "07-11-1433", Arrays.asList("Nhà Hậu Lê"), Arrays.asList("Lê Nguyên Khánh"), Arrays.asList("Tết Nguyên Đán"), Arrays.asList("Đông Kinh"))
    );
    ObservableList<Place> monument = FXCollections.observableArrayList(
            new Place("Đền Hùng", "Đền thờ tổ tiên của dân tộc Việt Nam", "đền", Arrays.asList("Lạc Long Quân", "Âu Cơ"), Arrays.asList("Lễ hội Đền Hùng"), Arrays.asList("Đánh Tây Âu"), Arrays.asList("Văn Lang", "Âu Lạc", "Nhà Hùng")),
            new Place("Thành cổ Quảng Trị", "Di tích lịch sử về cuộc chiến tranh Việt Nam", "thành cổ", Arrays.asList("Ngô Đình Diệm"), Arrays.asList(), Arrays.asList("Trận Quảng Trị"), Arrays.asList("Bắc Việt")),
            new Place("Lăng Chủ tịch Hồ Chí Minh", "Nghĩa trang và di tích lịch sử về Chủ tịch Hồ Chí Minh", "lăng", Arrays.asList("Hồ Chí Minh"), Arrays.asList(), Arrays.asList("Chiến tranh Việt Nam"), Arrays.asList("Việt Nam Cộng hòa", "Cộng hòa Xã hội Chủ nghĩa Việt Nam"))
    );
    ObservableList<Festival> festival = FXCollections.observableArrayList(
            new Festival("Lễ hội Đền Hùng", "Lễ hội tổ chức để tôn vinh các vua Hùng", "01-04", Arrays.asList("Phú Thọ"), Arrays.asList("Nhà Lý", "Nhà Trần", "Nhà Hậu Lê"), Arrays.asList("Lạc Long Quân", "Âu Cơ", "Hùng Vương"), Arrays.asList("Khởi đầu dân tộc", "Vua Hùng kính yêu")),
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
    }

    void tableViewAction(){
        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Kiểm tra xem người dùng đã nhấp đúp chuột hay chưa
                Entity selectedEntity = tableView.getSelectionModel().getSelectedItem();
                if (selectedEntity != null) {
                    handleClickedEvent(selectedEntity);
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
        searchBar.setVisible(true);
        mainBorder.setCenter(tableView);
        backButton.setVisible(false);
        search(event);
    }

    @FXML
    public void showDynastyList(ActionEvent event) {
        selectedList.clear();
        selectedList.addAll(governments);
        nameCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("name"));
        desCol.setCellValueFactory(new PropertyValueFactory<Entity, String>("description"));
        tableView.setItems(selectedList);
        tableViewAction();
        searchBar.setVisible(true);
        mainBorder.setCenter(tableView);
        backButton.setVisible(false);
        search(event);
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
        searchBar.setVisible(true);
        mainBorder.setCenter(tableView);
        backButton.setVisible(false);
        search(event);
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
        searchBar.setVisible(true);
        mainBorder.setCenter(tableView);
        backButton.setVisible(false);
        search(event);
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
        searchBar.setVisible(true);
        mainBorder.setCenter(tableView);
        backButton.setVisible(false);
        search(event);
    }


    public Hyperlink setHyperLink(String keyword ){
        Hyperlink itemToHyperlink = new Hyperlink(keyword);
        itemToHyperlink.setOnAction(event -> {
            ObservableList<Entity> govCheck = FXCollections.observableArrayList(governments);
            ObservableList<Entity> chrCheck = FXCollections.observableArrayList(characters);
            ObservableList<Entity> monuCheck = FXCollections.observableArrayList(monument);
            ObservableList<Entity> fesCheck = FXCollections.observableArrayList(festival);
            ObservableList<Entity> evnCheck = FXCollections.observableArrayList(events);
            Entity foundEntity = null;
            for (Entity entity : chrCheck) {
                if (entity.getName().equals(keyword)) {
                    foundEntity = entity;
                    break;
                }
            }
            for (Entity entity : govCheck) {
                if (entity.getName().equals(keyword)) {
                    foundEntity = entity;
                    break;
                }
            }
            for (Entity entity : monuCheck) {
                if (entity.getName().equals(keyword)) {
                    foundEntity = entity;
                    break;
                }
            }
            for (Entity entity : fesCheck) {
                if (entity.getName().equals(keyword)) {
                    foundEntity = entity;
                    break;
                }
            }
            for (Entity entity : evnCheck) {
                if (entity.getName().equals(keyword)) {
                    foundEntity = entity;
                    break;
                }
            }
            handleClickedEvent(foundEntity);
        });
        return itemToHyperlink;
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
    public void handleClickedEvent(Entity handleEntity){
        ObservableList<Entity> govCheck = FXCollections.observableArrayList(governments);
        ObservableList<Entity> chrCheck = FXCollections.observableArrayList(characters);
        ObservableList<Entity> monuCheck = FXCollections.observableArrayList(monument);
        ObservableList<Entity> fesCheck = FXCollections.observableArrayList(festival);
        ObservableList<Entity> evnCheck = FXCollections.observableArrayList(events);
        String checkedName = handleEntity.getName();
        if (checkEntityInList(checkedName,chrCheck)) {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("figureScene",handleEntity);
            mainBorder.setCenter(view);
            searchBar.setVisible(false);
            backButton.setVisible(true);
            Character handleCharacter = (Character) handleEntity;
            Label chrGovLabel = (Label) view.lookup("#chrGov");
            setHyperLinkForList(chrGovLabel ,handleCharacter.getcGovernment());
            Label chrRelLabel = (Label) view.lookup("#chrRel");
            setHyperLinkForList(chrRelLabel ,handleCharacter.getcRelatives());
            Label chrFesLabel = (Label) view.lookup("#chrFes");
            setHyperLinkForList(chrFesLabel ,handleCharacter.getcFestivals());
            Label chrPlaceLabel = (Label) view.lookup("#chrPlace");
            setHyperLinkForList(chrPlaceLabel,handleCharacter.getcPlaces());
        }

        if (checkEntityInList(checkedName, govCheck)) {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("governmentScene",handleEntity);
            mainBorder.setCenter(view);
            searchBar.setVisible(false);
            backButton.setVisible(true);
            Government handleGovernment = (Government) handleEntity;
            Label gFigLabel = (Label) view.lookup("#gFigure");
            setHyperLinkForList(gFigLabel ,handleGovernment.getGovFigures());
            Label gFes = (Label) view.lookup("#gFes");
            setHyperLinkForList(gFes ,handleGovernment.getGovFestivals());
            Label gPlace = (Label) view.lookup("#gPlace");
            setHyperLinkForList(gPlace ,handleGovernment.getGovPlaces());
            Label gEvent = (Label) view.lookup("#gEvent");
            setHyperLinkForList(gEvent ,handleGovernment.getGovEvents());
        }

        if (checkEntityInList(checkedName,monuCheck)) {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("placeScene",handleEntity);
            mainBorder.setCenter(view);
            searchBar.setVisible(false);
            backButton.setVisible(true);
            Place handlePlace = (Place) handleEntity;
            Label pFigLabel = (Label) view.lookup("#pFigure");
            setHyperLinkForList(pFigLabel ,handlePlace.getPlFigures());
            Label pFestivalLabel = (Label) view.lookup("#pFestival");
            setHyperLinkForList(pFestivalLabel ,handlePlace.getPlFestivals());
            Label pGovernmentsLabel = (Label) view.lookup("#pGovernments");
            setHyperLinkForList(pGovernmentsLabel ,handlePlace.getPlGovernments());
            Label pEventLabel = (Label) view.lookup("#pEvent");
            setHyperLinkForList(pEventLabel ,handlePlace.getPlEvents());
        }
        if (checkEntityInList(checkedName,fesCheck)) {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("festivalScene",handleEntity);
            mainBorder.setCenter(view);
            searchBar.setVisible(false);
            backButton.setVisible(true);
            Festival handleFestival = (Festival) handleEntity;
            Label fFigLabel = (Label) view.lookup("#fFig");
            setHyperLinkForList(fFigLabel ,handleFestival.getfFigures());
            Label fPlaceLabel = (Label) view.lookup("#fPlace");
            setHyperLinkForList(fPlaceLabel ,handleFestival.getfPlaces());
            Label fGovLabel = (Label) view.lookup("#fGov");
            setHyperLinkForList(fGovLabel ,handleFestival.getfGovernments());
            Label fEventLabel = (Label) view.lookup("#fEvent");
            setHyperLinkForList(fEventLabel ,handleFestival.getfEvents());
        }
        if (checkEntityInList(checkedName,evnCheck)) {
            FxmlLoader object = new FxmlLoader();
            Pane view = object.getPane("eventScene",handleEntity);
            mainBorder.setCenter(view);
            searchBar.setVisible(false);
            backButton.setVisible(true);
            Event handleEvent = (Event) handleEntity;
            Label fPlaceLabel = (Label) view.lookup("#ePlace");
            setHyperLinkForList(fPlaceLabel ,handleEvent.getEvPlace());
        }
    }
    public void setHyperLinkForList(Label handleLabel ,List<String> handleList){
        TextFlow textFlow = new TextFlow();
        for (int i = 0; i < handleList.size(); i++) {
            String keyword = handleList.get(i);
            Hyperlink hyperlink = setHyperLink(keyword);
            hyperlink.setFont(new Font(14));
            if (i > 0) {
                textFlow.getChildren().add(new Text("; "));
            }
            textFlow.getChildren().add(hyperlink);
        }
        handleLabel.setGraphic(textFlow);
    }
    @FXML
    public void showMenu(ActionEvent actionEvent) {
        Entity clone = new Entity(null,null);
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("menuScene",clone);
        mainBorder.setCenter(view);
        searchBar.setVisible(false);

    }
}