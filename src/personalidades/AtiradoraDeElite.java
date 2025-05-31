package personalidades;

import ambientacao.Ambiente;
import controladores.Inventario;
import criaturas.Criatura;
import itens.Arma;

public class AtiradoraDeElite extends Personagem{

	public AtiradoraDeElite(String nome, double vida, double energia, double fome, double sede, double sanidade,
			int protecaoEfeitosSecundarios, String classe,Inventario armInventario, Ambiente localizacao) {
		super(nome, vida, energia, fome, sede, sanidade, protecaoEfeitosSecundarios, classe, armInventario, localizacao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ataque(Arma arma, Criatura monstros) {
		double dano= -arma.getPoder()*getForca();
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
		setFugirChance(0.1);
	}

	@Override
	public void descricaoClasse() {
		System.out.println("Classe ATE ou atiradora de elite: Com ela todos os seus ataques serão certeiros\n "
				+ "Ataques de alcance longo, terá dano triplicado no inimigo");
		
		
	}
	
}
