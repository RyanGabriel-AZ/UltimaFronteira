package eventualidades;

import java.util.ArrayList;

import personalidades.Personagem;

public class DesgastePersonagem {
	private double vida;
	private double energia;
	private double sede; 
	private double sanidade;
	private double fome;
	private String indentificador;
	private int ProtecaoContraEfeitosSecundarios;
	
	public DesgastePersonagem(String indentificador) {
		this.indentificador= indentificador;
	}
	
	
	
	
	/*
	 * Aqui vamos colocar o sistema de desgaste: perda de vida, energia, sanidade,
	 * etc. tambem deve ser feito a tabela turno por aqui
	 */
	private ArrayList<DesgastePersonagem> estado = new ArrayList<>();
	/*
	Deve se criar 3 objetos para operar essa classe
*/
	public void StatsPersonagemSemDesgaste(Personagem jogador) {
		System.out.println("\n==Vida== ==Sanidade== ==fome== ==Energia== ==Sede== ==Proteção== ");
		System.out.println(String.format("%-10.1f %-10.1f %-10.1f %-10.1f %-10.1f %-10d", jogador.getVida(), jogador.getSanidade(), jogador.getFome(), jogador.getEnergia(), jogador.getSede(), jogador.getProtecaoEfeitosSecundarios()));
		
	}
	
	
	
	
	
	
	
	
	public void adicionarEstados(DesgastePersonagem antes, DesgastePersonagem depois, DesgastePersonagem resultado) {
		estado.add(antes);
		estado.add(depois);
		estado.add(resultado);

	}
	public ArrayList<DesgastePersonagem> getDesgates(){
		return estado;
	}
	public DesgastePersonagem retornarEstado(DesgastePersonagem  antesOUDepois) {
		for (DesgastePersonagem personagem : getDesgates()) {
			if (personagem.getIndentificador().equalsIgnoreCase(antesOUDepois.getIndentificador())) {
				return personagem;
			}
		}
		return null;
		
		
	}

	public void limparEstados() {
		estado.clear();
	}

	public void atualizarEstadoAntesDepois(Personagem jogador, DesgastePersonagem AntesouAtual) {
		for (DesgastePersonagem personagem : getDesgates()) {
			if (personagem.getIndentificador().equalsIgnoreCase(AntesouAtual.getIndentificador())) {
				personagem.setEnergia(jogador.getEnergia());
				personagem.setFome(jogador.getFome());
				personagem.setProtecaoContraEfeitosSecundarios(jogador.getProtecaoEfeitosSecundarios());
				personagem.setSanidade(jogador.getSanidade());
				personagem.setSede(jogador.getSede());
				personagem.setVida(jogador.getVida());
				
			}
		}
	}

	public void atualizarResultado(DesgastePersonagem antes, DesgastePersonagem atual, DesgastePersonagem resultado) {
		for (DesgastePersonagem personagem :getDesgates()) {
			if (personagem.getIndentificador().equalsIgnoreCase(resultado.getIndentificador())) {
				personagem.setEnergia(retornarEstado(atual).getEnergia() - retornarEstado(antes).getEnergia());
				personagem.setFome(retornarEstado(atual).getFome() - retornarEstado(antes).getFome());
				personagem.setProtecaoContraEfeitosSecundarios(retornarEstado(atual).getProtecaoContraEfeitosSecundarios() - retornarEstado(antes).getProtecaoContraEfeitosSecundarios());
				personagem.setSanidade(retornarEstado(atual).getSanidade() - retornarEstado(antes).getSanidade());
				personagem.setSede(retornarEstado(atual).getSede() - retornarEstado(antes).getSede());
				personagem.setVida(retornarEstado(atual).getVida() - retornarEstado(antes).getVida());
				
			}
		}

	}

	public String aumentouDiminuiu(int valor) {

		if (valor > 0) {
			return "aumentou em " + (valor);
		} else if (valor == 0) {
			return "não alterou ";
		}

		else {
			return "diminuiu em " + (valor);
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

	public void mostrarResultado(DesgastePersonagem resultado) {
		for (DesgastePersonagem personagem : getDesgates()) {
			if (personagem.getIndentificador().equalsIgnoreCase(resultado.getIndentificador())) {
				System.out.println("Sua vida " + aumentouDiminuiu(personagem.getVida()));
				System.out.println("Sua energia " + aumentouDiminuiu(personagem.getEnergia()));
				System.out.println("Sua sanidade " + aumentouDiminuiu(personagem.getSanidade()));
				System.out.println("Sua fome " + aumentouDiminuiu(personagem.getFome()));
				System.out.println("Sua sede " + aumentouDiminuiu(personagem.getSede()));
				System.out.println("Sua proteção contra  efeitos secundarios "
						+ aumentouDiminuiu(personagem.getProtecaoContraEfeitosSecundarios()));
				
			}
		}
	}

	public void resultadosAntesDepois(DesgastePersonagem estadoMostrarAntesOuAtual) {
		for (DesgastePersonagem personagem : getDesgates()) {
			if (personagem.getIndentificador().equalsIgnoreCase(estadoMostrarAntesOuAtual.getIndentificador())) {
				
				System.out.println("\n==Estado== ==Vida== ==Sanidade== ==fome== ==Energia== ==Sede== ==Proteção== ");
				System.out.println(String.format("%-10s %-10.1f %-10.1f %-10.1f %-10.1f %-10.1f %-10d",personagem.getIndentificador(), personagem.getVida(), personagem.getSanidade(), personagem.getFome(), personagem.getEnergia(), personagem.getSede(), personagem.getProtecaoContraEfeitosSecundarios()));
				
				
				
				
				break;
			}
		}
	}

	public void cicloEstados(Personagem jogador, DesgastePersonagem antes,DesgastePersonagem atual, DesgastePersonagem resultado) {
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
	public int getProtecaoContraEfeitosSecundarios() {
		return ProtecaoContraEfeitosSecundarios;
	}
	public void setProtecaoContraEfeitosSecundarios(int protecaoContraEfeitosSecundarios) {
		ProtecaoContraEfeitosSecundarios = protecaoContraEfeitosSecundarios;
	}
	public String getIndentificador() {
		return indentificador;
	}
	public void setIndentificador(String indentificador) {
		this.indentificador = indentificador;
	}
	public double getFome() {
		return fome;
	}
	public void setFome(double fome) {
		this.fome = fome;
	}
	public double getSanidade() {
		return sanidade;
	}
	public void setSanidade(double sanidade) {
		this.sanidade = sanidade;
	}
	public double getSede() {
		return sede;
	}
	public void setSede(double sede) {
		this.sede = sede;
	}
	public double getEnergia() {
		return energia;
	}
	public void setEnergia(double energia) {
		this.energia = energia;
	}
	public double getVida() {
		return vida;
	}
	public void setVida(double vida) {
		this.vida = vida;
	}

}
