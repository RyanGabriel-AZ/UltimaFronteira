package personalidades;
import ambientacao.Ambiente;
import controladores.Inventario;
import criaturas.Criatura;
import itens.Arma;
public abstract class Personagem {

	/*
	 * Fazer um contador de turnos para protecao, ela só pode ir ate 0, não pode ser mais que isso
	 */
	private String nome;
	private double vida;
	private double energia;
	private double fome;
	private double sede;
	private Ambiente localizacao;
	private double sanidade;
	private Inventario armazenamento;
	private double forca;
	private int protecaoEfeitosSecundarios;
	private double resistenciaAoAmbiente; // vai de 0 a 1, quanto menor, mais resistente
	private String classe;
	private double limiteVida;
	private double limiteEnergia;
	private double limiteFome; 
	private double limiteSede;
	private double limiteSanidade;
	private double limiteForca;
	private double fugirChance; // 0 a 1, quanto menor mais dificil é fugir das batalhas
//esse construtor é só para os atributos que estou precisando em DesgastePersonagem
	public Personagem(String nome, double vida, double energia, double fome, double sede, double sanidade, int protecaoEfeitosSecundarios) {
		this.energia=energia;
		this.fome=fome;
		this.sanidade=sanidade;;
		this.vida=vida;
		this.sede=sede;
		this.setNome(nome);
		this.protecaoEfeitosSecundarios=protecaoEfeitosSecundarios;
	}
	public void configurarLimites(double limiteVida, double limiteEnergia,double limiteForca, double limiteFome,double limiteSanidade, double limiteSede) {
		this.limiteEnergia=limiteEnergia;
		this.limiteFome=limiteFome;
		this.limiteSanidade= limiteSanidade;
		this.limiteSede= limiteSede;
		this.limiteVida= limiteVida;
		this.limiteForca=limiteForca;
	}
	public double getLimiteVida() {
		return limiteVida;
	}
	public double getLimiteEnergia() {
		return limiteEnergia;
	}
	public double getLimiteFome() {
		return limiteFome;
	}
	public double getLimiteSede() {
		return limiteSede;
	}
	public double getLimiteSanidade() {
		return limiteSanidade;
	}
	public double getLimiteForca() {
		return limiteForca;
	}
	
	
	public void diminuirProtecao() {
		if(getProtecaoEfeitosSecundarios()>0) {
			setProtecaoEfeitosSecundarios(-1);
		}
	}
	
	public void setLocalização(Ambiente localizacao) {
		this.localizacao=localizacao;
	}


	public double getVida() {
		return vida;
	}


	public void setVida(double vida) {
		
		this.vida = vida + getVida();
		if(getVida()>getLimiteVida()) {
			this.vida= getLimiteVida();
		}
	}


	public double getEnergia() {
		return energia;
	}


	public void setEnergia(double energia) {
		this.energia = energia+ getEnergia();
		if(getEnergia()>getLimiteEnergia()) {
			this.energia= getLimiteEnergia();
		}
	}


	public double getFome() {
		return fome;
	}


	public void setFome(double fome) {
		this.fome = fome + getFome();
		if(getFome()>getLimiteFome()) {
			this.fome= getLimiteFome();
		
		}
	}


	public double getSede() {
		return sede;
	}


	public void setSede(double sede) {
		this.sede = sede +getSede();
		if(getSede()>getLimiteSede()) {
			this.sede= getLimiteSede();
		}
	}


	public double getSanidade() {
		return sanidade;
	}


	public void setSanidade(double sanidade) {
		this.sanidade = sanidade +getSanidade();
		if(getSanidade()>getLimiteSanidade()) {
			this.sanidade= getLimiteSanidade();
		}
	}


	public double getForca() {
		return forca;
	}


	public void setForca(double forca) {
		this.forca = forca + getForca();
		if(getForca()>getLimiteForca()) {
			this.forca= getLimiteForca();
		}
	}



	public int getProtecaoEfeitosSecundarios() {
		return protecaoEfeitosSecundarios;
	}


	public void setProtecaoEfeitosSecundarios(int protecaoEfeitosSecundarios) {
		this.protecaoEfeitosSecundarios = protecaoEfeitosSecundarios + getProtecaoEfeitosSecundarios();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Ambiente getLocalizacao() {
		return localizacao;
	}
	public double getResistenciaAoAmbiente() {
		return resistenciaAoAmbiente;
	}
	public void setResistenciaAoAmbiente(double d) {
		this.resistenciaAoAmbiente = d;
	}
	public Inventario getArmazenamento() {
		return armazenamento;		
	}
	public void setArmazenamento(Inventario inventario) {
		this.armazenamento= armazenamento;
	}
	
	
public abstract void statsPersonagem();
/*
	configurarLimites(limiteVida, limiteEnergia, limiteForca, limiteFome, limiteSanidade, limiteSede);
	setEnergia(getLimiteEnergia());
		setFome(getLimiteFome());
		setForca(getLimiteForca());
		setSanidade(getLimiteSanidade());
		setVida(getLimiteVida());
		setSede(getLimiteSede());
		setResistenciaAoAmbiente();
	
	
*/
public abstract void ataque(Arma arma, Criatura monstros);
/*{
	double dano= arma.getPoder()*getForca();
    if(Math.random()<arma.getPrecisao()) {
    	monstros.setVida(dano);
    	arma.setDurabilidade(-10);
    }
}*/
public String getClasse() {
	return classe;
}
public void setClasse(String classe) {
	this.classe = classe;
}
public abstract void descricaoClasse();
public double getFugirChance() {
	return fugirChance;
}
public void setFugirChance(double fugirChance) {
	this.fugirChance = fugirChance;
}
	
}
