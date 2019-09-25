package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.Banco;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IngresarSaldo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private Banco miBanco = null;
	private JTextField txtCodigo;
	private JTextField txtDinero;
	
	JButton btnConfirmar;
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
			IngresarSaldo dialog = new IngresarSaldo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IngresarSaldo(Banco banco) {
		setResizable(false);
		setTitle("Ingresar saldo");
		this.miBanco = banco;
		setBounds(100, 100, 413, 260);
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
			{
				JLabel lblCantidadAIngresar = new JLabel("C\u00F3digo de cuenta: ");
				lblCantidadAIngresar.setBounds(17, 46, 166, 23);
				panel.add(lblCantidadAIngresar);
			}
			{
				JLabel label = new JLabel("Cantidad a ingresar: ");
				label.setBounds(17, 115, 186, 23);
				panel.add(label);
			}
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(198, 43, 166, 29);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			txtDinero = new JTextField();
			txtDinero.setColumns(10);
			txtDinero.setBounds(198, 112, 166, 29);
			panel.add(txtDinero);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			{
				btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Double.valueOf(txtDinero.getText()) >= 0 && miBanco.buscarIndiceCuenta(txtCodigo.getText()) > -1) 
						{
							JOptionPane.showMessageDialog(null, "Operación Sastifactoria", "Notificación", JOptionPane.INFORMATION_MESSAGE);
							miBanco.ingresarDinero(txtCodigo.getText(), Double.valueOf(txtDinero.getText()));
							clean();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Operación Errónea", "Notificación", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
				});
				btnConfirmar.setActionCommand("OK");
				buttonPane.add(btnConfirmar);
				getRootPane().setDefaultButton(btnConfirmar);
			}
			{
				JButton btnCancelar = new JButton("Salir");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void clean() {

		txtCodigo.setText("");
		txtDinero.setText("");
	}
}
