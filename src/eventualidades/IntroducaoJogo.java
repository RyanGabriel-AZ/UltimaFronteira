package eventualidades;

import java.util.Scanner;

public class IntroducaoJogo {
	/*
	 * Aqui temos a estoria inicial, e a expiclação de como se jogar
	 */
	Scanner leitor= new Scanner(System.in);
	public void historiaInicial() {
		System.out.println(" Em um lugar distante, havia uma moça chamada Liriel.\n"
				+ "Ela era filha de uma mundialmente famosa modelo , e de um explorador muito habilidoso\n"
				+ "Certo dia Liriel resolvel explorar o melhor do dois mundos distintos dos seus pais\n"
				+ "Então ela partiu em aventura, com perigos constantes, moda, e sem passagem de volta para casa!");
	}
public void interacaoFalaUsuario() {
	int i=0;
	do {
System.out.println("Digite qualquer coisa para continuar");
String jargao= leitor.nextLine();
if(jargao==null) {
	i=0;
}
else {
	i=1;
}


	}while(i==0);
	
	
	
	
}
	public void menuStart() {

		System.out.println("==============================================================================\n"
				+ "=                                                                            =\n"
				+ "=                                                                            =\n"
				+ "=                           Última Fronteira                                 =\n"
				+ "=                                                                            =\n"
				+ "=                                                                            =\n"
				+ "=                                                                            =\n"
				+ "=                                                                            =\n"
				+ "=                                                                            =\n"
				+ "=                                                                            =\n"
				+ "=                                                                            =\n"
				+ "=                                                                            =\n"
			);
	}

}
