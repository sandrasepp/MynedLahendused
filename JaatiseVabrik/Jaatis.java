package JaatiseVabrik;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Created by aleksandra on 02/02/2017.
 */
public class Jaatis extends Application {
    GridPane root = new GridPane();
    Label statistika = new Label();
    Myygiprogramm myygiprogramm = new Myygiprogramm(2.00);


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("LaGuun");

        joonistaLayout();

        primaryStage.setScene(new Scene(root, 500, 240));
        primaryStage.show();
    }

    private void joonistaLayout() {
        root.setHgap(5);
        root.setVgap(5);
        root.setAlignment(Pos.CENTER);

        lisaInput();
    }

    private void lisaInput() {
        TextField valjaSaadetudField = new TextField();
        root.add(new Label("Poodidesse saadetud"), 0, 0);
        root.add(valjaSaadetudField, 1, 0);

        TextField myydudField = new TextField();
        root.add(new Label("Maha Müüdud"), 0, 1);
        root.add(myydudField, 1, 1);

        TextField hindField = new TextField();
        root.add(new Label("Hind"), 0, 2);
        root.add(hindField, 1, 2);

        Button button = new Button("Lisa");
        root.add(button, 0, 3);
        button.setOnAction(e -> {
            int valjaSaadetud = Integer.parseInt(valjaSaadetudField.getText());
            int myydud = Integer.parseInt(myydudField.getText());
            double hind = Double.parseDouble(hindField.getText());
            KauplemisPaev paev = new KauplemisPaev(valjaSaadetud, myydud, hind);
            myygiprogramm.lisaPaev(paev);
            kuvaStatistika();

            // tühjenda väljad
            valjaSaadetudField.setText("");
            myydudField.setText("");
            hindField.setText("");
            // fookusta esimene väli uuesti
            valjaSaadetudField.requestFocus();
        });
        root.add(statistika, 1, 3);
    }

    private void kuvaStatistika() {
        String vastus = "";
        vastus += "Kokku välja saadetud: " + myygiprogramm.kokkuValjaSaadetud();
        vastus += "\nKokku ära ostetud: " + myygiprogramm.kokkuMyydud();
        vastus += "\nPoodides seisab: " + myygiprogramm.poodidesSeisab();
        vastus += "\nStatistika paevi: " + myygiprogramm.kauplemisPaevi();
        vastus += "\nKogukasum: " + myygiprogramm.koguKasum();
        vastus += "\nIdeaalne hind: " + myygiprogramm.ideaalneHind();
        statistika.setText(vastus);
    }
}
