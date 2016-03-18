package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewHome extends JFrame {

	private Boolean isConnected;
	private String role;
	
	private JPanel contentPane;
	
	private JButton btnEditProfile;
	private JButton btnManageProjTask;
	private JButton btnMyJournal;
	private JButton btnMembers;
	private JButton btnShop;
	private JButton btnManageBasket;
	private JButton btnOffers;
	private JButton btnLogOut;
	private JButton btnSignIn;
	private JButton btnLogIn;
	private JButton btnMngProduct;
	private JButton btnMngUser;
	
	
	public ViewHome() {
		this.isConnected = false;
		this.role = "Visiteur";
		this.CreationViewHome();
	}
	
	public ViewHome(Boolean isConnectedIn, String role) {
		this.isConnected = isConnectedIn;
		this.role = role;
		this.CreationViewHome();
	}
	
	public void CreationViewHome(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		setBounds(100, 100, 488, 255);
		setTitle("BuilDreams : Home");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnectAs = new JLabel("Connected as " + role);
		lblConnectAs.setBounds(230, 11, 194, 14);
		contentPane.add(lblConnectAs);
		
		this.btnEditProfile = new JButton("Edit my profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEditProfile fenEditProfile = new ViewEditProfile(role);
				fenEditProfile.setVisible(true);		
				dispose();
			}
		});
		btnEditProfile.setBounds(10, 46, 219, 23);
		contentPane.add(btnEditProfile);
		btnEditProfile.setEnabled(false);
		
		this.btnMngProduct = new JButton("Manage products");
		btnMngProduct.setBounds(10,46,219,23);
		contentPane.add(btnMngProduct);
		btnMngProduct.setVisible(false);
		
		this.btnManageProjTask = new JButton("Manage my projects and tasks");
		btnManageProjTask.setBounds(10, 80, 219, 23);
		contentPane.add(btnManageProjTask);
		btnManageProjTask.setEnabled(false);
		
		this.btnMyJournal = new JButton("My journal");
		btnMyJournal.setBounds(10, 114, 219, 23);
		contentPane.add(btnMyJournal);
		btnMyJournal.setEnabled(false);
		
		this.btnMngUser = new JButton("Manage users");
		btnMngUser.setBounds(10, 114, 219, 23);
		contentPane.add(btnMngUser);
		btnMngUser.setVisible(false);
		
		this.btnMembers = new JButton("Members public space");
		btnMembers.setBounds(10, 148, 219, 23);
		contentPane.add(btnMembers);
		btnMembers.setEnabled(false);
		
		this.btnShop = new JButton("Online shop");
		btnShop.setBounds(240, 46, 219, 23);
		contentPane.add(btnShop);
		btnShop.setEnabled(false);
		
		this.btnManageBasket = new JButton("Manage my basket");
		btnManageBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBasket fenBasket = new ViewBasket();
				fenBasket.setVisible(true);		
				dispose();
			}
		});
		btnManageBasket.setBounds(239, 80, 219, 23);
		contentPane.add(btnManageBasket);
		btnManageBasket.setEnabled(false);
		
		this.btnOffers = new JButton("My offers");
		btnOffers.setBounds(240, 114, 219, 23);
		contentPane.add(btnOffers);
		btnOffers.setEnabled(false);
		
		this.btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewHome fenHome = new ViewHome();
				JOptionPane.showMessageDialog(null, "You are now disconnected.",
			   		     "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
				fenHome.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setBounds(148, 182, 174, 23);
		contentPane.add(btnLogOut);
		btnLogOut.setVisible(false);
		
		this.btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewRegistration fenReg = new ViewRegistration();
				fenReg.setVisible(true);
				dispose();
			}
		});
		btnSignIn.setBounds(260, 182, 174, 23);
		contentPane.add(btnSignIn);
		
		this.btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLogin fenLogin = new ViewLogin();
				fenLogin.setVisible(true);
				dispose();
			}
		});
		btnLogIn.setBounds(42, 182, 174, 23);
		contentPane.add(btnLogIn);
		
		JButton btnQuit = new JButton("Close the application");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	System.exit(0); 
			}
		});
		btnQuit.setBounds(239, 148, 220, 23);
		contentPane.add(btnQuit);
		
		this.setLocationRelativeTo(null);
		
		if (this.isConnected & this.role == "User"){
			this.setEnableButtonsUser();
		}
		if (this.isConnected & this.role == "Administrator"){
			this.setVisibleButtonsAdmin();
		}
		if (this.isConnected & this.role == "Seller"){
			this.setVisibleButtonsSeller();
		}
		
	}
	
	private void setEnableButtonsUser() {
		btnEditProfile.setEnabled(true);
		btnManageProjTask.setEnabled(true);
		btnMyJournal.setEnabled(true);
		btnShop.setEnabled(true);
		btnManageBasket.setEnabled(true);
		btnOffers.setEnabled(true);
		btnLogOut.setVisible(true);
		btnLogIn.setVisible(false);
		btnSignIn.setVisible(false);
	}
	
	private void setVisibleButtonsAdmin(){
		btnEditProfile.setVisible(false);
		btnManageProjTask.setVisible(false);
		btnMyJournal.setVisible(false);
		btnShop.setVisible(false);
		btnManageBasket.setVisible(false);
		btnOffers.setVisible(false);
		btnLogOut.setVisible(true);
		btnMembers.setVisible(false);
		btnLogIn.setVisible(false);
		btnSignIn.setVisible(false);
		
		btnMngProduct.setVisible(true);
		btnMngUser.setVisible(true);
	}
	
	private void setVisibleButtonsSeller(){
	}
}
