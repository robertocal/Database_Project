import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aggiorna extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Aggiorna(){
		createFrame();
		
		setSize(400,400);
	}
	
	public void createFrame() {
		JButton button1 = new JButton("Inserisci un nuovo cliente");
		JButton button2 = new JButton("Modifica l'indirizzo di un cliente");
		JButton button3 = new JButton("Elimina un cliente dal database");
		JPanel panel = new JPanel(new GridLayout(3,1));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		add(panel);
		
		class ClickListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Inserisci frame = new Inserisci();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		}
		
		class ClickListener1 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Modifica frame1 = new Modifica();
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.setVisible(true);
			}
		}
		
		class ClickListener2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Elimina frame2 = new Elimina();
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setVisible(true);
			}
		}
		
		ActionListener listener1 = new ClickListener();
		button1.addActionListener(listener1);
		ActionListener listener2 = new ClickListener1();
		button2.addActionListener(listener2);
		ActionListener listener3 = new ClickListener2();
		button3.addActionListener(listener3);
	}
}
