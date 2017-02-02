package Meetings;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by aleksandra on 02/02/2017.
 * /**
 * Firmades raisatakse palju aega ebaefektiivsete koosolekute peale. Loo tööriist, mis aitab hoida fookust ja teha otsuseid.
 * Lahenda see ülesanne nii kuidas soovid, järgnev on näide mida ise ette kujutaksin.
 * Koosoleku algataja saab sisestada teema, mida on vaja arutada ja aeg kaua selle arutamiseks maksimaalselt või kuluda.
 * Kui teema on arutatud saab kinnitada kas ajast suudeti kinni pidada ja kas mingi otsus sai vastu võetud. Statistikat mida sooviks näha:
 * - Kui efektiivne on firma oma koosolekutega.
 * - Mitu koosolekut on peetud ja mitu õnnestusid.
 * - Kui ei olda väga efektiivsed, siis ilmub motivatsioonilause.
 */

public class Main extends Application {
    GridPane root = new GridPane();
    Label statistika = new Label();
    Firma firma = new Firma();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Koosolek");

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
        TextField teema = new TextField();
        root.add(new Label("Teema"), 0, 0);
        root.add(teema, 1, 0);

        TextField aeg = new TextField();
        root.add(new Label("Aeg"), 0, 1);
        root.add(aeg, 1, 1);

        CheckBox edukas = new CheckBox("Õnnestus?");
        root.add(edukas, 2, 1);

        Button button = new Button("Lisa koosolek");
        root.add(button, 0, 2);
        button.setOnAction(e -> {
            Koosolek koosolek = new Koosolek();
            koosolek.setNimi(teema.getText());
            koosolek.setAeg(Integer.parseInt(aeg.getText()));
            koosolek.setOnnestus(edukas.isSelected());
            firma.lisaKoosolek(koosolek);
            kuvaStatistika();

            // tühjenda väljad
            teema.setText("");
            aeg.setText("");
            edukas.setSelected(false);
            // fookusta esimene väli uuesti
            teema.requestFocus();
        });

        root.add(statistika, 1, 2);
    }

    private void kuvaStatistika() {
        String vastus = "";
        vastus += "Koosolekute arv: " + firma.koosolekuteArv();

        vastus += "\nÕnnestunud koosolekuid: " + firma.onnestunudKoosolekuid();
        vastus += "\nÕnnestunute %: " + firma.onnestunuteProtsent();

        vastus += "\nEdukaid tunde: " + firma.edukaidTunde();
        double edukateTundideProtsent = firma.edukateTundideProtsent();
        vastus += "\nEdukate tundide %: " + edukateTundideProtsent;

        if (edukateTundideProtsent < 75) {
            vastus += "\nMake work, not meetings :)";
        }
        statistika.setText(vastus);
    }
}