package br.edu.facear.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import br.edu.facear.entity.Jogador;

public class JogadorDAO {
	Jogador jg = new Jogador();
	

	
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
}
