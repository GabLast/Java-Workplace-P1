package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.Banco;
import javax.swing.UIManager;

public class RevisionMensual extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Banco miBanco = null;
	private JTextField txtCodigo;
	
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
			RevisionMensual dialog = new RevisionMensual(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RevisionMensual(Banco banco) {
		setResizable(false);
		setTitle("Revisión Mensual");
		this.miBanco = banco;
		setBounds(100, 100, 413, 192);
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
				JLabel lblCantidadAIngresar = new JLabel("C\u00F3digo del cliente: ");
				lblCantidadAIngresar.setBounds(17, 46, 166, 23);
				panel.add(lblCantidadAIngresar);
			}
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(198, 43, 166, 29);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			{
				btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(miBanco.buscarIndiceCliente(txtCodigo.getText()) > -1) 
						{
							JOptionPane.showMessageDialog(null, "Operación Sastifactoria", "Notificación", JOptionPane.INFORMATION_MESSAGE);
							miBanco.revisionMensual(txtCodigo.getText());
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
	}
}