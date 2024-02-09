package Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import BBDD.Conexion;

public class Usuarios {
private int idusuarios;
private String usuario;
private String contrasenia;
private int rol;
public int getIdusuarios() {
	return idusuarios;
}
public void setIdusuarios(int idusuarios) {
	this.idusuarios = idusuarios;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getContrasenia() {
	return contrasenia;
}
public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}
public int getRol() {
	return rol;
}
public void setRol(int rol) {
	this.rol = rol;
}

public void InsertarAdmin(String nombre,String contrasenia) {

	try {
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		Conexion controlador = new Conexion();
		cn = (Connection) controlador.conectar();
		stm = cn.createStatement();
	
		
		String consulta1 = "INSERT INTO usuarios (usuario, contrasenia, rol) VALUES ('" + nombre + "','" + contrasenia + "', 0)";
		
		
	
	
	
		boolean status = false;
		System.out.println(consulta1);
		status = controlador.insertar(controlador, consulta1);
	
			if (status==true) {
				  int opcion = JOptionPane.showConfirmDialog(
				            null,
				            "¿Quieres realizar esta acción?",
				            "Confirmación",
				            JOptionPane.OK_CANCEL_OPTION
				        );
			}
			
		

	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public void InsertarDoctor(String nombre,String contrasenia) {

	try {
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		Conexion controlador = new Conexion();
		cn = (Connection) controlador.conectar();
		stm = cn.createStatement();
	
		
		String consulta1 = "INSERT INTO usuarios (nombre, contrasenia, rol) VALUES ('" + nombre + "','" + contrasenia + "', 1)";
		
		
	
	
	
		boolean status = false;
		System.out.println(consulta1);
		status = controlador.insertar(controlador, consulta1);
	
			if (status==true) {
				  int opcion = JOptionPane.showConfirmDialog(
				            null,
				            "¿Quieres realizar esta acción?",
				            "Confirmación",
				            JOptionPane.OK_CANCEL_OPTION
				        );
			}
			
		

	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
}





