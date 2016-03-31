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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;
import BusinessLogic.FacadeBasket;
import BusinessLogic.FacadeOnlineShop;

public class ViewOnlineShop extends JFrame implements ActionListener{

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;
	
	private JButton btnHome;
	
	private FacadeOnlineShop myFacade;

	public ViewOnlineShop(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.myFacade = new FacadeOnlineShop();
		
		this.myFacade.setMyPerson(myAbstractPersonIn);
		this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Online shop");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		btnHome = new JButton("Home");
		btnHome.setBounds(176, 130, 112, 23);
		
		JPanel panbtn = new JPanel();
		panbtn.add(btnHome);
		getContentPane().add(panbtn, BorderLayout.SOUTH);
		
		JLabel lblInfos = new JLabel();
		lblInfos.setBounds(32, 11, 252, 24);
		lblInfos.setText("Products available in the Online Shop ");
		
		JPanel panNorth = new JPanel();
		panNorth.add(lblInfos);
		this.getContentPane().add(panNorth, BorderLayout.NORTH);
		this.getContentPane().add(panbtn, BorderLayout.SOUTH);
		
		 Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
			      {"5641", "Product1", "Categ1", "Subcat1", 100, "20", "SellerA", "Add to card","Add to offer"},
			      {"7412", "Product2", "Categ1", "Subcat1", 200, "10", "SellerB", "Add to card","Add to offer"},
			      {"7412", "Product3", "Categ3", "Subcat2", 500, "15", "SellerC", "Add to card","Add to offer"},
			      {"8964", "Product4", "Categ5", "Subcat4", 150, "50", "SellerD", "Add to card","Add to offer"}
			    };
	    String  title[] = {"Ref", "Product name", "Category", "Subcategory","Qty available", "Price", "Seller", " ","  "};
	    
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
	    this.tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    //  this.model.resizeCol(tableau);
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
	}
	
	public void addActionListener () {
		this.btnHome.addActionListener(this);
	}
}
