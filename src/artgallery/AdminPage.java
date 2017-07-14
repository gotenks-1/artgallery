package artgallery;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JScrollPane;

import java.awt.Insets;


 class Orderitems{
	 static int or_id;
	 Date d;
     String uname;
     String delivered;
     double price;
     String disc_coupon;
     double finalprice;
     double discount;
     
     
     public Orderitems(int or_id,Date d,String uname,String delivered,double price,String disc_coupon,double finalprice,double discount)
     {
    	 this.or_id=or_id;
    	 this.d=d;
    	 this.uname=uname;
    	 this.price=price;
    	 this.delivered=delivered;
    	 this.finalprice=finalprice;
    	 this.disc_coupon=disc_coupon;
    	 this.discount=discount;
     }
     static public int getId(int or_id)
     {
    	 return or_id;
     }
}
 
 class Orderdetails{
	 int or_id;
	 int awork_id;
	 int quantity;
	 
	 public Orderdetails(int or_id,int awork_id,int quantity)
	 {
		 this.or_id=or_id;
		 this.awork_id=awork_id;
		 this.quantity=quantity;
	 }

	public Orderdetails(int int1, String string, String string2, double double1) {
		// TODO Auto-generated constructor stub
	}
	 
 }
 
 	 



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
	final	JComboBox comboBox_3;
	JLabel removeimg;
	JPanel card_order;
	final JFileChooser fc=new JFileChooser();
	final JFileChooser fcr=new JFileChooser();
	final JFileChooser fcc=new JFileChooser();
	File f,file;
	String path;int it,lists,artworks;
	ArrayList<Image> aImage=new ArrayList<Image>();
	int index=0;
	ArrayList<Orderitems> orderlists=new ArrayList<Orderitems>();
	ArrayList<Orderdetails> showdetails=new ArrayList<Orderdetails>();
	private JTextField textField_18;
	private JTextField textField_19;
	
//	final DefaultComboBoxModel cmodel;
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
		panel_4.setBounds(0, 0, 123, 121);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setBounds(0, 0, 123, 121);
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
		
		JButton btnViewOrders = new JButton("View orders");
		
		btnViewOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//addorder(Orderitems o,int j);
				
				
			cd.show(panel_1,"name_48452958741380");
			}

			public void getorder() {
				try{
					PreparedStatement allorders=(PreparedStatement) DBConnect.conn.prepareStatement("Select * from orders");
				    
					
					ResultSet orderset=allorders.executeQuery();
					//Orderitems odd= new Orderitems();
				//	Orderitems.getId(orderset.getInt(1));
					while(orderset.next())
					{
						Orderitems od=new Orderitems(orderset.getInt(1),orderset.getDate(2),orderset.getString(3),orderset.getString(4),orderset.getDouble(5),orderset.getString(6),orderset.getDouble(7),orderset.getDouble(8)); 
					     orderlists.add(od);
					}
											
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
				
			}
		});
		btnViewOrders.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnViewOrders.setContentAreaFilled(false);
		btnViewOrders.setBorder(null);
		btnViewOrders.setBounds(0, 345, 123, 23);
		panel.add(btnViewOrders);
		
		
		
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
		panel_5.setBounds(0, 0, 604, 118);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(118, 23, 321, 71);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
		panel_5.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 118, 604, 297);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_1.add(panel_2, "addartists");
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Artist name :");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(25, 111, 109, 30);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescription.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblDescription.setBounds(25, 166, 109, 30);
		panel_2.add(lblDescription);
		
		JLabel lblContact = new JLabel("contact :");
		lblContact.setHorizontalAlignment(SwingConstants.LEFT);
		lblContact.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblContact.setBounds(25, 226, 109, 30);
		panel_2.add(lblContact);
		
		textField = new JTextField();
		textField.setBounds(144, 113, 155, 30);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 168, 155, 30);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 228, 155, 30);
		panel_2.add(textField_2);
		
		JButton btnAddDetails = new JButton("Add details");
		btnAddDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String a_name=textField.getText();
				String des=textField_1.getText();
				String contact=textField_2.getText();
				String ratings=textField_18.getText();
				String max_rat=textField_19.getText();
				
			FileInputStream imginput=new FileInputStream(fcc.getSelectedFile());
						
			   DBConnect.addartist.setString(1,a_name);
				DBConnect.addartist.setString(2,des);
				DBConnect.addartist.setString(3,contact);
				//DBConnect.addartist.setString(4,contact);
				DBConnect.addartist.setString(4,ratings);
				DBConnect.addartist.setString(5,max_rat);
				DBConnect.addartist.setBlob(6, imginput);
				
				DBConnect.addartist.executeUpdate();
				JOptionPane.showMessageDialog(null, "added");
				
				}
				catch(Exception e)
				{   e.printStackTrace();
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnAddDetails.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnAddDetails.setBounds(444, 360, 132, 39);
		panel_2.add(btnAddDetails);
		
		JLabel lblNewLabel_4 = new JLabel("Add new artist");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(134, 11, 332, 57);
		panel_2.add(lblNewLabel_4);
		
		final JLabel arimage = new JLabel("");
		arimage.setBounds(423, 84, 153, 130);
		panel_2.add(arimage);
		
		JButton btnUploadImage = new JButton("Upload image");
		btnUploadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int artistimage=fcc.showOpenDialog(panel_2);
				if(artistimage==JFileChooser.APPROVE_OPTION)
				{
					File f=fcc.getSelectedFile();
					String p=f.getPath();
					ImageIcon icon=new ImageIcon((new ImageIcon(fcc.getSelectedFile().getPath()).getImage().getScaledInstance(arimage.getHeight(), arimage.getWidth(), Image.SCALE_DEFAULT)));
				    arimage.setIcon(icon);
				}
				
						
				
			}
		});
		btnUploadImage.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnUploadImage.setBounds(423, 225, 153, 30);
		panel_2.add(btnUploadImage);
		
		JLabel lblRating_1 = new JLabel("Rating :");
		lblRating_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblRating_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblRating_1.setBounds(25, 279, 109, 30);
		panel_2.add(lblRating_1);
		
		JLabel lblMaxArting = new JLabel("Max arting :");
		lblMaxArting.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxArting.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblMaxArting.setBounds(25, 336, 109, 30);
		panel_2.add(lblMaxArting);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(144, 286, 155, 30);
		panel_2.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(144, 336, 155, 30);
		panel_2.add(textField_19);
		
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
		
		
				
		
		final JComboBox comboBox = new JComboBox();
		ArrayList<String> arr=new ArrayList<String>();
		try
		{
			while(DBConnect.rs.next())
			{
				arr.add(DBConnect.rs.getString(1));
				
		     //   cmodel =new DefaultComboBoxModel(arr);
//				cmodel.addElement();
			comboBox.addItem(arr.get(arr.size()-1));	
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"hi");
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("action per"+comboBox.getSelectedItem().toString());
				try{
				String items=comboBox.getSelectedItem().toString();
				  int it=Integer.parseInt(items);
				DBConnect.removeartist.setInt(1,it);
//				System.out.println(DBConnect.removeartist.executeQ);
				
				
				ResultSet rs=DBConnect.removeartist.executeQuery();
				
				
				boolean st= rs.next();
				
				if(st)
				{
//       			System.out.println(rs.getObject(1).toString());
					textField_3.setText(rs.getObject(2).toString());
					textField_4.setText(rs.getObject(3).toString());
					textField_5.setText(rs.getObject(4).toString());
					int rat=rs.getInt((Integer) rs.getObject(5));
					int max_rat=rs.getInt(6);
					double ratings=rat*100.0/max_rat/20;
                    textField_6.setText(String.format("%.2g/5.0", ratings+0.05));
                   
                   // byte img[]=rs.getBytes(7);
                    removeimg.setIcon(new ImageIcon(new ImageIcon(rs.getBytes(7)).getImage().getScaledInstance(removeimg.getWidth(), removeimg.getHeight(),Image.SCALE_DEFAULT)));
                    
                  
				}
				
				JOptionPane.showMessageDialog(null, "displayed");
				
				}
				catch(Exception e)
				{    e.printStackTrace();
					JOptionPane.showMessageDialog(null,e);	
				}
				
			}
			
		});
		
		
//		comboBox.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent arg0) {
//				System.out.println("state chnge"+comboBox.getSelectedItem().toString());
//				
//			}
//		});
		comboBox.setBounds(186, 120, 131, 25);
		panel_7.add(comboBox);
		
		JLabel lblRating = new JLabel("Rating :");
		lblRating.setHorizontalAlignment(SwingConstants.CENTER);
		lblRating.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblRating.setBounds(35, 314, 131, 33);
		panel_7.add(lblRating);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(176, 175, 198, 25);
		panel_7.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(176, 219, 198, 25);
		panel_7.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(176, 266, 198, 25);
		panel_7.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(176, 314, 91, 25);
		panel_7.add(textField_6);
		
		JButton btnNewButton_1 = new JButton("Remove ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String items=comboBox.getSelectedItem().toString();
					  int it=Integer.parseInt(items);
					DBConnect.remove_artist.setInt(1,it);
					DBConnect.remove_artist.executeUpdate();
				   JOptionPane.showMessageDialog(null,"deleted..!!!" );
				   
				   
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
					
					
				}
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnNewButton_1.setBounds(395, 348, 158, 33);
		panel_7.add(btnNewButton_1);
		
		removeimg = new JLabel("");
		removeimg.setBounds(431, 84, 150, 132);
		panel_7.add(removeimg);
		
		final JPanel panel_8 = new JPanel();
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
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int val=fc.showOpenDialog(panel_8);
				
				if(val==JFileChooser.APPROVE_OPTION)
				{
					 f=fc.getSelectedFile();
					path=f.getPath();
				}
			}
		});
		btnChooseFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChooseFile.setBounds(149, 267, 133, 23);
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
				try{
					String art_name=textField_7.getText();
					String details=textField_8.getText();
					String cat=textField_9.getText();
					double price=Double.valueOf(textField_10.getText());
										
					FileInputStream fimage=new FileInputStream(f);
					
					DBConnect.addartwork.setString(1,details);
					DBConnect.addartwork.setString(2,art_name);
					DBConnect.addartwork.setDouble(3,price);
					DBConnect.addartwork.setInt(4,Integer.parseInt(comboBox_3.getSelectedItem().toString()));
					System.out.println(comboBox_3.getSelectedItem().toString());
					DBConnect.addartwork.setString(5,cat);
					DBConnect.addartwork.setBlob(6,fimage);
					
					DBConnect.addartwork.executeUpdate();
					JOptionPane.showMessageDialog(null,"added");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnNewButton_2.setBounds(390, 366, 185, 37);
		panel_8.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Add artworks ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(149, 11, 271, 46);
		panel_8.add(lblNewLabel_6);
		
		JLabel lblEnterArtistid = new JLabel("Enter artist_id :");
		lblEnterArtistid.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblEnterArtistid.setBounds(35, 315, 129, 24);
		panel_8.add(lblEnterArtistid);
		
		
	comboBox_3 = new JComboBox();
	ArrayList<String> arry=new ArrayList<String>();
	try
	{     
		DBConnect.rs=DBConnect.smt.executeQuery("select art_id from artist");
		while(DBConnect.rs.next())
		{
			arr.add(DBConnect.rs.getString(1));
//			System.out.println(DBConnect.rs.getString(1));
			
	     //   cmodel =new DefaultComboBoxModel(arr);
//			cmodel.addElement();
		comboBox_3.addItem(arr.get(arr.size()-1));	
		}
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,e);
	}
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String items=comboBox.getSelectedItem().toString();
				  it=Integer.parseInt(items);
				
					
			}
		});
		comboBox_3.setBounds(159, 319, 123, 20);
		panel_8.add(comboBox_3);
		
		
		final JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(153, 50, 204));
		panel_1.add(panel_9, "removeartworks");
		panel_9.setLayout(null);
		
		final JLabel aimage = new JLabel("");
		aimage.setBounds(403, 55, 191, 133);
		panel_9.add(aimage);
		try
		{
			ResultSet img=DBConnect.smt.executeQuery("select image from artworks");
			while(img.next()){
				byte[] getimage=img.getBytes("image");
				aImage.add(new ImageIcon(getimage).getImage());
						}
			ImageIcon ic=new ImageIcon(aImage.get(index).getScaledInstance(aimage.getWidth(), aimage.getHeight(), Image.SCALE_SMOOTH));
			aimage.setIcon(ic);
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	
		
		JButton btnNewButton_3 = new JButton("Update picture ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int im=fcr.showOpenDialog(panel_9);
				if(im==JFileChooser.APPROVE_OPTION)
				{
					 file=fcr.getSelectedFile();
					ImageIcon ic=new ImageIcon((new ImageIcon(fcr.getSelectedFile().getPath())).getImage().getScaledInstance(aimage.getWidth(), aimage.getHeight(), Image.SCALE_SMOOTH));
					aimage.setIcon(ic);	
				}
//				if(fc.getSelectedFile()!=null)
//				{
//					try {
//						PreparedStatement ps=(PreparedStatement) DBConnect.conn.prepareStatement("insert into artworks(image) values(?)");
//						InputStream imgg=new FileInputStream(f);
//						ps.setBlob(1,imgg);
//						ps.executeUpdate();
//						
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//				
		}
		});
		btnNewButton_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
		btnNewButton_3.setBounds(419, 226, 162, 23);
		panel_9.add(btnNewButton_3);
		
		JLabel lblName_1 = new JLabel("Artwork id :");
		lblName_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblName_1.setBounds(47, 110, 114, 19);
		panel_9.add(lblName_1);
		
		JLabel label = new JLabel(" Name :");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		label.setBounds(47, 157, 114, 19);
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
		
		final JComboBox comboBox_1 =  new JComboBox();
				ArrayList<String> aList=new ArrayList<String>();
		try{
			ResultSet rSet=DBConnect.smt.executeQuery("select a_id from artworks");
			while(rSet.next())
			{
				aList.add(rSet.getString(1));
				comboBox_1.addItem(aList.get(aList.size()-1));
		
			}
		//	JOptionPane.showMessageDialog(null,"list added");
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,e);			
		}
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String list=comboBox_1.getSelectedItem().toString();
				 artworks=Integer.parseInt(list);
				 
				   //ResultSet update=DBConnect.smt.execu
				
					DBConnect.update_artworks.setInt(1,artworks);
					
					ResultSet result=DBConnect.update_artworks.executeQuery();
					System.out.println(result);
					while(result.next())
					{   
						textField_11.setText(result.getObject(2).toString());
						textField_12.setText(result.getObject(1).toString());
						textField_13.setText(result.getObject(3).toString());
						textField_14.setText(result.getObject(4).toString());
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		comboBox_1.setBounds(171, 110, 89, 23);
		panel_9.add(comboBox_1);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					FileInputStream imgg=new FileInputStream(file);
					
					
					String name=textField_11.getText();
					String details=textField_12.getText();
					double pr=Double.parseDouble(textField_13.getText());
					String cat=textField_14.getText();
					
					DBConnect.updateartwork.setInt(7,artworks);
					DBConnect.updateartwork.setString(1,details);
					DBConnect.updateartwork.setString(2,name);
					DBConnect.updateartwork.setDouble(3,pr);
					DBConnect.updateartwork.setString(4,cat);
					DBConnect.updateartwork.setInt(5,lists);
					DBConnect.updateartwork.setBlob(6,imgg);
				  //DBConnect.updateartwork.setInt(8,artworks);
				 	
					DBConnect.updateartwork.executeUpdate();
					JOptionPane.showMessageDialog(null,"added");
				
				//	DBConnect.updateartwork.setString(2,);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				     e.printStackTrace();
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
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
		
		JLabel lblArtistId = new JLabel("Artist id :");
		lblArtistId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblArtistId.setBounds(47, 351, 114, 19);
		panel_9.add(lblArtistId);
		
		final JComboBox comboBox_4 = new JComboBox();
		ArrayList<String> al=new ArrayList<String>();
		try{
			ResultSet set=DBConnect.smt.executeQuery("select art_id from artist");
			
			while(set.next()){
				al.add(set.getString(1));
				comboBox_4.addItem(al.get(al.size()-1));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=comboBox_4.getSelectedItem().toString();
				lists=Integer.parseInt(s);
			}
		});
		comboBox_4.setBounds(171, 355, 89, 23);
		panel_9.add(comboBox_4);
		
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
		
		final JComboBox comboBox_2 = new JComboBox();
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
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String adname=textField_15.getText();
				String pass=textField_16.getText();
				String sq_ans=textField_17.getText();
				String sq=(String) comboBox_2.getSelectedItem();
				
				DBConnect.addadmin.setString(1,adname);
				DBConnect.addadmin.setString(2,pass);
				DBConnect.addadmin.setString(3,sq);
				DBConnect.addadmin.setString(4,sq_ans);
				
				DBConnect.addadmin.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"new admin added sucessfully");
				
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"not added");
				}
				
			}
		});
		btnNewButton_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnNewButton_5.setBounds(430, 362, 142, 37);
		panel_10.add(btnNewButton_5);
		
		
			
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(138, 43, 226));
		JScrollPane scrollOrder=new JScrollPane(panel_11);
		
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{608};
		
		
		
		int orderrow=orderlists.size();
		int[] getheightofrow=new int[orderrow];
		for(int i1=0;i1<orderrow;i1++)
		{
			getheightofrow[i1]=200;
			System.out.println("i am called");
		}
		
		gbl_panel_11.rowHeights =getheightofrow;
	//	gbl_panel_11.columnWeights = new double[]{Double.MIN_VALUE};
		//gbl_panel_11.rowWeights = new double[]{Double.MIN_VALUE};
		panel_11.setPreferredSize(new Dimension(608,200*orderrow));
		panel_11.setLayout(gbl_panel_11);
		
		
		panel_1.add(scrollOrder, "name_48452958741380");
		
		for(int j=0;j<orderlists.size();j++)
		{
			addorder(orderlists.get(j),j);
		}
		
		
		
		
		//System.out.println(panel_12.getPreferredSize());
	}
	
	

	 void addorder(Orderitems o, int j) {
		//int y=j/3;
		
		JPanel mPanel=new JPanel();
		mPanel.setLayout(null);
//		mPanel.setMaximumSize(new Dimension(608,200));
		card_order.add(mPanel);
		
		
		JLabel orderid=new JLabel("orderID");
		orderid.setBounds(0,0,100,50);
		card_order.add(orderid);
		
//		JLabel date=new JLabel("Date");
//		orderid.setBounds(50,50,100,50);
//		card_order.add(date);
//
//		JLabel name=new JLabel("username");
//		orderid.setBounds(50,50,100,50);
//		card_order.add(name);
//		
//		JLabel price=new JLabel("PRICE :");
//		orderid.setBounds(50,50,100,50);
//		card_order.add(price);

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = j;
		card_order.add(mPanel, gbc_panel);
			
		}

//	 void getorders(Orderitems orderitems) {
//		// TODO Auto-generated method stub
//		
//	}
}
