package ambientacao;

import personalidades.Personagem;

public class LagoRio extends Ambiente {

	public LagoRio(String nome, String descricao, double dificuldadeDeExploração, double probabilidadeDeEventos,
			String condicoesClimaticasPredominantes, double aguaAbundante, double possibilidadeDePesca,
			double terrenoLamacento) {
		super(nome, descricao, dificuldadeDeExploração, probabilidadeDeEventos, condicoesClimaticasPredominantes);
		this.aguaAbundante = aguaAbundante;
		this.possibilidadeDePesca = possibilidadeDePesca;
		this.terrenoLamacento = terrenoLamacento;
		// TODO Auto-generated constructor stub
	}

	private double aguaAbundante;
	private double possibilidadeDePesca;
	private double terrenoLamacento;

	@Override
	public void Explorar(Personagem jogador) {
		System.out.println(
				"Que lugar lindo, cheio de água e peixes.\n Esse lago me traz lembranças, de quando eu nadava com os jacarés, nos rios");
		naturezaAmbiente(jogador);

		espoliosAmbiente();
	}

	@Override
	public void naturezaAmbiente(Personagem jogador) {
		double fome = 20 * getPossibilidadeDePesca();
		double lascarPersonagem = (-20 * getTerrenoLamacento()) * jogador.getResistenciaAoAmbiente();
		double sede = 20 * getAguaAbundante();
		jogador.setFome(fome);
		jogador.setSede(sede);
		jogador.setSanidade(lascarPersonagem);
		jogador.setEnergia(lascarPersonagem * 2);
	}

	public double getAguaAbundante() {
		return aguaAbundante;
	}

	public void setAguaAbundante(double aguaAbundante) {
		this.aguaAbundante = aguaAbundante;
	}

	public double getPossibilidadeDePesca() {
		return possibilidadeDePesca;
	}

	public void setPossibilidadeDePesca(double possibilidadeDePesca) {
		this.possibilidadeDePesca = possibilidadeDePesca;
	}

	public double getTerrenoLamacento() {
		return terrenoLamacento;
	}

	public void setTerrenoLamacento(double terrenoLamacento) {
		this.terrenoLamacento = terrenoLamacento;
	}

	/*
	 * energia 1.25 sede 0.5 fome 0.5 Sanidade normal
	 * "As águas daqui são lindas, mas essa lama é o ó " Taxa de altíssimas
	 */
}
