import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class Elimina extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Elimina() {
		createFrame();
		
		setSize(600,400);
	}
	
	public void createFrame() {
		JPanel panel = new JPanel(new GridLayout(1,2));
		JLabel label = new JLabel("Inserire email del cliente che si vuole eliminare: ");
		JTextField email = new JTextField();
		panel.add(label);
		panel.add(email);
		add(panel, BorderLayout.NORTH);
		JButton aggiorna = new JButton("Elimina");
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Negozio_Online", "root", "Roberto1234");
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("delete from cliente where email = '" + email.getText() + "'");
					setVisible(false);
				}catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		}
		ActionListener listener = new ClickListener();
		aggiorna.addActionListener(listener);
		add(aggiorna, BorderLayout.SOUTH);
	}
	
}