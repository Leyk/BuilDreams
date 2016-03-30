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

public class ViewManageGenProject extends JFrame {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;
	private AbstractPerson myPerson;
	private ArrayList<AbstractRole> myAbstractRoleArray;

	public ViewManageGenProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage general projects");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		 JButton btnHome = new JButton("Home");
		    btnHome.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		ViewHome fenHome = new ViewHome(true,"Administrator"); // A REMPLACER PAR LE ROLE RECUPERE
					fenHome.setVisible(true);	
					dispose();
		    	}
		    });
			btnHome.setBounds(176, 130, 112, 23);
			
			JButton btnCreateGeneralProject = new JButton("Create general project");
			btnCreateGeneralProject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewGenProject fenGenProj = new ViewGenProject(); 
					fenGenProj.setVisible(true);	
					dispose();
				}
			});
			btnCreateGeneralProject.setBounds(22, 31, 225, 23);
			
			JPanel panbtn = new JPanel();
			panbtn.add(btnCreateGeneralProject);
			panbtn.add(btnHome);
			getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			JLabel lblInfos = new JLabel();
			lblInfos.setBounds(32, 11, 252, 24);
			lblInfos.setText("Nb of general projects : ");
			
			JPanel panNorth = new JPanel();
			panNorth.add(lblInfos);
			this.getContentPane().add(panNorth, BorderLayout.NORTH);
			this.getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			 Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
				      {"Project1", "Cat1", "Update","Delete"},
				      {"Project2", "Cat2", "Update","Delete"},
				      {"Project3", "Cat3", "Update","Delete"},
				      {"Project4", "Cat4", "Update","Delete"}
				    };
		    String  title[] = {"Project name", "Category", " ", "  "};
		    
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
	}
	

}
