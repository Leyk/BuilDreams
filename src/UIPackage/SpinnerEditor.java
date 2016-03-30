package UIPackage;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerEditor extends DefaultCellEditor {
	 
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
		 	
		 	// allow only numeric values in the Jspinner
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
		 	       if ( numpad ) { // accept only numeric keys
		 	           if ( ((c >= '0') && (c <= '9')) ) { 
		 	        		  accept = true;
		 	           }
		 	       } 
		 	       else if ( (c == KeyEvent.VK_BACK_SPACE ) || (c == KeyEvent.VK_DELETE) ) { // accept backspace and delete keys
		 	           accept = true;
		 	       }		 	 
		 	       if( !accept ) { // if the key isn't accepted
		 	           Toolkit.getDefaultToolkit().beep(); // beep
		 	           e.consume(); 
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