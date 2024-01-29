package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BBDD.Conexion;

public class Doctor {

	String DNIDoctor;
	String nombre;
	int idusuario;
	int especialidad;

	private Conexion conexion;

	public Doctor() {

	}

	public Doctor(String DNIDoctor, String nombre, int idusuario, int especialidad) {
		super();
		DNIDoctor = this.DNIDoctor;
		nombre = this.nombre;
		idusuario = this.idusuario;
		especialidad = this.especialidad;

	}

	// sin id

	public Doctor(String nombre, int idusuario, int especialidad) {
		super();

		nombre = this.nombre;
		idusuario = this.idusuario;
		especialidad = this.especialidad;
	}

	public void CargarTabla(DefaultTableModel tableModel, JTable table_1) {
		try {
			tableModel.setRowCount(0);
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select DNIdoctor,nombre_doctor from doctor";
			rs = stm.executeQuery(consulta);

			while (rs.next()) {
				String DNIdoctor = rs.getString("DNIdoctor");
				String Nombre = rs.getString("nombre_doctor");

				String idusuario = rs.getString("idusuarios");
				String idespecialidad = rs.getString("idespecialidad");

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { DNIdoctor, Nombre,};
				tableModel.addRow(rowData);
			}

			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String> CargarDNIDoctorCitas() {

		ArrayList<String> DNIList = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select DNIdoctor from doctor";
			rs = stm.executeQuery(consulta);
		

			if (DNIList == null) {
				DNIList= new ArrayList<>();
			}
			while (rs.next()) {
				String StringDNI = rs.getString("DNIdoctor");

				
				
				DNIList.add(StringDNI);
				System.out.println(DNIList);
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DNIList;
		

	}
	public ArrayList<String> CargarNombreDoctorCitas() {

		ArrayList<String> NombreList = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select nombre_doctor from doctor";
			rs = stm.executeQuery(consulta);
		

			if (NombreList== null) {
				NombreList= new ArrayList<>();
			}
			while (rs.next()) {
	
				String Nombre = rs.getString("nombre_doctor");
				
				
				NombreList.add(Nombre);
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return NombreList;
		

	}
	
	public void EliminarDoctor(JTable jTable, Conexion conexion) throws SQLException {
		// voy a coger la fila selecccionada.
		int filaSeleccionada = jTable.getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Selecciona un doctor");
		} else {
			// obtenemos el valor de la columna Id que es la 0.
			Object valorId = jTable.getValueAt(filaSeleccionada, 0);

			// hacemos casting a int porque la recibimos como String.
			String idDoctor = valorId.toString();

			// consulta SQL para borrar
			String consulta = "DELETE FROM doctor WHERE DNIdoctor= '" + idDoctor+"';";
			String idCitas = valorId.toString();

			// borramos de la tabla ahora.
			DefaultTableModel model = (DefaultTableModel) jTable.getModel();
			model.removeRow(filaSeleccionada);

		}
	}

}
