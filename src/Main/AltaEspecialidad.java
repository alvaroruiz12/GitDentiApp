package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JDialog;

import BBDD.Conexion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaEspecialidad extends JDialog {

	private static final long serialVersionUID = 1L;
	Especialidad especialidad = new Especialidad();
	private JTextField textoNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			ArrayList<String> b = null;
			Conexion con = null;

			public void run() {
				try {
					AltaEspecialidad dialog = new AltaEspecialidad(b, con, null, true);
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
	public AltaEspecialidad(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		Conexion conexion = con;

		JButton btnVolver = new JButton("VOLVER");

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(319, 11, 105, 50);
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

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(36, 131, 200, 50);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.white);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(123, 101, 46, 14);
		getContentPane().add(lblNewLabel);

		textoNombre = new JTextField();
		textoNombre.setBounds(206, 98, 86, 20);
		getContentPane().add(textoNombre);
		textoNombre.setColumns(10);

		JButton btnInsertar = new JButton("AÑADIR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textoNombre.getText().toString().isEmpty()) {
					String sentencia = "INSERT into especialidad (nombre_especialidad)" + " values ('"
							+ textoNombre.getText().toString() + "')";

					boolean status = false;
					status = conexion.insertar(conexion, sentencia);

					JOptionPane.showMessageDialog(null, "Insertado con exito", "", JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "Introduce un nombre", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnInsertar.setBounds(319, 200, 105, 50);
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
		fondo.setBounds(0, 0, 600, 400);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		getContentPane().add(fondo);

	}
}
