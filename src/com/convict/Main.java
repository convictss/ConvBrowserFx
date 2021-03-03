package com.convict;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("index.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("ConvBrowser");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();

        Controller controller = loader.getController();
        TextField tf = controller.urlTextField;
        WebView wv = controller.webView;
        wv.getEngine().getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> tf.setText(wv.getEngine().getLocation()));
        controller.home();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
