package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class AltaEspecialidad extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nombreEspecialidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> b = null;
		Conexion con = null;
		try {
			AltaEspecialidad dialog = new AltaEspecialidad(b,con,null,true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaEspecialidad(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		Conexion conexion = con;

		setBounds(100, 100, 450, 300);
		
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		labelNombre.setForeground(Color.white);

		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setBounds(27, 109, 127, 24);
		getContentPane().add(labelNombre);
		
		nombreEspecialidad = new JTextField();
		nombreEspecialidad.setBounds(164, 109, 127, 25);
		getContentPane().add(nombreEspecialidad);
		nombreEspecialidad.setColumns(10);
		
		 //BOTON DE ELIMINAR
		JButton btnInsertar = new JButton("INSERTAR");
		
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre=nombreEspecialidad.getText().toString();
				String consulta= "INSERT INTO especialidad (nombre_especialidad) values ('"+nombre+"');";
				boolean status = false;

				status = conexion.insertar(conexion, consulta);

					}
		});
		btnInsertar.setBounds(307, 216, 127, 45);
		ImageIcon imagen= new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(btnInsertar.getWidth(), btnInsertar.getHeight(), Image.SCALE_SMOOTH));
       
		// Establecer el texto sobre la imagen
		btnInsertar.setHorizontalTextPosition(SwingConstants.CENTER);
       btnInsertar.setVerticalTextPosition(SwingConstants.CENTER);

       // Personalizar el estilo del texto
       btnInsertar.setForeground(Color.WHITE); // Color del texto
       btnInsertar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		btnInsertar.setIcon(imagen2);
       
       
       // Eliminar el borde del botón para que la imagen sea visible
       btnInsertar.setBorderPainted(false);
       btnInsertar.setContentAreaFilled(false);
		getContentPane().add(btnInsertar);
		
		//boton para volver a inicio
		JButton btnVolver = new JButton("VOLVER");
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(329, 0, 105, 50);
		ImageIcon imagen3= new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen4= new ImageIcon(imagen.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
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
		getContentPane().add(btnVolver);
		 
		
		
		//fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 434, 261);
		ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		getContentPane().setLayout(null);
		fondo.setIcon(imagen6);
		getContentPane().add(fondo);
		

		
	}
}
