/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eby.mainactivity;

import com.eby.helper.MaterialButtonIcon;
import com.eby.mainform.MainFormTestController;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import java.util.Optional;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kairos.ActionBarDrawerToggle;
import org.kairos.Toolbar;
import org.kairos.components.MaterialButton;
import org.kairos.core.Activity;
import org.kairos.core.ActivityFactory;
import org.kairos.core.ActivityTransition;
import org.kairos.core.FragmentTransaction;
import org.kairos.core.SimpleWindowManager;
import org.kairos.core.WindowManager;
import org.kairos.layouts.DrawerLayout;

/**
 * FXML Controller class
 *
 * @author eby
 */
public class MaterialTestLoginController extends Activity {

    @FXML
    private AnchorPane paneParent;
    @FXML
    private Toolbar toolbar;
    @FXML
    private MaterialButton btnLogin;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private DrawerLayout drawer;
    @FXML
    private MaterialButton btnMaximize;
    @FXML
    private MaterialButton btnMinimize;
    @FXML
    private MaterialButton btnFullScreen;
    @FXML
    private MaterialButton btnClose;
    
    private ActivityFactory factory;
    private Stage stage;
    private double w, h;
    private Rectangle2D rec2;
    private SimpleWindowManager windowManager;
    @FXML
    private Pane paneNav;

    @Override
    public void onCreate() {
        super.onCreate();
        initValue();
        setContentView(getClass().getResource("/com/eby/mainactivity/MaterialTestLogin.fxml"));
        toolbar.setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Login To Your Account");
        toolbar.getStyleClass().addAll("tool-bar");
        
        setActionBar(toolbar);

        btnLogin.setContentDisplay(ContentDisplay.RIGHT);
        btnLogin.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.POWER), "20"));
        drawer.setDrawerListener(new ActionBarDrawerToggle(this, drawer, toolbar));
        initIcon();
        windowAction();
    }

    private void loginAction() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (txtUsername.getText().equals("eby") && txtPassword.getText().equals("eby")) {
            alert.setContentText("Login Berhasil");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            startActivity(MainFormTestController.class);
        } else {
            alert.setContentText("Login Gagal");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }
    }

    private void initValue() {
        stage = new Stage();
        rec2 = Screen.getPrimary().getVisualBounds();
        w = 0.1;
        h = 0.1;
    }

    private void initIcon() {
        btnFullScreen.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.FULLSCREEN), "30"));
        btnMaximize.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MAXIMIZE), "30"));
        btnMinimize.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MINIMIZE), "30"));
        btnClose.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.WINDOW_CLOSE), "30"));

        btnFullScreen.setStyle("-fx-text-fill: black");
        btnMaximize.setStyle("-fx-text-fill: black");
        btnMinimize.setStyle("-fx-text-fill: black");
        btnClose.setStyle("-fx-text-fill: black");

//        btnFullScreen.setContentDisplay(ContentDisplay.RIGHT);
//        btnMaximize.setContentDisplay(ContentDisplay.RIGHT);
//        btnMinimize.setContentDisplay(ContentDisplay.RIGHT);
//        btnClose.setContentDisplay(ContentDisplay.RIGHT);
    }

    private void windowAction() {
        Platform.runLater(() -> {
            btnLogin.setOnAction(event -> {
                this.loginAction();
            });

            btnLogin.setOnTouchReleased(event -> {
                this.loginAction();
            });

            btnClose.setOnAction(event -> {
                close();
            });

            btnClose.setOnTouchPressed(event -> {
                close();
            });

            btnFullScreen.setOnAction(event -> {
                fullScreen();
            });
            btnFullScreen.setOnTouchPressed(event -> {
                fullScreen();
            });

            btnMaximize.setOnAction(event -> {
                maximize();
            });
            btnMaximize.setOnTouchPressed(event -> {
                maximize();
            });

            btnMinimize.setOnAction(event -> {
                minimize();
            });
            btnMinimize.setOnTouchPressed(event -> {
                minimize();
            });
        });
    }

    private boolean confirmDialog() {
        boolean status = false;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Mau keluar? :D");
        alert.initStyle(StageStyle.UNDECORATED);
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK) {
            status = true;
        }
        return status;
    }

    private void close() {
        if (confirmDialog()) {
            System.exit(0);
            Platform.exit();
        }
    }

    private void maximize() {
        stage = (Stage) btnMaximize.getScene().getWindow();
        if (stage.isMaximized()) {
            if (w == rec2.getWidth() && h == rec2.getHeight()) {
                stage.setMaximized(false);
                stage.setHeight(720);
                stage.setWidth(1320);
                //setScreen berada di tengah2 layar
                stage.centerOnScreen();
                //mengganti css ketika sudah maximized
                btnMaximize.setText("MAXIMIZE");
                btnMaximize.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MAXIMIZE), "30"));
            } else {
                stage.setMaximized(false);
                btnMaximize.setText("MAXIMIZE");
                btnMaximize.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MAXIMIZE), "30"));

            }

        } else {
            stage.setMaximized(true);
            btnMaximize.setText("RESTORE");
            btnMaximize.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.WINDOW_RESTORE), "30"));
        }
    }

    private void minimize() {
        stage = (Stage) btnMinimize.getScene().getWindow();
        if (stage.isMaximized()) {
            w = rec2.getWidth();
            h = rec2.getHeight();
            stage.setMaximized(false);
            stage.setHeight(h);
            stage.setWidth(w);
            stage.centerOnScreen();
            Platform.runLater(() -> {
                stage.setIconified(true);
            });
        } else {
            stage.setIconified(true);
        }
    }

    private void fullScreen() {
        stage = (Stage) paneParent.getScene().getWindow();
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
            btnFullScreen.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.FULLSCREEN), "30"));
            btnFullScreen.setText("FULLSCREEN");
        } else {
            stage.setFullScreen(true);
            btnFullScreen.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.FULLSCREEN_EXIT), "30"));
            btnFullScreen.setText("EXIT FULLSCREEN");
        }
    }
}
