package Controler;

import javax.swing.JOptionPane;

import Tela_jogo.Tela_cadastro;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

public class ControleJogador {
	Jogador jogador = new Jogador();
	JogadorDAO jgdao = new JogadorDAO();
	
	//Jogador top2 = new Jogador();	
	//Jogador top3 = new Jogador();
	
	ConfiguracaoControle confcontrole = new ConfiguracaoControle();
	
	
	public int comparaSenha(String senha1,String senha2) {
		int confere = 0;
		
		if (senha1.equals(senha2)){
			confere =0;
		}else {
			JOptionPane.showMessageDialog(null, "Senhas incompativeis");
		//	Tela_cadastro.txt_senha1.setText(null);
			///Tela_cadastro.txt_senha2.setText(null);
			confere =1;
		}
		return confere;
	}
	
	public void CadastrarJogador(Jogador jogador) {
		
		
		if((jogador.getNome().equals(null)) || jogador.getNome().equals("")){
			JOptionPane.showMessageDialog(null, "Favor Preencher o nome");
			
		}else if((jogador.getEmail().equals(null)) || jogador.getEmail().equals("")){
			JOptionPane.showMessageDialog(null, "Favor Preencher o email");
		}else{
		
		jgdao.Salvar(jogador);
		jgdao.Cadastrar(jogador);
		confcontrole.ControleCodHistorico(1,1);
		JOptionPane.showMessageDialog(null, "Jogador Cadastrado com sucesso");
		}
	}
		
	public Jogador Logar(String usuario,String senha) {
		
		jogador = jgdao.Logar(usuario, senha);
		
		
		
		return jogador;
		
		
	
	}
	
	public Jogador JogarSemCadastro(){
	jogador.setCod_jogador(0);
	jogador.setEmail("JogadorSemCadastro@sem.com");
	jogador.setIdade("15");
	jogador.setNome("Desconhecido");
		
		return jogador;
	}
	public void BuscaTop1() {
	//	top1 = jgdao.Buscatop1();
		
	}
	public void BuscaTop2 () {
		//top2 = jgdao.Buscatop2();
		 //top2 = jgdao.Buscatop2();
		
	}
	public void BuscaTop3 () {
		//top3 = jgdao.Buscatop3();
		 //top3 = jgdao.Buscatop3();
	}
		public void listarTop() {
		Jogador top1,top2,top3 = new Jogador();
			top1 = jgdao.Buscatop1();
			top2 = jgdao.Buscatop2();
			top3 = jgdao.Buscatop3();
			Tela_jogo.Tela_jogo.jg1.setText(top1.getNome());
			Tela_jogo.Tela_jogo.jg2.setText(top2.getNome());
			Tela_jogo.Tela_jogo.jg3.setText(top3.getNome());
			Tela_jogo.Tela_jogo.ptn1.setText(Integer.toString(top1.getPontuacao()));
			Tela_jogo.Tela_jogo.pnt2.setText(Integer.toString(top2.getPontuacao()));
			Tela_jogo.Tela_jogo.pnt3.setText(Integer.toString(top3.getPontuacao()));
		}
	
	public void SalvaJogadorTop(Jogador jg) {
		Jogador top1,top2,top3 = new Jogador();
	//	top1 = BuscaTop1();
		//top2 = BuscaTop2();
		//top3 = BuscaTop3();
		//BuscaTop1();
		// BuscaTop2();
		 //BuscaTop3();
		top1 = jgdao.Buscatop1();
		top2 = jgdao.Buscatop2();
		top3 = jgdao.Buscatop3();
		 System.out.println("top1: "+top1);
		 System.out.println("top1: "+top2);
		 System.out.println("top1: "+top3);
		 
		if(jg.getPontuacao() >= top1.getPontuacao()) {
			jgdao.CadastrarJogadorTop1(jg);
			System.out.println("top1 ");
		}else if(jg.getPontuacao() >= top2.getPontuacao()) {
			jgdao.CadastrarJogadorTop2(jg);
			System.out.println("top2 ");
		}else if(jg.getPontuacao() >= top3.getPontuacao()) {
			jgdao.CadastrarJogadorTop3(jg);
			System.out.println("top3 ");
		}
		
		Tela_jogo.Tela_jogo.jg1.setText(top1.getNome());
		Tela_jogo.Tela_jogo.jg2.setText(top2.getNome());
		Tela_jogo.Tela_jogo.jg3.setText(top3.getNome());
		Tela_jogo.Tela_jogo.ptn1.setText(Integer.toString(top1.getPontuacao()));
		Tela_jogo.Tela_jogo.pnt2.setText(Integer.toString(top2.getPontuacao()));
		Tela_jogo.Tela_jogo.pnt3.setText(Integer.toString(top3.getPontuacao()));
		
		
	}
	

}
