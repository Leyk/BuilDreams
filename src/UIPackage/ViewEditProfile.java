package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewEditProfile extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldDomainActivity;
	private JTextField textFieldWeb;
	private JTextField textFieldSiret;

	public ViewEditProfile(String role) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblConnectedAs = new JLabel("Connected as "+role);
		lblConnectedAs.setBounds(123, 11, 119, 14);
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
		textFieldName.setColumns(10);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setBounds(123, 71, 182, 20);
		contentPane.add(textFieldSurname);
		textFieldSurname.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(123, 106, 182, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(123, 141, 182, 20);
		contentPane.add(passwordField);
		
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
		btnUpdate.setBounds(51, 211, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewHome fenHome = new ViewHome(true,"User"); // A REMPLACER PAR LE ROLE RECUPERE
				fenHome.setVisible(true);	
				dispose();
			}
		});
		btnCancel.setBounds(191, 211, 89, 23);
		contentPane.add(btnCancel);
		this.setTitle("BuilDreams : Edit user profile");
		
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
		}
	}
}
