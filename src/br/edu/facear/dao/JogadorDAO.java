package br.edu.facear.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


import Tela_jogo.Tela_Historico;
import Tela_jogo.Tela_inicial;
import Tela_jogo.Tela_jogadores;
import br.edu.facear.entity.Jogador;

public class JogadorDAO {
	Jogador jg = new Jogador();
	Jogador top1 =new Jogador();
	Jogador top2 =new Jogador();
	Jogador top3 =new Jogador();
	Jogador reserva = new Jogador();
	
	
	ArrayList  <Jogador> listadejogador= new ArrayList();

		public void Salvar(Jogador jg) {
			try {
				// Inst�ncia de um Objeto da Class Java(PrintWriter
				// "para Grava��o do Arquivo").
				PrintWriter out = new PrintWriter("C:\\Onion\\Jogadores\\" +jg.getCod_jogador() + ".txt");// Define
																												// o
																												// local
																												// e
																												// a
																												// extens�o
																												// do
																												// arquivo
																												// que
																												// deseja
																												// criar.

				// Captura o Texto dos JTextField.
				out.println(jg.getCod_jogador());
				out.println(jg.getNome());
				out.println(jg.getEmail());
				out.println(jg.getIdade());
				out.println(jg.getPontuacao());
				out.println(jg.getSenha());

				// Fecha Conex�o.
				out.close();

				// Exibe caixa de Dialogo.
				//JOptionPane.showMessageDialog(null, "Arquivo gerado e conte�do gravado com sucesso!");

			} catch (IOException Erro) {
				JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
			}
			
			
		}
		public void editar(Jogador jg) {
			try {
				// Inst�ncia de um Objeto da Class Java(PrintWriter
				// "para Grava��o do Arquivo").
				PrintWriter out = new PrintWriter("C:\\Onion\\Jogadores\\" +jg.getNome()+ ".txt");// Define
				
				out.println(jg.getCod_jogador());
				out.println(jg.getNome());
				out.println(jg.getEmail());
				out.println(jg.getIdade());
				out.println(jg.getPontuacao());
				out.println(jg.getSenha());

				// Fecha Conex�o.
				out.close();

				
		//		JOptionPane.showMessageDialog(null, "Arquivo gerado e conte�do gravado com sucesso!");

			} catch (IOException Erro) {
				JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
			}
			
			
		}
		
		public Jogador Logar(String nome, String senha) {

					try {
				
						BufferedReader br = new BufferedReader(
								new FileReader("C:\\Onion\\Jogadores\\"+nome+".txt")); 
			
							
						int codigo = Integer.parseInt(br.readLine());
						
						jg.setCod_jogador(codigo);
						jg.setNome(br.readLine());
						jg.setEmail(br.readLine());
						jg.setIdade(br.readLine());
						
						int pontuacao = Integer.parseInt(br.readLine());
						jg.setPontuacao(pontuacao);
						
						
						jg.setSenha(Integer.parseInt(br.readLine()));
						System.out.println(jg);
						
				
					} catch (IOException Erro) {
						//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
					}
		
		
			return jg;
}
		
		public void ListarJogadores() {
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
							new FileReader("C:\\Onion\\Jogadores\\"+i+".txt")); // instancia o objeto da classe File com o caminho do arquivo a ser lido
			
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
					Tela_jogadores.lista.addElement(jg.getCod_jogador()+"      "+jg.getNome()+"               "+jg.getIdade()+"               "+jg.getEmail()+ "          "+jg.getPontuacao());
					//Tela_Historico.array.add(jg);
				} catch (IOException Erro) {
					//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
				}
			}
		}
		
		
		public String BuscaCodigoJogador(String joga) {
			String numjogador = null;
			// Tratamento de Erros
			try {
				// Solicita ao usu�rio que informe qual o arquivo deseja
				// abrir.
				String arquivo = joga;
				
				// Inst�ncia de um Objeto da Class java(BufferedReader
				// "Para Leitura do Arquivo"), que Inst�ncia um Objeto da
				// Class java(FileReader) referenciando o arquivo a ser
				// aberto.
				BufferedReader br = new BufferedReader(
						new FileReader("C:\\\\Onion\\\\Jogadores\\\\" + arquivo + ".txt"));

				// Ler o conte�do do arquivo e exibe nos JTextField.
				numjogador = br.readLine();
				numjogador = br.readLine();
				//tfNome.setText(br.readLine());
				//tfEmail.setText(br.readLine());

			} catch (IOException Erro) {
				//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
			}
			
			return numjogador;
		}
		
		public  Jogador BuscaJogador(String joga) {
			String numjogador = null;
			// Tratamento de Erros
			try {
				// Solicita ao usu�rio que informe qual o arquivo deseja
				// abrir.
				String arquivo = joga;
				
				// Inst�ncia de um Objeto da Class java(BufferedReader
				// "Para Leitura do Arquivo"), que Inst�ncia um Objeto da
				// Class java(FileReader) referenciando o arquivo a ser
				// aberto.
				BufferedReader br = new BufferedReader(
						new FileReader("C:\\\\Onion\\\\Jogadores\\\\" + joga + ".txt"));
				int codigo = Integer.parseInt(br.readLine());
				jg.setCod_jogador(codigo);
				jg.setNome(br.readLine());
				jg.setEmail(br.readLine());
				jg.setIdade(br.readLine());
				
				int pontuacao = Integer.parseInt(br.readLine());
				jg.setPontuacao(pontuacao);
				System.out.println(jg);
				

			} catch (IOException Erro) {
			//	JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
			}
			
			return jg;
		}
		
		
		public void Cadastrar(Jogador jg) {
			try {
				// Inst�ncia de um Objeto da Class Java(PrintWriter
				// "para Grava��o do Arquivo").
				PrintWriter out = new PrintWriter("C:\\Onion\\Jogadores\\" +jg.getNome() + ".txt");// Define
				
				out.println(jg.getCod_jogador());
				out.println(jg.getNome());
				out.println(jg.getEmail());
				out.println(jg.getIdade());
				out.println(jg.getPontuacao());
				out.println(jg.getSenha());

				// Fecha Conex�o.
				out.close();

				
		//		JOptionPane.showMessageDialog(null, "Arquivo gerado e conte�do gravado com sucesso!");

			} catch (IOException Erro) {
				JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
			}
			
			
		}
		
		// ******************ESSE METODO VAI SALVAR O TOP 1 DOS TOP3 JOGADORES*********************************
		
		public void CadastrarJogadorTop1(Jogador jg) {
			try {
				// Inst�ncia de um Objeto da Class Java(PrintWriter
				// "para Grava��o do Arquivo").
				PrintWriter out = new PrintWriter("C:\\Onion\\Top3\\1.txt");// Define
				
				out.println(jg.getCod_jogador());
				out.println(jg.getNome());
				out.println(jg.getEmail());
				out.println(jg.getIdade());
				out.println(jg.getPontuacao());
				out.println(jg.getSenha());

				// Fecha Conex�o.
				out.close();

		//		JOptionPane.showMessageDialog(null, "Arquivo gerado e conte�do gravado com sucesso!");

			} catch (IOException Erro) {
				JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
			}
			
			
		}
		
		// ******************ESSE METODO VAI SALVAR O TOP 2 DOS TOP3 JOGADORES*********************************
		
		public void CadastrarJogadorTop2(Jogador jg) {
			try {
				// Inst�ncia de um Objeto da Class Java(PrintWriter
				// "para Grava��o do Arquivo").
				PrintWriter out = new PrintWriter("C:\\Onion\\Top3\\2.txt");// Define
				
				out.println(jg.getCod_jogador());
				out.println(jg.getNome());
				out.println(jg.getEmail());
				out.println(jg.getIdade());
				out.println(jg.getPontuacao());
				out.println(jg.getSenha());

				// Fecha Conex�o.
				out.close();

		//		JOptionPane.showMessageDialog(null, "Arquivo gerado e conte�do gravado com sucesso!");

			} catch (IOException Erro) {
				JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
			}
			
			
		}		
		// ******************ESSE METODO VAI SALVAR O TOP 3 DOS TOP3 JOGADORES*********************************
		
		public void CadastrarJogadorTop3(Jogador jg) {
			try {
				// Inst�ncia de um Objeto da Class Java(PrintWriter
				// "para Grava��o do Arquivo").
				PrintWriter out = new PrintWriter("C:\\Onion\\Top3\\3.txt");// Define
				
				out.println(jg.getCod_jogador());
				out.println(jg.getNome());
				out.println(jg.getEmail());
				out.println(jg.getIdade());
				out.println(jg.getPontuacao());
				out.println(jg.getSenha());

				// Fecha Conex�o.
				out.close();

		//		JOptionPane.showMessageDialog(null, "Arquivo gerado e conte�do gravado com sucesso!");

			} catch (IOException Erro) {
				JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
			}
			
			
		}	
		
		//***************************metodos buscam os jogadores top **********************
		// BUSCA TOP1
		public  Jogador Buscatop1() {


			try {
	
				BufferedReader br = new BufferedReader(
						new FileReader("C:\\Onion\\Top3\\1.txt"));
				int codigo = Integer.parseInt(br.readLine());
				top1.setCod_jogador(codigo);
				top1.setNome(br.readLine());
				top1.setEmail(br.readLine());
				top1.setIdade(br.readLine());
				
				int pontuacao = Integer.parseInt(br.readLine());
				top1.setPontuacao(pontuacao);
				
				System.out.println(top1);
				
				int senha = Integer.parseInt(br.readLine());
				top1.setSenha(senha);

			} catch (IOException Erro) {
				//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
			}
			
			return top1;
		}
		// BUSCA TOP2
		public  Jogador Buscatop2() {
			String numjogador = null;

			try {
	
				BufferedReader br = new BufferedReader(
						new FileReader("C:\\\\Onion\\\\Top3\\\\2.txt"));
				int codigo = Integer.parseInt(br.readLine());
				top2.setCod_jogador(codigo);
				top2.setNome(br.readLine());
				top2.setEmail(br.readLine());
				top2.setIdade(br.readLine());
				
				int pontuacao = Integer.parseInt(br.readLine());
				top2.setPontuacao(pontuacao);
				
				System.out.println(top2);
				
				int senha = Integer.parseInt(br.readLine());
				top2.setSenha(senha);

			} catch (IOException Erro) {
			//	JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
			}
			
			return top2;
		}
		
		// BUSCA TOP3
		public  Jogador Buscatop3() {
			String numjogador = null;

			try {
	
				BufferedReader br = new BufferedReader(
						new FileReader("C:\\\\Onion\\\\Top3\\\\3.txt"));
				int codigo = Integer.parseInt(br.readLine());
				top3.setCod_jogador(codigo);
				top3.setNome(br.readLine());
				top3.setEmail(br.readLine());
				top3.setIdade(br.readLine());
				
				int pontuacao = Integer.parseInt(br.readLine());
				top3.setPontuacao(pontuacao);
				
				System.out.println(top3);
				
				int senha = Integer.parseInt(br.readLine());
				top3.setSenha(senha);

			} catch (IOException Erro) {
			//	JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
			}
			
			return top3;
		}
}
