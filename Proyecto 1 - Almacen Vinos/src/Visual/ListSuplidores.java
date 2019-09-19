package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import logic.Almacen;
import logic.Suministrador;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class listSuplidores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private static Almacen alma;
	private String idSupli = "";
	private JButton btnModificar ;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public listSuplidores(Almacen alma) {
		this.alma = alma;
		setResizable(false);
		setTitle("Listado de suministradores");
		setBounds(100, 100, 582, 353);
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
					
					model = new DefaultTableModel();
					String[] header = {"Código","Nombre","País","Tiempo"};
					model.setColumnIdentifiers(header);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>-1){
								int index = table.getSelectedRow();
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								idSupli = String.valueOf(table.getValueAt(index, 0));
								
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
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!idSupli.equals("")) {
							Suministrador aux = alma.buscarSuministrador(idSupli);
							RegSuplidor regSupli = new RegSuplidor(alma, aux);
						}	   
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!idSupli.equals("")){
						   Suministrador aux = alma.buscarSuministrador(idSupli);
						   int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el Suministrador: " + aux.getNombre(),"Información",JOptionPane.WARNING_MESSAGE);
							  if(option == JOptionPane.OK_OPTION){
							
								alma.eliminarSuplidor(idSupli);
								loadSuplidores();
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);	
							
							  }
						 						 
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadSuplidores();
	}

	public static void loadSuplidores() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (int i = 0; i < alma.getCantSumis(); i++) {
			row[0] = alma.getMisSumis()[i].getId();
			row[1] = alma.getMisSumis()[i].getNombre();
			row[2] = alma.getMisSumis()[i].getPais();
			row[3] = alma.getMisSumis()[i].getTiempoEntrega();
			model.addRow(row);
		}
		
	}

}
