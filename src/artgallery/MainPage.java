package artgallery;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

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

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
		setBounds(100, 100, 659, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 299, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		//lblNewLabel.setIcon(new ImageIcon(MainPage.class.getResource("/image/artgallery.jpg")));
		lblNewLabel.setBounds(0, 0, 299, 174);
		panel.add(lblNewLabel);
		ImageIcon image=new ImageIcon("/image/artgallery.jpg");
		Image i=image.getImage().getScaledInstance(299,174,java.awt.Image.SCALE_SMOOTH);
		image=new ImageIcon(i);
	//lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/image/artgallery.jpg")).getImage().getScaledInstance(299,174,Image.SCALE_DEFAULT));
	//ImageIcon image=new ImageIcon(("/image/artgallery.jpg").getScaledInstance(299,174,java.awt.Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(image);
	
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(300, 11, 343, 100);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(300, 137, 343, 37);
		contentPane.add(panel_2);
		
		JButton btnNewButton_3 = new JButton("Home ");
		btnNewButton_3.setBounds(3, 5, 63, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Gallery");
		btnNewButton.setBounds(71, 5, 65, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Contact us");
		btnNewButton_2.setBounds(141, 5, 85, 23);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Login/Register");
		btnNewButton_1.setBounds(231, 5, 101, 23);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel_1.setBounds(47, 185, 159, 181);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel_2.setBounds(249, 185, 159, 181);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel_3.setBounds(443, 185, 159, 181);
		contentPane.add(lblNewLabel_3);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoginPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
