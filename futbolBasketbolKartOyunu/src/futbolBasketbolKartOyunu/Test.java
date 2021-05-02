package futbolBasketbolKartOyunu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

public class Test extends JFrame {

	private JPanel contentPane;
    
    static ArrayList <Futbolcu> futbolcular;
    static ArrayList <Basketbolcu> basketbolcular;
    
    static Bilgisayar bilgisayar;
    static Kullanici kullanici;

    static int[] kullaniciFutbolcu;
    static int[] kullaniciBasketbolcu;

    static int[] bilgisayarFutbolcu;
    static int[] bilgisayarBasketbolcu;

    static int num = 0;
    static int sameVal = 0;

    int tikSayisi = 1;
    int gerekenTikSayisi = 9;
    int kart1FutbolTikSayisi = 0;
    int kart1BasketbolTikSayisi = 0;
    int kart2FutbolTikSayisi = 0;
    int kart2BasketbolTikSayisi = 0;
    int kart3FutbolTikSayisi = 0;
    int kart3BasketbolTikSayisi = 0;
    int kart4FutbolTikSayisi = 0;
    int kart4BasketbolTikSayisi = 0;
    int futbolToplamTikSayisi = 0;
    int basketbolToplamTikSayisi = 0;
    
    int secimKullanici = 0;
    int secimBilgisayar = 0;
    int pozisyon = 0;
    boolean ayniMi = false;
    
    private final Action action = new SwingAction();
    
	public static void main(String[] args) throws Exception {
		new Baslangic().setVisible(true);
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Test frame = new Test();
				frame.setVisible(false);
            }
        });
		
		Futbolcu cristianoRonaldo = new Futbolcu("Cristiano Ronaldo", "Juventus", 99, 95, 95);
        Futbolcu lionelMessi = new Futbolcu("Lionel Messi", "Barcelona", 97, 92, 96);
        Futbolcu muhammedSalah = new Futbolcu("Muhammed Salah", "Liverpool", 96, 91, 94);
        Futbolcu vedatMuric = new Futbolcu("Vedat Muriç", "Lazio", 88, 80, 85);
        Futbolcu karimBenzema = new Futbolcu("Karim Benzema", "Real Madrid", 90, 85, 93);
        Futbolcu zlatanIbrahimovic = new Futbolcu("Zlatan Ibrahimoviç", "AC Milan", 92, 83, 92);
        Futbolcu alexDeSouza = new Futbolcu("Alex De Souza", "Fenerbahçe", 96, 90, 90);
        Futbolcu wesleySneijder = new Futbolcu("Wesley Sneijder", "Galatasaray", 91, 89, 88);

        Basketbolcu lebronJames = new Basketbolcu("Lebron James", "Los Angeles Lakers", 95, 90, 85);
        Basketbolcu anthonyDavis = new Basketbolcu("Anthony Davis", "Los Angeles Lakers", 92, 85, 82);
        Basketbolcu stephanCurry = new Basketbolcu("Stephan Curry", "Golden State Warriors", 90, 95, 88);
        Basketbolcu jamesHarden = new Basketbolcu("James Harden", "Houston Rockets", 92, 93, 87);
        Basketbolcu russellWestbrook = new Basketbolcu("Russell Westbrook", "Houston Rockets", 91, 92, 89);
        Basketbolcu melihMahmutoglu = new Basketbolcu("Melih Mahmutoðlu", "Fenerbahçe", 80, 88, 80);
        Basketbolcu barisErmis = new Basketbolcu("Barýþ Ermiþ", "Galatasaray", 82, 80, 81);
        Basketbolcu goranDragic = new Basketbolcu("Goran Dragic", "Miami Heat", 89, 87, 86);
        
        bilgisayar = new Bilgisayar("Bilgisayar", "Bilgisayar", 0);
        kullanici = new Kullanici("Kullanýcý", "Kullanýcý", 0);

        futbolcular = new ArrayList<>();
        futbolcular.add(cristianoRonaldo);
        futbolcular.add(lionelMessi);
        futbolcular.add(muhammedSalah);
        futbolcular.add(vedatMuric);
        futbolcular.add(karimBenzema);
        futbolcular.add(zlatanIbrahimovic);
        futbolcular.add(alexDeSouza);
        futbolcular.add(wesleySneijder);

        basketbolcular = new ArrayList<>();
        basketbolcular.add(lebronJames);
        basketbolcular.add(anthonyDavis);
        basketbolcular.add(stephanCurry);
        basketbolcular.add(jamesHarden);
        basketbolcular.add(russellWestbrook);
        basketbolcular.add(melihMahmutoglu);
        basketbolcular.add(barisErmis);
        basketbolcular.add(goranDragic);

        //kullanýcý futbol kart daðýtýmý
        kullaniciFutbolcu = new int[4];
        kullaniciSinifinaKartDagitimi(kullaniciFutbolcu);

        //bilgisayar futbol kart daðýtýmý
        bilgisayarFutbolcu = new int[4];
        bilgisayarSinifinaKartDagitimi(bilgisayarFutbolcu, kullaniciFutbolcu);

        //kullanýcý basketbol kart daðýtýmý
        kullaniciBasketbolcu = new int[4];
        kullaniciSinifinaKartDagitimi(kullaniciBasketbolcu);

        //bilgisayar basketbol kart daðýtýmý
        bilgisayarBasketbolcu = new int[4];
        bilgisayarSinifinaKartDagitimi(bilgisayarBasketbolcu, kullaniciBasketbolcu);
	}

	JButton btnKart1;
	JButton btnKart2;
	JButton btnKart3;
	JButton btnKart4;
	
	JLabel lblSkor;
	JLabel lblSkorBilgisayar;
	JLabel lblSkorKullanici;
	JLabel lblPozisyonBilgisi;	
	JLabel lblKazanan;
	JLabel lblBackground;
	
	JTextPane txtMetinKullanici;
	JTextPane txtMetinBilgisayar;
	
	public Test() {
		setTitle("FUTBOL BASKETBOL KART OYUNU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 25, 1200, 980);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnKart1 = new JButton("");
		btnKart1.setIcon(new ImageIcon(getClass().getResource("/images/futbol/futbol_kart_background_" + kullaniciFutbolcu[0] + ".jpg")));
		btnKart1.setBounds(60, 70, 220, 270);
		contentPane.add(btnKart1);
		
		btnKart2 = new JButton("");
		btnKart2.setIcon(new ImageIcon(getClass().getResource("/images/futbol/futbol_kart_background_" + kullaniciFutbolcu[1] + ".jpg")));
		btnKart2.setBounds(360, 70, 220, 270);
		contentPane.add(btnKart2);
		
		btnKart3= new JButton("");
		btnKart3.setIcon(new ImageIcon(getClass().getResource("/images/futbol/futbol_kart_background_" + kullaniciFutbolcu[2] + ".jpg")));
		btnKart3.setBounds(650, 70, 220, 270);
		contentPane.add(btnKart3);
		
		btnKart4 = new JButton("");
		btnKart4.setIcon(new ImageIcon(getClass().getResource("/images/futbol/futbol_kart_background_" + kullaniciFutbolcu[3] + ".jpg")));
		btnKart4.setBounds(920, 70, 220, 270);
		contentPane.add(btnKart4);
		
		lblSkor = new JLabel("SKOR");
		lblSkor.setForeground(Color.WHITE);
		lblSkor.setBackground(Color.WHITE);
		lblSkor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSkor.setBounds(560, 690, 100, 40);
		contentPane.add(lblSkor);
		
		lblSkorBilgisayar = new JLabel(bilgisayar.skorGöster());
		lblSkorBilgisayar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSkorBilgisayar.setForeground(Color.WHITE);
		lblSkorBilgisayar.setBounds(950, 780, 140, 28);
		contentPane.add(lblSkorBilgisayar);
		
		lblSkorKullanici = new JLabel(kullanici.skorGöster());
		lblSkorKullanici.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSkorKullanici.setForeground(Color.WHITE);
		lblSkorKullanici.setBounds(110, 780, 130, 28);
		contentPane.add(lblSkorKullanici);
		
		lblPozisyonBilgisi = new JLabel("");
		lblPozisyonBilgisi.setForeground(Color.WHITE);
		lblPozisyonBilgisi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPozisyonBilgisi.setBounds(487, 537, 320, 50);
		contentPane.add(lblPozisyonBilgisi);
		
		lblKazanan = new JLabel("");
		lblKazanan.setForeground(Color.WHITE);
		lblKazanan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblKazanan.setBounds(499, 856, 270, 50);
		contentPane.add(lblKazanan);
		
		txtMetinKullanici = new JTextPane();
		txtMetinKullanici.setForeground(Color.WHITE);
		txtMetinKullanici.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtMetinKullanici.setBackground(Color.BLACK);
		txtMetinKullanici.setBounds(90, 550, 160, 80);
		contentPane.add(txtMetinKullanici);
		
		txtMetinBilgisayar = new JTextPane();
		txtMetinBilgisayar.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtMetinBilgisayar.setForeground(Color.WHITE);
		txtMetinBilgisayar.setBackground(Color.BLACK);
		txtMetinBilgisayar.setBounds(920, 540, 160, 80);
		contentPane.add(txtMetinBilgisayar);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/images/football_background.jpg")));
		lblBackground.setBounds(0, 0, 1184, 941);
		contentPane.add(lblBackground);
		
		btnKart1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//futbolcu arayüzü
				
				if (tikSayisi % 2 == 1) {
					basketArayuz();
					
		            secimKullanici = kullaniciFutbolcu[0];
		            secimBilgisayar = bilgisayarFutbolcu[0];

		            //seçilen futbolcularýn özelliklerini yazma
		            futbolcuOzellikYazma();
		            
		            //pozisyon bilgisi alma
		            pozisyonAlmaFutbol();
		            
		            if (!ayniMi) {
		                kart1FutbolTikSayisi++;
		                futbolToplamTikSayisi++;
		            }
		            
		            //kartlar kullanýldýysa görünümünü kapama
		            kartKullanildiysaKapatBasketbol();
		            
		        }
		        
		        //basketbolcu arayüzü
		        
		        if (tikSayisi %2 == 0) {
		            futbolArayuz();
		             
		            secimKullanici = kullaniciBasketbolcu[0];
		            secimBilgisayar = bilgisayarBasketbolcu[0];
		            
		            //seçilen basketbolcularýn özelliklerini yazma
		            basketbolcuOzellikYazma();
		            		            
		            //pozisyon bilgisi alma
		            pozisyonAlmaBasketbol();
		             
		            if (!ayniMi) {
		                kart1BasketbolTikSayisi++;
		                basketbolToplamTikSayisi++;
		            }
		                
		            //kartlar kullanýldýysa görünümünü kapama
		            kartKullanildiysaKapatFutbol();
		        }
		        
		        tikSayisi++;
		        
		        //beraberlik durumunun kontrolü
		        sonaBasketbolKalmaDurumu();
		        sonaFutbolKalmaDurumu();
		        
		        //kullanýcý ve bilgisayar skorlarýný yazdýrma
		        skorYazma();
		        
		        //son durumda yapýlacaklar
		        sonDurum();
			}
		});	
		
		btnKart2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//futbolcu arayüzü
				
				if (tikSayisi % 2 == 1) {
					basketArayuz();
					
		            secimKullanici = kullaniciFutbolcu[1];
		            secimBilgisayar = bilgisayarFutbolcu[1];

		            //seçilen futbolcularýn özelliklerini yazma
		            futbolcuOzellikYazma();
		            
		            //pozisyon bilgisi alma
		            pozisyonAlmaFutbol();
		            
		            if (!ayniMi) {
		                kart2FutbolTikSayisi++;
		                futbolToplamTikSayisi++;
		            }
		            
		            //kartlar kullanýldýysa görünümünü kapama
		            kartKullanildiysaKapatBasketbol();
		            
		        }
		        
		        //basketbolcu arayüzü
		        
		        if (tikSayisi %2 == 0) {
		            futbolArayuz();
		             
		            secimKullanici = kullaniciBasketbolcu[1];
		            secimBilgisayar = bilgisayarBasketbolcu[1];
		            
		            //seçilen basketbolcularýn özelliklerini yazma
		            basketbolcuOzellikYazma();
		            
		            //pozisyon bilgisi alma
		            pozisyonAlmaBasketbol();
		             
		            if (!ayniMi) {
		                kart2BasketbolTikSayisi++;
		                basketbolToplamTikSayisi++;
		            }
		                
		            //kartlar kullanýldýysa görünümünü kapama
		            kartKullanildiysaKapatFutbol();
		        }
		        
		        tikSayisi++;
		        
		        //beraberlik durumunun kontrolü
		        sonaBasketbolKalmaDurumu();
		        sonaFutbolKalmaDurumu();
		        
		        //kullanýcý ve bilgisayar skorlarýný yazdýrma
		        skorYazma();
		        
		        //son durumda yapýlacaklar
		        sonDurum();			
			}
		});
		
		btnKart3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//futbolcu arayüzü
				
				if (tikSayisi % 2 == 1) {
					basketArayuz();
					
		            secimKullanici = kullaniciFutbolcu[2];
		            secimBilgisayar = bilgisayarFutbolcu[2];

		            //seçilen futbolcularýn özelliklerini yazma
		            futbolcuOzellikYazma();
		            
		            //pozisyon bilgisi alma
		            pozisyonAlmaFutbol();
		            
		            if (!ayniMi) {
		                kart3FutbolTikSayisi++;
		                futbolToplamTikSayisi++;
		            }
		            
		            //kartlar kullanýldýysa görünümünü kapama
		            kartKullanildiysaKapatBasketbol();
		            
		        }
		        
		        //basketbolcu arayüzü
		        
		        if (tikSayisi %2 == 0) {
		            futbolArayuz();
		             
		            secimKullanici = kullaniciBasketbolcu[2];
		            secimBilgisayar = bilgisayarBasketbolcu[2];
		            
		            //seçilen basketbolcularýn özelliklerini yazma
		            basketbolcuOzellikYazma();
		            
		            //pozisyon bilgisi alma
		            pozisyonAlmaBasketbol();
		             
		            if (!ayniMi) {
		                kart3BasketbolTikSayisi++;
		                basketbolToplamTikSayisi++;
		            }
		                
		            //kartlar kullanýldýysa görünümünü kapama
		            kartKullanildiysaKapatFutbol();
		        }
		        
		        tikSayisi++;
		        
		        //beraberlik durumunun kontrolü
		        sonaBasketbolKalmaDurumu();
		        sonaFutbolKalmaDurumu();
		        
		        //kullanýcý ve bilgisayar skorlarýný yazdýrma
		        skorYazma();
		        
		        //son durumda yapýlacaklar
		        sonDurum();
			}
		});
		
		btnKart4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//futbolcu arayüzü
				
				if (tikSayisi % 2 == 1) {
					basketArayuz();
					
		            secimKullanici = kullaniciFutbolcu[3];
		            secimBilgisayar = bilgisayarFutbolcu[3];

		            //seçilen futbolcularýn özelliklerini yazma
		            futbolcuOzellikYazma();
		            
		            //pozisyon bilgisi alma
		            pozisyonAlmaFutbol();
		            
		            if (!ayniMi) {
		                kart4FutbolTikSayisi++;
		                futbolToplamTikSayisi++;
		            }
		            
		            //kartlar kullanýldýysa görünümünü kapama
		            kartKullanildiysaKapatBasketbol();
		            
		        }
		        
		        //basketbolcu arayüzü
		        
		        if (tikSayisi %2 == 0) {
		            futbolArayuz();
		             
		            secimKullanici = kullaniciBasketbolcu[3];
		            secimBilgisayar = bilgisayarBasketbolcu[3];
		            
		            //seçilen basketbolcularýn özelliklerini yazma
		            basketbolcuOzellikYazma();
		            
		            //pozisyon bilgisi alma
		            pozisyonAlmaBasketbol();
		             
		            if (!ayniMi) {
		                kart4BasketbolTikSayisi++;
		                basketbolToplamTikSayisi++;
		            }
		                
		            //kartlar kullanýldýysa görünümünü kapama
		            kartKullanildiysaKapatFutbol();
		        }
		        
		        tikSayisi++;
		        
		        //beraberlik durumunun kontrolü
		        sonaBasketbolKalmaDurumu();
		        sonaFutbolKalmaDurumu();
		        
		        //kullanýcý ve bilgisayar skorlarýný yazdýrma
		        skorYazma();
		        
		        //son durumda yapýlacaklar
		        sonDurum();
			}
		});
		
		btnKart1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKart1.setBounds(60, 80, 220, 270);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnKart1.setBounds(60, 70, 220, 270);
			}
		});
		
		btnKart2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKart2.setBounds(360, 80, 220, 270);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnKart2.setBounds(360, 70, 220, 270);
			}
		});
		
		btnKart3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKart3.setBounds(650, 80, 220, 270);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnKart3.setBounds(650, 70, 220, 270);
			}
		});
		
		btnKart4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKart4.setBounds(920, 80, 220, 270);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnKart4.setBounds(920, 70, 220, 270);
			}
		});
	}
	
	public void pozisyonKarsilastirma(int poz, int pozisyonSira, int deger1, int deger2) {
        if (poz == pozisyonSira) {
            if (deger1 > deger2) {
                kullanici.setSkor(kullanici.getSkor() + 10);
                ayniMi = false;
            }
            else if (deger1 < deger2) {
                bilgisayar.setSkor(bilgisayar.getSkor() + 10);
                ayniMi = false;
            }
            else {
                gerekenTikSayisi++;
                ayniMi = true;
            }
        }
    }

    public static void kullaniciSinifinaKartDagitimi(int[] dizi) {
        Random random = new Random();

        for (int i = 0; i < dizi.length; i++) {
            sameVal = 0;
            num = random.nextInt(8) + 1;

            for (int j = 0; j < i; j++) {
                if (num == dizi[j])
                    sameVal--;
            }

            if (sameVal <= -1)
                i--;
            else
                dizi[i] = num;
        }
    }

    public static void bilgisayarSinifinaKartDagitimi(int[] dizi, int[] dizi2) {
        boolean varMi = false;
        int ctrl = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < dizi.length; j++) {
                if (i == dizi2[j])
                    varMi = true;
            }

            if (varMi == false) {
                dizi[ctrl] = i;
                ctrl++;
            }

            varMi = false;
        }
    }
    
    public void basketArayuz() {
    	btnKart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basket/basket_kart_background_" + kullaniciBasketbolcu[0] + ".jpg")));
        btnKart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basket/basket_kart_background_" + kullaniciBasketbolcu[1] + ".jpg")));
        btnKart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basket/basket_kart_background_" + kullaniciBasketbolcu[2] + ".jpg")));
        btnKart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basket/basket_kart_background_" + kullaniciBasketbolcu[3] + ".jpg")));
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/basketball_background.jpg")));
	}
    
    public void futbolArayuz() {
    	btnKart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/futbol/futbol_kart_background_" + kullaniciFutbolcu[0] + ".jpg")));
        btnKart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/futbol/futbol_kart_background_" + kullaniciFutbolcu[1] + ".jpg")));
        btnKart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/futbol/futbol_kart_background_" + kullaniciFutbolcu[2] + ".jpg")));
        btnKart4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/futbol/futbol_kart_background_" + kullaniciFutbolcu[3] + ".jpg")));
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/football_background.jpg")));
	}
    
    public void kartKullanildiysaKapatBasketbol() {
    	if (kart1BasketbolTikSayisi >= 1)
            btnKart1.setVisible(false);
        if (kart2BasketbolTikSayisi >= 1)
            btnKart2.setVisible(false);
        if (kart3BasketbolTikSayisi >= 1)
            btnKart3.setVisible(false);
        if (kart4BasketbolTikSayisi >= 1)
            btnKart4.setVisible(false);
        
        if (kart1BasketbolTikSayisi == 0)
            btnKart1.setVisible(true);
        if (kart2BasketbolTikSayisi == 0)
            btnKart2.setVisible(true);
        if (kart3BasketbolTikSayisi == 0)
            btnKart3.setVisible(true);
        if (kart4BasketbolTikSayisi == 0)
            btnKart4.setVisible(true);
	}
    
    public void kartKullanildiysaKapatFutbol() {
    	if (kart1FutbolTikSayisi >= 1)
            btnKart1.setVisible(false);
        if (kart2FutbolTikSayisi >= 1)
            btnKart2.setVisible(false);
        if (kart3FutbolTikSayisi >= 1)
            btnKart3.setVisible(false);
        if (kart4FutbolTikSayisi >= 1)
            btnKart4.setVisible(false);
        
        if (kart1FutbolTikSayisi == 0)
            btnKart1.setVisible(true);
        if (kart2FutbolTikSayisi == 0)
            btnKart2.setVisible(true);
        if (kart3FutbolTikSayisi == 0)
            btnKart3.setVisible(true);
        if (kart4FutbolTikSayisi == 0)
            btnKart4.setVisible(true);
	}
    
    public void sonaBasketbolKalmaDurumu() {
    	if (futbolToplamTikSayisi == 4 && basketbolToplamTikSayisi != 4 && tikSayisi % 2 == 1) {
            tikSayisi++;
            gerekenTikSayisi++;
            
            kartKullanildiysaKapatBasketbol();
            basketArayuz();
        }
	}
    
    public void sonaFutbolKalmaDurumu() {
    	if (basketbolToplamTikSayisi == 4 && futbolToplamTikSayisi != 4 && tikSayisi % 2 == 0) {
            tikSayisi++;
            gerekenTikSayisi++;
            
            kartKullanildiysaKapatFutbol();           
            futbolArayuz();
        }
	}
    
    public void pozisyonAlmaFutbol() {
    	Random random = new Random();
        pozisyon = random.nextInt(3) + 1;
        
        if (pozisyon == 1)
            lblPozisyonBilgisi.setText("Pozisyon bilgisi: Penaltý");
        if (pozisyon == 2)
           lblPozisyonBilgisi.setText("Pozisyon bilgisi: Serbest vuruþ");
        if (pozisyon == 3)
            lblPozisyonBilgisi.setText("Pozisyon bilgisi: Kaleciyle karþý karþýya");
        
        pozisyonKarsilastirma(pozisyon, 1, futbolcular.get(secimKullanici-1).getPenalti(), futbolcular.get(secimBilgisayar-1).getPenalti());
        pozisyonKarsilastirma(pozisyon, 2, futbolcular.get(secimKullanici-1).getSerbestVurus(), futbolcular.get(secimBilgisayar-1).getSerbestVurus());
        pozisyonKarsilastirma(pozisyon, 3, futbolcular.get(secimKullanici-1).getKaleciKarsiKarsiya(), futbolcular.get(secimBilgisayar-1).getKaleciKarsiKarsiya());
	}
    
    public void pozisyonAlmaBasketbol() {
    	Random random = new Random();
        pozisyon = random.nextInt(3) + 1;
        
        if (pozisyon == 1)
            lblPozisyonBilgisi.setText("Pozisyon Bilgisi: Ýkilik");
        if (pozisyon == 2)
           lblPozisyonBilgisi.setText("Pozisyon Bilgisi: Üçlük");
        if (pozisyon == 3)
            lblPozisyonBilgisi.setText("Pozisyon Bilgisi: Serbest atýþ");
        
        pozisyonKarsilastirma(pozisyon, 1, basketbolcular.get(secimKullanici-1).getIkilik(), basketbolcular.get(secimBilgisayar-1).getIkilik());
        pozisyonKarsilastirma(pozisyon, 2, basketbolcular.get(secimKullanici-1).getUcluk(), basketbolcular.get(secimBilgisayar-1).getUcluk());
        pozisyonKarsilastirma(pozisyon, 3, basketbolcular.get(secimKullanici-1).getSerbestAtis(), basketbolcular.get(secimBilgisayar-1).getSerbestAtis());
	}
    
    public void sonDurum() {
    	if (tikSayisi == gerekenTikSayisi) {    
        	lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/last_background.jpg")));
            if (kullanici.getSkor() < bilgisayar.getSkor())
                lblKazanan.setText(bilgisayar.getOyuncuAdi() + " kazandý");
            else if (kullanici.getSkor() > bilgisayar.getSkor())
                lblKazanan.setText(kullanici.getOyuncuAdi() + " kazandý");
            else
                lblKazanan.setText("Berabere");
        }
	}
    
    public void futbolcuOzellikYazma() {
    	txtMetinKullanici.setText(futbolcular.get(secimKullanici-1).sporcuPuaniGoster());
        txtMetinBilgisayar.setText(futbolcular.get(secimBilgisayar-1).sporcuPuaniGoster());
	}
    
    public void basketbolcuOzellikYazma() {
    	txtMetinKullanici.setText(basketbolcular.get(secimKullanici-1).sporcuPuaniGoster());
        txtMetinBilgisayar.setText(basketbolcular.get(secimBilgisayar-1).sporcuPuaniGoster());
	}
    
    public void skorYazma() {
    	lblSkorKullanici.setText(kullanici.skorGöster());
        lblSkorBilgisayar.setText(bilgisayar.skorGöster());
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}