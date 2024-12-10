package es.ieslosmontecillos.componentes_caroantonio;

import javafx.animation.Animation;
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
import org.w3c.dom.css.RGBColor;

public class Temporizador2 extends Label {

    private final Timeline timeline;
    private final IntegerProperty timer = new SimpleIntegerProperty();


    private final IntegerProperty red = new SimpleIntegerProperty();
    private final IntegerProperty green = new SimpleIntegerProperty(255);



    private final KeyValue keyValueTimer = new KeyValue(timer, 0);

    private final KeyValue redKeyValue = new KeyValue(red, 255);
    private final KeyValue greenKeyValue = new KeyValue(green, 255);
    private final KeyValue greenToZeroKeyValue = new KeyValue(green, 0);



    private final ObjectProperty<EventHandler<ActionEvent>> onFinished = new SimpleObjectProperty<>();



    public Temporizador2() {
        super();

        this.setText("Temporizador");
        onFinished.set(Event::consume);



        timer.addListener((observable, oldValue, newValue) -> {
            setText("Quedan "+newValue+" s");
        });


        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);

        timeline.setOnFinished(event -> {

            onFinished.get().handle(event);

        });


        red.addListener((observable, oldValue, newValue) -> {
           changeColor(newValue.intValue(),green.get(),0);
        });

        green.addListener((observable, oldValue, newValue) -> {
            changeColor(red.get(),newValue.intValue(),0);
        });

    }

    public void play(){

        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(timer.get()),keyValueTimer,greenToZeroKeyValue));
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(timer.get()/2f),greenKeyValue,redKeyValue));

        timeline.play();
    }


    private void changeColor(int red, int green, int blue){

        this.setStyle("-fx-text-fill: rgb(" + red + "," + green + "," + blue + ");-fx-background-color: #000000");


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
