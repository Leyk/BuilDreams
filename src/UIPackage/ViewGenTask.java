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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewGenTask extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldTheoricalLen;

	public ViewGenTask () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 308);
		setTitle("BuilDreams : Create a general task");
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
		lblCategory.setBounds(26, 144, 86, 20);
		contentPane.add(lblCategory);
		
		JLabel lblProduct = new JLabel("Products");
		lblProduct.setBounds(26, 181, 86, 20);
		contentPane.add(lblProduct);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(102, 235, 89, 23);
		contentPane.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewManageGenTask fenMngGenTask = new ViewManageGenTask();
				fenMngGenTask.setVisible(true);	
				dispose();
			}
		});
		btnCancel.setBounds(216, 235, 89, 23);
		contentPane.add(btnCancel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(123, 37, 182, 20);
		contentPane.add(textFieldName);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setBounds(123, 74, 182, 20);
		contentPane.add(textFieldDescription);
		
		JList listCategory = new JList();
		listCategory.setBounds(123, 144, 182, 20);
		contentPane.add(listCategory);
		
		JList listProduct = new JList();
		listProduct.setBounds(122, 181, 182, 20);
		contentPane.add(listProduct);
		
		JLabel lblTheoricalLength = new JLabel("Theorical length");
		lblTheoricalLength.setBounds(26, 109, 86, 20);
		contentPane.add(lblTheoricalLength);
		
		textFieldTheoricalLen = new JTextField();
		textFieldTheoricalLen.setBounds(123, 109, 182, 20);
		contentPane.add(textFieldTheoricalLen);
	}

}
