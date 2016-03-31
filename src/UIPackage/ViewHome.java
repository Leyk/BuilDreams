package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewHome extends JFrame implements ActionListener {

	AbstractPerson myAbstractPerson;
	ArrayList<AbstractRole> myAbstractArrayListRole;
	
	private String myRole;
	
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
		this.myAbstractArrayListRole = new ArrayList<AbstractRole>(0);
		this.CreationViewHome();
	}
	
	public ViewHome(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.myAbstractPerson = myAbstractPersonIn;
		this.myAbstractArrayListRole = myAbstractArrayListRoleIn;
		
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
		
		myRole = "";
		
		
		
		if (this.myAbstractArrayListRole.isEmpty())  {
			myRole = "visiteur";
		}
		else {
			myRole = this.myAbstractArrayListRole.get(0).getWording();
		}
		
		JLabel lblConnectAs = new JLabel("Connected as " + myRole);
		lblConnectAs.setBounds(230, 11, 194, 14);
		contentPane.add(lblConnectAs);
		
		this.btnEditProfile = new JButton("Edit my profile");
		btnEditProfile.setBounds(10, 46, 219, 23);
		contentPane.add(btnEditProfile);
		btnEditProfile.setEnabled(false);
		
		this.btnMngProduct = new JButton("Manage products");
		btnMngProduct.setBounds(10, 114, 219, 23);
		contentPane.add(btnMngProduct);
		btnMngProduct.setVisible(false);
		
		this.btnManagePersoProj = new JButton("My projects");
		btnManagePersoProj.setBounds(10, 80, 219, 23);
		contentPane.add(btnManagePersoProj);
		btnManagePersoProj.setEnabled(false);
		
		this.btnMngGenProj = new JButton("Manage general projects");
		btnMngGenProj.setBounds(10, 80, 219, 23);
		contentPane.add(btnMngGenProj);
		btnMngGenProj.setVisible(false);
		
		this.btnOrder = new JButton("My orders");
		btnOrder.setBounds(10, 114, 219, 23);
		contentPane.add(btnOrder);
		btnOrder.setEnabled(false);
		
		this.btnMyJournal = new JButton("My journal");
		btnMyJournal.setBounds(240, 148, 219, 23);
		contentPane.add(btnMyJournal);
		btnMyJournal.setEnabled(false);
		
		this.btnMngUser = new JButton("Manage members");
		btnMngUser.setBounds(240, 46, 219, 23);
		contentPane.add(btnMngUser);
		btnMngUser.setVisible(false);
		
		/*this.btnMembers = new JButton("Members public space");
		btnMembers.setBounds(240, 148, 219, 23);
		contentPane.add(btnMembers);
		btnMembers.setEnabled(false);*/
		
		this.btnShop = new JButton("Online shop");
		btnShop.setBounds(240, 46, 219, 23);
		contentPane.add(btnShop);
		btnShop.setEnabled(false);
		
		this.btnMngCateg = new JButton("Manage product categories");
		btnMngCateg.setBounds(240,114,219,23);
		contentPane.add(btnMngCateg);
		btnMngCateg.setVisible(false);
		
		this.btnMyShop = new JButton("My shop");
		btnMyShop.setBounds(240, 46, 219, 23);
		contentPane.add(btnMyShop);
		btnMyShop.setVisible(false);
		
		this.btnManageBasket = new JButton("My basket");
		btnManageBasket.setBounds(10, 148, 219, 23);
		contentPane.add(btnManageBasket);
		btnManageBasket.setEnabled(false);
		
		
		this.btnManagePersoTask = new JButton("My tasks");
		btnManagePersoTask.setBounds(240, 80, 219, 23);
		contentPane.add(btnManagePersoTask);
		btnManagePersoTask.setEnabled(false);
		
		this.btnMngGenTask = new JButton("Manage general tasks");
		btnMngGenTask.setBounds(240, 80, 219, 23);
		contentPane.add(btnMngGenTask);
		btnMngGenTask.setVisible(false);
		
		this.btnOffers = new JButton("My offers ");
		btnOffers.setBounds(240, 114, 219, 23);
		contentPane.add(btnOffers);
		btnOffers.setEnabled(false);
		
		this.btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(82, 182, 100, 23);
		contentPane.add(btnLogOut);
		btnLogOut.setVisible(false);
		
		this.btnSignIn = new JButton("Sign in");
		btnSignIn.setBounds(190, 182, 100, 23);
		contentPane.add(btnSignIn);
		
		this.btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(72, 182, 100, 23);
		contentPane.add(btnLogIn);
		
		this.btnQuit = new JButton("Quit");
		btnQuit.setBounds(310, 182, 100, 23);
		contentPane.add(btnQuit);
		
		this.setLocationRelativeTo(null);
		
		if (myRole.equals("users")){
			this.setEnableButtonsUser();
		}
		else if (myRole.equals("admin")){
			this.setVisibleButtonsAdmin();
		}
		else if (myRole.equals("seller")){
			this.setVisibleButtonsSeller();
		}
		
		this.addActionListener();
	}
	
	private void setEnableButtonsUser() {
		btnEditProfile.setEnabled(true);
		btnManagePersoProj.setEnabled(true);
		btnManagePersoTask.setEnabled(true);
		btnShop.setEnabled(true);
		btnManageBasket.setEnabled(true);
		//btnOffers.setEnabled(true);
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
		//btnOffers.setEnabled(true);
		btnOffers.setBounds(240, 80, 219, 23);
		btnOrder.setBounds(10,80,219,23);
		btnQuit.setBounds(310, 114, 100, 23);
		btnLogOut.setBounds(82, 114, 100, 23);
		setBounds(100, 100, 488, 200);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Edit my profile".equals(e.getActionCommand())){
			System.out.println(String.valueOf(myAbstractPerson.getPassword()));
			System.out.println(String.valueOf(myAbstractArrayListRole.get(0).getWording()));
			ViewEditProfile fenEditProfile = new ViewEditProfile(myAbstractPerson, myAbstractArrayListRole);
			fenEditProfile.setVisible(true);		
			dispose();
		}
		else if ("Manage products".equals(e.getActionCommand())){
			ViewManageShop fenMngShop = new ViewManageShop(myAbstractPerson,myAbstractArrayListRole);
			fenMngShop.setVisible(true);		
			dispose();
		}
		else if ("My projects".equals(e.getActionCommand())){
			ViewManagePersoProject fenMngPersoProj = new ViewManagePersoProject(myAbstractPerson,myAbstractArrayListRole);
			fenMngPersoProj.setVisible(true);		
			dispose();
		}
		else if ("Manage general projects".equals(e.getActionCommand())){
			ViewManageGenProject fenMngGenProj = new ViewManageGenProject(myAbstractPerson,myAbstractArrayListRole);
			fenMngGenProj.setVisible(true);		
			dispose();
		}
		else if ("My orders".equals(e.getActionCommand())){
			ViewManageOrder fenMngOrder = new ViewManageOrder(myAbstractPerson,myAbstractArrayListRole);
			fenMngOrder.setVisible(true);		
			dispose();
		}
		else if ("My journal".equals(e.getActionCommand())){
			
		}
		else if ("Manage members".equals(e.getActionCommand())){
			ViewManageMember fenMngUser = new ViewManageMember(myAbstractPerson,myAbstractArrayListRole);
			fenMngUser.setVisible(true);		
			dispose();
		}
		else if ("Online shop".equals(e.getActionCommand())){
			ViewOnlineShop fenOnlineShop = new ViewOnlineShop(myAbstractPerson,myAbstractArrayListRole);
			fenOnlineShop.setVisible(true);		
			dispose();
		}
		else if ("Manage product categories".equals(e.getActionCommand())){
			ViewManageCategory fenMngCategory = new ViewManageCategory(myAbstractPerson,myAbstractArrayListRole);
			fenMngCategory.setVisible(true);		
			dispose();
		}
		else if ("My shop".equals(e.getActionCommand())){
			ViewManageShop fenMngShop = new ViewManageShop(myAbstractPerson,myAbstractArrayListRole);
			fenMngShop.setVisible(true);		
			dispose();
		}
		else if ("My basket".equals(e.getActionCommand())){
			ViewBasket fenBasket = new ViewBasket(myAbstractPerson,myAbstractArrayListRole);
			fenBasket.setVisible(true);		
			dispose();
		}
		else if ("My tasks".equals(e.getActionCommand())){
			ViewManagePersoTask fenMngPersoTask = new ViewManagePersoTask(myAbstractPerson,myAbstractArrayListRole);
			fenMngPersoTask.setVisible(true);		
			dispose();
		}
		else if ("Manage general tasks".equals(e.getActionCommand())){
			ViewManageGenTask fenMngGenTask = new ViewManageGenTask(myAbstractPerson,myAbstractArrayListRole);
			fenMngGenTask.setVisible(true);		
			dispose();
		}
		else if ("My offers ".equals(e.getActionCommand())){
			//ViewManageOffer fenMngOffer = new ViewManageOffer(myAbstractPerson,myAbstractArrayListRole);
			//fenMngOffer.setVisible(true);		
			//dispose();
		}
		else if ("Log out".equals(e.getActionCommand())){
			ViewHome fenHome = new ViewHome();
			dispose();
			JOptionPane.showMessageDialog(null, "You are now disconnected.",
		   		     "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			fenHome.setVisible(true);
		}
		else if ("Sign in".equals(e.getActionCommand())){
			ViewRegistration fenReg = new ViewRegistration();
			fenReg.setVisible(true);
			dispose();
		}
		else if ("Log in".equals(e.getActionCommand())){
			ViewLogin fenLogin = new ViewLogin();
			fenLogin.setVisible(true);
			dispose();
		}
		else if ("Quit".equals(e.getActionCommand())){
			dispose();
	    	System.exit(0);
		}
	}
	
	private void addActionListener () {
		this.btnEditProfile.addActionListener(this);
		this.btnManagePersoProj.addActionListener(this);
		this.btnMyJournal.addActionListener(this);
		this.btnShop.addActionListener(this);
		this.btnManageBasket.addActionListener(this);
		this.btnLogOut.addActionListener(this);
		this.btnOffers.addActionListener(this);
		this.btnSignIn.addActionListener(this);
		this.btnLogIn.addActionListener(this);
		this.btnMngProduct.addActionListener(this);
		this.btnMngUser.addActionListener(this);
		this.btnMngCateg.addActionListener(this);
		this.btnMngGenProj.addActionListener(this);
		this.btnMngGenTask.addActionListener(this);
		this.btnQuit.addActionListener(this);
		this.btnMyShop.addActionListener(this);
		this.btnOrder.addActionListener(this);
		this.btnManagePersoTask.addActionListener(this);
	}
}
