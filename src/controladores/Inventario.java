package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import itens.CriacaoDeItens;
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
	CriacaoDeItens criador= new CriacaoDeItens();
	private ArrayList<Item> inventario = new ArrayList<>();

	public ArrayList<Item> acessarInventario() {
		return inventario;
	}

	public void adicionarItem(Item item) {
		inventario.add(item);
	}

	public void retirarItem(String nomeItem) {
		for (Item item : acessarInventario()) {
			if (item.getNome().equalsIgnoreCase(nomeItem)) {
				inventario.remove(item);
				break;
			}
		}
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
		String nome= leitor.nextLine();
		System.out.println("Digite a quantidade que você quer liberar: ");
		int quantidade= leitor.nextInt();
		retirarQuantidade(nome, quantidade);
		
		
	}
	// colocar try catch
	public void retirarQuantidade(Item itens, int numero) {
		int a=0;
		for (Item item : acessarInventario()) {
			if (item.getNome().equalsIgnoreCase(itens.getNome())) {
				item.setQuantidade(-numero);
				a=1;
			}
		}
		if(a==0) {
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
	
	int sair=0;
	do{
		
		mostrarInventario();
		System.out.println("Digite 'S', para sair do inventario, \n'U' para usar um item,\n 'R' para remover itens, \n"
				+ " 'M' para a parte de cobinacação de materiais e,\n 'CF' para criar Ferramentas, 'CA' para criar armas. ");
		String letra= leitor.nextLine();
		switch(letra.toUpperCase()){
		case "R": {
			removerItemBolsa();
			continue;
		}
		
			case "U": {
				usarItemGeral(jogador);
			continue;}
			case "M": {
				trabalharComMateriais();
				continue;
			}
			case "CF":{
				criarFerramentasInventario();
		continue;
			}
			case"CA":{
				criarArmasInventario();
				continue;
			}
			case"S":
				sair=1;
				continue;
		}
		System.out.println("Ocorreu algum erro! verifique se colocou as informações corretas ");
		}while(sair==0);
		
	
	
	
}

	public void usarItemGeral(Personagem jogador) {
		System.out.println("Digite o nome do item que voce deseja usar: ");
		String nomeItem = leitor.nextLine();
		usarItem(nomeItem, jogador);

	}
	public void trabalharComMateriais() {
		
		System.out.println("Digite o nome do material 1: ");
		String nomeMaterialA= leitor.nextLine();
		leitor.nextLine();
		System.out.println("Digite o nome do material 2: ");
		String nomeMaterialB= leitor.nextLine();
		System.out.println("Digite o nome do material do novo material criado: ");
		String nome= leitor.nextLine();
		
		
		Material resultante = null;
		Material a = null;
		Material b= null;
		for (Item item : acessarInventario()) {
			if(item instanceof Material && item.getNome().equalsIgnoreCase(nomeMaterialA)&& item.getClasse().equalsIgnoreCase("Material")) {			
				    Material a1 = (Material) item;
				   a=a1;
				}

			}
		for (Item item : acessarInventario()) {
			if(item instanceof Material && item.getNome().equalsIgnoreCase(nomeMaterialB)&& item.getClasse().equalsIgnoreCase("Material")) {			
				    Material b1 = (Material) item;
			b=b1;
		}
			if(a != null && b != null) {
				resultante= a.combinar(a, b);
				resultante.setNome(nome);
				adicionarItem(resultante);
			}
			
			else {
				System.out.println("Erro, algum material está em falta");
			}
			
		}
	}
	
	
	
		public void  criarFerramentasInventario() {
			System.out.println("Digite o nome do material que será usado: ");
			String nomeMaterialA= leitor.nextLine();
			leitor.nextLine();
			
			
			Material resultante = null;
			Material a = null;
			Material b= null;
			for (Item item : acessarInventario()) {
				if(item instanceof Material && item.getNome().equalsIgnoreCase(nomeMaterialA)&& item.getClasse().equalsIgnoreCase("Material")) {			
					    Material a1 = (Material) item;
					   a=a1;
					}

				}
			for (Item item : acessarInventario()) {
				if(item instanceof Material && item.getNome().equalsIgnoreCase("Molde de Ferramentas")&& item.getClasse().equalsIgnoreCase("Material")) {			
					    Material b1 = (Material) item;
				b=b1;
			}
			}
			if(a!= null&& b!= null) {
			resultante= criador.criarFerramenta(a, b);
			retirarItem(resultante.getNome());
			adicionarItem(resultante);
			}
			else {
				System.out.println("Erro, algum material está em falta");
			}
			
			
		}
		public void criarArmasInventario() {
			System.out.println("Digite o nome do material que será usado: ");
			String nomeMaterialA= leitor.nextLine();
			leitor.nextLine();
			
			
			Material resultante = null;
			Material a = null;
			Material b= null;
			for (Item item : acessarInventario()) {
				if(item instanceof Material && item.getNome().equalsIgnoreCase(nomeMaterialA)&& item.getClasse().equalsIgnoreCase("Material")) {			
					    Material a1 = (Material) item;
					   a=a1;
					}

				}
			for (Item item : acessarInventario()) {
				if(item instanceof Material && item.getNome().equalsIgnoreCase("Molde de Ferramentas")&& item.getClasse().equalsIgnoreCase("Material")) {			
					    Material b1 = (Material) item;
				b=b1;
			}
			}
			if(a!= null&& b!= null) {
				resultante= criador.criarArma( a, b);
						retirarItem(resultante.getNome());
				adicionarItem(resultante);
			}
			else {
					System.out.println("Erro, algum material está em falta");
				}
			}
		
		
		
	

	public void retirarQuantidade(String nome, int numero) {
		for (Item item :acessarInventario()) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				item.setQuantidade(-numero);
			}
		}
	}
	public boolean verificarSeHaArmasFerramentas(String classeArmaOuFerramenta) {
		for (Item item : acessarInventario()) {
			if(item.getClasse().equalsIgnoreCase(classeArmaOuFerramenta)) {
				return true;
			}
		}
		return false;
	}
	

}
