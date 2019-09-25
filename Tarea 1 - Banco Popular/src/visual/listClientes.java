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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logica.Banco;
import logica.Cliente;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	
	private JButton btnCrearCuenta;
	private JButton	btnModificar;
	private JButton	btnEliminar;
	
	private static Banco banco;
	private String idCliente = "";
	
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
			Banco banco = new Banco();
			listClientes dialog = new listClientes(banco);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public listClientes(Banco banco) {
		
		this.banco = banco;
		setResizable(false);
		setTitle("Listado de clientes");
		setBounds(100, 100, 693, 431);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
					
					
					String[] header = {"ID","Nombre","Apellidos","Cédula","Teléfono", "Puntos"};
					model.setColumnIdentifiers(header);
					
					table = new JTable();
					
					loadClientes();
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>-1){
								int index = table.getSelectedRow();
								btnCrearCuenta.setEnabled(true);
								btnModificar.setEnabled(true);
								btnEliminar.setEnabled(true);
								idCliente = String.valueOf(table.getValueAt(index, 0));
								
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
				btnCrearCuenta = new JButton("Crear cuenta bancaria");
				btnCrearCuenta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente unCliente = banco.buscarCliente(idCliente);
						new RegCuenta(banco, null, unCliente).setVisible(true);;
					}
				});
				btnCrearCuenta.setEnabled(false);
				buttonPane.add(btnCrearCuenta);
			}
			{
				btnModificar = new JButton("Modificar cliente");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!idCliente.equals("")) {
							
							Cliente clienteModificar = banco.buscarCliente(idCliente);
							
							int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar al cliente: " 
									   + clienteModificar.getNombre(),"Información",JOptionPane.WARNING_MESSAGE);
							
							if(option == JOptionPane.OK_OPTION)
							{
								new RegCliente(banco, clienteModificar).setVisible(true);
							}
							
						}	 
					}
				});
				btnModificar.setEnabled(false);
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!idCliente.equals(""))
						{
							
							Cliente cliente = banco.buscarCliente(idCliente);
							int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar al cliente: " 
									   + cliente.getNombre(),"Información",JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION)
							{
								
								banco.eliminarCliente(idCliente);
								loadClientes();
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);	
							
							  }
						}
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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
		loadClientes();
	}
	
	public static void loadClientes() 
	{
		model.setRowCount(0);
		
		row = new Object[model.getColumnCount()];
		for (int i = 0; i < banco.getCantClientes(); i++) 
		{
			row[0] = banco.getClientes()[i].getId();
			row[1] = banco.getClientes()[i].getNombre();
			row[2] = banco.getClientes()[i].getApellidos();
			row[3] = banco.getClientes()[i].getCedula();
			row[4] = banco.getClientes()[i].getTelefono();
			row[5] = banco.getClientes()[i].getPuntos();
			model.addRow(row);
		}
	}
}
