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

    String DNIpaciente;
    String nombre;
    String Apellidos;
    String correo;   
    int telefono;
    int edad;
    
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
   	public void CargarTablaCitas(DefaultTableModel tableModel, JTable table_1) {
      	 try {

      		 Connection cn = null;
      		 Statement stm = null;
      		 ResultSet rs = null;
      		 Conexion controlador = new Conexion();
      		 cn = controlador.conectar();
      		 stm = cn.createStatement();
      		 String consulta = "Select DNI,Nombre,Apellidos from pacientes";
      		 rs = stm.executeQuery(consulta);

      		 while (rs.next()) {
      			 String DNIpaciente = rs.getString("DNIpaciente");
      			 String Nombre = rs.getString("Nombre");
      			 String Apellidos= rs.getString("Apellidos");

      			
      			 

      			 // Agregar los datos a la tabla
      			 // tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
      			 // que va a recibir todo tipo de datos.
      			 Object[] rowData = { DNIpaciente, Nombre, Apellidos};
      			 tableModel.addRow(rowData);
      		 }

      		 // Crear un JTable con el modelo de tabla
      		 table_1 = new JTable(tableModel);
      	 } catch (SQLException e) {
      		 e.printStackTrace();
      	 }

    }
}


