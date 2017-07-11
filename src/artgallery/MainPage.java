package artgallery;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

public class MainPage extends JFrame {

	private JPanel contentPane;
	static MainPage frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 174, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		//lblNewLabel.setIcon(new ImageIcon(MainPage.class.getResource("/image/artgallery.jpg")));
		lblNewLabel.setBounds(0, 0, 174, 174);
		panel.add(lblNewLabel);
		ImageIcon image=new ImageIcon(MainPage.class.getResource("/image/artgallery.jpg"));
		Image i=image.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
		image=new ImageIcon(i);
		lblNewLabel.setIcon(image);
	
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(175, 0, 557, 140);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(0, 0, 557, 140);
		panel_1.add(lblNewLabel_1);
		ImageIcon image1=new ImageIcon(MainPage.class.getResource("/image/art1.jpg"));
		Image i1=image1.getImage().getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
		image1=new ImageIcon(i1);
		lblNewLabel_1.setIcon(image1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(175, 141, 557, 34);
		contentPane.add(panel_2);
		
		JButton btnNewButton_3 = new JButton("Home ");
		btnNewButton_3.setBounds(0, 3, 135, 30);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Gallery");
		btnNewButton.setBounds(140, 3, 135, 30);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Contact us");
		btnNewButton_2.setBounds(280, 3, 135, 30);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Login/Register");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_1.setBounds(420, 3, 135, 30);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 175, 731, 271);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel sliderlabel = new JLabel("");
		sliderlabel.setBounds(0, 0, 731, 271);
		panel_3.add(sliderlabel);
		
//		Code for slider goes here
//		
//		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rectangle r1=frame.getBounds();
				LoginPage page=new LoginPage();
				page.setBounds(r1);
				dispose();
				page.setVisible(true);
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
