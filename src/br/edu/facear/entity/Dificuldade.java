package br.edu.facear.entity;

public class Dificuldade {
	
	private int cod_dificuldade;
	
	private int pontos;
	
	private int tempo;
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public int getCod_dificuldade() {
		return cod_dificuldade;
	}

	public void setCod_dificuldade(int cod_dificuldade) {
		this.cod_dificuldade = cod_dificuldade;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	
	public void test() {
	}

	@Override
	public String toString() {
		return "Dificuldade [cod_dificuldade=" + cod_dificuldade + ", pontos=" + pontos + ", tempo=" + tempo
				+ ", descricao=" + descricao + "]";
	}
	

}
