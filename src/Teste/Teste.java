package Teste;

import Controler.ControleJogador;
import Tela_jogo.Tela_jogo;
import br.edu.facear.entity.Jogador;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControleJogador controle = new ControleJogador();
		Tela_jogo tela = new Tela_jogo();
		Jogador jg = new Jogador();
		
		jg.setCod_jogador(1);
		jg.setEmail("Teste@gmal");
		jg.setIdade("20");
		jg.setNome("felipe");
		jg.setPontuacao(200);
		jg.setSenha(11);
		
		tela.setVisible(true);
		
		controle.SalvaJogadorTop(jg);
		
	}
	

}
