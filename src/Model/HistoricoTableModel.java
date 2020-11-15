package Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.facear.entity.Historico;


public class HistoricoTableModel extends AbstractTableModel{

	 private List<Historico> dados = new ArrayList<>();
	    private String[] colunas = {"Codigo","Jogador","Data","N sequencia","Dificuldade","Pontos",};

	
	    @Override
	    public String getColumnName(int column) {
	        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
	    }

	  @Override
	    public int getRowCount() {
	        return dados.size();
	    }

	    @Override
	    public int getColumnCount() {
	        return colunas.length;
	    }
	    
	    @Override
	    public Object getValueAt(int linha, int coluna) {
	        
	        switch(coluna){
	            case 0:
	                return dados.get(linha).getCod_historico();
	            case 1:
	                return dados.get(linha).getNome();
	            case 2: 
	                return dados.get(linha).getDate();
	            case 3: 
	                return dados.get(linha).getN_sequencia();
	            case 4: 
	                return dados.get(linha).getDificuldade();
	            case 5: 
	                return dados.get(linha).getPontos();
	        }
	        
	        return null;
	        
	    }
	    
	    public void addRow(Historico h){
	        this.dados.add(h);
	        this.fireTableDataChanged();
	    }
	    
	    public void removeRow(int linha){
	        this.dados.remove(linha);
	        this.fireTableRowsDeleted(linha, linha);
	    }
	    public void atualizarTabela(Historico h) {
	    	//dados.add(h);
	    	
	    	fireTableDataChanged();
	    	}

}
