module es.ieslosmontecillos.componentes_caroantonio {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.xml.dom;


    opens es.ieslosmontecillos.componentes_caroantonio to javafx.fxml;
    exports es.ieslosmontecillos.componentes_caroantonio;
}