package br.edu.facear.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import br.edu.facear.entity.Historico;
import br.edu.facear.entity.Jogador;

public class HistoricoDAO {
	
	Historico historico = new Historico();
	
	
	public void Salvar(Historico historico) {
		try {
			// Inst�ncia de um Objeto da Class Java(PrintWriter
			// "para Grava��o do Arquivo").
			PrintWriter out = new PrintWriter("C:\\Users\\helen\\Documents\\Onion\\Historico\\" +historico.getCod_historico() + ".txt");// Define
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
			out.println("Codigo Historico: "+historico.getCod_historico());
			out.println("Codigo Jogador:"+historico.getCod_jogador());
			out.println("Data: "+historico.getDate());
			out.println("Quantidade Sequencia: "+historico.getN_sequencia());
			out.println("Pontos: "+historico.getPontos());

			// Fecha Conex�o.
			out.close();

			// Exibe caixa de Dialogo.
			JOptionPane.showMessageDialog(null, "Arquivo gerado e conte�do gravado com sucesso!");

		} catch (IOException Erro) {
			JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
		}
		
		
	}

}
