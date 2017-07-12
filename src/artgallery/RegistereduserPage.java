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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;



class ArtistNode{
	int id;
	String name;
	String desc;
	String cont;
	int cur_rat;
	int max_rat;
	byte image[];
	
	public ArtistNode(int id,String name,String desc,String cont,int cur,int max,byte image[]) {
		this.id=id;
		this.name=name;
		this.desc=desc;
		this.cont=cont;
		this.cur_rat=cur;
		this.max_rat=max;	
		this.image=image;
	}
	
	public String toString(){
		return id+" "+name;
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
	public String toString(){
		return id+" "+name;
	}
	
}


public class RegistereduserPage extends JFrame {

	private JPanel contentPane;
	private CardLayout card;
	private JPanel panel_container;
	private String username;
	JPanel card_artist;
	private ArrayList<ArtistNode> artistList=new ArrayList<ArtistNode>();

	/**
	 * Launch the application.
	 */
	
	void addAllArtisttoPanel(){
		card_artist.removeAll();
		card_artist.repaint();
		artistList.clear();
		
		try {
			PreparedStatement artistgetqrl=DBConnect.conn.prepareStatement("select * from artist");
			ResultSet artistrs=artistgetqrl.executeQuery();
			while(artistrs.next()){
				artistList.add(new ArtistNode(artistrs.getInt(1),
						artistrs.getString(2),
						artistrs.getString(3),
						artistrs.getString(4),
						artistrs.getInt(5),
						artistrs.getInt(6),
						artistrs.getBytes(7)));
//				System.out.println(artistList.get(artistList.size()-1));
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		GridBagLayout gbl_card_artist = new GridBagLayout();
		gbl_card_artist.columnWidths = new int[]{237, 237, 237, 0};
		int noofrowsartist=(artistList.size()+2)/3;
		int artistrowheightarray[]=new int[noofrowsartist];
		card_artist.setPreferredSize(new Dimension(445,noofrowsartist*300));
		for(int i=0;i<noofrowsartist;i++)
			artistrowheightarray[i]=300;
		gbl_card_artist.rowHeights = artistrowheightarray;
//		gbl_card_artist.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_card_artist.rowWeights = new double[]{1.0};
		card_artist.setLayout(gbl_card_artist);
		
		
		for(int i=0;i<artistList.size();i++){
			addArtisttoPanel(artistList.get(i),i);
			
		}
		
		
		
	}
	
	
	void addArtisttoPanel(ArtistNode artist,int n){
		int x=n%3;
		int y=n/3;
		
		
		JPanel panel_card = new JPanel();
		panel_card.setLayout(null);
		panel_card.setMaximumSize(new Dimension(237,300));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(30, 18, 177, 177);
		panel_card.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel artistImage = new JLabel("artist image");
		artistImage.setBounds(0, 0, 177, 177);
		artistImage.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.add(artistImage);
		ImageIcon ic=new ImageIcon(new ImageIcon(artist.image).getImage().getScaledInstance(artistImage.getWidth(), artistImage.getHeight(), Image.SCALE_SMOOTH));
		artistImage.setIcon(ic);
		
		JLabel lblNewLabel = new JLabel("Name :-");
		lblNewLabel.setBounds(30, 205, 70, 15);
		panel_card.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact :-");
		lblNewLabel_1.setBounds(30, 230, 70, 15);
		panel_card.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rating :-");
		lblNewLabel_2.setBounds(30, 256, 70, 15);
		panel_card.add(lblNewLabel_2);
		
		JLabel artistName = new JLabel("New label");
		artistName.setBounds(115, 205, 90, 15);
		artistName.setText(artist.name);
		panel_card.add(artistName);
		
		JLabel artistRating = new JLabel("New label");
		artistRating.setBounds(115, 256, 90, 15);
		panel_card.add(artistRating);
		double ratings=artist.cur_rat*100.0/artist.max_rat/20;
		artistRating.setText(String.format("%.2g/5.0", ratings+0.05));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(115, 230, 105, 15);
		lblNewLabel_3.setText(artist.cont);
		panel_card.add(lblNewLabel_3);
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = x;
		gbc_panel.gridy = y;
		card_artist.add(panel_card, gbc_panel);
		
	}
	
	
	
	
	
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
				addAllArtisttoPanel();
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
		card_gallary.setLayout(null);
		
		JPanel panel_card = new JPanel();
		panel_card.setBounds(0, 0, 237, 300);
		card_gallary.add(panel_card);
		panel_card.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(30, 18, 177, 177);
		panel_card.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel artistImage = new JLabel("artist image");
		artistImage.setBounds(0, 0, 177, 177);
		panel_1.add(artistImage);
		
		JLabel lblNewLabel = new JLabel("Name :-");
		lblNewLabel.setBounds(30, 205, 70, 15);
		panel_card.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact :-");
		lblNewLabel_1.setBounds(30, 230, 70, 15);
		panel_card.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rating :-");
		lblNewLabel_2.setBounds(30, 256, 70, 15);
		panel_card.add(lblNewLabel_2);
		
		JLabel artistName = new JLabel("New label");
		artistName.setBounds(120, 205, 90, 15);
		panel_card.add(artistName);
		
		JLabel artistRating = new JLabel("New label");
		artistRating.setBounds(120, 256, 90, 15);
		panel_card.add(artistRating);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(120, 230, 90, 15);
		panel_card.add(lblNewLabel_3);
		
		card_artist = new JPanel();
		card_artist.setBackground(new Color(64, 224, 208));
	
//		enter size of container panel here
		int noofartistrows=(artistList.size()+2)/3;
		card_artist.setPreferredSize(new Dimension(445,300));
//		System.out.println(card_artist.getComponentCount());
		JScrollPane scroll=new JScrollPane(card_artist);
		panel_container.add(scroll, "name_7393311122147");
	
		
		addAllArtisttoPanel();
		
//		JPanel panel = new JPanel();
//		panel.setPreferredSize(new Dimension(237,150));
//		GridBagConstraints gbc_panel = new GridBagConstraints();
//		gbc_panel.insets = new Insets(0, 0, 5, 5);
//		gbc_panel.fill = GridBagConstraints.BOTH;
//		gbc_panel.gridx = 0;
//		gbc_panel.gridy = 0;
//		card_artist.add(panel, gbc_panel);
		
//		JPanel panel_8 = new JPanel();
//		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
//		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
//		gbc_panel_8.fill = GridBagConstraints.BOTH;
//		gbc_panel_8.gridx = 2;
//		gbc_panel_8.gridy = 2;
//		card_artist.add(panel_8, gbc_panel_8);
//		
//		JPanel panel_9 = new JPanel();
//		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
//		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
//		gbc_panel_9.fill = GridBagConstraints.BOTH;
//		gbc_panel_9.gridx = 0;
//		gbc_panel_9.gridy = 3;
//		card_artist.add(panel_9, gbc_panel_9);
//		
//		JPanel panel_10 = new JPanel();
//		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
//		gbc_panel_10.insets = new Insets(0, 0, 5, 5);
//		gbc_panel_10.fill = GridBagConstraints.BOTH;
//		gbc_panel_10.gridx = 1;
//		gbc_panel_10.gridy = 3;
//		card_artist.add(panel_10, gbc_panel_10);
//		card_artist.setPreferredSize(new Dimension(445,150*(card_artist.getComponentCount()+2)/3));
//		System.out.println(card_artist.getComponentCount());
//		JScrollPane scroll=new JScrollPane(card_artist);
//		panel_container.add(scroll, "name_7393311122147");
//		System.out.println(card_artist.getComponentCount());
		
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
