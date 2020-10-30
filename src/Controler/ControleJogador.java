package Controler;

import javax.swing.JOptionPane;

import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

public class ControleJogador {
	Jogador jogador = new Jogador();
	JogadorDAO jgdao = new JogadorDAO();
	ConfiguracaoControle confcontrole = new ConfiguracaoControle();
	
	
	public int comparaSenha(String senha1,String senha2) {
		int confere = 0;
		
		if (senha1 == senha2){
			confere =1;
		}else {
			JOptionPane.showMessageDialog(null, "Senhas incompativeis");
		}
		return confere;
	}
	
	public void CadastrarJogador(Jogador jogador) {
		
		
		if((jogador.getNome() == null) || jogador.getNome() == "a"){
			JOptionPane.showMessageDialog(null, "Favor Preencher o nome");
			System.out.println("aaaa");
		}else{
		jgdao.Salvar(jogador);
		jgdao.Cadastrar(jogador);
		confcontrole.ControleCodHistorico(1,1);
		}
	}
		
	
	

}
