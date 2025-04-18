package controladores;
import personalidades.*;
import java.util.ArrayList;

import ambientacao.*;


public class ControladorAmbiente {
// Vou criar os objetos de ambiente aqui, atraves de metodos, e colocar eles no array  list
	
ArrayList<Ambiente> ambientes= new ArrayList<>();

public void adicionarAmbientes(Ambiente bioma) {
	ambientes.add(bioma);
}
// sorteia um numero da lista ambiente
 public int randomAmbiente(){
 int tamanho, sorteio;
 tamanho= ambientes.size();
 sorteio = (int)(Math.random()*tamanho);
 return sorteio;
 }
 // com o ambiente sorteado, nos vamos usar esse método para definir o ambiente
 public Ambiente ambienteAleatorio(int sorteio){
 Ambiente novoAmbiente;
 novoAmbiente = ambientes.get(sorteio);
 return novoAmbiente;
 }
 // Atualizamos a localização
public  void mudarAmbiente(Personagem jogador, Ambiente novoAmbiente) {	
	jogador.setLocalização(novoAmbiente);
}

public void controlarAmbiente(Personagem jogador) {
	int sorteio= randomAmbiente();
	Ambiente novAmbiente= ambienteAleatorio(sorteio);
	mudarAmbiente(jogador, novAmbiente);
}

}
