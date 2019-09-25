package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.Banco;
import logica.Cliente;

import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	
	private Banco miBanco = null;
	private Cliente miCliente = null;
	private JTextField txtClienteCodigo;

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
			//Banco banco = new Banco();
			//Cliente cliente = new Cliente();
			RegCliente dialog = new RegCliente(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCliente(Banco banco, Cliente cliente) {
		this.miBanco = banco;
		this.miCliente = cliente;
		setAlwaysOnTop(false);
		
		if(miCliente == null)
		{
			setTitle("Registrar Cliente");
		}
		else
		{
			setTitle("Modificando a: "+miCliente.getNombre()+" "+miCliente.getApellidos());
		}
		
		setBackground(SystemColor.activeCaptionBorder);
		setResizable(false);
		setBounds(100, 100, 347, 433);
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
			lblCdula.setBounds(17, 39, 82, 23);
			panel.add(lblCdula);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(17, 101, 82, 23);
			panel.add(lblNombre);
			
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(17, 163, 82, 23);
			panel.add(lblApellidos);
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
			lblTelfono.setBounds(17, 225, 82, 29);
			panel.add(lblTelfono);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(99, 38, 202, 29);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(99, 100, 202, 29);
			panel.add(txtNombre);
			
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(99, 162, 202, 29);
			panel.add(txtApellido);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(99, 224, 202, 29);
			panel.add(txtTelefono);
			
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(17, 287, 82, 23);
			panel.add(lblCdigo);
			
			txtClienteCodigo = new JTextField();
			txtClienteCodigo.setEditable(false);
			txtClienteCodigo.setColumns(10);
			txtClienteCodigo.setText("P-"+miBanco.getCodigoCliente());
			txtClienteCodigo.setBounds(99, 281, 202, 29);
			panel.add(txtClienteCodigo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(miCliente == null)
				{
					btnRegistrar.setText("Registrar");
				}
				else
				{
					btnRegistrar.setText("Modificar");
					txtClienteCodigo.setText(miCliente.getId());
					txtCedula.setText(miCliente.getCedula());
					txtNombre.setText(miCliente.getNombre());
					txtApellido.setText(miCliente.getApellidos());
					txtTelefono.setText(miCliente.getTelefono());
					
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(miCliente == null)
						{
							Cliente unCliente = new Cliente(txtClienteCodigo.getText(), txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), 
									txtTelefono.getText(), 0);
							if(txtCedula.getText()!="" && txtNombre.getText().length()>2 
									&& txtApellido.getText().length()>2 && txtTelefono.getText().length() > 4) 
							{
								JOptionPane.showMessageDialog(null, "Operación Sastifactoria", "Notificación", JOptionPane.INFORMATION_MESSAGE);
								miBanco.insertarCliente(unCliente);
								clean();
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "Operación Errónea", "Notificación", JOptionPane.INFORMATION_MESSAGE);
							}
							
						}
						else
						{
							if(txtCedula.getText()!="" && txtNombre.getText().length()>2 
									&& txtApellido.getText().length()>2 && txtTelefono.getText().length() > 4)
							{
								miCliente.setCedula(txtCedula.getText());
								miCliente.setNombre(txtNombre.getText());
								miCliente.setApellidos(txtApellido.getText());
								miCliente.setTelefono(txtTelefono.getText());
								miCliente.setPuntos(miCliente.getPuntos());
								listClientes.loadClientes();
								dispose();
							}
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
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
		
		txtApellido.setText("");
		txtCedula.setText("");
		txtTelefono.setText("");
		txtNombre.setText("");
		txtClienteCodigo.setText("P-"+miBanco.getCodigoCliente());
	}
}
