package Main;

import models.*;
import database.Banco;

import java.util.ArrayList;
import java.util.Scanner;

public class SalesCars {

	public static void runFunc(Banco banco, Funcionario funcionario ){
		//copiado de rental cars
		Scanner reader = new Scanner(System.in);
		byte op;

		do {
			System.out.println("Voce esta logado no modulo sales Cars");
			System.out.println("Escolha uma opcao");
			System.out.println("1 - Cadastrar Veiculos");//feito
			System.out.println("2 - Visualizar Veiculos");//feito + edi��ao, falta delecao
			System.out.println("3 - Cadastrar Postos");
			System.out.println("4 - Visualizar Postos");
			System.out.println("5 - Visualizar Feedbacks");
			System.out.println("6 - Visualizar Agendamentos");
			System.out.println("7 - Realizar Checkin de Loca��ao");
			System.out.println("8 - Realizar Checkout de Loca��ao");
			System.out.println("9 - Cadastrar Planos de Quilometragem");
			System.out.println("10 - Visualizar Historico de Aluguel");
			System.out.println("11 - Sair");
			op = reader.nextByte();

			switch (op){
			case 1:
				cadastrarVeiculos(banco);
				break;
			case 2:
				visualizarVeiculos(banco);
				break;
			case 3:
				cadastrarPostos(banco);
				break;
			case 4:
				visualizarPostos(banco);
				break;
			case 5:
				visualizarFeedbacks(banco);
				break;
			case 11:
				break;
			default:
				System.out.println("Servi��o indisponivel no momento");
				break;
			}
		} while (op != 11);
	}

	private static void visualizarFeedbacks(Banco banco) {
		int op;
		Scanner reader = new Scanner(System.in);

		ArrayList<Feedback> feedbacks = Feedback.getAll(banco);

		for (int i = 0; i < feedbacks.size(); i++)
		{
			System.out.println("Id: " + (i+1) + "-");
			System.out.println("Quem: " + feedbacks.get(i).getWho());
			System.out.println("");
		}

		do
		{
			System.out.println("Para Ler em detalhes algum item digite seu id ou '0' (zero) para sair");
			op = reader.nextInt();
		} while (op > feedbacks.size());
		if (op != 0){
			System.out.println("Cliente " + feedbacks.get(op-1).getWho() + "escreveu:");
			System.out.println(feedbacks.get(op-1).getText());
		}

	}

	public static void runClient(Banco banco, Cliente client){
		Scanner reader = new Scanner(System.in);
		byte op;

		do {
			System.out.println("Voce esta logado no modulo Sales Cars");
			System.out.println("Escolha uma opcao");
			System.out.println("1 - Cadastrar Veiculos");
			System.out.println("2 - Cadastrar Postos");
			System.out.println("3 - Consultar Postos/Alterar Postos");
			System.out.println("4 - Consultar Veiculos/Alterar Veiculos");
			System.out.println("5 - Vender Veiculo");
			System.out.println("6 - Veiculos Disponíveis");
			System.out.println("7 - Escrever feedback");
			System.out.println("8 - Agendar Test Drive");
			System.out.println("9 - Sair");
			op = reader.nextByte();

			switch (op){
			case 1:
				cadastrarVeiculos(banco) ;
				break;
			case 2:
				cadastrarPostos(banco) ;
				break;
			case 3:
				visualizarPostos(banco);
				break;
			case 4:
				visualizarVeiculos(banco) ;
				break;
			case 5:
				venderVeiculos(banco) ;
				break;
			case 6:
				carrosDisponiveis(banco) ;
				break;
			case 7:
				escreverFeedback(banco, client.getId());	
				break;
			case 8:
				agendarTesteDrive(banco, client.getId());	
				break;
			case 9:
				break;
			default:
				System.out.println("Servico indisponivel no momento");
				break;
			}
		} while (op != 9);
	}


	private static void carrosDisponiveis(Banco banco)
	{
		System.out.println("Os carros dísponiveis para na SalesCars são: ");
		int op;
		Scanner reader = new Scanner(System.in);

		for (int i = 0; i < banco.getAutomoveis().size(); i++)
		{
			System.out.println("Id: " + (i+1) + "-");
			System.out.println("Modelo: " + banco.getAutomoveis().get(i).getModelo());
			System.out.println("Tipo: " + banco.getAutomoveis().get(i).getTipo());
			System.out.println("Numero de Portas: " + banco.getAutomoveis().get(i).getNumero_portas());
			System.out.println("Possui Arcondicionado: " + banco.getAutomoveis().get(i).getArcondicionado());
			System.out.println("");
		}

		do
		{
			System.out.println("Pressione '0' (zero) para sair");
			op = reader.nextInt();
		} while (op > banco.getAutomoveis().size());
	}


	private static void escreverFeedback(Banco banco, int cliente)
	{
		Scanner reader = new Scanner(System.in);
		String text;
		Feedback novo;
		System.out.println("Escreva seu Feedback");
		text = reader.nextLine();
		Feedback.create(banco,text, cliente);
		System.out.print("Feedback OK\n");
	}



	private static void cadastrarVeiculos(Banco banco)
	{
		Scanner reader = new Scanner(System.in);
		String modeloB;
		String tipoB; 
		byte numero_portasB;
		int	anoB;
		String arcondicionadoB;

		Automovel novo;

		System.out.println("Modelo do carro");
		modeloB = reader.nextLine();
		System.out.println("Tipo");
		tipoB = reader.nextLine();
		System.out.println("Numero de Portas");
		numero_portasB = reader.nextByte();
		System.out.println("Ano de Fabricacao");
		anoB = reader.nextInt();
		System.out.println("Possui Ar Condicionado? S/N");
		arcondicionadoB = reader.nextLine(); 
		arcondicionadoB = reader.nextLine();

		Automovel.create(banco, modeloB, tipoB, numero_portasB, anoB, arcondicionadoB);
		System.out.print("Automovel cadastrado com sucesso\n");
	}

	private static void visualizarVeiculos(Banco banco)
	{
		int op;
		Scanner reader = new Scanner(System.in);

		for (int i = 0; i < banco.getAutomoveis().size(); i++)
		{
			System.out.println("Id: " + (i+1) + "-");
			System.out.println("Modelo: " + banco.getAutomoveis().get(i).getModelo());
			System.out.println("Tipo: " + banco.getAutomoveis().get(i).getTipo());
			System.out.println("Numero de Portas: " + banco.getAutomoveis().get(i).getNumero_portas());
			System.out.println("Possui Arcondicionado: " + banco.getAutomoveis().get(i).getArcondicionado());
			System.out.println("");
		}

		do
		{
			System.out.println("Para editar algum item digite seu id ou '0' (zero) para sair");
			op = reader.nextInt();
		} while (op > banco.getAutomoveis().size());
		if (op != 0) alterarAutomovel(banco, banco.getAutomoveis().get(op-1));
	}


	private static void venderVeiculos(Banco banco)
	{	
		System.out.println("Bem Vindo ao departamento de vendas de veículos da Sales Cars");


		int op;
		Scanner reader = new Scanner(System.in);

		for (int i = 0; i < banco.getAutomoveis().size(); i++)
		{
			System.out.println("Id: " + (i+1) + "-");
			System.out.println("Modelo: " + banco.getAutomoveis().get(i).getModelo());
			System.out.println("Tipo: " + banco.getAutomoveis().get(i).getTipo());
			System.out.println("Numero de Portas: " + banco.getAutomoveis().get(i).getNumero_portas());
			System.out.println("Possui Arcondicionado: " + banco.getAutomoveis().get(i).getArcondicionado());
			System.out.println("");
		}
		
		System.out.println("Indique número do ID do Veiculo que você gostaria de alugar:");

		do
		{
			op = reader.nextInt();
		} while (op > banco.getAutomoveis().size());
		if (op != 0) {
			removerAutomovel(banco, banco.getAutomoveis().get(op-1)) ;
			System.out.println("O carro de ID " + op + " agora é seu!");
		}
	}


	public static void cadastrarPostos(Banco banco) {
		Scanner reader = new Scanner(System.in);
		String nameB; 
		String bairroB;
		String funcionamentoB; 
		Posto novo;
		System.out.println("Digite o nome da nova unidade");
		nameB = reader.nextLine();
		System.out.println("Digite o nome do Bairro");
		bairroB = reader.nextLine();
		System.out.println("Descreva o periodo de funcionamento (24 horas, 12 horas, fds...)");
		funcionamentoB = reader.nextLine();

		Posto.create(banco, nameB, bairroB, funcionamentoB);
		System.out.print("Automovel cadastrado com sucesso\n");
	}

	public static void visualizarPostos(Banco banco) {
		int op;
		Scanner reader = new Scanner(System.in);

		for (int i = 0; i < banco.getPostos().size(); i++) {
			System.out.println("Id: " + (i+1) + "-");
			System.out.println("Nome: " + banco.getPostos().get(i).getName());
			System.out.println("Bairro: " + banco.getPostos().get(i).getBairro());
			System.out.println("Funcionamento: " + banco.getPostos().get(i).getFuncionamento());
			System.out.println("");
		}

		do {
			System.out.println("Para editar algum item digite seu id ou '0' (zero) para sair");
			op = reader.nextInt();
		} while (op > banco.getPostos().size());
		if (op != 0) alterarPosto(banco, banco.getPostos().get(op-1));
	}

	public static void alterarPosto(Banco banco, Posto obj) {
		Scanner reader = new Scanner(System.in);
		int op;
		String nameB;
		String bairroB;
		String funcionamentoB;

		System.out.println("");
		System.out.println("1- Nome: " + obj.getName());
		System.out.println("2- Bairro: " + obj.getBairro());
		System.out.println("3- Funcionamento: " + obj.getFuncionamento());
		System.out.println("4- Sair");
		System.out.println("O que deseja editar?");
		op = reader.nextInt();

		switch (op) {
		case 1:
			System.out.println("Digite o novo valor para Nome");
			nameB = reader.nextLine();
			nameB = reader.nextLine();
			obj.setName(nameB);
			System.out.println("Modelo alterado com sucesso");
			break;
		case 2:
			System.out.println("Digite o novo valor para Bairro");
			bairroB = reader.nextLine();
			bairroB = reader.nextLine();
			obj.setBairro(bairroB);
			System.out.println("Tipo alterado com sucesso");
			break;
		case 3:
			System.out.println("Digite o novo valor para Funcionamento (24 horas, 12 horas, fds...)");
			funcionamentoB = reader.nextLine();
			funcionamentoB = reader.nextLine();
			obj.setFuncionamento(funcionamentoB);
			System.out.println("Numero de Portas alterado com sucesso");
			break;
		case 4:
			break;
		default:
			break;

		}
		Posto.edit(banco, obj);
	}


	public static void alterarAutomovel(Banco banco, Automovel obj){
		Scanner reader = new Scanner(System.in);
		int op;
		String modeloB;
		String tipoB; 
		byte numero_portasB;
		int	anoB;
		String arcondicionadoB;

		System.out.println("");
		System.out.println("1- Modelo: " + obj.getModelo());
		System.out.println("2- Tipo: " + obj.getTipo());
		System.out.println("3- Numero de Portas: " + obj.getNumero_portas());
		System.out.println("4- Possui Arcondicionado: " + obj.getArcondicionado());
		System.out.println("5- Sair");
		System.out.println("O que deseja editar?");
		op = reader.nextInt();

		switch (op){
		case 1:
			System.out.println("Digite o novo valor para Modelo");
			modeloB = reader.nextLine();
			obj.setModelo(modeloB);
			System.out.println("Modelo alterado com sucesso");
			break;
		case 2:
			System.out.println("Digite o novo valor para Tipo");
			tipoB = reader.nextLine();
			obj.setTipo(tipoB);
			System.out.println("Tipo alterado com sucesso");
			break;
		case 3:
			System.out.println("Digite o novo valor para Numero de Portas");
			numero_portasB = reader.nextByte();
			obj.setNumero_portas(numero_portasB);
			System.out.println("Numero de Portas alterado com sucesso");
			break;
		case 4:
			System.out.println("Digite o novo valor para o campo Ar Condicionado");
			arcondicionadoB = reader.nextLine();
			arcondicionadoB = reader.nextLine();
			obj.setArcondicionado(arcondicionadoB);
			System.out.println("Ar Condicionado alterado com sucesso");
			break;
		case 5: break;
		default:
			break;

		}
		Automovel.edit(banco, obj);
	}

	//Tag: Quando o numero de portas é -1, significa que o carro foi vendido
	public static void removerAutomovel(Banco banco, Automovel obj){
		byte portas = -1 ;
		obj.setModelo("");
		obj.setTipo("");
		obj.setNumero_portas(portas) ;
		obj.setArcondicionado("");
		Automovel.edit(banco, obj);
	}

	private static void agendarTesteDrive(Banco banco, int cliente)
	{
		System.out.println("Bem vindo a marcação de Teste Drive");
		Scanner reader = new Scanner(System.in);
		String data;
		String horario;
		System.out.println("Escreva a data (DD-MM-YYYY) do seu Teste Drive");
		data = reader.nextLine() ;
		System.out.println("Escreva o horário(HH:MM) do seu Teste Drive");
		horario = reader.nextLine();
		TesteDrive.create(banco,data, cliente);
		TesteDrive.create(banco,horario, cliente);
		System.out.print("TesteDrive marcado com sucesso\n");
	}


   
}

