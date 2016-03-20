package TabPatterns;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import UIPackage.ViewHome;
import UIPackage.ViewOffer;
import UIPackage.ViewOrder;

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
     
 
    class ButtonListener implements ActionListener{        
      private int column, row;
      private JTable table;
          
      public void setColumn(int col){this.column = col;}
      public void setRow(int row){this.row = row;}
      public void setTable(JTable table){this.table = table;}

          
      public void actionPerformed(ActionEvent event) {
    	  if ("See Order".equals(event.getActionCommand())){
    		  ViewOrder fenOrder = new ViewOrder(); // A REMPLACER PAR LE ROLE RECUPERE
			  fenOrder.setVisible(true);
			  System.out.println(((JButton)event.getSource()));  // Récupérer la fenetre d'où ça provient pour faire un dispose()
    	  } else if("See Offer".equals(event.getActionCommand())){
    		  ViewOffer fenOffer = new ViewOffer();
    		  fenOffer.setVisible(true);
    		  System.out.println(((JButton)event.getSource()));  // Récupérer la fenetre d'où ça provient pour faire un dispose()
    	  }
    	  else {
    		  System.out.println("test " + ((JButton)event.getSource()).getText());
    	  }
      }
    }     
  }