package es.ieslosmontecillos.componentes_caroantonio;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Temporizador extends Label {

    private final Timeline timeline;
    private final IntegerProperty duration = new SimpleIntegerProperty();

    private final ObjectProperty<EventHandler> manejadorProperty = new SimpleObjectProperty<>();

    public Temporizador() {
        super();
        KeyFrame keyFrame= new KeyFrame(Duration.seconds(duration.get()));
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(1);
        this.textProperty().bind(timeline.currentTimeProperty().asString());
        timeline.setOnFinished( event -> {
            manejadorProperty.get().handle(event);
        });

    }

   public void play(){
        timeline.play();
    }
    public void pause(){
        timeline.pause();
    }
    public void stop(){
        timeline.stop();
    }


    public int getDuration() {
        return duration.get();
    }
    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public ObjectProperty<EventHandler> manejadorProperty() {

        return manejadorProperty;
    }

    public void setManejador(EventHandler manejador) {
        this.manejadorProperty.set(manejador);
    }
    public EventHandler getManejador() {
        return manejadorProperty.get();
    }


    public Timeline getTimeline() {
        return timeline;
    }
}
