/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eby.productmenu.redirect;

import com.eby.helper.MaterialButtonIcon;
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
import org.kairos.components.MaterialButton;
import org.kairos.core.Fragment;
import org.kairos.core.FragmentTransaction;

/**
 *
 * @author eby
 */
public class ProductRedirectController extends Fragment {

    @FXML
    private AnchorPane paneView;
    @FXML
    private MaterialButton btnBack;

    private FragmentTransaction transaction;

    @Override
    public void onCreateView(FXMLLoader fxmll) {
        fxmll.setLocation(getClass().getResource("/com/eby/productmenu/redirect/ProductRedirect.fxml"));
        try {
            fxmll.load();
        } catch (IOException ex) {
            Logger.getLogger(ProductRedirectController.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIcon();
        onAction();
    }

    public void onAction() {
        transaction = getFragmentManager().beginTransaction();
        Platform.runLater(() -> {
            btnBack.setOnAction(e -> {
                transaction.replace("paneView", new ProductMenuController());
                transaction.commit();
            });
        });
    }

    private void setIcon() {
        btnBack.setGraphic(MaterialButtonIcon.icon(new MaterialDesignIconView(MaterialDesignIcon.ARROW_LEFT), "20"));
    }
}
