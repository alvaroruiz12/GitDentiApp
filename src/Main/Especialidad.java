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

public class Especialidad {
	public void CargarTabla(DefaultTableModel tableModel, JTable table_1) {
		try {
			tableModel.setRowCount(0);
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select nombre_especialidad from especialidad";
			rs = stm.executeQuery(consulta);

			while (rs.next()) {
				String nombreEspecialidad= rs.getString("nombre_especialidad");
				

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { nombreEspecialidad};
				tableModel.addRow(rowData);
			}

			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public ArrayList<String> CargarNombreEspecialidad() {

		ArrayList<String> nEspecialidad = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select nombre_especialidad from especialidad";
			rs = stm.executeQuery(consulta);
		

			if (nEspecialidad == null) {
				nEspecialidad= new ArrayList<>();
			}
			while (rs.next()) {
				String nombre = rs.getString("nombre_especialidad");

				
				
				nEspecialidad.add(nombre);
				System.out.println(nEspecialidad);
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nEspecialidad;
		

	}
    public ArrayList<String> CargarNumeroEspecialidad() {

		ArrayList<String> nEspecialidad = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select idespecialidad from especialidad";
			rs = stm.executeQuery(consulta);
		

			if (nEspecialidad == null) {
				nEspecialidad= new ArrayList<>();
			}
			while (rs.next()) {
				String numero = rs.getString("idespecialidad");

				
				
				nEspecialidad.add(numero);
				System.out.println(nEspecialidad);
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nEspecialidad;
		

	}
	
	
	
	
	
}
