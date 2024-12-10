package es.ieslosmontecillos.componentes_caroantonio;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CustomTextFieldSample extends Application {

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);
        stage.setTitle("Text Field Sample");

        HBox hbox = new HBox();

      Temporizador2 t1 = new Temporizador2();

      t1.setTimer(10);




      t1.play();

        hbox.getChildren().addAll(t1);
        scene.setRoot(hbox);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}