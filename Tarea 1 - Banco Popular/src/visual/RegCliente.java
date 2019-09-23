package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			RegCliente dialog = new RegCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCliente() {
		setTitle("Registrar Cliente");
		setBackground(SystemColor.activeCaptionBorder);
		setResizable(false);
		setBounds(100, 100, 327, 388);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setBorder(new TitledBorder(null, "Información", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCdula = new JLabel("C\u00E9dula:");
			lblCdula.setBounds(17, 48, 82, 23);
			panel.add(lblCdula);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(17, 117, 82, 23);
			panel.add(lblNombre);
			
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(17, 187, 82, 23);
			panel.add(lblApellidos);
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setBounds(17, 257, 82, 23);
			panel.add(lblTelfono);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(76, 47, 202, 24);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(76, 116, 202, 24);
			panel.add(txtNombre);
			
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(76, 186, 202, 24);
			panel.add(txtApellido);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(76, 256, 202, 24);
			panel.add(txtTelefono);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
