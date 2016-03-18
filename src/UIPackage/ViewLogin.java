package UIPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BusinessLogic.FacadeView;

public class ViewLogin extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField textField_login;
	private JPasswordField textField_password;
	private JButton btnLogIn;
	private JButton btnCancel;
	private FacadeView myFacadeView;
	

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
		
		textField_login = new JTextField();
		textField_login.setBounds(108, 50, 176, 20);
		contentPane.add(textField_login);
		textField_login.setColumns(10);
		
		textField_password = new JPasswordField();
		textField_password.setBounds(108, 87, 176, 20);
		contentPane.add(textField_password);
		textField_password.setColumns(10);
		
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
	
	/* FIN ACCESSEUR */
	
	
	/* Impl�mentation de l'interface ActionListener */
	
	private void addActionListenner () {
		this.getButtonLogIn().addActionListener(this);
		this.getButtonCancel().addActionListener(this);
	}
	
	public void actionPerformed (ActionEvent e){
		if ("Cancel".equals(e.getActionCommand())){
			ViewHome fenHome = new ViewHome();
			fenHome.setVisible(true);	
			this.dispose();
		}
		else if ("Login".equals(e.getActionCommand())){
			//String [] recup = this.connectionDatabase(this.getTextFieldLogin(), this.getTextFieldPassword());
			this.myFacadeView = new FacadeView(this.getTextFieldLogin(),this.getTextFieldPassword());
			
			String [] recupInfo = this.myFacadeView.loginJDBC();
			
			if (recupInfo[0].equals(this.getTextFieldLogin()) && recupInfo[0] != ""){
				//System.out.println("Bravo, votre identifiant existe bien en base de donn�es ! Il ne reste plus qu'� terminer le programme !");
				this.connexionReussieDisplay(recupInfo);
				ViewHome fenHome = new ViewHome(true, "Administrator"); // A REMPLACER PAR LE ROLE RECUPERE
				fenHome.setVisible(true);
				dispose();
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Login/Password, please try again.",
			   		     "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/* Fin Code d'impl�mentation de l'interface ActionListener */
	public void keyReleased(KeyEvent e) {  
		if (e.getKeyCode() == KeyEvent.VK_ENTER){  
			btnLogIn.doClick();
		}
	}
	
	/* Affichage d'une nouvelle fenetre si la connexion est r�ussie (� re-d�velopper) */ 
	
	public void connexionReussieDisplay (String[] recupInfoIn) {
		this.getRootPane().repaint();
		this.getRootPane().revalidate();
		
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel simpleWords = new JLabel("Bienvenu sur l'application BuilDreams !");
		simpleWords.setBounds(10, 5, 88, 50);
		contentPane.add(simpleWords);
		
		JLabel lblID = new JLabel("Nickname : " + recupInfoIn[0]);
		lblID.setBounds(10, 40, 88, 50);
		contentPane.add(lblID);
		
		JLabel lblName = new JLabel("Nickname : " + recupInfoIn[1]);
		lblName.setBounds(10, 60, 88, 50);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password : "+ recupInfoIn[2]);
		lblPassword.setBounds(10, 80, 88, 50);
		contentPane.add(lblPassword);
		
		JLabel lblsurname = new JLabel("surname : "+ recupInfoIn[3]);
		lblsurname.setBounds(10, 100, 88, 50);
		contentPane.add(lblsurname);
		
		JLabel lblemail = new JLabel("email : "+ recupInfoIn[4]);
		lblemail.setBounds(10, 120, 88, 50);
		contentPane.add(lblemail);
		
		JLabel lblphoneNumber = new JLabel("phoneNumber : "+ recupInfoIn[5]);
		lblphoneNumber.setBounds(10, 140, 88, 50);
		contentPane.add(lblPassword);
		
		this.setVisible(true);		
		this.setLocationRelativeTo(null);
	}
}
