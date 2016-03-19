package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;

public class ViewGenProject extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldDescription;

	public ViewGenProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 262);
		setTitle("BuilDreams : Create a general project");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(26, 37, 86, 20);
		contentPane.add(lblName);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(26, 74, 86, 20);
		contentPane.add(lblDescription);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(26, 109, 86, 20);
		contentPane.add(lblCategory);
		
		JLabel lblTask = new JLabel("Tasks");
		lblTask.setBounds(26, 144, 86, 20);
		contentPane.add(lblTask);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(105, 188, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewManageGenProject fenMngGenProj = new ViewManageGenProject();
				fenMngGenProj.setVisible(true);	
				dispose();
			}
		});
		btnCancel.setBounds(216, 188, 89, 23);
		contentPane.add(btnCancel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(123, 37, 182, 20);
		contentPane.add(textFieldName);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setBounds(123, 74, 182, 20);
		contentPane.add(textFieldDescription);
	
		JList listCategory = new JList();
		listCategory.setBounds(123, 109, 182, 20);
		contentPane.add(listCategory);
		
		JList listTask = new JList();
		listTask.setBounds(123, 141, 182, 20);
		contentPane.add(listTask);
	}

}
