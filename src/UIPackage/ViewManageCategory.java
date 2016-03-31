package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;
import BusinessLogic.FacadeBasket;
import BusinessLogic.FacadeCategory;

public class ViewManageCategory extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;
	
	private JButton btnHome;
	private JButton btnCreateCategory;
	
	private FacadeCategory myFacade;

	public ViewManageCategory(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.myFacade = new FacadeCategory();
		
		this.myFacade.setMyPerson(myAbstractPersonIn);
		this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage categories");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		btnHome = new JButton("Home");
		btnHome.setBounds(176, 130, 112, 23);
		
		btnCreateCategory = new JButton("New category");
		btnCreateCategory.setBounds(176, 130, 112, 23);
		
		JPanel panbtn = new JPanel();
		panbtn.add(btnCreateCategory);
		panbtn.add(btnHome);
		
		JLabel lblInfos = new JLabel();
		lblInfos.setBounds(32, 11, 252, 24);
		lblInfos.setText("Nb of categories : ");
		
		JPanel panNorth = new JPanel();
		panNorth.add(lblInfos);
		this.getContentPane().add(panNorth, BorderLayout.NORTH);
		this.getContentPane().add(panbtn, BorderLayout.SOUTH);
		
		 Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
			      {"Categ1", "Subcat1", "Update","Delete"},
			      {"Categ2", "Subcat2", "Update","Delete"},
			      {"Categ3", "Subcat3", "Update","Delete"},
			      {"Categ4", "Subcat4", "Update","Delete"}
			    };
	    String  title[] = {"Category name", "Sub-category", " ", "  "};
	    
	    this.model = new ModeleDonneesTab(data, title);
	    this.tableau = new JTable(model);
	    this.model.addTab(tableau);
	    this.tableau.setRowHeight(20);
	    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	    this.tableau.getColumn(" ").setCellRenderer(new ButtonRenderer());
	    this.tableau.getColumn(" ").setCellEditor(new ButtonEditor(this, new JCheckBox(), this.myFacade.getMyPerson(), this.myFacade.getMyAbstractRoleArray()));
	    this.tableau.getColumn("  ").setCellRenderer(new ButtonRenderer());
	    this.tableau.getColumn("  ").setCellEditor(new ButtonEditor(this, new JCheckBox(), this.myFacade.getMyPerson(), this.myFacade.getMyAbstractRoleArray()));
	    this.tableau.setAutoCreateRowSorter(true);
	    
	    this.addActionListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Home".equals(e.getActionCommand())){
			ViewHome fenHome = new ViewHome(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray()); // A REMPLACER PAR LE ROLE RECUPERE
			fenHome.setVisible(true);	
			dispose();
		}
		else if ("New category".equals(e.getActionCommand())){
			ViewCategory fenCategory = new ViewCategory(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray()); 
			fenCategory.setVisible(true);	
			dispose();
		}
	}
	
	public void addActionListener () {
		this.btnHome.addActionListener(this);
		this.btnCreateCategory.addActionListener(this);
	}
}
