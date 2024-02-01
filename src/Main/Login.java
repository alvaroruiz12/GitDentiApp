package Main;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.help.HelpSet;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	// declaracion de las visuales de la aplicacion
	private JPanel contentPane;
	private JTextField txUsuario;
	private JPasswordField pfContra;
	private JButton btnInicioSesion;
	JLabel lblUsuario, lblContra;
	private boolean esUsuario = true; // tiene que ir en false
	private String nombre, contra;
	private Conexion conexion;
	private JLabel lblFotoUser;
	private Login padre;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// inicializacion de las visuales de la aplicacion
	private void init() {

		btnInicioSesion = new JButton("INICIAR SESIÓN");
		btnInicioSesion.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txUsuario = new JTextField();
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblContra = new JLabel("CONTRASEÑA");
		lblContra.setHorizontalAlignment(SwingConstants.CENTER);
		lblContra.setFont(new Font("Arial Black", Font.PLAIN, 11));
		pfContra = new JPasswordField();

		// conexion
		conexion = new Conexion();
		conexion.conectar();

	}

	/**
	 * Create the frame.
	 */

	public Login() {
		setResizable(false);
		padre=this;
		// iniciar toda la aplicacion
		init();

		// conectarse a la baes de datos

		/*
		 * 
		 * COMIENZO DE JFRAME
		 * 
		 */

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("PRUEBA AYUDA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File fichero = new File("src/help/help_set.hs");
				URL hsURL = fichero.toURI().toURL();
				
				HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
				HelpBroker hb = helpset.createHelpBroker();
				
				hb.enableHelpOnButton(btnNewButton,"aplicacion",helpset);
				
				Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
				Point p = new Point((int) pantalla.getWidth()/3,(int) pantalla.getHeight()/3);
				hb.setLocation(p);
				
			}
		});
		btnNewButton.setBounds(597, 157, 89, 23);
		contentPane.add(btnNewButton);

		// TEXTFIELD
		txUsuario.setBounds(701, 312, 135, 25);
		contentPane.add(txUsuario);
		txUsuario.setColumns(10);

		// JLABEL USUARIO
		lblUsuario.setBounds(701, 276, 135, 25);
		lblUsuario.setForeground(new Color(255, 255, 255));
		contentPane.add(lblUsuario);

		// JLABEL CONTRASEÑA
		lblContra.setBounds(701, 348, 135, 25);
		contentPane.add(lblContra);

		// PASSWORDFIELD
		pfContra.setBounds(701, 384, 135, 25);
		lblContra.setForeground(new Color(255, 255, 255));
		contentPane.add(pfContra);

		// BOTON INICIAR SESION
		btnInicioSesion.setBounds(669, 432, 204, 53);
		contentPane.add(btnInicioSesion);

		// TITULO
		JLabel titulo = new JLabel("DENTIAPP");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Arial Black", Font.ITALIC, 33));
		titulo.setBounds(300, 312, 272, 59);
		contentPane.add(titulo);

		// VERSION
		JLabel version = new JLabel("Versión 0.2");
		version.setBounds(348, 366, 77, 14);
		version.setFont(new Font("Arial Black", Font.ITALIC, 10));
		version.setForeground(new Color(255, 255, 255));
		contentPane.add(version);

		// foto usuario
		lblFotoUser = new JLabel();
		lblFotoUser.setBounds(742, 215, 50, 50);
		ImageIcon imagen = new ImageIcon(getClass().getResource("user.png"));
		ImageIcon imagen2 = new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(),
				lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
		lblFotoUser.setIcon(imagen2);
		contentPane.add(lblFotoUser);

//boton recuperar contraseña
		JButton botonRecuperar = new JButton("Recuperar contraseña");
		botonRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre = txUsuario.getText();
				contra = pfContra.getText();
				String sentenciaSQL = "Select contrasenia from usuarios where usuario = '" + nombre + "';";

				ArrayList<String> res = new ArrayList<String>();
				res = conexion.seleccionarUsuarios(conexion, sentenciaSQL);
				System.out.println(res);

				if (res.isEmpty()) {
					JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Tu contraseña es: "+res.get(0)+" ", "Contraseña",
							JOptionPane.INFORMATION_MESSAGE);
				
				}

			}
		});
		botonRecuperar.setBounds(679, 496, 184, 42);
		contentPane.add(botonRecuperar);
		
		// JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 900, 700);

		ImageIcon imagen3 = new ImageIcon(getClass().getResource("fondologin.jpg"));
		ImageIcon imagen4 = new ImageIcon(
				imagen3.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen4);
		contentPane.add(fondo);

//		btnInicioSesion.setMnemonic(VK_ENTER);

		// personalizar boton de inicio de sesion
		ImageIcon inicio = new ImageIcon(getClass().getResource("boton.png"));
		// ImageIcon sesion= new
		// ImageIcon(inicio.getImage().getScaledInstance(btnInicioSesion.getWidth(),
		// btnInicioSesion.getHeight(), Image.SCALE_SMOOTH));
		Image foto = inicio.getImage().getScaledInstance(btnInicioSesion.getWidth(), btnInicioSesion.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon sesion = new ImageIcon(foto);
		// Eliminar el borde del botón para que la imagen sea visible
		btnInicioSesion.setBorderPainted(false);
		btnInicioSesion.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnInicioSesion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInicioSesion.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnInicioSesion.setIcon(sesion);

		//boton recuperar contraseña
		
		botonRecuperar.setBorderPainted(false);
		botonRecuperar.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		botonRecuperar.setHorizontalTextPosition(SwingConstants.CENTER);
		botonRecuperar.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		botonRecuperar.setIcon(sesion);
		
		// inicio de sesion
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nombre = txUsuario.getText();
				contra = pfContra.getText();
				String sentenciaSQL = "Select * from usuarios where usuario = '" + nombre + "' AND contrasenia='" + contra
						+ "';";

				ArrayList<String> res = new ArrayList<String>();
				res = conexion.seleccionarUsuarios(conexion, sentenciaSQL);
				System.out.println(res);

				if (res.isEmpty()) {
					JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {

					if (res.get(3) == "true") {

						// crear ventana admin

						InicioAdmin ventana_admin = new InicioAdmin(res, conexion);
						ventana_admin.setVisible(true);
						dispose();

					} else if (res.get(3) == "false") {

						InicioDoctor ventana_doctor = new InicioDoctor();
						ventana_doctor.setVisible(true);
						dispose();

					}
				}

			}
		});
		AbstractAction accionBoton = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Realiza la acción deseada al presionar el atajo de teclado
				btnInicioSesion.doClick(); // Simula un clic en el botón

			}
		};
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()),
				"presionarBoton");

		getRootPane().getActionMap().put("presionarBoton", accionBoton);
	}
}

