package Controler;

import java.util.ArrayList;

import br.edu.facear.dao.HistoricoDAO;

public class ControleHistorico {

	HistoricoDAO hdao = new HistoricoDAO();
	
	public ArrayList Listar() {
		return hdao.ListarHistorico();
		
	}
}
