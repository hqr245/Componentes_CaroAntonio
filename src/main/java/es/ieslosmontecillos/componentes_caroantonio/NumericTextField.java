package es.ieslosmontecillos.componentes_caroantonio;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Arrays;
import java.util.random.RandomGenerator;

public class NumericTextField extends TextField {


    @Override
    public void replaceText(int start, int end, String text) {
        System.out.println("Start "+ start + " End "+ end + " Text "+ text);
        if (text.matches("\\d*")) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text) {

        if (text.matches("[0-9]*\\.?[0-9]*")) {
            super.replaceSelection(text);
        }
    }
}