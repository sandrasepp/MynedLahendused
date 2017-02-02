package Ristmik;

/**
 * Created by aleksandra on 31/01/2017.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Kesklinn-Mustamäe-Tabasalu-Paldiski ringristmikule pisteti istuma liiklusmutt, kelle ülesandeks on lugeda
 * kokku palju autosi mis suunas sõidavad. Kuna liiklus on kiire, siis on tal vaja süsteemi, kus saab kiirelt
 * sisestada märke nii kui auto on ringilt väljunud mingis suunas.
 * Programm peaks väljastama järgnevat infot:
 * - Mitu autot kokku on läbi sõitnud.
 * - Kui palju autosid igas suunas liikus.
 * - Milline oli kõige populaarsem suund
 */
public class Main extends Application {
    GridPane root = new GridPane();
    Label statistika = new Label();
    Ristmik ristmik = new Ristmik();
    Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Ristmik");
        root.setAlignment(Pos.CENTER_LEFT);
        root.setHgap(5);
        root.setVgap(5);

        lisaNupp("Paldiski", 0);
        lisaNupp("Kesklinn", 1);
        lisaNupp("Tabasalu", 2);
        lisaNupp("Mustamäe", 3);

        root.add(statistika, 1, 0, 1, 4);

        primaryStage.setScene(new Scene(root, 550, 180));
        primaryStage.show();
    }

    private void lisaNupp(String suund, int indeks) {
        Button nupp = new Button(suund);
        root.add(nupp, 0, indeks);
        nupp.setOnAction(e -> {
            ristmik.lisaAuto(new Auto(suund));
            kuvaStatistika();
        });
    }

    private void kuvaStatistika() {
        String vastus = "";
        vastus += "Kokku autosid: " + ristmik.autosidKokku();
        vastus += "\nSuunad: " + ristmik.getSuunad();
        vastus += "\nPopulaarseim: " + ristmik.populaarseimSuund();
        statistika.setText(vastus);
    }
}
