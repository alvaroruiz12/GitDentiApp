package Main;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTextField;

import BBDD.Conexion;

public class BajaTratamiento extends JDialog {

	private static final long serialVersionUID = 1L;
	Tratamiento tratamiento= new Tratamiento();
	private JTextField NombreTexto;
	private JTextField CosteTexto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<String> b = null;
				Conexion con = null;
				try {
					BajaTratamiento dialog = new BajaTratamiento(b, con, null, true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public BajaTratamiento(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		setBounds(100, 100, 450, 300);

	}

}
