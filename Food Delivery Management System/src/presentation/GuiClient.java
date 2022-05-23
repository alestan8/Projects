package presentation;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import business.BaseProduct;
import main.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GuiClient extends JFrame {

	private JPanel contentPane;
	private static JTextField cuvantCheie;
	private static JTable table;
	private static JTextField intA;
	private static JTextField intB;
	private static JComboBox categorie;

	public GuiClient() {
		setTitle("Client - restaurant");
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
				Main m = new Main();
				m.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(400, 442, 126, 61);
		contentPane.add(btnNewButton);

		JButton btnAfisareProduse = new JButton("Afisare produse");
		btnAfisareProduse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Title");
					model.addColumn("Rating");
					model.addColumn("Calories");
					model.addColumn("Protein");
					model.addColumn("Fat");
					model.addColumn("Sodium");
					model.addColumn("Price");
					for (BaseProduct tmp : main.Controller.getProduse()) {
						Vector<String> row = new Vector<String>();
						row.add(tmp.getTitle());
						row.add(Float.toString(tmp.getRating()));
						row.add(Integer.toString(tmp.getCalories()));
						row.add(Integer.toString(tmp.getProtein()));
						row.add(Integer.toString(tmp.getFat()));
						row.add(Integer.toString(tmp.getSodium()));
						row.add(Float.toString(tmp.getPret()));
						model.addRow(row);
					}
					table.setModel(model);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnAfisareProduse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAfisareProduse.setBackground(new Color(216, 191, 216));
		btnAfisareProduse.setBounds(326, 138, 200, 50);
		contentPane.add(btnAfisareProduse);

		categorie = new JComboBox();
		categorie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		categorie.setModel(new DefaultComboBoxModel(
				new String[] { "title", "rating", "calories", "protein", "fat", "sodium", "pret" }));
		categorie.setBounds(297, 198, 170, 31);
		contentPane.add(categorie);

		JLabel lblNewLabel = new JLabel("Afisare produse in functie de:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 198, 250, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cautati dupa un cuvant cheie:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 315, 250, 25);
		contentPane.add(lblNewLabel_1);

		cuvantCheie = new JTextField();
		cuvantCheie.setBounds(297, 309, 170, 31);
		contentPane.add(cuvantCheie);
		cuvantCheie.setColumns(10);

		JButton cautareCategorie = new JButton("");
		cautareCategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<BaseProduct> bP = new ArrayList<BaseProduct>();
				if (categorie.getSelectedIndex() == 1)
					bP = business.CautareProdus.cautareRating(Integer.parseInt(intA.getText().toString()),
							Integer.parseInt(intB.getText().toString()));
				else if (categorie.getSelectedIndex() == 2)
					bP = business.CautareProdus.cautareCalories(Integer.parseInt(intA.getText().toString()),
							Integer.parseInt(intB.getText().toString()));
				else if (categorie.getSelectedIndex() == 3)
					bP = business.CautareProdus.cautareProtein(Integer.parseInt(intA.getText().toString()),
							Integer.parseInt(intB.getText().toString()));
				else if (categorie.getSelectedIndex() == 4)
					bP = business.CautareProdus.cautareFat(Integer.parseInt(intA.getText().toString()),
							Integer.parseInt(intB.getText().toString()));
				else if (categorie.getSelectedIndex() == 5)
					bP = business.CautareProdus.cautareSodiu(Integer.parseInt(intA.getText().toString()),
							Integer.parseInt(intB.getText().toString()));
				else if (categorie.getSelectedIndex() == 6)
					bP = business.CautareProdus.cautarePrice(Integer.parseInt(intA.getText().toString()),
							Integer.parseInt(intB.getText().toString()));
				business.CautareProdus.afisareLista(bP);
			}
		});
		cautareCategorie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cautareCategorie.setBackground(new Color(46, 139, 87));
		cautareCategorie.setBounds(477, 198, 49, 33);
		contentPane.add(cautareCategorie);

		JButton cautareCheie = new JButton("");
		cautareCheie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<BaseProduct> bP = business.CautareProdus.cautareCuvantCheie(cuvantCheie.getText().toString(), Controller.getProduse());
				business.CautareProdus.afisareLista(bP);
			}
		});
		cautareCheie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cautareCheie.setBackground(new Color(46, 139, 87));
		cautareCheie.setBounds(477, 309, 49, 33);
		contentPane.add(cautareCheie);

		JButton btnAdaugatiOComanda = new JButton("Adaugati o comanda");
		btnAdaugatiOComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdaugareComanda c = new AdaugareComanda();
				c.show();
				dispose();
			}
		});
		btnAdaugatiOComanda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdaugatiOComanda.setBackground(new Color(46, 139, 87));
		btnAdaugatiOComanda.setBounds(10, 407, 250, 50);
		contentPane.add(btnAdaugatiOComanda);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 516, 108);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblAdaugatiUnInterval = new JLabel("Adaugati un interval:");
		lblAdaugatiUnInterval.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdaugatiUnInterval.setBounds(10, 254, 200, 30);
		contentPane.add(lblAdaugatiUnInterval);

		intA = new JTextField();
		intA.setColumns(10);
		intA.setBounds(297, 257, 100, 31);
		contentPane.add(intA);

		intB = new JTextField();
		intB.setColumns(10);
		intB.setBounds(426, 257, 100, 31);
		contentPane.add(intB);

		JLabel lblAdaugatiUnInterval_1 = new JLabel("-");
		lblAdaugatiUnInterval_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdaugatiUnInterval_1.setBounds(408, 257, 25, 25);
		contentPane.add(lblAdaugatiUnInterval_1);

		JButton btnCautare = new JButton("Cautare*");
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<BaseProduct> bP = new ArrayList<BaseProduct>();
				bP = business.CautareProdus.cautareDouaCriterii(categorie.getSelectedIndex(), cuvantCheie.getText().toString(), Integer.parseInt(intA.getText().toString()), Integer.parseInt(intB.getText().toString()));
				business.CautareProdus.afisareLista(bP);
			}
		});
		btnCautare.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCautare.setBackground(new Color(216, 191, 216));
		btnCautare.setBounds(326, 350, 200, 50);
		contentPane.add(btnCautare);

		JLabel lblNewLabel_2 = new JLabel("*Cautarea se va face dupa un criteriu plus un cuvant cheie");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 490, 351, 13);
		contentPane.add(lblNewLabel_2);
	}

	public static JTextField getCuvantCheie() {
		return cuvantCheie;
	}

	public static JTable getTable() {
		return table;
	}

	public static JTextField getIntA() {
		return intA;
	}

	public static JTextField getIntB() {
		return intB;
	}
}
