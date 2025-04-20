package controladores;

import java.util.ArrayList;
import itens.*;

public class Inventario {

	/*
	 * verifica a carga total que o personagem pode carregar só pode adicionar se
	 * não estourar a carga limite remover itens remove peso. Quero fazer um sistema
	 * futuramente, onde quanto maior a carga, mais energia gasta. public void
	 * cargaPeso()
	 * 
	 */
	ArrayList<Item> inventario = new ArrayList<>();

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

	public void usarItem(String nomeItem) {

		for (Item item : inventario) {
			if (item.getNome().equalsIgnoreCase(nomeItem)) {
				item.usar();
				break;

			}

		}
	}

}
