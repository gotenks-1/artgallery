package artgallery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class AdminPage extends JFrame {

	private JPanel contentPane;

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
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 123, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add artist");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(0, 102, 123, 23);
		panel.add(btnNewButton);
		
		JButton btnRemoveArtist = new JButton("Remove artist");
		btnRemoveArtist.setContentAreaFilled(false);
		btnRemoveArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRemoveArtist.setBounds(0, 146, 123, 23);
		panel.add(btnRemoveArtist);
		
		JButton btnAddArtworks = new JButton("Add artworks");
		btnAddArtworks.setContentAreaFilled(false);
		btnAddArtworks.setBounds(0, 187, 123, 23);
		panel.add(btnAddArtworks);
		
		JButton btnRemoveArtworks = new JButton("Remove artworks");
		btnRemoveArtworks.setContentAreaFilled(false);
		btnRemoveArtworks.setBounds(0, 228, 123, 23);
		panel.add(btnRemoveArtworks);
		
		JButton btnAddAdmin = new JButton("Add admin");
		btnAddAdmin.setContentAreaFilled(false);
		btnAddAdmin.setBounds(0, 271, 123, 23);
		panel.add(btnAddAdmin);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(0, 0, 123, 91);
		panel.add(panel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(124, 0, 608, 445);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		CardLayout cd=(CardLayout)panel_1.getLayout();
				
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.info);
		panel_1.add(panel_3, "name_98415668853519");
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBounds(0, 0, 594, 89);
		panel_3.add(panel_5);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_5.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 89, 594, 315);
		panel_3.add(panel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_1.add(panel_2, "name_98415687124957");
	}
}
