package es.ieslosmontecillos.componentes_caroantonio;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class CampoTextoBoton extends HBox {

    private ObjectProperty<EventHandler> enAccion = new SimpleObjectProperty<>();


    @FXML
    private TextField CampoTexto;

    @FXML
    private Button boton;
    public CampoTextoBoton() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("campotextoboton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);


        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        enAccion.set(e->{
            System.out.println("a");
        });


        boton.setOnAction((ActionEvent event) -> {
            enAccion.get().handle(event);
        });



    }

    public TextField getCampoTexto() {
        return CampoTexto;
    }
    public void setCampoTexto(TextField campoTexto) {
        this.CampoTexto = campoTexto;
    }

   public String getTexto() {
        return CampoTexto.getText();
   }


    public EventHandler getEnAccion() {
        return enAccion.get();
    }

    public ObjectProperty<EventHandler> enAccionProperty() {
        return enAccion;
    }

    public void setEnAccion(EventHandler enAccion) {
        this.enAccion.set(enAccion);
    }
}

