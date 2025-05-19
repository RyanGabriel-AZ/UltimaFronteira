package controladores;

import java.util.ArrayList;

import ambientacao.Ambiente;
import criaturas.Criatura;

public class ControladorCriaturas {

	private ArrayList<Criatura> criaturas = new ArrayList<>();
	private ArrayList<Criatura> criaturasAmbiente = new ArrayList<>();

	
	public  ArrayList<Criatura>  criaturas(){
		return criaturasAmbiente;
	}
	
	public void adicionarCriaturas(Criatura criatura) {
		criaturas.add(criatura);
	}

	public void removerCriatura(String nomeCriatura) {
		for (Criatura criatura : criaturas) {
			if (criatura.getNome().equalsIgnoreCase(nomeCriatura)) {
				criaturas.remove(criatura);
				break;
			}
		}

	}
/*
 * quando chegar no ambiente usamos o criaturas ambiente, para acessar apenas as criaturas daquele ambiente.
 * e sairmos temos que limpar tudo
 */
	public void adicionarCriaturasDoAmbiente(Ambiente habitat) {
		for (Criatura criatura : criaturas) {
			if (criatura.getHabitat().equals(habitat)) {
				criaturasAmbiente.add(criatura);

			}
		}
	}
// usar quando mudar de ambiente
	public void limparCriaturasAmbiente() {
		criaturasAmbiente.clear();
	}
}
