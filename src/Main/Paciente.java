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
   			 String Nombre = rs.getString("nombre_paciente");
   			 String Apellidos= rs.getString("apellido_paciente");
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
	
	public String BuscarPaciente(String nombre,String apellidos) {
		String DNI="";
		
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select DNIpaciente from pacientes WHERE nombre_paciente='"+nombre+"' "
					+ "AND apellido_paciente='"+apellidos+"'";
				rs = stm.executeQuery(consulta);
				
				
				 while (rs.next()) {
						DNI= rs.getString("DNIpaciente");
				 }

					
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return DNI;
	}
	
	public String BuscarModificarPaciente(String nombre,String apellidos) {
		String DNI="";
		
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select DNIpaciente from pacientes WHERE nombre_paciente='"+nombre+"' "
					+ "AND apellido_paciente='"+apellidos+"'";
				rs = stm.executeQuery(consulta);
				
				
				 while (rs.next()) {
						DNI= rs.getString("DNIpaciente");
				 }

					
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return DNI;
	}
	
	public ArrayList<String> BuscarPacienteModificar(String nombre,String apellidos) {
		ArrayList<String> datos=null;
		String DNI="";
		String correo="";
		String telefono="";
		int edad=0;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select DNIpaciente,correo,telefono,edad from pacientes WHERE nombre_paciente='"+nombre+"' "
					+ "AND apellido_paciente='"+apellidos+"'";
				rs = stm.executeQuery(consulta);
				if (datos== null) {
					datos= new ArrayList<>();
				}
				
				 while (rs.next()) {
						DNI= rs.getString("DNIpaciente");
						correo=rs.getString("correo");
						telefono=rs.getString("telefono");
						edad=rs.getInt("edad");
						
						datos.add(DNI);
						datos.add(correo);
						datos.add(telefono);
						datos.add(String.valueOf(edad));
				 }

					System.out.println(datos);
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datos;
	}
	
	
	public ArrayList<String> CargarDNIPaciente() {

		ArrayList<String> DNIList = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select DNIpaciente from pacientes";
			rs = stm.executeQuery(consulta);
		

			if (DNIList == null) {
				DNIList= new ArrayList<>();
			}
			while (rs.next()) {
				String StringDNI = rs.getString("DNIpaciente");

				
				
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
	public ArrayList<String> CargarNombrePaciente() {

		ArrayList<String> NombreList = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select nombre_paciente from pacientes";
			rs = stm.executeQuery(consulta);
		

			if (NombreList== null) {
				NombreList= new ArrayList<>();
			}
			while (rs.next()) {
	
				String Nombre = rs.getString("nombre_paciente");
				
				
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


