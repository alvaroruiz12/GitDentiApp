package Main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class prueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = new prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAyuda = new JButton("New button");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//lo que voy a cargar es el fichero donde estan las vistas
			//
				try {
					File fichero = new File ("src/help/help_set.hs");
					URL hsURL = fichero.toURI().toURL();
					HelpSet helpset = new HelpSet(getClass().getClassLoader(),hsURL);
					//crear un objeto de ayuda que vaya asociada a la clase anterior
					HelpBroker hb = helpset.createHelpBroker();
					
					//declara cuando se hace
					//lo primero es el boton, lo segundo la clave valor del principal y el helpset
					hb.enableHelpOnButton(btnAyuda,"prueba",helpset);
					
					//esto es para colocar la ayuda en medio de la pantalla
					
					Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
					Point p = new Point( (int) pantalla.getWidth()/3, (int)pantalla.getHeight()/4);
					hb.setLocation(p);
				
				}//se le pone un exception para no tener 200 catch
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAyuda.setBounds(92, 124, 89, 23);
		contentPane.add(btnAyuda);
	}

}
