package UIPackage;

import java.awt.BorderLayout;
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
import BusinessLogic.FacadeOnlineShop;
import BusinessLogic.FacadeProduct;

public class ViewOnlineShop extends JFrame implements ActionListener{

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;
	private Object[][] data;
	
	private JButton btnHome;
	
	private FacadeProduct myFacadeProduct;

	public ViewOnlineShop(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.myFacadeProduct = new FacadeProduct();
		
		this.myFacadeProduct.setMyPerson(myAbstractPersonIn);
		this.myFacadeProduct.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Online shop");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		btnHome = new JButton("Home");
		btnHome.setBounds(176, 130, 112, 23);
		
		JPanel panbtn = new JPanel();
		panbtn.add(btnHome);
		getContentPane().add(panbtn, BorderLayout.SOUTH);
		
		JLabel lblInfos = new JLabel();
		lblInfos.setBounds(32, 11, 252, 24);
		lblInfos.setText("Products available in the Online Shop ");
		
		JPanel panNorth = new JPanel();
		panNorth.add(lblInfos);
		this.getContentPane().add(panNorth, BorderLayout.NORTH);
		this.getContentPane().add(panbtn, BorderLayout.SOUTH);
		
		ArrayList<ArrayList<String>> allProducts = myFacadeProduct.loadAllProduct();
		 data = new Object[allProducts.size()][8];
			 for (int i=0;i<allProducts.size();i++){
				 data[i][0] = allProducts.get(i).get(0);  
				 data[i][1] = allProducts.get(i).get(1); 
				 data[i][2] = allProducts.get(i).get(2); 
				 data[i][3] = allProducts.get(i).get(3);
				 data[i][4] = Integer.parseInt(allProducts.get(i).get(4));
				 data[i][5] = Integer.parseInt(allProducts.get(i).get(5));
				 data[i][6] = "Add to card";
			 }             
		
	    String  title[] = {"Ref", "Product name", "Category", "Seller","Quantity", "Price (€)", " "};
	    
	    this.model = new ModeleDonneesTab(data, title);
	    this.tableau = new JTable(model);
	    this.model.addTab(tableau);
	    this.tableau.setRowHeight(20);
	    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	    this.tableau.getColumn(" ").setCellRenderer(new ButtonRenderer());
	    this.tableau.getColumn(" ").setCellEditor(new ButtonEditor(this, new JCheckBox(), this.myFacadeProduct.getMyPerson(), this.myFacadeProduct.getMyAbstractRoleArray()));
	    this.tableau.setAutoCreateRowSorter(true);
	    this.tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    //  this.model.resizeCol(tableau);
	    this.addActionListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Home".equals(e.getActionCommand())){
			ViewHome fenHome = new ViewHome(this.myFacadeProduct.getMyPerson(),this.myFacadeProduct.getMyAbstractRoleArray()); // A REMPLACER PAR LE ROLE RECUPERE
			fenHome.setVisible(true);	
			dispose();
		}
	}
	
	public void addActionListener () {
		this.btnHome.addActionListener(this);
	}
}
