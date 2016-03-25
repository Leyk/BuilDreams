package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import TabPatterns.ButtonEditor;
import TabPatterns.ButtonRenderer;
import TabPatterns.ModeleDonneesTab;

public class ViewManagePersoTask extends JFrame {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;


	public ViewManagePersoTask() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage my tasks");
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
			
			JButton btnCreatePersoTask = new JButton("Create personnal task");
			btnCreatePersoTask.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewPersoTask fenPersoTask = new ViewPersoTask(); 
					fenPersoTask.setVisible(true);	
					dispose();
				}
			});
			btnCreatePersoTask.setBounds(22, 99, 225, 23);

			JPanel panbtn = new JPanel();
			panbtn.add(btnCreatePersoTask);
			panbtn.add(btnHome);
			getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			JLabel lblInfos = new JLabel();
			lblInfos.setBounds(32, 11, 252, 24);
			lblInfos.setText("Nb of tasks : ");
			
			JPanel panNorth = new JPanel();
			panNorth.add(lblInfos);
			this.getContentPane().add(panNorth, BorderLayout.NORTH);
			this.getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			 Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
				      {"Task1", "Project2", "20/03/2016", "1j", "in progress", "Update","Delete"},
				      {"Task2", "Project2", "20/03/2016", "5j", "in progress", "Update","Delete"},
				      {"Task3", "Project4", "20/03/2016", "2j", "completed", "Update","Delete"},
				      {"Task4", "Project2", "20/03/2016", "5j", "in progress", "Update","Delete"},
				    };
		    String  title[] = {"Task name", "Project", "Begin date", "Length","State", " ","  "};
		    
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
