package gui;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.OpDAO;
import model.*;
import net.proteanit.sql.DbUtils;
import presentation.Interfata;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class GuiClient extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField nume;
	private JTextField adresa;
	private static JButton afisare;
	private JButton adaugare;
	private JButton stergere;
	private JButton editare;
	private JTextField numeNou;
	private JTextField adresaNoua;

	public static JButton getAfisare() {
		return afisare;
	}
	
	public GuiClient() {
		setTitle("CLIENTI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton back = new JButton("Back");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Interfata v = new Interfata();
				v.show();
				dispose();
			}
		});
		back.setBackground(new Color(216, 191, 216));
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		back.setBounds(315, 440, 200, 50);
		contentPane.add(back);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 29, 254, 267);
		contentPane.add(scrollPane);

		setTable(new JTable());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table.getSelectedRow();
					String table_nume = table.getModel().getValueAt(row, 1).toString();
					String table_adresa = table.getModel().getValueAt(row, 2).toString();
					nume.setText(table_nume);
					adresa.setText(table_adresa);
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
		scrollPane.setViewportView(getTable());

		afisare = new JButton("Afisare clienti");
		afisare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Client client = new Client();
					ResultSet rs = OpDAO.getLista(client);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception exceptie) {
					System.out.print(exceptie);
				}
			}
		});
		afisare.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		afisare.setBackground(new Color(144, 238, 144));
		afisare.setBounds(33, 296, 200, 50);
		contentPane.add(afisare);

		adaugare = new JButton("Adaugare client");
		adaugare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int rs = OpDAO.opClient(1, nume.getText(), adresa.getText(), 0);
					if (rs != 0) {
						Client client = new Client();
						ResultSet rs1 = OpDAO.getLista(client);
						table.setModel(DbUtils.resultSetToTableModel(rs1));
					}
				} catch (Exception exceptie) {
					System.out.print(exceptie);
				}
			}
		});
		adaugare.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		adaugare.setBackground(new Color(144, 238, 144));
		adaugare.setBounds(33, 369, 200, 50);
		contentPane.add(adaugare);

		stergere = new JButton(" Stergere client");
		stergere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String table_id = table.getModel().getValueAt(row, 0).toString();
					int id = Integer.parseInt(table_id);
					int rs = OpDAO.opClient(id, nume.getText(), adresa.getText(), 2);
					if (rs != 0) {
						Client client = new Client();
						ResultSet rs1 = OpDAO.getLista(client);
						table.setModel(DbUtils.resultSetToTableModel(rs1));
					}
				} catch (Exception exceptie) {
					System.out.print(exceptie);
				}
			}
		});
		stergere.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		stergere.setBackground(new Color(205, 92, 92));
		stergere.setBounds(33, 440, 200, 50);
		contentPane.add(stergere);

		JLabel lblNewLabel = new JLabel("Nume");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 31, 70, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Adresa");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(33, 66, 70, 25);
		contentPane.add(lblNewLabel_1);

		nume = new JTextField();
		nume.setBounds(133, 31, 100, 25);
		contentPane.add(nume);
		nume.setColumns(10);

		adresa = new JTextField();
		adresa.setBounds(133, 66, 100, 25);
		contentPane.add(adresa);
		adresa.setColumns(10);

		editare = new JButton("Editare client");
		editare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String table_id = table.getModel().getValueAt(row, 0).toString();
					int id = Integer.parseInt(table_id);
					if(!(numeNou.getText().isBlank()) && !(adresaNoua.getText().isBlank())) {
						int rs = OpDAO.opClient(id, numeNou.getText(), adresaNoua.getText(), 1);
						if (rs != 0) {
							Client client = new Client();
							ResultSet rs1 = OpDAO.getLista(client);
							table.setModel(DbUtils.resultSetToTableModel(rs1));
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Introduceti va rog datele modificate");
				} catch (Exception exceptie) {
					System.out.print(exceptie);
				}
			}
		});
		editare.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		editare.setBackground(new Color(144, 238, 144));
		editare.setBounds(315, 313, 200, 50);
		contentPane.add(editare);

		JLabel nume_nou = new JLabel("Nume nou");
		nume_nou.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nume_nou.setBounds(33, 150, 100, 25);
		contentPane.add(nume_nou);

		JLabel aresa_noua = new JLabel("Adresa noua");
		aresa_noua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		aresa_noua.setBounds(33, 185, 102, 25);
		contentPane.add(aresa_noua);

		numeNou = new JTextField();
		numeNou.setColumns(10);
		numeNou.setBounds(133, 150, 100, 25);
		contentPane.add(numeNou);

		adresaNoua = new JTextField();
		adresaNoua.setColumns(10);
		adresaNoua.setBounds(133, 185, 100, 25);
		contentPane.add(adresaNoua);
	}

	public static JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
