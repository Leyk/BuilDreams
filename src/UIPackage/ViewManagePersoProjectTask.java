package UIPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewManagePersoProjectTask extends JFrame {

	private JPanel contentPane;


	public ViewManagePersoProjectTask() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 234);
		setTitle("BuilDreams : Manage ");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JButton btnCreateGeneralProject = new JButton("Create personnal project");
		btnCreateGeneralProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPersoProject fenPersoProject = new ViewPersoProject(); 
				fenPersoProject.setVisible(true);	
				dispose();
			}
		});
		btnCreateGeneralProject.setBounds(22, 31, 225, 23);
		contentPane.add(btnCreateGeneralProject);
		
		JButton btnUpdateGeneralProject = new JButton("Update personnal project");
		btnUpdateGeneralProject.setBounds(22, 65, 225, 23);
		contentPane.add(btnUpdateGeneralProject);
		
		JButton btnCreateGeneralTask = new JButton("Create personnal Task");
		btnCreateGeneralTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPersoTask fenPersoTask = new ViewPersoTask(); 
				fenPersoTask.setVisible(true);	
				dispose();
			}
		});
		btnCreateGeneralTask.setBounds(22, 99, 225, 23);
		contentPane.add(btnCreateGeneralTask);
		
		JButton btnUpdateGeneralTask = new JButton("Update personnal task");
		btnUpdateGeneralTask.setBounds(22, 133, 225, 23);
		contentPane.add(btnUpdateGeneralTask);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewHome fenHome = new ViewHome(true,"User"); // A REMPLACER PAR LE ROLE RECUPERE
				fenHome.setVisible(true);	
				dispose();
			}
		});
		btnHome.setBounds(85, 167, 89, 23);
		contentPane.add(btnHome);
	}

}
