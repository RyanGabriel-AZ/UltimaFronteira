package personalidades;

import ambientacao.Ambiente;
import controladores.Inventario;
import criaturas.Criatura;
import itens.Arma;

public class FilhinhaDoPapai extends Personagem{

	public FilhinhaDoPapai(String nome, double vida, double energia, double fome, double sede, double sanidade,
			int protecaoEfeitosSecundarios, String classe,Inventario armInventario, Ambiente localizacao) {
		super(nome, vida, energia, fome, sede, sanidade, protecaoEfeitosSecundarios, classe, armInventario, localizacao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void statsPersonagem() {
		configurarLimites(400, 400, 125, 400, 400, 400);
		setEnergia(getLimiteEnergia());
		setFome(getLimiteFome());
		setForca(getLimiteForca());
		setSanidade(getLimiteSanidade());
		setVida(getLimiteVida());
		setSede(getLimiteSede());
		setResistenciaAoAmbiente(1);
		setFugirChance(0.75);
		
		
	}

	@Override
	public void ataque(Arma arma, Criatura monstros) {
		double dano= arma.getPoder()*getForca();
	    if(Math.random()<arma.getPrecisao()) {
	    	monstros.setVida(-dano);
	    	setVida(dano*0.5);//ela vai se curar ao causar dano
	    	arma.setDurabilidade(-10);
	}
	}

	@Override
	public void descricaoClasse() {
		System.out.println("***Classe FDP (ou Filhinha do papai)***");
		System.out.println("\"Papai realmente facilitou tudo para mim\"");
		
	}
}
