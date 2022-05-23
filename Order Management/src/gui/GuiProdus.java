package gui;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.OpDAO;
import presentation.Interfata;
import javax.swing.JScrollPane;
import model.*;
import net.proteanit.sql.DbUtils;

public class GuiProdus extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField denumire;
	private JTextField pret;
	private JTextField cantitate;
	private JButton afisare;
	private JButton adaugare;
	private JButton editare;
	private JButton stergere;
	private JLabel dateActualizate;
	private JLabel d;
	private JLabel p;
	private JLabel c;
	private JTextField denumireNoua;
	private JTextField pretNou;
	private JTextField cantitateNoua;

	public JButton getAfisare() {
		return afisare;
	}

	public GuiProdus() {
		setTitle("PRODUSE");
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

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table.getSelectedRow();
					String table_nume = table.getModel().getValueAt(row, 1).toString();
					String table_pret = table.getModel().getValueAt(row, 2).toString();
					String table_cantitate = table.getModel().getValueAt(row, 3).toString();
					denumire.setText(table_nume);
					pret.setText(table_pret);
					cantitate.setText(table_cantitate);
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3);
				}
			}
		});
		scrollPane.setViewportView(table);

		afisare = new JButton("Afisare produse");
		afisare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Produs produs = new Produs();
					ResultSet rs = OpDAO.getLista(produs);
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

		adaugare = new JButton("Adaugare produs");
		adaugare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					float pretFLOAT = Float.parseFloat(pret.getText());
					int cantINT = Integer.parseInt(cantitate.getText());
					int rs = OpDAO.opProdus(1, denumire.getText(), pretFLOAT, cantINT, 0);
					if (rs != 0) {
						Produs produs = new Produs();
						ResultSet rs1 = OpDAO.getLista(produs);
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

		stergere = new JButton("Stergere produs");
		stergere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String table_id = table.getModel().getValueAt(row, 0).toString();
					int id = Integer.parseInt(table_id);
					float pretFLOAT = Float.parseFloat(pret.getText());
					int cantINT = Integer.parseInt(cantitate.getText());
					int rs = OpDAO.opProdus(id, denumire.getText(), pretFLOAT, cantINT, 2);
					if (rs != 0) {
						Produs produs = new Produs();
						ResultSet rs1 = OpDAO.getLista(produs);
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

		JLabel lblNewLabel = new JLabel("Denumire");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 30, 100, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Pret ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(33, 60, 100, 25);
		contentPane.add(lblNewLabel_1);

		denumire = new JTextField();
		denumire.setBounds(133, 30, 100, 25);
		contentPane.add(denumire);
		denumire.setColumns(10);

		pret = new JTextField();
		pret.setBounds(133, 60, 100, 25);
		contentPane.add(pret);
		pret.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Cantitate");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(33, 90, 100, 25);
		contentPane.add(lblNewLabel_1_1);

		cantitate = new JTextField();
		cantitate.setColumns(10);
		cantitate.setBounds(133, 90, 100, 25);
		contentPane.add(cantitate);

		editare = new JButton("Editare produs");
		editare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String table_id = table.getModel().getValueAt(row, 0).toString();
					int id = Integer.parseInt(table_id);
					if (!(denumireNoua.getText().isBlank()) && !(pretNou.getText().isBlank())
							&& !(cantitateNoua.getText().isBlank())) {
						int rs = OpDAO.opProdus(id, denumireNoua.getText(), Float.parseFloat(pretNou.getText()),
								Integer.parseInt(cantitateNoua.getText()), 1);
						if (rs != 0) {
							Produs produs = new Produs();
							ResultSet rs1 = OpDAO.getLista(produs);
							table.setModel(DbUtils.resultSetToTableModel(rs1));
						}
					} else
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

		dateActualizate = new JLabel("Date actualizate:");
		dateActualizate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dateActualizate.setBounds(33, 145, 200, 25);
		contentPane.add(dateActualizate);

		d = new JLabel("Denumire");
		d.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		d.setBounds(33, 180, 100, 25);
		contentPane.add(d);

		p = new JLabel("Pret ");
		p.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		p.setBounds(33, 210, 100, 25);
		contentPane.add(p);

		c = new JLabel("Cantitate");
		c.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		c.setBounds(33, 240, 100, 25);
		contentPane.add(c);

		denumireNoua = new JTextField();
		denumireNoua.setColumns(10);
		denumireNoua.setBounds(133, 180, 100, 25);
		contentPane.add(denumireNoua);

		pretNou = new JTextField();
		pretNou.setColumns(10);
		pretNou.setBounds(133, 210, 100, 25);
		contentPane.add(pretNou);

		cantitateNoua = new JTextField();
		cantitateNoua.setColumns(10);
		cantitateNoua.setBounds(133, 240, 100, 25);
		contentPane.add(cantitateNoua);
	}

}
