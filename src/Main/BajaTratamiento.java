package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import BBDD.Conexion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class BajaTratamiento extends JDialog {

	private static final long serialVersionUID = 1L;
	Tratamiento tratamiento= new Tratamiento();
	private JTextField NombreTexto;
	private JTextField CosteTexto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<String> b = null;
				Conexion con = null;
				try {
					BajaTratamiento dialog = new BajaTratamiento(b, con, null, true);
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
	public BajaTratamiento(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		Conexion conexion=con;
		ArrayList<String> nombre=tratamiento.CargarNombreTratamiento();
		ArrayList<String> id=tratamiento.CargarNumeroTratamiento();
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(75, 161, 46, 14);
		getContentPane().add(lblNombre);
		
		JComboBox comboNombre = new JComboBox();
		comboNombre.setBounds(166, 151, 229, 30);
		for (int i = 0; i < nombre.size(); i++) {
			comboNombre.addItem(nombre.get(i).toString());
		}
		getContentPane().add(comboNombre);
		
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

		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// comprobacion doctor
				String numTra="";
				int nTra=0;
				for (int i = 0; i < nombre.size(); i++) {
					String nomTratamiento = nombre.get(i).toString();
					if (nomTratamiento.equals(comboNombre.getSelectedItem().toString())) {
						numTra = id.get(i).toString();
						 nTra = Integer.parseInt(numTra);

					}
				}
				boolean bien=true;
				String consulta = "DELETE FROM tratamientos WHERE idtratamiento= " + nTra;
				try {
					conexion.ejecutarInsertDeleteUpdate(consulta);
					ArrayList<String> nombreEspecialidad = tratamiento.CargarNombreTratamiento();
					for (int i = 0; i < nombreEspecialidad.size(); i++) {
						comboNombre.addItem(nombreEspecialidad.get(i).toString());
					}
					
					JOptionPane.showMessageDialog(
			                null, // Componente padre (en este caso, null para el componente principal)
			                "Se ha borrado correctamente", // Mensaje de error
			                "Correcto", // Título del JOptionPane
			                JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje (en este caso, ERROR_MESSAGE)
			        );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					 JOptionPane.showMessageDialog(
				                null, // Componente padre (en este caso, null para el componente principal)
				                "No se ha podido borrar", // Mensaje de error
				                "Error", // Título del JOptionPane
				                JOptionPane.ERROR_MESSAGE // Tipo de mensaje (en este caso, ERROR_MESSAGE)
				        );
					 bien=false;
				}
				if (bien==true) {
					dispose();
				}
			}
		});
		btnEliminar.setBounds(319, 218, 105, 32);
		ImageIcon imagen56 = new ImageIcon(
				imagen3.getImage().getScaledInstance(btnEliminar.getWidth(), btnEliminar.getHeight(), Image.SCALE_SMOOTH));
		btnEliminar.setIcon(imagen56);

		// Eliminar el borde del botón para que la imagen sea visible
		btnEliminar.setBorderPainted(false);
		btnEliminar.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnEliminar.setForeground(Color.WHITE); // Color del texto
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		getContentPane().add(btnEliminar);
		
		
		
		

	}
}
