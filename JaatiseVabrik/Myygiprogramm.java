package JaatiseVabrik;

import java.util.ArrayList;

/**
 * Created by aleksandra on 02/02/2017.
 */
public class Myygiprogramm {
    ArrayList<KauplemisPaev> paevad = new ArrayList<>();
    double omahind;

    public Myygiprogramm(double omahind) {
        this.omahind = omahind;
    }

    public void lisaPaev(KauplemisPaev paev) {
        paevad.add(paev);
    }

    public int kokkuValjaSaadetud() {
        int saadetud = 0;
        for (KauplemisPaev paev : paevad) {
            saadetud += paev.getTooteidValjaSaadetud();
        }
        return saadetud;
    }

    public int kokkuMyydud() {
        int myydud = 0;
        for (KauplemisPaev paev : paevad) {
            myydud += paev.getTooteidMyydud();
        }
        return myydud;
    }

    public int poodidesSeisab() {
        int seisab = 0;
        for (KauplemisPaev paev : paevad) {
            seisab += (paev.getTooteidValjaSaadetud() - paev.getTooteidMyydud());
        }
        return seisab;
    }

    public int kauplemisPaevi() {
        return paevad.size();
    }

    public double koguKasum() {
        double kasum = 0;
        for (KauplemisPaev paev : paevad) {
            kasum += paevaKasum(paev);
        }
        return kasum;
    }

    // ideaalseks loen hinna, mille juures oli päevakasum suurim
    public double ideaalneHind() {
        double suurimPaevaKasum = 0;
        double suurimaPaevaKasumiPaevaHind = 0;
        for (KauplemisPaev paev : paevad) {
            double paevaKasum = paevaKasum(paev);
            if (suurimPaevaKasum < paevaKasum) {
                suurimPaevaKasum = paevaKasum;
                suurimaPaevaKasumiPaevaHind = paev.getHind();
            }
        }
        return suurimaPaevaKasumiPaevaHind;
    }

    // abimeetod, mida on kahes kohas vaja
    private double paevaKasum(KauplemisPaev paev) {
        double kasumYhestJaatisest = paev.getHind() - omahind;
        return kasumYhestJaatisest * paev.getTooteidMyydud();
    }
}
