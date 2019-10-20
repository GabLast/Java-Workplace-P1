package visual;

import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Articulo;
import logico.Biblioteca;
import logico.Libro;
import logico.Publicacion;
import logico.Revista;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PublicList extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private static JButton btnEliminar;
	private static JButton btnModificar;
	private int code;
	JComboBox cbxPublicType;



	/**
	 * Create the dialog.
	 * @param fed 
	 */
	public PublicList() {
		setTitle("Listado de Publicaciones");
		setBounds(100, 100, 650, 376);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado de Deportistas:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 624, 293);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 604, 228);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			/*String country;
				int delivery;*/
				if(table.getSelectedRow()>=0){
					btnEliminar.setEnabled(true);
					btnModificar.setEnabled(true);
					int index = table.getSelectedRow();
					code = (int)table.getModel().getValueAt(index, 0);
					/*country = (String)tableSupply.getModel().getValueAt(index, 1);
					delivery = (Integer)tableSupply.getModel().getValueAt(index, 2);
					textFldSupplyName.setText(name);
					spnDelivery.getModel().setValue(Integer.valueOf(delivery));
					cbCountry.getModel().setSelectedItem(new String(country));*/
				}
			}
		});
		tableModel = new DefaultTableModel();
		String[] columnNames = {"Código","Título", "Autor", "Materia","Tipo"};
		tableModel.setColumnIdentifiers(columnNames);
		loadSportMans(0);
		scrollPane.setViewportView(table);
		
		JLabel lblTipoDePublicacin = new JLabel("Tipo de Publicaci\u00F3n:");
		lblTipoDePublicacin.setBounds(10, 29, 116, 14);
		panel.add(lblTipoDePublicacin);
		
		cbxPublicType = new JComboBox();
		cbxPublicType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = cbxPublicType.getSelectedIndex();
				loadSportMans(selection);
			}
		});
		cbxPublicType.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Art\u00EDculos", "Libros", "Revistas"}));
		cbxPublicType.setBounds(127, 26, 157, 20);
		panel.add(cbxPublicType);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*RegisterSportMan mod = new RegisterSportMan(fed,"Modificar Atleta",code);
					mod.setModal(true);
					mod.setLocationRelativeTo(null);
					mod.setVisible(true);*/
				}
			});
			btnModificar.setEnabled(false);
			buttonPane.add(btnModificar);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*SportMan aux = fed.getSportManByCode(code);
					  int delete = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar al Deportista: " + aux.getName(), null, JOptionPane.YES_NO_OPTION);
						    if (delete == JOptionPane.YES_OPTION)
						    {
						       
						    	fed.deleteSportMan(code);
								loadSportMans();
						    }
						
						
						*/
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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



	public static void loadSportMans(int selection) {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		switch (selection) {
		case 0:
			for (Publicacion aux : Biblioteca.getInstance().getMisPublicaciones()) {
				fila[0] = aux.getId();
				fila[1] = aux.getTitulo();
				fila[2] = aux.getAutor();
				fila[3] = aux.getMateria();
				if(aux instanceof Libro)
					fila[4] = "Libro";
				if(aux instanceof Revista)
					fila[4] = "Revista";
				if(aux instanceof Articulo)
					fila[4] = "Artículo";
				
				tableModel.addRow(fila);
			}
			break;
		case 1:
			for (Publicacion aux : Biblioteca.getInstance().getMisPublicaciones()) {
				if(aux instanceof Articulo){
				fila[0] = aux.getId();
				fila[1] = aux.getTitulo();
				fila[2] = aux.getAutor();
				fila[3] = aux.getMateria();
				fila[4] = "Artículo";
				
				tableModel.addRow(fila);
				}
			}
			break;	
		case 2:
			for (Publicacion aux : Biblioteca.getInstance().getMisPublicaciones()) {
				if(aux instanceof Libro){
				fila[0] = aux.getId();
				fila[1] = aux.getTitulo();
				fila[2] = aux.getAutor();
				fila[3] = aux.getMateria();
				fila[4] = "Libro";
				
				tableModel.addRow(fila);
				}
			}
			break;	
		case 3:
			for (Publicacion aux : Biblioteca.getInstance().getMisPublicaciones()) {
				if(aux instanceof Revista){
				fila[0] = aux.getId();
				fila[1] = aux.getTitulo();
				fila[2] = aux.getAutor();
				fila[3] = aux.getMateria();
				fila[4] = "Revista";
				
				tableModel.addRow(fila);
				}
			}
			break;	
		}
		
		
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(60);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(130);
		columnModel.getColumn(4).setPreferredWidth(81);
		/*if(tableModel.getRowCount()==0){
			btnEliminar.setEnabled(false);
			btnModificar.setEnabled(false);
		}*/
		
		
	}
}
