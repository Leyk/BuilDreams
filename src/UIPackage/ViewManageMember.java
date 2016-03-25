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

public class ViewManageMember extends JFrame {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;

	public ViewManageMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage members");
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
			
			JButton btnCreateMember = new JButton("New member");
			btnCreateMember.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewRegistration fenRegistration = new ViewRegistration(); 
					fenRegistration.setVisible(true);	
					dispose();
					
				}
			});
			btnCreateMember.setBounds(176, 130, 112, 23);
			
			JPanel panbtn = new JPanel();
			panbtn.add(btnCreateMember);
			panbtn.add(btnHome);
			getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			JLabel lblInfos = new JLabel();
			lblInfos.setBounds(32, 11, 252, 24);
			lblInfos.setText("Nb of members : ");
			
			JPanel panNorth = new JPanel();
			panNorth.add(lblInfos);
			this.getContentPane().add(panNorth, BorderLayout.NORTH);
			this.getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			 Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
				      {"654532", "Faivre", "Loic", "loic.faivre@gmail.com","0677777777","Admin","Delete"},
				      {"654533", "Kane", "Djeneba", "djeneba.kane@gmail.com","0677777777","Admin","Delete"},
				      {"654534", "Vasseur", "Alexandre", "alex.vasseur@gmail.com","0677777777","Admin","Delete"},
				      {"654535", "Savornin", "Simon", "sim.savornin@gmail.com","0677777777","Admin","Delete"}
				    };
		    String  title[] = {"ID", "Name", "Surname", "Email", "Phone", "Role", " "};
		    
		    this.model = new ModeleDonneesTab(data, title);
		    this.tableau = new JTable(model);
		    this.model.addTab(tableau);
		    this.tableau.setRowHeight(20);
		    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		    this.tableau.getColumn(" ").setCellRenderer(new ButtonRenderer());
		    this.tableau.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
		    this.tableau.setAutoCreateRowSorter(true);
		    this.tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	

}
