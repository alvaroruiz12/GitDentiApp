package Main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public Material(	int idmateriales,String nombrematerial,int cantidad,String precio,String proveedor_CIF) {
		super();
	this.idmateriales=idmateriales;
	this.nombrematerial=nombrematerial;
	this.cantidad=cantidad;
	this.precio=precio;
	this.proveedor_CIF=proveedor_CIF;
	
	}	
	public void CargarTabla(DefaultTableModel tableModel, JTable table_1) {
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select nombre_material,cantidad,precio,CIFproveedor from materiales;";
			rs = stm.executeQuery(consulta);
			while (rs.next()) {
			
				String nombrematerial = rs.getString("nombre_material");
				int cantidad= rs.getInt("cantidad");
				String precio = rs.getString("precio");
				String proveedor_CIF = rs.getString("CIFproveedor");
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
				Object[] rowData = { nombrematerial, cantidad, precio, proveedor_CIF};
				tableModel.addRow(rowData);
			}
			// Crear un JTable con el modelo de tabla
			table_1 = new JTable(tableModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
