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

public class ViewPersoProject extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldBeginDate;
	private JTextField textFieldEstimateLen;

	public ViewPersoProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 314);
		setTitle("BuilDreams : Create a personnal project");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 57, 102, 20);
		contentPane.add(lblName);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 94, 102, 20);
		contentPane.add(lblDescription);
		
		JLabel lblTask = new JLabel("General tasks");
		lblTask.setBounds(10, 164, 102, 20);
		contentPane.add(lblTask);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(50, 241, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewManagePersoProject fenMngPersoProjTask = new ViewManagePersoProject(); 
				fenMngPersoProjTask.setVisible(true);	
				dispose();
			}
		});
		btnCancel.setBounds(184, 241, 89, 23);
		contentPane.add(btnCancel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(123, 57, 182, 20);
		contentPane.add(textFieldName);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setBounds(123, 94, 182, 20);
		contentPane.add(textFieldDescription);
		
		JList listGeneralTask = new JList();
		listGeneralTask.setBounds(123, 164, 182, 20);
		contentPane.add(listGeneralTask);
		
		JLabel lblBeginDate = new JLabel("Begin date");
		lblBeginDate.setBounds(10, 129, 102, 20);
		contentPane.add(lblBeginDate);
		
		textFieldBeginDate = new JTextField();
		textFieldBeginDate.setBounds(123, 129, 182, 20);
		contentPane.add(textFieldBeginDate);
		
		JLabel lblUseAnExisting = new JLabel("Use an existing project :");
		lblUseAnExisting.setBounds(26, 3, 144, 14);
		contentPane.add(lblUseAnExisting);
		
		JCheckBox chckbxYes = new JCheckBox("Yes");
		chckbxYes.setBounds(176, -1, 97, 23);
		contentPane.add(chckbxYes);
		
		JLabel lblSelectAProject = new JLabel("Project ");
		lblSelectAProject.setBounds(10, 27, 81, 14);
		contentPane.add(lblSelectAProject);
		lblSelectAProject.setVisible(false);
		
		JList listProject = new JList();
		listProject.setBounds(123, 27, 182, 20);
		contentPane.add(listProject);
		listProject.setVisible(false);
		
		JLabel lblEstimateLength = new JLabel("Estimate length :");
		lblEstimateLength.setBounds(10, 201, 102, 14);
		contentPane.add(lblEstimateLength);
		
		textFieldEstimateLen = new JTextField();
		textFieldEstimateLen.setBounds(123, 201, 86, 20);
		contentPane.add(textFieldEstimateLen);

		chckbxYes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (chckbxYes.isSelected()){
					listProject.setVisible(true);
					lblSelectAProject.setVisible(true);			
				}
				else {
					listProject.setVisible(false);
					lblSelectAProject.setVisible(false);	
				}
			}
		});
	}
}
