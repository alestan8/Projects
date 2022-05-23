package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private LogInAdmin logare;
	
	public Main() {
		setTitle("Restaurant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton admin_1 = new JButton("Administrator");
		admin_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogInAdmin log = new LogInAdmin();
				log.show();
				dispose();
			}
		});
		admin_1.setBackground(new Color(216, 191, 216));
		admin_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		admin_1.setBounds(152, 84, 250, 70);
		contentPane.add(admin_1);
		
		JButton client_1 = new JButton("Client");
		client_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogInClient log = new LogInClient();
				log.show();
				dispose();
			}
		});
		client_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		client_1.setBackground(new Color(216, 191, 216));
		client_1.setBounds(152, 230, 250, 70);
		contentPane.add(client_1);
		
		JButton angajat_1 = new JButton("Angajat");
		angajat_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogInAngajat log = new LogInAngajat();
				log.show();
				dispose();
			}
		});
		angajat_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		angajat_1.setBackground(new Color(216, 191, 216));
		angajat_1.setBounds(152, 369, 250, 70);
		contentPane.add(angajat_1);
	}
}
