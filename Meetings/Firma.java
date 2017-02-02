package Meetings;

import java.util.ArrayList;

/**
 * Created by aleksandra on 02/02/2017.
 */
public class Firma {
    ArrayList<Koosolek> koosolekud = new ArrayList<>();

    public void lisaKoosolek(Koosolek koosolek) {
        koosolekud.add(koosolek);
    }

    public int koosolekuteArv() {
        return koosolekud.size();
    }

    public int koosolekuteKestus() {
        int kestus = 0;
        for (Koosolek koosolek : koosolekud) {
            kestus += koosolek.getAeg();
        }
        return kestus;
//    return koosolekud.stream().mapToInt(Koosolek::getAeg).sum();
    }


    public long onnestunudKoosolekuid() {
        return koosolekud.stream().filter(Koosolek::isOnnestus).count();
    }

    public double onnestunuteProtsent() {
//    return (1000 * onnestunudKoosolekuid() / koosolekuteArv()) / 10.0;
        return 100.0 * onnestunudKoosolekuid() / koosolekuteArv();
    }


    public int edukaidTunde() {
        int tunde = 0;
        for (Koosolek koosolek : koosolekud) {
            if (koosolek.isOnnestus()) {
                tunde += koosolek.getAeg();
            }
        }
        return tunde;
/*
    return koosolekud.stream()
            .filter(Koosolek::isOnnestus)
            .mapToInt(Koosolek::getAeg)
            .sum();
*/
    }

    public double edukateTundideProtsent() {
        return (1000 * edukaidTunde() / koosolekuteKestus()) / 10.0;
    }
}
