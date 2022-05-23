package presentation;
import java.sql.*;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import business.MenuItem;
import business.Order;

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
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GuiAngajat extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public GuiAngajat() {
		setTitle("Anagajat - restaurant");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 516, 169);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAfisareComenzi = new JButton("Afisare comenzi");
		btnAfisareComenzi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Title");
				model.addColumn("Data");

				for (Order tmp : main.Controller.getComenzi()) {
					Vector<String> row = new Vector<String>();
					row.add(tmp.getNumeClient());
					row.add(tmp.getData().toString());
					model.addRow(row);
					table.setModel(model);
				}
			}
		});
		btnAfisareComenzi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAfisareComenzi.setBackground(new Color(216, 191, 216));
		btnAfisareComenzi.setBounds(10, 222, 200, 61);
		contentPane.add(btnAfisareComenzi);
	}
}
