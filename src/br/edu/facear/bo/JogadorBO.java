package br.edu.facear.bo;

import javax.swing.JOptionPane;

import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

public class JogadorBO {
	Jogador jg = new Jogador();
	JogadorDAO jgdao = new JogadorDAO();
	
	
	public void salvar(Jogador jogador) {
		
		
		if(equals(jogador.getNome()== "")) {
			
			JOptionPane.showMessageDialog(null, "Nome vazio");
			
		}else if (equals(jogador.getNome()== null)){
			
			JOptionPane.showMessageDialog(null, "Nome vazio");
			
		}else {
		
		jgdao.Salvar(jogador);
		jgdao.editar(jogador);
		JOptionPane.showMessageDialog(null, "Editado com sucesso");
		}
	}

}
