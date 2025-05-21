package ambientacao;

import personalidades.Personagem;

public class Ruinas extends Ambiente {

	public Ruinas(String nome, String descricao, double dificuldadeDeExploração, double probabilidadeDeEventos,
			String condicoesClimaticasPredominantes, double estruturasInstaveis, double baixoRiscoClimatico, Boolean presencaDeOutros) {
		super(nome, descricao, dificuldadeDeExploração, probabilidadeDeEventos, condicoesClimaticasPredominantes);
		this.baixoRiscoClimatico= baixoRiscoClimatico;
		this.estruturasInstaveis= estruturasInstaveis;
		this.presencaDeOutros= presencaDeOutros;
		// TODO Auto-generated constructor stub
	}
	private double estruturasInstaveis;
	private Boolean presencaDeOutros;
	private double baixoRiscoClimatico;
	public double getEstruturasInstaveis() {
		return estruturasInstaveis;
	}
	public void setEstruturasInstaveis(double estruturasInstaveis) {
		this.estruturasInstaveis = estruturasInstaveis;
	}
	public double getBaixoRiscoClimatico() {
		return baixoRiscoClimatico;
	}
	public void setBaixoRiscoClimatico(double baixoRiscoClimatico) {
		this.baixoRiscoClimatico = baixoRiscoClimatico;
	}
	public Boolean getPresencaDeOutros() {
		return presencaDeOutros;
	}
	public void setPresencaDeOutros(Boolean presençaDeOutros) {
		this.presencaDeOutros = presençaDeOutros;
	}
	@Override
	public void Explorar(Personagem jogador) {
		System.out.println("Essas ruinas são incriveis!\n Me embrei da minha amiga Lara, ela adorava caçar tesouros em tumbas \n"
				+ "Acho que não vou me preocupar com o clima.");
		naturezaAmbiente(jogador);
		espoliosAmbiente();
		
	}
	@Override
	public void naturezaAmbiente(Personagem jogador) {
		double lascarPersonagem = -1*getEstruturasInstaveis()*5*jogador.getResistenciaAoAmbiente();
		System.out.println("Essas estruturas parecem que vão cair!");
		jogador.setSanidade(lascarPersonagem);
		jogador.setEnergia(lascarPersonagem);
		if(getPresencaDeOutros()) {
			System.out.println("pode ter pessoas por aqui");
		}
	}
	
	/*
	 * sanidade cai muito rapido
	 * sede 1
	 * fome 1
	 * energia 2
	 * "correr, pular, que divertido"
	 */
}
