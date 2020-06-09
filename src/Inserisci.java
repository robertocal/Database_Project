import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;

public class Inserisci extends JFrame {
	private static final long serialVersionUID = 1L;

	public Inserisci(){
		createFrame();

		setSize(400,400);
	}
	
	public void createFrame() {
		JPanel panel = new JPanel(new GridLayout(4,2));
		JLabel label = new JLabel("Email: ");
		JLabel label1 = new JLabel("Nome: ");
		JLabel label2 = new JLabel("Indirizzo: ");
		JLabel label3 = new JLabel("Telefono (opzionale): ");
		JTextField email = new JTextField();
		JTextField nome = new JTextField();
		JTextField indirizzo = new JTextField();
		JTextField telefono = new JTextField();
		panel.add(label);
		panel.add(email);
		panel.add(label1);
		panel.add(nome);
		panel.add(label2);
		panel.add(indirizzo);
		panel.add(label3);
		panel.add(telefono);
		add(panel, BorderLayout.NORTH);
		JButton aggiorna = new JButton("Inserisci");
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Negozio_Online", "root", "Roberto1234");
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("insert into cliente (email, nome, indirizzo, telefono) values('" + email.getText() + "', '" + nome.getText() + "', '" + indirizzo.getText() + "', '" + telefono.getText() + "')");
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
