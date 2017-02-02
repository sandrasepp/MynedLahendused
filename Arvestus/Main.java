package Arvestus;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Eksamil on 70 tudengit. Kõik saavad mingi hinde. Vaja on lahendust, kuhu saab iga hinde sisestada
 * koos tudengi nimega, mis väljastab statistikat:
 * - Mitu protsenti läbis eksami.
 * - Eksami raskusastme sobivus (ideaalis saab 70% tudengitest läbi).
 * - Millisel tudengil tuli parim tulemus.
 */
public class Main extends Application {

    Eksam eksam = new Eksam(70);
    Label statistika = new Label();
    GridPane root = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Eksam");
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);

        root.add(statistika, 1, 3);

        lisaTudengiLisaja();
        lisaTudengid();
        kuvaStatistika();

        primaryStage.setScene(new Scene(root, 400, 130));
        primaryStage.show();
    }

    private void lisaTudengiLisaja() {
        TextField nimi = new TextField();
        root.add(new Label("Nimi"), 0, 1);
        root.add(nimi, 1, 1);

        TextField hinne = new TextField();
        root.add(new Label("Hinne (0..100)"), 0, 2);
        root.add(hinne, 1, 2);
        Button lisaTudeng = new Button("Lisa");
        root.add(lisaTudeng, 0, 3);
        lisaTudeng.setOnAction(e -> {
            try {
                eksam.lisaTudeng(new Tudeng(nimi.getText(), Integer.parseInt(hinne.getText())));
                nimi.setText("");
                hinne.setText("");
                kuvaStatistika();
                nimi.requestFocus();
            } catch (NumberFormatException e1) {
                new Alert(Alert.AlertType.ERROR, "Vigane hinne").showAndWait();
            }
        });
    }

    private void lisaTudengid() {
        Random random = new Random();
        for (int i = 0; i < 70; i++) {
            eksam.lisaTudeng(new Tudeng("Tudeng_" + i, 51 + random.nextInt(50)));
        }
    }

    private void kuvaStatistika() {
        try {
            Tudeng tudeng = eksam.parimTudeng();
            String vastus = "";
            vastus += "Läbivuse protsent: " + (Math.round(10 * eksam.labimisProtsent()) / 10.0);
            vastus += "\nHinnang: " + eksam.sobivus();
            vastus += "\nParim tudeng: " + (tudeng.getNimi() + " (" + tudeng.getHinne() + ")");

            statistika.setText(vastus);
        } catch (TudengeidPoleException e) {
            statistika.setText("Tudengeid pole");
        }
    }
}
