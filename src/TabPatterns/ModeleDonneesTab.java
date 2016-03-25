package TabPatterns;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ModeleDonneesTab extends AbstractTableModel {
	
	private Object[][] data;
	private String[] title;
	private JTable tab;
	
	public ModeleDonneesTab(Object[][] data, String[] title){
		this.data = data;
		this.title = title;
		this.tab = null;
	}
	
	public void addTab(JTable tableau){
		this.tab = tableau;
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
		
	// to display column's title
	public String getColumnName(int col){
		return this.title[col];
	}
	
	// return the class of the data in the column
	public Class getColumnClass(int col){
		return this.data[0][col].getClass();
	}
	
	/*public void resizeCol(JTable table){
		for (int column = 0; column < table.getColumnCount(); column++)
		{
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    TableCellRenderer headerRenderer = tableColumn.getHeaderRenderer();
		    if (headerRenderer == null) {
		    	headerRenderer = table.getTableHeader().getDefaultRenderer();
		    }
		    Component comp = headerRenderer.getTableCellRendererComponent(
			        table, tableColumn.getHeaderValue(), false, false, 0, 0);
			int widthC = comp.getPreferredSize().width;
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();
		 
		    for (int row = 0; row < table.getRowCount(); row++)
		    {
		        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
		        Component c = table.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);
		 
		        //  We've exceeded the maximum width, no need to check other rows
		 
		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }
		 
		    tableColumn.setPreferredWidth( preferredWidth );
		}
		    // Get width of column header
		    
		    java.awt.

		    // Get maximum width of column data
		    for (int r=0; r<table.getRowCount(); r++) {
		        renderer = table.getCellRenderer(r, vColIndex);
		        comp = renderer.getTableCellRendererComponent(
		            table, table.getValueAt(r, vColIndex), false, false, r, vColIndex);
		        width = Math.max(width, comp.getPreferredSize().width);
		    }

		    // Add margin
		    width += 2*margin;

		    // Set the width
		    col.setPreferredWidth(width);
	}*/
	
	// Pas très propre mais pas réussi à faire autrement..
	public void setValueAt(Object value, int row, int col) {
		try{
			String r = this.tab.getColumn(getColumnName(col)).getCellRenderer().toString();
			if(!(r.contains("ButtonRenderer"))){
			data[row][col] = value;
	        fireTableCellUpdated(row, col);
			}
		} catch(Exception e){
			data[row][col] = value;
	        fireTableCellUpdated(row, col);
		}
    }
	
	// allow to edit cells
	public boolean isCellEditable(int row, int col){
		if(getColumnName(col)=="Chosen Quantity"){    // sale => à changer
			return true;
		}
		else if(getColumnName(col)==" "){
			return true;
		}
		else if(getColumnName(col)=="  "){
			return true;
		}
		else if(getColumnName(col)=="Chosen Price"){
			return true;
		}
		return false;
	}
}
