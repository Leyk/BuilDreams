package MainPackage;

import java.awt.EventQueue;

import UIPackage.ViewLogin;

public class MainBuilDreams {
	public static void main (String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
