package personalidades;

import java.util.Random;

import criaturas.Criatura;
import itens.Arma;

public class Coringa extends Personagem{
Random aleatorio= new Random();

	public Coringa(String nome, double vida, double energia, double fome, double sede, double sanidade,
			int protecaoEfeitosSecundarios) {
		super(nome, vida, energia, fome, sede, sanidade, protecaoEfeitosSecundarios);
		// TODO Auto-generated constructor stub
	}
public int statusAleatorio() {
	int status=20+ aleatorio.nextInt(200);
	return status;
}
	public double ZeroAUm() {
		return aleatorio.nextDouble(1);
	}

	@Override
	public void statsPersonagem() {
	
	configurarLimites(statusAleatorio(),statusAleatorio(),statusAleatorio(),statusAleatorio(),statusAleatorio(),statusAleatorio()); 
	setEnergia(getLimiteEnergia());
		setFome(getLimiteFome());
		setForca(getLimiteForca());
		setSanidade(getLimiteSanidade());
		setVida(getLimiteVida());
		setSede(getLimiteSede());
		setResistenciaAoAmbiente(ZeroAUm());
		
	}

	@Override
	public void ataque(Arma arma, Criatura monstros) {
		double dano= -arma.getPoder()*getForca();
	    if(Math.random()<arma.getPrecisao()) {
	    	monstros.setVida(dano);
	    	arma.setDurabilidade(-10);
	    }
	}

	
	
	
	
	
	
}
