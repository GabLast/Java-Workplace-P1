package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class RegCuenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPropietario;
	private JTextField textField;

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
			RegCuenta dialog = new RegCuenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCuenta() {
		setResizable(false);
		setTitle("Registrar Cuenta");
		setBounds(100, 100, 784, 335);
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
			{
				JLabel lblDueo = new JLabel("Propietario:");
				lblDueo.setBounds(17, 32, 96, 23);
				panel.add(lblDueo);
			}
			{
				JLabel lblCdigoDeCuenta = new JLabel("C\u00F3digo de cuenta:");
				lblCdigoDeCuenta.setBounds(268, 32, 165, 23);
				panel.add(lblCdigoDeCuenta);
			}
			{
				JLabel lblFechaDeApertura = new JLabel("Fecha de apertura:");
				lblFechaDeApertura.setBounds(17, 87, 165, 23);
				panel.add(lblFechaDeApertura);
			}
			{
				JLabel lblFechaDeCorte = new JLabel("Fecha de corte:");
				lblFechaDeCorte.setBounds(268, 87, 138, 23);
				panel.add(lblFechaDeCorte);
			}
			{
				JLabel lblEstadoDeCuenta = new JLabel("Estado de cuenta:");
				lblEstadoDeCuenta.setBounds(17, 142, 165, 23);
				panel.add(lblEstadoDeCuenta);
			}
			{
				JLabel lblTipoDeCuenta = new JLabel("Tipo de cuenta:");
				lblTipoDeCuenta.setBounds(17, 197, 165, 23);
				panel.add(lblTipoDeCuenta);
			}
			{
				txtPropietario = new JTextField();
				txtPropietario.setEditable(false);
				txtPropietario.setBounds(133, 32, 118, 23);
				panel.add(txtPropietario);
				txtPropietario.setColumns(10);
			}
			{
				textField = new JTextField();
				textField.setEditable(false);
				textField.setColumns(10);
				textField.setBounds(427, 32, 88, 23);
				panel.add(textField);
			}
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(404, 84, 40, 29);
			panel.add(comboBox);
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
