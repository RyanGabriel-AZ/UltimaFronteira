package ambientacao;

import java.util.ArrayList;

import controladores.Inventario;
import itens.Item;
import personalidades.Personagem;

public class Floresta extends Ambiente {
 public Floresta(String nome, String descricao, double dificuldadeDeExploração, double probabilidadeDeEventos,
			String condicoesClimaticasPredominantes, Inventario inventario, double vegetacaoDensa, double faunaAbundante, double climaUmido) {
		super(nome, descricao, dificuldadeDeExploração, probabilidadeDeEventos, condicoesClimaticasPredominantes, inventario);
		this.climaUmido=climaUmido;
		this.faunaAbundante=faunaAbundante;
		this.vegetacaoDensa=vegetacaoDensa;
		// TODO Auto-generated constructor stub
	}
private double vegetacaoDensa;
 private double faunaAbundante;
 private double climaUmido;
 private ArrayList<Item> itensFloresta= new ArrayList<>();
 
public double getVegetacaoDensa() {
	return vegetacaoDensa;
}
public void setVegetacaoDensa(double vegetacaoDensa) {
	this.vegetacaoDensa = vegetacaoDensa;
}
public double getFaunaAbundante() {
	return faunaAbundante;
}
public void setFaunaAbundante(double faunaAbundante) {
	this.faunaAbundante = faunaAbundante;
}
public double getClimaUmido() {
	return climaUmido;
}
public void setClimaUmido(double climaUmido) {
	this.climaUmido = climaUmido;
}
@Override
public void Explorar(Personagem jogador) {
	System.out.println("Florestas, florestas... As melhores peles de animais, vem daqui, ótimo para criar roupas. ");
	naturezaAmbiente(jogador);
	espoliosAmbiente(jogador);
}
@Override
public void naturezaAmbiente(Personagem jogador) {
	System.out.println("Olha, há frutas logo ali, talvez possa comer elas!");
	double ajudarPersonagem = getClimaUmido()*10+getVegetacaoDensa()*10;
	double lascarPersonagem= -1*(getFaunaAbundante()*10+ getClimaUmido()*10)*jogador.getResistenciaAoAmbiente();
	jogador.setSede(ajudarPersonagem);
	jogador.setFome(ajudarPersonagem);
	jogador.setEnergia(lascarPersonagem);
	jogador.setSanidade(lascarPersonagem);
	
}
@Override
public void adicionarItensAbiente(Item Item) {
	itensFloresta.add(Item);
	
}
@Override
public ArrayList<Item> itensDoAmbiente() {
	// TODO Auto-generated method stub
	return itensFloresta;
}

 
 /* o explorar aqui qero que seja o seguinte.
  * sede. 0.75
  * fome 0.75
  * sanidade cai mais devido aos perigos eminentes 
  * taxa de minerios baixa
  * mensagens "a floresta é linda, mas parece perigosa"
  * taxa de itens é maior
  * 
  */
 
}
