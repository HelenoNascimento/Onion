package br.edu.facear.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Tela_jogo.Tela_jogadores;
import br.edu.facear.entity.Jogador;

public class JogadorDAO {
	Jogador jg = new Jogador();
	ArrayList  <Jogador> listadejogador= new ArrayList();

	
		public void Salvar(Jogador jg) {
			try {
				// Inst�ncia de um Objeto da Class Java(PrintWriter
				// "para Grava��o do Arquivo").
				PrintWriter out = new PrintWriter("C:\\Users\\helen\\Documents\\Onion\\Jogadores\\" +jg.getCod_jogador() + ".txt");// Define
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

				// Fecha Conex�o.
				out.close();

				// Exibe caixa de Dialogo.
				JOptionPane.showMessageDialog(null, "Arquivo gerado e conte�do gravado com sucesso!");

			} catch (IOException Erro) {
				JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
			}
			
			
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
					Tela_jogadores.lista.addElement(jg.getCod_jogador()+"      "+jg.getNome()+"               "+jg.getIdade()+"               "+jg.getEmail()+ "          "+jg.getPontuacao());
					
				} catch (IOException Erro) {
					//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
				}
			}
		}
}