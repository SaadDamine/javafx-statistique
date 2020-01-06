package logindatabase;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author JISOO
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane layersignup;
    @FXML
    private AnchorPane layer2;
    @FXML
    private JFXButton signin;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label s1;
    @FXML
    private Label s2;
    @FXML
    private Label s3;
    @FXML
    private JFXButton signup;
    @FXML
    private Label a2;
    @FXML
    private Label b2;
    @FXML
    private JFXButton btnsignup;
    @FXML
    private JFXButton btnsignin;
    @FXML
    private TextField u1;
    @FXML
    private TextField n2;
    @FXML
    private AnchorPane layer1;
    @FXML
    private ImageView im1;
    @FXML
    private ImageView im2;
    @FXML
    private ImageView exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        s1.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        signup.setVisible(false);
        b2.setVisible(false);
        btnsignin.setVisible(false);
        im1.setVisible(true);
        im2.setVisible(false);

    }

    @FXML
    private void btn(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(491);
        slide.play();

        layer1.setTranslateX(-309);
        btnsignin.setVisible(true);

        b2.setVisible(true);
        s1.setVisible(true);
        s2.setVisible(true);
        s3.setVisible(true);
        signup.setVisible(true);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        signin.setVisible(false);
        a2.setVisible(false);
        btnsignup.setVisible(false);
        u1.setText("");
        n2.setText("");
        im1.setVisible(true);
        im2.setVisible(false);
        slide.setOnFinished((e -> {

        }));
    }

    @FXML
    private void btn2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(0);
        slide.play();

        layer1.setTranslateX(0);
        btnsignin.setVisible(false);
        b2.setVisible(false);
        s1.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        signup.setVisible(false);
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        signin.setVisible(true);
        a2.setVisible(true);
        btnsignup.setVisible(true);
        u1.setText("");
        n2.setText("");
        im1.setVisible(false);
        im2.setVisible(true);
        slide.setOnFinished((e -> {

        }));
    }

    @FXML
    private void btnsignup(MouseEvent event) {
    }

    @FXML
    private void sign(MouseEvent event) {

    }

    @FXML
    private void click(ActionEvent event) {
        if ("damine".equals(u1.getText()) && "123".equals(n2.getText())) {
            try {
                String tilte = "Sign In";
                String message = u1.getText();
                TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainSecond.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.initStyle(StageStyle.TRANSPARENT);
                ((Node) (event.getSource())).getScene().getWindow().hide();
                stage.show();

                tray.setAnimationType(type);
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(3000));
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!"damine".equals(u1.getText())) {
            String tilte = "Sign In";
            String message = "Error Username " + "'" + u1.getText() + "'" + " Wrong";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }
        if (!"123".equals(n2.getText())) {
            String tilte = "Sign In";
            String message = "Error Password " + "'" + n2.getText() + "'" + " Wrong";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }
        if (!"damine".equals(u1.getText()) && !"123".equals(n2.getText())) {
            String tilte = "Sign In";
            String message = "Error Username " + "'" + u1.getText() + "'" + ", and Password " + "'" + n2.getText() + "'" + " Wrong";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));
        }
    }

    @FXML
    private void exit(MouseEvent event) {
        System.exit(0);
    }
}
