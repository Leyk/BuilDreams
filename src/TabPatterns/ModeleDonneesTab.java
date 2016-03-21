package TabPatterns;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
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
