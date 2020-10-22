package Tela_jogo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

public class Tela_cadastro extends JFrame {
	 Jogador jogador = new Jogador();
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_idade;
	private JTextField txt_email;
	public static DefaultListModel lista;
	ArrayList  <Jogador> listadejogador= new ArrayList();
	JogadorDAO jogadordao = new JogadorDAO();
	private JTextField txt_codigo;
	
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
		lblNome.setBounds(36, 58, 46, 14);
		contentPane.add(lblNome);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(92, 55, 86, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(36, 95, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(36, 130, 46, 14);
		contentPane.add(lblEmail);
		
		txt_idade = new JTextField();
		txt_idade.setBounds(92, 92, 86, 20);
		contentPane.add(txt_idade);
		txt_idade.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(92, 127, 86, 20);
		contentPane.add(txt_email);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Jogador jn = new Jogador();
				
				
				String nome;
				String idade;
				
				int codigo;
				codigo =Integer.parseInt(txt_codigo.getText());
				nome = (txt_nome.getText());
				jogador.setNome(nome);
				jogador.setCod_jogador(codigo);
				
				idade = (txt_idade.getText());
				jogador.setIdade(idade);
				jogador.setEmail(txt_email.getText());
				listadejogador.add(jogador);
				//for(int cont = 0;cont < listadejogador.size();cont++){
					lista.addElement(jogador.getCod_jogador()+"      "+jogador.getNome()+"      "+jogador.getIdade()+"    "+jogador.getEmail()+ "   "+jogador.getPontuacao());
				//	lista.addElement(listadejogador.get(cont).getNome()+"    "+listadejogador.get(cont).getIdade());
					jogadordao.Salvar(jogador);
					
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
		
		txt_codigo = new JTextField();
		txt_codigo.setColumns(10);
		txt_codigo.setBounds(92, 24, 86, 20);
		contentPane.add(txt_codigo);
		
		JLabel lbl_cod = new JLabel("Codigo");
		lbl_cod.setBounds(36, 27, 46, 14);
		contentPane.add(lbl_cod);
	}
}
