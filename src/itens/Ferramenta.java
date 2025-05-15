package itens;

public class Ferramenta extends Material {
	private double eficiencia;
	private String tipo;

	public Ferramenta(String nome, double peso, double durabilidade, int quantidade, double resistencia,
			double eficiencia, String tipo) {
		super(nome, peso, durabilidade, quantidade, resistencia);
		this.eficiencia=eficiencia;
		this.tipo= tipo;
		// TODO Auto-generated constructor stub
	}

	public double getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(double eficiencia) {
		this.eficiencia = eficiencia;
	}
	
	

	}
	

