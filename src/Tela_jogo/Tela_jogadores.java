package Tela_jogo;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.facear.entity.Jogador;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_jogadores extends Tela_cadastro {
	//private DefaultListModel lista;
	//Tela_cadastro tela_cadastro = new Tela_cadastro();
	

	public void listajogadores(){
		
		//lista.addElement(jogador.getNome()+"      "+jogador.getIdade()+"    "+jogador.getEmail()+ "   "+jogador.getPontuacao());
		lista.addElement(listadejogador.get(0).getNome());
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_jogadores frame = new Tela_jogadores();
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
	public Tela_jogadores() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(94, 108, 50, -42);
		contentPane.add(list);
		lista = new DefaultListModel();
		JList txt_jogadores = new JList(lista);
		txt_jogadores.setBounds(45, 70, 341, 115);
		contentPane.add(txt_jogadores);
		
		JLabel lblJogadores = new JLabel("Jogadores");
		lblJogadores.setBounds(150, 27, 108, 14);
		contentPane.add(lblJogadores);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	System.out.println("aaa"+nome);
				//list.setModel(lista);
				
				lista.addElement(listadejogador.get(0).getNome());
				//lista.(jogador.getNome()+"      "+jogador.getIdade()+"    "+jogador.getEmail()+ "   "+jogador.getPontuacao());
			}
		});
		btnConsultar.setBounds(68, 200, 89, 23);
		contentPane.add(btnConsultar);
	}
}
