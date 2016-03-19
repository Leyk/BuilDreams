package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewManagePersoProject extends JFrame {

	private JPanel contentPane;

	public ViewManagePersoProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage my projects");
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
			
			JButton btnCreatePersoProject = new JButton("Create personnal project");
			btnCreatePersoProject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewPersoProject fenPersoProject = new ViewPersoProject(); 
					fenPersoProject.setVisible(true);	
					dispose();
				}
			});
			btnCreatePersoProject.setBounds(22, 31, 225, 23);

			JPanel panbtn = new JPanel();
			panbtn.add(btnCreatePersoProject);
			panbtn.add(btnHome);
			getContentPane().add(panbtn, BorderLayout.SOUTH);
	}
	

}
