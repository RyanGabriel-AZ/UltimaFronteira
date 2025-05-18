package itens;

import personalidades.Personagem;

public class Material extends Item {
	
	public Material(String nome, double peso, double durabilidade, int quantidade, double resistencia, String tipo) {
		super(nome, peso, durabilidade, quantidade, tipo);
		this.resistencia = resistencia;
		
	}

	private double resistencia;

// Acho que o combinar seria o nosso usar.
	public Material combinar(Material a, Material b) {
		if (a.getResistencia() > 0 && +b.getResistencia() > 0 && a.getQuantidade() > 0 && b.getQuantidade() > 0 && a.getTipo().equalsIgnoreCase(b.getTipo())) {
			double resistencia = a.getResistencia() + b.getResistencia();
			double peso = (a.getPeso() + b.getPeso()) * 0.75;
			double durabilidade = a.getDurabilidade() + b.getDurabilidade();
			a.setQuantidade(-1);
			b.setQuantidade(-1);
			String tipo= a.getTipo();
			Material c = new Material("material criado", peso, durabilidade, 1, resistencia, tipo);
			return c;
		}
		System.out.println("Não é possível combinar os materiais");
		return null;
	}

	public double getResistencia() {
		return resistencia;
	}

	public void setResistencia(double resistencia) {
		this.resistencia = resistencia;
	}

	public boolean verificarPossivelCriacao(Material a, Material b) {
		if (a.getQuantidade() > 0 && b.getQuantidade() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verificarPossivelCriacao(Material a, Material b, Material c) {
		if (a.getQuantidade() > 0 && b.getQuantidade() > 0 && c.getQuantidade() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * terminar depois, isso é a criaçao de armas e ferramentas, talvez até remédio.
	 * public Material criar(Material a, Material b) {
	 * if(verificarPossivelCriacao(a, b)) {
	 * 
	 * } }
	 */
	@Override
	public void usar(Personagem jogador) {

	}

	
}
