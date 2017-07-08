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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
		setBounds(100, 100, 866, 483);
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
		contentPane.setBackground(c);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Adminstrator ");
		rdbtnAdmin.setBackground(SystemColor.textHighlight);
		rdbtnAdmin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		rdbtnAdmin.setBounds(436, 283, 115, 33);
		contentPane.add(rdbtnAdmin);
		
		JLabel lblNewLabel = new JLabel("E-mail :");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblNewLabel.setBounds(35, 247, 101, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(35, 285, 91, 27);
		contentPane.add(lblNewLabel_1);
		
		nemail = new JTextField();
		nemail.setBounds(166, 253, 101, 20);
		contentPane.add(nemail);
		nemail.setColumns(10);
		
		JLabel lblTypeOfUser = new JLabel("Type of User : ");
		lblTypeOfUser.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblTypeOfUser.setBounds(436, 250, 126, 20);
		contentPane.add(lblTypeOfUser);
		
		JRadioButton rdbtnUser = new JRadioButton("User");
		rdbtnUser.setBackground(SystemColor.textHighlight);
		rdbtnUser.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		rdbtnUser.setBounds(588, 285, 115, 29);
		contentPane.add(rdbtnUser);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnAdmin);
		group.add(rdbtnUser);
		
		npass = new JPasswordField();
		npass.setBounds(166, 291, 101, 20);
		contentPane.add(npass);
		
		JLabel lblEmail = new JLabel("Username :");
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblEmail.setBounds(35, 209, 101, 27);
		contentPane.add(lblEmail);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblName.setBounds(35, 171, 101, 27);
		contentPane.add(lblName);
		
		nname = new JTextField();
		nname.setBounds(166, 177, 101, 20);
		contentPane.add(nname);
		nname.setColumns(10);
		
		nuser = new JTextField();
		nuser.setBounds(166, 215, 101, 20);
		contentPane.add(nuser);
		nuser.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.setBounds(101, 338, 101, 33);
		contentPane.add(btnRegister);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(534, 338, 101, 33);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("Username :");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		label.setBounds(436, 141, 101, 27);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Password :");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		label_1.setBounds(436, 195, 91, 27);
		contentPane.add(label_1);
		
		ruser = new JTextField();
		ruser.setColumns(10);
		ruser.setBounds(547, 147, 101, 20);
		contentPane.add(ruser);
		
		rpass = new JPasswordField();
		rpass.setBounds(547, 195, 101, 20);
		contentPane.add(rpass);
		
		JLabel lblNewLabel_2 = new JLabel("Registered User");
		lblNewLabel_2.setFont(new Font("Segoe UI Semilight", Font.BOLD, 19));
		lblNewLabel_2.setBounds(462, 54, 212, 39);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(462, 106, 164, 2);
		contentPane.add(separator);
		
		JLabel lblNewLanewbel = new JLabel("New User... ?");
		lblNewLanewbel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblNewLanewbel.setBounds(81, 106, 185, 27);
		contentPane.add(lblNewLanewbel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(81, 146, 111, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(346, 43, 2, 328);
		contentPane.add(separator_2);
	}
}
