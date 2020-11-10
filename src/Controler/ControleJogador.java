package Controler;

import javax.swing.JOptionPane;

import Tela_jogo.Tela_cadastro;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

public class ControleJogador {
	Jogador jogador = new Jogador();
	JogadorDAO jgdao = new JogadorDAO();
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
	

}
