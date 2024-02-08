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

public class PacienteModificar extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfCorreo;
	private JTextField tfTelefono;
	private JTextField tfEdad;
	Paciente paciente = new Paciente();

	private String stf1 = "Introduzca nombre", stf2 = "Introduzca apellido", stf3 = "Introduzca DNI",
			stf4 = "Introduzca correo", stf5 = "Introduzca telefono", stf6 = "Introduzca edad";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ArrayList<String> b = null;
		Conexion con = null;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					PacienteModificar modificar = new PacienteModificar(b, con, null, true);
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
	public PacienteModificar(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
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

		// DISEÑO

		// PRIMERA SELECCION



		// SEGUNDA SELECCION
		// text field apellidos
		tfNombre = new JTextField();
		tfNombre.setForeground(new Color(192, 192, 192));
		tfNombre.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfNombre.setBounds(187, 304, 189, 30);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);

		JLabel lblFotoUser = new JLabel();
		lblFotoUser.setBounds(154, 72, 120, 120);
		ImageIcon imagen = new ImageIcon(getClass().getResource("user.png"));
		ImageIcon imagen2 = new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(),
				lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
		lblFotoUser.setIcon(imagen2);
		contentPane.add(lblFotoUser);

		JButton btnVolver = new JButton("VOLVER");

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(969, 11, 105, 50);
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
		contentPane.add(btnVolver);
		
		tfApellido = new JTextField();
		tfApellido.setForeground(new Color(192, 192, 192));
		tfApellido.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfApellido.setBounds(187, 360, 189, 30);
		contentPane.add(tfApellido);
		tfApellido.setColumns(10);

		tfCorreo = new JTextField();
		tfCorreo.setForeground(new Color(192, 192, 192));
		tfCorreo.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfCorreo.setBounds(187, 418, 189, 30);
		contentPane.add(tfCorreo);
		tfCorreo.setColumns(10);

		tfTelefono = new JTextField();
		tfTelefono.setForeground(new Color(192, 192, 192));
		tfTelefono.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfTelefono.setBounds(187, 465, 189, 30);
		contentPane.add(tfTelefono);
		tfTelefono.setColumns(10);

		tfEdad = new JTextField();
		tfEdad.setForeground(new Color(192, 192, 192));
		tfEdad.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfEdad.setBounds(187, 518, 189, 30);
		contentPane.add(tfEdad);
		tfEdad.setColumns(10);

	

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(407, 169, 629, 326);
		scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
		getContentPane().add(scrollPane);

		// Personalizo la tabla
		JTable table_1 = new JTable();
		// desactiva la la tabla para que no se pueda cambiar
		table_1.setEnabled(false);
		// objeto para editar encabezado
		JTableHeader header = table_1.getTableHeader();
		header.setForeground(Color.black);
		header.setFont(new Font("Arial", Font.PLAIN, 20));

		header.setBackground(new Color(207, 241, 255));
		table_1.setIntercellSpacing(new Dimension(4, 4));
		// ajusta el alto de las columnas de la tabla
		table_1.setRowHeight(30);
		// Cambia el color de fondo de las filas seleccionadas
		table_1.setSelectionBackground(new Color(217, 217, 217));
		table_1.setSelectionForeground(Color.BLACK);
		DefaultTableModel model;
		table_1.setModel(model = new DefaultTableModel(new Object[][] {},
				new String[] { "DNIpaciente", "Nombre", "Apellidos", "Correo", "Telefono", "Edad" }));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);
		paciente.CargarTabla(model, table_1);

		
		JLabel labelDNI = new JLabel("DNI");
		labelDNI.setBounds(34, 241, 100, 30);
		labelDNI.setFont(new Font("Arial", Font.PLAIN, 20));
		labelDNI.setForeground(Color.white);
		labelDNI.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelDNI);
		
		
		// funcion buscar
		JTextField textoNombre = new JTextField();
		textoNombre.setBounds(407, 107, 150, 30);
		getContentPane().add(textoNombre);
		textoNombre.setColumns(10);

		JTextField textoApellidos = new JTextField();
		textoApellidos.setBounds(567, 107, 290, 30);
		getContentPane().add(textoApellidos);
		textoApellidos.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(407, 66, 150, 30);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.white);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(567, 66, 290, 30);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.white);

		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_1);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> datos = paciente.BuscarPacienteModificar(textoNombre.getText().toString(),
						textoApellidos.getText().toString());
				String DNI = paciente.BuscarPaciente(textoNombre.getText().toString(),
						textoApellidos.getText().toString());

				
				//cambio de color a negro
				tfNombre.setForeground(Color.BLACK);
				tfApellido.setForeground(Color.BLACK);
				tfCorreo.setForeground(Color.BLACK);
				tfTelefono.setForeground(Color.BLACK);
				tfEdad.setForeground(Color.BLACK);
				
				//relleno de datos con la busqueda
				labelDNI.setText(datos.get(0));
				tfNombre.setText(textoNombre.getText().toString());
				tfApellido.setText(textoApellidos.getText().toString());
				tfCorreo.setText(datos.get(1));
				tfTelefono.setText(datos.get(2));
				tfEdad.setText(datos.get(3));

			}
		});
		btnBuscar.setBounds(936, 107, 100, 30);

		getContentPane().add(btnBuscar);

		// BOTON FUNCIONALIDAD

		JButton btnAnadir = new JButton("Modificar");
		btnAnadir.setBounds(407, 517, 629, 30);
		contentPane.add(btnAnadir);
		btnAnadir.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnAnadir.setForeground(new Color(0, 0, 0));
		btnAnadir.setBackground(new Color(207, 241, 255));
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = labelDNI.getText();
				String apellido = tfApellido.getText();
				String nombre = tfNombre.getText();
				String correo = tfCorreo.getText();
				int telefono = Integer.parseInt(tfTelefono.getText());
				int edad = Integer.parseInt(tfEdad.getText());
				String sentencia = "UPDATE dentiapp.pacientes " + "SET nombre_paciente='" + nombre + "', " + "apellido_paciente='"
						+ apellido + "', " + "correo='" + correo + "', " + "telefono=" + telefono + ", " + "edad="
						+ edad + " " + "WHERE DNIpaciente='" + dni + "';";
				boolean status = false;
				status = conexion.actualizar(conexion, sentencia);
				if (status = true) {

				}
				table_1.removeAll();
				paciente.CargarTabla(model, table_1);
			}
		});

		

		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(34, 304, 100, 30);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Apellidos");
		lblNewLabel_4.setBounds(34, 360, 100, 30);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(Color.white);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Correo");
		lblNewLabel_5.setBounds(34, 418, 100, 30);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_5.setForeground(Color.white);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono");
		lblNewLabel_6.setBounds(34, 465, 100, 30);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_6.setForeground(Color.white);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Edad");
		lblNewLabel_7.setBounds(34, 518, 100, 30);
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_7.setForeground(Color.white);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_7);

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
