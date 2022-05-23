package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui.*;

public class Interfata extends JFrame {

	private JPanel contentPane;
	private GuiClient gClient;
	private GuiComanda gComanda;
	private GuiProdus gProdus;
	
	public Interfata() {
		setTitle("DEPOZIT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doriti sa accesati informatiile despre:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(22, 62, 400, 60);
		contentPane.add(lblNewLabel);
		
		JButton clientWindow = new JButton("Clienti");
		clientWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GuiClient v = new GuiClient();
				v.show();
				dispose();
			}
		});
		clientWindow.setBackground(new Color(216, 191, 216));
		clientWindow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		clientWindow.setBounds(115, 179, 200, 50);
		contentPane.add(clientWindow);
		
		JButton produsWindow = new JButton("Produse");
		produsWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GuiProdus v = new GuiProdus();
				v.show();
				dispose();
			}
		});
		produsWindow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		produsWindow.setBackground(new Color(216, 191, 216));
		produsWindow.setBounds(115, 274, 200, 50);
		contentPane.add(produsWindow);
		
		JButton comandaWindow = new JButton("Comenzi");
		comandaWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GuiComanda v = new GuiComanda();
				v.show();
				dispose();
			}
		});
		comandaWindow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comandaWindow.setBackground(new Color(216, 191, 216));
		comandaWindow.setBounds(115, 371, 200, 50);
		contentPane.add(comandaWindow);
	}
}
