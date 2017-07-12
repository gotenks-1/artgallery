package artgallery;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;

class ArtistNode{
	int id;
	String name;
	String desc;
	String cont;
	int cur_rat;
	int max_rat;
	
	public ArtistNode(int id,String name,String desc,String cont,int cur,int max) {
		this.id=id;
		this.name=name;
		this.desc=desc;
		this.cont=cont;
		this.cur_rat=cur;
		this.max_rat=max;		
	}
}

class ArtworkNode{
	int id;
	String details;
	String name;
	float price;
	int artist_id;
	int qty_left;
	int sold;
	String category;
	byte[] icon;
	
	public ArtworkNode(int id,String details,String name,float price,int artist_id,int qty_left,int sold,String category,byte[] icon){
		this.id=id;
		this.details=details;
		this.name=name;
		this.price=price;
		this.artist_id=artist_id;
		this.qty_left=qty_left;
		this.sold=sold;
		this.category=category;
		this.icon=icon;
	}
}


public class RegistereduserPage extends JFrame {

	private JPanel contentPane;
	private CardLayout card;
	private JPanel panel_container;
	private String username;
	private ArrayList<ArtistNode> artistList=new ArrayList<ArtistNode>();

	/**
	 * Launch the application.
	 */
	
	void welcomeMessage(){
		JOptionPane.showMessageDialog(contentPane, "Welcome"+username);
	}
	
	JPanel artistpanel(){
		JPanel mainPanel=new JPanel();
		
		
		
		return mainPanel;
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistereduserPage frame = new RegistereduserPage("guest");
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
	public RegistereduserPage(String u_main) {
		username=u_main;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_logo = new JPanel();
		panel_logo.setBounds(0, 0, 99, 99);
		contentPane.add(panel_logo);
		panel_logo.setLayout(null);
		
		JLabel logolabel = new JLabel("");
		logolabel.setBounds(0, 0, 99, 99);
		panel_logo.add(logolabel);
		ImageIcon ic=new ImageIcon(new ImageIcon(RegistereduserPage.class.getResource("/image/artgallery.jpg")).getImage().getScaledInstance(panel_logo.getWidth(), panel_logo.getHeight(), Image.SCALE_SMOOTH));
		logolabel.setIcon(ic);
		
		JPanel panel_name = new JPanel();
		panel_name.setBounds(99, 0, 633, 99);
		contentPane.add(panel_name);
		panel_name.setLayout(null);
		
		JLabel namelabel = new JLabel("");
		namelabel.setBounds(0, 0, 633, 99);
		panel_name.add(namelabel);
		ImageIcon ic1=new ImageIcon(new ImageIcon(RegistereduserPage.class.getResource("/image/art1.jpg")).getImage().getScaledInstance(panel_name.getWidth(), panel_name.getHeight(), Image.SCALE_SMOOTH));
		namelabel.setIcon(ic1);
		
		JPanel panel_controls = new JPanel();
		panel_controls.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_controls.setBounds(0, 100, 731, 30);
		contentPane.add(panel_controls);
		panel_controls.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel_container, "name_7296281800690");
			}
		});
		panel_controls.add(btnHome);
		
		JButton btnGallery = new JButton("Gallery");
		btnGallery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_container, "name_7377952523234");
			}
		});
		panel_controls.add(btnGallery);
		
		JButton btnArtist = new JButton("Artist");
		btnArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_container, "name_7393311122147");
			}
		});
		panel_controls.add(btnArtist);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_container, "name_7410583295410");
			}
		});
		panel_controls.add(btnProfile);
		
		JButton btnMyCart = new JButton("My Cart");
		btnMyCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_container, "name_7426609771253");
			}
		});
		panel_controls.add(btnMyCart);
		
		JButton btnLogout = new JButton("Logout");
		panel_controls.add(btnLogout);
		
		panel_container = new JPanel();
		panel_container.setBounds(0, 130, 731, 470);
		contentPane.add(panel_container);
		panel_container.setLayout(new CardLayout(0, 0));
		card=(CardLayout)panel_container.getLayout();
		
		JPanel card_home = new JPanel();
		card_home.setBackground(Color.CYAN);
		panel_container.add(card_home, "name_7296281800690");
		
		JPanel card_gallary = new JPanel();
		card_gallary.setBackground(new Color(0, 191, 255));
		card_gallary.setForeground(new Color(0, 0, 0));
		panel_container.add(card_gallary, "name_7377952523234");
		
		JPanel card_artist = new JPanel();
		card_artist.setBackground(new Color(64, 224, 208));
//		card_artist.setPreferredSize(new Dimension(445,1000));
		JScrollPane scroll=new JScrollPane(card_artist);
		panel_container.add(scroll, "name_7393311122147");
	
		GridBagLayout gbl_card_artist = new GridBagLayout();
		gbl_card_artist.columnWidths = new int[]{237, 237, 237, 0};
		gbl_card_artist.rowHeights = new int[]{150, 150, 150, 0, 0};
		gbl_card_artist.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_card_artist.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		card_artist.setLayout(gbl_card_artist);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		card_artist.add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		card_artist.add(panel_1, gbc_panel_1);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 0;
		card_artist.add(panel_2, gbc_panel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		card_artist.add(panel_3, gbc_panel_3);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		card_artist.add(panel_4, gbc_panel_4);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 1;
		card_artist.add(panel_5, gbc_panel_5);
		
		JPanel card_profile = new JPanel();
		card_profile.setBackground(new Color(0, 250, 154));
		panel_container.add(card_profile, "name_7410583295410");
		
		JPanel card_cart = new JPanel();
		card_cart.setBackground(new Color(100, 149, 237));
		panel_container.add(card_cart, "name_7426609771253");
		
		new Timer().schedule(new TimerTask() {
			public void run() {
				welcomeMessage();
			}
		}, 2);
		
	}

}
