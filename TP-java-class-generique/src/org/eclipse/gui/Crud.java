package org.eclipse.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.classes.Salles;
import org.eclipse.services.SalleService;

import java.awt.ScrollPane;

public class Crud extends JFrame {

	private SalleService salleService;
	private List<Salles> salle;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalleService salleService = new SalleService();
					Crud frame = new Crud(salleService);
					// rend la fenetre visible 
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
	// les objects de la classe C1 dependent des objets de la classe C2 quand :
	// -> C1 a un attribut objet de la classe C2
	// -> C1 herite de C2
	// -> Une methode de C1, ici Crud, appelle une methode de C2, ici SalleService
	// Et pour ca on a utilise l'injection de dependance
	public Crud(SalleService salleService) {
		this.salleService = salleService;
		setTitle("Crud");
		initFrame();
		fetch();
	}

	private void initFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Definition de la posotion (int x , int y , int width , int  height)
		setBounds(100, 100, 481, 285);
		//Creation du Jpanel qui comprend un layout et des composants 
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Code", "Libelle"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
		//pack();
	}
	private void fetch()
	{
		salle = salleService.findAll();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Salles s : salle)
		{
			Object[] row = new Object[3];
			row[0] = s.getId();
			row[1] = s.getCode();
			row[2] = s.getLibelle();
			model.addRow(row);
		}
	}
	
}
