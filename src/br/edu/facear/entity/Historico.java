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

	private int cod_jogador;
	
	private String date;
	
	private int N_sequencia;
	
	private int cod_Dificuldade;
	
	private int Pontos;
	
	public int getCod_jogador() {
		return cod_jogador;
	}

	public void setCod_jogador(int cod_jogador) {
		this.cod_jogador = cod_jogador;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getN_sequencia() {
		return N_sequencia;
	}

	public void setN_sequencia(int n_sequencia) {
		N_sequencia = n_sequencia;
	}

	public int getCod_Dificuldade() {
		return cod_Dificuldade;
	}

	public void setCod_Dificuldade(int cod_Dificuldade) {
		this.cod_Dificuldade = cod_Dificuldade;
	}

	public int getPontos() {
		return Pontos;
	}

	public void setPontos(int pontos) {
		Pontos = pontos;
	}

	@Override
	public String toString() {
		return "Historico [cod_historico=" + cod_historico + ", cod_jogador=" + cod_jogador + ", date=" + date
				+ ", N_sequencia=" + N_sequencia + ", cod_Dificuldade=" + cod_Dificuldade + ", Pontos=" + Pontos + "]";
	}



	
}
