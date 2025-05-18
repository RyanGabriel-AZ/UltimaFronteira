package eventualidades;

import controladores.Inventario;
import itens.Ferramenta;
import itens.Item;

public class Exploracao {

	public void ganharRecurso(Ferramenta usada, String tipo) {
		for (Item inventarios : Inventario.inventario) {
			if (inventarios.getTipo().equalsIgnoreCase(tipo)) {
				inventarios.setQuantidade((int) (10 * usada.getEficiencia()));
				usada.setDurabilidade(-10);
			}
		}
	}

	public void usarFerramenta(Ferramenta usada) {
		switch (usada.getTipo()) {
		case "Picareta": {
			if (Math.random() >= 0.5) {
				ganharRecurso(usada, "Minerais");
			}
			break;
		}
		case "Machado": {
			if (Math.random() >= 0.5) {
				ganharRecurso(usada, "Madeiras");
			}
			break;
		}
		case "Foice": {
			if (Math.random() >= 0.5) {
				ganharRecurso(usada, "Ervas");
			}
			if (Math.random() >= 0.5) {
				ganharRecurso(usada, "Comida");
			}
			break;
		}
		case "Balde": {
			if (Math.random() >= 0.5) {
			}
			ganharRecurso(usada, "Liquido");
		}
			break;
		}
	}

}
