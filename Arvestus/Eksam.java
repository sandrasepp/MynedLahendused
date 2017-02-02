package Arvestus;

import java.util.ArrayList;

/**
 * Created by aleksandra on 01/02/2017.
 */
public class Eksam {

    ArrayList <Tudeng> tudengid = new ArrayList<>();
    int lavi;

    public Eksam(int lavi) {
        this.lavi = lavi;
    }

    public void lisaTudeng(Tudeng tudeng) {
        tudengid.add(tudeng);
    }

    public double labimisProtsent() throws TudengeidPoleException {
        if (tudengid.isEmpty()) {
            throw new TudengeidPoleException();
        }

        double labisid = 0;
        for (Tudeng tudeng : tudengid) {
            if (tudeng.getHinne() >= lavi) {
                labisid++;
            }
        }
        return 100 * labisid / tudengid.size();
    }

    public Tudeng parimTudeng() throws TudengeidPoleException {
        if (tudengid.isEmpty()) {
            throw new TudengeidPoleException();
        }
        Tudeng parim = null;
        for (Tudeng tudeng : tudengid) {
            if (parim == null || tudeng.getHinne() > parim.getHinne()) {
                parim = tudeng;
            }
        }
        return parim;
    }

    public String sobivus() throws TudengeidPoleException {
        double protsent = labimisProtsent();
        if (protsent < 50) {
            return "Liiga raske eksam";
        }
        if (protsent < 60) {
            return "Raske eksam";
        }
        if (protsent > 80) {
            return "Kerge eksam";
        }
        if (protsent > 90) {
            return "Liiga kerge eksam";
        }
        return "Paraja raskusega eksam";
    }
}
