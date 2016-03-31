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
import BusinessLogic.FacadeProduct;
import BusinessLogic.FacadeProductSeller;

public class ViewManageShop extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;
	private Object[][] data;
	
	private FacadeProductSeller myFacade;
	private FacadeProduct myFacadeProduct;
	private Boolean isSeller;
	
	private JButton btnHome;
	private JButton btnCreateProd;

	public ViewManageShop(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		if(myAbstractArrayListRoleIn.get(0).getWording().equals("admin")){
			this.myFacadeProduct = new FacadeProduct();
			this.myFacadeProduct.setMyPerson(myAbstractPersonIn);
			this.myFacadeProduct.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
			this.isSeller = false;
		}
		else if(myAbstractArrayListRoleIn.get(0).getWording().equals("seller")){
			this.myFacade = new FacadeProductSeller();
			this.myFacade.setMyPerson(myAbstractPersonIn);
			this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
			this.isSeller = true;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage shop");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		btnHome = new JButton("Home");
		btnHome.setBounds(176, 130, 112, 23);
			
		btnCreateProd = new JButton("New product");
		btnCreateProd.setBounds(176, 130, 112, 23);
		
		if(myAbstractArrayListRoleIn.get(0).getWording().equals("admin")){
			this.myFacadeProduct = new FacadeProduct();
			this.myFacadeProduct.setMyPerson(myAbstractPersonIn);
			this.myFacadeProduct.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
			this.isSeller = false;
			this.btnCreateProd.setVisible(false);
		}
		else if(myAbstractArrayListRoleIn.get(0).getWording().equals("seller")){
			this.myFacade = new FacadeProductSeller();
			this.myFacade.setMyPerson(myAbstractPersonIn);
			this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
			this.isSeller = true;
		}
		
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
		
		// Retrieve the content of the all the products in the shop
		if(this.isSeller){
			ArrayList<ArrayList<String>> allProducts = myFacade.loadAllProductSeller();
			 data = new Object[allProducts.size()][8];
				 for (int i=0;i<allProducts.size();i++){
					 data[i][0] = allProducts.get(i).get(0);  
					 data[i][1] = allProducts.get(i).get(1); 
					 data[i][2] = allProducts.get(i).get(2); 
					 data[i][3] = allProducts.get(i).get(3);
					 data[i][4] = Integer.parseInt(allProducts.get(i).get(4));
					 data[i][5] = Integer.parseInt(allProducts.get(i).get(5));
					 data[i][6] = "Update";
					 data[i][7] = "Delete";
				 }                           
		} else {
			ArrayList<ArrayList<String>> allProducts = myFacadeProduct.loadAllProduct();
			 data = new Object[allProducts.size()][8];
				 for (int i=0;i<allProducts.size();i++){
					 data[i][0] = allProducts.get(i).get(0);  
					 data[i][1] = allProducts.get(i).get(1); 
					 data[i][2] = allProducts.get(i).get(2); 
					 data[i][3] = allProducts.get(i).get(3);
					 data[i][4] = Integer.parseInt(allProducts.get(i).get(4));
					 data[i][5] = Integer.parseInt(allProducts.get(i).get(5));
					 data[i][6] = "Update";
					 data[i][7] = "Delete";
				 }                         
		}
		 
	    String  title[] = {"Ref", "Product name", "Category", "Seller","Quantity", "Price", " ","  "};
	    
	    this.model = new ModeleDonneesTab(data, title);
	    this.tableau = new JTable(model);
	    this.model.addTab(tableau);
	    this.tableau.setRowHeight(20);
	    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	    this.tableau.getColumn(" ").setCellRenderer(new ButtonRenderer());
	    this.tableau.getColumn("  ").setCellRenderer(new ButtonRenderer());
	    
	    if(myAbstractArrayListRoleIn.get(0).getWording().equals("seller")){
	    this.tableau.getColumn(" ").setCellEditor(new ButtonEditor(this, new JCheckBox(), this.myFacade.getMyPerson(), this.myFacade.getMyAbstractRoleArray()));
	    this.tableau.getColumn("  ").setCellEditor(new ButtonEditor(this, new JCheckBox(), this.myFacade.getMyPerson(), this.myFacade.getMyAbstractRoleArray()));
	    }
		else if(myAbstractArrayListRoleIn.get(0).getWording().equals("admin")){
			this.tableau.getColumn(" ").setCellEditor(new ButtonEditor(this, new JCheckBox(), this.myFacadeProduct.getMyPerson(), this.myFacadeProduct.getMyAbstractRoleArray()));
		    this.tableau.getColumn("  ").setCellEditor(new ButtonEditor(this, new JCheckBox(), this.myFacadeProduct.getMyPerson(), this.myFacadeProduct.getMyAbstractRoleArray()));
		}
	    this.tableau.setAutoCreateRowSorter(true);
	    this.tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    this.addActionListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ViewHome fenHome;
		ViewProduct fenProd;
		
		if ("Home".equals(e.getActionCommand())){
			if(this.isSeller){
				fenHome = new ViewHome(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray()); 
			} else {
				fenHome = new ViewHome(this.myFacadeProduct.getMyPerson(),this.myFacadeProduct.getMyAbstractRoleArray()); 
			}
			fenHome.setVisible(true);	
			dispose();
		}
		else if ("New product".equals(e.getActionCommand())){
			if(this.isSeller){
				fenProd = new ViewProduct(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray());
			} else {
				fenProd = new ViewProduct(this.myFacadeProduct.getMyPerson(),this.myFacadeProduct.getMyAbstractRoleArray());
			}
			fenProd.setVisible(true);	
			dispose();
		}
	}
	
	public void addActionListener () {
		this.btnHome.addActionListener(this);
		this.btnCreateProd.addActionListener(this);
	}
}
