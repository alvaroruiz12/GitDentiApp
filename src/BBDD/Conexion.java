package BBDD;

import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.JOptionPane;


public class Conexion {

	private static final String CONTROLADOR="com.mysql.jbdc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/dentiapp?useSSL=false";
	private static final String USUARIO="root";
	private static final String CLAVE="1234";
	
	
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
			
			JOptionPane.showMessageDialog(null, "Insertado con exito", "Insertado con exito", JOptionPane.INFORMATION_MESSAGE);
					
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "Error no se pudo insertar", "Error no se pudo insertar", JOptionPane.ERROR_MESSAGE);
			
		}
		
		
		return res;
	}
	
	public boolean comprobar(String n, String c) {
		boolean res = false;
		
		
		return res;
	}
	public boolean eliminar(Conexion con, String sentencia) {
	    boolean res = false;
	    Conexion conexion = con;
	    Connection cn = null;
	    Statement stm = null;
	    try {
	        cn = conexion.conectar();
	        stm = cn.createStatement();
	        int rowCount = stm.executeUpdate(sentencia);
	        if (rowCount > 0) {
	            res = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Cerrar recursos
	        try {
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return res;
	}

	public boolean actualizar(Conexion con, String sentencia) {
	    boolean res = false;
	    Conexion conexion = con;
	    Connection cn = null;
	    Statement stm = null;
	    try {
	        cn = conexion.conectar();
	        stm = cn.createStatement();
	        int rowCount = stm.executeUpdate(sentencia);
	        if (rowCount > 0) {
	            res = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Cerrar recursos
	        try {
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return res;
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
	
	//recuperar contraseña
	public ArrayList<String> recuperarContraseña(Conexion con, String sentencia){
		
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
				
				
				

				String contrausuario = rs.getString(1);
				res.add(contrausuario);
			

			}			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
		
		return res;
		
	}
	
	public ArrayList<String> seleccionarMateriales() {
	    ArrayList<String> res = new ArrayList<>();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    try {
	        cn = this.conectar();
	        stm = cn.createStatement();
	        rs = stm.executeQuery("SELECT * FROM materiales");

	        while (rs.next()) {
	            int idMateriales = rs.getInt("id materiales");
	            res.add(String.valueOf(idMateriales));
	            String cantidad = rs.getString("Cantidad");
	            res.add(cantidad);
	            int precio = rs.getInt("precio");
	            res.add(String.valueOf(precio));
	            String cif = rs.getString("CIF");
	            res.add(cif);
	            int idTratamientos = rs.getInt("tratamientos_idtratamientos");
	            res.add(String.valueOf(idTratamientos));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return res;
	}

	public ArrayList<String> seleccionarCitas() {
	    ArrayList<String> res = new ArrayList<>();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    try {
	        cn = this.conectar();
	        stm = cn.createStatement();
	        rs = stm.executeQuery("SELECT * FROM citas");

	        while (rs.next()) {
	            int idCitas = rs.getInt("idcitas");
	            res.add(String.valueOf(idCitas));
	            String hora = rs.getString("Hora");
	            res.add(hora);
	            String fecha = rs.getString("Fecha");
	            res.add(fecha);
	            int idDoctor = rs.getInt("doctor_iddoctor");
	            res.add(String.valueOf(idDoctor));
	            int idPagos = rs.getInt("pagos_idpagos");
	            res.add(String.valueOf(idPagos));
	            int idTratamientos = rs.getInt("tratamientos_idtratamientos");
	            res.add(String.valueOf(idTratamientos));
	            int idPacientes = rs.getInt("pacientes_idpacientes");
	            res.add(String.valueOf(idPacientes));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return res;
	}

	public ArrayList<String> seleccionarDoctor() {
	    ArrayList<String> res = new ArrayList<>();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    try {
	        cn = this.conectar();
	        stm = cn.createStatement();
	        rs = stm.executeQuery("SELECT * FROM doctor");

	        while (rs.next()) {
	            int idDoctor = rs.getInt("iddoctor");
	            res.add(String.valueOf(idDoctor));
	            String nombre = rs.getString("Nombre");
	            res.add(nombre);
	            String dni = rs.getString("DNI");
	            res.add(dni);
	            int idUsuarios = rs.getInt("usuarios_idusuarios");
	            res.add(String.valueOf(idUsuarios));
	            int idEspecialidad = rs.getInt("especialidad_idespecialidad");
	            res.add(String.valueOf(idEspecialidad));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return res;
	}

	public ArrayList<String> seleccionarEspecialidad() {
	    ArrayList<String> res = new ArrayList<>();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    try {
	        cn = this.conectar();
	        stm = cn.createStatement();
	        rs = stm.executeQuery("SELECT * FROM especialidad");

	        while (rs.next()) {
	            int idEspecialidad = rs.getInt("idespecialidad");
	            res.add(String.valueOf(idEspecialidad));
	            String nombre = rs.getString("nombre");
	            res.add(nombre);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return res;
	}


	public ArrayList<String> seleccionarPacientes() {
	    ArrayList<String> res = new ArrayList<>();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    try {
	        cn = this.conectar();
	        stm = cn.createStatement();
	        rs = stm.executeQuery("SELECT * FROM pacientes");

	        while (rs.next()) {
	            int idPacientes = rs.getInt("idpacientes");
	            res.add(String.valueOf(idPacientes));
	            String nombre = rs.getString("Nombre");
	            res.add(nombre);
	            String apellidos = rs.getString("Apellidos");
	            res.add(apellidos);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return res;
	}

	public ArrayList<String> seleccionarPagos() {
	    ArrayList<String> res = new ArrayList<>();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    try {
	        cn = this.conectar();
	        stm = cn.createStatement();
	        rs = stm.executeQuery("SELECT * FROM pagos");

	        while (rs.next()) {
	            int idPagos = rs.getInt("idpagos");
	            res.add(String.valueOf(idPagos));
	            String idCitas = rs.getString("idcitas");
	            res.add(idCitas);
	            String precio = rs.getString("precio");
	            res.add(precio);
	            int abonado = rs.getInt("abonado");
	            res.add(String.valueOf(abonado));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return res;
	}

	public ArrayList<String> seleccionarTratamientos() {
	    ArrayList<String> res = new ArrayList<>();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    try {
	        cn = this.conectar();
	        stm = cn.createStatement();
	        rs = stm.executeQuery("SELECT * FROM tratamientos");

	        while (rs.next()) {
	            int idTratamientos = rs.getInt("idtratamientos");
	            res.add(String.valueOf(idTratamientos));
	            int coste = rs.getInt("Coste");
	            res.add(String.valueOf(coste));
	            String nombre = rs.getString("Nombre");
	            res.add(nombre);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return res;
	}



	public ArrayList<String> seleccionarEspecialidades(Conexion con, String string) {
		// TODO Auto-generated method stub
		return null;
	}
	



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
	
	
	public int ejecutarInsertDeleteUpdate(String consulta) throws SQLException {
		Connection conexion = conectar();

		Statement stmt = conexion.createStatement();
		int file = stmt.executeUpdate(consulta);
		return file;
		
		
	}
	
	//recuperar contraseña

	
	
	
	
	public String seleccionar(Conexion con, String nombre) {
		Conexion conexion = con;
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sentencia="Select Nombre from tratamientos";
		try {
			cn=conexion.conectar();
			stm = cn.createStatement();
			rs= stm.executeQuery(sentencia);
					
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return nombre;
	}
	public String seleccionarDoctor(Conexion con, String nombre) {
		Conexion conexion = con;
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sentencia="Select Nombre from doctor";
		try {
			cn=conexion.conectar();
			stm = cn.createStatement();
			rs= stm.executeQuery(sentencia);
			
			List<String> nombresDoctores = new ArrayList<>();

			
			while (rs.next()) {
                String nombreDoctor = rs.getString("Nombre");
                nombresDoctores.add(nombreDoctor);
            }
					
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return nombre;
	}
	public boolean comprobarCitasDoctor(String horaIn, String fechaIn,String doctorIn) {
	    ArrayList<String> res = new ArrayList<>();
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    if (res == null) {
	    	res= new ArrayList<>();
		}
	    try {
	        cn = this.conectar();
	        stm = cn.createStatement();
	        rs = stm.executeQuery("SELECT * FROM citas "
	        		+ "WHERE hora = '"+horaIn+"' AND "
	        		+ "fecha = '"+fechaIn+"' AND "
	        		+ "DNIdoctor = '"+doctorIn+"'");


	        while (rs.next()) {
	            int idCitas = rs.getInt("idcitas");
	            res.add(String.valueOf(idCitas));
	            String hora = rs.getString("hora");
	            res.add(hora);
	            String fecha = rs.getString("fecha");
	            res.add(fecha);
	            int idDoctor = rs.getInt("DNIdoctor");
	            res.add(String.valueOf(idDoctor));

	            int idTratamientos = rs.getInt("idtratamiento");
	            res.add(String.valueOf(idTratamientos));
	            int idPacientes = rs.getInt("DNIpaciente");
	            res.add(String.valueOf(idPacientes));
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    boolean existe=false;
	    if (rs!=null) {
	    	existe=true;
	    	return existe;
	    }else {
	    	existe=false;
	    	return existe;
	    }
	}
	public boolean comprobarCitasPaciente(String horaIn, String fechaIn,String doctorIn,String paciente) {
	    ArrayList<String> res = new ArrayList<>();
	    res=null;
	    Connection cn = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    if (res == null) {
	    	res= new ArrayList<>();
		}
	    try {
	        cn = this.conectar();
	        stm = cn.createStatement();
	        rs = stm.executeQuery("SELECT * FROM citas "
	        		+ "WHERE hora = '"+horaIn+"' AND "
	        		+ "fecha = '"+fechaIn+"' AND "
	        		+ "DNIpaciente = '"+paciente+"' AND DNIdoctor='"+doctorIn+"'");
	        System.out.println();
	        while (rs.next()) {
	            int idCitas = rs.getInt("idcitas");
	            res.add(String.valueOf(idCitas));
	            String hora = rs.getString("hora");
	            res.add(hora);
	            String fecha = rs.getString("fecha");
	            res.add(fecha);
	            int idDoctor = rs.getInt("DNIdoctor");
	            res.add(String.valueOf(idDoctor));
	            int idTratamientos = rs.getInt("idtratamiento");
	            res.add(String.valueOf(idTratamientos));
	            int idPacientes = rs.getInt("DNIpaciente");
	            res.add(String.valueOf(idPacientes));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stm != null) stm.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    boolean existe=false;
	    if (res!=null) {
	    	existe=true;
	    	return existe;
	    }else {
	    	existe=false;
	    	return existe;
	    }
	}

	 public ArrayList<String> ConsultarCitas( String fecha, String hora, String DNIpaciente, String DNIdoctor) {
	      	ArrayList<String> datos=null; 
	    	try {
	      		 Connection cn = null;
	      		 Statement stm = null;
	      		 ResultSet rs = null;
	      		 Conexion controlador = new Conexion();
	      		 cn = controlador.conectar();
	      		 stm = cn.createStatement();
	      		 String consulta ="SELECT * FROM citas "
	 	        		+ "WHERE hora = '"+hora+"' AND "
		        		+ "fecha = '"+fecha+"' AND "
		        		+ "DNIpaciente = '"+DNIpaciente+"' AND DNIdoctor='"+DNIdoctor+"'";
	      		 System.out.println(consulta);
	      		 rs = stm.executeQuery(consulta);
	     		if (datos == null) {
	     			datos= new ArrayList<>();
				}
	      		 while (rs.next()) {
	      			String Shora=rs.getString("hora");
	      			datos.add(Shora);
	      			String Sfecha=rs.getString("fecha");
	      			datos.add(Sfecha);
	      			String SDNIpaciente=rs.getString("DNIpaciente");
	      			datos.add(SDNIpaciente);
	      			String SDNIdoctor=rs.getString("DNIdoctor");
	      			datos.add(SDNIdoctor);
	      		 }

	      	 } catch (SQLException e) {
	      		 e.printStackTrace();
	      	 }  		
	    	System.out.println("dentro del metodo "+datos);
	      	 return datos;


	       }

	
}
