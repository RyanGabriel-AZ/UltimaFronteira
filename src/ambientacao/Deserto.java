package ambientacao;

import personalidades.Personagem;

public class Deserto extends Savana{

	public Deserto(String nome, String descricao, double dificuldadeDeExploração, double probabilidadeDeEventos,
			String condicoesClimaticasPredominantes, double solEscaldante, double faltaDeSuprimentos, double mormaco, double terrenoArenoso) {
		super(nome, descricao, dificuldadeDeExploração, probabilidadeDeEventos, condicoesClimaticasPredominantes, solEscaldante,
				faltaDeSuprimentos, mormaco);
		this.terrenoArenoso= terrenoArenoso;
	}

	private double terrenoArenoso;
	@Override
	public void naturezaAmbiente(Personagem jogador) {
		double lascarPersonagem= -1*(getMormaco()*10+ getFaltaDeSuprimentos()*10+ getSolEscaldante()*10+ 15*getTerrenoArenoso())*jogador.getResistenciaAoAmbiente();
		jogador.setEnergia(lascarPersonagem*3);
		jogador.setFome(lascarPersonagem*3);
		jogador.setSanidade(lascarPersonagem*3);
		jogador.setSede(lascarPersonagem*3);
		jogador.setVida(lascarPersonagem);
	}

	public double getTerrenoArenoso() {
		return terrenoArenoso;
	}

	public void setTerrenoArenoso(double terrenoArenoso) {
		this.terrenoArenoso = terrenoArenoso;
	}
	@Override
	public void Explorar(Personagem jogador) {
		System.out.println("Que deserto escaldante, a jornada aqui será difícil");
		naturezaAmbiente(jogador);
		
		espoliosAmbiente();
	}
}
