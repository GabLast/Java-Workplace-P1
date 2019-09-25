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
import logica.Cuenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegCuenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPropietario;
	private JTextField txtCodigoCuenta;
	private JTextField txtFechaApertura;
	
	private Banco mibanco = null;
	private Cuenta miCuenta = null;
	private Cliente miCliente = null;
	
	JComboBox cbxTipoCuenta;
	JComboBox cbxEstadoCuenta;
	JComboBox cbxDiaCorte;
	
	JButton btnRegistrar;
	
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
		
			RegCuenta dialog = new RegCuenta(null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCuenta(Banco banco, Cuenta cuenta, Cliente cliente) {
		this.mibanco = banco;
		this.miCuenta = cuenta;
		this.miCliente = cliente;
		setResizable(false);
		
		if(miCuenta == null)
		{
			setTitle("Registrar Cuenta");
		}
		else
		{
			setTitle("Modificando la cuenta de: "+ miCuenta.getPropietario().getNombre() 
					+" "+ miCuenta.getPropietario().getApellidos());
		}
		
		setBounds(100, 100, 740, 331);
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
				txtCodigoCuenta = new JTextField();
				txtCodigoCuenta.setEditable(false);
				txtCodigoCuenta.setColumns(10);
				txtCodigoCuenta.setBounds(545, 28, 150, 23);
				txtCodigoCuenta.setText("C-"+mibanco.getCodigoCuenta());
				panel.add(txtCodigoCuenta);
			}
			
			cbxDiaCorte = new JComboBox();
			cbxDiaCorte.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbxDiaCorte.setBounds(545, 76, 150, 26);
			panel.add(cbxDiaCorte);
			{
				txtFechaApertura = new JTextField();
				txtFechaApertura.setEditable(false);
				txtFechaApertura.setColumns(10);
				txtFechaApertura.setBounds(178, 78, 165, 23);
				txtFechaApertura.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
				
				panel.add(txtFechaApertura);
			}
			{
				JLabel lblDueo = new JLabel("Propietario:");
				lblDueo.setBounds(17, 28, 96, 23);
				panel.add(lblDueo);
			}
			{
				JLabel lblCdigoDeCuenta = new JLabel("C\u00F3digo de cuenta:");
				lblCdigoDeCuenta.setBounds(383, 28, 165, 23);
				panel.add(lblCdigoDeCuenta);
			}
			{
				JLabel lblFechaDeApertura = new JLabel("Fecha de apertura:");
				lblFechaDeApertura.setBounds(17, 79, 165, 23);
				panel.add(lblFechaDeApertura);
			}
			{
				JLabel lblFechaDeCorte = new JLabel("D\u00EDa de corte:");
				lblFechaDeCorte.setBounds(383, 79, 132, 23);
				panel.add(lblFechaDeCorte);
			}
			{
				JLabel lblEstadoDeCuenta = new JLabel("Estado de cuenta:");
				lblEstadoDeCuenta.setBounds(17, 130, 165, 23);
				panel.add(lblEstadoDeCuenta);
			}
			{
				JLabel lblTipoDeCuenta = new JLabel("Tipo de cuenta:");
				lblTipoDeCuenta.setBounds(17, 181, 165, 23);
				panel.add(lblTipoDeCuenta);
			}
			{
				txtPropietario = new JTextField();
				txtPropietario.setEditable(false);
				txtPropietario.setBounds(178, 28, 165, 23);
				panel.add(txtPropietario);
				txtPropietario.setColumns(10);
				txtPropietario.setText(miCliente.getNombre() + "{ " + miCliente.getId() + " }");
			}
			
			cbxTipoCuenta = new JComboBox();
			cbxTipoCuenta.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Corriente", "Vivienda", "Fondo de inversi\u00F3n"}));
			cbxTipoCuenta.setBounds(178, 179, 165, 26);
			panel.add(cbxTipoCuenta);
			{
				cbxEstadoCuenta = new JComboBox();
				cbxEstadoCuenta.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Habilitada", "Bloqueada", "Cancelada"}));
				cbxEstadoCuenta.setBounds(178, 128, 165, 26);
				panel.add(cbxEstadoCuenta);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				
				if(miCuenta == null)
				{
					btnRegistrar.setText("Registrar");
				}
				else
				{
					btnRegistrar.setText("Modificar");
					miCuenta.setCodigo(txtCodigoCuenta.getText());
					miCuenta.setEstado(cbxEstadoCuenta.getSelectedItem().toString());
					miCuenta.setFechaCorte(cbxDiaCorte.getSelectedItem().toString());
					miCuenta.setTipoDeCuenta(cbxTipoCuenta.getSelectedItem().toString());
				}
				
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(miCuenta == null)
						{
							Cuenta nuevaCuenta = new Cuenta(txtCodigoCuenta.getText(), txtFechaApertura.getText(), miCliente, cbxDiaCorte.getSelectedItem().toString(),
									cbxEstadoCuenta.getSelectedItem().toString(), cbxTipoCuenta.getSelectedItem().toString(), 0, 0);
							
							if(cbxDiaCorte.getSelectedIndex()>0 && cbxEstadoCuenta.getSelectedIndex()>0 
									&& cbxEstadoCuenta.getSelectedIndex()>0 
									&& !mibanco.verificarTipoCuentaUnico(nuevaCuenta.getPropietario().getId(), cbxTipoCuenta.getSelectedItem().toString()))
							{
								JOptionPane.showMessageDialog(null, "Operación Sastifactoria", "Notificación", JOptionPane.INFORMATION_MESSAGE);
								mibanco.insertarCuenta(nuevaCuenta);
								clean();
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "Operación Errónea", "Notificación", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else
						{
							if(cbxDiaCorte.getSelectedIndex()>0 && cbxEstadoCuenta.getSelectedIndex()>0 
									&& cbxEstadoCuenta.getSelectedIndex()>0
									&& !mibanco.verificarTipoCuentaUnico(miCuenta.getPropietario().getId(), cbxTipoCuenta.getSelectedItem().toString()))
							{
								miCuenta.setCodigo(txtCodigoCuenta.getText());
								miCuenta.setPropietario(miCliente);
								miCuenta.setFechaCorte(cbxDiaCorte.getSelectedItem().toString());
								miCuenta.setEstado(cbxEstadoCuenta.getSelectedItem().toString());
								miCuenta.setTipoDeCuenta(cbxTipoCuenta.getSelectedItem().toString());
								ListaCuentas.loadCuentas();
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
		
		cbxDiaCorte.setSelectedIndex(0);
		cbxEstadoCuenta.setSelectedIndex(0);
		cbxTipoCuenta.setSelectedIndex(0);
		txtCodigoCuenta.setText("C-"+mibanco.getCodigoCuenta());
		
	}
}
