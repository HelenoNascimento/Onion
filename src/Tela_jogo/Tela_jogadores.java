package Tela_jogo;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTable;

public class Tela_jogadores extends Tela_cadastro {
	//private DefaultListModel lista;
	//Tela_cadastro tela_cadastro = new Tela_cadastro();
	JogadorDAO jgdao = new JogadorDAO();
	Jogador jg = new Jogador();
	public void listajogadores(){
		ArrayList  <Jogador> listadejogador= new ArrayList();
		//lista.addElement(jogador.getNome()+"      "+jogador.getIdade()+"    "+jogador.getEmail()+ "   "+jogador.getPontuacao());
		//lista.addElement(listadejogador.get(0).getNome());
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
		setBounds(100, 100, 476, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(94, 108, 50, -42);
		contentPane.add(list);
		lista = new DefaultListModel();
		JList txt_jogadores = new JList(lista);
		txt_jogadores.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		txt_jogadores.setBounds(28, 70, 396, 177);
		contentPane.add(txt_jogadores);
		
		JLabel lblJogadores = new JLabel("Jogadores");
		lblJogadores.setBounds(150, 27, 108, 14);
		contentPane.add(lblJogadores);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				jgdao.ListarJogadores();
			/*	
				JList lista = new JList();
				BufferedReader bReader = new BufferedReader(new FileReader(new File("C:\\Users\\helen\\Documents\\Onion\\Jogadores")));
				while(bReader.ready()) {
					lista.add(bReader.read());
					*******************
					*
				}*/
				/*
				for(int i =0 ;i<10; i++) {
					try {
						// Solicita ao usu�rio que informe qual o arquivo deseja
						// abrir.
					//	String arquivo = JOptionPane.showInputDialog(null, "Infome um c�digo para carregar os dados:");

						// Inst�ncia de um Objeto da Class java(BufferedReader
						// "Para Leitura do Arquivo"), que Inst�ncia um Objeto da
						// Class java(FileReader) referenciando o arquivo a ser
						// aberto.
						BufferedReader br = new BufferedReader(
								new FileReader("C:\\Users\\helen\\Documents\\Onion\\Jogadores\\"+i+".txt")); // instancia o objeto da classe File com o caminho do arquivo a ser lido
				
								// Ler o conte�do do arquivo e exibe nos JTextField.
						int codigo = Integer.parseInt(br.readLine());
						
						jg.setCod_jogador(codigo);
						jg.setNome(br.readLine());
						
						jg.setIdade(br.readLine());
						
						int pontuacao = Integer.parseInt(br.readLine());
						jg.setPontuacao(pontuacao);
						System.out.println(jg);
						jg.setEmail(br.readLine());
						
						listadejogador.add(jg);
					//	lista.addElement( jg );
						lista.addElement(jg.getCod_jogador()+"      "+jg.getNome()+"      "+jg.getIdade()+"    "+jg.getEmail()+ "   "+jg.getPontuacao());
						
					} catch (IOException Erro) {
						//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
					}
				}
				for(int cont = 0;cont < listadejogador.size();cont++){
					
					 System.out.println(listadejogador);
				    //lista.addElement( listadejogador.get( cont ) );
				    
				}
				/*for(int cont = 0;cont < listadejogador.size();cont++){
					
					 
				    lista.addElement( listadejogador.get( cont ) );  
				
				//lista.addElement(jogador.getNome()+"      "+jogador.getIdade()+"    "+jogador.getEmail()+ "   "+jogador.getPontuacao());
				//lista.addElement(listadejogador.get(cont).getNome()+"    "+listadejogador.get(cont).getIdade());
				}*/
				
			//	System.out.println("aaa"+nome);
				//list.setModel(lista);
				
				//lista.addElement(listadejogador.get(0).getNome());
				//lista.(jogador.getNome()+"      "+jogador.getIdade()+"    "+jogador.getEmail()+ "   "+jogador.getPontuacao());
			}
		});
		btnConsultar.setBounds(45, 258, 89, 23);
		contentPane.add(btnConsultar);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(57, 27, 50, 32);
		contentPane.add(horizontalBox);
	}
}
