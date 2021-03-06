package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;
import BusinessLogic.FacadeBasket;
import BusinessLogic.FacadeGeneralManager;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewGenTask extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldTheoricalLen;
	
	private FacadeGeneralManager myFacade;
	
	private JButton btnCancel;

	public ViewGenTask (AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.myFacade = new FacadeGeneralManager();
		
		this.myFacade.setMyPerson(myAbstractPersonIn);
		this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
		
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
		
		btnCancel = new JButton("Cancel");
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
		
		this.addActionListener();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Cancel".equals(e.getActionCommand())){
			ViewManageGenTask fenMngGenTask = new ViewManageGenTask(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray());
			fenMngGenTask.setVisible(true);	
			dispose();
		}
	}
	
	public void addActionListener () {
		this.btnCancel.addActionListener(this);
	}
}
