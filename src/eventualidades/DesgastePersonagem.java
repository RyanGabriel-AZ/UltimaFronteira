package eventualidades;

import java.util.ArrayList;

import personalidades.Personagem;

public class DesgastePersonagem {
	/*
	 * Aqui vamos colocar o sistema de desgaste: perda de vida, energia, sanidade,
	 * etc. tambem deve ser feito a tabela turno por aqui
	 */
	private ArrayList<Personagem> estado = new ArrayList<>();
	/*
	 * Deve se criar 3 perssonagem nesse molde
	Normal antes = new Normal("antes", 0, 0, 0, 0, 0, 0);
	Normal atual = new Normal("Atual", 0, 0, 0, 0, 0, 0);
	Normal resultado = new Normal("resultado", 0, 0, 0, 0, 0, 0);
*/
	public void adicionarEstados(Personagem antes, Personagem depois, Personagem resultado) {
		estado.add(antes);
		estado.add(depois);
		estado.add(resultado);

	}
	public ArrayList<Personagem> getDesgates(){
		return estado;
	}
	public Personagem retornarEstado(Personagem  antesOUDepois) {
		for (Personagem personagem : estado) {
			if (personagem.getNome().equalsIgnoreCase(antesOUDepois.getNome())) {
				return personagem;
			}
		}
		return null;
		
		
	}

	public void limparEstados() {
		estado.clear();
	}

	public void atualizarEstadoAntesDepois(Personagem jogador, Personagem AntesouAtual) {
		for (Personagem personagem : estado) {
			if (personagem.getNome().equalsIgnoreCase(AntesouAtual.getNome())) {
				personagem.setEnergia(jogador.getEnergia());
				personagem.setFome(jogador.getFome());
				personagem.setProtecaoEfeitosSecundarios(jogador.getProtecaoEfeitosSecundarios());
				personagem.setSanidade(jogador.getSanidade());
				personagem.setSede(jogador.getSede());
				personagem.setVida(jogador.getVida());
				break;
			}
		}
	}

	public void atualizarResultado(Personagem antes, Personagem atual, Personagem resultado) {
		for (Personagem personagem : estado) {
			if (personagem.getNome().equalsIgnoreCase(resultado.getNome())) {
				personagem.setEnergia(retornarEstado(atual).getEnergia() - retornarEstado(antes).getEnergia());
				personagem.setFome(retornarEstado(atual).getFome() - retornarEstado(antes).getFome());
				personagem.setProtecaoEfeitosSecundarios(
						retornarEstado(atual).getProtecaoEfeitosSecundarios() - retornarEstado(antes).getProtecaoEfeitosSecundarios());
				personagem.setSanidade(retornarEstado(atual).getSanidade() - retornarEstado(antes).getSanidade());
				personagem.setSede(retornarEstado(atual).getSede() - retornarEstado(antes).getSede());
				personagem.setVida(retornarEstado(atual).getVida() - retornarEstado(antes).getVida());
				break;
			}
		}

	}

	public String aumentouDiminuiu(int valor) {

		if (valor > 0) {
			return "aumentou em " + String.valueOf(valor);
		} else if (valor == 0) {
			return "não alterou ";
		}

		else {
			return "diminuiu em " + String.valueOf(valor);
		}

	}

	public String aumentouDiminuiu(double valor) {

		if (valor > 0) {
			return "aumentou em: " + String.format("%.1f", valor);
		} else if (valor == 0.0)
			return "não alterou ";

		else {
			return "diminuiu em: " + String.format("%.1f", valor);
		}

	}

	public void mostrarResultado(Personagem resultado) {
		for (Personagem personagem : estado) {
			if (personagem.getNome().equalsIgnoreCase(resultado.getNome())) {
				System.out.println("Sua vida" + aumentouDiminuiu(personagem.getVida()));
				System.out.println("Sua energia" + aumentouDiminuiu(personagem.getEnergia()));
				System.out.println("Sua sanidade" + aumentouDiminuiu(personagem.getSanidade()));
				System.out.println("Sua fome" + aumentouDiminuiu(personagem.getFome()));
				System.out.println("Sua sede" + aumentouDiminuiu(personagem.getSede()));
				System.out.println("Sua proteção contra  efeitos secundarios"
						+ aumentouDiminuiu(personagem.getProtecaoEfeitosSecundarios()));
				break;
			}
		}
	}

	public void resultadosAntesDepois(Personagem estadoMostrarAntesOuAtual) {
		for (Personagem personagem : estado) {
			if (personagem.getNome().equalsIgnoreCase(estadoMostrarAntesOuAtual.getNome())) {
				System.out.println("Estado: " + personagem.getNome() + "\n" + "vida: " + personagem.getVida()
						+ " Energia: " + personagem.getEnergia() + " Sanidade: " + personagem.getSanidade() + " Fome: "
						+ personagem.getFome() + " Sede: " + personagem.getSede()
						+ " proteção contra efeitos secundarios: " + personagem.getProtecaoEfeitosSecundarios());
				break;
			}
		}
	}

	public void cicloEstados(Personagem jogador, Personagem antes, Personagem atual, Personagem resultado) {
		adicionarEstados(antes, atual, resultado);
		atualizarEstadoAntesDepois(jogador, antes);
		// batalhas
		atualizarEstadoAntesDepois(jogador, atual);
		atualizarResultado(antes, atual, resultado);
		// atualizei agora vou mostrar o resutado
		resultadosAntesDepois(antes);
		resultadosAntesDepois(atual);
		// resultado final
		mostrarResultado(resultado);
		// limpar o array, para reuso.
		limparEstados();

	}
	/*
	 * É o seguinte. vamos colocar os dados iniciais em antes, igualando objetos. e
	 * quando acabar o turno em depois. vamos fazer 4 funçoes principais. uma para
	 * atualizar os objetos. uma para pegar valores dos objetos. uma para mostrar a
	 * diferença, e e uma que mpstre o antes e depois. OBS: o Antes inicial é igual
	 * ao do jogador. ele atualiza depois para o depois. o depois sempre vai ser
	 * igual ao do jogador. essas ações são execultadas no fim do turno.
	 * 
	 * ex: no inicio do turno tinha 10 de vida. no final tinha 15. a mudança foi de
	 * 5 de vida. estamos usando array, porque é mais facil guardar dados com ele.
	 */

}
