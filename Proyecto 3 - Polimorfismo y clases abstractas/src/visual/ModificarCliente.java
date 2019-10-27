package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import logico.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class ModificarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Cliente miCliente = null;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
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
			ModificarCliente dialog = new ModificarCliente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarCliente(Cliente miCliente) {
		this.miCliente = miCliente;
		setTitle("Modificando Cliente");
		setResizable(false);
		setBounds(100, 100, 399, 349);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			{
				JLabel label = new JLabel("C\u00E9dula:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				label.setBounds(17, 32, 73, 23);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				label.setBounds(17, 87, 88, 23);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				label.setBounds(17, 142, 88, 23);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Tel\u00E9fono:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				label.setBounds(17, 197, 88, 23);
				panel.add(label);
			}
			{
				txtCedula = new JTextField();
				txtCedula.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				txtCedula.setColumns(10);
				txtCedula.setBounds(107, 29, 244, 29);
				txtCedula.setText(miCliente.getCedula());
				panel.add(txtCedula);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				txtNombre.setColumns(10);
				txtNombre.setBounds(107, 84, 244, 29);
				txtNombre.setText(miCliente.getNombre());
				panel.add(txtNombre);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(107, 139, 244, 29);
				txtDireccion.setText(miCliente.getDireccion());
				panel.add(txtDireccion);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(107, 194, 244, 29);
				txtTelefono.setText(miCliente.getTelefono());
				panel.add(txtTelefono);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnModi = new JButton("Modificar");
				btnModi.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				btnModi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtCedula.getText().length() >=1 && txtNombre.getText().length() >= 1 && txtTelefono.getText().length() >= 1
								&& txtDireccion.getText().length() >= 1)
						{
//							txtNombre.setText(txtNombre.getText());
//							txtDireccion.setText(txtDireccion.getText());
//							txtTelefono.setText(txtTelefono.getText());
//							txtCedula.setText(txtCedula.getText());
							
							miCliente.setCedula(txtCedula.getText());
							miCliente.setNombre(txtNombre.getText());
							miCliente.setTelefono(txtTelefono.getText());
							miCliente.setDireccion(txtDireccion.getText());
							
							JOptionPane.showMessageDialog(null, "Modificación realizada", "Notificación", JOptionPane.INFORMATION_MESSAGE);
							ListarClientes.loadClientes();
							dispose();
						}
					}
				});
				btnModi.setActionCommand("OK");
				buttonPane.add(btnModi);
				getRootPane().setDefaultButton(btnModi);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
