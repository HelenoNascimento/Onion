
package br.edu.facear.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import br.edu.facear.entity.Historico;

public class ConfiguracaoDAO {
	
	public void Salvar(int cod_historico,int cod_jogador ) {
		try {
			// Inst�ncia de um Objeto da Class Java(PrintWriter
			// "para Grava��o do Arquivo").
			PrintWriter out = new PrintWriter("C:\\Users\\helen\\Documents\\Onion\\configuracao.txt");// Define
											
			out.println(cod_historico);
			out.println(cod_jogador);
			//out.println("Data: "+historico.getDate());
			//out.println("Quantidade Sequencia: "+historico.getN_sequencia());
			//out.println("Pontos: "+historico.getPontos());

			// Fecha Conex�o.
			out.close();

			// Exibe caixa de Dialogo.
			//JOptionPane.showMessageDialog(null, "Arquivo gerado e conte�do gravado com sucesso!");

		} catch (IOException Erro) {
			JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
		}
		
		
	}
	
	
	
	
	public int PegarCodHistorico() {
		int cod_historico = 0;
	
		try {


			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\helen\\Documents\\Onion\\configuracao.txt"));

			// Ler o conte�do do arquivo e exibe nos JTextField.
			cod_historico = Integer.parseInt(br.readLine());
			//tfNome.setText(br.readLine());
			//tfEmail.setText(br.readLine());

		} catch (IOException Erro) {
			//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
		}
		
		return  cod_historico;
	}
	
	
	public int PegarCodJogador() {
		int cod_jogador = 0;
	
		try {


			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\helen\\Documents\\Onion\\configuracao.txt"));

			// Ler o conte�do do arquivo e exibe nos JTextField.
			br.readLine();
			cod_jogador = Integer.parseInt(br.readLine());
			//tfNome.setText(br.readLine());
			//tfEmail.setText(br.readLine());

		} catch (IOException Erro) {
			//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
		}
		
		return  cod_jogador;
	}
	// metedo que cria as pastas caso elas nao existam 
		public void CriarPastas() {
			File diretorio = new File("C:\\Users\\helen\\Documents/Onion/Historico");
			File diretorio2 = new File("C:\\Users\\helen\\Documents\\Onion/HistoricoSequencia");
			File diretorio3 = new File("C:\\Users\\helen\\Documents\\Onion/Jogadores");
		    diretorio.mkdirs();
		    diretorio2.mkdirs();
		    diretorio3.mkdirs();
		}

		
		public void criarconf( ) {
			try {
				PrintWriter out = new PrintWriter("C:\\Users\\helen\\Documents\\Onion\\configuracao.txt");// Define

				// Fecha Conex�o.
				out.close();


			} catch (IOException Erro) {
				JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
			}
			
			
		}
}
