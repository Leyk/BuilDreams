package UIPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BusinessLogic.FacadeProfileModifier;

public class ViewEditProfile extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldDomainActivity;
	private JTextField textFieldWeb;
	private JTextField textFieldSiret;
	private JPasswordField textFieldPassword;
	private String role;
	private FacadeProfileModifier myFacadeProfileModifier;

	public ViewEditProfile(String role) {
		this.role = role;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("BuilDreams : Edit my profile");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblConnectedAs = new JLabel("Connected as "+role);
		lblConnectedAs.setBounds(123, 11, 160, 14);
		contentPane.add(lblConnectedAs);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(26, 37, 86, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(26, 74, 76, 14);
		contentPane.add(lblSurname);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(26, 179, 86, 14);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(26, 109, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(26, 141, 86, 14);
		contentPane.add(lblPassword);
	
		textFieldName = new JTextField();
		textFieldName.setBounds(123, 36, 182, 20);
		contentPane.add(textFieldName);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setBounds(123, 71, 182, 20);
		contentPane.add(textFieldSurname);
	
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(123, 106, 182, 20);
		contentPane.add(textFieldEmail);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(123, 141, 182, 20);
		contentPane.add(textFieldPassword);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(123, 176, 182, 20);
		contentPane.add(textFieldPhone);

		textFieldSiret = new JTextField();
		textFieldSiret.setBounds(123, 214, 182, 20);
		contentPane.add(textFieldSiret);
		textFieldSiret.setVisible(false);
		
		JLabel lblSiret = new JLabel("Siret");
		lblSiret.setBounds(26, 214, 86, 17);
		contentPane.add(lblSiret);
		lblSiret.setVisible(false);
		
		textFieldWeb = new JTextField();
		textFieldWeb.setBounds(123, 249, 182, 20);
		contentPane.add(textFieldWeb);
		textFieldWeb.setVisible(false);
		
		JLabel lblWebsite = new JLabel("Website");
		lblWebsite.setBounds(26, 249, 86, 14);
		contentPane.add(lblWebsite);
		lblWebsite.setVisible(false);
		
		textFieldDomainActivity = new JTextField();
		textFieldDomainActivity.setBounds(123, 284, 182, 20);
		contentPane.add(textFieldDomainActivity);
		textFieldDomainActivity.setVisible(false);
		
		JLabel lblDomainActivity = new JLabel("Domain activity");
		lblDomainActivity.setBounds(26, 284, 86, 14);
		contentPane.add(lblDomainActivity);
		lblDomainActivity.setVisible(false);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(51, 211, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(191, 211, 89, 23);
		contentPane.add(btnCancel);
				
		if(role=="Seller"){
			lblDomainActivity.setVisible(true);
			lblWebsite.setVisible(true);
			lblSiret.setVisible(true);
			textFieldSiret.setVisible(true);
			textFieldWeb.setVisible(true);
			textFieldDomainActivity.setVisible(true);
			btnUpdate.setBounds(38, 326, 89, 23);
			btnCancel.setBounds(182, 326, 89, 23);
			setBounds(100, 100, 338, 410);
			setLocationRelativeTo(null);
		}
	}
	
	public void actionPerformed (ActionEvent e){
		if("Cancel".equals(e.getActionCommand())){
				ViewHome fenHome = new ViewHome(true,"User"); // A REMPLACER PAR LE ROLE RECUPERE
				fenHome.setVisible(true);	
				dispose();
		}
		else if("Update".equals(e.getActionCommand())){
			Boolean req = false;
			if(this.role=="User"){
				req = this.myFacadeProfileModifier.modifyProfileUsers(textFieldName.getText(), textFieldSurname.getText(), textFieldEmail.getText(), textFieldPassword.getText(), textFieldPhone.getText());				
			}
			else if(this.role=="Seller"){
				req = this.myFacadeProfileModifier.modifyProfileSeller(textFieldName.getText(), textFieldSurname.getText(), textFieldEmail.getText(), textFieldPassword.getText(), textFieldPhone.getText(), Integer.parseInt(textFieldSiret.getText()), textFieldWeb.getText(), textFieldDomainActivity.getText());
			}
			if(req = true){
				JOptionPane.showMessageDialog(null, "Your profile has been edited successfully !", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);		
				ViewHome fenHome = new ViewHome(true, role);
				fenHome.setVisible(true);	
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "A problem occured when editing your profile ! Please try again or contact the administration ;)",
			   		     "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
