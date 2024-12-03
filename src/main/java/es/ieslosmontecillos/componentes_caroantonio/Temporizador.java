package es.ieslosmontecillos.componentes_caroantonio;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Temporizador extends Label {

    private final Timeline timeline;
    private final IntegerProperty timer = new SimpleIntegerProperty();
    private final KeyValue kv = new KeyValue(timer, 0);

    private final ObjectProperty<EventHandler<ActionEvent>> onFinished = new SimpleObjectProperty<>();


    public Temporizador() {
        super();

        onFinished.set(Event::consume);


        KeyFrame kf = new KeyFrame(Duration.seconds(timer.get()), kv);


       timer.addListener((observable, oldValue, newValue) -> {
           setText("Quedan "+newValue+" s");
       });


       timeline = new Timeline(kf);
       timeline.setCycleCount(1);

       timeline.setOnFinished(event -> {

           onFinished.get().handle(event);

        });

    }

    public void play(){

        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(timer.get()),kv));

        timeline.play();
    }


    public void stop(){

        timeline.stop();
    }


    public Timeline getTimeline() {
        return timeline;
    }


    public void setTimer(int time) {
        timer.set(time);
    }

    public int getTimer() {
        return timer.get();
    }

    public IntegerProperty timerProperty() {
        return timer;
    }


    public EventHandler<ActionEvent> getOnFinished() {
        return onFinished.get();
    }

    public ObjectProperty<EventHandler<ActionEvent>> onFinishedProperty() {
        return onFinished;
    }

    public void setOnFinished(EventHandler<ActionEvent> onFinished) {
        this.onFinished.set(onFinished);
    }

}
