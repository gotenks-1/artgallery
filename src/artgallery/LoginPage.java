package artgallery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;

//import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.swing.JMenuBar;
//import javax.swing.JMenu;
//
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
//
//import javax.swing.ButtonGroup;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JRadioButton;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField nemail;
	private JPasswordField npass;
	private JTextField nname;
	private JTextField nuser;
	private JTextField ruser;
	private JPasswordField rpass;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Color c=new Color(216, 186, 186);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnLogin = new JMenu("HOME ");
		mnLogin.setForeground(Color.WHITE);
		mnLogin.setBackground(Color.BLACK);
		mnLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		menuBar.add(mnLogin);
		
		JMenu mnLogout = new JMenu("About Us");
		mnLogout.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mnLogout.setForeground(Color.WHITE);
		mnLogout.setBackground(Color.BLACK);
		menuBar.add(mnLogout);
		
		JMenu mnContactUs = new JMenu("Contact us");
		mnContactUs.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		mnContactUs.setForeground(Color.WHITE);
		mnContactUs.setBackground(Color.BLACK);
		menuBar.add(mnContactUs);
		contentPane.setBackground(UIManager.getColor("info"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("info"));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(379, 82, 322, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		buttonGroup.add(rdbtnAdmin);
		rdbtnAdmin.setBounds(146, 152, 90, 33);
		panel.add(rdbtnAdmin);
		rdbtnAdmin.setBackground(UIManager.getColor("info"));
		rdbtnAdmin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		
		JRadioButton rdbtnUser = new JRadioButton("User");
		buttonGroup.add(rdbtnUser);
		rdbtnUser.setBounds(240, 154, 76, 29);
		panel.add(rdbtnUser);
		rdbtnUser.setSelected(true);
		rdbtnUser.setBackground(UIManager.getColor("info"));
		rdbtnUser.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(5, 189, 303, 33);
		panel.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label = new JLabel("Username :");
		label.setBounds(5, 78, 157, 27);
		panel.add(label);
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("Password :");
		label_1.setBounds(5, 117, 159, 27);
		panel.add(label_1);
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		
		ruser = new JTextField();
		ruser.setBounds(182, 83, 126, 20);
		panel.add(ruser);
		ruser.setColumns(10);
		
		rpass = new JPasswordField();
		rpass.setBounds(182, 122, 126, 20);
		panel.add(rpass);
		
		JLabel lblNewLabel_2 = new JLabel("Registered User");
		lblNewLabel_2.setBounds(8, 17, 212, 39);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI Semilight", Font.BOLD, 19));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(5, 56, 311, 13);
		panel.add(separator);
		
		JPanel registerpanel = new JPanel();
		registerpanel.setBackground(UIManager.getColor("info"));
		registerpanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		registerpanel.setBounds(15, 84, 309, 287);
		contentPane.add(registerpanel);
		registerpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-mail :");
		lblNewLabel.setBounds(5, 158, 155, 27);
		registerpanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setBounds(5, 196, 155, 27);
		registerpanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		
		nemail = new JTextField();
		nemail.setBounds(178, 169, 126, 20);
		registerpanel.add(nemail);
		nemail.setColumns(10);
		
		npass = new JPasswordField();
		npass.setBounds(178, 207, 126, 20);
		registerpanel.add(npass);
		
		JLabel lblEmail = new JLabel("Username :");
		lblEmail.setBounds(5, 120, 155, 27);
		registerpanel.add(lblEmail);
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(5, 82, 155, 27);
		registerpanel.add(lblName);
		lblName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		
		nname = new JTextField();
		nname.setBounds(178, 93, 126, 20);
		registerpanel.add(nname);
		nname.setColumns(10);
		
		nuser = new JTextField();
		nuser.setBounds(178, 131, 126, 20);
		registerpanel.add(nuser);
		nuser.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(5, 239, 299, 33);
		registerpanel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLanewbel = new JLabel("Need an Account?");
		lblNewLanewbel.setBounds(5, 17, 185, 27);
		registerpanel.add(lblNewLanewbel);
		lblNewLanewbel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(5, 52, 299, 2);
		registerpanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(350, 84, 2, 287);
		contentPane.add(separator_2);
	}
}
