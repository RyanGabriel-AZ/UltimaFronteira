package personalidades;

import java.util.Random;

import ambientacao.Ambiente;
import controladores.Inventario;
import criaturas.Criatura;
import itens.Arma;

public class Coringa extends Personagem{
Random aleatorio= new Random();

	public Coringa(String nome, double vida, double energia, double fome, double sede, double sanidade,
			int protecaoEfeitosSecundarios, String classe,Inventario armInventario, Ambiente localizacao) {
		super(nome, vida, energia, fome, sede, sanidade, protecaoEfeitosSecundarios, classe, armInventario, localizacao);
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
		setFugirChance(ZeroAUm());
		
	}

	@Override
	public void ataque(Arma arma, Criatura monstros) {
		double dano= -arma.getPoder()*getForca();
	    if(Math.random()<arma.getPrecisao()) {
	    	monstros.setVida(dano);
	    	arma.setDurabilidade(-10);
	    }
	}
	@Override
	public void descricaoClasse() {
		System.out.println("Classe coringa: é ótima para quem ama viver à base da sorte");
	}

	
	
	
	
	
	
}
