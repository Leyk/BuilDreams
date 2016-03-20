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

public class ViewOffer extends JFrame {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;

	public ViewOffer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("BuilDreams : See Offer");
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
			if(true){   // Vérifier que le role est SELLER
		    btnMngOrder.setText("Valide prices");   // A PARTIR DE L'ETAT DE LA COMMANDE : si déjà validée le bouton doit s'appeler "Sent"
			btnMngOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewManageOrder fenMngOrder = new ViewManageOrder (); 
					JOptionPane.showMessageDialog(null, "Offer validation successful",
				   		     "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
					fenMngOrder.setVisible(true);	
					dispose();				
				}
			});
			}
			else{  // Si le role est USER
				btnMngOrder.setText("Order");
				btnMngOrder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ViewPayment fenPayment = new ViewPayment();
						fenPayment.setVisible(true);
						dispose();
					}
				});			
			}
			btnMngOrder.setBounds(176, 130, 112, 23);
			
			JPanel panbtn = new JPanel();
			panbtn.add(btnMngOrder);
			panbtn.add(btnCancel);
			
			JLabel lblInfos = new JLabel();
			lblInfos.setBounds(32, 11, 252, 24);
			lblInfos.setText("#Name#'Offer : #ref# Total price : ");  // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
			
			JPanel panNorth = new JPanel();
			panNorth.add(lblInfos);
			this.getContentPane().add(panNorth, BorderLayout.NORTH);
			this.getContentPane().add(panbtn, BorderLayout.SOUTH);
			
			Object[][] data = {                              // A COMPLETER AVEC LES DONNEES RECUPEREES DE LA REQUETE
				      {"Product1", 10, 0},
				      {"Product2", 10, 0},
				      {"Product3", 10, 0},
				      {"Product4", 10, 0},
				    };
		    String  title[] = {"Product name", "Quantity", "Chosen Price"};  // A modifier : si c'est user qui consulte : remplacer "Choosen price" par "proposed price"
		    
		    this.model = new ModeleDonneesTab(data, title);
		    this.tableau = new JTable(model);
		    this.tableau.setRowHeight(20);
		    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		    this.tableau.setAutoCreateRowSorter(true);
	}

}
