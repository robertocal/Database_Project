import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Esegui extends JFrame {

	private static final long serialVersionUID = 1L;

	public Esegui() {
		createFrame();
		
		setSize(400,400);
	}
	
	public void createFrame() {
		JLabel label = new JLabel("Scrivi la query:");
		JTextArea area = new JTextArea();
		add(label, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		JButton button = new JButton("Esegui");
		class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Negozio_Online", "root", "Roberto1234");
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery(area.getText());
					while(myRs.next()) {
						System.out.println(myRs.getString(1) + ", " + myRs.getString(2) + ", " + myRs.getString(3));
					}
				}catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		}
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		add(button, BorderLayout.SOUTH);
	}
}
