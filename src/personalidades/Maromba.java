package personalidades;

import criaturas.Criatura;
import itens.Arma;

public class Maromba extends Personagem {

	public Maromba(String nome, double vida, double energia, double fome, double sede, double sanidade,
			int protecaoEfeitosSecundarios) {
		super(nome, vida, energia, fome, sede, sanidade, protecaoEfeitosSecundarios);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void statsPersonagem() {
		configurarLimites(125,100,250,80,80,80);
		setEnergia(getLimiteEnergia());
			setFome(getLimiteFome());
			setForca(getLimiteForca());
			setSanidade(getLimiteSanidade());
			setVida(getLimiteVida());
			setSede(getLimiteSede());
			setResistenciaAoAmbiente(0.6);
	}

	@Override
	public void ataque(Arma arma, Criatura monstros) {
		double dano= arma.getPoder()*getForca();
	    if(Math.random()<arma.getPrecisao()) {
	    	if(arma.getTipo().equalsIgnoreCase("curto")) {
	    		monstros.setVida(dano*3);
		    	arma.setDurabilidade(-10);
	    	}else
	    	monstros.setVida(dano);
	    	arma.setDurabilidade(-10);
	}
	}
}
