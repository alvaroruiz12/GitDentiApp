package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import BBDD.Conexion;

public class Material {
	private int idmateriales;
	private String nombrematerial;
	private int cantidad;
	private String precio;
	private String proveedor_CIF;
	private Conexion conexion;

	public Material() {

	}

	public Material(int idmateriales, String nombrematerial, int cantidad, String precio, String proveedor_CIF) {
		super();
		this.idmateriales = idmateriales;
		this.nombrematerial = nombrematerial;
		this.cantidad = cantidad;
		this.precio = precio;
		this.proveedor_CIF = proveedor_CIF;

	}

	public void CargarTabla(DefaultTableModel tableModel, JTable table_1) {
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select nombrematerial,Cantidad,precio,proveedor_CIF from materiales;";
			rs = stm.executeQuery(consulta);
			while (rs.next()) {

				String nombrematerial = rs.getString("nombrematerial");
				int cantidad = rs.getInt("Cantidad");
				String precio = rs.getString("precio");
				String proveedor_CIF = rs.getString("proveedor_CIF");

				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { nombrematerial, cantidad, precio, proveedor_CIF };
				tableModel.addRow(rowData);
			}
			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	
	public ArrayList<String> CargarIDMaterial() {

		ArrayList<String> DNIList = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select idmateriales from materiales";
			rs = stm.executeQuery(consulta);
		

			if (DNIList == null) {
				DNIList= new ArrayList<>();
			}
			while (rs.next()) {
				String StringDNI = rs.getString("idmateriales");

				
				
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
	public ArrayList<String> CargarNombreMateriales() {

		ArrayList<String> NombreList = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select nombre_material from materiales";
			rs = stm.executeQuery(consulta);
		

			if (NombreList== null) {
				NombreList= new ArrayList<>();
			}
			while (rs.next()) {
	
				String Nombre = rs.getString("nombre_material");
				
				
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
	
}
