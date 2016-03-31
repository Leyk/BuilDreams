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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;
import BusinessLogic.FacadeBasket;
import BusinessLogic.FacadeShopOrder;

public class ViewOrder extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;
	
	private FacadeShopOrder myFacade;
	
	private JButton btnCancel;
	private JButton btnMngOrder;

	public ViewOrder(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.myFacade = new FacadeShopOrder();
		
		this.myFacade.setMyPerson(myAbstractPersonIn);
		this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("BuilDreams : See Order");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(176, 130, 112, 23);
		
		btnMngOrder = new JButton("Mng Order");
		if(true){  
			btnMngOrder.setText("Valide");   // A PARTIR DE L'ETAT DE LA COMMANDE : si d�j� valid�e le bouton doit s'appeler "Sent"
		} else {                              // Si c'est un USER qui consulte ses orders il n'y a pas de boutons pour valider..
			btnMngOrder.setText("Sent"); 
		}
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
	    
	    this.addActionListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Cancel".equals(e.getActionCommand())){
			ViewManageOrder fenMngOrder= new ViewManageOrder(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray()); // A REMPLACER PAR LE ROLE RECUPERE
    		fenMngOrder.setVisible(true);	
			dispose();
		}
		else if ("Mng Order".equals(e.getActionCommand())){
			ViewManageOrder fenMngOrder = new ViewManageOrder(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray()); 
			JOptionPane.showMessageDialog(null, "Order validation successful",
		   		     "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			fenMngOrder.setVisible(true);	
			dispose();
		}
	}
	
	public void addActionListener () {
		this.btnCancel.addActionListener(this);
		this.btnMngOrder.addActionListener(this);
	}

}
