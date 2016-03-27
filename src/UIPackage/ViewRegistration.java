package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLogic.FacadeRegistration;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewRegistration extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JTextField textFieldPhone;
	private JTextField textFieldSiret;
	private JTextField textFieldWeb;
	private JTextField textFieldDomainActivity;
	private JTextField textFieldPseudo;
	
	private JCheckBox chckbxYes;
	
	private JLabel lblDomainActivity;
	private JLabel lblWebsite;
	private JLabel lblSiret;
	;
	private JButton btnRegister;
	private JButton btnCancel;
	
	private FacadeRegistration myFacadeRegistration;

	/**
	 * Create the frame.
	 */
	public ViewRegistration() {
		this.myFacadeRegistration = new FacadeRegistration();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 337);
		setTitle("BuilDreams : Registration");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(26, 37, 86, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(26, 74, 76, 14);
		contentPane.add(lblSurname);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(26, 220, 86, 14);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(26, 146, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(26, 109, 76, 14);
		contentPane.add(lblNickname);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(26, 183, 76, 14);
		contentPane.add(lblPassword);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(123, 37, 182, 20);
		contentPane.add(textFieldName);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setBounds(123, 74, 182, 20);
		contentPane.add(textFieldSurname);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(123, 146, 182, 20);
		contentPane.add(textFieldEmail);
		
		textFieldPseudo = new JTextField();
		textFieldPseudo.setBounds(123, 109, 182, 20);
		contentPane.add(textFieldPseudo);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(123, 220, 182, 20);
		contentPane.add(textFieldPhone);
		
		this.btnRegister = new JButton("Register");
		this.btnRegister.addActionListener(this);
		this.btnRegister.setBounds(38, 251, 89, 23);
		contentPane.add(this.btnRegister);
		
		this.btnCancel = new JButton("Cancel");
		this.btnCancel.addActionListener(this);
		this.btnCancel.setBounds(182, 251, 89, 23);
		contentPane.add(this.btnCancel);
		
		textFieldSiret = new JTextField();
		textFieldSiret.setBounds(123, 257, 182, 20);
		contentPane.add(textFieldSiret);
		textFieldSiret.setVisible(false);
		
		this.lblSiret = new JLabel("Siret");
		this.lblSiret.setBounds(26, 257, 86, 17);
		contentPane.add(this.lblSiret);
		this.lblSiret.setVisible(false);
		
		textFieldWeb = new JTextField();
		textFieldWeb.setBounds(123, 294, 182, 20);
		contentPane.add(textFieldWeb);
		textFieldWeb.setVisible(false);
		
		this.lblWebsite = new JLabel("Website");
		this.lblWebsite.setBounds(26, 294, 86, 14);
		contentPane.add(this.lblWebsite);
		this.lblWebsite.setVisible(false);
		
		textFieldDomainActivity = new JTextField();
		textFieldDomainActivity.setBounds(123, 331, 182, 20);
		contentPane.add(textFieldDomainActivity);
		textFieldDomainActivity.setVisible(false);
		
		this.lblDomainActivity = new JLabel("Domain activity");
		this.lblDomainActivity.setBounds(26, 331, 86, 14);
		contentPane.add(lblDomainActivity);
		this.lblDomainActivity.setVisible(false);
		
		JLabel lblSellReg = new JLabel("Is it a seller registration ?");
		lblSellReg.setBounds(26, 6, 182, 20);
		contentPane.add(lblSellReg);
		
		this.chckbxYes = new JCheckBox("Yes");
		this.chckbxYes.addActionListener(this);
		chckbxYes.setBounds(182, 5, 97, 23);
		contentPane.add(chckbxYes);
		
		this.textFieldPassword = new JPasswordField();
		this.textFieldPassword.setBounds(123, 183, 182, 20);
		contentPane.add(textFieldPassword);
	}
	
	
	public void actionPerformed (ActionEvent e){
		if ("Cancel".equals(e.getActionCommand())){
			ViewHome fenHome = new ViewHome();  // A CHANGER, renvoyer si user non connecté ou si admin
			fenHome.setVisible(true);	
			dispose();
		}
		else if ("Yes".equals(e.getActionCommand())){
			if (chckbxYes.isSelected()){
				lblDomainActivity.setVisible(true);
				lblWebsite.setVisible(true);
				lblSiret.setVisible(true);
				textFieldSiret.setVisible(true);
				textFieldWeb.setVisible(true);
				textFieldDomainActivity.setVisible(true);
				this.btnRegister.setBounds(38, 363, 89, 23);
				this.btnCancel.setBounds(182, 363, 89, 23);
				setBounds(100, 100, 338, 447);
				setLocationRelativeTo(null);
			}
			else {
				lblDomainActivity.setVisible(false);
				lblWebsite.setVisible(false);
				lblSiret.setVisible(false);
				textFieldSiret.setVisible(false);
				textFieldWeb.setVisible(false);
				textFieldDomainActivity.setVisible(false);
				this.btnRegister.setBounds(38, 251, 89, 23);
				this.btnCancel.setBounds(182, 251, 89, 23);
				setBounds(100, 100, 338, 337);
				setLocationRelativeTo(null);
			}
		}
		else if ("Register".equals(e.getActionCommand())){
			String recup = new String();
			
			if (this.chckbxYes.isSelected()){
				recup = this.myFacadeRegistration.registrationSeller(textFieldPseudo.getText(), textFieldName.getText(), textFieldSurname.getText(), textFieldEmail.getText(), textFieldPassword.getText(), textFieldPhone.getText(), Integer.parseInt(textFieldSiret.getText()), textFieldWeb.getText(), textFieldDomainActivity.getText());
			}
			else {
				recup = this.myFacadeRegistration.registrationUsers(textFieldPseudo.getText(), textFieldName.getText(), textFieldSurname.getText(), textFieldEmail.getText(), textFieldPassword.getText(), textFieldPhone.getText());
			}
			
			if (recup.equals("Invalid registration")){
				JOptionPane.showMessageDialog(null, "Invalid registration, le pseudo que vous demandez est déjà utilisé. Veuillez en choisir un autre !",
			   		     "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Félicitation vous avez réussi à vous inscrire, allez tout de suite vous connecter !",
			   		     "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				ViewHome fenHome = new ViewHome();
				fenHome.setVisible(true);	
				dispose();
			}
		}
	}
}
