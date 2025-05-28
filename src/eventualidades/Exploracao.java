package eventualidades;

import controladores.Inventario;
import itens.Ferramenta;
import itens.Item;
public class Exploracao {
private Inventario inventario;

public void setInventarioExploraçao(Inventario inventario) {
	this.inventario = inventario;
}
	public void ganharRecurso(Ferramenta usada, String tipo) {
		for (Item inventarios : inventario.acessarInventario()) {
			if (inventarios.getTipo().equalsIgnoreCase(tipo)) {
				inventarios.setQuantidade((int) (10 * usada.getEficiencia()));
				usada.setDurabilidade(-10);
			}
		}
	}

	public void usarFerramenta(Ferramenta usada) {
		switch (usada.getTipo()) {
		case "Picareta": {
			if (Math.random() >= 0.1) {
				ganharRecurso(usada, "Minerais");
			}
			break;
		}
		case "Machado": {
			if (Math.random() >= 0.1) {
				ganharRecurso(usada, "Madeiras");
			}
			break;
		}
		case "Foice": {
			if (Math.random() >= 0.1) {
				ganharRecurso(usada, "Ervas");
			}
			if (Math.random() >= 0.1) {
				ganharRecurso(usada, "Comida");
			}
			break;
		}
		case "Balde": {
			if (Math.random() >= 0.1) {
			}
			ganharRecurso(usada, "Liquido");
		}
			break;
		default:
			
		}
		
			
	}
	//Metodo mais importante daqui.
	public void explorar() {
		usarFerramenta(chamarFerramenta("Balde"));
		usarFerramenta(chamarFerramenta("Picareta"));
		usarFerramenta(chamarFerramenta("Foice"));
		usarFerramenta(chamarFerramenta("Machado"));
	}
	
	
public Ferramenta chamarFerramenta(String tipo) {
	Ferramenta a;
	for (Item item : inventario.acessarInventario()) {
		if(item.getTipo().equalsIgnoreCase(tipo) && item instanceof Ferramenta) {
			a=(Ferramenta) item;
			return a;
		}
	}
	return null;
	
	
}
}
