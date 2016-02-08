/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eby.main;

import com.eby.mainactivity.MaterialTestLoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kairos.components.MaterialButton;
import org.kairos.core.ActivityFactory;

/**
 *
 * @author eby
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        ActivityFactory factory = new ActivityFactory(primaryStage);
        primaryStage.getScene().getStylesheets().add(MaterialButton.class.getResource("controls.css").toExternalForm());
        factory.startActivity(MaterialTestLoginController.class);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
