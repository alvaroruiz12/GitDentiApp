package Main;
import java.awt.EventQueue;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Login extends JFrame {
	
	
	
	private static final long serialVersionUID = 1L;
	
	//declaracion de las visuales de la aplicacion
	private JPanel contentPane;
	private JTextField txUsuario;
	private JPasswordField pfContra;
	private JButton btnInicioSesion;
	JLabel lblNewLabel, lblNewLabel_1;
	private boolean esUsuario = true; //tiene que ir en false
	private String nombre, contra; 
	private Conexion conex;

	

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


	
	//inicializacion de las visuales de la aplicacion
	private void init() {
		
		btnInicioSesion = new JButton("INICIAR SESIÓN");
		btnInicioSesion.setHorizontalAlignment(SwingConstants.LEFT);
		btnInicioSesion.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txUsuario = new JTextField();
		lblNewLabel= new JLabel("USUARIO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		pfContra = new JPasswordField();
		
		//conexion
		conex = new Conexion();
		conex.conectar();

	}
	
	
	/**
	 * Create the frame.
	 */
	
	public Login() {
		setResizable(false);


		
		
		//iniciar toda la aplicacion
		init();
		
		//conectarse a la baes de datos

		
		
		
		
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
		
		
		
		//TEXTFIELD
		txUsuario.setBounds(701, 312, 135, 25);
		contentPane.add(txUsuario);
		txUsuario.setColumns(10);
		
		//JLABEL USUARIO
		lblNewLabel.setBounds(701, 276, 135, 25);
		contentPane.add(lblNewLabel);
		
		//JLABEL CONTRASEÑA
		lblNewLabel_1.setBounds(701, 348, 135, 25);
		contentPane.add(lblNewLabel_1);
		
		//PASSWORDFIELD
		pfContra.setBounds(701, 384, 135, 25);
		contentPane.add(pfContra);
		
		//BOTON INICIAR SESION
		btnInicioSesion.setBounds(701, 426, 135, 25);
		contentPane.add(btnInicioSesion);
		
		//TITULO
		JLabel titulo = new JLabel("DENTIAPP");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Arial Black", Font.ITALIC, 33));
		titulo.setBounds(300, 312, 272, 59);
		contentPane.add(titulo);
		
		//VERSION
		JLabel version = new JLabel("Versión 0.1");
		version.setBounds(348, 366, 77, 14);
		version.setFont(new Font("Arial Black", Font.ITALIC, 10));
		version.setForeground(new Color(255, 255, 255));
		contentPane.add(version);
        
        //JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 900, 700);
	
		ImageIcon imagen= new ImageIcon(getClass().getResource("fondologin.jpg"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen2);
		contentPane.add(fondo);
		
	
		
	// inicio de sesion 
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				nombre = txUsuario.getText();
				contra = pfContra.getPassword().toString();
				
				String sentenciaSQL="Select * from usuarios where user='"+nombre+"' & password='"+contra+"';";
				
				ArrayList<String> intento = new ArrayList<String>();
				intento.add(nombre);
				intento.add(contra);
				
				ArrayList<String> res = new ArrayList<String>();
				res= conex.seleccionarUsuarios(conex,sentenciaSQL);
				
				
				
				
			/*	if(res.get(3) == "true") {
					
					//crear ventana admin
					
					
				} else if (res.get(3) == "false") {
					
					//crear ventana doctor
					
				}*/
				
				
				
				
				
			}
		});
	}
}
