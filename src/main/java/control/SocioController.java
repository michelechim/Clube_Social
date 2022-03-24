package control;

import java.util.Scanner;

import DAO.SocioDAO;
import model.Socio;


public class SocioController {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao = 0;
		do {
			System.out.print("\n\"-------  MENU socio -------\"");
			System.out.print(		
				"\n1. Registra um socio" +
				"\n2. Listar todas as socios" +
				"\n3. Buscar socio pelo código" +
				"\nOpção (Zero p/sair): ");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					RegSocio();
					break;
				case 2:
					selectSocio();
					break;
				case 3:
					ConsSocio();
					break;
				default:
					if(opcao != 0) System.out.println("Opção inválida.");
			}
		} while(opcao != 0) ;	
	}
	
	//opção 1
	private static void RegSocio() {
		Socio Socio= new Socio();
        System.out.println("\n++++++ Cadastro de Sócio ++++++");
        System.out.print("\nDigite seu nome: ");
        Socio.setNome_socio(input.nextLine());
        System.out.print("\nDigite o endereço:");
        Socio.setEnd_socio(input.nextLine());
        System.out.print("\nDigite o telefone:");
        Socio.setTel_socio(input.nextLine());
        System.out.print("\nDigite o email:");
        Socio.setEmail_socio(input.nextLine());
        System.out.print("\nDigite a categoria:");
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
	private static void selectSocio() {
		System.out.println("\nLista de socios cadastrados no banco de dados:\n" + SocioDAO.selectSocio());
	}
	
	//opção 3
	private static void ConsSocio() {
		System.out.print("\nDigite o código do socio: ");
        Socio socio = SocioDAO.ConsSocio(input.nextLong());
        input.nextLine();
        if(socio != null){
            System.out.println(socio);
        }else{
            System.out.println("Código não localizado.");
        }
	}
}//fim classe