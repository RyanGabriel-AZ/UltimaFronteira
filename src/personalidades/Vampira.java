package personalidades;

import criaturas.Criatura;
import itens.Arma;

public class Vampira  extends Personagem {

	public Vampira(String nome, double vida, double energia, double fome, double sede, double sanidade,
			int protecaoEfeitosSecundarios) {
		super(nome, vida, energia, fome, sede, sanidade, protecaoEfeitosSecundarios);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void statsPersonagem() {
		configurarLimites(200,80,90,120,100,125);
		setEnergia(getLimiteEnergia());
			setFome(getLimiteFome());
			setForca(getLimiteForca());
			setSanidade(getLimiteSanidade());
			setVida(getLimiteVida());
			setSede(getLimiteSede());
			setResistenciaAoAmbiente(0.1);
		
	}

	@Override
	public void ataque(Arma arma, Criatura monstros) {
		double dano= arma.getPoder()*getForca();
	    if(Math.random()<arma.getPrecisao()) {
	    	monstros.setVida(dano*-1);
	    	setVida(dano*0.75);
	    	arma.setDurabilidade(-10);
	    }
	
	}
	

}
