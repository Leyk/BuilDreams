package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewManageGenProject extends JFrame {

	private JPanel contentPane;

	public ViewManageGenProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 258);
		setTitle("BuilDreams : Manage members");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		 JButton btnHome = new JButton("Home");
		    btnHome.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		ViewHome fenHome = new ViewHome(true,"Administrator"); // A REMPLACER PAR LE ROLE RECUPERE
					fenHome.setVisible(true);	
					dispose();
		    	}
		    });
			btnHome.setBounds(176, 130, 112, 23);
			
			JButton btnCreateGeneralProject = new JButton("Create general project");
			btnCreateGeneralProject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewGenProject fenGenProj = new ViewGenProject(); 
					fenGenProj.setVisible(true);	
					dispose();
				}
			});
			btnCreateGeneralProject.setBounds(22, 31, 225, 23);
			
			JPanel panbtn = new JPanel();
			panbtn.add(btnCreateGeneralProject);
			panbtn.add(btnHome);
			this.getContentPane().add(panbtn, BorderLayout.SOUTH);
	}
	

}
