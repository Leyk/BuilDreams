package UIPackage;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;

public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private boolean   isPushed;
    private ButtonListener bListener;
    
    private AbstractPerson myAbstractPerson;
    private ArrayList<AbstractRole> myAbstractArrayListRole;
    
    private Object myFen;
     
    //Constructeur avec une CheckBox
    public ButtonEditor(Object myFenIn, JCheckBox checkBox,AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
    	//Par défaut, ce type d'objet travaille avec un JCheckBox
    	super(checkBox);
      
    	this.myFen = myFenIn;
      	this.myAbstractPerson = myAbstractPersonIn;
  		this.myAbstractArrayListRole = myAbstractArrayListRoleIn;
  		this.bListener = new ButtonListener(myFen, myAbstractPersonIn, myAbstractArrayListRoleIn);
  	
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
  
 }