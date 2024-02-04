package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BBDD.Conexion;

public class Proveedor {

	public void CargarTabla(DefaultTableModel tableModel, JTable table_1) {
		try {
			tableModel.setRowCount(0);
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select * from proveedor";
			rs = stm.executeQuery(consulta);

			while (rs.next()) {
				String CIFproveedor = rs.getString("CIFproveedor");
				String nombre_proveedor = rs.getString("nombre_proveedor");
				int telefono_proveedor= rs.getInt("telefono_proveedor");
				String correo_proveedor= rs.getString("correo_proveedor");
				

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { CIFproveedor, nombre_proveedor,telefono_proveedor, correo_proveedor };
				tableModel.addRow(rowData);
			}

			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
