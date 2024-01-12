package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BBDD.Conexion;

public class Paciente {

    private String DNIpaciente;
    private String nombre;
    private String Apellidos;
    private String correo;   
    private int telefono;
    private int edad;
    
    private Conexion conexion;
    
    public Paciente() {
   	 
    }
    public Paciente(String DNIpaciente,String nombre,String Apellidos,String correo, int telefono,int edad) {
   	 super();
    DNIpaciente=this.DNIpaciente;
    nombre=this.nombre;
    Apellidos= this.Apellidos;
    correo=this.correo;
    telefono=this.telefono;
    edad = this.edad;
    }    
    
    //sin id
    
    public Paciente(String nombre,String Apellidos,String correo, int telefono,int edad) {
   	 super();
    
     nombre=this.nombre;
     Apellidos= this.Apellidos;
     correo=this.correo;
     telefono=this.telefono;
     edad = this.edad;
    }
    
    public void CargarTabla(DefaultTableModel tableModel, JTable table_1) {
   	 try {

   		 Connection cn = null;
   		 Statement stm = null;
   		 ResultSet rs = null;
   		 Conexion controlador = new Conexion();
   		 cn = controlador.conectar();
   		 stm = cn.createStatement();
   		 String consulta = "Select * from pacientes";
   		 rs = stm.executeQuery(consulta);

   		 while (rs.next()) {
   			 String DNIpaciente = rs.getString("DNIpaciente");
   			 String Nombre = rs.getString("Nombre");
   			 String Apellidos= rs.getString("Apellidos");
   			 String correo= rs.getString("correo");
   			 int telefono = rs.getInt("telefono");
   			 int edad = rs.getInt("edad");
   			
   			 

   			 // Agregar los datos a la tabla
   			 // tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
   			 // que va a recibir todo tipo de datos.
   			 Object[] rowData = { DNIpaciente, Nombre, Apellidos, correo, telefono, edad};
   			 tableModel.addRow(rowData);
   		 }

   		 // Crear un JTable con el modelo de tabla
   		 table_1 = new JTable(tableModel);
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   	 }

    }
	public String getDNIpaciente() {
		return DNIpaciente;
	}
	public void setDNIpaciente(String dNIpaciente) {
		DNIpaciente = dNIpaciente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Conexion getConexion() {
		return conexion;
	}
	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
    
    
}


