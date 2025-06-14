package execucoes;

import java.util.Scanner;

import ambientacao.Deserto;
import ambientacao.Floresta;
import ambientacao.LagoRio;
import ambientacao.Ruinas;
import ambientacao.Savana;
import controladores.ControladorAmbiente;
import controladores.ControladorCriaturas;
import controladores.ControladorEvento;
import controladores.ControlePersonagem;
import controladores.Inventario;
import controladores.SistemaCombate;
import criaturas.CriaturasHostis;
import eventualidades.EventoCriaturasDoceis;
import itens.Agua;
import itens.Alimentos;
import itens.Arma;
import itens.Ferramenta;
import itens.Material;
import itens.Medicamentos;
import personalidades.AtiradoraDeElite;
import personalidades.Coringa;
import personalidades.FilhinhaDoPapai;
import personalidades.Maromba;
import personalidades.Normal;
import personalidades.Personagem;
import personalidades.Sobrevivente;
import personalidades.Vampira;

public class JogoEstrutura {
	Scanner leitor = new Scanner(System.in);

	/*
	 * Controladores
	 */
	ControladorAmbiente controleAmbiente = new ControladorAmbiente();
	ControladorCriaturas controleCriaturas = new ControladorCriaturas();
	ControladorEvento controleEventos = new ControladorEvento();
	Inventario inventario = new Inventario();
	SistemaCombate sistemaCombate = new SistemaCombate();
	ControlePersonagem controladorPersonagem = new ControlePersonagem();

	/*
	 * Objetos Ambiente
	 */

	Deserto deserto = new Deserto("Deserto", "Um lugar árido e perigoso, a morte está à espreita!\nAqui podemos encontrar diversas ciraturas perigosas. ", 20, 70, "sol",
			inventario, 0.9, 0.9, 0.9, 0.9);
	Savana savana = new Savana("Savana", "Um lugar seco, vegetação pequena, mas fauna vasta. Leões, Hipopótamos entre outros animais mansos, que lugar TRANQUILO, SEGURO e AGRDÁVEL. O sol está me torrando!", 50, 70, "Sol",
			inventario, 0.7, 0.7, 0.7);
	LagoRio lago = new LagoRio("Lago", "Um lugar lindo, cheio de água, e lama. Ótimo para nadar com jacarés, eles são DÓCEIS", 80, 70, "Sol", inventario, 0.9, 0.8,
			1);
	Floresta floresta = new Floresta("Floresta", "Matos sem fim, um ótimo lugar para fazer chá. Uma madereira, seria ótima para negócios.", 90, 90, "Sol",
			inventario, 0.9, 0.9, 0.8);
	Ruinas ruina = new Ruinas("Ruinas", "Estruturas antigas, alguém já viveu aqui. \"Olha um mendigo \" ", 70, 80, "Nenhuma", inventario, 0.8,
			0.6, true);

	/*
	 * /* Personagem classees
	 *//*
		 * /* Personagem classees
		 */
	AtiradoraDeElite atiradoraDeElite = new AtiradoraDeElite("Liriel", 0, 0, 0, 0, 0, 0, "ATE", inventario, floresta);
	Coringa coringa = new Coringa("Liriel", 0, 0, 0, 0, 0, 0, "Coringa", inventario, floresta);
	FilhinhaDoPapai fdp = new FilhinhaDoPapai("Liriel", 0, 0, 0, 0, 0, 0, "FDP", inventario, floresta);
	Maromba maromba = new Maromba("Liriel", 0, 0, 0, 0, 0, 0, "Maromba", inventario, floresta);
	Sobrevivente sobrevivente = new Sobrevivente("Liriel", 0, 0, 0, 0, 0, 0, "Sobrevivente", inventario, floresta);
	Normal normal = new Normal("Liriel", 0, 0, 0, 0, 0, 0, "Normal", inventario, floresta);
	Vampira vampira = new Vampira("Liriel", 0, 0, 0, 0, 0, 0, "Vampira", inventario, floresta);
	/*
	 * Criatura Doceis
	 */
	EventoCriaturasDoceis lebre = new EventoCriaturasDoceis("Lebre", floresta);
	EventoCriaturasDoceis jararaca = new EventoCriaturasDoceis("Jararáca", deserto);
	EventoCriaturasDoceis golfinho = new EventoCriaturasDoceis("Golfinho", lago);
	EventoCriaturasDoceis pardal = new EventoCriaturasDoceis("Pardal", savana);
	EventoCriaturasDoceis sogra = new EventoCriaturasDoceis("Sogra", ruina);
	EventoCriaturasDoceis coelho = new EventoCriaturasDoceis("coelho", floresta);
	EventoCriaturasDoceis capivara = new EventoCriaturasDoceis("Capivara", lago);
	EventoCriaturasDoceis girafa = new EventoCriaturasDoceis("Girafa", savana);
	EventoCriaturasDoceis lagartixa = new EventoCriaturasDoceis("Lagartixa", deserto);
	EventoCriaturasDoceis tatu = new EventoCriaturasDoceis("Tatu", ruina);

	/*
	 * criaturas
	 */
	// deserto
	CriaturasHostis cascavel = new CriaturasHostis("Cascavél", 50, 1, "Venenosa! Parece minha prima", deserto, 40, "Veneno", 1, "Letal");
	CriaturasHostis escorpião = new CriaturasHostis("Escorpião", 25, 1, "Pequeno, mas letal", deserto, 30, "Veneno",
			0.9, "Normal");
	CriaturasHostis carcara = new CriaturasHostis("Carcará", 60, 1, "Uma ave de rapina, de respeito", deserto, 70,
			"Sangramento", 0.5, "Normal");
	CriaturasHostis abutre = new CriaturasHostis("Abutre", 70, 3, "Comem carcaças", deserto, 25, "Veneno", 0.4,
			"Normal");
	CriaturasHostis miragem = new CriaturasHostis("Miragem", 80, 1, "Isso é real?!", deserto, 70, "", 0, "Letal");
	CriaturasHostis lagarto = new CriaturasHostis("Lagarto", 30, 1, "Pequenos e rápidos", deserto, 20, "", 0,
			"Muito fraco");
	// savana
	CriaturasHostis dragaoDeKomodo = new CriaturasHostis("Dragão-de -", 100, 1, "Grande e venenoso, melhor ficar longe",
			savana, 70, "Hemorragia", 0.8, "Letal");
	CriaturasHostis leao = new CriaturasHostis("Leão", 70, 2, "Sempre caçando em bando", savana, 60, "Hemorragia", 0.9,
			"Letal");
	CriaturasHostis hiena = new CriaturasHostis("Hiena", 40, 6, "Elas vão rir de você", savana, 40, "Sangramento", 0.6,
			"Normal");
	CriaturasHostis bufalo = new CriaturasHostis("Búfalo", 100, 3, "Resistentes, andam em bando", savana, 50, "", 0,
			"Normal");
	CriaturasHostis hipopotamo = new CriaturasHostis("Hipopótamo", 100, 1, "Fofo, mas letal", savana, 70, "Hemorragia",
			0.9, "Letal");
	CriaturasHostis zebra = new CriaturasHostis("Zebra", 40, 1, "Preto com branco, ou branco com preto?", savana, 20,
			"", 0, "Muito fraco");
	// lago
	CriaturasHostis jacare = new CriaturasHostis("Jacaré", 100, 2, "Olha a boquinha dele", lago, 70, "Hemorragia", 1,
			"Letal");
	CriaturasHostis pato = new CriaturasHostis("Pato", 30, 1, "Ele está correndo atrás de mim!", lago, 20, "", 0,
			"Muito fraco");
	CriaturasHostis piranha = new CriaturasHostis("Piranha", 20, 10, "Ela quer me morder! ", lago, 20, "Hemorragia",
			0.5, "Normal");
	CriaturasHostis mosquito = new CriaturasHostis("Mosquito da dengue", 10, 3, "Pequenos, mas letais", lago, 40,
			"Sangramento", 0.8, "Letal");
	CriaturasHostis lontra = new CriaturasHostis("Lontra", 30, 2, "Elas são muito lindas", lago, 20, "", 0,
			"Muito fraco");
	CriaturasHostis sereia = new CriaturasHostis("Sereia", 50, 1, "Amada, você nunca vai ser mais linda do que eu!",
			lago, 50, "", 0, "Normal");
	CriaturasHostis sapo = new CriaturasHostis("Sapo-Cururu", 70, 1, "Como alguém pode beijar uma coisa dessas! Eca!",
			lago, 30, "Veneno", 0.7, "Normal");
	// floresta
	CriaturasHostis cobra = new CriaturasHostis("Cobrar", 50, 1, "Venenosa!", floresta, 40, "Veneno", 1, "Letal");
	CriaturasHostis urso = new CriaturasHostis("Urso", 100, 1, "Ele daria um bom casaco", floresta, 70, "Hemorragia", 1,
			"Letal");
	CriaturasHostis lobo = new CriaturasHostis("Lobo", 50, 3, "Matiha de casacos, quero dizer lobos", floresta, 50,
			"Sangramento", 0.6, "Normal");
	CriaturasHostis raposa = new CriaturasHostis("Raposa", 60, 1, "Ela pegou meu caviar!", floresta, 30, "", 0,
			"Normal");
	CriaturasHostis pantera = new CriaturasHostis("Pantera", 60, 1, "É só um gatinho grande", floresta, 70,
			"Hemorragia", 0.5, "Letal");
	CriaturasHostis barata = new CriaturasHostis("Barata", 5, 25, "Baratas, que nojo!", floresta, 5, "Veneno", 0.1,
			"Fraco");
	// Ruinas
	CriaturasHostis homem = new CriaturasHostis("Homem", 70, 1, "Eu só queria vender artes na praia!", ruina, 40, "", 0,
			"Normal");
	CriaturasHostis morcego = new CriaturasHostis("Morcego", 20, 1, "Ratos com asas!", ruina, 10, "", 0, "Normal");
	CriaturasHostis mumia = new CriaturasHostis("Múmia", 200, 1, "Faixas não estão  na moda, querida.", ruina, 60, "",
			0, "Normal");
	CriaturasHostis escaravelho = new CriaturasHostis("Escaravelho", 40, 4,
			"Minha amiga Suzie, tem uma dieta baseada em você, ótima fonte de proteinas!", ruina, 40, "Sangramento",
			0.4, "Fraco");
	CriaturasHostis guardiao = new CriaturasHostis("Guardião", 150, 1, "Você passou algum perfume francês?", ruina, 70,
			"Hemorragia", 0.6, "Letal");

	// itens do jogo
	// Agua
	Agua aguaLimpa = new Agua("Água", 0.1, 1, 0.9, 100, 3, "Liquido", "Agua");
	Agua aguaPodre = new Agua("Água", 0.3, 1, 0.6, 50, 0, "Liquido", "Agua");
	Agua aguaNeutra = new Agua("Água", 0.1, 1, 0.7, 70, 0, "Liquido", "Agua");
	Agua aguaPerfeita = new Agua("Água", 0.1, 1, 1, 100, 0, "Liquido", "Agua");
	Agua aguaHorrivel = new Agua("Água", 1, 1, 0.1, 10, 0, "Liquido", "Agua");
	// Alimentos
	Alimentos pao = new Alimentos("Pão", 1, 1, 50, 0.7, 4, "Comida", "Alimentos");
	Alimentos caviar = new Alimentos("Caviar", 0.4, 1, 80, 0.7, 0, "Comida", "Alimentos");
	Alimentos lagosta = new Alimentos("Lagosta", 2, 1, 100, 1, 0, "Comida", "Alimentos");
	Alimentos vieiras = new Alimentos("Vieiras", 0.3, 1, 30, 0.7, 0, "Comida", "Alimentos");
	Alimentos foieGras = new Alimentos("Foie gras", 2, 1, 50, 0.6, 0, "Comida", "Alimentos");
	Alimentos baiacu = new Alimentos("Baiacu", 0.7, 1, 40, 0.2, 0, "Comida", "Alimentos");
	Alimentos cordeiro = new Alimentos("Cordeiro nobre", 3, 1, 80, 0.8, 0, "Comida", "Alimentos");
	Alimentos cobraAssada = new Alimentos("Cobra assada", 2, 1, 200, -0.2, 0, "Comida", "Alimentos");
	Alimentos amora = new Alimentos("Amoras", 0.1, 1, 20, 0.8, 0, "Comida", "Alimentos");
	Alimentos manga = new Alimentos("Manga", 0.3, 1, 40, 0.8, 0, "Comida", "Alimentos");
	Alimentos cerebroDeMacaco = new Alimentos("Cérebro de macaco", 2, 1, 100, 0.8, 0, "Comida", "Alimentos");
	// Material
	// Minerais
	Material pedra = new Material("Pedra", 2, 1, 0, 200, "Minerais", "Material");
	Material ferro = new Material("Ferro", 5, 1, 1, 500, "Minerais", "Material");
	Material carvao = new Material("Carvão", 3, 1, 0, 300, "Minerais", "Material");
	Material chumbo = new Material("Chumbo", 6, 1, 0, 400, "Minerais", "Material");
	// Madeiras
	Material madeiraBoa = new Material("Madeira boa", 3, 1, 0, 400, "Madeiras", "Material");
	Material madeiraRuim = new Material("Madeira ruim", 5, 1, 0, 100, "Madeiras", "Material");
	Material madeira = new Material("Madeira ", 4, 1, 0, 200, "Madeiras", "Material");
//Ervas
	Medicamentos capim = new Medicamentos("Capim Santo", 0.1, 1, "Analgesico", 0.3, 3, "Ervas", "Medicamentos");
	Medicamentos dipirona = new Medicamentos("Dipirona", 1, 1, "Milagroso", 0.6, 0, "Ervas", "Medicamentos");
	Medicamentos cidreira = new Medicamentos("Erva cidreira", 0.2, 1, "Analgesico", 0.5, 0, "Ervas", "Medicamentos");
	Medicamentos aroeira = new Medicamentos("Aroeira", 0.1, 1, "Milagroso", 0.7, 0, "Ervas", "Medicamentos");
	Medicamentos alho = new Medicamentos("Alho", 0.3, 1, "Milagroso", 0.4, 0, "Ervas", "Medicamentos");
	Medicamentos gengibre = new Medicamentos("Gengibre", 0.2, 1, "CuraTudo", 1, 0, "Ervas", "Medicamentos");
//Itens raros, só podem ser obtidos explorando ambientes.
	Alimentos picanha = new Alimentos("Picanha Argentina", 1, 1, 100, 1, 0, "Raro", "Alimentos");
	Medicamentos misturaErvas = new Medicamentos("Mistura de ervas", 1, 1, "Milagroso", 1, 0, "Raro", "Medicamentos");
	Agua aguaDivina = new Agua("Água divina", 0.1, 1, 1, 300, 0, "Raro", "Agua");
//Materiais raros e necessario para fazer armas e espada;
	Material moldeArma = new Material("Molde de armas", 10, 1, 1, 500, "Raro", "Material");
	Material moldeFerramenta = new Material("Molde de ferramentas", 10, 1, 1, 500, "Raro", "Material");
	Material combinado= new Material("Material combinado", 0, 1, 1, 0, "Criado", "Material");
// Armas
	Arma arma1 = new Arma("Saltos Altos", 5, 200, 1, 75, 100, 0.75, "Curto", "Arma");
	Arma arma2 = new Arma("Chicote", 5, 200, 1, 200, 50, 0.8, "Medio", "Arma");
	Arma arma3 = new Arma("Batons de precisao", 2, 200, 1, 200, 25, 1, "Longo", "Arma");

// Ferramentas
	Ferramenta balde = new Ferramenta("Balde", 20, 100, 1, 100, 1, "Balde", "Ferramenta");
	Ferramenta picareta = new Ferramenta("Furadeira automatica", 30, 50, 1, 200, 1, "Picareta", "Ferramenta");
	Ferramenta foice = new Ferramenta("Funcionarios CLT", 100, 50, 1, 200, 1, "Foice", "Ferramenta");
	Ferramenta machado = new Ferramenta("Moto Serra Eletrica", 200, 200, 1, 100, 1, "Machado", "Ferramenta");

	public void adcionarElementosJogo() {
		//
		controleAmbiente.adicionarAmbientes(deserto);
		controleAmbiente.adicionarAmbientes(floresta);
		controleAmbiente.adicionarAmbientes(lago);
		controleAmbiente.adicionarAmbientes(ruina);
		controleAmbiente.adicionarAmbientes(savana);
//
		controleCriaturas.adicionarCriaturas(abutre);
		controleCriaturas.adicionarCriaturas(barata);
		controleCriaturas.adicionarCriaturas(bufalo);
		controleCriaturas.adicionarCriaturas(carcara);
		controleCriaturas.adicionarCriaturas(cascavel);
		controleCriaturas.adicionarCriaturas(cobra);
		controleCriaturas.adicionarCriaturas(dragaoDeKomodo);
		controleCriaturas.adicionarCriaturas(escaravelho);
		controleCriaturas.adicionarCriaturas(escorpião);
		controleCriaturas.adicionarCriaturas(guardiao);
		controleCriaturas.adicionarCriaturas(hiena);
		controleCriaturas.adicionarCriaturas(hipopotamo);
		controleCriaturas.adicionarCriaturas(homem);
		controleCriaturas.adicionarCriaturas(jacare);
		controleCriaturas.adicionarCriaturas(lagarto);
		controleCriaturas.adicionarCriaturas(leao);
		controleCriaturas.adicionarCriaturas(lobo);
		controleCriaturas.adicionarCriaturas(lontra);
		controleCriaturas.adicionarCriaturas(miragem);
		controleCriaturas.adicionarCriaturas(morcego);
		controleCriaturas.adicionarCriaturas(mosquito);
		controleCriaturas.adicionarCriaturas(mumia);
		controleCriaturas.adicionarCriaturas(pantera);
		controleCriaturas.adicionarCriaturas(pato);
		controleCriaturas.adicionarCriaturas(piranha);
		controleCriaturas.adicionarCriaturas(raposa);
		controleCriaturas.adicionarCriaturas(sapo);
		controleCriaturas.adicionarCriaturas(sereia);
		controleCriaturas.adicionarCriaturas(urso);
		controleCriaturas.adicionarCriaturas(zebra);
//
		deserto.adicionarItensAbiente(aguaDivina);
		deserto.adicionarItensAbiente(moldeFerramenta);
		deserto.adicionarItensAbiente(moldeArma);
		deserto.adicionarItensAbiente(picanha);
		deserto.adicionarItensAbiente(aguaPerfeita);
		deserto.adicionarItensAbiente(ferro);
		deserto.adicionarItensAbiente(misturaErvas);
		deserto.adicionarItensAbiente(pedra);
		deserto.adicionarItensAbiente(alho);
		deserto.adicionarItensAbiente(carvao);
		deserto.adicionarItensAbiente(cobraAssada);
		deserto.adicionarItensAbiente(madeiraBoa);
		deserto.adicionarItensAbiente(cordeiro);
		//
		floresta.adicionarItensAbiente(aguaHorrivel);
		floresta.adicionarItensAbiente(aguaNeutra);
		floresta.adicionarItensAbiente(alho);
		floresta.adicionarItensAbiente(amora);
		floresta.adicionarItensAbiente(aroeira);
		floresta.adicionarItensAbiente(capim);
		floresta.adicionarItensAbiente(carvao);
		floresta.adicionarItensAbiente(cerebroDeMacaco);
		floresta.adicionarItensAbiente(cidreira);
		floresta.adicionarItensAbiente(dipirona);
		floresta.adicionarItensAbiente(madeira);
		floresta.adicionarItensAbiente(madeiraBoa);
		floresta.adicionarItensAbiente(manga);
		//
		lago.adicionarItensAbiente(aguaDivina);
		lago.adicionarItensAbiente(aguaHorrivel);
		lago.adicionarItensAbiente(aguaLimpa);
		lago.adicionarItensAbiente(aguaNeutra);
		lago.adicionarItensAbiente(aguaPodre);
		lago.adicionarItensAbiente(aguaPerfeita);
		lago.adicionarItensAbiente(baiacu);
		lago.adicionarItensAbiente(caviar);
		lago.adicionarItensAbiente(dipirona);
		lago.adicionarItensAbiente(lagosta);
		lago.adicionarItensAbiente(vieiras);
		lago.adicionarItensAbiente(capim);
		//
		ruina.adicionarItensAbiente(carvao);
		ruina.adicionarItensAbiente(chumbo);
		ruina.adicionarItensAbiente(ferro);
		ruina.adicionarItensAbiente(moldeArma);
		ruina.adicionarItensAbiente(madeiraRuim);
		//
		savana.adicionarItensAbiente(aguaNeutra);
		savana.adicionarItensAbiente(cerebroDeMacaco);
		savana.adicionarItensAbiente(cobraAssada);
		savana.adicionarItensAbiente(cordeiro);
		savana.adicionarItensAbiente(foieGras);
		savana.adicionarItensAbiente(madeiraBoa);
		savana.adicionarItensAbiente(moldeFerramenta);
		savana.adicionarItensAbiente(carvao);
		//
		inventario.adicionarItem(aguaDivina);
		inventario.adicionarItem(aguaHorrivel);
		inventario.adicionarItem(aguaLimpa);
		inventario.adicionarItem(aguaPerfeita);
		inventario.adicionarItem(aguaNeutra);
		inventario.adicionarItem(aguaPodre);
		inventario.adicionarItem(alho);
		inventario.adicionarItem(amora);
		inventario.adicionarItem(aroeira);
		inventario.adicionarItem(baiacu);
		inventario.adicionarItem(capim);
		inventario.adicionarItem(carvao);
		inventario.adicionarItem(caviar);
		inventario.adicionarItem(cerebroDeMacaco);
		inventario.adicionarItem(chumbo);
		inventario.adicionarItem(cidreira);
		inventario.adicionarItem(cobraAssada);
		inventario.adicionarItem(cordeiro);
		inventario.adicionarItem(dipirona);
		inventario.adicionarItem(ferro);
		inventario.adicionarItem(foieGras);
		inventario.adicionarItem(gengibre);
		inventario.adicionarItem(lagosta);
		inventario.adicionarItem(madeira);
		inventario.adicionarItem(madeiraBoa);
		inventario.adicionarItem(madeiraRuim);
		inventario.adicionarItem(manga);
		inventario.adicionarItem(misturaErvas);
		inventario.adicionarItem(moldeArma);
		inventario.adicionarItem(moldeFerramenta);
		inventario.adicionarItem(pao);
		inventario.adicionarItem(pedra);
		inventario.adicionarItem(picanha);
		inventario.adicionarItem(vieiras);
		inventario.adicionarItem(arma1);
		inventario.adicionarItem(arma2);
		inventario.adicionarItem(arma3);
		inventario.adicionarItem(balde);
		inventario.adicionarItem(machado);
		inventario.adicionarItem(picareta);
		inventario.adicionarItem(foice);
		inventario.adicionarItem(combinado);

		controladorPersonagem.adcionarClassesPersonagem(atiradoraDeElite);
		controladorPersonagem.adcionarClassesPersonagem(coringa);
		controladorPersonagem.adcionarClassesPersonagem(fdp);
		controladorPersonagem.adcionarClassesPersonagem(maromba);
		controladorPersonagem.adcionarClassesPersonagem(normal);
		controladorPersonagem.adcionarClassesPersonagem(sobrevivente);
		controladorPersonagem.adcionarClassesPersonagem(vampira);
		//
		controleEventos.adcionarFalas("Onde está meu repelente? Os msoquitos estão me comendo viva ");
		controleEventos.adicionarFalas("TÔ FICANDO DOIDONA!", "Você está realmente lendo minhas mensagens?", "Meus desenhos são divinos!");
		controleEventos.adicionarFalas("Quer falar comigo? beije meus pés", "Você vai me deixar viva?", "Gosto de beber água importada, ela tem gosto de água!");
		controleEventos.adicionarFalas("Você tem senso de moda?", "Isso é moda?!", "Papai me ensinou a tirar carne nobre dos animais silvestres!");
		controleEventos.adicionarFalas("Minha bolsa de grife é linda, não é?", "Sou só eu, ou alguém mais acha esse jogo desbalanceado?", "Animais são ótimos para fazer roupas, elas ficam quantinhas!");
		//
		controleEventos.adicionarCriaturasDoceis(pardal);
		controleEventos.adicionarCriaturasDoceis(tatu);
		controleEventos.adicionarCriaturasDoceis(capivara);
		controleEventos.adicionarCriaturasDoceis(coelho);
		controleEventos.adicionarCriaturasDoceis(girafa);
		controleEventos.adicionarCriaturasDoceis(golfinho);
		controleEventos.adicionarCriaturasDoceis(jararaca);
		controleEventos.adicionarCriaturasDoceis(lagartixa);
		controleEventos.adicionarCriaturasDoceis(lebre);
		controleEventos.adicionarCriaturasDoceis(sogra);
		// hashMaps

		controleAmbiente.adcionarAmbienteAoHashMap(deserto);
		controleAmbiente.adcionarAmbienteAoHashMap(floresta);
		controleAmbiente.adcionarAmbienteAoHashMap(lago);
		controleAmbiente.adcionarAmbienteAoHashMap(ruina);
		controleAmbiente.adcionarAmbienteAoHashMap(savana);

	}

//funcao teste
	public void testePersonagemInventario() {

	}

//Implem
	public void inicioJogo() {
		adcionarElementosJogo();
		controleEventos.introducaoJogoTexto();
		loopJogo(controladorPersonagem.escolherclassejogador());

	}

	public boolean bloquearLoop(Personagem jogador) {
		if (jogador.getVida() > 0 && jogador.getFome() > 0 && jogador.getEnergia() > 0 && jogador.getSanidade() > 0
				&& jogador.getSede() > 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean podeExplorar(Inventario inventario) {
		if (inventario.verificarSeHaArmasFerramentas("Ferramenta") ) {

			return true;
		}
		return false;
	}

	public String perguntarCaminho() {
		String resposta = null;
		int i = 0;
		do {
			System.out.println(
					"\nDigite 'E' para explorar com as suas ferramentas\n Digite C para caçar tesouros do ambiente:  ");
			resposta = leitor.nextLine();
			if (resposta.equalsIgnoreCase("E") || resposta.equalsIgnoreCase("C")) {
				i = 1;
			}
		} while (i == 0);
		return resposta;

	}

	public void caminhoDoTurno(Personagem jogador) {
		if (inventario.verificarSeHaArmasFerramentas("Ferramenta")) {
			System.out.println(
					"\nTemos uma difícil decisão para tomar!\n Exploramos com as nossas ferramentas, ou buscamos tesouros na natureza.");
			String letra = perguntarCaminho();
			switch (letra.toUpperCase()) {
			case "E": {
				System.out.println("\n Eu vou eu vou, lascar as juntas eu vou...");
				controleEventos.podeExplorar(inventario);
				controleAmbiente.forcasDaNaturezaAmbiente(jogador);
				break;
			}
			case "C":
				System.out.println("Ai! meu Deus do céu, úrtigas!");
				controleAmbiente.espolios(jogador);
				controleAmbiente.forcasDaNaturezaAmbiente(jogador);
			}
		} else {

			System.out.println("\nVamos procurar tesouros no ambiente");
			controleAmbiente.espolios(jogador);
			controleAmbiente.forcasDaNaturezaAmbiente(jogador);
		}
	}

	public void deveriamosMudarOAmbiente(Personagem jogador) {
		
		System.out.println("=====Mudando de Ambiente=====");
		System.out.println("\n Estou ficando Enjoada desse ambiente! Vamos mudar de ambiente!");
		String direcao = null;
		System.out.println(
				"\nPara onde deveriamos ir? Norte, Sul, Leste ou Oeste?\n Digite 'N' ou 'S' ou 'L' , 'O', para mudar de ambiente!");
		direcao = leitor.nextLine();
		if (direcao.equalsIgnoreCase("N") || direcao.equalsIgnoreCase("S") || direcao.equalsIgnoreCase("L")
				|| direcao.equalsIgnoreCase("O")) {
			controleAmbiente.controlarAmbiente(jogador);
			System.out.println("======"+ jogador.getLocalizacao().getNome()+ "======");
			System.out.println("\n Oba! um novo ambiente, estamos no(a): " + jogador.getLocalizacao().getNome()
					+ " \n Deixe-me ver o que papai anotou para mim sobre este ambiente. " + "Bom aqui diz: "
					+ jogador.getLocalizacao().getDescricao());

		} else {
			System.out.println("======"+ jogador.getLocalizacao().getNome()+ "======");
			System.out.println("\nQue pena, queria tanto mudar de ambiente :( . Vamos continuar então!");
		}

	}

	public void loopJogo(Personagem jogador) {
		int bloquearLoop = 1;
		int loopMaximo = 16;
		System.out.println("======"+jogador.getLocalizacao().getNome()+"======");
		System.out.println("Melhor tomar cuidado, minha jornada será difícil.");
		while (bloquearLoop < loopMaximo) {
			System.out.println("\nVocê está na rodada: " + bloquearLoop);
			inventario.inventarioFuncional(jogador);
			caminhoDoTurno(jogador);
			if (bloquearLoop(jogador)) {
				break;
			}
			controleEventos.eventosAleatoriosJogo(jogador, controleCriaturas, inventario);
			if (bloquearLoop(jogador)) {
				break;
			}
			controleEventos.aplicarEfeitorPorTurno(jogador);
			if (bloquearLoop(jogador)) {
				break;
			}
			deveriamosMudarOAmbiente(jogador);
			bloquearLoop= 1+ bloquearLoop;

		}
		controleEventos.todosFinais(jogador, loopMaximo, bloquearLoop);

	}
	
	
	
	

}
