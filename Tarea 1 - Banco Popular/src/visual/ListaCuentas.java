package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Banco;
import logica.Cliente;
import logica.Cuenta;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ListaCuentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	
	private static Banco miBanco = null;
	private String idCuenta = "";
	
	JButton btnModificar;
	JButton btnEliminar;
	
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
			ListaCuentas dialog = new ListaCuentas(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaCuentas(Banco banco) {
		this.miBanco = banco;
		setTitle("Lista de Cuentas");
		setBounds(100, 100, 900, 495);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					
					model = new DefaultTableModel() {
						@Override
					    public boolean isCellEditable(int row, int column) {
					       //all cells false
					       return false;
					    }
					};
					
					
					String[] header = {"Código de cuenta", "Código de propietario", "Tipo", "Estado", "Fecha de apertura", "Día de corte", "Dinero actual", "Puntos"};
					model.setColumnIdentifiers(header);
					
					table = new JTable();
					
					loadCuentas();
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>-1){
								int index = table.getSelectedRow();
								btnModificar.setEnabled(true);
								btnEliminar.setEnabled(true);
								idCuenta = String.valueOf(table.getValueAt(index, 0));
								
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
							if(!idCuenta.equals("")) {
							
							Cuenta cuentaModificar = miBanco.buscarCuenta(idCuenta);
							
							int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar la cuenta: " 
									   + cuentaModificar.getCodigo(),"Información",JOptionPane.WARNING_MESSAGE);
							
							if(option == JOptionPane.OK_OPTION)
							{
								new RegCuenta(miBanco, cuentaModificar, cuentaModificar.getPropietario()).setVisible(true);
							}
							
						}
					}
				});
				btnModificar.setActionCommand("OK");
				btnModificar.setEnabled(false);
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cuenta aBorrar = miBanco.buscarCuenta(idCuenta);
						int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar la cuenta: " 
								   + aBorrar.getCodigo(),"Información",JOptionPane.WARNING_MESSAGE);
						if(option == JOptionPane.OK_OPTION)
						{
							
							banco.eliminarCuenta(idCuenta);
							loadCuentas();
							btnEliminar.setEnabled(false);
							btnModificar.setEnabled(false);	
						
						 }
					}
				});
				btnEliminar.setActionCommand("OK");
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
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
	
	public static void loadCuentas() 
	{
		model.setRowCount(0);
		//String[] header = {"Código", "Propietario", "Tipo", "Estado", "Fecha de apertura", "Fecha de corte", "Dinero actual", "Puntos"};
		row = new Object[model.getColumnCount()];
		for (int i = 0; i < miBanco.getCantCuentas(); i++) 
		{
			row[0] = miBanco.getCuentas()[i].getCodigo();
			row[1] = miBanco.getCuentas()[i].getPropietario().getId();
			row[2] = miBanco.getCuentas()[i].getTipoDeCuenta();
			row[3] = miBanco.getCuentas()[i].getEstado();
			row[4] = miBanco.getCuentas()[i].getFechaApertura();
			row[5] = miBanco.getCuentas()[i].getFechaCorte();
			row[6] = miBanco.getCuentas()[i].getDineroActual();
			row[7] = miBanco.getCuentas()[i].getPuntos();
			model.addRow(row);
		}
	}

}
