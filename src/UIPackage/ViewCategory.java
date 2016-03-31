package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;
import BusinessLogic.FacadeBasket;
import BusinessLogic.FacadeCategory;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ViewCategory extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldNameCat;

	private FacadeCategory myFacade;
	
	private JButton btnCancel;
	
	public ViewCategory(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.myFacade = new FacadeCategory();
		
		this.myFacade.setMyPerson(myAbstractPersonIn);
		this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 203);
		setTitle("BuilDreams : Create a category");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(34, 40, 64, 14);
		contentPane.add(lblName);
		
		JLabel lblLinkTo = new JLabel("Link to");
		lblLinkTo.setBounds(34, 86, 64, 14);
		contentPane.add(lblLinkTo);
		
		JList listLinkCateg = new JList();
		listLinkCateg.setBounds(123, 85, 168, 20);
		contentPane.add(listLinkCateg);
		
		textFieldNameCat = new JTextField();
		textFieldNameCat.setBounds(123, 36, 168, 20);
		contentPane.add(textFieldNameCat);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(34, 130, 89, 23);
		contentPane.add(btnCreate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(172, 130, 89, 23);
		contentPane.add(btnCancel);
		
		this.addActionListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Cancel".equals(e.getActionCommand())){
			ViewManageCategory fenMngCategory = new ViewManageCategory(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray()); 
			fenMngCategory.setVisible(true);	
			dispose();
		}
	}
	
	public void addActionListener () {
		this.btnCancel.addActionListener(this);
	}

}
