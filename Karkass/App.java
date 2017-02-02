package Karkass;

/**
 * Created by aleksandra on 02/02/2017.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Date;

public class App extends Application {
    GridPane root = new GridPane();
    Label statistika = new Label();
    // BusinessObject obj = new BusinessObject();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Eksamiülesanne");

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
        TextField input1 = new TextField();
        root.add(new Label("Input 1"), 0, 0);
        root.add(input1, 1, 0);

        TextField input2 = new TextField();
        root.add(new Label("Input 2"), 0, 1);
        root.add(input2, 1, 1);

        Button button = new Button("Lisa");
        root.add(button, 0, 2);
        button.setOnAction(e -> {
            // obj.lisaUusAsi(input1.getText(), input2.getText());
            System.out.println(input1.getText() + "\t" + input2.getText()); // näidistegevus
            kuvaStatistika();

            // tühjenda väljad
            input1.setText("");
            input2.setText("");
            // fookusta esimene väli uuesti
            input1.requestFocus();
        });
        root.add(statistika, 1, 2);
    }

    private void kuvaStatistika() {
        String vastus = "";
        // vastus += "Keskmine on: " + obj.leiaKesmine();
        // vastus += "\nSuurim on: " + obj.leiaSuurim();
        vastus += new Date().toString(); // näidisvastus
        statistika.setText(vastus);
    }
}