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
/**
 * Timer component. This component extends from a label, and it's modified in order to act as a timer.
 * **/
public class Temporizador extends Label {

    private final Timeline timeline;
    private final IntegerProperty timer = new SimpleIntegerProperty();
    private final KeyValue kv = new KeyValue(timer, 0);
    private final ObjectProperty<EventHandler<ActionEvent>> onFinished = new SimpleObjectProperty<>();


    /**
     * Constructor of the timer, it's purpose is to instance the timer, duh
     * **/
    public Temporizador() {
        super();

        this.setText("Temporizador");
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

    /**
     * This method starts the timer.
     * **/
    public void play(){

        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(timer.get()),kv));

        timeline.play();
    }


    /**
     * This method Stops the timer.
     * **/
    public void stop(){

        timeline.stop();
    }


    /**
     * this method allows to get the timeLine field of the timer.
     * **/
    public Timeline getTimeline() {
        return timeline;
    }


    /**
     * this method allows to set the time of the timer. The value must be set on seconds
     * **/
    public void setTimer(int time) {
        timer.set(time);
    }

    /**
     *This method allows to get the time set on the timer at the moment of execution.
     **/
    public int getTimer() {
        return timer.get();
    }

    /**
     * This method allows to get the time property.
     **/
    public IntegerProperty timerProperty() {
        return timer;
    }


    /**
     * This method is used in order to get the EventHandler of the timer.
     **/
    public EventHandler<ActionEvent> getOnFinished() {
        return onFinished.get();
    }

    /**
     * This method is used in order to get the OnFinishedProperty of the timer
     **/
    public ObjectProperty<EventHandler<ActionEvent>> onFinishedProperty() {
        return onFinished;
    }

    /**
     * This method is used in order to set the action that will occur just after the timer ends up
     **/
    public void setOnFinished(EventHandler<ActionEvent> onFinished) {
        this.onFinished.set(onFinished);
    }

}
