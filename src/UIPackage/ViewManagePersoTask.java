package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewManagePersoTask extends JFrame {

	private JPanel contentPane;

	public ViewManagePersoTask() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage my tasks");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		 JButton btnHome = new JButton("Home");
		    btnHome.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		ViewHome fenHome = new ViewHome(true,"User"); // A REMPLACER PAR LE ROLE RECUPERE
					fenHome.setVisible(true);	
					dispose();
		    	}
		    });
			btnHome.setBounds(176, 130, 112, 23);
			
			JButton btnCreatePersoTask = new JButton("Create personnal task");
			btnCreatePersoTask.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewPersoTask fenPersoTask = new ViewPersoTask(); 
					fenPersoTask.setVisible(true);	
					dispose();
				}
			});
			btnCreatePersoTask.setBounds(22, 99, 225, 23);

			JPanel panbtn = new JPanel();
			panbtn.add(btnCreatePersoTask);
			panbtn.add(btnHome);
			getContentPane().add(panbtn, BorderLayout.SOUTH);
	}
	

}
