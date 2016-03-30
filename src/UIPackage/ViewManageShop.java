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
import TabPatterns.ButtonEditor;
import TabPatterns.ButtonRenderer;
import TabPatterns.ModeleDonneesTab;
import TabPatterns.SpinnerEditor;
import TabPatterns.SpinnerRenderer;

public class ViewManageShop extends JFrame {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;
	private AbstractPerson myPerson;
	private ArrayList<AbstractRole> myAbstractRoleArray;

	public ViewManageShop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage shop");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		 JButton btnHome = new JButton("Home");
		    btnHome.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		ViewHome fenHome = new ViewHome(true,"Seller"); // A REMPLACER PAR LE ROLE RECUPERE
					fenHome.setVisible(true);	
					dispose();
		    	}
		    });
			btnHome.setBounds(176, 130, 112, 23);
			
			JButton btnCreateProd = new JButton("New product");
			btnCreateProd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewProduct fenProd = new ViewProduct();
					fenProd.setVisible(true);	
					dispose();
				}
			});
			btnCreateProd.setBounds(176, 130, 112, 23);
			
			JPanel panbtn = new JPanel();
			panbtn.add(btnCreateProd);
			panbtn.add(btnHome);
			getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			JLabel lblInfos = new JLabel();
			lblInfos.setBounds(32, 11, 252, 24);
			lblInfos.setText("Nb of products : ");
			
			JPanel panNorth = new JPanel();
			panNorth.add(lblInfos);
			this.getContentPane().add(panNorth, BorderLayout.NORTH);
			this.getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			 Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
				      {"5641", "Product1", "Categ1", "Subcat1", 100, "20", "Update","Delete"},
				      {"7412", "Product2", "Categ1", "Subcat1", 200, "10", "Update","Delete"},
				      {"7412", "Product3", "Categ3", "Subcat2", 500, "15", "Update","Delete"},
				      {"8964", "Product4", "Categ5", "Subcat4", 150, "50", "Update","Delete"},
				    };
		    String  title[] = {"Ref", "Product name", "Category", "Subcategory","Quantity", "Price", " ","  "};
		    
		    this.model = new ModeleDonneesTab(data, title);
		    this.tableau = new JTable(model);
		    this.model.addTab(tableau);
		    this.tableau.setRowHeight(20);
		    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		    this.tableau.getColumn(" ").setCellRenderer(new ButtonRenderer());
		    this.tableau.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
		    this.tableau.getColumn("  ").setCellRenderer(new ButtonRenderer());
		    this.tableau.getColumn("  ").setCellEditor(new ButtonEditor(new JCheckBox()));
		    this.tableau.setAutoCreateRowSorter(true);
		    this.tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
}
