package presentation;
import javax.swing.*;

import java.awt.Font;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class Raport extends JFrame {

	private JPanel contentPane;
	private JTextField intA;
	private JTextField intB;
	private JTextField deCateOri;
	private JTextField r3;
	private JTextField r4;

	public Raport() {
		setTitle("Raport");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBackground(new Color(216, 191, 216));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiAdministrator gAdmin = new GuiAdministrator();
				gAdmin.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(400, 442, 126, 61);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Interval de timp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 45, 200, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblGenerareRaportIn = new JLabel("Generare raport in functie de:");
		lblGenerareRaportIn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGenerareRaportIn.setBounds(10, 10, 263, 25);
		contentPane.add(lblGenerareRaportIn);
		
		intA = new JTextField();
		intA.setBounds(10, 80, 100, 25);
		contentPane.add(intA);
		intA.setColumns(10);
		
		intB = new JTextField();
		intB.setBounds(140, 80, 100, 25);
		contentPane.add(intB);
		intB.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(120, 83, 22, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton raport1 = new JButton("");
		raport1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				business.GenerareRaport.raport1(Integer.parseInt(intA.getText()), Integer.parseInt(intB.getText()));
			}
		});
		raport1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		raport1.setBackground(new Color(0, 128, 0));
		raport1.setBounds(476, 45, 50, 50);
		contentPane.add(raport1);
		
		JLabel lblProduseComandateDe = new JLabel("Produse comandate de mai mult de");
		lblProduseComandateDe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProduseComandateDe.setBounds(10, 132, 278, 25);
		contentPane.add(lblProduseComandateDe);
		
		deCateOri = new JTextField();
		deCateOri.setColumns(10);
		deCateOri.setBounds(283, 132, 100, 25);
		contentPane.add(deCateOri);
		
		JLabel lblOri = new JLabel("ori.");
		lblOri.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOri.setBounds(393, 129, 50, 25);
		contentPane.add(lblOri);
		
		JButton raport2 = new JButton("");
		raport2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		raport2.setBackground(new Color(0, 128, 0));
		raport2.setBounds(476, 126, 50, 50);
		contentPane.add(raport2);
		
		JButton raport3 = new JButton("");
		raport3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				business.GenerareRaport.raport3(Integer.parseInt(r3.getText()));
			}
		});
		raport3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		raport3.setBackground(new Color(0, 128, 0));
		raport3.setBounds(476, 207, 50, 50);
		contentPane.add(raport3);
		
		JButton raport4 = new JButton("");
		raport4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				business.GenerareRaport.raport4(Integer.parseInt(r4.getText()));
			}
		});
		raport4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		raport4.setBackground(new Color(0, 128, 0));
		raport4.setBounds(476, 289, 50, 50);
		contentPane.add(raport4);
		
		r3 = new JTextField();
		r3.setColumns(10);
		r3.setBounds(10, 242, 100, 25);
		contentPane.add(r3);
		
		JLabel lblClientiiCareAu = new JLabel("Clientii care au un numar de comenzi mai mare decat:");
		lblClientiiCareAu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblClientiiCareAu.setBounds(10, 207, 414, 25);
		contentPane.add(lblClientiiCareAu);
		
		JLabel lblProduseComandateIn = new JLabel("Produse comandate in data de:");
		lblProduseComandateIn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProduseComandateIn.setBounds(10, 289, 414, 25);
		contentPane.add(lblProduseComandateIn);
		
		r4 = new JTextField();
		r4.setColumns(10);
		r4.setBounds(10, 324, 100, 25);
		contentPane.add(r4);
	}
}
