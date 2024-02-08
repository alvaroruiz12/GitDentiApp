package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import BBDD.Conexion;

public class Citas {

	int idCitas;
	String Hora;
	String Fecha;
	int IdPagos;
	String DNIpaciente;
	String DNIdoctor;
	String Observaciones;

	private Conexion conexion;

	public Citas() {

	}

	public Citas(int idCitas, String Hora, String Fecha, int IdPagos, String DNIpacientes, String DNIdoctor,
			String Observaciones) {
		super();
		this.idCitas = idCitas;
		Hora = Hora;
		Fecha = Fecha;
		IdPagos = IdPagos;
		DNIpacientes = DNIpacientes;
		DNIdoctor = DNIdoctor;
		Observaciones = Observaciones;
	}

	// sin id

	public Citas(String Hora, String Fecha, int IdPagos, String DNIpacientes, String DNIdoctor, String Observaciones) {
		super();
		Hora = Hora;
		Fecha = Fecha;
		IdPagos = IdPagos;
		DNIpacientes = DNIpacientes;
		DNIdoctor = DNIdoctor;
		Observaciones = Observaciones;
	}

	public void CargarTabla(DefaultTableModel tableModel, JTable table_1) {
		try {

			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select hora,fecha,DNIpaciente," + "DNIdoctor,observaciones_cita"
					+ " from citas ORDER BY fecha";
			rs = stm.executeQuery(consulta);

			while (rs.next()) {
				String Hora = rs.getString("hora");
				String Fecha = rs.getString("fecha");
				String DNIpacientes = rs.getString("DNIpaciente");
				String DNIdoctor = rs.getString("DNIdoctor");
				String Observaciones = rs.getString("observaciones_cita");

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { Hora, Fecha, DNIpacientes, DNIdoctor, Observaciones };
				tableModel.addRow(rowData);
			}

			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void CargarTablaDoctor(DefaultTableModel tableModel, JTable table_1) {
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select hora,fecha,DNIpaciente," + "DNIdoctor,observaciones_cita"
					+ " from citas ORDER BY fecha";
			rs = stm.executeQuery(consulta);

			while (rs.next()) {
				String Hora = rs.getString("hora");
				String Fecha = rs.getString("fecha");
				String DNIpacientes = rs.getString("DNIpaciente");
				String DNIdoctor = rs.getString("DNIdoctor");
				String Observaciones = rs.getString("observaciones_cita");

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { Hora, Fecha, DNIpacientes, DNIdoctor, Observaciones };
				tableModel.addRow(rowData);
			}

			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void CargarTablaBusqueda(DefaultTableModel tableModel, JTable table_1, String DNI) {
		try {

			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select hora,fecha,DNIpaciente," + "DNIdoctor,observaciones_cita"
					+ " from citas WHERE DNIpaciente='" + DNI + "' ORDER BY fecha";
			rs = stm.executeQuery(consulta);

			while (rs.next()) {
				String Hora = rs.getString("hora");
				String Fecha = rs.getString("fecha");
				String DNIpacientes = rs.getString("DNIpaciente");
				String DNIdoctor = rs.getString("DNIdoctor");
				String Observaciones = rs.getString("observaciones_cita");

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { Hora, Fecha, DNIpacientes, DNIdoctor, Observaciones };
				tableModel.addRow(rowData);
			}

			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void EliminarCitas(JTable jTable, Conexion conexion) throws SQLException {
		// voy a coger la fila selecccionada.
		int filaSeleccionada = jTable.getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Selecciona una cita");
		} else {
			// obtenemos el valor de la columna Id que es la 0.
			Object valorId = jTable.getValueAt(filaSeleccionada, 0);

			// hacemos casting a int porque la recibimos como String.
			int idCitas = Integer.parseInt(valorId.toString());

			// consulta SQL para borrar
			String consulta = "DELETE FROM citas WHERE idcitas= " + idCitas;
			conexion.ejecutarInsertDeleteUpdate(consulta);
			// borramos de la tabla ahora.
			DefaultTableModel model = (DefaultTableModel) jTable.getModel();
			model.removeRow(filaSeleccionada);

		}
	}

	// metodo editar citas NO TERMINADO
	public void EditarCitas(JTable jTable, Conexion conexion, String hora, String fecha, String DNIpaciente,
			String DNIdoctor, String observaciones) throws SQLException {
		// voy a coger la fila selecccionada.
		int filaSeleccionada = jTable.getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Selecciona una cita");
		} else {
			// obtenemos el valor de la columna Id que es la 0.
			Object valorId = jTable.getValueAt(filaSeleccionada, 0);

			// hacemos casting a int porque la recibimos como String.
			int idCitas = Integer.parseInt(valorId.toString());

			// consulta SQL para borrar
			String consulta = "UPDATE nombre_de_tabla" + "SET " + "    hora = '" + hora + "'," + "    fecha = '" + fecha
					+ "'," + "    DNIpaciente = '" + DNIpaciente + "'," + "    DNIdoctor = '" + DNIdoctor + "',"
					+ "    observaciones_cita = '" + observaciones + "'" + "WHERE\n" + "    idcitas = " + idCitas + ";";
			conexion.ejecutarInsertDeleteUpdate(consulta);
			// borramos de la tabla ahora.
			DefaultTableModel model = (DefaultTableModel) jTable.getModel();
			model.removeRow(filaSeleccionada);

		}
	}

	public ArrayList<String> CargarDatos(String DNI, String fecha) {
		ArrayList<String> datos = null;
		try {

			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select idcitas,hora,fecha,DNIpaciente," + "DNIdoctor,observaciones_cita"
					+ " from citas WHERE DNIpaciente='"+DNI+"' AND fecha='"+fecha+"'";
			rs = stm.executeQuery(consulta);
			if (datos == null) {
				datos= new ArrayList<>();
			}
			while (rs.next()) {
				String idcitas=rs.getString("idcitas");
				String Hora = rs.getString("hora");
				String Fecha = rs.getString("fecha");
				String DNIpacientes = rs.getString("DNIpaciente");
				String DNIdoctor = rs.getString("DNIdoctor");
				String Observaciones = rs.getString("observaciones_cita");


				//relleno de los datos del arraylist
				datos.add(idcitas);
				datos.add(Hora);
				datos.add(Fecha);
				datos.add(DNIpacientes);
				datos.add(DNIdoctor);
				datos.add(Observaciones);
				
			}

			// Crear un JTable con el modelo de tabla
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datos;
	}

}
