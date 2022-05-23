package presentation;

import javax.swing.*;

import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import business.BaseProduct;
import business.DeliveryService;
import main.Controller;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AdaugareComanda extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	DefaultTableModel model;
	private static JTable table_1;
	private JTextField nume;
	private JTextField adresa;

	public AdaugareComanda() {
		model = new DefaultTableModel();
		model.addColumn("Title");
		model.addColumn("Price");

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
				GuiClient gClient = new GuiClient();
				gClient.show();
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
					main.Controller.generareProduse();
					// table.setModel(model);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAfisareProduse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAfisareProduse.setBackground(new Color(216, 191, 216));
		btnAfisareProduse.setBounds(326, 167, 200, 50);
		contentPane.add(btnAfisareProduse);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 516, 150);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				Vector<String> Row = new Vector<String>();
				Row.add((String) AdaugareComanda.getTable().getModel().getValueAt(row, 0));
				Row.add((String) AdaugareComanda.getTable().getModel().getValueAt(row, 1));
				model.addRow(Row);
			}
		});
		
		scrollPane.setViewportView(table);

		JButton btnPlasareComanda = new JButton("Plasare comanda");
		btnPlasareComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DeliveryService dS = new DeliveryService();
					dS.adaugareComanda(nume.getText().toString(), adresa.getText().toString());
					// table.setModel(model);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPlasareComanda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlasareComanda.setBackground(new Color(216, 191, 216));
		btnPlasareComanda.setBounds(10, 447, 200, 50);
		contentPane.add(btnPlasareComanda);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 225, 516, 81);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(model);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("Nume");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(25, 344, 200, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adresa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(25, 380, 200, 25);
		contentPane.add(lblNewLabel_1);
		
		nume = new JTextField();
		nume.setBounds(376, 347, 150, 25);
		contentPane.add(nume);
		nume.setColumns(10);
		
		adresa = new JTextField();
		adresa.setBounds(376, 383, 150, 25);
		contentPane.add(adresa);
		adresa.setColumns(10);
	}

	public static JTable getTable() {
		return table;
	}
	
	public static JTable getTable_1() {
		return table_1;
	}
}
