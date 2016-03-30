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
import TabPatterns.ButtonEditor;
import TabPatterns.ButtonRenderer;
import TabPatterns.ModeleDonneesTab;

public class ViewManagePersoProject extends JFrame {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;
	private AbstractPerson myPerson;
	private ArrayList<AbstractRole> myAbstractRoleArray;

	public ViewManagePersoProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage my projects");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		 JButton btnHome = new JButton("Home");
		    btnHome.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		ViewHome fenHome = new ViewHome(true,"User"); // A REMPLACER PAR LE ROLE RECUPERE
					fenHome.setVisible(true);	
					dispose();
		    	}
		    });
			btnHome.setBounds(176, 130, 112, 23);
			
			JButton btnCreatePersoProject = new JButton("Create personnal project");
			btnCreatePersoProject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewPersoProject fenPersoProject = new ViewPersoProject(); 
					fenPersoProject.setVisible(true);	
					dispose();
				}
			});
			btnCreatePersoProject.setBounds(22, 31, 225, 23);

			JPanel panbtn = new JPanel();
			panbtn.add(btnCreatePersoProject);
			panbtn.add(btnHome);
			getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			JLabel lblInfos = new JLabel();
			lblInfos.setBounds(32, 11, 252, 24);
			lblInfos.setText("Nb of projects : ");
			
			JPanel panNorth = new JPanel();
			panNorth.add(lblInfos);
			this.getContentPane().add(panNorth, BorderLayout.NORTH);
			this.getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			 Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
				      {"Project1", "20/03/2016", "20j", "in progress", "Update","Delete"},
				      {"Project2", "02/03/2016", "20j", "completed", "Update","Delete"},
				      {"Project3", "10/03/2016", "20j", "in progress", "Update","Delete"},
				      {"Project4", "19/03/2016", "20j", "in progress", "Update","Delete"},
				    };
		    String  title[] = {"Project name", "Begin date", "Length","State", " ","  "};
		    
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
