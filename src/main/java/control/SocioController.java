package control;

import java.util.Scanner;

import DAO.SocioDAO;
import model.Socio;

public class SocioController {

	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcao = 0;
		do {
			System.out.print("--- Socio ---");
			System.out.print(		
				"\n1. Registra um socio" +
				"\n2. Buscar socio pelo n° do cartão" +
				"\n3. Lista de todos socios" +
				"\n4. Voltar a HOME" +
				"\nOpção (Zero p/sair): ");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					RegSocio();
					break;
				case 2:
					ConsSocio();
					break;
				case 3:
					ListaSocio();
					break;
				case 4: 
					HomeController.main(null);
					break;
				default:
					if(opcao != 0) System.out.println("Opção inválida.");
			}
		} while(opcao != 0) ;	
	}
	
	//opção 1
	private static void RegSocio() {
		Socio Socio= new Socio();
        System.out.println("\n++++++ Cadastro de Socio ++++++");
        System.out.print("Digite seu nome: ");
        Socio.setNome_socio(input.nextLine());
        System.out.print("Digite o endere�o:");
        Socio.setEnd_socio(input.nextLine());
        System.out.print("Digite o telefone:");
        Socio.setTel_socio(input.nextLine());
        System.out.print("Digite o email:");
        Socio.setEmail_socio(input.nextLine());
        System.out.print("Digite sua categoria:");
        Socio.setDes_cat(input.nextLine());
        input.nextLine(); //limpa o input
		
        if(SocioDAO.RegSocio(Socio)) {
        	System.out.println("\nCategoria salvo com sucesso." + Socio.getCartao_socio());
        	//nao esta pegando o dado de Cartao_socio.
        }else {
        	System.out.println("\nHouve um erro ao salvar o Categoria. Por favor, contate o administrador do sistema.");
        }
    }

	//opção 2
	private static void ConsSocio() {
		System.out.print("\nDigite o n° do cartão de sócio: ");
        Socio socio = SocioDAO.ConsSocio(input.nextLong());
        input.nextLine();
        if(socio != null){
            System.out.println(socio);
        }else{
            System.out.println("Código não localizado.");
        }
	}
	
	//opção 3
	private static void ListaSocio() {
		System.out.println("\nLista de socios cadastrados no banco de dados:\n" + SocioDAO.ListaSocio());
	}
}//fim classe