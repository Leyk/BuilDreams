package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldSiret;
	private JTextField textFieldWeb;
	private JTextField textFieldDomainActivity;
	private JCheckBox chckbxYes;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public ViewRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 300);
		setTitle("BuilDreams : Registration");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
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
		lblPassword.setBounds(26, 144, 76, 14);
		contentPane.add(lblPassword);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(123, 37, 182, 20);
		contentPane.add(textFieldName);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setBounds(123, 74, 182, 20);
		contentPane.add(textFieldSurname);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(123, 109, 182, 20);
		contentPane.add(textFieldEmail);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(123, 179, 182, 20);
		contentPane.add(textFieldPhone);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reussi = 0;
				if (reussi == 1){
					
				}
			}
		});
		btnRegister.setBounds(38, 214, 89, 23);
		contentPane.add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewHome fenHome = new ViewHome();  // A CHANGER, renvoyer si user non connecté ou si admin
				fenHome.setVisible(true);	
				dispose();
			}
		});
		btnCancel.setBounds(182, 214, 89, 23);
		contentPane.add(btnCancel);
		
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
		
		JLabel lblSellReg = new JLabel("Is it a seller registration ?");
		lblSellReg.setBounds(26, 6, 182, 20);
		contentPane.add(lblSellReg);
		
		JCheckBox chckbxYes = new JCheckBox("Yes");
		chckbxYes.setBounds(182, 5, 97, 23);
		contentPane.add(chckbxYes);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 144, 182, 20);
		contentPane.add(passwordField);
		
		chckbxYes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (chckbxYes.isSelected()){
					lblDomainActivity.setVisible(true);
					lblWebsite.setVisible(true);
					lblSiret.setVisible(true);
					textFieldSiret.setVisible(true);
					textFieldWeb.setVisible(true);
					textFieldDomainActivity.setVisible(true);
					btnRegister.setBounds(38, 326, 89, 23);
					btnCancel.setBounds(182, 326, 89, 23);
					setBounds(100, 100, 338, 410);
					setLocationRelativeTo(null);
					
				}
				else {
					lblDomainActivity.setVisible(false);
					lblWebsite.setVisible(false);
					lblSiret.setVisible(false);
					textFieldSiret.setVisible(false);
					textFieldWeb.setVisible(false);
					textFieldDomainActivity.setVisible(false);
					btnRegister.setBounds(38, 214, 89, 23);
					btnCancel.setBounds(182, 214, 89, 23);
					setBounds(100, 100, 338, 300);
					setLocationRelativeTo(null);

				}
				}
			});
	}
}
