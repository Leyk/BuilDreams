package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import TabPatterns.ButtonEditor;
import TabPatterns.ButtonRenderer;
import TabPatterns.ModeleDonneesTab;

public class ViewOrder extends JFrame {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;

	public ViewOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("BuilDreams : See Order");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		

		 JButton btnCancel = new JButton("Cancel");
		    btnCancel.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		ViewManageOrder fenMngOrder= new ViewManageOrder(); // A REMPLACER PAR LE ROLE RECUPERE
		    		fenMngOrder.setVisible(true);	
					dispose();
		    	}
		    });
			btnCancel.setBounds(176, 130, 112, 23);
			
			JButton btnMngOrder = new JButton("");
			if(true){  
				btnMngOrder.setText("Valide");   // A PARTIR DE L'ETAT DE LA COMMANDE : si déjà validée le bouton doit s'appeler "Sent"
			} else {                              // Si c'est un USER qui consulte ses orders il n'y a pas de boutons pour valider..
				btnMngOrder.setText("Sent"); 
			}
			btnMngOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewManageOrder fenMngOrder = new ViewManageOrder (); 
					JOptionPane.showMessageDialog(null, "Order validation successful",
				   		     "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
					fenMngOrder.setVisible(true);	
					dispose();
					
				}
			});
			btnMngOrder.setBounds(176, 130, 112, 23);
			
			JPanel panbtn = new JPanel();
			panbtn.add(btnMngOrder);
			panbtn.add(btnCancel);
			
			JLabel lblInfos = new JLabel();
			lblInfos.setBounds(32, 11, 252, 24);
			lblInfos.setText("#Name#'Order : #ref# #address# Total Price : ");  // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
			
			JPanel panNorth = new JPanel();
			panNorth.add(lblInfos);
			this.getContentPane().add(panNorth, BorderLayout.NORTH);
			this.getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			 Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
				      {"Product1", 10, 220},
				      {"Product2", 10, 150},
				      {"Product3", 10, 450},
				      {"Product4", 10, 25},
				    };
		    String  title[] = {"Product name", "Quantity", "Price"};
		    
		    this.model = new ModeleDonneesTab(data, title);
		    this.tableau = new JTable(model);
		    this.model.addTab(tableau);
		    this.tableau.setRowHeight(20);
		    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		    this.tableau.setAutoCreateRowSorter(true);
	}

}
