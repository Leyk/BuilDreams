package UIPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;
import BusinessLogic.FacadeLogin;

public class ViewLogin extends JFrame implements ActionListener{
	private JPanel contentPane;
	private MyTextField textField_login;
	private MyPasswordField textField_password;
	private JButton btnLogIn;
	private JButton btnCancel;
	private FacadeLogin myFacadeLogin;
	

	/**
	 * Create the frame.
	 */
	
	/* Constructeur de la vue Login */
	public ViewLogin() {
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(10, 83, 88, 28);
		contentPane.add(lblPassword);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(10, 46, 88, 28);
		contentPane.add(lblLogin);
		
		btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(32, 130, 112, 23);
		contentPane.add(btnLogIn);
		btnLogIn.setActionCommand("Login");
		
		textField_login = new MyTextField();
		textField_login.setActionCommand("Login");
		textField_login.setBounds(108, 50, 176, 20);
		contentPane.add(textField_login);

		textField_password = new MyPasswordField();
		textField_password.setActionCommand("Login");
		textField_password.setBounds(108, 87, 176, 20);
		contentPane.add(textField_password);
		
		JLabel lblinfo1 = new JLabel("You must log in to access BuilDreams App");
		lblinfo1.setBounds(32, 11, 252, 24);
		contentPane.add(lblinfo1);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(176, 130, 112, 23);
		contentPane.add(btnCancel);
		this.setTitle("BuilDreams");
		btnCancel.setActionCommand("Cancel");
		
		this.addActionListenner();
		
		this.setVisible(true);		
		this.setLocationRelativeTo(null);
	}	
	
	
	
	
	/* ACCESSEURS */
	
	public JButton getButtonLogIn() {
		return this.btnLogIn;
	}
	
	public JButton getButtonCancel() {
		return this.btnCancel;
	}
	
	public String getTextFieldLogin() {
		return this.textField_login.getText();
	}
	
	public String getTextFieldPassword() {
		return this.textField_password.getText();
	}
	
	public MyPasswordField getTextFieldPasswordObject() {
		return this.textField_password;
	}
	
	public MyTextField getTextFieldObject() {
		return this.textField_login;
	}
	/* FIN ACCESSEUR */
	
	
	/* Impl�mentation de l'interface ActionListener */
	
	private void addActionListenner () {
		this.getButtonLogIn().addActionListener(this);
		this.getButtonCancel().addActionListener(this);
		this.getTextFieldPasswordObject().addActionListener(this);
		this.getTextFieldObject().addActionListener(this);
	}
	
	public void actionPerformed (ActionEvent e){
		if ("Cancel".equals(e.getActionCommand())){
			ViewHome fenHome = new ViewHome();
			fenHome.setVisible(true);	
			this.dispose();
		}
		else if ("Login".equals(e.getActionCommand()) || "".equals(e.getActionCommand())){
			this.myFacadeLogin = new FacadeLogin();
			
			boolean recupInfo = this.myFacadeLogin.login(this.getTextFieldLogin(),this.getTextFieldPassword());
			
			if (recupInfo){
				AbstractPerson recupPerson = this.myFacadeLogin.getMyPerson();
				ArrayList<AbstractRole> recupRole = this.myFacadeLogin.getMyAbstractRoleArray();
				
				ViewHome fenHome = new ViewHome(recupPerson, recupRole); // A REMPLACER PAR LE ROLE RECUPERE
				fenHome.setVisible(true);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Login/Password, please try again.",
			   		     "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/* Fin Code d'impl�mentation de l'interface ActionListener */  // A FINALISER
	
	/* Affichage d'une nouvelle fenetre si la connexion est r�ussie (� re-d�velopper) */ 
	
	
}
