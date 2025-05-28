package criaturas;
import ambientacao.Ambiente;
import personalidades.Personagem;
public abstract class Criatura {
	private String nome;
	private double vida;
	private int individuosPorGrupo;
	private String descricao;
	private Ambiente habitat;
	private boolean podeLutar;

	public Criatura(String nome, double vida, int individuosPorGrupo, String descricao, Ambiente habitat) {
		this.nome = nome;
		this.vida = vida;
		this.individuosPorGrupo = individuosPorGrupo;
		this.descricao = descricao;
		this.habitat = habitat;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setHabitat(Ambiente habitat) {
		this.habitat = habitat;
	}

	public Ambiente getHabitat() {
		return habitat;

	}

	public String getDescricao() {
		return descricao;
	}

	public void setVida(double dano) {
		dano = dano + getVida();
		this.vida = dano;
	}

	public double getVida() {
		return vida;
	}

	public void setIndividuosPorGrupo(int individuosPorGrupo) {
		this.individuosPorGrupo = individuosPorGrupo;
	}

	public void setDescriçao(String descricao) {
		this.descricao = descricao;
	}

	public int getIndividuosPorGrupo() {
		return individuosPorGrupo;

	}

	public abstract void interagir(Personagem jogador);

	public boolean getPodeLutar() {
		return podeLutar;
	}

	public void setPodeLutar(boolean podeLutar) {
		this.podeLutar = podeLutar;
	}

}
