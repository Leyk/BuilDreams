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

public class ViewManageOffer extends JFrame {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;

	public ViewManageOffer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setTitle("BuilDreams : My offers");
		
		JButton btnHome = new JButton("Home");
	    btnHome.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ViewHome fenHome = new ViewHome(true,"Seller"); // A REMPLACER PAR LE ROLE RECUPERE
				fenHome.setVisible(true);	
				dispose();
	    	}
	    });
		btnHome.setBounds(176, 130, 112, 23);	
		
		JPanel panbtn = new JPanel();
		panbtn.add(btnHome);
		getContentPane().add(panbtn, BorderLayout.SOUTH);
		
		JLabel lblInfos = new JLabel();
		lblInfos.setBounds(32, 11, 252, 24);
		lblInfos.setText("Nb of offers : ");
		
		JPanel panNorth = new JPanel();
		panNorth.add(lblInfos);
		this.getContentPane().add(panNorth, BorderLayout.NORTH);
		this.getContentPane().add(panbtn, BorderLayout.SOUTH);
		
		 Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
			      {"546547","Vasseur", "20/03/2016", 10, "!","See Offer"},
			      {"78654", "Faivre", "20/03/2016", 15, "!","See Offer"},
			      {"456876","Duchemole", "19/03/2016", 25, "Answered","See Offer"},
			      {"968745","Toto", "18/03/2016", 12, "Answered","See Offer"},
			    };
	    String  title[] = {"ID","Client","Date","Nb of items","Status"," "};  // Changer si c'est un user qui regarde ses orders : mettre "Seller" au lieu de "Client"
	    
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
