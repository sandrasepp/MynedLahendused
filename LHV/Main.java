package LHV;

import LHV.Bilanss;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * LHVs on endiselt puudu kulude arvestaja. On vaja süsteemi, kuhu saab kuupalga
 * sisestada ja kulusid ükshaaval sisestada (koos kulu nimetusega).
 * Kulu sisestada ei saa kui raha selle jaoks ei jätku ja uue kuupalga sisestamisel
 * nullitakse varasemad andmed ära. Sooviks näha statistikat:
 * - Kui palju raha on alles
 * - Mis on kuu kõige suurem kulu
 * - Küsimus kuvada randomiga valitud kuluartikli kohta, et "kas äkki saaks sellest loobuda?"
 */
public class Main extends Application {
    GridPane root = new GridPane();
    Label statistika = new Label();
    Bilanss bilanss;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("LHV");

        joonistaLayout();

        primaryStage.setScene(new Scene(root, 500, 200));
        primaryStage.show();
    }

    private void joonistaLayout() {
        root.setHgap(5);
        root.setVgap(5);
        root.setAlignment(Pos.CENTER);

        lisaInput();
    }

    private void lisaInput() {
        TextField palk = new TextField();
        root.add(new Label("Palk"), 0, 0);
        root.add(palk, 1, 0);

        Button palgaLisamine = new Button("Lisa palk");
        palgaLisamine.setOnAction(e -> {
            bilanss = new Bilanss(Double.parseDouble(palk.getText()));
            kuvaStatistika(true);
        });
        root.add(palgaLisamine, 2, 0);

        TextField nimi = new TextField();
        root.add(new Label("Kulu nimetus"), 0, 1);
        root.add(nimi, 1, 1);

        TextField summa = new TextField();
        root.add(new Label("Summa"), 0, 2);
        root.add(summa, 1, 2);

        Button button = new Button("Lisa");
        root.add(button, 0, 3);
        button.setOnAction(e -> {
            boolean lisamineOnnestus = bilanss.lisaKulu(new Kulu(nimi.getText(),
                    Double.parseDouble(summa.getText())));
            kuvaStatistika(lisamineOnnestus);

            // tühjenda väljad
            nimi.setText("");
            summa.setText("");
            // fookusta esimene väli uuesti
            nimi.requestFocus();
        });
        root.add(statistika, 1, 3);
    }


    private void kuvaStatistika(boolean lisamineOnnestus) {
        String vastus = "Raha jargi: " + bilanss.rahaJargi()
                + "\nSuurim kulu: " + bilanss.suurimKulu();
        if (!lisamineOnnestus) {
            vastus += "\nEi saa lisada, eemaldaks äkki " + bilanss.suvalineKulu();
        }
        statistika.setText(vastus);
    }
}
