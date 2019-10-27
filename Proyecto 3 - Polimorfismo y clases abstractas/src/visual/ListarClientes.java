package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Cliente;
import logico.Complejo;
import java.awt.Font;

public class ListarClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private static DefaultTableModel model;
	private static Object[] row;
	private static JTable table;
	private String cedula = "";
	JButton btnModificar;
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
			ListarClientes dialog = new ListarClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarClientes() {
		
		setTitle("Lista de clientes");
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		dim.width *= .50;
		dim.height *= .50;
		super.setSize(dim.width, dim.height);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
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
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel() {
						@Override
					    public boolean isCellEditable(int row, int column) {
					       //all cells false
					       return false;
					    }
					};
					
					
					String[] header = {"Cédula", "Nombre", "Dirección", "Teléfono"};
					model.setColumnIdentifiers(header);
					
					table = new JTable();
					
					loadClientes();
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>-1){
								int index = table.getSelectedRow();
								cedula = String.valueOf(table.getValueAt(index, 0));
								btnModificar.setEnabled(true);
								
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
				JButton cancelButton = new JButton("Salir");
				cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					btnModificar = new JButton("Modificar");
					btnModificar.setFont(new Font("Times New Roman", Font.PLAIN, 19));
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) 
						{
							if(!cedula.equals("")) 
							{
								
								Cliente clienteModi = Complejo.getInstance().buscarClienteByCedula(cedula);
								
								//System.out.println(clienteModi.getCedula());
								int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar la cuenta: " 
										   + clienteModi.getCedula(),"Información",JOptionPane.WARNING_MESSAGE);
								
								if(option == JOptionPane.OK_OPTION && clienteModi != null)
								{
									new ModificarCliente(clienteModi).setVisible(true);
									//new Facturar(true, clienteModi);
								}
								
							}
						}
					});
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public static void loadClientes() 
	{
		model.setRowCount(0);
		Complejo unComp = Complejo.getInstance();
		//{"Cédula", "Nombre", "Dirección", "Teléfono"};
		row = new Object[model.getColumnCount()];
		for (int i = 0; i < unComp.getClientes().size(); i++) 
		{
			row[0] = unComp.getClientes().get(i).getCedula();
			row[1] = unComp.getClientes().get(i).getNombre();
			row[2] = unComp.getClientes().get(i).getDireccion();
			row[3] = unComp.getClientes().get(i).getTelefono();
			model.addRow(row);
		}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);
	}
}
