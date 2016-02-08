/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eby.productmenu;

import com.eby.helper.MaterialButtonIcon;
import com.eby.mainform.MainFormTestController;
import com.eby.productmenu.redirect.ProductRedirectController;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.layout.AnchorPane;
import org.kairos.components.MaterialButton;
import org.kairos.core.Activity;
import org.kairos.core.Fragment;
import org.kairos.core.FragmentTransaction;

import org.kairos.components.MaterialButton;
import org.kairos.core.Activity;
import org.kairos.core.Fragment;

/**
 * FXML Controller class
 *
 * @author eby
 */
public class ProductMenuController extends Fragment {

    @FXML
    private AnchorPane paneView;
    @FXML
    private MaterialButton btnProduct;
    @FXML
    private MaterialButton btnSuppliers;
    @FXML
    private MaterialButton btnBrand;
    @FXML
    private MaterialButton btnCategory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void onCreateView(FXMLLoader fxmll) {
        fxmll.setLocation(getClass().getResource("ProductMenu.fxml"));
        try {
            fxmll.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        onAction();
        setIcon();
    }

    private void onAction() {
        Platform.runLater(() -> {
            btnProduct.setOnAction(e -> {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace("paneView", new ProductRedirectController());
                transaction.commit();
            });
        });
    }

    private void setIcon() {
        btnProduct.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.VIEW_MODULE), "72.2"));
        btnSuppliers.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.ACCOUNT_MULTIPLE), "72.2"));
        btnBrand.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.LAYERS), "72.2"));
        btnCategory.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.APPS), "72.2"));

    }

}
