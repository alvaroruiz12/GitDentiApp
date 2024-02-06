package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JDialog;

import BBDD.Conexion;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarEspecialidad extends JDialog {
	private String id="";
	private int nid=0;
	private static final long serialVersionUID = 1L;
	Especialidad especialidad = new Especialidad();
	private JTextField txNombre;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			ArrayList<String> b = null;
			Conexion con = null;
			public void run() {
				try {
					ModificarEspecialidad dialog = new ModificarEspecialidad(b, con, null, true);
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
	public ModificarEspecialidad(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		ArrayList <String> nombreEspecialidad=especialidad.CargarNombreEspecialidad();
		ArrayList <String> idEspecialidad=especialidad.CargarNumeroEspecialidad();
		Conexion conexion=con;
		txNombre = new JTextField();
		txNombre.setBounds(178, 174, 195, 29);
		getContentPane().add(txNombre);
		txNombre.setColumns(10);
		
		JButton btnVolver = new JButton("VOLVER");

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(469, 11, 105, 50);
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

		
		
		JComboBox comboNombre = new JComboBox();
		comboNombre.setBounds(104, 103, 195, 29);
		getContentPane().add(comboNombre);
		
		// mete los nombres en el combobox
		for (int i = 0; i < nombreEspecialidad.size(); i++) {
			comboNombre.addItem(nombreEspecialidad.get(i).toString());
		}

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(47, 172, 86, 26);
		labelNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		labelNombre.setForeground(Color.white);
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelNombre);
		JButton btnRellenar = new JButton("Rellenar");
		btnRellenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nEspecialidad="";
				
				for (int i = 0; i < nombreEspecialidad.size(); i++) {
					 nEspecialidad = nombreEspecialidad.get(i).toString();
					if (nEspecialidad.equals(comboNombre.getSelectedItem().toString())) {
						id = idEspecialidad.get(i);
						nid=Integer.parseInt(id);
						txNombre.setText(nEspecialidad);
					}	
				}
			}
		});
		btnRellenar.setBounds(337, 90, 147, 50);
		btnRellenar.setIcon(imagen4);

		// Eliminar el borde del botón para que la imagen sea visible
		btnRellenar.setBorderPainted(false);
		btnRellenar.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnRellenar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRellenar.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnRellenar.setForeground(Color.WHITE); // Color del texto
		btnRellenar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		getContentPane().add(btnRellenar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sentencia = "UPDATE dentiapp.especialidad " +
                        "SET nombre_especialidad='" + txNombre.getText().toString() + "'" +
                        		 " WHERE idespecialidad="+id+";";            			
        		boolean status = false;
        		System.out.println(sentencia);
    			status = conexion.insertar(conexion,sentencia);
    			if (status=true) {
    			dispose();	
    			}
			}
		});
		btnModificar.setBounds(469, 313, 105, 37);
		btnModificar.setIcon(imagen4);

		// Eliminar el borde del botón para que la imagen sea visible
		btnModificar.setBorderPainted(false);
		btnModificar.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificar.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnModificar.setForeground(Color.WHITE); // Color del texto
		btnModificar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		getContentPane().add(btnModificar);
		
		
		// JLabel de fondo
				JLabel fondo = new JLabel();
				fondo.setBounds(0, 0, 600, 400);

				ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
				ImageIcon imagen6 = new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
				fondo.setIcon(imagen6);
				getContentPane().add(fondo);
	
	}
}
