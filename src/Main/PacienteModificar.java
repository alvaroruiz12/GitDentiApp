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
	private JTextField tfDNI;
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

		tfDNI = new JTextField();
		tfDNI.setForeground(new Color(192, 192, 192));
		tfDNI.setText("Introduzca DNI");
		tfDNI.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfDNI.setBounds(124, 241, 189, 30);
		contentPane.add(tfDNI);
		tfDNI.setColumns(10);

		// SEGUNDA SELECCION
		// text field apellidos
		tfNombre = new JTextField();
		tfNombre.setForeground(new Color(192, 192, 192));
		tfNombre.setText("Introduzca Nombre");
		tfNombre.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfNombre.setBounds(124, 304, 189, 30);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);

		JLabel lblFotoUser = new JLabel();
		lblFotoUser.setBounds(154, 72, 120, 120);
		ImageIcon imagen = new ImageIcon(getClass().getResource("user.png"));
		ImageIcon imagen2 = new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(),
				lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
		lblFotoUser.setIcon(imagen2);
		contentPane.add(lblFotoUser);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(23, 10, 76, 64);
		btnVolver.setBackground(new Color(207, 241, 255));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		ImageIcon i7 = new ImageIcon(getClass().getResource("volver.png"));
		ImageIcon i8 = new ImageIcon(
				i7.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
		btnVolver.setIcon(i8);
		contentPane.add(btnVolver);

		tfApellido = new JTextField();
		tfApellido.setForeground(new Color(192, 192, 192));
		tfApellido.setText("Introduzca Apellido");
		tfApellido.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfApellido.setBounds(124, 360, 189, 30);
		contentPane.add(tfApellido);
		tfApellido.setColumns(10);

		tfCorreo = new JTextField();
		tfCorreo.setForeground(new Color(192, 192, 192));
		tfCorreo.setText("Introduzca correo electronico");
		tfCorreo.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfCorreo.setBounds(124, 418, 189, 30);
		contentPane.add(tfCorreo);
		tfCorreo.setColumns(10);

		tfTelefono = new JTextField();
		tfTelefono.setForeground(new Color(192, 192, 192));
		tfTelefono.setText("Introduzca el telefono");
		tfTelefono.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfTelefono.setBounds(124, 465, 189, 30);
		contentPane.add(tfTelefono);
		tfTelefono.setColumns(10);

		tfEdad = new JTextField();
		tfEdad.setForeground(new Color(192, 192, 192));
		tfEdad.setText("Introduzca edad");
		tfEdad.setFont(new Font("Calibri", Font.PLAIN, 15));
		tfEdad.setBounds(124, 518, 189, 30);
		contentPane.add(tfEdad);
		tfEdad.setColumns(10);

		// -----------------------Para que desaparezca y aparezca cuando este
		// vacio----------------

		tfDNI.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				tfDNI.setText("");
				tfDNI.setForeground(new Color(0, 0, 0));

			}

		});

		tfDNI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (tfDNI.getText().isEmpty()) {

					tfDNI.setText(stf1);
					tfDNI.setForeground(new Color(192, 192, 192));

				}
			}
		});
		tfNombre.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				tfNombre.setText("");
				tfNombre.setForeground(new Color(0, 0, 0));

			}

		});

		tfNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (tfNombre.getText().isEmpty()) {

					tfNombre.setText(stf2);
					tfNombre.setForeground(new Color(192, 192, 192));
				}
			}
		});

		tfApellido.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				tfApellido.setText("");

				tfApellido.setForeground(new Color(0, 0, 0));

			}

		});

		tfApellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (tfApellido.getText().isEmpty()) {

					tfApellido.setText(stf3);
					tfApellido.setForeground(new Color(192, 192, 192));
				}
			}
		});
		tfCorreo.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				tfCorreo.setText("");
				tfCorreo.setForeground(new Color(0, 0, 0));

			}

		});

		tfCorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (tfCorreo.getText().isEmpty()) {

					tfCorreo.setText(stf4);
					tfCorreo.setForeground(new Color(192, 192, 192));
				}
			}
		});
		tfTelefono.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				tfTelefono.setText("");
				tfTelefono.setForeground(new Color(0, 0, 0));

			}

		});

		tfTelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (tfTelefono.getText().isEmpty()) {

					tfTelefono.setText(stf5);
					tfTelefono.setForeground(new Color(192, 192, 192));
				}
			}
		});
		tfEdad.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				tfEdad.setText("");
				tfEdad.setForeground(new Color(0, 0, 0));
			}

		});

		tfEdad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (tfEdad.getText().isEmpty()) {

					tfEdad.setText(stf6);
					tfEdad.setForeground(new Color(192, 192, 192));
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(407, 169, 560, 326);
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
				tfDNI.setForeground(Color.BLACK);
				tfNombre.setForeground(Color.BLACK);
				tfApellido.setForeground(Color.BLACK);
				tfCorreo.setForeground(Color.BLACK);
				tfTelefono.setForeground(Color.BLACK);
				tfEdad.setForeground(Color.BLACK);
				
				//relleno de datos con la busqueda
				tfDNI.setText(datos.get(0));
				tfNombre.setText(textoNombre.getText().toString());
				tfApellido.setText(textoApellidos.getText().toString());
				tfCorreo.setText(datos.get(1));
				tfTelefono.setText(datos.get(2));
				tfEdad.setText(datos.get(3));

			}
		});
		btnBuscar.setBounds(867, 107, 100, 30);
		getContentPane().add(btnBuscar);

		// BOTON FUNCIONALIDAD

		JButton btnAnadir = new JButton("Modificar");
		btnAnadir.setBounds(407, 517, 560, 30);
		contentPane.add(btnAnadir);
		btnAnadir.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnAnadir.setForeground(new Color(0, 0, 0));
		btnAnadir.setBackground(new Color(207, 241, 255));
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = tfDNI.getText();
				String apellido = tfApellido.getText();
				String nombre = tfNombre.getText();
				String correo = tfCorreo.getText();
				int telefono = Integer.parseInt(tfTelefono.getText());
				int edad = Integer.parseInt(tfEdad.getText());
				String sentencia = "UPDATE dentiapp.pacientes " + "SET nombre_paciente='" + nombre + "', " + "apellido_pacie='"
						+ apellido + "', " + "correo='" + correo + "', " + "telefono=" + telefono + ", " + "edad="
						+ edad + " " + "WHERE DNIpaciente='" + dni + "';";
				boolean status = false;
				status = conexion.actualizar(conexion, sentencia);
				if (status = true) {

				}
				paciente.CargarTabla(model, table_1);
			}
		});

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
