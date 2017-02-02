package JaatiseVabrik;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Date;

import static javafx.application.Application.launch;

/**
 * LaGuun Jäätisevabrik OÜ on oma kodukontorist välja kasvanud. Vaja oleks müügist paremat ülevaadet.
 * Nimelt oleks kasu programmist, mille sisse saab sisestada mitu toodet hommikul poodidesse saadeti,
 * mitu toodet õhtuks maha sai müüdud ja kolmandaks palju üks toode sel päeval maksis.
 * Ühe toote omahind on 2€. Näha on vaja statistikat:
 * - Palju kokku on tooted välja saadetud
 * - Palju on ära ostetud.
 * - Palju poodides seisab.
 * - Mitu päeva on statistikat peetud.
 * - Palju on kogukasum.
 * - Mis on ideaalne hind?
 */


public class Main {
    public static void main(String[] args) {
        launch(Jaatis.class, args);
    }
}