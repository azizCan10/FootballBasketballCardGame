package futbolBasketbolKartOyunu;

public class Futbolcu extends Sporcu {
    private String futbolcuAdi;
    private String futbolcuTakim;
    private int penalti;
    private int serbestVurus;
    private int kaleciKarsiKarsiya;

    public Futbolcu() {}

    public Futbolcu(String futbolcuAdi, String futbolcuTakim, int penalti, int serbestVurus, int kaleciKarsiKarsiya) {
        super(futbolcuAdi, futbolcuTakim);
        this.setFutbolcuAdi(super.getSporcuIsim());
        this.setFutbolcuTakim(super.getSporcuTakim());
        this.penalti = penalti;
        this.serbestVurus = serbestVurus;
        this.kaleciKarsiKarsiya = kaleciKarsiKarsiya;
    }

    @Override
    public String sporcuPuaniGoster() {
        String metin = futbolcuAdi + "\nPenaltý: " + penalti + "\nSerbest vuruþ: " + serbestVurus
                + "\nKaleciyle karþý karþýya: " + kaleciKarsiKarsiya;
        return metin;
    }

    public String getFutbolcuAdi() {
        return futbolcuAdi;
    }

    public void setFutbolcuAdi(String futbolcuAdi) {
        this.futbolcuAdi = futbolcuAdi;
    }

    public String getFutbolcuTakim() {
        return futbolcuTakim;
    }

    public void setFutbolcuTakim(String futbolcuTakim) {
        this.futbolcuTakim = futbolcuTakim;
    }

    public int getPenalti() {
        return penalti;
    }

    public void setPenalti(int penalti) {
        this.penalti = penalti;
    }

    public int getSerbestVurus() {
        return serbestVurus;
    }

    public void setSerbestVurus(int serbestVurus) {
        this.serbestVurus = serbestVurus;
    }

    public int getKaleciKarsiKarsiya() {
        return kaleciKarsiKarsiya;
    }

    public void setKaleciKarsiKarsiya(int kaleciKarsiKarsiya) {
        this.kaleciKarsiKarsiya = kaleciKarsiKarsiya;
    }
}