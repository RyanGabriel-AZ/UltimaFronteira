package ambientacao;

import controladores.Inventario;
import personalidades.Personagem;

public class Savana extends Ambiente  {

	public Savana(String nome, String descricao, double dificuldadeDeExploração, double probabilidadeDeEventos,
			String condicoesClimaticasPredominantes, Inventario inventario, double solEscaldante, double faltaDeSuprimentos, double mormaco) {
		super(nome, descricao, dificuldadeDeExploração, probabilidadeDeEventos, condicoesClimaticasPredominantes, inventario);
		this.setFaltaDeSuprimentos(faltaDeSuprimentos);
		this.setMormaco(mormaco);
		this.setSolEscaldante(solEscaldante);
		// TODO Auto-generated constructor stub
	}
	public double getSolEscaldante() {
		return solEscaldante;
	}
	public void setSolEscaldante(double solEscaldante) {
		this.solEscaldante = solEscaldante;
	}
	public double getFaltaDeSuprimentos() {
		return faltaDeSuprimentos;
	}
	public void setFaltaDeSuprimentos(double faltaDeSuprimentos) {
		this.faltaDeSuprimentos = faltaDeSuprimentos;
	}
	public double getMormaco() {
		return mormaco;
	}
	public void setMormaco(double mormaco) {
		this.mormaco = mormaco;
	}
	private double solEscaldante; // chance de queimadura
	private double faltaDeSuprimentos;
	private double mormaco; // diminui a sanidade com o tempo
	@Override
	public void Explorar(Personagem jogador) {
		System.out.println("Que calor infernal, saudades do meu cruzeiro com hidromassagem.");
		naturezaAmbiente(jogador);
		
		espoliosAmbiente();
	}
	@Override
	public void naturezaAmbiente(Personagem jogador) {
		double lascarPersonagem= -1*(getMormaco()*10+ getFaltaDeSuprimentos()*10+ getSolEscaldante()*10)*jogador.getResistenciaAoAmbiente();
		jogador.setEnergia(lascarPersonagem*3);
		jogador.setFome(lascarPersonagem*2);
		jogador.setSanidade(lascarPersonagem*2);
		jogador.setSede(lascarPersonagem*2);
		jogador.setVida(lascarPersonagem);
	}
	
	/* quero fazer a exploração diferente aqui.
	 * o gasto de energia é de 1.5
	 * fome 1.75
	 * poucos itens
	 * sede. 2.0;
	 * vida diminui com tempo. "O calor está muito intenso"
	 * mensagens do tipo "o deserto está escaldante, estou começando a ficar com sede
	 * sanidade cai em 1.5
	 * a probabilidade de achar qual quer itens é muito baixa
	 * 
	 */
}
