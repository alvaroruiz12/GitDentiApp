package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;

import BBDD.Conexion;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AltaTratamiento extends JDialog {
	Tratamiento tratamiento= new Tratamiento();
	private static final long serialVersionUID = 1L;
	private JTextField NombreTexto;
	private JTextField CosteTexto;
	Material material= new Material();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			ArrayList<String> b = null;
			Conexion con = null;
			public void run() {
				try {
					AltaTratamiento dialog = new AltaTratamiento(b, con, null, true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public AltaTratamiento(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(null);
		Conexion conexion = con;

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 72, 99, 24);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.white);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(10, 120, 99, 27);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.white);

		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Material");
		lblNewLabel_2.setBounds(10, 162, 99, 27);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.white);

		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_2);
		
		NombreTexto = new JTextField();
		NombreTexto.setBounds(119, 69, 100, 30);
		getContentPane().add(NombreTexto);
		NombreTexto.setColumns(10);
		
		CosteTexto = new JTextField();
		CosteTexto.setBounds(119, 117, 100, 30);
		getContentPane().add(CosteTexto);
		CosteTexto.setColumns(10);
		
		
		
		
		JComboBox comboMateriales = new JComboBox();
		
		
		ArrayList<String> idMaterial=material.CargarIDMaterial();
		ArrayList<String> Nombre=material.CargarNombreMateriales();

		System.out.println(Nombre);
		// mete los nombres en el combobox
		for (int i = 0; i < Nombre.size(); i++) {
			comboMateriales.addItem(Nombre.get(i).toString());
		}

		
		comboMateriales.setBounds(119, 159, 150, 30);
		getContentPane().add(comboMateriales);
		
		

		// boton para volver a inicio
				JButton btnVolver = new JButton("VOLVER");

				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnVolver.setBounds(369, 11, 105, 50);
				ImageIcon imagen3 = new ImageIcon(getClass().getResource("boton.png"));
				ImageIcon imagen4 = new ImageIcon(
						imagen3.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
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
		
		
				JButton btnInsertar = new JButton("INSERTAR");
				btnInsertar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// comprobacion doctor
						String numMaterial="";
						int nMaterial=0;
						for (int i = 0; i < Nombre.size(); i++) {
							String nomTratamiento = Nombre.get(i).toString();
							if (nomTratamiento.equals(comboMateriales.getSelectedItem().toString())) {
								numMaterial = idMaterial.get(i).toString();
								 nMaterial = Integer.parseInt(numMaterial);
							}
						}
						
						float precio=0;
						
						String sentencia="INSERT INTO tratamientos (coste_tratamiento,nombre_tratamiento,idmateriales)"
								+ " values ("+precio+",'"+NombreTexto.getText().toString()
								+"',"+nMaterial+")";
						
						boolean status = false;
						System.out.println(sentencia);
						status = conexion.insertar(conexion, sentencia);

						
					}
				});
				btnInsertar.setBounds(94, 203, 143, 50);
				btnInsertar.setIcon(imagen4);

				// Eliminar el borde del botón para que la imagen sea visible
				btnInsertar.setBorderPainted(false);
				btnInsertar.setContentAreaFilled(false);

				// Establecer el texto sobre la imagen
				btnInsertar.setHorizontalTextPosition(SwingConstants.CENTER);
				btnInsertar.setVerticalTextPosition(SwingConstants.CENTER);

				// Personalizar el estilo del texto
				btnInsertar.setForeground(Color.WHITE); // Color del texto
				btnInsertar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
				getContentPane().add(btnInsertar);
				
				
				JLabel fondo = new JLabel();
				fondo.setBounds(0, 0, 784, 461);

				ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
				ImageIcon imagen6 = new ImageIcon(
						imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
				fondo.setIcon(imagen6);
				getContentPane().add(fondo);
	}
}
