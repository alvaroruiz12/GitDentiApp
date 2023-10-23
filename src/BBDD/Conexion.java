package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Conexion {

	private static final String CONTROLADOR="com.mysql.jbdc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/dentiapp?useSSL=false";
	private static final String USUARIO="root";
	private static final String CLAVE="1234";

	public Connection conectar() 
	{
		Connection conexion=null;
		try {
			conexion=DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexion OK");
		}catch(SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return conexion;

	}
	
	public ArrayList<String> seleccionarUsuarios(Conexion con, String sentencia){
		
		ArrayList<String> res = new ArrayList<String>();
		
		
		Conexion conexion = con;
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn=conexion.conectar();
			stm = cn.createStatement();
			rs= stm.executeQuery(sentencia);
			
			while(rs.next()) {
				
				int idusuarios = rs.getInt(1);
				res.add(String.valueOf(idusuarios));
				String nombreusuario = rs.getString(2);
				res.add(nombreusuario);
				String contrausuario = rs.getString(3);
				res.add(contrausuario);
				Boolean rol = rs.getBoolean(4);
				res.add(Boolean.toString(rol));

			}			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
		
		return res;
		
	}
	
	public boolean insertar(Conexion con, String sentencia) {
		
		boolean res= false;
		
		Conexion conexion = con;
		Connection cn = null;
		Statement stm = null;
		int rs = 0;
		
		try {
			cn=conexion.conectar();
			stm = cn.createStatement();
			rs= stm.executeUpdate(sentencia);
					
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return res;
	}
	
	public boolean comprobar(String n, String c) {
		boolean res = false;
		
		
		return res;
	}
	

}
