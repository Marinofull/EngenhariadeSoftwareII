package Main;

import models.*;
import database.Banco;

import java.util.Scanner;

public class Sistema {
public static Banco banco = new Banco();
public static Scanner reader = new Scanner(System.in);

static int op;
public static String nameB;
public static String emailB;
public static String passwordB;

public static void main(String args[]) {

    for(;;) {
        System.out.println("Seja bem vindo ao portal Brasil Cars!");
        System.out.println("1-Login\n2-Cadastrar\n");
        op = reader.nextInt();

        switch (op) {
            case 1:
                Sistema.login();
                break;
            case 2:
                Sistema.singUp();
                break;
            case 3:
                return;
            default:
                break;
        }
    }
}

private static void login(){
    Pessoa logado;
    do {
        System.out.println("Entre com seus dados");
        System.out.print("email: ");
        emailB = reader.next();
        System.out.print("password: ");
        passwordB = reader.next();
        logado = Pessoa.login(banco, emailB, passwordB);
    } while (logado.isFail());

    if( logado instanceof Cliente){
        do {
            System.out.println("Escolha uma opcao");
            System.out.println("1 - Rental Cars");
            System.out.println("2 - Sales Cars");
            System.out.println("3 - Cars Manutenutencao");
            System.out.println("4 - Sair");
            op = reader.nextInt();

            switch (op){
                case 1:
                    System.out.println("Rental Cars");
                    RentalCars.run(banco) ;
                    //System.out.println("Servicoo indisponivel no momento");
                    break;
                case 2:
                    System.out.println("Bem vindo a SalesCars");
                    //SalesCars.runFunc(banco, funcionario)
                    SalesCars.runClient(banco, (Cliente)logado);                    
                    break;
                case 3:
                    System.out.println("Servico indisponivel no momento");
                    break;
                case 4: break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (op != 4);
    }
    else{
        switch (((Funcionario) logado).getEmpresa()){
            case 0:
                System.out.println("Brasil Cars");
                CarsBrasil.run(banco);
                break;
            case 1:
                System.out.println("Rental Cars");
                RentalCars.run(banco);
                break;
            case 2:
                System.out.println("Main.Sistema de Sales Cars offline");
                SalesCars.runFunc(banco, (Funcionario)logado);
                break;
            case 3:
                System.out.println("Main.Sistema de Cars Manuten��ao offline");
                break;
        }
    }

}

private static void singUp(){
    Cliente novo;
    String r;
    do {
        System.out.println("Entre com seus dados");
        System.out.print("nome: ");
        nameB = reader.next();
        System.out.print("email: ");
        emailB = reader.next();
        System.out.print("password: ");
        passwordB = reader.next();
        System.out.print("Confirma? y/n");
        r = reader.next();
    } while (r.equals("n") || r.equals("n"));
    Cliente.create(banco, nameB, emailB, passwordB);
}

}
