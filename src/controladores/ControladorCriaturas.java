package controladores;

import criaturas.*;

import java.util.ArrayList;

import ambientacao.*;

public class ControladorCriaturas {

	ArrayList<Criatura> criaturas = new ArrayList<>();
	ArrayList<Criatura> criaturasAmbiente = new ArrayList<>();

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
