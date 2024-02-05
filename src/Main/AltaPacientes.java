package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

public class AltaPacientes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	
	private String stf1="Introduzca nombre",stf2= "Introduzca apellido",
			stf3 = "Introduzca DNI",stf4 = "Introduzca correo",stf5 = "Introduzca telefono",stf6="Introduzca edad";
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ArrayList<String> b = null;
		Conexion con = null;
		try {
			AltaPacientes dialog = new AltaPacientes(b,con,null,true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaPacientes(ArrayList<String> a, Conexion con,InicioAdmin parent,boolean modal) {
		super(parent,modal);
		
		setBounds(100, 100, 750, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
		
		ArrayList<String> usuario = a;
		Conexion conexion = con;

		//
		tf1 = new JTextField();
		tf1.setText(" ");
		tf1.setForeground(new Color(192, 192, 192));

		tf1.setFont(new Font("Calibri", Font.PLAIN, 15));
		tf1.setBounds(456, 135, 189, 30);
		contentPanel.add(tf1);
		tf1.setColumns(10);

		//SEGUNDA SELECCION
		//text field apellidos
		tf2 = new JTextField();
		tf2.setForeground(new Color(192, 192, 192));
		tf2.setFont(new Font("Calibri", Font.PLAIN, 15));
		tf2.setBounds(456, 195, 189, 30);
		contentPanel.add(tf2);
		tf2.setColumns(10);
		JButton btnVolver = new JButton("VOLVER");

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(619, 11, 105, 50);
		ImageIcon imagen3 = new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen4 = new ImageIcon(imagen3.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
		btnVolver.setIcon(imagen4);

		// Eliminar el borde del botón para que la imagen sea visible
		btnVolver.setBorderPainted(false);
		btnVolver.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolver.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnVolver.setForeground(Color.WHITE); // Color del texto
		btnVolver.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		contentPanel.add(btnVolver);
		
		
		//BOTON FUNCIONALIDAD
		
		JButton btnAnadir = new JButton("Insertar");
		btnAnadir.setBounds(626, 537, 55, 50);
		btnAnadir.setFont(new Font("Calibri", Font.PLAIN, 28));
		btnAnadir.setForeground(new Color(0, 0, 0));
		btnAnadir.setBackground(new Color (207, 241, 255));
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					
					String sentencia="Insert into dentiapp.pacientes (DNIpaciente,Nombre,Apellidos,correo,telefono,edad)values('"
							+tf3.getText()+"','"+tf1.getText()+"','"+tf2.getText()+"','"+tf4.getText()+"',"+tf5.getText()+","+tf6.getText()+");";
				
					
					
					boolean status = false;
					status = conexion.insertar(conexion,sentencia);
					if (status=true) {
						
					}
			}
		});
		btnAnadir.setIcon(imagen4);

		// Eliminar el borde del botón para que la imagen sea visible
		btnAnadir.setBorderPainted(false);
		btnAnadir.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnAnadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAnadir.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnAnadir.setForeground(Color.WHITE); // Color del texto
		btnAnadir.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		contentPanel.add(btnAnadir);
		
		JLabel lblFotoUser = new JLabel();
		lblFotoUser.setBounds(94, 125, 170, 170);
		ImageIcon imagen= new ImageIcon(getClass().getResource("user.png"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
		lblFotoUser.setIcon(imagen2);
		contentPanel.add(lblFotoUser);
		
		
		
		
		
		tf3 = new JTextField();
		tf3.setForeground(new Color(192, 192, 192));
		tf3.setText("Introduzca DNI");
		tf3.setFont(new Font("Calibri", Font.PLAIN, 15));
		tf3.setBounds(456, 265, 189, 30);
		contentPanel.add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setForeground(new Color(192, 192, 192));
		tf4.setText("Introduzca correo electronico");
		tf4.setFont(new Font("Calibri", Font.PLAIN, 15));
		tf4.setBounds(456, 333, 189, 30);
		contentPanel.add(tf4);
		tf4.setColumns(10);
		
		tf5 = new JTextField();
		tf5.setForeground(new Color(192, 192, 192));
		tf5.setText("Introduzca el telefono");
		tf5.setFont(new Font("Calibri", Font.PLAIN, 15));
		tf5.setBounds(456, 403, 189, 30);
		contentPanel.add(tf5);
		tf5.setColumns(10);
		
		tf6 = new JTextField();
		tf6.setForeground(new Color(192, 192, 192));
		tf6.setText("Introduzca edad");
		tf6.setFont(new Font("Calibri", Font.PLAIN, 15));
		tf6.setBounds(456, 473, 189, 30);
		contentPanel.add(tf6);
		tf6.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(333, 141, 93, 24);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(333, 201, 93, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setBounds(333, 265, 76, 30);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(333, 339, 76, 24);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setBounds(333, 403, 93, 30);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(Color.white);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Edad");
		lblNewLabel_5.setBounds(333, 479, 76, 24);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_5.setForeground(Color.white);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_5);
		
		
		//JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 750, 650);

		ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		contentPanel.add(fondo);
		
		
		
	}public void clearTxtField(JTextField text) {
		text.setText("");
		}
}

