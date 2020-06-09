import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Connetti extends JFrame {
	private static final long serialVersionUID = 1L;
	public Connetti() {
		user = new JTextField();
		password = new JTextField();
		
		createFrame();
		
		setSize(300,200);
	}
	
	public void createFrame() {
		JPanel panel = new JPanel(new GridLayout(2,2));
		JLabel label = new JLabel("Inserisci username: ");
		JLabel label2 = new JLabel("Inserisci password: ");
		panel.add(label);
		panel.add(user);
		panel.add(label2);
		panel.add(password);
		add(panel, BorderLayout.NORTH);
		JButton connetti = new JButton("Connetti");
		add(connetti, BorderLayout.SOUTH);
		
		class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					DriverManager.getConnection("jdbc:mysql://localhost:3306/Negozio_Online", user.getText(), password.getText());
					setVisible(false);
				}catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		}
		
		ActionListener listener = new ClickListener();
		connetti.addActionListener(listener);
	}
	
	private JTextField user;
	private JTextField password;
}
