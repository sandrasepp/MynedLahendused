package JaatiseVabrik;

/**
 * Created by aleksandra on 02/02/2017.
 */
public class KauplemisPaev {
    int tooteidValjaSaadetud;
    int tooteidMyydud;
    double hind;

    public KauplemisPaev(int tooteidValjaSaadetud, int tooteidMyydud, double hind) {
        this.tooteidValjaSaadetud = tooteidValjaSaadetud;
        this.tooteidMyydud = tooteidMyydud;
        this.hind = hind;
    }

    public int getTooteidValjaSaadetud() {
        return tooteidValjaSaadetud;
    }

    public int getTooteidMyydud() {
        return tooteidMyydud;
    }

    public double getHind() {
        return hind;
    }
}
