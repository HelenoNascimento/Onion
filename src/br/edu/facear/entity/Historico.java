package br.edu.facear.entity;

import java.util.Date;

public class Historico {

	private int cod_historico;
	
	public int getCod_historico() {
		return cod_historico;
	}

	public void setCod_historico(int cod_historico) {
		this.cod_historico = cod_historico;
	}

	private String Nome;
	
	private String Date;
	
	private int N_sequencia;
	
	private String Dificuldade;
	
	private int Pontos;
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		this.Date = date;
	}

	public int getN_sequencia() {
		return N_sequencia;
	}

	public void setN_sequencia(int n_sequencia) {
		N_sequencia = n_sequencia;
	}

	public String getDificuldade() {
		return Dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.Dificuldade = dificuldade;
	}

	public int getPontos() {
		return Pontos;
	}

	public void setPontos(int pontos) {
		Pontos = pontos;
	}

	@Override
	public String toString() {
		return "Historico [cod_historico=" + cod_historico + ", cod_jogador=" + Nome + ", date=" + Date
				+ ", N_sequencia=" + N_sequencia + ", cod_Dificuldade=" + Dificuldade + ", Pontos=" + Pontos + "]";
	}



	
}
