package futbolBasketbolKartOyunu;

public abstract class Sporcu {
    private String sporcuIsim;
    private String sporcuTakim;

    public Sporcu() {}

    public Sporcu(String sporcuIsim, String sporcuTakim) {
        this.setSporcuIsim(sporcuIsim);
        this.setSporcuTakim(sporcuTakim);
    }

    public abstract String sporcuPuaniGoster();

    public String getSporcuIsim() {
        return sporcuIsim;
    }

    public void setSporcuIsim(String sporcuIsim) {
        this.sporcuIsim = sporcuIsim;
    }

    public String getSporcuTakim() {
        return sporcuTakim;
    }

    public void setSporcuTakim(String sporcuTakim) {
        this.sporcuTakim = sporcuTakim;
    }
}
