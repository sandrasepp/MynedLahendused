package LHV;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Dominus on 31.01.2017.
 */
public class Bilanss {
    ArrayList<Kulu> kulud = new ArrayList<>();
    double palk;

    public Bilanss(double palk) {
        this.palk = palk;
    }

    public void setPalk(double palk) {
        this.palk = palk;
        this.kulud.clear();
    }

    public boolean lisaKulu(Kulu kulu) {
        if (rahaJargi() > kulu.getSumma()) {
            kulud.add(kulu);
            return true;
        } else {
            return false;
        }
    }

    public double rahaJargi() {
        double kulutatud = 0;
        for (Kulu kulu : kulud) {
            kulutatud += kulu.getSumma();
        }
        return palk - kulutatud;
    }

    public String suurimKulu() {
        double suurimKulu = 0;
        String kuluNimetus = null;
        for (Kulu kulu : kulud) {
            if (suurimKulu < kulu.getSumma()) {
                suurimKulu = kulu.getSumma();
                kuluNimetus = kulu.getNimetus();
            }
        }
        return kuluNimetus;
    }

    public String suvalineKulu() {
        Random random = new Random();
        int index = random.nextInt(kulud.size());
        Kulu kulu = kulud.get(index);
        return kulu.getNimetus();
    }
}
