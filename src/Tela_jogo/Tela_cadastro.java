package Tela_jogo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.facear.entity.Jogador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class Tela_cadastro extends JFrame {
	 Jogador jogador = new Jogador();
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_idade;
	private JTextField txt_email;
	public DefaultListModel lista;
	ArrayList  <Jogador> listadejogador= new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_cadastro frame = new Tela_cadastro();
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
	public Tela_cadastro() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(46, 25, 46, 14);
		contentPane.add(lblNome);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(102, 22, 86, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(46, 62, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(46, 97, 46, 14);
		contentPane.add(lblEmail);
		
		txt_idade = new JTextField();
		txt_idade.setBounds(102, 59, 86, 20);
		contentPane.add(txt_idade);
		txt_idade.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(102, 94, 86, 20);
		contentPane.add(txt_email);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Jogador jn = new Jogador();
				
				
				String nome;
				String idade;
				nome = (txt_nome.getText());
				jogador.setNome(nome);
				
				idade = (txt_idade.getText());
				jogador.setIdade(idade);
				jogador.setEmail(txt_email.getText());
				listadejogador.add(jogador);
				//for(int cont = 0;cont < listadejogador.size();cont++){
					lista.addElement(jogador.getNome()+"      "+jogador.getIdade()+"    "+jogador.getEmail()+ "   "+jogador.getPontuacao());
				//	lista.addElement(listadejogador.get(cont).getNome()+"    "+listadejogador.get(cont).getIdade());
					
				//lista.set(index, nome);
				txt_nome.setText(null);
				txt_idade.setText(null);
				txt_email.setText(null);
				
			}
		});
		btnCadastrar.setBounds(69, 158, 89, 23);
		contentPane.add(btnCadastrar);
		lista = new DefaultListModel();
		JList list = new JList(lista);
		list.setBounds(222, 24, 190, 169);
		contentPane.add(list);
		
		JButton btnJ_jogadores = new JButton("Jogadores");
		btnJ_jogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int cont = 0;cont < listadejogador.size();cont++){
					
					 
					    lista.addElement( listadejogador.get( cont ) );  
					
					//lista.addElement(jogador.getNome()+"      "+jogador.getIdade()+"    "+jogador.getEmail()+ "   "+jogador.getPontuacao());
					//lista.addElement(listadejogador.get(cont).getNome()+"    "+listadejogador.get(cont).getIdade());
					}
			Tela_jogadores tela_jogadores = new Tela_jogadores();
			
			tela_jogadores.setVisible(true);
			}
		});
		btnJ_jogadores.setBounds(450, 58, 89, 23);
		contentPane.add(btnJ_jogadores);
	}
}
