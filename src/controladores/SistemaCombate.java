package controladores;

import itens.Arma;
import itens.Item;

public class SistemaCombate {

	public Item selecionaArma(Inventario bolsa ,String tipoAlcance) {
		for (Item arma : bolsa.acessarInventario()) {
			if(arma.getTipo().equalsIgnoreCase(tipoAlcance)) {
				return arma;
			}
		}
		return null;
	}
	
}
