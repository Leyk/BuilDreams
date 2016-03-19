package UIPackage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

import TabPatterns.*;

public class ViewOffers extends JFrame {
	private JTable tableau;
	private JButton order = new JButton("Order Items");
	private JButton home = new JButton("Home");
	private ModeleDonneesTab model;

	  public ViewOffers(){
		  this.setLocationRelativeTo(null);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setBounds(100, 100, 488, 258);
		  this.setTitle("BuilDreams : My Basket");
		  
		  Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
			      {"56465", "19/03/2016","Dupont","tata","See","Delete"},
			      {"8567654", "19/03/2016","Kane","titi","See","Delete"},
			      {"4564", "19/03/2016","Vasseur","toto","See","Delete"},
			      {"46547", "19/03/2016","Faivre","tutu","See","Delete"}
			    };
	    String  title[] = {"Id offer", "Date", "Applicant", "Seller"," "," "};
	    
	    JButton btnHome = new JButton("Home");
	    btnHome.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ViewHome fenHome = new ViewHome(true,"User"); // A REMPLACER PAR LE ROLE RECUPERE
				fenHome.setVisible(true);	
				dispose();
	    	}
	    });
		btnHome.setBounds(176, 130, 112, 23);
		
		JButton btnNewOffer = new JButton("Order");
		btnNewOffer.setBounds(176, 130, 112, 23);
		
		JLabel lblPrixTot = new JLabel();
		lblPrixTot.setBounds(32, 11, 252, 24);
		lblPrixTot.setText("Total Price (€): ");
		
		JPanel panbtn = new JPanel();
		panbtn.add(btnNewOffer);
		panbtn.add(btnHome);
		
		JPanel panPrixTot = new JPanel();
		panPrixTot.add(lblPrixTot);
	    
	    JSpinner monspin = new JSpinner();
	    this.model = new ModeleDonneesTab(data, title);
	    this.tableau = new JTable(model);
	    this.tableau.setRowHeight(20);
	    this.getContentPane().add(panPrixTot, BorderLayout.NORTH);
	    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	    this.getContentPane().add(panbtn, BorderLayout.SOUTH);
	    this.tableau.getColumn(" ").setCellRenderer(new ButtonRenderer());
	    this.tableau.getColumn("Quantity").setCellRenderer(new SpinnerRenderer());
	    this.tableau.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
	    this.tableau.getColumn("Quantity").setCellEditor(new SpinnerEditor());
	    this.tableau.setAutoCreateRowSorter(true);
	    this.setLocationRelativeTo(null);
	  }
}