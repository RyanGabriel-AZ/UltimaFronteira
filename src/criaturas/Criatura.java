package criaturas;
import ambientacao.*;
public abstract class Criatura {
	private String nome;
	private float vida;
	private int individuosPorGrupo;
	private String descricao;
	private Ambiente habitat;

	public Criatura(String nome, float vida, int individuosPorGrupo, String descricao, Ambiente habitat) {
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

	public void setVida(float vida) {
		vida = vida + getVida();
		this.vida = vida;
	}

	public float getVida() {
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

	public abstract void interagir();

}
