package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Biblioteca;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Biblioteca aux = new Biblioteca();
					Principal frame = new Principal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Biblioteca Nacional");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 417);
		dim = super.getToolkit().getScreenSize(); 
		super.setSize(dim.width, dim.height-100);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistroDeClientes = new JMenu("Registro de Clientes");
		menuBar.add(mnRegistroDeClientes);
		
		JMenu mnRegistroDePublic = new JMenu("Registro de Publicaciones");
		menuBar.add(mnRegistroDePublic);
		
		JMenuItem mntmRegistro = new JMenuItem("Registro de Clientes");
		mnRegistroDeClientes.add(mntmRegistro);
		
		JMenuItem mntmRegistroPublic = new JMenuItem("Registro de Publicaciones");
		mntmRegistroPublic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegPublic reg = new RegPublic("Registro de Publicaciones",0);
				reg.setModal(true);
				reg.setLocationRelativeTo(null);
				reg.setVisible(true);
				
			}
		});
		mnRegistroDePublic.add(mntmRegistroPublic);
		
		JMenu mnListadoDePublic = new JMenu("Listado de Publicaciones");
		menuBar.add(mnListadoDePublic);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mntmListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PublicList list = new PublicList();
				list.setModal(true);
				list.setLocationRelativeTo(null);
				list.setVisible(true);
			}
		});
		mnListadoDePublic.add(mntmListado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
