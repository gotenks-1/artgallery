package artgallery;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	CardLayout cd;
	JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,731,445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184,207,229));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 123, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add artist");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.show(panel_1,"addartists");
			}
		});
		btnNewButton.setBounds(0, 166, 123, 23);
		panel.add(btnNewButton);
		
		JButton btnRemoveArtist = new JButton("Remove artist");
		btnRemoveArtist.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoveArtist.setContentAreaFilled(false);
		btnRemoveArtist.setBorder(null);
		btnRemoveArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.show(panel_1,"removeartist");
			}
		});
		btnRemoveArtist.setBounds(0, 200, 123, 23);
		panel.add(btnRemoveArtist);
		
		JButton btnAddArtworks = new JButton("Add artworks");
		btnAddArtworks.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddArtworks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.show(panel_1,"addartworks");
			}
		});
		btnAddArtworks.setContentAreaFilled(false);
		btnAddArtworks.setBorder(null);
		btnAddArtworks.setBounds(0, 234, 123, 23);
		panel.add(btnAddArtworks);
		
		JButton btnRemoveArtworks = new JButton("Update artworks");
		btnRemoveArtworks.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoveArtworks.setContentAreaFilled(false);
		btnRemoveArtworks.setBorder(null);
		btnRemoveArtworks.setBounds(0, 268, 133, 32);
		btnRemoveArtworks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.show(panel_1, "removeartworks");
			}
		});
		
		panel.add(btnRemoveArtworks);
		
		JButton btnAddAdmin = new JButton("Add admin");
		btnAddAdmin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cd.show(panel_1,"addadmin");
			}
		});
		btnAddAdmin.setContentAreaFilled(false);
		btnAddAdmin.setBorder(null);
		btnAddAdmin.setBounds(0, 311, 123, 23);
		panel.add(btnAddAdmin);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(0, 0, 123, 111);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setBounds(0, 0, 123, 111);
		panel_4.add(lblNewLabel_1);
		ImageIcon image=new ImageIcon(AdminPage.class.getResource("/image/artgallery.jpg"));
		Image i=image.getImage().getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
		image=new ImageIcon(i);
		lblNewLabel_1.setIcon(image);
		
		JButton btnNewButton_6 = new JButton("Home Page ");
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBorder(null);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.show(panel_1,"home_panel" );
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_6.setBounds(0, 132, 123, 23);
		panel.add(btnNewButton_6);
		
		
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(124, 0, 608, 445);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		cd=(CardLayout)panel_1.getLayout();
				
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.info);
		panel_1.add(panel_3, "home_panel");
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBounds(0, 0, 604, 89);
		panel_3.add(panel_5);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_5.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 89, 604, 326);
		panel_3.add(panel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_1.add(panel_2, "addartists");
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Artist name :");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(55, 113, 109, 30);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescription.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblDescription.setBounds(55, 186, 109, 30);
		panel_2.add(lblDescription);
		
		JLabel lblContact = new JLabel("contact :");
		lblContact.setHorizontalAlignment(SwingConstants.LEFT);
		lblContact.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblContact.setBounds(55, 257, 109, 30);
		panel_2.add(lblContact);
		
		textField = new JTextField();
		textField.setBounds(177, 113, 236, 30);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(177, 186, 236, 30);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(177, 257, 236, 30);
		panel_2.add(textField_2);
		
		JButton btnAddDetails = new JButton("Add details");
		btnAddDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String a_name=textField.getText();
				String des=textField.getText();
				String contact=textField.getText();
				
				DBConnect.addartist.setString(1,a_name);
				DBConnect.addartist.setString(2,des);
				DBConnect.addartist.setString(3,contact);
				
				DBConnect.addartist.executeUpdate();
				JOptionPane.showMessageDialog(null, "added");
				
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnAddDetails.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnAddDetails.setBounds(386, 336, 132, 39);
		panel_2.add(btnAddDetails);
		
		JLabel lblNewLabel_4 = new JLabel("Add new artist");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(134, 11, 332, 57);
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 192, 203));
		panel_1.add(panel_7, "removeartist");
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Enter artist id :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(35, 112, 131, 33);
		panel_7.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Remove artist ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(124, 11, 339, 62);
		panel_7.add(lblNewLabel_5);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblName.setBounds(35, 169, 131, 33);
		panel_7.add(lblName);
		
		JLabel lblDescription_1 = new JLabel("Description :");
		lblDescription_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblDescription_1.setBounds(35, 213, 131, 33);
		panel_7.add(lblDescription_1);
		
		JLabel lblEnterArtistId = new JLabel("Contact :");
		lblEnterArtistId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterArtistId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblEnterArtistId.setBounds(35, 260, 131, 33);
		panel_7.add(lblEnterArtistId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(186, 120, 131, 25);
		panel_7.add(comboBox);
		
		JLabel lblRating = new JLabel("Rating :");
		lblRating.setHorizontalAlignment(SwingConstants.CENTER);
		lblRating.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblRating.setBounds(35, 314, 131, 33);
		panel_7.add(lblRating);
		
		textField_3 = new JTextField();
		textField_3.setBounds(176, 175, 198, 25);
		panel_7.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(176, 219, 198, 25);
		panel_7.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(176, 266, 198, 25);
		panel_7.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(176, 314, 91, 25);
		panel_7.add(textField_6);
		
		JButton btnNewButton_1 = new JButton("Remove ");
		btnNewButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnNewButton_1.setBounds(395, 348, 158, 33);
		panel_7.add(btnNewButton_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(173, 255, 47));
		panel_1.add(panel_8, "addartworks");
		panel_8.setLayout(null);
		
		JLabel lblDetails = new JLabel("Name of artwork :");
		lblDetails.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblDetails.setBounds(35, 93, 129, 24);
		panel_8.add(lblDetails);
		
		JLabel lblNameOfArtwork = new JLabel("Details :");
		lblNameOfArtwork.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNameOfArtwork.setBounds(35, 135, 129, 24);
		panel_8.add(lblNameOfArtwork);
		
		JLabel lblNameOfArtwork_1 = new JLabel("Category of artwork :");
		lblNameOfArtwork_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNameOfArtwork_1.setBounds(35, 175, 149, 24);
		panel_8.add(lblNameOfArtwork_1);
		
		JLabel lblNameOfArtwork_2 = new JLabel("Price : ");
		lblNameOfArtwork_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNameOfArtwork_2.setBounds(35, 220, 129, 24);
		panel_8.add(lblNameOfArtwork_2);
		
		JLabel lblImage = new JLabel("Image : ");
		lblImage.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblImage.setBounds(35, 266, 129, 24);
		panel_8.add(lblImage);
		
		JButton btnChooseFile = new JButton("Choose file");
		btnChooseFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChooseFile.setBounds(127, 269, 154, 23);
		panel_8.add(btnChooseFile);
		
		textField_7 = new JTextField();
		textField_7.setBounds(182, 93, 196, 24);
		panel_8.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(182, 135, 196, 24);
		panel_8.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(182, 175, 196, 24);
		panel_8.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(182, 220, 196, 24);
		panel_8.add(textField_10);
		
		JButton btnNewButton_2 = new JButton("Add artworks");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnNewButton_2.setBounds(385, 333, 185, 37);
		panel_8.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Add artworks ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(149, 11, 271, 46);
		panel_8.add(lblNewLabel_6);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(153, 50, 204));
		panel_1.add(panel_9, "removeartworks");
		panel_9.setLayout(null);
		
		JLabel aimage = new JLabel("New label");
		aimage.setBounds(403, 55, 191, 133);
		panel_9.add(aimage);
		
		JButton btnNewButton_3 = new JButton("Update picture ");
		btnNewButton_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		btnNewButton_3.setBounds(419, 226, 162, 23);
		panel_9.add(btnNewButton_3);
		
		JLabel lblName_1 = new JLabel("Artwork id :");
		lblName_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblName_1.setBounds(47, 110, 114, 19);
		panel_9.add(lblName_1);
		
		JLabel label = new JLabel(" Name :");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		label.setBounds(47, 159, 114, 19);
		panel_9.add(label);
		
		JLabel lblDetails_1 = new JLabel("Details :");
		lblDetails_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblDetails_1.setBounds(47, 203, 114, 19);
		panel_9.add(lblDetails_1);
		
		JLabel lblName_2 = new JLabel("Price :");
		lblName_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblName_2.setBounds(47, 254, 114, 19);
		panel_9.add(lblName_2);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblCategory.setBounds(47, 305, 114, 19);
		panel_9.add(lblCategory);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(171, 110, 89, 23);
		panel_9.add(comboBox_1);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		btnNewButton_4.setBounds(403, 355, 162, 35);
		panel_9.add(btnNewButton_4);
		
		textField_11 = new JTextField();
		textField_11.setBounds(174, 158, 143, 20);
		panel_9.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(174, 204, 143, 20);
		panel_9.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(171, 255, 143, 20);
		panel_9.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(174, 306, 143, 20);
		panel_9.add(textField_14);
		
		JLabel lblUpdateArtworks = new JLabel("Update Artworks");
		lblUpdateArtworks.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateArtworks.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblUpdateArtworks.setBounds(96, 11, 272, 53);
		panel_9.add(lblUpdateArtworks);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 0));
		panel_1.add(panel_10, "addadmin");
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Add More Admins ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(135, 11, 278, 58);
		panel_10.add(lblNewLabel_7);
		
		JLabel lblUsername = new JLabel(" Username : ");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblUsername.setBounds(46, 111, 113, 28);
		panel_10.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblPassword.setBounds(46, 172, 113, 28);
		panel_10.add(lblPassword);
		
		JLabel lblSequrityQuestion = new JLabel("Sequrity Question :");
		lblSequrityQuestion.setHorizontalAlignment(SwingConstants.LEFT);
		lblSequrityQuestion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblSequrityQuestion.setBounds(46, 229, 142, 28);
		panel_10.add(lblSequrityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer :");
		lblAnswer.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnswer.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblAnswer.setBounds(46, 290, 113, 28);
		panel_10.add(lblAnswer);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Your place of birth ?", "what is your pet name ?", "which is your favourite book ?", "Your favourite sport ?"}));
		comboBox_2.setBounds(194, 233, 186, 24);
		panel_10.add(comboBox_2);
		
		textField_15 = new JTextField();
		textField_15.setBounds(194, 117, 186, 20);
		panel_10.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(194, 178, 186, 20);
		panel_10.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(194, 296, 186, 20);
		panel_10.add(textField_17);
		
		JButton btnNewButton_5 = new JButton("Add ");
		btnNewButton_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnNewButton_5.setBounds(430, 362, 142, 37);
		panel_10.add(btnNewButton_5);
	}
}
