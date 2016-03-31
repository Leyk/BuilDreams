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
import BusinessLogic.FacadeBasket;
import BusinessLogic.FacadeGeneralManager;

public class ViewManageGenProject extends JFrame implements ActionListener{

	private JPanel contentPane;
	private ModeleDonneesTab model;
	private JTable tableau;
	private Object[][] data;
	
	private JButton btnHome;
	private JButton btnCreateGeneralProject;
	
	private FacadeGeneralManager myFacade;

	public ViewManageGenProject(AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.myFacade = new FacadeGeneralManager();
		
		this.myFacade.setMyPerson(myAbstractPersonIn);
		this.myFacade.setMyAbstractRoleArray(myAbstractArrayListRoleIn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage general projects");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		btnHome = new JButton("Home");
		btnHome.setBounds(176, 130, 112, 23);
			
			btnCreateGeneralProject = new JButton("Create general project");
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
					
			// Retrieve the content of the all the general projects in the shop
			 ArrayList<ArrayList<String>> allProject = myFacade.loadAllGeneralProject();
			 data = new Object[allProject.size()][5];
				 for (int i=0;i<allProject.size();i++){
					 data[i][0] = allProject.get(i).get(0); 
					 data[i][1] = allProject.get(i).get(1); 
					 data[i][2] = allProject.get(i).get(2); 
					 data[i][3] = "Update";
					 data[i][4] = "Delete";
				 }                           

		    String  title[] = {"ID Project", "Project name", "Category", " ", "  "};
		    
		    this.model = new ModeleDonneesTab(data, title);
		    this.tableau = new JTable(model);
		    this.model.addTab(tableau);
		    this.tableau.setRowHeight(20);
		    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		    this.tableau.getColumn(" ").setCellRenderer(new ButtonRenderer());
		    this.tableau.getColumn(" ").setCellEditor(new ButtonEditor(this, new JCheckBox(), this.myFacade.getMyPerson(), this.myFacade.getMyAbstractRoleArray()));
		    this.tableau.getColumn("  ").setCellRenderer(new ButtonRenderer());
		    this.tableau.getColumn("  ").setCellEditor(new ButtonEditor(this, new JCheckBox(), this.myFacade.getMyPerson(), this.myFacade.getMyAbstractRoleArray()));
		    this.tableau.setAutoCreateRowSorter(true);
		    
		    this.addActionListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Home".equals(e.getActionCommand())){
			ViewHome fenHome = new ViewHome(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray()); 
			fenHome.setVisible(true);	
			dispose();
		}
		else if ("Create general project".equals(e.getActionCommand())){
			ViewGenProject fenGenProj = new ViewGenProject(this.myFacade.getMyPerson(),this.myFacade.getMyAbstractRoleArray()); 
			fenGenProj.setVisible(true);	
			dispose();
		}
	}
	
	public void addActionListener () {
		this.btnHome.addActionListener(this);
		this.btnCreateGeneralProject.addActionListener(this);
	}

}
