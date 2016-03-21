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
	private JButton btnManagePersoProj;
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
	private JButton btnMngCateg;
	private JButton btnMngGenProj;
	private JButton btnMngGenTask;
	private JButton btnQuit;
	private JButton btnMyShop;
	private JButton btnOrder;
	private JButton btnManagePersoTask;
	
	
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
		setVisible(true);
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
		btnMngProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManageShop fenMngShop = new ViewManageShop();
				fenMngShop.setVisible(true);		
				dispose();
			}
		});
		btnMngProduct.setBounds(10, 114, 219, 23);
		contentPane.add(btnMngProduct);
		btnMngProduct.setVisible(false);
		
		this.btnManagePersoProj = new JButton("My projects");
		btnManagePersoProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManagePersoProject fenMngPersoProj = new ViewManagePersoProject();
				fenMngPersoProj.setVisible(true);		
				dispose();
			}
		});
		btnManagePersoProj.setBounds(10, 80, 219, 23);
		contentPane.add(btnManagePersoProj);
		btnManagePersoProj.setEnabled(false);
		
		this.btnMngGenProj = new JButton("Manage general projects");
		btnMngGenProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManageGenProject fenMngGenProj = new ViewManageGenProject();
				fenMngGenProj.setVisible(true);		
				dispose();
			}
		});
		btnMngGenProj.setBounds(10, 80, 219, 23);
		contentPane.add(btnMngGenProj);
		btnMngGenProj.setVisible(false);
		
		this.btnOrder = new JButton("My orders");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManageOrder fenMngOrder = new ViewManageOrder();
				fenMngOrder.setVisible(true);		
				dispose();
			}
		});
		btnOrder.setBounds(10, 114, 219, 23);
		contentPane.add(btnOrder);
		btnOrder.setEnabled(false);
		
		this.btnMyJournal = new JButton("My journal");
		btnMyJournal.setBounds(240, 148, 219, 23);
		contentPane.add(btnMyJournal);
		btnMyJournal.setEnabled(false);
		
		this.btnMngUser = new JButton("Manage members");
		btnMngUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManageMember fenMngUser = new ViewManageMember();
				fenMngUser.setVisible(true);		
				dispose();
			}
		});
		btnMngUser.setBounds(240, 46, 219, 23);
		contentPane.add(btnMngUser);
		btnMngUser.setVisible(false);
		
		/*this.btnMembers = new JButton("Members public space");
		btnMembers.setBounds(240, 148, 219, 23);
		contentPane.add(btnMembers);
		btnMembers.setEnabled(false);*/
		
		this.btnShop = new JButton("Online shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewOnlineShop fenOnlineShop = new ViewOnlineShop();
				fenOnlineShop.setVisible(true);		
				dispose();
			}
		});
		btnShop.setBounds(240, 46, 219, 23);
		contentPane.add(btnShop);
		btnShop.setEnabled(false);
		
		this.btnMngCateg = new JButton("Manage product categories");
		btnMngCateg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManageCategory fenMngCategory = new ViewManageCategory();
				fenMngCategory.setVisible(true);		
				dispose();
			}
		});
		btnMngCateg.setBounds(240,114,219,23);
		contentPane.add(btnMngCateg);
		btnMngCateg.setVisible(false);
		
		this.btnMyShop = new JButton("My shop");
		btnMyShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManageShop fenMngShop = new ViewManageShop();
				fenMngShop.setVisible(true);		
				dispose();
			}
		});
		btnMyShop.setBounds(240, 46, 219, 23);
		contentPane.add(btnMyShop);
		btnMyShop.setVisible(false);
		
		this.btnManageBasket = new JButton("My basket");
		btnManageBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBasket fenBasket = new ViewBasket();
				fenBasket.setVisible(true);		
				dispose();
			}
		});
		btnManageBasket.setBounds(10, 148, 219, 23);
		contentPane.add(btnManageBasket);
		btnManageBasket.setEnabled(false);
		
		
		this.btnManagePersoTask = new JButton("My tasks");
		btnManagePersoTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManagePersoTask fenMngPersoTask = new ViewManagePersoTask();
				fenMngPersoTask.setVisible(true);		
				dispose();
			}
		});
		btnManagePersoTask.setBounds(240, 80, 219, 23);
		contentPane.add(btnManagePersoTask);
		btnManagePersoTask.setEnabled(false);
		
		this.btnMngGenTask = new JButton("Manage general tasks");
		btnMngGenTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManageGenTask fenMngGenTask = new ViewManageGenTask();
				fenMngGenTask.setVisible(true);		
				dispose();
			}
		});
		btnMngGenTask.setBounds(240, 80, 219, 23);
		contentPane.add(btnMngGenTask);
		btnMngGenTask.setVisible(false);
		
		this.btnOffers = new JButton("My offers ");
		btnOffers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManageOffer fenMngOffer = new ViewManageOffer();
				fenMngOffer.setVisible(true);		
				dispose();
			}
		});
		btnOffers.setBounds(240, 114, 219, 23);
		contentPane.add(btnOffers);
		btnOffers.setEnabled(false);
		
		this.btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewHome fenHome = new ViewHome();
				dispose();
				JOptionPane.showMessageDialog(null, "You are now disconnected.",
			   		     "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
				fenHome.setVisible(true);
			}
		});
		btnLogOut.setBounds(82, 182, 100, 23);
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
		btnSignIn.setBounds(190, 182, 100, 23);
		contentPane.add(btnSignIn);
		
		this.btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLogin fenLogin = new ViewLogin();
				fenLogin.setVisible(true);
				dispose();
			}
		});
		btnLogIn.setBounds(72, 182, 100, 23);
		contentPane.add(btnLogIn);
		
		this.btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		    	System.exit(0); 
			}
		});
		btnQuit.setBounds(310, 182, 100, 23);
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
		btnManagePersoProj.setEnabled(true);
		btnManagePersoTask.setEnabled(true);
		btnShop.setEnabled(true);
		btnManageBasket.setEnabled(true);
		btnOffers.setEnabled(true);
		btnLogOut.setVisible(true);
		btnLogIn.setVisible(false);
		btnSignIn.setVisible(false);
		btnOrder.setEnabled(true);
	}
	
	private void setVisibleButtonsAdmin(){
		btnEditProfile.setEnabled(true);
		btnManagePersoProj.setVisible(false);
		btnManagePersoTask.setVisible(false);
		btnMyJournal.setVisible(false);
		btnShop.setVisible(false);
		btnManageBasket.setVisible(false);
		btnOffers.setVisible(false);
		btnOrder.setVisible(false);
		btnLogOut.setVisible(true);
		//btnMembers.setVisible(false);
		btnLogIn.setVisible(false);
		btnSignIn.setVisible(false);
		
		btnMngProduct.setVisible(true);
		btnMngUser.setVisible(true);
		btnMngCateg.setVisible(true);
		btnMngGenProj.setVisible(true);
		btnMngGenTask.setVisible(true);
		btnQuit.setBounds(310, 148, 100, 23);
		btnLogOut.setBounds(82, 148, 100, 23);
		setBounds(100, 100, 488, 221);
		setLocationRelativeTo(null);
	}
	
	private void setVisibleButtonsSeller(){
		btnManagePersoProj.setVisible(false);
		btnManagePersoTask.setVisible(false);
		btnMyJournal.setVisible(false);
		btnShop.setVisible(false);
		btnManageBasket.setVisible(false);
		btnLogOut.setVisible(true);
		//btnMembers.setVisible(false);
		btnLogIn.setVisible(false);
		btnSignIn.setVisible(false);
		
		btnMyShop.setVisible(true);
		btnEditProfile.setEnabled(true);
		btnOrder.setEnabled(true);	
		btnOffers.setEnabled(true);
		btnOffers.setBounds(240, 80, 219, 23);
		btnOrder.setBounds(10,80,219,23);
		btnQuit.setBounds(310, 114, 100, 23);
		btnLogOut.setBounds(82, 114, 100, 23);
		setBounds(100, 100, 488, 200);
		setLocationRelativeTo(null);
	}
}
