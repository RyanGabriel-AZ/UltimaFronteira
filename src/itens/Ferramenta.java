package itens;

public class Ferramenta extends Material {
	private double eficiencia;
	public Ferramenta(String nome, double peso, double durabilidade, int quantidade, double resistencia,
			double eficiencia, String tipo, String classe) {
		super(nome, peso, durabilidade, quantidade, resistencia, tipo, classe);
		this.eficiencia=eficiencia;
	}

	public double getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(double eficiencia) {
		this.eficiencia = eficiencia;
	}
	
@Override
public String getEspecifico() {
	return String.valueOf(getEficiencia());
}

	}
	

