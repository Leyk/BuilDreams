package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldReference;
	private AbstractPerson myPerson;
	private ArrayList<AbstractRole> myAbstractRoleArray;

	public ViewProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("BuilDreams : Create a product");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblConnectedAs = new JLabel("Connected as");
		lblConnectedAs.setBounds(123, 11, 119, 14);
		contentPane.add(lblConnectedAs);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(26, 37, 86, 14);
		contentPane.add(lblName);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(26, 74, 76, 14);
		contentPane.add(lblCategory);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(26, 179, 86, 14);
		contentPane.add(lblDescription);
		
		JLabel lblSubCategory = new JLabel("Subcategory");
		lblSubCategory.setBounds(26, 109, 86, 14);
		contentPane.add(lblSubCategory);
		
		JLabel lblReference = new JLabel("Reference");
		lblReference.setBounds(26, 144, 76, 14);
		contentPane.add(lblReference);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(123, 36, 182, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setBounds(123, 176, 182, 20);
		contentPane.add(textFieldDescription);
		textFieldDescription.setColumns(10);
		
		textFieldReference = new JTextField();
		textFieldReference.setBounds(123, 141, 182, 20);
		contentPane.add(textFieldReference);
		textFieldReference.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(36, 285, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewManageShop fenMngShop = new ViewManageShop();
				fenMngShop.setVisible(true);	
				dispose();
			}
		});
		btnCancel.setBounds(192, 285, 89, 23);
		contentPane.add(btnCancel);
		
		JList listSubCategory = new JList();
		listSubCategory.setBounds(123, 103, 182, 20);
		contentPane.add(listSubCategory);
		
		JList listCategory = new JList();
		listCategory.setBounds(123, 74, 182, 20);
		contentPane.add(listCategory);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(26, 216, 46, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblUnitPrice = new JLabel("Unit price");
		lblUnitPrice.setBounds(26, 253, 86, 14);
		contentPane.add(lblUnitPrice);
		
		JSpinner spinnerQuantity = new JSpinner();
		spinnerQuantity.setBounds(123, 216, 29, 20);
		contentPane.add(spinnerQuantity);
		
		JFormattedTextField formattedTextFieldUnitPrice = new JFormattedTextField();
		formattedTextFieldUnitPrice.setBounds(123, 253, 76, 20);
		contentPane.add(formattedTextFieldUnitPrice);
	}
}
