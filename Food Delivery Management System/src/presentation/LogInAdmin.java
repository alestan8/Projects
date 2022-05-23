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

public class LogInAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	public LogInAdmin() {
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user.setBounds(66, 103, 367, 43);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(66, 51, 83, 32);
		contentPane.add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pass.setBounds(66, 277, 367, 43);
		contentPane.add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("Parola");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(66, 226, 114, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton btnlogin = new JButton("Logare");
		btnlogin.setBackground(new Color(216, 191, 216));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant?serverTimezone=UTC&user=root&password=parolaIBD21");
					Statement stmt=con.createStatement();
					String sql="Select * from Administrator where mail ='"+user.getText()+"' and parola='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						GuiAdministrator c = new GuiAdministrator();
						c.show();
						dispose();
						//JOptionPane.showMessageDialog(null,"Login Successfully ");
					}
					else
						JOptionPane.showMessageDialog(null,"Wrong id and password ");
					con.close();
				}catch(Exception e) {System.out.print(e);}
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnlogin.setBounds(318, 390, 142, 61);
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
		btnNewButton.setBounds(66, 390, 126, 61);
		contentPane.add(btnNewButton);
	}
}
