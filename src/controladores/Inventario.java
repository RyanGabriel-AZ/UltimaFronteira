package controladores;

import java.util.ArrayList;
import itens.*;
import personalidades.Personagem;

public class Inventario {

	/*
	 * verifica a carga total que o personagem pode carregar só pode adicionar se
	 * não estourar a carga limite remover itens remove peso. Quero fazer um sistema
	 * futuramente, onde quanto maior a carga, mais energia gasta. public void
	 * cargaPeso()
	 * 
	 */
	private ArrayList<Item> inventario = new ArrayList<>();

	public ArrayList<Item> acessarInventario() {
		return inventario;
	}

	public void adicionarItem(Item item) {
		inventario.add(item);
	}

	public void retirarItem(String nomeItem) {
		for (Item item : inventario) {
			if (item.getNome().equalsIgnoreCase(nomeItem)) {
				inventario.remove(item);
				break;
			}
		}
	}

	public void usarItem(String nomeItem, Personagem jogador) {

		for (Item item : inventario) {
			if (item.getNome().equalsIgnoreCase(nomeItem)) {
				item.usar(jogador);
				break;

			}

		}
	}

	public void adcionarQuantidade(Item itens, int numero) {
		for (Item item : inventario) {
			if (item.getNome().equalsIgnoreCase(itens.getNome())) {
				item.setQuantidade(numero);
			}
		}
	}

	// colocar try catch
	public void retirarQuantidade(Item itens, int numero) {
		for (Item item : inventario) {
			if (item.getNome().equalsIgnoreCase(itens.getNome())) {
				item.setQuantidade(-numero);
			}
		}
	}

	public double pesoInventario() {
		double peso = 0;
		double pesoItens;
		for (Item item : inventario) {
			pesoItens = item.getPeso();
			peso = peso + pesoItens;
		}
		return peso;
	}

	public void listarInventario(String classe) {
		for (Item item : inventario) {

			if (item.getClasse().equalsIgnoreCase(classe) && item.getQuantidade() > 0) {
				System.out.println("    " + item.getNome() + "   " + item.getQuantidade() + "   " + item.getTipo()
						+ "   " + item.getPeso() + "   " + item.getEspecifico());
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

	public void retirarQuantidade(String nome, int numero) {
		for (Item item : inventario) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				item.setQuantidade(-numero);
			}
		}
	}

}
