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

public class Tratamiento {

  
    int idtratamiento;
    int coste;
    String Nombre;
    
    private Conexion conexion;
    
    public Tratamiento() {
   	 
    }
    public Tratamiento(int idtratamiento, int coste,  String Nombre) {
   	 super();
   	idtratamiento=this.idtratamiento;
   	coste=this.coste;
   	Nombre= this.Nombre;
    
 
    }    
    
    //sin id
    
    public Tratamiento(int coste,String Nombre) {
   	 super();
    
   	coste=this.coste;
   	Nombre= this.Nombre;
     
    }
    
    public void CargarTabla(DefaultTableModel tableModel, JTable table_1) {
   	 try {
   		tableModel.setRowCount(0);
   		 Connection cn = null;
   		 Statement stm = null;
   		 ResultSet rs = null;
   		 Conexion controlador = new Conexion();
   		 cn = controlador.conectar();
   		 stm = cn.createStatement();
   		 String consulta = "Select nombre_tratamiento,coste_tratamiento from tratamientos";
   		 rs = stm.executeQuery(consulta);

   		 while (rs.next()) {
   			 int Coste = Integer.parseInt(rs.getString("coste_tratamiento"));
   			 String Nombre= rs.getString("nombre_tratamiento");
   		
   			
   			
   			 

   			 // Agregar los datos a la tabla
   			 // tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
   			 // que va a recibir todo tipo de datos.
   			 Object[] rowData = { Nombre,Coste};
   			 tableModel.addRow(rowData);
   		 }

   		 // Crear un JTable con el modelo de tabla
   		 table_1 = new JTable(tableModel);
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   	 }

    }
    public ArrayList<String> CargarNombreTratamiento() {

		ArrayList<String> nTratamiento = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select nombre_tratamiento from tratamientos order by idtratamiento";
			rs = stm.executeQuery(consulta);
		

			if (nTratamiento == null) {
				nTratamiento= new ArrayList<>();
			}
			while (rs.next()) {
				String nombre = rs.getString("nombre_tratamiento");

				
				
				nTratamiento.add(nombre);
				System.out.println(nTratamiento);
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nTratamiento;
		

	}
    public ArrayList<String> CargarNumeroTratamiento() {

		ArrayList<String> nTratamiento = null;
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = controlador.conectar();
			stm = cn.createStatement();
			String consulta = "Select idtratamiento from tratamientos order by idtratamiento";
			rs = stm.executeQuery(consulta);
		

			if (nTratamiento == null) {
				nTratamiento= new ArrayList<>();
			}
			while (rs.next()) {
				String numero = rs.getString("idtratamiento");

				
				
				nTratamiento.add(numero);
				System.out.println(nTratamiento);
				
				// Agregar los datos a la tabla
				// tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
				// que va a recibir todo tipo de datos.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nTratamiento;
		

	}
    public ArrayList<String> CargarDatos( int id) {
      	ArrayList<String> datos=null; 
    	try {
      		 Connection cn = null;
      		 Statement stm = null;
      		 ResultSet rs = null;
      		 Conexion controlador = new Conexion();
      		 cn = controlador.conectar();
      		 stm = cn.createStatement();
      		 String consulta = "Select nombre_tratamiento,coste_tratamiento from tratamientos "
      		 		+ " WHERE idtratamiento="+id+ " order by idtratamiento";
      		 rs = stm.executeQuery(consulta);
     		if (datos == null) {
     			datos= new ArrayList<>();
			}
      		 while (rs.next()) {
      			 int Coste = Integer.parseInt(rs.getString("coste_tratamiento"));
      			 String Nombre= rs.getString("nombre_tratamiento");
      			 datos.add(Nombre);
      			 datos.add(String.valueOf(Coste));

      			
      			

      		 }

      	 } catch (SQLException e) {
      		 e.printStackTrace();
      	 }  			 
      	 return datos;


       }

    
    
}
