package Tela_jogo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Controler.ControleHistorico;
import Model.HistoricoTableModel;
import br.edu.facear.entity.Historico;
import br.edu.facear.entity.Jogador;
import javax.swing.UIManager;
import java.awt.Color;

public class Tela_Historico extends JFrame {

	HistoricoTableModel tableModel = new HistoricoTableModel();
	ControleHistorico controleh = new ControleHistorico();
	 ArrayList  <Historico> listahistorico= new ArrayList();
	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	
	// public ViewHistorico() {
	  //      initComponents();

	       
	        
	    //}

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					Tela_Historico frame = new Tela_Historico();
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
	public Tela_Historico() {
		
		 
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(21, 14, 494, 266);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 40, 474, 215);
		panel.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(tableModel);
		
		table.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null},
		                {null, null, null, null}
		            },
		            new String [] {
		                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
		            }
		        ));
		
			 table.setModel(tableModel);
		// jScrollPane1.setViewportView(table);
		
		JButton Listar = new JButton("Listar");
		Listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listahistorico = controleh.Listar();
				
				
				for(int a = 0; a<=listahistorico.size();a++) {
					tableModel.addRow(listahistorico.get(a));
				}
				listahistorico.clear();
			/*	Historico h = new Historico();
				h.setCod_Dificuldade(1);
				h.setCod_historico(1);
				h.setCod_jogador(1);
				h.setDate("test");
				h.setN_sequencia(10);
				h.setPontos(10);
				*/
				//tableModel.addRow(h);
			}
		});
		Listar.setBounds(46, 291, 89, 23);
		contentPane.add(Listar);
		
		JButton btnNewButton = new JButton("atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//System.out.println(listahistorico.size());
					for(int a1 = 0; a1<= listahistorico.size();a1++) {
						tableModel.removeRow(a1);
						System.out.println(listahistorico.size());
					}
					//tableModel.atualizarTabela(listahistorico.get(a));
				}
				
		});
		btnNewButton.setBounds(148, 291, 89, 23);
		contentPane.add(btnNewButton);
	}
}
