package Main;
import java.awt.EventQueue;
import java.awt.Image;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Component;

public class Login extends JFrame {
	
	
	
	private static final long serialVersionUID = 1L;
	
	//declaracion de las visuales de la aplicacion
	private JPanel contentPane;
	private JTextField txUsuario;
	private JPasswordField pfContra;
	private JButton btnInicioSesion;
	private boolean esUsuario = true; //tiene que ir en false
	private String nombre, contra; 
	private Conexion conexion;
	private JLabel lblFotoUser;
   private String stf1= "Usuario",stf2 ="Contraseña";
	

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
		btnInicioSesion.setFocusable(false);
		btnInicioSesion.setFocusPainted(false);
		btnInicioSesion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnInicioSesion.setBorderPainted(false);
		btnInicioSesion.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnInicioSesion.setBackground(Color.LIGHT_GRAY);
		txUsuario = new JTextField();
		txUsuario.setHorizontalAlignment(txUsuario.CENTER);
		txUsuario.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		txUsuario.setText("Usuario");
		txUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txUsuario.setOpaque(false);
		txUsuario.setBackground(null);
		txUsuario.setForeground(Color.LIGHT_GRAY);
		
		
		pfContra = new JPasswordField();
		pfContra.setForeground(Color.LIGHT_GRAY);
		pfContra.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 10));
		pfContra.setText("Contraseña");
		pfContra.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		pfContra.setOpaque(false);
		pfContra.setHorizontalAlignment(pfContra.CENTER);
		
		//conexion
		conexion = new Conexion();
		conexion.conectar();

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
		txUsuario.setBounds(335, 327, 195, 25);
		contentPane.add(txUsuario);
		txUsuario.setColumns(10);
		
		//PASSWORDFIELD
		pfContra.setBounds(335, 399, 195, 25);
		contentPane.add(pfContra);
		
		//BOTON INICIAR SESION
		btnInicioSesion.setBounds(335, 468, 195, 48);
		contentPane.add(btnInicioSesion);
        
		
		//foto usuario
		lblFotoUser = new JLabel();
		lblFotoUser.setBounds(262, 0, 334, 316);
		ImageIcon imagen= new ImageIcon(getClass().getResource("diente.png"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
		lblFotoUser.setIcon(imagen2);
		contentPane.add(lblFotoUser);
	
		ImageIcon imagen3= new ImageIcon(getClass().getResource("fondologin.jpg"));
		
		JLabel nombre1 = new JLabel("D E N T I A P P");
	
		nombre1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		nombre1.setForeground(Color.LIGHT_GRAY);
		nombre1.setBounds(363, 231, 195, 32);
		contentPane.add(nombre1);
		
		JButton btnNewButton = new JButton("Recuperar Contraseña");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setFocusable(false);
		btnNewButton.setDoubleBuffered(true);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setSelected(true);
		btnNewButton.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(280, 581, 130, 18);
		contentPane.add(btnNewButton);
		
JButton crearcuenta = new JButton("Crear Cuenta");
		
		crearcuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				CrearCuenta crear = new CrearCuenta();
				crear.setVisible(modal);
				
				
			}
		});
		crearcuenta.setFocusable(false);
		crearcuenta.setDoubleBuffered(true);
		crearcuenta.setFocusPainted(false);
		crearcuenta.setSelected(true);
		crearcuenta.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		crearcuenta.setOpaque(false);
		crearcuenta.setBackground(new Color(240, 240, 240));
		crearcuenta.setBorder(null);
		crearcuenta.setForeground(Color.LIGHT_GRAY);
		crearcuenta.setBounds(479, 581, 145, 18);
		contentPane.add(crearcuenta);
		
		


        //JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setForeground(Color.LIGHT_GRAY);
		fondo.setBorder(null);
		fondo.setBounds(0, 0, 884, 661);
		ImageIcon imagen4= new ImageIcon(imagen3.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen4);
		contentPane.add(fondo);
		// Establecer el texto sobre la imagen

        // Personalizar el estilo del texto
	

	// inicio de sesion 
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				nombre = txUsuario.getText();
				contra = pfContra.getText();
				String sentenciaSQL="Select * from usuarios where usuario = '"+nombre+"' AND contrasenia='"+contra+"';";
				
				ArrayList<String> res = new ArrayList<String>();
				res= conexion.seleccionarUsuarios(conexion,sentenciaSQL);
				System.out.println(res);
				
			if (res.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);			
		        }else {
				
				
				
				if(res.get(3) == "true") {
					
					//crear ventana admin
					
					InicioAdmin ventana_admin = new InicioAdmin(res,conexion);
					ventana_admin.setVisible(true);
					dispose();
					
					
				} else if (res.get(3) == "false") {
					ArrayList<String> b = null;
					Conexion con = null;
					InicioDoctor ventana_doctor = new InicioDoctor(res,conexion); 
					ventana_doctor.setVisible(true);
					dispose();
					
				}
		        }
				
			}
		});		
		txUsuario.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				txUsuario.setText("");
				txUsuario.setForeground(Color.LIGHT_GRAY);
					
				
			}
			
		});
		
		txUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				
				if(txUsuario.getText().isEmpty()) {
					
					
					txUsuario.setText(stf1);
					txUsuario.setForeground(Color.LIGHT_GRAY);
					
				}
			}
		});
		
		pfContra.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				pfContra.setText("");
				pfContra.setForeground(Color.LIGHT_GRAY);
					
				
			}
			
		});
		
		pfContra.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				
				if(pfContra.getText().isEmpty()) {
					
					
					pfContra.setText(stf2);
					pfContra.setForeground(Color.LIGHT_GRAY);
					
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
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "presionarBoton");

        getRootPane().getActionMap().put("presionarBoton", accionBoton);
	}	
}
