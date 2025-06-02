package itens;

import java.util.Scanner;

public class CriacaoDeItens {
	
	Scanner ler= new Scanner(System.in);
//Aqui vamos usar um while ate obtermos o tipo desejado. devemos falar das opcoes e o que elas fazem. criar um para armas tambem 
	public String pedirTipoArma() {
		String tipo;
		do {
			System.out.println("Temos 3 tipos de arma, Curto, Medio, e Longo.\n Curto tem um ótimo dano, precisão media.\n Medio tem bom dano, precisão normal.\n Longo tem dano normal, e precisão perfeita.  ");
			System.out.println("Digite o tipo de arma: ");
			tipo= ler.nextLine();
			if(tipo.equalsIgnoreCase("Curto")|| tipo.equalsIgnoreCase("Medio") || tipo.equalsIgnoreCase("Longo")) {
				
			}
			
			else {
				tipo=null;
			}
			
			
		}while(tipo==null);
		return tipo;
		
	}
	public String pedirTipoFerramenta() {
		String tipo;
		do {
			System.out.println("Temos 4 tipos de Ferramentas: \n Picareta, ótima para encontrar minerais. \n Machado, Ótimo para obter madeiras. \n Foice ótimo para conseguir ervas e comida"
					+ "\n Balde ótimo para conseguir líquidos.");
			System.out.println("Digite o tipo de ferrsamenta que você quer cria: ");
			tipo= ler.nextLine();
		if(tipo.equalsIgnoreCase("Balde")||tipo.equalsIgnoreCase("Picareta")||tipo.equalsIgnoreCase("Machado")|| tipo.equalsIgnoreCase("Foice")) {
			  
		}
		else {
			tipo=null;
		}
		
		}while(tipo==null);
		
		return tipo;
		
		
	}
	
	
	public Ferramenta criarFerramenta( Material a, Material b) {
		if(a.getNome().equalsIgnoreCase("Molde de Ferramentas") || b.getNome().equalsIgnoreCase("Molde de Ferramentas") ) {
		String tipo= pedirTipoFerramenta();
			double resistencia= a.getResistencia() + b.getResistencia();
		double durabilidade= resistencia*2;
		double eficiencia= durabilidade/100;
		int quantidade= 1;
		String nome = null;
		double peso = (a.getPeso() + b.getPeso()) * 0.75;
		switch(tipo) {
		case "Balde":
			nome = "Balde";
		case "Picareta":
			nome = "Furadeira automatica";
		case "Foice":
			nome = "Funcionarios CLT";
		case "Machado":
			nome= "Moto Serra Eletrica";
		}
		return new Ferramenta(nome, peso, durabilidade, quantidade, resistencia, eficiencia, tipo , "Ferramentas");}
		return null;
	}
	public Arma  criarArma(Material a, Material b) {
		if(a.getNome().equalsIgnoreCase("Molde de Armas") || b.getNome().equalsIgnoreCase("Molde de Armas")) {
		String tipo= pedirTipoArma();
			double resistencia= a.getResistencia() + b.getResistencia();
			double durabilidade= resistencia*2;
			double poder= 0;
			int quantidade= 1;
			double precisao=0;
			double peso = (a.getPeso() + b.getPeso()) * 0.75;
			String nome1= null;
			switch(tipo) {
			case "Curto":
			{ nome1= "Saltos Altos";
			poder= (durabilidade/10)*1.7;
			precisao=0.6;
			}
			case "Medio": {
				nome1= "Chicote";
				poder= (durabilidade/10)*1.4;
				precisao= 0.8;
			}
			case "Longo": {
				nome1= "Batons de Precisao";
				poder= (durabilidade/10)*1.1;
				precisao= 1;
			}	
			}
			return new Arma(nome1, peso, durabilidade, quantidade, resistencia, poder, precisao,  tipo, "Armas");}
		return null;
		}
		
}
