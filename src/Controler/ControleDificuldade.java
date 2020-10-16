package Controler;

import java.util.ArrayList;
import java.util.List;

import br.edu.facear.entity.Dificuldade;

public class ControleDificuldade {
	
	 List<Dificuldade> listDificuldade;
	    Dificuldade dificuldade;
	     
	    public void ControlDificuldade() {
	    	listDificuldade = new ArrayList<Dificuldade>();
	    }  


	    public List<Dificuldade> criaListDificuldade() {     
	        dificuldade = new Dificuldade();
	        dificuldade.setCod_dificuldade(1);
	        dificuldade.setPontos(1);
	        dificuldade.setTempo(1000);
	        dificuldade.setDescricao("Facil");
	        
	         
	        dificuldade = new Dificuldade();
	        dificuldade.setCod_dificuldade(2);
	        dificuldade.setPontos(2);
	        dificuldade.setTempo(500);
	        dificuldade.setDescricao("Normal");
	         
	        dificuldade = new Dificuldade();
	        dificuldade.setCod_dificuldade(3);
	        dificuldade.setPontos(3);
	        dificuldade.setTempo(300);
	        dificuldade.setDescricao("Dificil");
	        
	        dificuldade = new Dificuldade();
	        dificuldade.setCod_dificuldade(4);
	        dificuldade.setPontos(4);
	        dificuldade.setTempo(100);
	        dificuldade.setDescricao("hardcore");
	         
	        return listDificuldade;    
	    }


		@Override
		public String toString() {
			return "ControleDificuldade [listDificuldade=" + listDificuldade + ", dificuldade=" + dificuldade + "]";
		}


	

}
