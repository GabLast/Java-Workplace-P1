package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Almacen mialma = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almacen alma = new Almacen();
					Principal frame = new Principal(alma);
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
	public Principal(Almacen alma) {
		this.mialma = alma;
		setResizable(false);
		setTitle("Almac\u00E9n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 435);
		
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaptionBorder);
		setJMenuBar(menuBar);
		
		JMenu mnSuplidores = new JMenu("Suplidores");
		menuBar.add(mnSuplidores);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mnSuplidores.add(mntmRegistrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnSuplidores.add(mntmListar);
		
		JMenu mnVinos = new JMenu("Vinos");
		menuBar.add(mnVinos);
		
		JMenu mnAdministracin = new JMenu("Administraci\u00F3n");
		menuBar.add(mnAdministracin);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(15);
		contentPane.add(panel, BorderLayout.SOUTH);
	}

}
