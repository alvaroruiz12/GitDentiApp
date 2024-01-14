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
			String consulta = "Select Hora,Fecha,pacientes_DNIpaciente,"
					+ "doctor_DNI,Observaciones"
					+ " from citas ORDER BY Fecha";
			rs = stm.executeQuery(consulta);

			while (rs.next()) {
				String Hora = rs.getString("Hora");
				String Fecha = rs.getString("Fecha");
				String DNIpacientes = rs.getString("pacientes_DNIpaciente");
				String DNIdoctor = rs.getString("doctor_DNI");
				String Observaciones = rs.getString("Observaciones");

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = {Hora, Fecha, DNIpacientes, DNIdoctor, Observaciones };
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
			String consulta = "Select Hora,Fecha,pacientes_DNIpaciente,"
					+ "doctor_DNI,Observaciones"
					+ " from citas ORDER BY Fecha";
			rs = stm.executeQuery(consulta);

			while (rs.next()) {
				String Hora = rs.getString("Hora");
				String Fecha = rs.getString("Fecha");
				String DNIpacientes = rs.getString("pacientes_DNIpaciente");
				String DNIdoctor = rs.getString("doctor_DNI");
				String Observaciones = rs.getString("Observaciones");

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = {Hora, Fecha, DNIpacientes, DNIdoctor, Observaciones };
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
	public void EditarCitas(JTable jTable, Conexion conexion, String hora,String fecha, String DNIpaciente, String DNIdoctor,String observaciones) throws SQLException {
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
			String consulta = "UPDATE nombre_de_tabla"
					+ "SET "
					+ "    Hora = '"+hora+"',"
					+ "    Fecha = '"+fecha+"',"
					+ "    pacientes_DNIpaciente = '"+DNIpaciente+"',"
					+ "    doctor_DNI = '"+DNIdoctor+"',"
					+ "    observaciones = '"+observaciones+"'"
					+ "WHERE\n"
					+ "    idcitas = "+idCitas+";";
			conexion.ejecutarInsertDeleteUpdate(consulta);
			// borramos de la tabla ahora.
			DefaultTableModel model = (DefaultTableModel) jTable.getModel();
			model.removeRow(filaSeleccionada);

		}
	}
	
	



}
