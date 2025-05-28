package controladores;

import java.util.ArrayList;
import java.util.Random;

import ambientacao.Ambiente;
import criaturas.CriaturasHostis;

public class ControladorCriaturas {
Random sorte= new Random();
	private ArrayList<CriaturasHostis> criaturas = new ArrayList<>();
	private ArrayList<CriaturasHostis> criaturasAmbiente = new ArrayList<>();

	
	public  ArrayList<CriaturasHostis>  criaturas(){
		return criaturasAmbiente;
	}
	
	public void adicionarCriaturas(CriaturasHostis criatura) {
		criaturas.add(criatura);
	}

	public void removerCriatura(String nomeCriatura) {
		for (CriaturasHostis criatura : criaturas) {
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
		for (CriaturasHostis criatura : criaturas) {
			if (criatura.getHabitat().equals(habitat)) {
				criaturasAmbiente.add(criatura);

			}
		}
	}
// usar quando mudar de ambiente
	public void limparCriaturasAmbiente() {
		criaturasAmbiente.clear();
	}
	public CriaturasHostis sortearCriatura() {
	int tamanho= criaturasAmbiente.size();
	
	return criaturasAmbiente.get(sorte.nextInt(tamanho));
	
	}
}
