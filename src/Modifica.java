import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class Modifica extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Modifica() {
		createFrame();
		
		setSize(600,400);
	}
	
	public void createFrame() {
		JPanel panel = new JPanel(new GridLayout(2,2));
		JLabel label = new JLabel("Inserire email del cliente che si vuole modificare: ");
		JLabel label2 = new JLabel("Nuovo indirizzo: ");
		JTextField email = new JTextField();
		JTextField indirizzo = new JTextField();
		panel.add(label);
		panel.add(email);
		panel.add(label2);
		panel.add(indirizzo);
		add(panel, BorderLayout.NORTH);
		JButton aggiorna = new JButton("Modifica");
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Negozio_Online", "root", "Roberto1234");
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("update cliente set indirizzo = '" + indirizzo.getText() + "' where email = '" + email.getText() + "'");
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
