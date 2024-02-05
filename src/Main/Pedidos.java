package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BBDD.Conexion;

public class Pedidos {
private int idpedido;
private int cantidad;
private boolean aceptado;
private int idmaterial;
public int getIdpedido() {
	return idpedido;
}
public void setIdpedido(int idpedido) {
	this.idpedido = idpedido;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public boolean isAceptado() {
	return aceptado;
}
public void setAceptado(boolean aceptado) {
	this.aceptado = aceptado;
}
public int getIdmaterial() {
	return idmaterial;
}
public void setIdmaterial(int idmaterial) {
	this.idmaterial = idmaterial;
}


public void CargarTabla(DefaultTableModel tableModel, JTable table_1) {
	try {
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		Conexion controlador = new Conexion();
		cn = controlador.conectar();
		stm = cn.createStatement();
	
		String consulta = "select nombre_material,cantidad,precio,CIFproveedor from materiales";
		rs = stm.executeQuery(consulta);
		while (rs.next()) {
		
			String nombrematerial = rs.getString("nombre_material");
			int cantidad= rs.getInt("cantidad");
			int precio = rs.getInt("precio");
			String proveedor = rs.getString("CIFproveedor");
		
			
			// Agregar los datos a la tabla
			// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
			// que va a recibir todo tipo de datos.
			Object[] rowData = { nombrematerial, cantidad, precio,proveedor};
			tableModel.addRow(rowData);
		}
		// Crear un JTable con el modelo de tabla
		table_1 = new JTable(tableModel);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

	
public ArrayList<String> CargarNombreMaterial() {

		ArrayList<String> nmaterial = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "select nombre_material from materiales";
			rs = stm.executeQuery(consulta);
		

			if (nmaterial == null) {
				nmaterial= new ArrayList<>();
			}
			while (rs.next()) {
				String nombre = rs.getString("nombre_material");

				
				
				nmaterial.add(nombre);
				System.out.println(nmaterial);
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nmaterial;
		

	}

public int CargarCantidad(String nombre) {

	int cantidad=0;
	try {
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		Conexion controlador = new Conexion();
		cn = controlador.conectar();
		stm = cn.createStatement();
		String consulta = "Select cantidad from materiales where  nombre_material = '" + nombre + "'";
		rs = stm.executeQuery(consulta);
	

		while (rs.next()) {
			String resultado = rs.getString("cantidad");

			cantidad = Integer.parseInt(resultado);
			
		
		
			
			// Agregar los datos a la tabla
			// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
			// que va a recibir todo tipo de datos.
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return cantidad;
	

}





}
