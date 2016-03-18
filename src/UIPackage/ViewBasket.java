package UIPackage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class ViewBasket extends JFrame {
	private JTable tableau;
	private JButton order = new JButton("Order Items");
	private JButton home = new JButton("Home");

	  public ViewBasket(){
		  this.setLocationRelativeTo(null);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setBounds(100, 100, 488, 258);
		  this.setTitle("BuilDreams : My Basket");
		  
		  Object[][] data = {
			      {"Wood", 100, 200,"Dupont","Delete"},
			      {"Plastic", 100, 50,"Kane","Delete"},
			      {"Hammer", 100, 45,"Vasseur","Delete"},
			      {"Screw", 100, 19,"Faivre","Delete"}
			    };
	    String  title[] = {"Product name", "Quantity", "Price", "Seller"," "};
	    
	    JButton btnHome = new JButton("Home");
	    btnHome.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		ViewHome fenHome = new ViewHome(true,"User"); // A REMPLACER PAR LE ROLE RECUPERE
				fenHome.setVisible(true);	
				dispose();
	    	}
	    });
		btnHome.setBounds(176, 130, 112, 23);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setBounds(176, 130, 112, 23);
		
		JLabel lblPrixTot = new JLabel();
		lblPrixTot.setBounds(32, 11, 252, 24);
		lblPrixTot.setText("Total Price (€): ");
		
		JPanel panbtn = new JPanel();
		panbtn.add(btnOrder);
		panbtn.add(btnHome);
		
		JPanel panPrixTot = new JPanel();
		panPrixTot.add(lblPrixTot);
	    
	    JSpinner monspin = new JSpinner();
	    ModeleDonnees model = new ModeleDonnees(data, title);
	    this.tableau = new JTable(model);
	    this.tableau.setRowHeight(20);
	    this.getContentPane().add(panPrixTot, BorderLayout.NORTH);
	    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	    this.getContentPane().add(panbtn, BorderLayout.SOUTH);
	    this.tableau.getColumn(" ").setCellRenderer(new ButtonRenderer());
	    this.tableau.getColumn("Quantity").setCellRenderer(new SpinnerRenderer());
	    this.tableau.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
	    this.tableau.getColumn("Quantity").setCellEditor(new SpinnerEditor());
	    this.tableau.setAutoCreateRowSorter(true);
	    
	    this.setLocationRelativeTo(null);

	  }
	  
	  public class ButtonRenderer extends JButton implements TableCellRenderer{

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
	      //On écrit dans le bouton ce que contient la cellule
	      setText((value != null) ? value.toString() : ""); // si valeur non nulle on la caste en string sinon on met ""
	      //On retourne notre bouton
	      return this;
	    }
	    
	  }
	    
	    public class SpinnerRenderer extends JSpinner implements TableCellRenderer{

		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
		      //On écrit dans le bouton ce que contient la cellule
			   setValue((value != null) ? value : 0); 
		      //On retourne notre bouton
		      return this;
		    }    
	  }
	    
	    public class ButtonEditor extends DefaultCellEditor {

	      protected JButton button;
	      private boolean   isPushed;
	      private ButtonListener bListener = new ButtonListener();
	       
	      //Constructeur avec une CheckBox
	      public ButtonEditor(JCheckBox checkBox) {
	        //Par défaut, ce type d'objet travaille avec un JCheckBox
	        super(checkBox);
	        //On crée à nouveau un bouton
	        button = new JButton();
	        button.setOpaque(true);
	        //On lui attribue un listener
	        button.addActionListener(bListener);
	      }

	      public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) { 
	        //On précise le numéro de ligne et de colonne à notre listener
	        bListener.setRow(row);
	        bListener.setColumn(column);
	        bListener.setTable(table);	          
	        //On réaffecte le libellé au bouton
	        button.setText( (value == null) ? "" : value.toString() );
	        return button;
	      }
	       
	      //Notre listener pour le bouton
	      class ButtonListener implements ActionListener{        
	        private int column, row;
	        private JTable table;
	            
	        public void setColumn(int col){this.column = col;}
	        public void setRow(int row){this.row = row;}
	        public void setTable(JTable table){this.table = table;}

	            
	        public void actionPerformed(ActionEvent event) {
	          System.out.println("test " + ((JButton)event.getSource()).getText());
	        }
	      }     
	    }
	    
	    class ModeleDonnees extends AbstractTableModel{
	    	private Object[][] data;
	    	private String[] title;
	    	
	    	public ModeleDonnees(Object[][] data, String[] title){
	    		this.data = data;
	    		this.title = title;
	    	}
	    	
	    	public int getColumnCount(){
	    		return this.title.length;
	    	}
	    	
	    	public int getRowCount(){
	    		return this.data.length;
	    	}
	    	
	    	public Object getValueAt(int row, int col){
	    		return this.data[row][col];
	    	}
	    	
	    	// pour afficher les titres des colonnes
	    	public String getColumnName(int col){
	    		return this.title[col];
	    	}
	    	
	    	// retourne la classe de la donnée de la colonne
	    	public Class getColumnClass(int col){
	    		return this.data[0][col].getClass();
	    	}
	    	
	    	// permet l'édition d'une cellule
	    	public boolean isCellEditable(int row, int col){
	    		if(getColumnName(col)=="Quantity"){    // sale => à changer
	    			return true;
	    		}
	    		else if(getColumnName(col)==" "){
	    			return true;
	    		}
	    		return false;
	    	}
	    }
	    
	 class SpinnerEditor extends DefaultCellEditor {
		 
		protected JSpinner spinner ;
		private JSpinner.DefaultEditor editor;
				
		 public SpinnerEditor() {
			 	super(new JTextField());		   
			    SpinnerModel modelSpin = new SpinnerNumberModel(0, 0, 1000, 1);
			 	spinner = new JSpinner(modelSpin);
			 	spinner.addChangeListener(new ChangeListener(){
			 		int nb = 0;
			 		 @Override
			         public void stateChanged(ChangeEvent e) {
			 			 nb++;
			 			 if((Integer)(spinner.getValue()) > 1000){  //voir si utile de conserver en max
			 				 spinner.setValue(1000);
			 			 }
			         }
			 	});
			 	editor = ((JSpinner.DefaultEditor)spinner.getEditor());
			 	
			 	// le paragraphe suivant permet de ne prendre en compte que la saisie de numériques dans le JSpinner 
			 	((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().addKeyListener(new KeyAdapter() {
			 		private boolean numpad;
			 		 
			 	   @Override
			 	   public void keyPressed(KeyEvent e) {
			 	      numpad = e.getKeyLocation()==KeyEvent.KEY_LOCATION_NUMPAD;
			 	   }
			 	 
			 	   @Override
			 	   public void keyTyped(KeyEvent e) {		 	 
			 	      char c = e.getKeyChar();	
			 	       boolean accept=false;
			 	       if ( numpad ) { // on accepte que les frappes sur le pavé numérique
			 	           if ( ((c >= '0') && (c <= '9')) || c=='.' ) { // on accepte que les chiffres et le .
			 	        		  accept = true;
			 	           }
			 	       } 
			 	       else if ( (c == KeyEvent.VK_BACK_SPACE ) || (c == KeyEvent.VK_DELETE) ) { // on accepte le backspace et le delete (suppr)
			 	           accept = true;
			 	       }		 	 
			 	       if( !accept ) { // si la touche n'est pas acceptée
			 	           Toolkit.getDefaultToolkit().beep(); // on fait un bip
			 	           e.consume(); // on brûle l'évenement, qui ne sera donc pas exploité
			 	       }		 	 
			 	   }		 	 
			 	});
			  }

			  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
			      int row, int column) {
				spinner.setValue( (value == null) ? 0 : value );
			    return spinner;
			  }

			 public Object getCellEditorValue() {
			    return spinner.getValue();
			  }
	 }
}