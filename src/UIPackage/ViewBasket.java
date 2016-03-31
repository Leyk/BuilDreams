package UIPackage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;
import BusinessLogic.FacadeBasket;

public class ViewBasket extends JFrame implements ActionListener{
	private JTable tableau;
	private ModeleDonneesTab model;
	
	private JButton btnHome;
	private JButton btnOrder;
	
	private FacadeBasket myFacade;

	  public ViewBasket(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn){
		  this.myFacade = new FacadeBasket();
		  
		  this.myFacade.setMyPerson(myAbstractPersonIn);
		  this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
		  
		  this.setLocationRelativeTo(null);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setBounds(100, 100, 488, 258);
		  this.setTitle("BuilDreams : My Basket");
		  
		  Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
			      {"Wood", 100, 200,"Dupont","Delete"},
			      {"Plastic", 100, 50,"Kane","Delete"},
			      {"Hammer", 100, 45,"Vasseur","Delete"},
			      {"Screw", 100, 19,"Faivre","Delete"}
			    };
	    String  title[] = {"Product name", "Chosen Quantity", "Price", "Seller"," "};
	    
	    btnHome = new JButton("Home");
		btnHome.setBounds(176, 130, 112, 23);
		
		btnOrder = new JButton("Order");
		btnOrder.setBounds(176, 130, 112, 23);
		
		JLabel lblPrixTot = new JLabel();
		lblPrixTot.setBounds(32, 11, 252, 24);
		lblPrixTot.setText("Total Price (�): ");
		
		JPanel panbtn = new JPanel();
		panbtn.add(btnOrder);
		panbtn.add(btnHome);
		
		JPanel panPrixTot = new JPanel();
		panPrixTot.add(lblPrixTot);
	    
	    JSpinner monspin = new JSpinner();
	    this.model = new ModeleDonneesTab(data, title);
	    this.tableau = new JTable(model);
	    this.model.addTab(tableau);
	    this.tableau.setRowHeight(20);
	    this.getContentPane().add(panPrixTot, BorderLayout.NORTH);
	    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	    this.getContentPane().add(panbtn, BorderLayout.SOUTH);
	    this.tableau.getColumn(" ").setCellRenderer(new ButtonRenderer());
	    this.tableau.getColumn("Chosen Quantity").setCellRenderer(new SpinnerRenderer());
	    this.tableau.getColumn(" ").setCellEditor(new ButtonEditor(this, new JCheckBox(), this.myFacade.getMyPerson(), this.myFacade.getMyAbstractRoleArray()));
	    this.tableau.getColumn("Chosen Quantity").setCellEditor(new SpinnerEditor());
	    this.tableau.setAutoCreateRowSorter(true);
	    this.setLocationRelativeTo(null);
	    
	    this.addActionListener();
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Home".equals(e.getActionCommand())){
			ViewHome fenHome = new ViewHome(this.myFacade.getMyPerson(), this.myFacade.getMyAbstractRoleArray());
			fenHome.setVisible(true);	
			this.dispose();
		}
		else if ("Order".equals(e.getActionCommand())){
			ViewPayment fenPayment = new ViewPayment(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray());
			fenPayment.setVisible(true);
			dispose();
		}
	}
	
	private void addActionListener (){
		this.btnHome.addActionListener(this);
		this.btnOrder.addActionListener(this);
	}
	
	  
	  
}