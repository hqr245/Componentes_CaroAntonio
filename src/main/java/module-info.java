module es.ieslosmontecillos.componentes_caroantonio {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.componentes_caroantonio to javafx.fxml;
    exports es.ieslosmontecillos.componentes_caroantonio;
}