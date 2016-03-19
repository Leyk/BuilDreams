package TabPatterns;

import javax.swing.table.AbstractTableModel;

public class ModeleDonneesTab extends AbstractTableModel {
	
	private Object[][] data;
	private String[] title;
	
	public ModeleDonneesTab(Object[][] data, String[] title){
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
	
	// to display column's title
	public String getColumnName(int col){
		return this.title[col];
	}
	
	// return the class of the data in the column
	public Class getColumnClass(int col){
		return this.data[0][col].getClass();
	}
	
	// allow to edit cells
	public boolean isCellEditable(int row, int col){
		if(getColumnName(col)=="Quantity"){    // sale => à changer
			return true;
		}
		else if(getColumnName(col)==" "){
			return true;
		}
		else if(getColumnName(col)=="  "){
			return true;
		}
		return false;
	}
}
