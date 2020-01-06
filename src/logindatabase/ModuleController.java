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
import static logindatabase.DatabaseConnection.ModulesAdmin;
import static logindatabase.DatabaseConnection.ModulesAdminEx;
import static logindatabase.DatabaseConnection.ModulesAdminTd;
import static logindatabase.DatabaseConnection.ModulesAdminTp;
import static logindatabase.DatabaseConnection.ModulesAjourné;
import static logindatabase.DatabaseConnection.ModulesAjournéEx;
import static logindatabase.DatabaseConnection.ModulesAjournéTd;
import static logindatabase.DatabaseConnection.ModulesAjournéTp;
import static logindatabase.DatabaseConnection.getYearModl;
import logindatabase.models.GetElement;

/**
 * FXML Controller class
 *
 * @author mdami
 */
public class ModuleController implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private HBox year;
    @FXML
    private BarChart<String, Integer> chartBarGenderPres;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private VBox boxLevel1;
    @FXML
    private StackPane admin;
    @FXML
    private StackPane ajourne;
    ArrayList<Integer> values = new ArrayList<>();
    ArrayList<String> ad_ajL = new ArrayList<>();
    @FXML
    private BarChart<String, Integer> chartBarEx;
    @FXML
    private BarChart<String, Integer> chartBarTd;
    @FXML
    private BarChart<String, Integer> chartBarTp;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setYear();
        admin.setStyle("-fx-background-color: BLUE;");
        ad_ajL.add("admin");
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
    private void type(MouseEvent event) {
        if (!values.isEmpty()) {
            if (event.getSource().equals(admin)) {
                if (ad_ajL.contains("admin")) {
                    admin.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                    ad_ajL.remove("admin");
                } else {
                    admin.setStyle("-fx-background-color: BLUE;");
                    ad_ajL.add("admin");
                    if (ad_ajL.contains("ajourné")) {
                        ajourne.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                        ad_ajL.remove("ajourné");
                    }
                }
            }
            if (event.getSource().equals(ajourne)) {
                if (ad_ajL.contains("ajourné")) {
                    ajourne.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                    ad_ajL.remove("ajourné");
                } else {
                    ajourne.setStyle("-fx-background-color: BLUE;");
                    ad_ajL.add("ajourné");
                    if (ad_ajL.contains("admin")) {
                        admin.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);");
                        ad_ajL.remove("admin");
                    }
                }
            }
        }
    }

    public void setYear() {
        ObservableList<Integer> years = getYearModl();
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

    public void testModulesAdmin() {
        chartBarGenderPres.getData().clear();
        if (!values.isEmpty()) {
            ObservableList<GetElement> gender;
            if ("admin".equals(ad_ajL.get(0))) {
                for (Integer value : values) {
                    gender = ModulesAdmin(value);
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartBarGenderPres.getData().add(x);
                }
            } else {
                for (Integer value : values) {
                    gender = ModulesAjourné(value);
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

    public void testModulesAdminEx() {
        chartBarEx.getData().clear();
        if (!values.isEmpty()) {
            ObservableList<GetElement> gender;
            if ("admin".equals(ad_ajL.get(0))) {
                for (Integer value : values) {
                    gender = ModulesAdminEx(value);
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartBarEx.getData().add(x);
                }
            } else {
                for (Integer value : values) {
                    gender = ModulesAjournéEx(value);
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartBarEx.getData().add(x);
                }
            }
        }
    }

    public void testModulesAdminTd() {
        chartBarTd.getData().clear();
        if (!values.isEmpty()) {
            ObservableList<GetElement> gender;
            if ("admin".equals(ad_ajL.get(0))) {
                for (Integer value : values) {
                    gender = ModulesAdminTd(value);
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartBarTd.getData().add(x);
                }
            } else {
                for (Integer value : values) {
                    gender = ModulesAjournéTd(value);
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartBarTd.getData().add(x);
                }
            }
        }
    }

    public void testModulesAdminTp() {
        chartBarTp.getData().clear();
        if (!values.isEmpty()) {
            ObservableList<GetElement> gender;
            if ("admin".equals(ad_ajL.get(0))) {
                for (Integer value : values) {
                    gender = ModulesAdminTp(value);
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartBarTp.getData().add(x);
                }
            } else {
                for (Integer value : values) {
                    gender = ModulesAjournéTp(value);
                    XYChart.Series x = new XYChart.Series<>();
                    x.setName(value + "");
                    for (GetElement getGender : gender) {
                        x.getData().add(new XYChart.Data<>(getGender.getElement(), getGender.getCount()));
                    }
                    chartBarTp.getData().add(x);
                }
            }
        }
    }

    @FXML
    private void test(MouseEvent event) {
        testModulesAdmin();
        testModulesAdminEx();
        testModulesAdminTd();
        testModulesAdminTp();
    }

    @FXML
    private void next(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sp.fxml"));
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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainSecond.fxml"));
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

}
