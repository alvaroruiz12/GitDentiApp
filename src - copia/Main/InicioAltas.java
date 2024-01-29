package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BBDD.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTable;

public class InicioAltas extends JDialog  {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField tf1;
		private JTextField tf2;
		private JTextField tf3;
		private JTextField tf4;
		private JTextField tf5;
		private JTextField tf6;
		private JComboBox topoConsulta = new JComboBox();
		private Paciente paciente = new Paciente();
		
		
		private String stf1="Introduzca nombre",stf2= "Introduzca apellido",
				stf3 = "Introduzca DNI",stf4 = "Introduzca correo",stf5 = "Introduzca telefono",stf6="Introduzca edad";
		

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			
			ArrayList<String> b = null;
			Conexion con = null;

	
		
		
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
				
						InicioAltas altas = new InicioAltas(b,con,null,true);
						//metodo para que la pantalla sea en pantalla completa
						((JDialog) altas).setSize(800,650);
						altas.setVisible(true);
						altas.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public InicioAltas(ArrayList<String> a, Conexion con,InicioAdmin parent,boolean modal) {
			super(parent,modal);
			
			ArrayList<String> usuario = a;
			Conexion conexion = con;
			
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 750, 650);
			
			contentPane = new JPanel();
			contentPane.setBackground(new Color(235, 235, 235));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
					contentPane.setLayout(null);
										
					//combobox
					
					topoConsulta.setBounds(39, 334, 229, 42);
					topoConsulta.setForeground(new Color(0, 0, 0));
					topoConsulta.setBackground(new Color(207, 241, 255));
					topoConsulta.setFont(new Font("Calibri", Font.PLAIN, 28));
					((JLabel)topoConsulta.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
					topoConsulta.setAlignmentX(CENTER_ALIGNMENT);
					topoConsulta.setAlignmentY(CENTER_ALIGNMENT);

					contentPane.add(topoConsulta);
					//añadir todo al combobox
					topoConsulta.addItem("Paciente");
					topoConsulta.addItem("Doctor");
					topoConsulta.addItem("Proveedor");
					
					
					
					
					//AÑADIR EN LA TABLA EL SELECCIONADO
					
					//DISEÑO
					
					//PRIMERA SELECCION
					
					tf1 = new JTextField();
					tf1.setForeground(new Color(192, 192, 192));
					tf1.setText("Introduzca nombre");
					tf1.setFont(new Font("Calibri", Font.PLAIN, 15));
					tf1.setBounds(398, 125, 189, 30);
					contentPane.add(tf1);
					tf1.setColumns(10);
					
				
				

			
					
					//SEGUNDA SELECCION
					//text field apellidos
					tf2 = new JTextField();
					tf2.setForeground(new Color(192, 192, 192));
					tf2.setText("Introduzca Apellidos");
					tf2.setFont(new Font("Calibri", Font.PLAIN, 15));
					tf2.setBounds(398, 198, 189, 30);
					contentPane.add(tf2);
					tf2.setColumns(10);
	                
					
			
					
					
					//BOTON FUNCIONALIDAD
					
					JButton btnAnadir = new JButton("+");
					btnAnadir.setBounds(297, 334, 52, 42);
					btnAnadir.setFont(new Font("Calibri", Font.PLAIN, 28));
					btnAnadir.setForeground(new Color(0, 0, 0));
					btnAnadir.setBackground(new Color (207, 241, 255));
					btnAnadir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							String seleccionado=(String)topoConsulta.getSelectedItem();
							
							switch(seleccionado) {
							case "Paciente"://Paciente
								
								String sentencia="Insert into dentiapp.pacientes (DNIpaciente,Nombre,Apellidos,correo,telefono,edad)values('"
										+tf3.getText()+"','"+tf1.getText()+"','"+tf2.getText()+"','"+tf4.getText()+"',"+tf5.getText()+","+tf6.getText()+");";
							
								
								
								boolean status = false;
								status = conexion.insertar(conexion,sentencia);
								if (status=true) {
									
								}
																
								break;
							case "Doctor":
								String sentencia2="Insert into dentiapp.doctor (DNI,Nombre,usuarios_idusuarios,especialidad_idespecialidad)values('"
										+tf1.getText()+"','"+tf2.getText()+"',"+tf3.getText()+"," + tf4.getText() +");";
							
								
								boolean status2 = false;
								status2 = conexion.insertar(conexion, sentencia2);
								if (status2=true) {
									
								}
									
	
								break;
								
								
							case "Proveedor":
								String sentencia3="Insert into dentiapp.doctor (CIF,nombre,telefono,correo,direccion)values('"
										+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+ ","+ tf4.getText() + "," + tf5.getText() +");";
								
								
								
								boolean status3 = false;
								status3 = conexion.insertar(conexion,sentencia3);
								if (status3=true) {
									
								}
				
								break;
								
							
							}
							
							  
							
						}
					});
					contentPane.add(btnAnadir);
					
					JLabel lblFotoUser = new JLabel();
					lblFotoUser.setBounds(94, 125, 170, 170);
					ImageIcon imagen= new ImageIcon(getClass().getResource("user.png"));
					ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
					lblFotoUser.setIcon(imagen2);
					contentPane.add(lblFotoUser);
					
					JButton btnVolver = new JButton("Volver");
					btnVolver.setBounds(10, 43, 76, 64);
					btnVolver.setBackground(new Color(207, 241, 255));
					btnVolver.setForeground(new Color(255, 255, 255));
					btnVolver.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							dispose();
						}
					});
					ImageIcon i7 = new ImageIcon(getClass().getResource("volver.png"));
					ImageIcon i8 = new ImageIcon(i7.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
					btnVolver.setIcon(i8);
					contentPane.add(btnVolver);
					
					tf3 = new JTextField();
					tf3.setForeground(new Color(192, 192, 192));
					tf3.setText("Introduzca DNI");
					tf3.setFont(new Font("Calibri", Font.PLAIN, 15));
					tf3.setBounds(398, 265, 189, 30);
					contentPane.add(tf3);
					tf3.setColumns(10);
					
					tf4 = new JTextField();
					tf4.setForeground(new Color(192, 192, 192));
					tf4.setText("Introduzca correo electronico");
					tf4.setFont(new Font("Calibri", Font.PLAIN, 15));
					tf4.setBounds(398, 334, 189, 30);
					contentPane.add(tf4);
					tf4.setColumns(10);
					
					tf5 = new JTextField();
					tf5.setForeground(new Color(192, 192, 192));
					tf5.setText("Introduzca el telefono");
					tf5.setFont(new Font("Calibri", Font.PLAIN, 15));
					tf5.setBounds(398, 406, 189, 30);
					contentPane.add(tf5);
					tf5.setColumns(10);
					
					tf6 = new JTextField();
					tf6.setForeground(new Color(192, 192, 192));
					tf6.setText("Introduzca edad");
					tf6.setFont(new Font("Calibri", Font.PLAIN, 15));
					tf6.setBounds(398, 468, 189, 30);
					contentPane.add(tf6);
					tf6.setColumns(10);
					
					
			
					
					
					
					
					//-----------------------Para que desaparezca y aparezca cuando este vacio----------------
					
					
					tf1.addMouseListener(new MouseAdapter() {
						
						public void mouseClicked(MouseEvent e) {
							
								tf1.setText("");
								tf1.setForeground(new Color(0,0,0));
								
							
						}
						
					});
					
					tf1.addFocusListener(new FocusAdapter() {
						@Override
						public void focusLost(FocusEvent e) {
							
							
							if(tf1.getText().isEmpty()) {
								
								
								tf1.setText(stf1);
								tf1.setForeground(new Color(192,192,192));
								
							}
						}
					});
					tf2.addMouseListener(new MouseAdapter() {
						
						public void mouseClicked(MouseEvent e) {
							
							tf2.setText("");
							tf2.setForeground(new Color(0,0,0));
							
						}
						
					});
					
					tf2.addFocusListener(new FocusAdapter() {
						@Override
						public void focusLost(FocusEvent e) {
							
							
							if(tf2.getText().isEmpty()) {
								
								
								tf2.setText(stf2);
								tf2.setForeground(new Color(192,192,192));
							}
						}
					});
					
					tf3.addMouseListener(new MouseAdapter() {
						
						public void mouseClicked(MouseEvent e) {
							
							tf3.setText("");
						
							tf3.setForeground(new Color(0,0,0));
							
						}
						
					});
					
					tf3.addFocusListener(new FocusAdapter() {
						@Override
						public void focusLost(FocusEvent e) {
							
							
							if(tf3.getText().isEmpty()) {
								
								
								tf3.setText(stf3);
								tf3.setForeground(new Color(192,192,192));
							}
						}
					});
					tf4.addMouseListener(new MouseAdapter() {
						
						public void mouseClicked(MouseEvent e) {
							
							tf4.setText("");
							tf4.setForeground(new Color(0,0,0));
							
						}
						
					});
					
					tf4.addFocusListener(new FocusAdapter() {
						@Override
						public void focusLost(FocusEvent e) {
							
							
							if(tf4.getText().isEmpty()) {
								
								
								tf4.setText(stf4);
								tf4.setForeground(new Color(192,192,192));
							}
						}
					});
					tf5.addMouseListener(new MouseAdapter() {
						
						public void mouseClicked(MouseEvent e) {
							
							tf5.setText("");
							tf5.setForeground(new Color(0,0,0));
							
						}
						
					});
					
					tf5.addFocusListener(new FocusAdapter() {
						@Override
						public void focusLost(FocusEvent e) {
							
							
							if(tf5.getText().isEmpty()) {
								
								
								tf5.setText(stf5);
								tf5.setForeground(new Color(192,192,192));
							}
						}
					});
					tf6.addMouseListener(new MouseAdapter() {
						
						public void mouseClicked(MouseEvent e) {
							
							tf6.setText("");
							tf6.setForeground(new Color(0,0,0));
						}
						
					});
					
					tf6.addFocusListener(new FocusAdapter() {
						@Override
						public void focusLost(FocusEvent e) {
							
							
							if(tf6.getText().isEmpty()) {
								
								
								tf6.setText(stf6);
								tf6.setForeground(new Color(192,192,192));
							}
						}
					});
					
					
					
					
					
					
					
					
					//----------------Seleccion del combobox---------------------------------
					
					topoConsulta.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						        if (e.getSource()==topoConsulta) {
						        	String seleccionado=(String)topoConsulta.getSelectedItem();
									
									switch(seleccionado) {
									case "Paciente"://Paciente
										tf4.setVisible(true);
										tf5.setVisible(true);
										tf6.setVisible(true);
										
										
										stf1="Introduzca nombre";
										stf2= "Introduzca apellido";
										stf3 = "Introduzca DNI";
										stf4 = "Introduzca correo";
										stf5 = "Introduzca telefono";
										stf6="Introduzca edad";
												
										
										//metodo borrar lo que tegan los edit text y poner el texto predeterminado correspondiente
										tf1.setText(stf1);
										tf2.setText(stf2);
										tf3.setText(stf3);
										tf4.setText(stf4);
										tf5.setText(stf5);
										tf6.setText(stf6);
											
										
										break;
									case "Doctor":
										
										tf5.setVisible(false);
										tf6.setVisible(false);
										clearTxtField(tf1);
										clearTxtField(tf2);
										clearTxtField(tf3);
										
										stf1="Introduzca nombre";
										stf2= "Introduzca dni";
										stf3 = "Introduzca idusuario";
										stf4 = "Introduzca especialidad";
										
										//metodo borrar lo que tegan los edit text y poner el texto predeterminado correspondiente
										
										tf1.setText(stf1);
										tf2.setText(stf2);
										tf3.setText(stf3);
										tf4.setText(stf4);
										
										
										
										break;
										
										
									case "Proveedor":
									
										tf4.setVisible(true);
										tf5.setVisible(true);
										tf6.setVisible(false);
										
										
										stf1="Introduzca CIF";
										stf2= "Introduzca nombre";
										stf3 = "Introduzca telefono";
										stf4 = "Introduzca correo";
										stf5 = "Introduzca direccion";
										
										//metodo borrar lo que tegan los edit text y poner el texto predeterminado correspondiente
										
										tf1.setText(stf1);
										tf2.setText(stf2);
										tf3.setText(stf3);
										tf4.setText(stf4);
										tf5.setText(stf5);

										
										
										break;
										
									
									}
						        }
						    }
					});
					
					
					

					//JLabel de fondo
					JLabel fondo = new JLabel();
					fondo.setBounds(0, 0, 750, 650);

					ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
					ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
					fondo.setIcon(imagen6);
					contentPane.add(fondo);
					
		}public void clearTxtField(JTextField text) {
			text.setText("");
		}
}
