package futbolBasketbolKartOyunu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Baslangic extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Baslangic frame = new Baslangic();
				frame.setVisible(true);
            }
        });
	}

	
	public Baslangic() {
		setTitle("FUTBOL BASKETBOL KART OYUNU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 25, 1200, 980);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOyna = new JButton("OYNA");
		btnOyna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Test().setVisible(true);
		        dispose();
			}
		});
		btnOyna.setFont(new Font("Dialog", Font.BOLD, 32));
		btnOyna.setForeground(Color.WHITE);
		btnOyna.setBackground(Color.BLACK);
		btnOyna.setBounds(130, 670, 300, 170);
		contentPane.add(btnOyna);
		
		JButton btnCikis = new JButton("\u00C7IKI\u015E");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCikis.setFont(new Font("Dialog", Font.BOLD, 36));
		btnCikis.setForeground(Color.WHITE);
		btnCikis.setBackground(Color.BLACK);
		btnCikis.setBounds(740, 670, 300, 170);
		contentPane.add(btnCikis);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(getClass().getResource("/images/last_background.jpg")));
		lblBackground.setBounds(0, 0, 1184, 941);
		contentPane.add(lblBackground);
	}
}