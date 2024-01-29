package Main;
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class boton_personalizado extends JButton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean cambioColor;
	private boolean azul = true;
	JFrame esteFrame;

	public boton_personalizado(JFrame frame) {
		super();
		initcomponents();
		esteFrame = frame;

	}

	
	private void initcomponents() {
		
		setText("APAGAR");
		//ImageIcon i7 = new ImageIcon(getClass().getResource("botonapagarsolo.png"));
		//ImageIcon i8 = new ImageIcon(i7.g	etImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
		//this.setIcon(i8);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				esteFrame.dispose();
				
			}
		});	
	}
	

}


