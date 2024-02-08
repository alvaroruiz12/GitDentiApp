package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BBDD.Conexion;

public class TratamientosModificar extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tftratamiento;
	private JTextField tfCoste;
	private JTextField tfNombre;
	Tratamiento tratamiento = new Tratamiento();
	String numTratamiento = "";
	int NumeroTratamiento = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ArrayList<String> b = null;
		Conexion con = null;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TratamientosModificar modificar = new TratamientosModificar(b, con, null, true);
					// metodo para que la pantalla sea en pantalla completa

					modificar.setVisible(true);
					modificar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TratamientosModificar(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		super(parent, modal);

		ArrayList<String> usuario = a;
		Conexion conexion = con;

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 650);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// AÑADIR EN LA TABLA EL SELECCIONADO

		// combobox tratamientos

		JComboBox cbTratamientos = new JComboBox();
		cbTratamientos.setBounds(410, 116, 189, 30);
		getContentPane().add(cbTratamientos);

		// relleno

		ArrayList<String> nombreTratamiento = tratamiento.CargarNombreTratamiento();
		ArrayList<String> nTratamiento = tratamiento.CargarNumeroTratamiento();

		for (int i = 0; i < nombreTratamiento.size(); i++) {
			cbTratamientos.addItem(nombreTratamiento.get(i).toString());
		}

		// SEGUNDA SELECCION

		tfCoste = new JTextField();
		tfCoste.setForeground(new Color(192, 192, 192));
		tfCoste.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfCoste.setBounds(195, 303, 189, 30);
		contentPane.add(tfCoste);
		tfCoste.setColumns(10);

		JLabel lblFotoUser = new JLabel();
		lblFotoUser.setBounds(154, 72, 120, 120);
		ImageIcon imagen = new ImageIcon(getClass().getResource("user.png"));
		ImageIcon imagen2 = new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(),
				lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
		lblFotoUser.setIcon(imagen2);
		contentPane.add(lblFotoUser);
		ImageIcon i7 = new ImageIcon(getClass().getResource("volver.png"));

		tfNombre = new JTextField();
		tfNombre.setForeground(new Color(192, 192, 192));
		tfNombre.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfNombre.setBounds(195, 244, 189, 30);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 164, 560, 326);
		scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
		getContentPane().add(scrollPane);

		// Personalizo la tabla
		JTable table_1 = new JTable();
		// desactiva la la tabla para que no se pueda cambiar
		table_1.setEnabled(false);
		// objeto para editar encabezado
		JTableHeader header = table_1.getTableHeader();
		header.setForeground(Color.black);
		header.setBackground(new Color(207, 241, 255));
		header.setFont(new Font("Arial", Font.PLAIN, 20));

		table_1.setIntercellSpacing(new Dimension(4, 4));
		// ajusta el alto de las columnas de la tabla
		table_1.setRowHeight(30);
		// Cambia el color de fondo de las filas seleccionadas
		table_1.setSelectionBackground(new Color(217, 217, 217));
		table_1.setSelectionForeground(Color.BLACK);
		DefaultTableModel model;
		table_1.setModel(model = new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Coste" }));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);
		tratamiento.CargarTabla(model, table_1);

		// boton para volver a inicio
		JButton btnVolver = new JButton("VOLVER");

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(969, 15, 105, 50);
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

		// BOTON FUNCIONALIDAD

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(410, 513, 560, 30);
		contentPane.add(btnModificar);
		btnModificar.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnModificar.setForeground(new Color(0, 0, 0));
		btnModificar.setBackground(new Color(207, 241, 255));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				String nombre = tfNombre.getText();
				int Coste = Integer.parseInt(tfCoste.getText());
				String sentencia = "UPDATE dentiapp.tratamientos " + "SET " + "coste_tratamiento=" + Coste + ", "
						+ "nombre_tratamiento='" + nombre + "' " + "WHERE idtratamiento=" + NumeroTratamiento + ";";
				boolean status = false;
				status = conexion.insertar(conexion, sentencia);
				if (status = true) {

				}
				tratamiento.CargarTabla(model, table_1);
			}
		});

		JButton btnRellenar = new JButton("Rellenar");
		btnRellenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < nombreTratamiento.size(); i++) {
					String nomTra = nombreTratamiento.get(i).toString();

					if (nomTra.equals(cbTratamientos.getSelectedItem().toString())) {

						numTratamiento = nTratamiento.get(i);

						NumeroTratamiento = Integer.parseInt(numTratamiento);

					}
				}
				ArrayList<String> datos = tratamiento.CargarDatos(NumeroTratamiento);
				tfNombre.setText(datos.get(0));
				tfCoste.setText(datos.get(1));

			}
		});
		btnRellenar.setBounds(619, 116, 111, 30);
		btnRellenar.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnRellenar.setForeground(new Color(0, 0, 0));
		btnRellenar.setBackground(new Color(207, 241, 255));
		contentPane.add(btnRellenar);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(32, 244, 120, 30);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Coste");
		lblNewLabel_1.setBounds(32, 303, 120, 30);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel fondo = new JLabel();
		
		fondo.setBounds(0, 0, 1100, 650);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		contentPane.add(fondo);
		


	}

	public void clearTxtField(JTextField text) {
		text.setText("");
	}
}
