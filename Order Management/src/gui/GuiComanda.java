package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import model.*;
import net.proteanit.sql.DbUtils;
import presentation.Interfata;
import javax.swing.JScrollPane;

public class GuiComanda extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField nume;
	private JTextField adresa;
	private JTextField denumire;
	private JTextField pret;
	private JTextField cantitate;
	private JButton afisareClienti;
	private JButton afisareProduse;
	private JButton adaugareComanda;
	
	public GuiComanda() {
		setTitle("COMENZI");
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
		scrollPane.setBounds(33, 29, 482, 147);
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
		
		afisareClienti = new JButton("Afisare clienti");
		afisareClienti.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		afisareClienti.addActionListener(new ActionListener() {
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
		afisareClienti.setBackground(new Color(144, 238, 144));
		afisareClienti.setBounds(315, 191, 200, 50);
		contentPane.add(afisareClienti);
		
		JLabel lblNewLabel = new JLabel("Nume");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(33, 204, 70, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel("Adresa");
		lblNewLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel2.setBounds(33, 254, 70, 25);
		contentPane.add(lblNewLabel2);
		
		nume = new JTextField();
		nume.setBounds(133, 206, 100, 25);
		contentPane.add(nume);
		nume.setColumns(10);
		
		adresa = new JTextField();
		adresa.setBounds(133, 254, 100, 25);
		contentPane.add(adresa);
		adresa.setColumns(10);
		
		afisareProduse = new JButton("Afisare produse");
		afisareProduse.addActionListener(new ActionListener() {
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
		afisareProduse.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		afisareProduse.setBackground(new Color(144, 238, 144));
		afisareProduse.setBounds(315, 250, 200, 50);
		contentPane.add(afisareProduse);
		
		adaugareComanda = new JButton("Adaugare comanda");
		adaugareComanda.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		adaugareComanda.setBackground(new Color(144, 238, 144));
		adaugareComanda.setBounds(315, 345, 200, 50);
		contentPane.add(adaugareComanda);
		
		JLabel lblNewLabel3 = new JLabel("Denumire");
		lblNewLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel3.setBounds(33, 320, 100, 25);
		contentPane.add(lblNewLabel3);
		
		JLabel lblNewLabel4 = new JLabel("Pret");
		lblNewLabel4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel4.setBounds(33, 363, 70, 25);
		contentPane.add(lblNewLabel4);
		
		denumire = new JTextField();
		denumire.setColumns(10);
		denumire.setBounds(133, 320, 100, 25);
		contentPane.add(denumire);
		
		pret = new JTextField();
		pret.setColumns(10);
		pret.setBounds(133, 365, 100, 25);
		contentPane.add(pret);
		
		JLabel lblCantitate = new JLabel("Cantitate");
		lblCantitate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCantitate.setBounds(33, 440, 100, 25);
		contentPane.add(lblCantitate);
		
		cantitate = new JTextField();
		cantitate.setColumns(10);
		cantitate.setBounds(133, 440, 100, 25);
		contentPane.add(cantitate);
	}

}
