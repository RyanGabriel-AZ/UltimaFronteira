package ambientacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import controladores.Inventario;
import itens.Item;
import personalidades.Personagem;

public abstract class Ambiente {
	private String nome;
	private String descricao;
	private double dificuldadeDeExploração; // 0 a 100, condiz com os itens da exploracao, chance de obte-los;
	private double probabilidadeDeEventos;
	private String condicoesClimaticasPredominantes;
	private Inventario inventario;
	Random aleatorio = new Random();
	private HashMap<Ambiente, ArrayList<Item>> itensAmbiente= new HashMap<>();

	public Ambiente(String nome, String descricao, double dificuldadeDeExploração, double probabilidadeDeEventos,
			String condicoesClimaticasPredominantes, Inventario inventario) {
		this.nome = nome;
		this.descricao = descricao;
		this.condicoesClimaticasPredominantes = condicoesClimaticasPredominantes;
		this.dificuldadeDeExploração = dificuldadeDeExploração;
		this.probabilidadeDeEventos = probabilidadeDeEventos;
		this.inventario= inventario;

	}

	public abstract void Explorar(Personagem jogador); //itens e texto do ambiente
	public abstract void naturezaAmbiente(Personagem jogador); //pega os atributos do ambiente e mexem com o jogador

	/*
	 * public abstract void GerarEvento(); public abstract void ModificarClima();
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public double getDificuldadeDeExploração() {
		return dificuldadeDeExploração;
	}

	public void setDificuldadeDeExploração(double dificuldadeDeExploração) {
		this.dificuldadeDeExploração = dificuldadeDeExploração;
	}

	public double getProbabilidadeDeEventos() {
		return probabilidadeDeEventos;
	}

	public void setProbabilidadeDeEventos(double probabilidadeDeEventos) {
		this.probabilidadeDeEventos = probabilidadeDeEventos;
	}

	public String getCondicoesClimaticasPredominantes() {
		return condicoesClimaticasPredominantes;
	}

	public void setCondicoesClimaticasPredominantes(String condicoesClimaticasPredominantes) {
		this.condicoesClimaticasPredominantes = condicoesClimaticasPredominantes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) { 
		this.descricao = descricao;
	}

	public abstract void adicionarItensAbiente(Item Item); 
public abstract ArrayList<Item> itensDoAmbiente();

public void adcionarAmbientesAoHASH(Ambiente ambiente ) {
itensAmbiente.put(ambiente, itensDoAmbiente());	
}
public ArrayList<Item>  acessarHash(Personagem jogador){
	return itensAmbiente.get(jogador.getLocalizacao());
	
}





	
	// loucura total
	public void espoliosAmbiente(Personagem jogador) {
		double dificuldadeExploracao= getDificuldadeDeExploração();
		
		for (Item item : acessarHash(jogador)) {
			if (aleatorio.nextDouble(100) < dificuldadeExploracao) {
				inventario.adcionarQuantidade(item, 1);
			}

		}
	}

	public void setInventarioAmbiente(Inventario inventario) {
		this.inventario = inventario;
	}
}
