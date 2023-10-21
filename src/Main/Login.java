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

public class Login extends JFrame {
	
	
	
	private static final long serialVersionUID = 1L;
	
	//declaracion de las visuales de la aplicacion
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
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
		
		btnNewButton = new JButton("iniciar sesion");
		textField = new JTextField();
		lblNewLabel= new JLabel("USUARIO");
		lblNewLabel_1 = new JLabel("CONTRASEÑA");
		passwordField = new JPasswordField();
		
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
		setBounds(100, 100, 1920, 1080);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//TEXTFIELD
		textField.setBounds(942, 216, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//JLABEL USUARIO
		lblNewLabel.setBounds(942, 191, 58, 14);
		contentPane.add(lblNewLabel);
		
		//JLABEL CONTRASEÑA
		lblNewLabel_1.setBounds(949, 259, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		//PASSWORDFIELD
		passwordField.setBounds(937, 284, 86, 20);
		contentPane.add(passwordField);
		
		//BOTON INICIAR SESION
		btnNewButton.setBounds(931, 333, 126, 23);
		contentPane.add(btnNewButton);
		
		
        
        
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 657, 466);
		fondo.setSize(1920,1080);
		ImageIcon imagen= new ImageIcon(getClass().getResource("fondologin	ººº.jpg"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen2);
		contentPane.add(fondo);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				nombre = textField.getText();
				contra = passwordField.getPassword().toString();
				
				ArrayList<String> res = new ArrayList<String>();
				//res = Conexion.seleccionarUsuarios(conex, "Select * from dentiapp.usuarios where nombre & contra coincidan");
				
				
				
				if(res.get(3) == "true") {
					
					//crear ventana admin
					
				} else if (res.get(3) == "false") {
					
					//crear ventana doctor
					
				}
				
				
				
				
				
			}
		});
	}
}
