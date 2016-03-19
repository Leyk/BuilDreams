package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPersoTask extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldBeginDate;
	private JTextField textFieldTheoricalLen;

	public ViewPersoTask() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 344);
		setTitle("BuilDreams : Create a personnal task");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(26, 57, 86, 20);
		contentPane.add(lblName);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(26, 94, 86, 20);
		contentPane.add(lblDescription);
		
		JLabel lblTheoricalLen = new JLabel("Theorical length");
		lblTheoricalLen.setBounds(26, 164, 86, 20);
		contentPane.add(lblTheoricalLen);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(26, 201, 86, 20);
		contentPane.add(lblCategory);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(88, 271, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewManagePersoProject fenMngPersoProjTask = new ViewManagePersoProject(); 
				fenMngPersoProjTask.setVisible(true);	
				dispose();
			}
		});
		btnCancel.setBounds(214, 271, 89, 23);
		contentPane.add(btnCancel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(123, 57, 182, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setBounds(123, 94, 182, 20);
		contentPane.add(textFieldDescription);
		textFieldDescription.setColumns(10);
		
		JList listCategory = new JList();
		listCategory.setBounds(122, 201, 182, 20);
		contentPane.add(listCategory);
		
		JLabel lblBeginDate = new JLabel("Begin date");
		lblBeginDate.setBounds(26, 129, 86, 20);
		contentPane.add(lblBeginDate);
		
		textFieldBeginDate = new JTextField();
		textFieldBeginDate.setBounds(123, 129, 182, 20);
		contentPane.add(textFieldBeginDate);
		
		textFieldTheoricalLen = new JTextField();
		textFieldTheoricalLen.setBounds(122, 164, 182, 20);
		contentPane.add(textFieldTheoricalLen);
		
		JLabel lblProduct = new JLabel("Products");
		lblProduct.setBounds(26, 238, 46, 14);
		contentPane.add(lblProduct);
		
		JList listProduct = new JList();
		listProduct.setBounds(123, 238, 182, 20);
		contentPane.add(listProduct);
		
		JLabel lblUseExistingTask = new JLabel("Use existing task");
		lblUseExistingTask.setBounds(26, 3, 144, 14);
		contentPane.add(lblUseExistingTask);
		
		JCheckBox chckbxYes = new JCheckBox("Yes");
		chckbxYes.setBounds(176, -1, 97, 23);
		contentPane.add(chckbxYes);
		
		JLabel lblTask = new JLabel("Task");
		lblTask.setBounds(26, 27, 65, 14);
		contentPane.add(lblTask);
		lblTask.setVisible(false);
		
		JList listTask = new JList();
		listTask.setBounds(123, 27, 182, 20);
		contentPane.add(listTask);
		listTask.setVisible(false);
		
		chckbxYes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (chckbxYes.isSelected()){
					listTask.setVisible(true);
					lblTask.setVisible(true);			
				}
				else {
					listTask.setVisible(false);
					lblTask.setVisible(false);	
				}
			}
		});
	}

}
