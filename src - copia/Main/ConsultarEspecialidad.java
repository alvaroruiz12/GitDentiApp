package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BBDD.Conexion;

public class ConsultarEspecialidad extends JDialog {

	JTable table_1 = new JTable();
	DefaultTableModel model;
	Especialidad especialidad= new Especialidad();
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> b = null;
		Conexion con = null;
		try {
			ConsultarEspecialidad dialog = new ConsultarEspecialidad(b,con,null,true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarEspecialidad(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		setBounds(100, 100, 450, 300);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		
		// scroll panel de la tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 71, 191, 139);
		scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
		getContentPane().add(scrollPane);

		// Personalizo la tabla
		//objeto para editar encabezado
		JTableHeader header = table_1.getTableHeader(); 
		header.setForeground(Color.black); 
		header.setBackground(new Color(207, 241, 255));
		table_1.setIntercellSpacing(new Dimension(4, 4));
		// ajusta el alto de las columnas de la tabla
		table_1.setRowHeight(30);
		// Cambia el color de fondo de las filas seleccionadas
		table_1.setSelectionBackground(new Color(217, 217, 217)); 
		table_1.setSelectionForeground(Color.BLACK);
		table_1.setModel(model = new DefaultTableModel(new Object[][] {
		}, new String[] { "Nombre" }));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);
		especialidad.CargarTabla(model, table_1);
		
		//boton para volver a inicio
				JButton btnVolver = new JButton("VOLVER");
				
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnVolver.setBounds(329, 0, 105, 50);
				ImageIcon imagen3= new ImageIcon(getClass().getResource("boton.png"));
				ImageIcon imagen4= new ImageIcon(imagen3.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
		       btnVolver.setIcon(imagen4);
		       
		       // Eliminar el borde del botón para que la imagen sea visible
		       btnVolver.setBorderPainted(false);
		       btnVolver.setContentAreaFilled(false);

				// Establecer el texto sobre la imagen
				btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
				btnVolver.setVerticalTextPosition(SwingConstants.CENTER);

		       // Personalizar el estilo del texto
				btnVolver.setForeground(Color.WHITE); // Color del texto
				btnVolver.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
				getContentPane().add(btnVolver);
		
				//fondo
				JLabel fondo = new JLabel();
				fondo.setBounds(0, 0, 434, 261);
				ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
				ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
				getContentPane().setLayout(null);
				fondo.setIcon(imagen6);
				getContentPane().add(fondo);
		
	}

}
