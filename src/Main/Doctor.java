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
			String consulta = "Select * from doctor";
			rs = stm.executeQuery(consulta);

			while (rs.next()) {
				String DNIdoctor = rs.getString("DNI");
				String Nombre = rs.getString("Nombre");
				String idusuario = rs.getString("usuarios_idusuarios");
				String idespecialidad = rs.getString("especialidad_idespecialidad");

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { DNIdoctor, Nombre, idusuario, idespecialidad };
				tableModel.addRow(rowData);
			}

			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void CargarDoctorCitas(ArrayList<String> NombreList, ArrayList<String> DNI) {
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select DNI,Nombre from doctor";
			rs = stm.executeQuery(consulta);
			if (NombreList == null) {
				NombreList = new ArrayList<>();
			}
			if (DNI == null) {
				DNI= new ArrayList<>();
			}
			while (rs.next()) {
				String StringDNI = rs.getString("DNI");

				String Nombre = rs.getString("Nombre");

				NombreList.add(Nombre);
				DNI.add(StringDNI);

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
