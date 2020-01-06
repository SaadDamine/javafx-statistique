/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindatabase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logindatabase.FXMLDocumentController;
import static logindatabase.DatabaseConnection.getYear;
import logindatabase.models.GetElement;
import static logindatabase.DatabaseConnection.getGender;
import static logindatabase.DatabaseConnection.OriginCity;
import static logindatabase.DatabaseConnection.getNationality;

/**
 * FXML Controller class
 *
 * @author mdami
 */
public class MainController implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private VBox boxLevel;
    @FXML
    private BarChart<String, Number> chartBarGenderPres;
    @FXML
    private StackedBarChart chartStackedBarNatPres;
    @FXML
    private StackedBarChart chartStackedBarOriginCityPres;
    @FXML
    private VBox boxLevel1;
    @FXML
    private HBox year;
    ArrayList<Integer> values = new ArrayList<>();
    ArrayList<String> lmdL = new ArrayList<>();
    ArrayList<String> ad_ajL = new ArrayList<>();
    @FXML
    private StackPane l1;
    @FXML
    private StackPane l2;
    @FXML
    private StackPane l3;
    @FXML
    private StackPane admin;
    @FXML
    private StackPane ajourne;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    public void setYear() {
        ObservableList<Integer> years = getYear();
        years.forEach((integer) -> {
            StackPane stackPane;
            Label label;
            label = new Label(integer + "");
            label.setStyle("  -fx-font-family: \"Comic Sans MS\";\n"
                    + "    -fx-font-size: 26px;\n"
                    + "    -fx-font-weight: bold;\n"
                    + "    -fx-text-fill: -base3;"
                    + "-fx-cursor: hand;\n");
            stackPane = new StackPane(label);
            stackPane.setOnMouseClicked((event) -> {
                if (!stackPane.getStyle().contains("BLUE")) {
                    values.add(integer);
                    stackPane.setStyle("-fx-pref-width: 150px;\n"
                            + "    -fx-pref-height: 150px;\n"
                            + "    -fx-background-color: BLUE;\n"
                            + "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 0, 0);\n"
                            + "    -fx-background-radius: 10;"
                            + "-fx-cursor: hand;\n"
                            + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 0, 0);");
                } else {
                    values.remove(integer);
                    stackPane.setStyle("-fx-pref-width: 150px;\n"
                            + "    -fx-pref-height: 150px;\n"
                            + "    -fx-background-color: #FFF;\n"
                            + "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 0, 0);\n"
                            + "    -fx-background-radius: 10;"
                            + "-fx-cursor: hand;\n"
                            + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 0, 0);");
                }
            });
            stackPane.setStyle("-fx-pref-width: 150px;\n"
                    + "    -fx-pref-height: 150px;\n"
                    + "    -fx-background-color: #FFF;\n"
                    + "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 0, 0);\n"
                    + "    -fx-background-radius: 10;"
                    + "-fx-cursor: hand;\n"
                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0, 0, 0);");
            label.setTextFill(Color.BLUE);
            year.getChildren().add(stackPane);
        });
    }

    @FXML
    private void level(MouseEvent event) {
        if (!values.isEmpty()) {
            if (event.getSource().equals(l1)) {
                if (lmdL.contains("1LMD")) {
                    l1.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                    lmdL.remove("1LMD");
                } else {
                    l1.setStyle("-fx-background-color: BLUE;");
                    lmdL.add("1LMD");
                    if (lmdL.contains("2LMD")) {
                        l2.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                        lmdL.remove("2LMD");
                    }
                    if (lmdL.contains("3LMD")) {
                        l3.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                        lmdL.remove("3LMD");
                    }
                }
            }
            if (event.getSource().equals(l2)) {
                if (lmdL.contains("2LMD")) {
                    l2.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                    lmdL.remove("2LMD");
                } else {
                    l2.setStyle("-fx-background-color: BLUE;");
                    lmdL.add("2LMD");
                    if (lmdL.contains("1LMD")) {
                        l1.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                        lmdL.remove("1LMD");
                    }
                    if (lmdL.contains("3LMD")) {
                        l3.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                        lmdL.remove("3LMD");
                    }
                }
            }
            if (event.getSource().equals(l3)) {
                if (lmdL.contains("3LMD")) {
                    l3.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                    lmdL.remove("3LMD");
                } else {
                    l3.setStyle("-fx-background-color: BLUE;");
                    lmdL.add("3LMD");
                    if (lmdL.contains("1LMD")) {
                        l1.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                        lmdL.remove("1LMD");
                    }
                    if (lmdL.contains("2LMD")) {
                        l2.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                        lmdL.remove("2LMD");
                    }
                }
            }
        } else {

        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setYear();
        l1.setStyle("-fx-background-color: BLUE;");
        lmdL.add("1LMD");
    }

    @FXML
    private void type(MouseEvent event) {
        if (!values.isEmpty()) {
            if (event.getSource().equals(admin)) {
                if (ad_ajL.contains("admin")) {
                    admin.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                    ad_ajL.remove("admin");
                } else {
                    admin.setStyle("-fx-background-color: BLUE;");
                    ad_ajL.add("admin");
                }
            }
            if (event.getSource().equals(ajourne)) {
                if (ad_ajL.contains("ajourné")) {
                    ajourne.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                    ad_ajL.remove("ajourné");
                } else {
                    ajourne.setStyle("-fx-background-color: BLUE;");
                    ad_ajL.add("ajourné");
                }
            }
        } else {
            if (ad_ajL.contains("ajourné")) {
                ajourne.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                ad_ajL.remove("ajourné");
            }
            if (ad_ajL.contains("ajourné")) {
                ajourne.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                ad_ajL.remove("ajourné");
            }
        }
    }

    public void testGender() {
        chartBarGenderPres.getData().clear();
        if (!values.isEmpty()) {
            ObservableList<GetElement> gender;
            if (ad_ajL.isEmpty() || ad_ajL.size() == 2) {

                for (Integer value : values) {
                    gender = getGender(value, lmdL.get(0));
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartBarGenderPres.getData().add(x);
                }
            } else if (!ad_ajL.isEmpty()) {

                for (Integer value : values) {
                    gender = getGender(value, ad_ajL.get(0), lmdL.get(0));
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartBarGenderPres.getData().add(x);
                }
            }
        }
    }

    public void testNationality() {
        chartStackedBarNatPres.getData().clear();
        if (!values.isEmpty()) {
            ObservableList<GetElement> gender;
            if (ad_ajL.isEmpty() || ad_ajL.size() == 2) {

                for (Integer value : values) {
                    gender = getNationality(value, lmdL.get(0));
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartStackedBarNatPres.getData().add(x);
                }
            } else if (!ad_ajL.isEmpty()) {

                for (Integer value : values) {
                    gender = getNationality(value, ad_ajL.get(0), lmdL.get(0));
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartStackedBarNatPres.getData().add(x);
                }
            }
        }
    }

    public void testOriginCity() {
        chartStackedBarOriginCityPres.getData().clear();
        if (!values.isEmpty()) {
            ObservableList<GetElement> gender;
            if (ad_ajL.isEmpty() || ad_ajL.size() == 2) {
                for (Integer value : values) {
                    gender = OriginCity(value, lmdL.get(0));
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartStackedBarOriginCityPres.getData().add(x);
                }
            } else if (!ad_ajL.isEmpty()) {
                for (Integer value : values) {
                    gender = OriginCity(value, ad_ajL.get(0), lmdL.get(0));
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartStackedBarOriginCityPres.getData().add(x);
                }
            }
        }
    }

    @FXML
    private void test(MouseEvent event) {
        testOriginCity();
        testGender();
        testNationality();
    }

    @FXML
    private void exit(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.TRANSPARENT);
            ((Node) (event.getSource())).getScene().getWindow().hide();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void next(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("module.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.TRANSPARENT);
            ((Node) (event.getSource())).getScene().getWindow().hide();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void pres(MouseEvent event) {
    }

}
