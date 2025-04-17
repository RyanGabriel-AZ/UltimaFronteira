package controladores;

import java.util.ArrayList;

import ambientacao.*;


public class ControladorAmbiente {
// Vou criar os objetos de ambiente aqui, atraves de metodos, e colocar eles no array  list
	
ArrayList<Ambiente> ambientes= new ArrayList<>();

public void adicionarAmbientes(Ambiente bioma) {
	ambientes.add(bioma);
}
/*
 public int randomAmbiente(){
 int a, b;
 a= ambiente.length;
 b= sortear(a)
 return b;
 }
 public Ambiente ambienteAleatorio(){
 int a;
 a= randomAmbiente();
 return ambiente(a);    será o nosso novo ambiente
 }
 
public  void mudarAmbiente(Personagem jogador, Ambiente novoAmbiente) {
	
	jogador.setLocalização(novoAmbiente);
}
*/
}
