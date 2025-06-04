package personalidades;

import ambientacao.Ambiente;
import controladores.Inventario;
import criaturas.Criatura;
import itens.Arma;

public class Vampira  extends Personagem {

	public Vampira(String nome, double vida, double energia, double fome, double sede, double sanidade,
			int protecaoEfeitosSecundarios, String classe,Inventario armInventario, Ambiente localizacao) {
		super(nome, vida, energia, fome, sede, sanidade, protecaoEfeitosSecundarios, classe, armInventario, localizacao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void statsPersonagem() {
		configurarLimites(200,80,60,120,100,125);
		setEnergia(getLimiteEnergia());
			setFome(getLimiteFome());
			setForca(getLimiteForca());
			setSanidade(getLimiteSanidade());
			setVida(getLimiteVida());
			setSede(getLimiteSede());
			setResistenciaAoAmbiente(0.1);
			setFugirChance(0.1);
		
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

	@Override
	public void descricaoClasse() {
		System.out.println("***Classe Vampira:***");
		System.out.println(" Após vários anos convinvendo com vampiros, ela se tornou uma humano-vampira.\n Sua alegria, vem da dor alheia. ");
	}
	

}
