package personalidades;

import criaturas.Criatura;
import itens.Arma;

public class Sobrevivente extends Personagem{

	public Sobrevivente(String nome, double vida, double energia, double fome, double sede, double sanidade,
			int protecaoEfeitosSecundarios) {
		super(nome, vida, energia, fome, sede, sanidade, protecaoEfeitosSecundarios);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void statsPersonagem() {
		configurarLimites(150,200,100,200,200,200);
		setEnergia(getLimiteEnergia());
			setFome(getLimiteFome());
			setForca(getLimiteForca());
			setSanidade(getLimiteSanidade());
			setVida(getLimiteVida());
			setSede(getLimiteSede());
			setResistenciaAoAmbiente(1);
	}

	@Override
	public void ataque(Arma arma, Criatura monstros) {
		double dano= arma.getPoder()*getForca();
	    if(Math.random()<arma.getPrecisao()) {
	    	monstros.setVida(dano);
	    	arma.setDurabilidade(-10);
	}}

}
