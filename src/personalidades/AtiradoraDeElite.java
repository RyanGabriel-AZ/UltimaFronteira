package personalidades;

import criaturas.Criatura;
import itens.Arma;

public class AtiradoraDeElite extends Personagem{

	public AtiradoraDeElite(String nome, double vida, double energia, double fome, double sede, double sanidade,
			int protecaoEfeitosSecundarios) {
		super(nome, vida, energia, fome, sede, sanidade, protecaoEfeitosSecundarios);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ataque(Arma arma, Criatura monstros) {
		double dano= arma.getPoder()*getForca();
	   if(arma.getTipo().equalsIgnoreCase("Longo")) {
		   monstros.setVida(dano*3);
	    	arma.setDurabilidade(-10);
	   } else
	    	monstros.setVida(dano);
	    	arma.setDurabilidade(-10);
	}

	@Override
	public void statsPersonagem() {
		configurarLimites(150, 100, 100, 100, 100, 100);
		setEnergia(getLimiteEnergia());
		setFome(getLimiteFome());
		setForca(getLimiteForca());
		setSanidade(getLimiteSanidade());
		setVida(getLimiteVida());
		setSede(getLimiteSede());
		setResistenciaAoAmbiente(0.3);
	}
	
}
