package presentation;

import java.sql.*;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import business.*;
import main.*;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiAdministrator extends JFrame {

	private JPanel contentPane;
	private JTextField denumire;
	private JTextField rating;
	private JTextField calorii;
	private JTextField proteine;
	private JTextField fat;
	private JTextField sodiu;
	private JTextField pret;
	private static JTable table;

	public GuiAdministrator() {
		setTitle("Administrator - restaurant");
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
				main.Controller.importProducts();
			}
		});

		btnAfisareProduse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAfisareProduse.setBackground(new Color(216, 191, 216));
		btnAfisareProduse.setBounds(302, 216, 224, 43);
		contentPane.add(btnAfisareProduse);

		JButton btnAdaugare = new JButton("Adaugare");
		btnAdaugare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveryService dS = new DeliveryService();
				dS.addProducts(denumire.getText(), Float.parseFloat(rating.getText()),
						Integer.parseInt(calorii.getText()), Integer.parseInt(proteine.getText()),
						Integer.parseInt(fat.getText()), Integer.parseInt(sodiu.getText()),
						Float.parseFloat(pret.getText()));
			}
		});
		btnAdaugare.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdaugare.setBackground(new Color(216, 191, 216));
		btnAdaugare.setBounds(302, 269, 224, 43);
		contentPane.add(btnAdaugare);

		JButton btnStergere = new JButton("Stergere");
		btnStergere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveryService dS = new DeliveryService();
				dS.deleteProducts(denumire.getText(), Float.parseFloat(rating.getText()),
						Integer.parseInt(calorii.getText()), Integer.parseInt(proteine.getText()),
						Integer.parseInt(fat.getText()), Integer.parseInt(sodiu.getText()),
						Float.parseFloat(pret.getText()));
			}
		});
		btnStergere.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStergere.setBackground(new Color(178, 34, 34));
		btnStergere.setBounds(302, 322, 224, 43);
		contentPane.add(btnStergere);

		JButton btnEditare = new JButton("Editare");
		btnEditare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.Controller.editProducts(denumire.getText(), Float.parseFloat(rating.getText()),
						Integer.parseInt(calorii.getText()), Integer.parseInt(proteine.getText()),
						Integer.parseInt(fat.getText()), Integer.parseInt(sodiu.getText()),
						Float.parseFloat(pret.getText()));
			}
		});
		btnEditare.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditare.setBackground(new Color(216, 191, 216));
		btnEditare.setBounds(302, 374, 224, 43);
		contentPane.add(btnEditare);

		JButton btnAdaugare_2 = new JButton("Adaugare*");
		btnAdaugare_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdaugareProduseCompuse produseCompuse = new AdaugareProduseCompuse();
				produseCompuse.show();
				dispose();
			}
		});
		btnAdaugare_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdaugare_2.setBackground(new Color(216, 191, 216));
		btnAdaugare_2.setBounds(10, 451, 224, 43);
		contentPane.add(btnAdaugare_2);

		JLabel lblNewLabel = new JLabel("*produs compus");
		lblNewLabel.setBounds(10, 489, 202, 24);
		contentPane.add(lblNewLabel);

		JButton btnRaport = new JButton("Raport");
		btnRaport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Raport r = new Raport();
				r.show();
				dispose();
			}
		});
		btnRaport.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRaport.setBackground(new Color(216, 191, 216));
		btnRaport.setBounds(10, 398, 224, 43);
		contentPane.add(btnRaport);

		JLabel lblNewLabel_1 = new JLabel("Denumire");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 150, 76, 21);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Rating");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 181, 76, 21);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Grasimi");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(10, 274, 76, 21);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Sodiu");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(10, 305, 76, 21);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Pret");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(10, 336, 76, 21);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Calorii");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_5.setBounds(10, 212, 76, 21);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Proteine");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_6.setBounds(10, 243, 76, 21);
		contentPane.add(lblNewLabel_1_6);

		denumire = new JTextField();
		denumire.setFont(new Font("Tahoma", Font.PLAIN, 17));
		denumire.setBounds(134, 150, 100, 20);
		contentPane.add(denumire);
		denumire.setColumns(10);

		rating = new JTextField();
		rating.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rating.setColumns(10);
		rating.setBounds(134, 181, 100, 20);
		contentPane.add(rating);

		calorii = new JTextField();
		calorii.setFont(new Font("Tahoma", Font.PLAIN, 17));
		calorii.setColumns(10);
		calorii.setBounds(134, 212, 100, 20);
		contentPane.add(calorii);

		proteine = new JTextField();
		proteine.setFont(new Font("Tahoma", Font.PLAIN, 17));
		proteine.setColumns(10);
		proteine.setBounds(134, 243, 100, 20);
		contentPane.add(proteine);

		fat = new JTextField();
		fat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		fat.setColumns(10);
		fat.setBounds(134, 274, 100, 20);
		contentPane.add(fat);

		sodiu = new JTextField();
		sodiu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sodiu.setColumns(10);
		sodiu.setBounds(134, 305, 100, 20);
		contentPane.add(sodiu);

		pret = new JTextField();
		pret.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pret.setColumns(10);
		pret.setBounds(134, 336, 100, 20);
		contentPane.add(pret);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 516, 130);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				denumire.setText(table.getModel().getValueAt(row, 0).toString());
				rating.setText(table.getModel().getValueAt(row, 1).toString());
				calorii.setText(table.getModel().getValueAt(row, 2).toString());
				proteine.setText(table.getModel().getValueAt(row, 3).toString());
				fat.setText(table.getModel().getValueAt(row, 4).toString());
				sodiu.setText(table.getModel().getValueAt(row, 5).toString());
				pret.setText(table.getModel().getValueAt(row, 6).toString());
			}
		});
		scrollPane.setViewportView(table);
	}

	public static JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
