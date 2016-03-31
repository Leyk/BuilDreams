package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

public class ViewGenProject extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	
	private FacadeGeneralManager myFacade;
	
	private JButton btnCancel;
	
	public ViewGenProject(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.myFacade = new FacadeGeneralManager();
		
		this.myFacade.setMyPerson(myAbstractPersonIn);
		this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
		
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
		
		btnCancel = new JButton("Cancel");
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
		
		this.addActionListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Cancel".equals(e.getActionCommand())){
			ViewManageGenProject fenMngGenProj = new ViewManageGenProject(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray());
			fenMngGenProj.setVisible(true);	
			dispose();
		}
	}
	
	public void addActionListener () {
		this.btnCancel.addActionListener(this);
	}

}
