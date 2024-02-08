package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

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
	
		String consulta = "select nombre_material,cantidad, concat (precio, '€') as Precio,CIFproveedor from materiales";
		rs = stm.executeQuery(consulta);
		while (rs.next()) {
		
			String nombrematerial = rs.getString("nombre_material");
			int cantidad= rs.getInt("cantidad");
			String precio = rs.getString("precio");
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




  public void AceptarSolicitud(Object idpedido) {
        
        try {
            // conexión a la base de datos
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentiapp?useSSL=false", "root", "1234");

         //sentencia para eliminar a traves de la id
            String consulta = "UPDATE pedidos set aceptado = true  WHERE idpedidos = ?";
           
   
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(consulta);
            preparedStatement.setObject(1, idpedido);
            preparedStatement.executeUpdate(); 
         
            // Cerrar recursos
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones (puedes mostrar un mensaje de error, etc.)
        }
    }
  
  public void Actualizarmateriales(int idpedido) {
      
      try {
    	  Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			int idmateriales =0;
			int cantidadpedidos=0;
			int cantidadmaterial =0;
      
		       String consulta = "select idmateriales "
		         		+ "from pedidos where idpedidos= "+idpedido+"";
		         	
			rs = stm.executeQuery(consulta);
			while (rs.next()) {
				idmateriales= rs.getInt("idmateriales");
				
				
			}
			
			String consulta2="select cantidad from pedidos where idpedidos = "+idpedido+"";
			rs = stm.executeQuery(consulta2);
			while (rs.next()) {
				cantidadpedidos= rs.getInt("cantidad");
				
			}
			
			String consulta3 ="select cantidad from materiales where idmateriales = "+idmateriales+"";
			rs = stm.executeQuery(consulta3);
			while (rs.next()) {
				cantidadmaterial= rs.getInt("cantidad");
				
			}
			int sumatotal = cantidadpedidos+cantidadmaterial; 
    	  
    	  
   
				
         
			String consulta6 = "UPDATE materiales"
                    + " SET materiales.cantidad = " + sumatotal
                    + " where materiales.idmateriales = " + idmateriales + "";

          
          stm.executeUpdate(consulta6);
          
          String eliminar = "delete from pedidos where idpedidos ="+idpedido+"";
          stm.execute(eliminar);
          System.out.println("se ha eliminado correctamente");
          
      } catch (SQLException e) {
          e.printStackTrace();
          // Manejo de excepciones (puedes mostrar un mensaje de error, etc.)
      }
  }
  
  
  
  
  public void CargarTablaPedidos(DefaultTableModel tableModel, JTable table_1) {
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
        
			String consulta = "SELECT pedidos.idpedidos, materiales.nombre_material,pedidos.cantidad,pedidos.aceptado "
					+ "FROM materiales  "
					+ "JOIN pedidos  "
					+ "ON pedidos.idmateriales = materiales.idmateriales where pedidos.aceptado = false ";
			rs = stm.executeQuery(consulta);
			while (rs.next()) {
				int idpedidos= rs.getInt("idpedidos");
				String nombrematerial = rs.getString("nombre_material");
				int cantidad= rs.getInt("cantidad");
				boolean aceptado = rs.getBoolean("aceptado");
			
			
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { idpedidos,nombrematerial, cantidad, aceptado};
				tableModel.addRow(rowData);
			}
			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
  
  public void CargarTablaPedidosTodos(DefaultTableModel tableModel, JTable table_1) {
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
      
			String consulta = "SELECT pedidos.idpedidos, materiales.nombre_material,pedidos.cantidad,pedidos.aceptado "
					+ "FROM materiales  "
					+ "JOIN pedidos  "
					+ "ON pedidos.idmateriales = materiales.idmateriales order by idpedidos ASC";
			rs = stm.executeQuery(consulta);
			while (rs.next()) {
				int idpedidos= rs.getInt("idpedidos");
				String nombrematerial = rs.getString("nombre_material");
				int cantidad= rs.getInt("cantidad");
				boolean aceptado = rs.getBoolean("aceptado");
			
			
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { idpedidos,nombrematerial, cantidad, aceptado};
				tableModel.addRow(rowData);
			}
			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}




}
