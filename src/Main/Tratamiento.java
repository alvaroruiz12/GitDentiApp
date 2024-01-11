package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
   		 String consulta = "Select * from tratamientos";
   		 rs = stm.executeQuery(consulta);

   		 while (rs.next()) {
   			 int idtratamientos = Integer.parseInt(rs.getString("idtratamientos"));
   			 int Coste = Integer.parseInt(rs.getString("Coste"));
   			 String Nombre= rs.getString("Nombre");
   		
   			
   			
   			 

   			 // Agregar los datos a la tabla
   			 // tiene que ser de tipo Object porque el DefaultTableModel espera un Object ya
   			 // que va a recibir todo tipo de datos.
   			 Object[] rowData = { idtratamientos, Coste,Nombre};
   			 tableModel.addRow(rowData);
   		 }

   		 // Crear un JTable con el modelo de tabla
   		 table_1 = new JTable(tableModel);
   	 } catch (SQLException e) {
   		 e.printStackTrace();
   	 }

    }
}