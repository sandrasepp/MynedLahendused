package Meetings;

/**
 * Created by aleksandra on 02/02/2017.
 */
public class Koosolek {
    String nimi;
    int aeg;
    boolean onnestus;

/*
  public Koosolek(String nimi, int aeg, boolean onnestus) {
    this.nimi = nimi;
    this.aeg = aeg;
    this.onnestus = onnestus;
  }
*/

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setAeg(int aeg) {
        this.aeg = aeg;
    }

    public void setOnnestus(boolean onnestus) {
        this.onnestus = onnestus;
    }

    public String getNimi() {
        return nimi;
    }

    public int getAeg() {
        return aeg;
    }

    public boolean isOnnestus() {
        return onnestus;
    }
}
