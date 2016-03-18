package MainPackage;

import java.awt.EventQueue;

import UIPackage.ViewHome;


public class MainBuilDreams {
	public static void main (String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewHome frame = new ViewHome();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
