package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPayment extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldOwnerName;
	private JTextField textFieldValidityDate;

	public ViewPayment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 255);
		setTitle("BuilDreams : Order Payment");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblCardNb = new JLabel("Credit card number :");
		lblCardNb.setBounds(48, 37, 126, 14);
		contentPane.add(lblCardNb);
		
		JLabel lblSecurityCode = new JLabel("Security code :");
		lblSecurityCode.setBounds(48, 74, 126, 14);
		contentPane.add(lblSecurityCode);
		
		JLabel lblOwnersName = new JLabel("Owner's name :");
		lblOwnersName.setBounds(48, 109, 126, 14);
		contentPane.add(lblOwnersName);
		
		JLabel lblValidityDate = new JLabel("Validity date :");
		lblValidityDate.setBounds(48, 144, 126, 14);
		contentPane.add(lblValidityDate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBasket fenBasket = new ViewBasket(); // A REMPLACER PAR LE ROLE RECUPERE
				fenBasket.setVisible(true);	
				dispose();
			}
		});
		btnCancel.setBounds(48, 182, 134, 23);
		contentPane.add(btnCancel);
		
		JButton btnConfirmOrder = new JButton("Confirm order");
		btnConfirmOrder.setBounds(215, 182, 134, 23);
		contentPane.add(btnConfirmOrder);
		
		textFieldOwnerName = new JTextField();
		textFieldOwnerName.setBounds(167, 109, 182, 20);
		contentPane.add(textFieldOwnerName);
		textFieldOwnerName.setColumns(10);
		
		JFormattedTextField formattedTextFieldCardNb = new JFormattedTextField();
		formattedTextFieldCardNb.setBounds(167, 37, 182, 20);
		contentPane.add(formattedTextFieldCardNb);
		
		JFormattedTextField formattedTextFieldSecurityCode = new JFormattedTextField();
		formattedTextFieldSecurityCode.setBounds(167, 74, 182, 20);
		contentPane.add(formattedTextFieldSecurityCode);
		
		textFieldValidityDate = new JTextField();
		textFieldValidityDate.setBounds(167, 144, 182, 20);
		contentPane.add(textFieldValidityDate);
		textFieldValidityDate.setColumns(10);
	}
}
