package TabPatterns;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private boolean   isPushed;
    private ButtonListener bListener = new ButtonListener();
     
    //Constructeur avec une CheckBox
    public ButtonEditor(JCheckBox checkBox) {
      //Par d�faut, ce type d'objet travaille avec un JCheckBox
      super(checkBox);
      //On cr�e � nouveau un bouton
      button = new JButton();
      button.setOpaque(true);
      //On lui attribue un listener
      button.addActionListener(bListener);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) { 
      //On pr�cise le num�ro de ligne et de colonne � notre listener
      bListener.setRow(row);
      bListener.setColumn(column);
      bListener.setTable(table);	          
      //On r�affecte le libell� au bouton
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
        System.out.println("test " + ((JButton)event.getSource()).getText());
      }
    }     
  }