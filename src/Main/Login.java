package Main;
import java.awt.EventQueue;
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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
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
		setBounds(100, 100, 450, 300);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//TEXTFIELD
		textField.setBounds(155, 82, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//JLABEL USUARIO
		lblNewLabel.setBounds(165, 57, 58, 14);
		contentPane.add(lblNewLabel);
		
		//JLABEL CONTRASEÑA
		lblNewLabel_1.setBounds(158, 112, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		//PASSWORDFIELD
		passwordField.setBounds(155, 138, 86, 20);
		contentPane.add(passwordField);
		
		//BOTON INICIAR SESION
		btnNewButton.setBounds(132, 173, 126, 23);
		contentPane.add(btnNewButton);
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
