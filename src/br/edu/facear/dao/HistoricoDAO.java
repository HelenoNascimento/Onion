package br.edu.facear.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Tela_jogo.Tela_jogadores;
import br.edu.facear.entity.Historico;
import br.edu.facear.entity.Jogador;

public class HistoricoDAO {
	
	Historico historico = new Historico();
	 static ArrayList <Integer> texto = new ArrayList();
	 static ArrayList <Integer> Maior = new ArrayList();
	 static ArrayList <Integer> Salvo = new ArrayList();
	 
	public void Salvar(Historico historico) {
		try {
			// Inst�ncia de um Objeto da Class Java(PrintWriter
			// "para Grava��o do Arquivo").
			PrintWriter out = new PrintWriter("C:\\Onion\\Historico\\" +historico.getCod_historico()+".txt");// Define
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
			out.println(historico.getCod_historico());
			out.println(historico.getNome());
			out.println(historico.getDate());
			out.println(historico.getN_sequencia());
			out.println(historico.getDificuldade());
			out.println(historico.getPontos());

			// Fecha Conex�o.
			out.close();

			// Exibe caixa de Dialogo.
			//JOptionPane.showMessageDialog(null, "Arquivo gerado e conte�do gravado com sucesso!");

		} catch (IOException Erro) {
			JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
		}
		
		
	}
	
	public static void gravar(ArrayList texto,String cod){
		
		try {
			
			// Inst�ncia de um Objeto da Class Java(PrintWriter
			// "para Grava��o do Arquivo").
			PrintWriter out = new PrintWriter("C:\\Onion\\\\HistoricoSequencia\\" +cod+".txt");// Define

			for (int i = 0; i < texto.size(); i++){
				out.print((int) texto.get(i));
				out.println();;
			}
			
				// Fecha Conex�o.
			out.close();
				// Exibe caixa de Dialogo.
			//JOptionPane.showMessageDialog(null, "Historico gerado e conte�do gravado com sucesso!");
			//return texto;
			
		} catch (IOException Erro) {
			JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
		}
		
			
	}
	
	public static ArrayList LerUtilmaJogada(String codigo){
		
		try {
			
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\\\Onion\\\\\\HistoricoSequencia\\\\"+codigo+".txt")); // instancia o objeto da classe File com o caminho do arquivo a ser lido
			String line = br.readLine();
			 
			//System.out.println("aa"+line);
					// Ler o conte�do do arquivo e exibe nos JTextField.
			while (line != null) {
				
			int tes = Integer.parseInt(line);
			
				texto.add(tes);
				//System.out.println(line);
				line = br.readLine();
				//br.readLine();
				//line = br.readLine();
				
			}
			
		} catch (IOException Erro) {
			//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
		}
		System.out.println("tex to");
		for (int i = 0; i < texto.size(); i++) {	
			
      		 System.out.print(texto.get(i));
      	 }
		return texto;
	}
	
	
	public void teste (){
		//ArrayList texto = null;
		
				//C:\\Users\\helen\\Documents\\Onion\\Historico\\0.txt
		try {
	
			
			FileReader arq = new FileReader("C:\\\\Onion\\\\Historico\\\\0.txt"); // instancia o objeto da classe File com o caminho do arquivo a ser lido
			 BufferedReader lerArq = new BufferedReader(arq);
			 String linha = lerArq.readLine(); 
			System.out.println("aa"+linha);
					// Ler o conte�do do arquivo e exibe nos JTextField.
			while (linha != null) {
				
			
				int tes = Integer.parseInt(linha);
				
			texto.add(tes);
			System.out.println(linha);
				linha = lerArq.readLine();
				//br.readLine();
				//line = br.readLine();
				//texto.add(line);
			}
			arq.close();
			
			
		} catch (IOException Erro) {
			//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
		}
		System.out.println("tex to");
		for (int i = 0; i < texto.size(); i++) {	
			
      		 System.out.print(texto.get(i));
      	 }
		
	}
	
public static void MaiorSequencia(ArrayList texto){
		
		try {
			
			// Inst�ncia de um Objeto da Class Java(PrintWriter
			// "para Grava��o do Arquivo").
			PrintWriter out = new PrintWriter("C:\\\\Onion\\HistoricoSequencia\\MaiorSequencia.txt");// Define

			for (int i = 0; i < texto.size(); i++){
				out.print((int) texto.get(i));
				out.println();;
			}
			
				// Fecha Conex�o.
			out.close();
				// Exibe caixa de Dialogo.
		JOptionPane.showMessageDialog(null, "Parabeeens ah um novo record!");
			//return texto;
			
		} catch (IOException Erro) {
			JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro);
		}
		
			
	}
		
public static ArrayList  PegaMaiorSequencia (){

	try {

		
		FileReader arq = new FileReader("C:\\\\Onion\\\\\\HistoricoSequencia\\\\MaiorSequencia.txt"); // instancia o objeto da classe File com o caminho do arquivo a ser lido
		 BufferedReader lerArq = new BufferedReader(arq);
		 String linha = lerArq.readLine(); 
		System.out.println("aa"+linha);
		
		while (linha != null) {
			int tes = Integer.parseInt(linha);
		
			Maior.add(tes);
		System.out.println(linha);
			linha = lerArq.readLine();
			
		}
		arq.close();
		
		
	} catch (IOException Erro) {
		//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
	}
	return Maior;

}


public static ArrayList  PegarSalvo (String codigo){

	try {

		//"C:\\\\Users\\\\helen\\\\Documents\\\\Onion\\\\\\HistoricoSequencia\\"+codigo+".txt"
		FileReader arq = new FileReader("C:\\\\Onion\\\\\\HistoricoSequencia\\"+codigo+".txt"); // instancia o objeto da classe File com o caminho do arquivo a ser lido
		 BufferedReader lerArq = new BufferedReader(arq);
		 String linha = lerArq.readLine(); 

		
		while (linha != null) {
			int tes = Integer.parseInt(linha);
		
			Salvo.add(tes);
		System.out.println(linha);
			linha = lerArq.readLine();
			
		}
		arq.close();
		System.out.println("tex to");
		for (int i = 0; i < Salvo.size(); i++) {	
			
	  		 System.out.print(Salvo.get(i));
	  	 }
		
	} catch (IOException Erro) {
		//JOptionPane.showMessageDialog(null, "Digite um c�digo v�lido!");
	}
	return Salvo;
	
}

		public ArrayList ListarHistorico() {
			ArrayList  <Historico> listahistorico= new ArrayList();
	for(int i =0 ;i<50; i++) {
		Historico h = new Historico();
		System.out.println(i);
		try {

			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Onion\\Historico\\"+i+".txt")); // instancia o objeto da classe File com o caminho do arquivo a ser lido
	
					// Ler o conte�do do arquivo e exibe nos JTextField.
			int codigo = Integer.parseInt(br.readLine());
			
			h.setCod_historico(codigo);
			//int cod = Integer.parseInt(br.readLine());
			
			h.setNome(br.readLine());
		
			h.setDate(br.readLine());
			
			int quantidade = Integer.parseInt(br.readLine());
			h.setN_sequencia(quantidade);
			
			h.setDificuldade(br.readLine());
		
			int pontuacao = Integer.parseInt(br.readLine());
			
			h.setPontos(pontuacao);
			
			listahistorico.add(h);
			
		} catch (IOException Erro) {
			//JOptionPane.showMessageDialog(null, i);
		}
		
	}
	for (int i1 = 0; i1 < listahistorico.size(); i1++) {	
		
 		 System.out.println(listahistorico.get(i1));
 	 }
	return listahistorico;
}
	
}
