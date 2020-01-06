/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindatabase;

import java.io.IOException;
import java.math.BigDecimal;
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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static logindatabase.DatabaseConnection.getStudent;
import logindatabase.models.moy_math_info;

/**
 * FXML Controller class
 *
 * @author mdami
 */
public class SpMIController implements Initializable {

    ArrayList<Integer> values = new ArrayList<>();
    @FXML
    private ListView<BigDecimal> math;
    @FXML
    private ListView<BigDecimal> info;
    @FXML
    private ListView<BigDecimal> std_ch;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<moy_math_info> student = getStudent(2011);
        for (moy_math_info object : student) {
            if (object.isSp()) {
                math.getItems().add(object.getId_std());
            } else {
                info.getItems().add(object.getId_std());
            }
            if (object.isEq()) {
                std_ch.getItems().add(object.getId_std());
            }
        }
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
    }

    @FXML
    private void pres(MouseEvent event) {
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

}
