package ambientacao;

import personalidades.*;

public abstract class Ambiente {
	private String nome;
	private String descricao;
	private double dificuldadeDeExploração;
	private double probabilidadeDeEventos;
	private String condicoesClimaticasPredominantes;

	public Ambiente(String nome, String descricao, double dificuldadeDeExploração, double probabilidadeDeEventos,
			String condicoesClimaticasPredominantes) {
		this.nome = nome;
		this.descricao = descricao;
		this.condicoesClimaticasPredominantes = condicoesClimaticasPredominantes;
		this.dificuldadeDeExploração = dificuldadeDeExploração;
		this.probabilidadeDeEventos = probabilidadeDeEventos;
	}

	public abstract void Explorar(Personagem jogador);

	/*
	 * public abstract void GerarEvento(); public abstract void ModificarClima();
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public double getDificuldadeDeExploração() {
		return dificuldadeDeExploração;
	}

	public void setDificuldadeDeExploração(double dificuldadeDeExploração) {
		this.dificuldadeDeExploração = dificuldadeDeExploração;
	}

	public double getProbabilidadeDeEventos() {
		return probabilidadeDeEventos;
	}

	public void setProbabilidadeDeEventos(double probabilidadeDeEventos) {
		this.probabilidadeDeEventos = probabilidadeDeEventos;
	}

	public String getCondicoesClimaticasPredominantes() {
		return condicoesClimaticasPredominantes;
	}

	public void setCondicoesClimaticasPredominantes(String condicoesClimaticasPredominantes) {
		this.condicoesClimaticasPredominantes = condicoesClimaticasPredominantes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
