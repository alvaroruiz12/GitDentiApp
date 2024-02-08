package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.util.Date;

import com.toedter.calendar.JDateChooser;

import BBDD.Conexion;

public class EditarCitas extends JDialog {
	String idcitas = "";
	private static final long serialVersionUID = 1L;
	private JTextField txObservaciones;
	private JTable table_1;

	DefaultTableModel model;
	Citas citas = new Citas();
	Doctor doctor = new Doctor();
	private JTextField textoNombre;
	private JTextField textoApellidos;
	Date hoy = new Date();
	Paciente paciente= new Paciente();
	Tratamiento tratamiento= new Tratamiento();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<String> b = null;
				Conexion con = null;
				try {
					EditarCitas dialog = new EditarCitas(b, con, null, true);
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
	public EditarCitas(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		setBounds(100, 100, 1100, 650);
		Conexion conexion=con;
		
		JComboBox comboHora = new JComboBox();
		comboHora.setBounds(237, 104, 150, 30);
		getContentPane().add(comboHora);

		for (int hour = 9; hour <= 20; hour++) {
			for (int minute = 0; minute < 60; minute += 30) {
				String formattedHour = String.format("%02d:%02d", hour, minute);
				comboHora.addItem(formattedHour);
			}
		}
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(27, 91, 200, 50);
		lblHora.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHora.setForeground(Color.white);

		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblHora);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(27, 152, 200, 50);
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFecha.setForeground(Color.white);

		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFecha);

		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(27, 213, 200, 50);
		lblDoctor.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDoctor.setForeground(Color.white);

		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDoctor);

		JLabel lblTratamientos = new JLabel("Tratamientos");
		lblTratamientos.setBounds(37, 274, 200, 50);
		lblTratamientos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTratamientos.setForeground(Color.white);

		lblTratamientos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTratamientos);

		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(37, 396, 200, 50);
		lblObservaciones.setFont(new Font("Arial", Font.PLAIN, 20));
		lblObservaciones.setForeground(Color.white);

		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblObservaciones);

		JLabel txPaciente = new JLabel("Paciente");
		txPaciente.setBounds(217, 335, 200, 50);
		txPaciente.setFont(new Font("Arial", Font.PLAIN, 20));
		txPaciente.setForeground(Color.white);
		txPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txPaciente);

		txObservaciones = new JTextField();
		txObservaciones.setBounds(237, 396, 200, 80);
		getContentPane().add(txObservaciones);
		txObservaciones.setColumns(10);

// combobox tratamientos

		// combobox doctor
		JComboBox comboBoxDoctor = new JComboBox();
		// cargar datos al combobox

		// esto da null

		int tamañoNombre = 0;
		// metodo recoge el nombre y el dni

		ArrayList<String> Dni = doctor.CargarDNIDoctorCitas();
		ArrayList<String> Nombre = doctor.CargarNombreDoctorCitas();

		System.out.println(Nombre);
		// mete los nombres en el combobox
		for (int i = 0; i < Nombre.size(); i++) {
			comboBoxDoctor.addItem(Nombre.get(i).toString());
		}

		comboBoxDoctor.setBounds(237, 228, 150, 30);
		getContentPane().add(comboBoxDoctor);

		JComboBox cbTratamientos = new JComboBox();
		cbTratamientos.setBounds(237, 287, 150, 30);
		
		getContentPane().add(cbTratamientos);
		ArrayList<String> NombreTratamiento=tratamiento.CargarNombreTratamiento();
		ArrayList<String> NumTratamiento=tratamiento.CargarNumeroTratamiento();
		
		for (int i = 0; i < NombreTratamiento.size(); i++) {
			cbTratamientos.addItem(NombreTratamiento.get(i).toString());
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(469, 104, 583, 363);
		scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
		getContentPane().add(scrollPane);

		// Personalizo la tabla
		table_1 = new JTable();
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
		table_1.setModel(model = new DefaultTableModel(new Object[][] {},
				new String[] { "Hora", "Fecha", "DNI paciente", "DNI doctor", "Observaciones" }));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);

		citas.CargarTablaDoctor(model, table_1);

		// boton volver
		JButton btnVolver = new JButton("VOLVER");

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(10, 18, 105, 50);
		ImageIcon imagen3 = new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen4 = new ImageIcon(
				imagen3.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
		getContentPane().setLayout(null);
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

		// formato se aplica en el boton
		SimpleDateFormat formatoBBDD = new SimpleDateFormat("dd-MM-yyyy");

		// calendar
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(237, 163, 150, 30);
		dateChooser.setMinSelectableDate(hoy);

		getContentPane().add(dateChooser);

		// BOTON EDITAR
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fecha = formatoBBDD.format(dateChooser.getDate());

				int pagosId = 0;
				// declaracion de variables
				String numTratamiento="";
				int NumeroTratamiento=0;
				for (int i = 0; i < NombreTratamiento.size(); i++) {
					String nomTra = NombreTratamiento.get(i).toString();

					if (nomTra.equals(cbTratamientos.getSelectedItem().toString())) {
						
						 numTratamiento = NumTratamiento.get(i);

						NumeroTratamiento=Integer.parseInt(numTratamiento);
						
					}
				}

				
				String doc = "";
				for (int i = 0; i < Nombre.size(); i++) {

					String nomDoc = Nombre.get(i).toString();
					if (nomDoc.equals(comboBoxDoctor.getSelectedItem().toString())) {
						doc = Dni.get(i);

					}
				}
				String hora = comboHora.getSelectedItem().toString();
				String pacientes = txPaciente.getText().toString();
				String observaciones = txObservaciones.getText().toString();
				if (hora.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe una hora", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (fecha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe una fecha", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (pacientes.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe un DNI de paciente", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				if (observaciones.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe un observacion", "Error", JOptionPane.ERROR_MESSAGE);
				}
				String sentencia="UPDATE dentiapp.citas set hora='"+hora+"',"
						+ " fecha='"+fecha+"', observaciones_cita='"+observaciones+"', "
								+ "DNIpaciente='"+pacientes+"', idtratamiento="+NumeroTratamiento+","
										+ " DNIdoctor='"+doc+"' WHERE idcitas="+idcitas+";";
				System.out.println(sentencia);
				boolean status = false;
				status = conexion.actualizar(conexion, sentencia);
				if (status = true) {

				}
				model.setRowCount(0);
				citas.CargarTabla(model, table_1);

			}
		});
		btnEditar.setBounds(966, 550, 105, 50);
		getContentPane().setLayout(null);
		btnEditar.setIcon(imagen4);

		// Eliminar el borde del botón para que la imagen sea visible
		btnEditar.setBorderPainted(false);
		btnEditar.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditar.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnEditar.setForeground(Color.WHITE); // Color del texto
		btnEditar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		getContentPane().add(btnEditar);
		getContentPane().add(btnEditar);

		JLabel lblNewLabel = new JLabel("Apellidos");
		lblNewLabel.setBounds(595, 27, 150, 30);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);

		textoNombre = new JTextField();
		textoNombre.setBounds(474, 63, 100, 30);
		getContentPane().add(textoNombre);
		textoNombre.setColumns(10);

		textoApellidos = new JTextField();
		textoApellidos.setBounds(595, 63, 150, 30);
		getContentPane().add(textoApellidos);
		textoApellidos.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(476, 29, 105, 30);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_1);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(766, 63, 150, 30);

		getContentPane().add(dateChooser_1);

		JButton btnRellenar = new JButton("Rellenar");
		btnRellenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fecha1 = formatoBBDD.format(dateChooser_1.getDate());
				String DNI=paciente.BuscarPaciente(textoNombre.getText().toString(), textoApellidos.getText().toString());

				ArrayList<String> datos = citas.CargarDatos(DNI, fecha1);
				   String date = datos.get(2);
				   java.util.Date date2 = null;
				try {
					date2 = new SimpleDateFormat("dd-MM-yyy").parse(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				   dateChooser.setDate(date2);

				System.out.println(datos);
				txPaciente.setText(datos.get(3));
				txObservaciones.setText(datos.get(5));
				idcitas = datos.get(0);

			}
		});
		btnRellenar.setBounds(939, 67, 89, 23);
		getContentPane().add(btnRellenar);

		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1100, 650);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		getContentPane().add(fondo);

	}
}
