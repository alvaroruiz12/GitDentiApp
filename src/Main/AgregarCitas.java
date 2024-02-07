package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

import BBDD.Conexion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.print.attribute.AttributeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AgregarCitas extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField txPacientes;
	private JTextField txObservaciones;
	Date hoy = new Date();
	Tratamiento tratamiento = new Tratamiento();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<String> b = null;
				Conexion con = null;
				try {
					AgregarCitas dialog = new AgregarCitas(b, con, null, true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setResizable(false); // para que no se pueda cambiar de tamaño
					dialog.setLocationRelativeTo(null); // Para que nuestra ventana aparezca siempre en la mitad de la
														// pantalla.

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public AgregarCitas(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {

		super(parent, modal);

		ArrayList<String> usuario = a;
		Conexion conexion = con;
		Doctor doctor = new Doctor();

		Paciente paciente = new Paciente();

		setBounds(200, 150, 1100, 650);
		getContentPane().setLayout(null);
		// labels
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(36, 69, 200, 50);
		lblHora.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHora.setForeground(Color.white);

		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblHora);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(36, 131, 200, 50);
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFecha.setForeground(Color.white);

		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFecha);

		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(36, 191, 200, 50);
		lblDoctor.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDoctor.setForeground(Color.white);

		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDoctor);

		

		JLabel lblTratamientos = new JLabel("Tratamientos");
		lblTratamientos.setBounds(36, 262, 200, 50);
		lblTratamientos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTratamientos.setForeground(Color.white);

		lblTratamientos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTratamientos);

		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(36, 384, 200, 50);
		lblObservaciones.setFont(new Font("Arial", Font.PLAIN, 20));
		lblObservaciones.setForeground(Color.white);

		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblObservaciones);

		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setBounds(36, 323, 200, 50);
		lblPacientes.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPacientes.setForeground(Color.white);
		lblPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPacientes);

	

		txPacientes = new JTextField();
		txPacientes.setBounds(246, 336, 150, 30);
		getContentPane().add(txPacientes);
		txPacientes.setColumns(10);

		txObservaciones = new JTextField();
		txObservaciones.setBounds(246, 384, 236, 154);
		getContentPane().add(txObservaciones);
		txObservaciones.setColumns(10);
		// combobox tratamientos

		JComboBox cbTratamientos = new JComboBox();
		cbTratamientos.setBounds(246, 275, 150, 30);
		getContentPane().add(cbTratamientos);

		// relleno

		ArrayList<String> nombreTratamiento = tratamiento.CargarNombreTratamiento();
		ArrayList<String> nTratamiento = tratamiento.CargarNumeroTratamiento();

		for (int i = 0; i < nombreTratamiento.size(); i++) {
			cbTratamientos.addItem(nombreTratamiento.get(i).toString());
		}
		
		ArrayList<String> NombreTratamiento=tratamiento.CargarNombreTratamiento();
		ArrayList<String> NumTratamiento=tratamiento.CargarNumeroTratamiento();
		
		for (int i = 0; i < NombreTratamiento.size(); i++) {
			cbTratamientos.addItem(NombreTratamiento.get(i).toString());
		}
		// formato se aplica en el boton
		SimpleDateFormat formatoBBDD = new SimpleDateFormat("dd-MM-yyyy");

		// calendar
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(246, 137, 150, 30);
		dateChooser.setMinSelectableDate(hoy);

		getContentPane().add(dateChooser);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(561, 82, 439, 437);
		scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
		getContentPane().add(scrollPane);
//tabla pacientes
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
				new String[] { "DNIpaciente", "Nombre", "Apellidos" }));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);
		paciente.CargarTabla(model, table_1);

		// combobox hora

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(246, 81, 150, 30);
		getContentPane().add(comboBox);

		for (int hour = 9; hour <= 20; hour++) {
			for (int minute = 0; minute < 60; minute += 30) {
				String formattedHour = String.format("%02d:%02d", hour, minute);
				comboBox.addItem(formattedHour);
			}
		}

		JButton btnVolver = new JButton("VOLVER");

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(966, 7, 105, 50);
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

		// combobox doctor
		JComboBox comboBoxDoctor = new JComboBox();
		// cargar datos al combobox

		// esto da null

		int tamañoNombre = 0;
		// metodo recoge el nombre y el dni

		ArrayList<String> Dni=doctor.CargarDNIDoctorCitas();
		ArrayList<String> Nombre=doctor.CargarNombreDoctorCitas();

		System.out.println(Nombre);
		// mete los nombres en el combobox
		for (int i = 0; i < Nombre.size(); i++) {
			comboBoxDoctor.addItem(Nombre.get(i).toString());
		}

		comboBoxDoctor.setBounds(239, 203, 157, 33);
		getContentPane().add(comboBoxDoctor);
		// añadir doctor

		// boton insertar
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fecha = formatoBBDD.format(dateChooser.getDate());
				String horadeverdad = (String) comboBox.getSelectedItem();
				String doc = "";
				String numTratamiento;
				int NumeroTratamiento = 0;
				// comprobacion tratamiento
				for (int i = 0; i < nombreTratamiento.size(); i++) {
					String nomTra = nombreTratamiento.get(i).toString();

					if (nomTra.equals(cbTratamientos.getSelectedItem().toString())) {
						
						 numTratamiento = nTratamiento.get(i);

						NumeroTratamiento=Integer.parseInt(numTratamiento);
						
					}
				}
				// comprobacion doctor
				String numTra="";
				int nTra=0;
				for (int i = 0; i < NombreTratamiento.size(); i++) {
					String nomTratamiento = NombreTratamiento.get(i).toString();
					if (nomTratamiento.equals(cbTratamientos.getSelectedItem().toString())) {
						numTra = NumTratamiento.get(i).toString();
						 nTra = Integer.parseInt(numTra);

					}
				}
				
				for (int i = 0; i < Nombre.size(); i++) {

					String nomDoc = Nombre.get(i).toString();
					if (nomDoc.equals(comboBoxDoctor.getSelectedItem().toString())) {
						doc = Dni.get(i);

					}
				}
				int pagosId = 0;
				// declaracion de variables
				int tratamientosId = 0;
				

				
				
				
				
				// comprobaciones
				String dnipaciente = txPacientes.getText();
				if (dnipaciente.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe un DNI en pacientes", "Error",
							JOptionPane.ERROR_MESSAGE);
				}


				if (fecha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Introduce una fecha", "Error", JOptionPane.ERROR_MESSAGE);

				}
				String observaciones = txObservaciones.getText();
				if (observaciones.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe un observacion", "Error", JOptionPane.ERROR_MESSAGE);
				}
				boolean comprobarDoctor = con.comprobarCitasDoctor(horadeverdad, fecha, doc);
				boolean comprobarPaciente = con.comprobarCitasPaciente(horadeverdad, fecha,
						doc);
				System.out.print(comprobarDoctor);
				System.out.print(comprobarPaciente);
				if (comprobarDoctor == false && comprobarPaciente == false) {
					// sentencia sql
					String sentencia = "INSERT into citas (hora,fecha,"
							+ "observaciones_cita,DNIpaciente,idtratamiento,DNIdoctor)values('" + horadeverdad + "'," + "'"
							+ fecha + "' ,'"
							+ txObservaciones.getText().toString() + "','" + txPacientes.getText().toString()
							+ "', "+ NumeroTratamiento +" ,'" + doc + "')";


					boolean status = false;
					status = conexion.insertar(conexion, sentencia);
				} else {
					JOptionPane.showMessageDialog(null, "Ya existe una cita con ese doctor o ese paciente a esa hora",
							"Error", JOptionPane.ERROR_MESSAGE);

				}

			}

		});
		btnInsertar.setBounds(966, 530, 108, 70);
		ImageIcon imagen = new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen2 = new ImageIcon(imagen.getImage().getScaledInstance(btnInsertar.getWidth(),
				btnInsertar.getHeight(), Image.SCALE_SMOOTH));

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

		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1100, 650);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		getContentPane().add(fondo);

	}
}
