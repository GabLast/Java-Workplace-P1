package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.GRAY);
		setResizable(false);
		setTitle("Banco Popular");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 355);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mnClientes.add(mntmRegistrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnClientes.add(mntmListar);
		
		JMenu mnCuentas = new JMenu("Cuentas");
		menuBar.add(mnCuentas);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mnCuentas.add(mntmRegistrar_1);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mnCuentas.add(mntmListar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
