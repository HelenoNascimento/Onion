package Controler;

import br.edu.facear.dao.ConfiguracaoDAO;

public class ConfiguracaoControle {
	
	ConfiguracaoDAO confdao = new ConfiguracaoDAO();
	
	
	public void ControleCodHistorico(int cod_historico,int cod_jogador) {
		
		cod_historico = confdao.PegarCodHistorico()+1;
		confdao.Salvar(cod_historico,cod_jogador);
		
	}
	public int PegarCodHistorico() {
		
		return confdao.PegarCodHistorico()+1;
		
	}
	
	public void CriarPasta() {
		confdao.CriarPastas();
	}
	
	

}
