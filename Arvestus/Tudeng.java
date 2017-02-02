package Arvestus;

public class Tudeng {
    String nimi;
    int hinne;

    public Tudeng(String nimi, int hinne) {
        this.nimi = nimi;
        this.hinne = hinne;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getHinne() {
        return hinne;
    }

    public void setHinne(int hinne) {
        this.hinne = hinne;
    }
}
