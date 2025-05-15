package itens;

public class Arma extends Material {
	private double poder;
	private double precisao;
	private String tipo;
	public Arma(String nome, double peso, double durabilidade,
			int quantidade, double resistencia, double poder, double precisao, String tipo) {
		super(nome, peso, durabilidade, quantidade, resistencia);
		this.poder= peso;
		this.precisao= precisao;
		this.tipo= tipo;
		// TODO Auto-generated constructor stub
	}
	
	public double getPoder() {
		return poder;
	}
	public void setPoder(double poder) {
		this.poder = poder;
	}
	public double getPrecisao() {
		return precisao;
	}
	public void setPrecisao(double precisao) {
		this.precisao = precisao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
