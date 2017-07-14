package artgallery;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JComboBox;


class Cart{
	ArrayList<CartItem> cartItems=new ArrayList<CartItem>();
	double totalPrice;
	String discountCoupon="nocoupen";
	int discountper=0;
	double discount;
	double pricePay;
	
	void addItem(CartItem ci){
		boolean toAdd=true;
		for(CartItem c: cartItems){
			if(c.item.id==ci.item.id){
				c.qty++;
				toAdd=false;
				break;
			}
		}
		if(toAdd)
			cartItems.add(ci);
		totalPrice+=ci.item.price;
		reApplyDiscount(discountCoupon);
		
	}
	
	void reApplyDiscount(String ccode){
		pricePay=totalPrice;
					discount=totalPrice*discountper/100;
					pricePay=totalPrice-discount;
					
	}
	
	void remove(CartItem ci){
		if(cartItems.contains(ci)){
			int index=cartItems.indexOf(ci);
			CartItem c=cartItems.get(index);
			totalPrice-=c.item.price*c.qty;
			cartItems.remove(index);
			reApplyDiscount(discountCoupon);
		}
	}
	
	void applyDiscount(String ccode){
		pricePay=totalPrice;
		try {
			ResultSet rs=DBConnect.conn.prepareStatement("select * from discount where coupon_code='"+ccode+"'").executeQuery();
			if(rs.next()){
				String status=rs.getString(3);
				if(status.equals("yes")){
					JOptionPane.showMessageDialog(null, "Code is alredy used.");
				}else{
					int dis=rs.getInt(2);
					discountper=dis;
					discount=totalPrice*dis/100;
					pricePay=totalPrice-discount;
					DBConnect.conn.prepareStatement("update discount set used_or_not='yes' where coupon_code='"+ccode+"'").executeUpdate();
					JOptionPane.showMessageDialog(null, "Coupon code applied.Discount of "+dis+"% added.Refresh cart to view cshanges.");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Invalid Code");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

class CartItem implements Comparable<CartItem>{
	ArtworkNode item;
	int qty;
	
	public CartItem(ArtworkNode item,int qty){
		this.item=item;
		this.qty=qty;
	}

	public int compareTo(CartItem node) {
		return this.item.id-node.item.id;
	}
	
	public boolean equals(CartItem c){
		if(this.item.id==c.item.id)
			return true;
		else
			return false;
	}
}

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
	double price;
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
	private CardLayout card2;
	private JPanel panel_container;
	private String username;
	private JLabel productID;
	private JLabel productName;
	private JTextArea productDesc;
	private JLabel productPrice;
	private JLabel productArtist;
	private JLabel productQty;
	private JLabel productCat;
	private JLabel labelArtworkImage;
	private JButton btnAddCart;
	private JButton btnShowCart;
	JPanel panelCategoryFilter;
	JPanel panelArtistFilter;
	JPanel card_artist;
	JPanel galleryIntro;
	JPanel galleryContainer;
	JPanel card_cart;
	JScrollPane cartScroll;
	private ArrayList<ArtistNode> artistList=new ArrayList<ArtistNode>();
	private ArrayList<ArtworkNode> artworkList=new ArrayList<ArtworkNode>();
	private ArrayList<JCheckBox> categoryList=new ArrayList<JCheckBox>();
	private ArrayList<JCheckBox> cbArtistList=new ArrayList<JCheckBox>();
	private ArrayList<String> filterCatList=new ArrayList<String>();
	private ArrayList<String> filterArtistList=new ArrayList<String>();
	boolean catFilter=false;
	boolean artistFilter=false;
	static Cart myCart;
	JPanel galleryDetail;
//	static ArtworkNode artwork1;
	/**
	 * Launch the application.
	 */
	
	
	void addAllCarttoPanel(){
		card_cart.removeAll();
		
		GridBagLayout gbl_galleryIntro=new GridBagLayout();
		int noofrowsartwork=myCart.cartItems.size()+1;
		int artworkrowheightarray[]=new int[noofrowsartwork];
		for(int i=0;i<noofrowsartwork;i++)
			artworkrowheightarray[i]=170;
		gbl_galleryIntro.columnWidths=new int[]{731};
		gbl_galleryIntro.rowHeights=artworkrowheightarray;
		card_cart.setPreferredSize(new Dimension(445,noofrowsartwork*170));
		card_cart.setLayout(gbl_galleryIntro);
		
		for(int i=0;i<myCart.cartItems.size();i++){
			addCartItemtoPanel(myCart.cartItems.get(i),i);
			
		}
		
		addLastCartItemtoPanel();
		
		card_cart.revalidate();
		card_cart.repaint();
	}
	
	void addLastCartItemtoPanel(){
		JPanel mainItemPanel=new JPanel();
		mainItemPanel.setBounds(0, 0, 731, 170);
		mainItemPanel.setLayout(null);
		
		if(myCart.cartItems.size()<=0){
			JLabel lblItemID=new JLabel("No items in cart");
			lblItemID.setBounds(200, 10, 400, 20);
			mainItemPanel.add(lblItemID);
			
			GridBagConstraints gbc=new GridBagConstraints();
			gbc.insets=new Insets(0, 5, 5, 5);
			gbc.gridx=0;
			gbc.gridy=0;
			gbc.fill=GridBagConstraints.BOTH;
			
//			System.out.println("added last item");
			
			card_cart.add(mainItemPanel, gbc);
			return;
		}
		
		JLabel lblTPrice=new JLabel("Total Price :- ");
		lblTPrice.setBounds(20, 10, 150, 20);
		mainItemPanel.add(lblTPrice);
		
		JLabel lblTPrice1=new JLabel(String.format("%.2f", myCart.totalPrice));
		lblTPrice1.setBounds(500, 10, 150, 20);
		mainItemPanel.add(lblTPrice1);
		
		JLabel lblDiscount=new JLabel("Discount Percent :- ");
		lblDiscount.setBounds(20, 40, 150, 20);
		mainItemPanel.add(lblDiscount);
		
		JLabel lblDiscount1=new JLabel(""+myCart.discountper+"%");
		lblDiscount1.setBounds(500, 40, 150, 20);
		mainItemPanel.add(lblDiscount1);
		
		JLabel lblDisCoupen=new JLabel("Total Discount :- ");
		lblDisCoupen.setBounds(20, 70, 150, 20);
		mainItemPanel.add(lblDisCoupen);
		
		JLabel lblDisCoupen1=new JLabel(String.format("%.2f", myCart.discount));
		lblDisCoupen1.setBounds(500, 70, 150, 20);
		mainItemPanel.add(lblDisCoupen1);
		
		JLabel lblTotalPay=new JLabel("Final Amount :- ");
		lblTotalPay.setBounds(20, 100, 150, 20);
		mainItemPanel.add(lblTotalPay);
		
		JLabel lblTotalPay1=new JLabel(String.format("%.2f", myCart.pricePay));
		lblTotalPay1.setBounds(500, 100, 150, 20);
		mainItemPanel.add(lblTotalPay1);
		
		JButton btnApplyDiscount=new JButton("Apply Discount Coupon");
		btnApplyDiscount.setBounds(20, 130, 250, 25);
		mainItemPanel.add(btnApplyDiscount);
		btnApplyDiscount.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String s=JOptionPane.showInputDialog(contentPane,"Enter Coupon Code");
				myCart.applyDiscount(s);
			}
		});
		
		JButton btnCheckout=new JButton("Proceed to checkout");
		btnCheckout.setBounds(320, 130, 250, 25);
		mainItemPanel.add(btnCheckout);
		btnCheckout.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(username.equals("guest")){
					JOptionPane.showMessageDialog(contentPane, "Login First to continue");
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Order placed");
				}
			}
		});
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(0, 5, 5, 5);
		gbc.gridx=0;
		gbc.gridy=myCart.cartItems.size();
		gbc.fill=GridBagConstraints.BOTH;
		
		card_cart.add(mainItemPanel, gbc);
		
	}
	
	
	void addCartItemtoPanel(final CartItem ci,int i){
		JPanel mainItemPanel=new JPanel();
		mainItemPanel.setBounds(0, 0, 731, 0);
		mainItemPanel.setLayout(null);
		
		JLabel lblImage=new JLabel();
		lblImage.setBounds(10, 10, 150, 150);
		lblImage.setIcon(new ImageIcon(new ImageIcon(ci.item.icon).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH)));
		mainItemPanel.add(lblImage);
		
		JLabel lblItemID=new JLabel("Item Id:-");
		lblItemID.setBounds(200, 10, 100, 20);
		mainItemPanel.add(lblItemID);
		
		JLabel lblItemID1=new JLabel(""+ci.item.id);
		lblItemID1.setBounds(320, 10, 100, 20);
		mainItemPanel.add(lblItemID1);
		
		JLabel lblItemName=new JLabel("Name:-");
		lblItemName.setBounds(200, 50, 100, 20);
		mainItemPanel.add(lblItemName);
		
		JLabel lblItemName1=new JLabel(""+ci.item.name);
		lblItemName1.setBounds(320, 50, 100, 20);
		mainItemPanel.add(lblItemName1);
		
		JLabel lblItemQty=new JLabel("Quantity:-");
		lblItemQty.setBounds(200, 90, 100, 20);
		mainItemPanel.add(lblItemQty);
		
		JLabel lblItemQty1=new JLabel(""+ci.qty);
		lblItemQty1.setBounds(320, 90, 100, 20);
		mainItemPanel.add(lblItemQty1);
		
		JLabel lblItemPrice=new JLabel("Price:-");
		lblItemPrice.setBounds(200, 130, 100, 20);
		mainItemPanel.add(lblItemPrice);
		
		JLabel lblItemPrice1=new JLabel(""+ci.qty+" * "+String.format("%.2f", ci.item.price)+" = "+String.format("%.2f", ci.item.price*ci.qty));
		lblItemPrice1.setBounds(320, 130, 300, 20);
		mainItemPanel.add(lblItemPrice1);
		
		JButton btnRemove=new JButton("Remove");
		btnRemove.setBounds(550,10,150,60);
		mainItemPanel.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myCart.remove(ci);
				addAllCarttoPanel();
				card.show(panel_container, "name_7426609771253");
			}
		});
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(0, 5, 5, 5);
		gbc.gridx=0;
		gbc.gridy=i;
		gbc.fill=GridBagConstraints.BOTH;
		
		card_cart.add(mainItemPanel, gbc);
	}
	
	
	
	void generateArtistList(){
		cbArtistList.clear();
		try {
			ResultSet rs=DBConnect.smt.executeQuery("select art_id from artist");
			while(rs.next()){
				final JCheckBox cb=new JCheckBox(rs.getString(1));
				cb.addActionListener(new ActionListener() {					
					public void actionPerformed(ActionEvent e) {
						if(cb.isSelected()){
							filterArtistList.add(cb.getText());
//							System.out.println("added "+cb.getText());
						}
						else{
							filterArtistList.remove(cb.getText());
//							System.out.println("removed "+cb.getText());
						}
					}
				});
				cbArtistList.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		GridBagLayout gbl=new GridBagLayout();
		panelArtistFilter.setPreferredSize(new Dimension(100, 23*categoryList.size()));
		int rowheight[]=new int[cbArtistList.size()];
		for(int i=0;i<rowheight.length;i++)
			rowheight[i]=23;
		gbl.rowHeights=rowheight;
		panelArtistFilter.setLayout(gbl);
		
		for(int i=0;i<rowheight.length;i++){
			GridBagConstraints gbc=new GridBagConstraints();
			gbc.fill=GridBagConstraints.BOTH;
			gbc.gridx=0;
			gbc.gridy=i;
			panelArtistFilter.add(cbArtistList.get(i), gbc);
//			System.out.println(categoryList.get(i));
		}
		
//		cbArtistList.clear();
		
	}
	
	void clearFilter(JCheckBox cb){
		cb.setSelected(false);
	}
	
	void applyFilter(){
		getAllArtwork();
		if(catFilter){
			for(int i=0;i<artworkList.size();i++){
//				System.out.print("checking "+artworkList.get(i).category);
				if(!filterCatList.contains(artworkList.get(i).category)){
					artworkList.remove(i);
					i--;
//					System.out.println("\tnot found");
				}
			}
		}
		
		if(artistFilter){
			for(int i=0;i<artworkList.size();i++){
				if(!filterArtistList.contains(String.valueOf(artworkList.get(i).artist_id))){
					artworkList.remove(i);
					i--;
				}
			}
			
		}
		addAllArtworktoPanel();
	}
	
	
	void generateCategoryList(){
		categoryList.clear();
		try {
			ResultSet rs=DBConnect.smt.executeQuery("select distinct(category) from artworks");
			while(rs.next()){
				final JCheckBox cb=new JCheckBox(rs.getString(1));
				cb.addActionListener(new ActionListener() {					
					public void actionPerformed(ActionEvent e) {
						if(cb.isSelected()){
							filterCatList.add(cb.getText());
//							System.out.println("added "+cb.getText());
						}
						else{
							filterCatList.remove(cb.getText());
//							System.out.println("removed "+cb.getText());
						}
					}
				});
				categoryList.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		GridBagLayout gbl=new GridBagLayout();
		panelCategoryFilter.setPreferredSize(new Dimension(100, 23*categoryList.size()));
		int rowheight[]=new int[categoryList.size()];
		for(int i=0;i<rowheight.length;i++)
			rowheight[i]=23;
		gbl.rowHeights=rowheight;
		panelCategoryFilter.setLayout(gbl);
		
		for(int i=0;i<rowheight.length;i++){
			GridBagConstraints gbc=new GridBagConstraints();
			gbc.fill=GridBagConstraints.BOTH;
			gbc.gridx=0;
			gbc.gridy=i;
			panelCategoryFilter.add(categoryList.get(i), gbc);
//			System.out.println(categoryList.get(i));
		}
		
//		categoryList.clear();
		
	}
	
	
	void sortArtworks(int i){
		switch(i){
		case 1:Collections.sort(artworkList,new Comparator<ArtworkNode>() {
			public int compare(ArtworkNode node1,ArtworkNode node2){
				return node1.name.compareTo(node2.name);
			}
		});
		addAllArtworktoPanel();
		break;
		
		case 2:Collections.sort(artworkList,new Comparator<ArtworkNode>() {
			public int compare(ArtworkNode node1,ArtworkNode node2){
				return node2.id-node1.id;
			}
		});
		addAllArtworktoPanel();
		break;
		
		case 3:Collections.sort(artworkList,new Comparator<ArtworkNode>() {
			public int compare(ArtworkNode node1,ArtworkNode node2){
				return (int)(node1.price-node2.price);
			}
		});
		addAllArtworktoPanel();
		break;
		
		case 4:Collections.sort(artworkList,new Comparator<ArtworkNode>() {
			public int compare(ArtworkNode node1,ArtworkNode node2){
				return (int)(node2.price-node1.price);
			}
		});
		addAllArtworktoPanel();
		break;
		
		case 5:Collections.sort(artworkList,new Comparator<ArtworkNode>() {
			public int compare(ArtworkNode node1,ArtworkNode node2){
				return (int)(node1.sold-node2.sold);
			}
		});
		addAllArtworktoPanel();
		break;
		
		}
	}
	
	void addProductDetail(final ArtworkNode artwork1){
		
		btnAddCart=new JButton("Add to Cart");
		btnAddCart.setBounds(300,308,130,40);
		galleryDetail.add(btnAddCart);
		btnAddCart.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				myCart.addItem(new CartItem(artwork1, 1));
				JOptionPane.showMessageDialog(contentPane, "Added to cart");
			}
		});
		
		
		productID.setText(""+artwork1.id+"");
		productName.setText(artwork1.name);
		productDesc.setText(artwork1.details);
		productPrice.setText("INR "+artwork1.price+"");
		try {
			PreparedStatement ps=DBConnect.conn.prepareStatement("select name from artist where art_id="+artwork1.artist_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				productArtist.setText(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		productArtist.setText(""+artwork1.artist_id+"");
		productCat.setText(artwork1.category);
		productQty.setText(""+artwork1.qty_left+"");
		ImageIcon ic=new ImageIcon(new ImageIcon(artwork1.icon).getImage().getScaledInstance(labelArtworkImage.getWidth(), labelArtworkImage.getHeight(), Image.SCALE_SMOOTH));
		labelArtworkImage.setIcon(ic);
		if(artwork1.qty_left<=0){
			btnAddCart.setText("Out of Stock");
			btnAddCart.setEnabled(false);
		}
		else{
			btnAddCart.setText("Add to cart");
			btnAddCart.setEnabled(true);
		}
	}
	
	
	void getAllArtwork(){
		artworkList.clear();
		
		try {
			PreparedStatement artworkgensql=DBConnect.conn.prepareStatement("select * from artworks");
			ResultSet artworkrs=artworkgensql.executeQuery();
			while(artworkrs.next()){
				artworkList.add(new ArtworkNode(artworkrs.getInt(1),
						artworkrs.getString(2),
						artworkrs.getString(3),
						artworkrs.getFloat(4),
						artworkrs.getInt(5),
						artworkrs.getInt(6),
						artworkrs.getInt(7),
						artworkrs.getString(8),
						artworkrs.getBytes(9)));
//				System.out.println(artistList.get(artistList.size()-1));
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	
	
	void addAllArtworktoPanel(){
		galleryIntro.removeAll();
		
		GridBagLayout gbl_galleryIntro=new GridBagLayout();
		gbl_galleryIntro.columnWidths=new int[]{200,200,200};
		int noofrowsartwork=(artworkList.size()+2)/3;
		int artworkrowheightarray[]=new int[noofrowsartwork];
		for(int i=0;i<noofrowsartwork;i++)
			artworkrowheightarray[i]=300;
		gbl_galleryIntro.rowHeights=artworkrowheightarray;
		galleryIntro.setPreferredSize(new Dimension(445,noofrowsartwork*300));
		galleryIntro.setLayout(gbl_galleryIntro);
		
		for(int i=0;i<artworkList.size();i++){
			addArtworktoPanel(artworkList.get(i),i);
			
		}
		galleryIntro.revalidate();
		galleryIntro.repaint();
	}
	
	void addArtworktoPanel(final ArtworkNode artwork,int n){
		int x=n%3;
		int y=n/3;
		
		
		JPanel panel_card = new JPanel();
		panel_card.setLayout(null);
		panel_card.setMaximumSize(new Dimension(230,300));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(22, 10, 150, 150);
		panel_card.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel artworkImage = new JLabel("artwork image");
		artworkImage.setBounds(0, 0, 150, 150);
		artworkImage.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.add(artworkImage);
		ImageIcon ic=new ImageIcon(new ImageIcon(artwork.icon).getImage().getScaledInstance(artworkImage.getWidth(), artworkImage.getHeight(), Image.SCALE_SMOOTH));
		artworkImage.setIcon(ic);
		
		JLabel lblNewLabel = new JLabel("Name :-");
		lblNewLabel.setBounds(18, 170, 85, 15);
		panel_card.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category :-");
		lblNewLabel_1.setBounds(18, 195, 85, 15);
		panel_card.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price :-");
		lblNewLabel_2.setBounds(18, 220, 85, 15);
		panel_card.add(lblNewLabel_2);
		
		JLabel artworkName = new JLabel("New label");
		artworkName.setBounds(115, 170, 90, 15);
		artworkName.setText(artwork.name);
		panel_card.add(artworkName);
		
		JLabel artworkCategory = new JLabel("New label");
		artworkCategory.setBounds(115, 195, 90, 15);
		panel_card.add(artworkCategory);
		artworkCategory.setText(""+artwork.category);
		
		JLabel artworkPrice = new JLabel("New label");
		artworkPrice.setBounds(115, 220, 105, 15);
		artworkPrice.setText("INR "+artwork.price);
		panel_card.add(artworkPrice);
		
		JButton btnAddCart=new JButton("Add to cart");
		btnAddCart.setBounds(18,245,158,20);
		panel_card.add(btnAddCart);
		if(artwork.qty_left<=0){
			btnAddCart.setEnabled(false);
			btnAddCart.setText("Out of Stock");
		}
		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCart.addItem(new CartItem(artwork, 1));
				JOptionPane.showMessageDialog(contentPane, "Item added to cart");
			}
		});
		
		JButton btnShowDetail=new JButton("Details");
		btnShowDetail.setBounds(18,269,158,20);
		panel_card.add(btnShowDetail);
		btnShowDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addProductDetail(artwork);
				card2.show(galleryContainer, "name_3950194483962");
//				System.out.println("i am called");
			}
		});
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = x;
		gbc_panel.gridy = y;
		galleryIntro.add(panel_card, gbc_panel);
//		System.out.println(artwork.toString());
		
	}
	
	
	
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
		gbl_card_artist.rowWeights = new double[]{};
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
	
//	JPanel artistpanel(){
//		JPanel mainPanel=new JPanel();
//		
//		
//		
//		return mainPanel;
//		
//	}
	
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
		if(myCart==null)
			myCart=new Cart();
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
				getAllArtwork();
				addAllArtworktoPanel();
				card.show(panel_container, "name_7377952523234");
				card2.show(galleryContainer, "name_15095058194076");
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
		if(username.equals("guest")){
			btnProfile.setText("Register");
			btnProfile.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					LoginPage.main(new String[]{""});
					dispose();
				}
			});
		}else{
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_container, "name_7410583295410");
			}
		});}
		panel_controls.add(btnProfile);
		
		JButton btnMyCart = new JButton("My Cart");
		btnMyCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAllCarttoPanel();
				card.show(panel_container, "name_7426609771253");
			}
		});
		panel_controls.add(btnMyCart);
		
		JButton btnLogout = new JButton("Logout");
		if(username.equals("guest"))
			btnLogout.setText("Login");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username="guest";
				LoginPage.main(new String[]{""});
				dispose();
			}
		});
		panel_controls.add(btnLogout);
		
		panel_container = new JPanel();
		panel_container.setBounds(0, 130, 731, 470);
		contentPane.add(panel_container);
		panel_container.setLayout(new CardLayout(0, 0));
		card=(CardLayout)panel_container.getLayout();
		
		JPanel card_home = new JPanel();
		card_home.setBackground(Color.CYAN);
		panel_container.add(card_home, "name_7296281800690");
		card_home.setLayout(null);
		
		JPanel card_gallery = new JPanel();
		card_gallery.setBackground(new Color(0, 191, 255));
		card_gallery.setForeground(new Color(0, 0, 0));
		panel_container.add(card_gallery, "name_7377952523234");
		card_gallery.setLayout(null);
		
		JPanel gallarySortByPanel = new JPanel();
		gallarySortByPanel.setBackground(new Color(0, 255, 0));
		gallarySortByPanel.setBounds(0, 0, 731, 20);
		card_gallery.add(gallarySortByPanel);
		gallarySortByPanel.setLayout(null);
		
		final JComboBox sortByCB = new JComboBox();
		sortByCB.setBounds(598, 0, 130, 20);
		String sortByArray[]={"By Name","Most recent","Price(low to high)","Price(high to low)","High sellers"};
		sortByCB.setModel(new DefaultComboBoxModel<String>(sortByArray));
		gallarySortByPanel.add(sortByCB);
		sortByCB.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				sortArtworks(sortByCB.getSelectedIndex()+1);
			}
		});
		
		JLabel lblSortBy = new JLabel("Sort By :-");
		lblSortBy.setBounds(530, 0, 70, 15);
		gallarySortByPanel.add(lblSortBy);
		
		JPanel galleryFilter = new JPanel();
		galleryFilter.setBackground(new Color(0, 255, 127));
		galleryFilter.setBounds(0, 20, 120, 450);
		card_gallery.add(galleryFilter);
		galleryFilter.setLayout(null);
		
		JLabel lblFilter = new JLabel("Filters");
		lblFilter.setFont(new Font("Dialog", Font.BOLD, 15));
		lblFilter.setBounds(0, 5, 120, 15);
		galleryFilter.add(lblFilter);
		
		JLabel lblCategory = new JLabel("Category :-");
		lblCategory.setBounds(0, 35, 120, 15);
		galleryFilter.add(lblCategory);
		
		panelCategoryFilter = new JPanel();
		panelCategoryFilter.setBounds(0, 50, 120, 150);
		JScrollPane categoryScroll=new JScrollPane(panelCategoryFilter);
		categoryScroll.setBounds(0, 50, 120, 150);
//		panelCategoryFilter.setPreferredSize(new Dimension(100, 1200));
		
		galleryFilter.add(categoryScroll);
		
		generateCategoryList();
		
		JButton btnCateoryApply = new JButton("Apply");
		btnCateoryApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catFilter=true;
				applyFilter();
			}
		});
		btnCateoryApply.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnCateoryApply.setBounds(0, 200, 60, 20);
		galleryFilter.add(btnCateoryApply);
		
		JButton btnCategoryClear = new JButton("Clear");
		btnCategoryClear.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnCategoryClear.setBounds(60, 200, 60, 20);
		galleryFilter.add(btnCategoryClear);
		btnCategoryClear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				catFilter=false;
				for(JCheckBox cb:categoryList){
					clearFilter(cb);
				}
				applyFilter();
			}
		});
		
		JLabel lblArtist = new JLabel("Artist :-");
		lblArtist.setBounds(0, 240, 120, 15);
		galleryFilter.add(lblArtist);
		
		panelArtistFilter = new JPanel();
//		panelArtistFilter.setBounds(0, 255, 120, 150);
		JScrollPane artistScroll=new JScrollPane(panelArtistFilter);
		artistScroll.setBounds(0, 255, 120, 150);
//		panelArtistFilter.setPreferredSize(new Dimension(100, 1200));
		galleryFilter.add(artistScroll);
		
		generateArtistList();
		
		JButton btnArtistApply = new JButton("Apply");
		btnArtistApply.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnArtistApply.setBounds(0, 405, 60, 20);
		galleryFilter.add(btnArtistApply);
		btnArtistApply.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				artistFilter=true;
				applyFilter();
			}
		});
		
		JButton btnArtistClear = new JButton("Clear");
		btnArtistClear.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnArtistClear.setBounds(60, 405, 60, 20);
		galleryFilter.add(btnArtistClear);
		btnArtistClear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				artistFilter=false;
				for(JCheckBox cb:cbArtistList){
					clearFilter(cb);
				}
				applyFilter();
			}
		});
		
		
		
		galleryContainer = new JPanel();
		galleryContainer.setBackground(new Color(0, 191, 255));
		galleryContainer.setBounds(120, 20, 611, 450);
		card_gallery.add(galleryContainer);
		galleryContainer.setLayout(new CardLayout(0, 0));
		card2=(CardLayout)galleryContainer.getLayout();
				
				galleryIntro = new JPanel();
				galleryIntro.setBackground(new Color(32, 178, 170));
				//		galleryContainer.add(galleryIntro, "name_12258997997422");
						
						JScrollPane scrollPane = new JScrollPane(galleryIntro);
						galleryContainer.add(scrollPane, "name_15095058194076");
						
						galleryDetail = new JPanel();
						galleryContainer.add(galleryDetail, "name_3950194483962");
						galleryDetail.setBackground(new Color(30, 144, 255));
						galleryDetail.setLayout(null);
						
						JButton btnBack = new JButton("Back");
						btnBack.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								card2.show(galleryContainer, "name_15095058194076");
							}
						});
						btnBack.setBounds(0, 0, 117, 25);
						btnBack.setBorderPainted(false);
						btnBack.setContentAreaFilled(false);
						galleryDetail.add(btnBack);
						
						JPanel panel = new JPanel();
						panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
						panel.setBounds(50, 50, 200, 300);
						galleryDetail.add(panel);
						panel.setLayout(null);
						
						labelArtworkImage = new JLabel("Artwork Image");
						labelArtworkImage.setBounds(0, 0, 200, 300);
						labelArtworkImage.setBorder(new LineBorder(new Color(0, 0, 0), 2));
						panel.add(labelArtworkImage);
						
						JLabel lblProductId = new JLabel("Product ID :-");
						lblProductId.setBounds(300, 50, 110, 15);
						galleryDetail.add(lblProductId);
						
						productID = new JLabel("New label");
						productID.setBounds(450, 50, 140, 15);
						galleryDetail.add(productID);
						
						JLabel labelName = new JLabel("Name :-");
						labelName.setBounds(300, 80, 110, 15);
						galleryDetail.add(labelName);
						
						productName = new JLabel("New label");
						productName.setBounds(450, 80, 140, 15);
						galleryDetail.add(productName);
						
						JLabel labelCat = new JLabel("Category :-");
						labelCat.setBounds(300, 110, 110, 15);
						galleryDetail.add(labelCat);
						
						productCat = new JLabel("New label");
						productCat.setBounds(450, 110, 140, 15);
						galleryDetail.add(productCat);
						
						JLabel labelArtist = new JLabel("Artist :-");
						labelArtist.setBounds(300, 140, 110, 15);
						galleryDetail.add(labelArtist);
						
						productArtist = new JLabel("New label");
						productArtist.setBounds(450, 140, 140, 15);
						galleryDetail.add(productArtist);
						
						JLabel labelPrice = new JLabel("Price :-");
						labelPrice.setBounds(300, 170, 110, 15);
						galleryDetail.add(labelPrice);
						
						productPrice = new JLabel("New label");
						productPrice.setBounds(450, 170, 140, 15);
						galleryDetail.add(productPrice);
						
						JLabel labelQty = new JLabel("Remaining :-");
						labelQty.setBounds(300, 200, 110, 15);
						galleryDetail.add(labelQty);
						
						productQty = new JLabel("New label");
						productQty.setBounds(450, 200, 140, 15);
						galleryDetail.add(productQty);
						
						JLabel labelDesc = new JLabel("Description :-");
						labelDesc.setBounds(300, 230, 110, 15);
						galleryDetail.add(labelDesc);
						
//		productDesc = new JLabel("New label");
//		productDesc.setBounds(450, 230, 140, 15);
						
						productDesc=new JTextArea();
						productDesc.setFont(new Font("Dialog", Font.BOLD, 12));
						productDesc.setBounds(450,230,140,60);
						productDesc.setBackground(new Color(30, 144, 255));
						productDesc.setEditable(false);
						galleryDetail.add(productDesc);
						
						
						btnShowCart=new JButton("View Cart");
						btnShowCart.setBounds(450,308,130,40);
						galleryDetail.add(btnShowCart);
						btnShowCart.addActionListener(new ActionListener() {			
							public void actionPerformed(ActionEvent e) {
								card.show(panel_container, "name_7426609771253");
							}
						});
		
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
		
		card_cart = new JPanel();
		cartScroll=new JScrollPane(card_cart);
		card_cart.setBackground(new Color(100, 149, 237));
		panel_container.add(cartScroll, "name_7426609771253");
		
		new Timer().schedule(new TimerTask() {
			public void run() {
				welcomeMessage();
			}
		}, 2);
		
	}

}
