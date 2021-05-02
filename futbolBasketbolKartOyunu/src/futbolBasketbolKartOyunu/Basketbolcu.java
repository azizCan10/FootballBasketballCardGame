package futbolBasketbolKartOyunu;

public class Basketbolcu extends Sporcu {
    private String basketbolcuAdi;
    private String basketbolcuTakim;
    private int ikilik;
    private int ucluk;
    private int serbestAtis;

    public Basketbolcu() {}

    public Basketbolcu(String basketbolcuAdi, String basketbolcuTakim, int ikilik, int ucluk, int serbestAtis) {
        super(basketbolcuAdi, basketbolcuTakim);
        this.setBasketbolcuAdi(super.getSporcuIsim());
        this.setBasketbolcuTakim(super.getSporcuTakim());
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
    }

    @Override
    public String sporcuPuaniGoster() {
    	String metin = basketbolcuAdi + "\nÝkilik: " + ikilik + "\nÜçlük: " + ucluk + "\nSerbest atýþ: " + serbestAtis;
    	return metin;
    }

    public String getBasketbolcuAdi() {
        return basketbolcuAdi;
    }

    public void setBasketbolcuAdi(String basketbolcuAdi) {
        this.basketbolcuAdi = basketbolcuAdi;
    }

    public String getBasketbolcuTakim() {
        return basketbolcuTakim;
    }

    public void setBasketbolcuTakim(String basketbolcuTakim) {
        this.basketbolcuTakim = basketbolcuTakim;
    }

    public int getIkilik() {
        return ikilik;
    }

    public void setIkilik(int ikilik) {
        this.ikilik = ikilik;
    }

    public int getUcluk() {
        return ucluk;
    }

    public void setUcluk(int ucluk) {
        this.ucluk = ucluk;
    }

    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
    }
}