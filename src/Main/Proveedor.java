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
	
	public ArrayList<String> CargarNombreProveedor() {

		ArrayList<String> nProveedor = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select nombre_proveedor from proveedor";
			rs = stm.executeQuery(consulta);
		

			if (nProveedor == null) {
				nProveedor= new ArrayList<>();
			}
			while (rs.next()) {
				String nombre = rs.getString("nombre_proveedor");

				
				
				nProveedor.add(nombre);
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nProveedor;
		

	}
    public ArrayList<String> CargarCIF() {

		ArrayList<String> nTratamiento = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select CIFproveedor from proveedor";
			rs = stm.executeQuery(consulta);
		

			if (nTratamiento == null) {
				nTratamiento= new ArrayList<>();
			}
			while (rs.next()) {
				String CIF = rs.getString("CIFproveedor");

				
				
				nTratamiento.add(CIF);
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nTratamiento;
	}
    public ArrayList<String> RellenarDatosProveedor(String CIF) {
		ArrayList<String> datos=null;

		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select * from proveedor "
					+ "WHERE CIFproveedor='"+CIF+"'";
			System.out.println(consulta);
			rs = stm.executeQuery(consulta);
			if (datos== null) {
				datos= new ArrayList<>();
			}
			while (rs.next()) {
				String CIFproveedor = rs.getString("CIFproveedor");
				String Nombre = rs.getString("nombre_proveedor");
				int telefono = rs.getInt("telefono_proveedor");
				String correo = rs.getString("correo_proveedor");

				datos.add(CIFproveedor);
				datos.add(Nombre);
				datos.add(String.valueOf(telefono));
				datos.add(correo);

				
			}

			// Crear un JTable con el modelo de tabla
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datos;
	
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
			String idDoctor = valorId.toString();

			// consulta SQL para borrar
			String consulta = "DELETE FROM proveedor WHERE CIFproveedor= '" + idDoctor + "';";
			conexion.ejecutarInsertDeleteUpdate(consulta);

			// borramos de la tabla ahora.
			DefaultTableModel model = (DefaultTableModel) jTable.getModel();
			model.removeRow(filaSeleccionada);

		}
	}

    
}
