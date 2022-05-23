package presentation;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class LogInClient extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JTextField adr;
	private JTextField nrTelefon;
	private JTextField nume;

	public LogInClient() {
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user.setBounds(159, 307, 367, 43);
		contentPane.add(user);
		user.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(22, 309, 83, 32);
		contentPane.add(lblNewLabel_1);

		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pass.setBounds(159, 378, 367, 43);
		contentPane.add(pass);

		JLabel lblNewLabel_2 = new JLabel("Parola");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(22, 384, 114, 25);
		contentPane.add(lblNewLabel_2);

		JButton btnlogin = new JButton("Logare");
		btnlogin.setBackground(new Color(216, 191, 216));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Restaurant?serverTimezone=UTC&user=root&password=parolaIBD21");
					Statement stmt = con.createStatement();
					String sql = "Select * from Clienti where mail ='" + user.getText() + "' and parola='"
							+ pass.getText().toString() + "'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						GuiClient c = new GuiClient();
						c.show();
						dispose();
						// JOptionPane.showMessageDialog(null,"Login Successfully ");
					} else
						JOptionPane.showMessageDialog(null, "Wrong id and password ");
					con.close();
				} catch (Exception e) {
					System.out.print(e);
				}
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnlogin.setBounds(384, 442, 142, 61);
		contentPane.add(btnlogin);

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
		btnNewButton.setBounds(24, 442, 126, 61);
		contentPane.add(btnNewButton);

		JButton btnInregistrare = new JButton("Inregistrare");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Restaurant?serverTimezone=UTC&user=root&password=parolaIBD21");
					Statement stmt = con.createStatement();
					String sql = "Insert into Clienti (nume, adresa, telefon, mail, parola) values ('" + nume.getText()
							+ "', '" + adr.getText() + "', '" + nrTelefon.getText() + "', '" + user.getText() + "', '" + pass.getText().toString() + "');";
					int rs = stmt.executeUpdate(sql);
					con.close();
				} catch (Exception e) {
					System.out.print(e);
				}
			}
		});
		btnInregistrare.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInregistrare.setBackground(new Color(216, 191, 216));
		btnInregistrare.setBounds(384, 236, 142, 61);
		contentPane.add(btnInregistrare);

		JLabel adresa = new JLabel("Adresa");
		adresa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		adresa.setBounds(22, 113, 83, 32);
		contentPane.add(adresa);

		JLabel telefon = new JLabel("Nr. telefon");
		telefon.setFont(new Font("Tahoma", Font.PLAIN, 25));
		telefon.setBounds(22, 185, 128, 32);
		contentPane.add(telefon);

		adr = new JTextField();
		adr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		adr.setColumns(10);
		adr.setBounds(159, 111, 367, 43);
		contentPane.add(adr);

		nrTelefon = new JTextField();
		nrTelefon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nrTelefon.setColumns(10);
		nrTelefon.setBounds(159, 183, 367, 43);
		contentPane.add(nrTelefon);

		JLabel lblNume = new JLabel("Nume");
		lblNume.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNume.setBounds(22, 44, 83, 32);
		contentPane.add(lblNume);

		nume = new JTextField();
		nume.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nume.setColumns(10);
		nume.setBounds(159, 33, 367, 43);
		contentPane.add(nume);
	}
}
