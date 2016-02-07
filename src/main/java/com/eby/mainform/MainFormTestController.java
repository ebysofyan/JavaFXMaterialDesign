/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eby.mainform;

import com.eby.helper.MaterialButtonIcon;
import com.eby.mainactivity.MaterialTestLoginController;
import com.eby.productmenu.ProductMenuController;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.kairos.ActionBarDrawerToggle;
import org.kairos.FragmentStatePagerAdapter;
import org.kairos.Toolbar;
import org.kairos.components.MaterialButton;
import org.kairos.core.Activity;
import org.kairos.core.Fragment;
import org.kairos.core.FragmentTransaction;
import org.kairos.core.WindowManager;
import org.kairos.layouts.DrawerLayout;
import org.kairos.layouts.PagerAdapter;
import org.kairos.layouts.SlidingTabLayout;
import org.kairos.layouts.ViewPager;

/**
 *
 * @author eby
 */
public class MainFormTestController extends Activity {

    @FXML
    private AnchorPane paneParent;
    @FXML
    private DrawerLayout drawer;
    @FXML
    private Pane paneView;
    @FXML
    private Toolbar toolbar;
    @FXML
    private MaterialButton btnDashboard;
    @FXML
    private MaterialButton btnProduct;
    @FXML
    private MaterialButton btnSales;
    @FXML
    private MaterialButton btnReport;
    @FXML
    private MaterialButton btnSetting;
    @FXML
    private MaterialButton btnLogout;
    @FXML
    private Pane paneNav;

    @Override
    public void onCreate() {
        super.onCreate();
        setContentView(getClass().getResource("/com/eby/mainform/MainFormTest.fxml"));
        toolbar.setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Main Form Testing");
        toolbar.getStyleClass().addAll("tool-bar");
        setActionBar(toolbar);

        drawer.setDrawerListener(new ActionBarDrawerToggle(this, drawer, toolbar));
        initIcon();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add("paneView", new ProductMenuController());
        transaction.commit();

        Platform.runLater(() -> {
            btnLogout.setOnAction(e -> {
                logout();
            });

            btnLogout.setOnTouchPressed(e -> {
                logout();
            });
        });
    }

    private void initIcon() {
        btnDashboard.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.VIEW_DASHBOARD), "30"));
        btnProduct.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.DROPBOX), "30"));
        btnSales.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.SHOPPING), "30"));
        btnReport.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.CHART_LINE), "30"));
        btnSetting.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.SETTINGS), "30"));
        btnLogout.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.POWER), "30"));

        btnDashboard.setStyle("-fx-text-fill: black");
        btnProduct.setStyle("-fx-text-fill: black");
        btnSales.setStyle("-fx-text-fill: black");
        btnReport.setStyle("-fx-text-fill: black");
        btnSetting.setStyle("-fx-text-fill: black");
        btnLogout.setStyle("-fx-text-fill: black");

//        btnFullScreen.setContentDisplay(ContentDisplay.RIGHT);
//        btnMaximize.setContentDisplay(ContentDisplay.RIGHT);
//        btnMinimize.setContentDisplay(ContentDisplay.RIGHT);
//        btnClose.setContentDisplay(ContentDisplay.RIGHT);
    }

    public void logout() {
        startActivity(MaterialTestLoginController.class);
    }

}
