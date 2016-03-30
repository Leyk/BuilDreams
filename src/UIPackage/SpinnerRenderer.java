package UIPackage;

import java.awt.Component;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SpinnerRenderer extends JSpinner implements TableCellRenderer{

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
		  this.setValue((value != null) ? value : 0); 
	      return this;
	    }    
  }

