package controladores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import eventualidades.DesgastePersonagem;
import itens.Arma;
import itens.CriacaoDeItens;
import itens.Ferramenta;
import itens.Item;
import itens.Material;
import personalidades.Personagem;

public class Inventario {
	Scanner leitor = new Scanner(System.in);
	/*
	 * verifica a carga total que o personagem pode carregar só pode adicionar se
	 * não estourar a carga limite remover itens remove peso. Quero fazer um sistema
	 * futuramente, onde quanto maior a carga, mais energia gasta. public void
	 * cargaPeso()
	 * 
	 */
	CriacaoDeItens criador = new CriacaoDeItens();
	private ArrayList<Item> inventario = new ArrayList<>();
	DesgastePersonagem dadosJogador = new DesgastePersonagem("dados");

	public ArrayList<Item> acessarInventario() {
		return inventario;
	}

	public void adicionarItem(Item item) {
		inventario.add(item);
	}

	public void retirarItem(String nomeItem) {
		Iterator<Item> it = inventario.iterator();
		while (it.hasNext()) {
			Item item = it.next();
			if (item.getNome().equalsIgnoreCase(nomeItem)) {
				it.remove();
				System.out.println("Item removido: " + nomeItem);
				return; // sai do método depois de remover
			}
		}
		System.out.println("Item não encontrado: " + nomeItem);
	}

	public void usarItem(String nomeItem, Personagem jogador) {

		for (Item item : acessarInventario()) {
			if (item.getNome().equalsIgnoreCase(nomeItem)) {
				System.out.println(item.getNome());
				item.usar(jogador);
				break;

			}

		}
		System.out.println("Você não pode usar Armas, Materiais, ou Ferramentas, enquanto está no inventário! ");
	}

	public void adcionarQuantidade(Item itens, int numero) {
		for (Item item : acessarInventario()) {
			if (item.getNome().equalsIgnoreCase(itens.getNome())) {
				item.setQuantidade(numero);
			}
		}
	}

	public void removerItemBolsa() {
		System.out.println("Digite o nome do Item que você quer retirar: ");
		String nome = leitor.nextLine();
		System.out.println("Digite a quantidade que você quer liberar: ");
		int quantidade = leitor.nextInt();
		retirarQuantidade(nome, quantidade);

	}

	// colocar try catch
	public void retirarQuantidade(Item itens, int numero) {
		int a = 0;
		for (Item item : acessarInventario()) {
			if (item.getNome().equalsIgnoreCase(itens.getNome())) {
				item.setQuantidade(-numero);
				a = 1;
			}
		}
		if (a == 0) {
			System.out.println("Erro ao retirar item");
		}
	}

	public double pesoInventario() {
		double peso = 0;
		double pesoItens;
		for (Item item : acessarInventario()) {
			pesoItens = item.getPeso();
			peso = peso + pesoItens;
		}
		return peso;
	}

	public void listarInventario(String classe) {
		System.out.println("\n=== " + classe.toUpperCase() + " ===");
		for (Item item : acessarInventario()) {
			if (item.getClasse().equalsIgnoreCase(classe) && item.getQuantidade() > 0) {
				System.out.println(String.format("%-20s %-15d %-15s %-10.2f %-20s", item.getNome(),
						item.getQuantidade(), item.getTipo(), item.getPeso(), item.getEspecifico()));
			}
		}
	}

	public void mostrarInventario() {

		System.out.println("==========Inventário=========");
		System.out.println(
				"|     Nome     |     Quantidade    |     tipo     |     peso     |              específicos            | ");
		listarInventario("Material");
		listarInventario("Alimentos");
		listarInventario("Agua");
		listarInventario("Medicamentos");
		listarInventario("Arma");
		listarInventario("Ferramenta");

	}

// função principal do inventario
	public void inventarioFuncional(Personagem jogador) {

		int sair = 0;
		do {
			dadosJogador.StatsPersonagemSemDesgaste(jogador);
			mostrarInventario();
			System.out.println(
					"\nDigite:\n [S] para sair do inventario, \n[U] para usar um item\n [R] para remover itens \n"
							+ " [M] para a parte de cobinacação de materiais e,\n [CF] para criar Ferramentas, [CA] para criar armas. ");
			String letra = leitor.nextLine();
			switch (letra.toUpperCase()) {
			case "R": {
				removerItemBolsa();
				continue;
			}

			case "U": {
				usarItemGeral(jogador);
				continue;
			}
			case "M": {
				trabalharComMateriais();
				continue;
			}
			case "CF": {
				criarFerramentasInventario();
				continue;
			}
			case "CA": {
				criarArmasInventario();
				continue;
			}
			case "S":
				sair = 1;
				continue;
			}
			System.out.println("\nOcorreu algum erro! verifique se colocou as informações corretas ");
		} while (sair == 0);

	}

	public void usarItemGeral(Personagem jogador) {
		System.out.println("Digite o nome do item que voce deseja usar: ");
		String nomeItem = leitor.nextLine();
		usarItem(nomeItem, jogador);

	}

	public void trabalharComMateriais() {

		System.out.println("Digite o nome do material 1: ");
		String nomeMaterialA = leitor.nextLine();

		System.out.println("Digite o nome do material 2: ");
		String nomeMaterialB = leitor.nextLine();
		System.out.println("Digite o nome do material do novo material criado: ");
		String nome = leitor.nextLine();

		Material resultante = null;
		Material a = null;
		Material b = null;
		for (Item item : acessarInventario()) {
			if (item instanceof Material && item.getNome().equalsIgnoreCase(nomeMaterialA)
					&& item.getClasse().equalsIgnoreCase("Material")) {
				Material a1 = (Material) item;
				a = a1;
			}

		}
		for (Item item : acessarInventario()) {
			if (item instanceof Material && item.getNome().equalsIgnoreCase(nomeMaterialB)
					&& item.getClasse().equalsIgnoreCase("Material")) {
				Material b1 = (Material) item;
				b = b1;
			}
			if (a != null && b != null) {
				resultante = a.combinar(a, b);
				if (resultante != null) {
					clonarMaterialCombinado(resultante);				}
			}

			else {
				System.out.println("Erro, algum material está em falta");
			}

		}
	}

	public void criarFerramentasInventario() {
		System.out.println("Digite o nome do material que será usado: ");
		String nomeMaterialA = leitor.nextLine();
		System.out.println("\n Vamos ver se você tem o molde correto");

		Ferramenta resultante = null;
		Material a = null;
		Material b = null;
		//

		//
		for (Item item : acessarInventario()) {
			if (item.getNome().equalsIgnoreCase(nomeMaterialA) && item.getClasse().equalsIgnoreCase("Material")
					&& item instanceof Material) {
				Material a1 = (Material) item;
				a = a1;
			}

		}
		for (Item item : acessarInventario()) {
			if (item.getNome().equalsIgnoreCase("Molde de Ferramentas") && item.getClasse().equalsIgnoreCase("Material")
					&& item instanceof Material) {
				Material b1 = (Material) item;
				b = b1;
			}
		}
		if (a != null && b != null) {
			resultante = criador.criarFerramenta(a, b);
			if (resultante != null) {
				System.out.println(resultante.getNome());
				clonarFerramenta(resultante);
				retirarQuantidade(b, 1);
				retirarQuantidade(a, 1);
				itemNome(resultante);
			}
		} else {
			System.out.println("Erro, algum material está em falta");
		}

	}

	public void criarArmasInventario() {
		System.out.println("Digite o nome do material que será usado: ");
		String nomeMaterialA = null;
		nomeMaterialA = leitor.nextLine();

		Arma resultante = null;
		Material a = null;
		Material b = null;
		for (Item item : acessarInventario()) {
			if (item instanceof Material && item.getNome().equalsIgnoreCase(nomeMaterialA)
					&& item.getClasse().equalsIgnoreCase("Material")) {
				Material a1 = (Material) item;
				a = a1;
			}

		}
		for (Item item : acessarInventario()) {
			if (item instanceof Material && item.getNome().equalsIgnoreCase("Molde de armas")
					&& item.getClasse().equalsIgnoreCase("Material")) {
				Material b1 = (Material) item;
				b = b1;
			}
		}
		if (a != null && b != null) {
			resultante = criador.criarArma(a, b);
			if (resultante != null) {
				clonarArmas(resultante);
				retirarQuantidade(b, 1);
				retirarQuantidade(a, 1);
			}

		} else {
			System.out.println("Erro, algum material está em falta");
		}
	}

	public void retirarQuantidade(String nome, int numero) {
		for (Item item : acessarInventario()) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				item.setQuantidade(-numero);
			}
		}
	}

	public boolean verificarSeHaArmasFerramentas(String classeArmaOuFerramenta) {
		for (Item item : acessarInventario()) {
			if (item.getClasse().equalsIgnoreCase(classeArmaOuFerramenta) && item.getQuantidade() > 0) {
				return true;
			}
		}
		return false;
	}

	public void clonarFerramenta(Ferramenta ferramenta) {
		for (Item iteragir : inventario) {
			if (iteragir.getNome().equalsIgnoreCase(ferramenta.getNome())) {
				if (iteragir instanceof Ferramenta) {
					Ferramenta f = (Ferramenta) iteragir;
					f.setDurabilidade(ferramenta.getDurabilidade());
					f.setEficiencia(ferramenta.getEficiencia());
					f.setResistencia(ferramenta.getResistencia());
					f.setQuantidade(1);
					f.setClasse(ferramenta.getClasse());
					f.setPeso(ferramenta.getPeso());
					return;

				}

			}
		}

	}
public void clonarArmas(Arma arma) {
	for (Item item : inventario) {
		if(item.getTipo().equalsIgnoreCase(arma.getNome())) {
			if(item instanceof Arma) {
				Arma a= (Arma) item;
				a.setDurabilidade(arma.getDurabilidade());
				a.setPeso(arma.getPeso());
				a.setPoder(arma.getPoder());
				a.setPrecisao(arma.getPrecisao());
				a.setResistencia(arma.getResistencia());
				a.setQuantidade(1);
				a.setClasse(arma.getClasse());
				return;
				
				
			}
		}
		
	}
	
	
	
	
}
public void clonarMaterialCombinado(Material material) {
	for (Item item : inventario) {
		if(item.getTipo().equalsIgnoreCase(material.getTipo())) {
			if(item instanceof Material) {
				Material a= (Material) item;
				a.setDurabilidade(material.getDurabilidade());
				a.setNome(material.getNome());
				a.setPeso(material.getPeso());
				a.setQuantidade(1);
				a.setResistencia(material.getResistencia());
				return;
				
				
			}
		}
	}
	
}
public void itemNome(Item item1) {
	for (Item item : inventario) {
		if(item.getNome().equalsIgnoreCase(item1.getNome())) {
			System.out.println(item.getNome());
		}
	}
}











}
