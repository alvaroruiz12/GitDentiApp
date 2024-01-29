package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
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

				int telofono_proveedor = rs.getInt("telefono_proveedor");
				String correo_proveedor = rs.getString("correo_proveedor");
				String direccion_proveedor = rs.getString("direccion_proveedor");

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { CIFproveedor, nombre_proveedor, telofono_proveedor, correo_proveedor,
						direccion_proveedor };
				tableModel.addRow(rowData);
			}

			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void EliminarProveedor(JTable jTable, Conexion conexion) throws SQLException {
		// voy a coger la fila selecccionada.
		int filaSeleccionada = jTable.getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Selecciona un proveedor");
		} else {
			// obtenemos el valor de la columna Id que es la 0.
			Object valorId = jTable.getValueAt(filaSeleccionada, 0);

			// hacemos casting a int porque la recibimos como String.
			String CIFproveedor = valorId.toString();

			// consulta SQL para borrar
			String consulta = "DELETE FROM proveedor WHERE CIFproveedor= '" + CIFproveedor+"';";
			String idProveedor = valorId.toString();

			// borramos de la tabla ahora.
			DefaultTableModel model = (DefaultTableModel) jTable.getModel();
			model.removeRow(filaSeleccionada);

		}
	}
	
	
}
