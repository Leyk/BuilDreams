package UIPackage;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;

import BusinessLogic.AbstractPerson;
import BusinessLogic.AbstractRole;

class ButtonListener implements ActionListener{        
      private int column, row;
      private JTable table;
      private Object fen;
      
      private AbstractPerson myAbstractPerson;
      private ArrayList<AbstractRole> myAbstractArrayListRole;
          
      public ButtonListener(Object fen2, AbstractPerson myAbstractPersonIn, ArrayList<AbstractRole> myAbstractArrayListRoleIn) {
		this.fen = fen2;
		this.myAbstractPerson = myAbstractPersonIn;
  	  	this.myAbstractArrayListRole = myAbstractArrayListRoleIn;
      }
      
      public void setColumn(int col){this.column = col;}
      public void setRow(int row){this.row = row;}
      public void setTable(JTable table){this.table = table;}
          
	  public void actionPerformed(ActionEvent event) {
		  if ("ViewOnlineShop".equals(fen.getClass().getSimpleName())){
			  if("Add to card".equals(event.getActionCommand())){
				  //((Window) fen).dispose();
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
				  
			  }
			  else if("Add to offer".equals(event.getActionCommand())){
				  System.out.println("This functionality is not implemented yet !");
			  }
		  }
		  else if ("ViewBasket".equals(fen.getClass().getSimpleName())){
			  if("Delete".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
			  }
		  }
		  else if ("ViewManageCategory".equals(fen.getClass().getSimpleName())){
			  if("Update".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
			  }
			  else if("Delete".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  }
		  }
		  else if ("ViewManageGenProject".equals(fen.getClass().getSimpleName())){ 
			  if("Update".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  }
			  else if("Delete".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  }
		  }
		  else if ("ViewManageGenTask".equals(fen.getClass().getSimpleName())){
			  if("Update".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  }
			  else if("Delete".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  } 
		  }
		  else if ("ViewManageMember".equals(fen.getClass().getSimpleName())){
			  if("Delete".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  }
		  }
		  else if ("ViewManageOffer".equals(fen.getClass().getSimpleName())){
			  if("See Offer".equals(event.getActionCommand())){
				  ViewOffer fenOffer = new ViewOffer();
	    		  fenOffer.setVisible(true);
	    		  ((Window) fen).dispose();
			  }	  
		  }
		  else if ("ViewManageOrder".equals(fen.getClass().getSimpleName())){
			  if("See Order".equals(event.getActionCommand())){
				  ViewOrder fenOrder = new ViewOrder(this.myAbstractPerson, this.myAbstractArrayListRole); // A REMPLACER PAR LE ROLE RECUPERE
				  fenOrder.setVisible(true);
				  ((Window) fen).dispose();
			  }  
		  }
		  else if ("ViewManagePersoProject".equals(fen.getClass().getSimpleName())){
			  if("Update".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  }
			  else if("Delete".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  }  		  
		  }
		  else if ("ViewManagePersoTask".equals(fen.getClass().getSimpleName())){
			  if("Update".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  }
			  else if("Delete".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  }  
		  }
		  else if ("ViewManageShop".equals(fen.getClass().getSimpleName())){
			  if("Update".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
			  }
			  else if("Delete".equals(event.getActionCommand())){
				  System.out.println("Fenetre : " +fen.getClass()+" Colonne : "+column+" Ligne : " +row);
	
	    		  }		  
	    	  }
	      }
	  }