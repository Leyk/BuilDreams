package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;
import BusinessLogic.FacadeBasket;
import BusinessLogic.FacadeShopOrder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewPayment extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldOwnerName;
	private JTextField textFieldValidityDate;
	
	private FacadeShopOrder myFacade;
	
	private JButton btnCancel;
	private JButton btnConfirmOrder;

	public ViewPayment(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.myFacade = new FacadeShopOrder();
		
		this.myFacade.setMyPerson(myAbstractPersonIn);
		this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
		
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
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(48, 182, 134, 23);
		contentPane.add(btnCancel);
		
		btnConfirmOrder = new JButton("Confirm order");
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
		
		this.addActionListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Cancel".equals(e.getActionCommand())){
			ViewBasket fenBasket = new ViewBasket(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray()); // A REMPLACER PAR LE ROLE RECUPERE
			fenBasket.setVisible(true);	
			dispose();
		}
		else if ("Confirm order".equals(e.getActionCommand())){
			
		}
	}
	
	public void addActionListener () {
		this.btnCancel.addActionListener(this);
		this.btnConfirmOrder.addActionListener(this);
	}
}
