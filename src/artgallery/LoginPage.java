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
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	DBConnect db=new DBConnect();

	/**
	 * Launch the application.
	 */
	boolean validatename(String s){
		if(s.length()>2)
			return true;
		else
			return false;
	}
	
	boolean validateuser(String s){
		if(s.length()<2)
			return false;
		String qry="select * from users where username='"+s+"'";
		try {
			ResultSet rs=db.smt.executeQuery(qry);
			rs.last();
			if(rs.getRow()>0)
				return false;
			else
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	boolean validateemail(String s){
		int d=0;
		boolean found=false;
		if(s.length()<4)
			return false;
		char []ch=s.toCharArray();
		for(char c:ch){
			if(c=='@')
				found=true;
			if(found){
				if(c=='.'){
					if(d>=2)
						return true;
					else
						return false;
				}
				else
					d++;
			}
		}
		return false;
		
	}
	
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
		contentPane.setBackground(UIManager.getColor("info"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("info"));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(383, 120, 322, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JRadioButton rdbtnAdmin = new JRadioButton("Admin");
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
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	JRadioButton b= (JRadioButton)e.getSource();
				
				String uname=ruser.getText();
				String upass=String.valueOf(rpass.getPassword());
			if(rdbtnAdmin.isSelected())
				{
					String qry="select * from adminlogin where username='"+uname+"' and pass='"+upass+"'";
					try {
						ResultSet rs=db.smt.executeQuery(qry);
						if(rs.last()&&rs.getRow()==1){
							new AdminPage().setVisible(true);
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(null,"Invalid Username/Password");
						}
					} 
					catch (Exception e1) {
						e1.printStackTrace();
					}
				
				}
				else
				{
					String qry="select * from users where username='"+uname+"' and pass='"+upass+"'";
					try {
						ResultSet rs=db.smt.executeQuery(qry);
						if(rs.last()&&rs.getRow()==1){
							new RegistereduserPage(uname).setVisible(true);
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(null,"Invalid Username/Password");
						}
					} 
					catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
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
		registerpanel.setBounds(15, 120, 309, 287);
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
			public void actionPerformed(ActionEvent e) {
				String rname=nname.getText();
				String ruser=nuser.getText();
				String rpass=String.valueOf(npass.getPassword());
				String remail=nemail.getText();
				
				if(validatename(rname)){
					if(ruser.length()>2){
						if(validateuser(ruser)){
							if(validateemail(remail)){
								String sql="insert into users(name,username,pass,email) values(?,?,?,?)";
								try {
									PreparedStatement ps=db.conn.prepareStatement(sql);
									ps.setString(1, rname);
									ps.setString(2, ruser);
									ps.setString(3, rpass);
									ps.setString(4, remail);
									ps.executeUpdate();
									JOptionPane.showMessageDialog(contentPane,"Registered Successfully");

									new RegistereduserPage(ruser).setVisible(true);
									dispose();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
							}
							else{
								JOptionPane.showMessageDialog(contentPane,"Enter valid email");
							}
						}
						else{
							JOptionPane.showMessageDialog(contentPane,"Username already exists. Choose another username");
						}
					}
					else{
						JOptionPane.showMessageDialog(contentPane,"Username should be greater than 2 characters");
					}
				}
				else{
					JOptionPane.showMessageDialog(contentPane,"Enter valid name");
				}
				
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
		separator_2.setBounds(350, 120, 2, 287);
		contentPane.add(separator_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 99, 99);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel logolabel = new JLabel("");
		logolabel.setBounds(0, 0, 99, 99);
		panel_1.add(logolabel);
		ImageIcon ic=new ImageIcon(new ImageIcon(LoginPage.class.getResource("/image/artgallery.jpg")).getImage().getScaledInstance(panel_1.getWidth(), panel_1.getHeight(), Image.SCALE_SMOOTH));
		logolabel.setIcon(ic);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(99, 0, 633, 99);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel labelname = new JLabel("");
		labelname.setBounds(0, 0, 633, 99);
		panel_2.add(labelname);
		ImageIcon ic1=new ImageIcon(new ImageIcon(LoginPage.class.getResource("/image/art1.jpg")).getImage().getScaledInstance(panel_2.getWidth(), panel_2.getHeight(), Image.SCALE_SMOOTH));
		labelname.setIcon(ic1);
	}
}
