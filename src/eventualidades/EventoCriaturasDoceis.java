package eventualidades;

import java.util.ArrayList;
import java.util.Random;

import ambientacao.Ambiente;
import personalidades.Personagem;

public class EventoCriaturasDoceis {
private String nome;
private Ambiente habitat;

private ArrayList<EventoCriaturasDoceis> criaturasDoceis= new ArrayList<>();
Random roleta= new Random();
public EventoCriaturasDoceis(String nome, Ambiente habitat) {
	this.habitat=habitat;
	this.nome=nome;
}


public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Ambiente getHabitat() {
	return habitat;
}
public void setHabitat(Ambiente habitat) {
	this.habitat = habitat;
}


public ArrayList<EventoCriaturasDoceis> getCriaturasDoceis() {
	return criaturasDoceis;
}


public void adicionarCriaturasDoceis(EventoCriaturasDoceis criaturas) {
	criaturasDoceis.add(criaturas);
}
public void aparecerCriaturasDoceis(Personagem jogador) {
	for (EventoCriaturasDoceis eventoCriaturasDoceis : criaturasDoceis) {
		if(eventoCriaturasDoceis.getHabitat()==jogador.getLocalizacao()) {
			System.out.println("Parece que você achou " +eventoCriaturasDoceis.getNome()+ "\n"+ "Ele quer te dar amor e alegria");
			eventoCriaturasDoceis.getHabitat().espoliosAmbiente(jogador);
			jogador.setVida(roleta.nextInt(50) );
			jogador.setSanidade(roleta.nextInt(50) );
			break;
		}
	
	}}}
