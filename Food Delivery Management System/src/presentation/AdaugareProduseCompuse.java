package presentation;

import javax.swing.*;

import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import business.BaseProduct;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AdaugareProduseCompuse extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private static JTable table_1;
	private static JTextField title;
	DefaultTableModel model;

	public AdaugareProduseCompuse() {

		model = new DefaultTableModel();
		model.addColumn("Title");
		model.addColumn("Rating");
		model.addColumn("Calories");
		model.addColumn("Protein");
		model.addColumn("Fat");
		model.addColumn("Sodium");
		model.addColumn("Price");

		setTitle("Administrator");
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
		btnAfisareProduse.setBounds(326, 167, 200, 50);
		contentPane.add(btnAfisareProduse);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 516, 145);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				Vector<String> Row = new Vector<String>();
				Row.add((String) AdaugareProduseCompuse.getTable().getModel().getValueAt(row, 0));
				Row.add((String) AdaugareProduseCompuse.getTable().getModel().getValueAt(row, 1));
				Row.add((String) AdaugareProduseCompuse.getTable().getModel().getValueAt(row, 2));
				Row.add((String) AdaugareProduseCompuse.getTable().getModel().getValueAt(row, 3));
				Row.add((String) AdaugareProduseCompuse.getTable().getModel().getValueAt(row, 4));
				Row.add((String) AdaugareProduseCompuse.getTable().getModel().getValueAt(row, 5));
				Row.add((String) AdaugareProduseCompuse.getTable().getModel().getValueAt(row, 6));
				model.addRow(Row);

				// main.Controller.adaugareDateTabel(table.getSelectedRow());
			}
		});
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 227, 516, 61);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();

		JButton btnAdaugare = new JButton("Adaugare");
		btnAdaugare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.Controller.addCompProducts();
				model = new DefaultTableModel();
				model.addColumn("Title");
				model.addColumn("Rating");
				model.addColumn("Calories");
				model.addColumn("Protein");
				model.addColumn("Fat");
				model.addColumn("Sodium");
				model.addColumn("Price");
				table_1.setModel(model);
			}
		});
		table_1.setModel(model);
		scrollPane_1.setViewportView(table_1);

		btnAdaugare.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdaugare.setBackground(new Color(216, 191, 216));
		btnAdaugare.setBounds(326, 324, 200, 50);
		contentPane.add(btnAdaugare);
		
		JLabel lblNewLabel = new JLabel("Adaugati o denumire:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 314, 200, 30);
		contentPane.add(lblNewLabel);
		
		title = new JTextField();
		title.setBounds(10, 357, 200, 30);
		contentPane.add(title);
		title.setColumns(10);
	}

	public static JTable getTable() {
		return table;
	}

	public static JTable getTable_1() {
		return table_1;
	}

	public  static JTextField getTitleField() {
		return title;
	}
}
