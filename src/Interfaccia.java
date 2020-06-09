import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Interfaccia extends JFrame {

	private static final long serialVersionUID = 1L;

	public Interfaccia(){
		createFrame();
		
		setSize(400,400);
	}
	
	public void createFrame() {
		JButton button1 = new JButton("Connetti");
		JButton button2 = new JButton("Aggiorna");
		JButton button3 = new JButton("Esegui");
		JPanel panel = new JPanel(new GridLayout(3,1));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		add(panel);
		
		class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Connetti frame2 = new Connetti();
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setVisible(true);
			}
		}
		
		class ClickListener1 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Aggiorna frame3 = new Aggiorna();
				frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame3.setVisible(true);
			}
		}
		
		class ClickListener2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Esegui frame4 = new Esegui();
				frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame4.setVisible(true);
			}
		}
		
		ActionListener listener = new ClickListener();
		button1.addActionListener(listener);
		ActionListener listener1 = new ClickListener1();
		button2.addActionListener(listener1);
		ActionListener listener2 = new ClickListener2();
		button3.addActionListener(listener2);
	}
}