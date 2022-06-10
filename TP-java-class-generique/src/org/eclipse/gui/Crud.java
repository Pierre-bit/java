package org.eclipse.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.eclipse.classes.Salles;
import org.eclipse.services.SalleService;

import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JTextField;

public class Crud extends JFrame {

	private SalleService salleService;
	private List<Salles> salle;
	private JPanel contentPane;
	private JTable table;
	private JTextField textId;
	private JTextField textCode;
	private JTextField textLibelle;
	private JTextField textDispo;

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
		//fetch();
	}

	private void initFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Definition de la posotion (int x , int y , int width , int  height)
		setBounds(100, 100, 673, 477);
		//Creation du Jpanel qui comprend un layout et des composants 
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.BLUE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Code", "Libelle", "Dispo"
			}
		));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				getValues(evt);
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(192, 61, 389, 172);
		contentPane.add(scrollPane);
		
		
		JLabel lblNewLabel = new JLabel("Listes des Salles ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(273, 24, 193, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Fetch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetch();
			}
		});
		btnNewButton.setBounds(492, 37, 89, 23);
		contentPane.add(btnNewButton);
		
//		textId = new JTextField();
//		textId.setBounds(82, 106, 86, 20);
//		contentPane.add(textId);
//		textId.setColumns(10);
//		
//		JLabel lblNewLabel_1 = new JLabel("Id");
//		lblNewLabel_1.setBounds(0, 109, 81, 14);
//		contentPane.add(lblNewLabel_1);
		
		textCode = new JTextField();
		textCode.setColumns(10);
		textCode.setBounds(82, 129, 86, 20);
		contentPane.add(textCode);
		
		textLibelle = new JTextField();
		textLibelle.setColumns(10);
		textLibelle.setBounds(82, 152, 86, 20);
		contentPane.add(textLibelle);
		
		textDispo = new JTextField();
		textDispo.setColumns(10);
		textDispo.setBounds(82, 175, 86, 20);
		contentPane.add(textDispo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Code");
		lblNewLabel_1_1.setBounds(0, 134, 81, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Libellé");
		lblNewLabel_1_2.setBounds(0, 155, 81, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Disponibilité");
		lblNewLabel_1_3.setBounds(0, 178, 81, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				add(e);
			}
		});
		btnAdd.setBounds(191, 256, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel_2 = new JLabel("Nouvelle Salle");
		lblNewLabel_2.setBounds(20, 24, 100, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btnDelete = new JButton("Supprimer");
		btnDelete.setBounds(303, 256, 89, 23);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				delete(e);
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(416, 256, 89, 23);
		contentPane.add(btnEdit);
		btnEdit.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
				getValues(evt);
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				edit(e);
			}
		});
	}
	private void fetch()
	{
		salle = salleService.findAll();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Salles s : salle)
		{
			Object[] row = new Object[4];
			row[0] = s.getId();
			row[1] = s.getCode();
			row[2] = s.getLibelle();
			row[3] = s.getDispo();
			model.addRow(row);
		}
	}
	
	private void add(java.awt.event.ActionEvent evt)
	{
		//int id= Integer.parseInt(textId.getText());
		String code = textCode.getText();
		String libelle = textLibelle.getText();
		String dispo = textDispo.getText();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[4];
		//row[0]= id;
		row[1]= code;
		row[2]= libelle;
		row[3]= dispo;
		salleService.create(new Salles(code,libelle,dispo));
		JOptionPane.showConfirmDialog(rootPane, "Voulez vous ajouter ?","Add Confirmation", JOptionPane.YES_NO_OPTION);
		model.addRow(row);
		clear();
		
	}
	
	private void delete(java.awt.event.ActionEvent evt)
	{
		int i = table.getSelectedRow();
		if (i >= 0)
		{
			int option = JOptionPane.showConfirmDialog(rootPane, "Voulez vous supprimer ?","Delete Confirmation", JOptionPane.YES_NO_OPTION);
			if (option ==0)
			{
				TableModel model = (DefaultTableModel) table.getModel();
				String id = model.getValueAt(i, 0).toString();
				if (table.getSelectedRows().length == 1)
				{
					Salles s = salleService.findById(Integer.parseInt(id));
					salleService.delete(s);
					DefaultTableModel defaultmodel = (DefaultTableModel) table.getModel();
					defaultmodel.setRowCount(0);
					fetch();
				}
			}
		}
		else
		{
			JOptionPane.showInternalMessageDialog(rootPane, "Veillez selectionner une ligne !");
		}
		
	}
	
	private void edit(java.awt.event.ActionEvent evt)
	{
		int i = table.getSelectedRow();
		String code = textCode.getText();;
		String libelle = textLibelle.getText();
		String dispo = textDispo.getText();
		if (i >= 0)
		{
			int option = JOptionPane.showConfirmDialog(rootPane, "Voulez vous modifier ?","Update Confirmation", JOptionPane.YES_NO_OPTION);
			if (option ==0)
			{
				TableModel model = (DefaultTableModel) table.getModel();
				String id = model.getValueAt(i, 0).toString();
				if (table.getSelectedRows().length == 1)
				{
					Salles s = salleService.findById(Integer.parseInt(id));
					
					DefaultTableModel defaultmodel = (DefaultTableModel) table.getModel();
					defaultmodel.setRowCount(0);
					s.setCode(code);
					s.setLibelle(libelle);
					s.setDispo(dispo);
					salleService.update(s);
					fetch();
				}
			}
		}
		else
		{
			JOptionPane.showInternalMessageDialog(rootPane, "Veillez selectionner une ligne !");
		}
	}
	// Affiche la ligne selectionne ds le formulaire
	private void getValues(java.awt.event.MouseEvent evt) {
		int i = table.getSelectedRow();
		TableModel model = table.getModel();
		//textId.setText(model.getValueAt(i, 0).toString());
		textCode.setText(model.getValueAt(i, 1).toString());
		textLibelle.setText(model.getValueAt(i, 2).toString());
		textDispo.setText(model.getValueAt(i, 3).toString());

	}
	private void clear() {
		//textId.setText("");
		textCode.setText("");
		textLibelle.setText("");
		textDispo.setText("");
	}
}
