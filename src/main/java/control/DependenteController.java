package control;

import java.util.Scanner;

import DAO.DependenteDAO;
import model.Dependente;

public class DependenteController {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao = 0;
		do {
			System.out.print("--- Dependente ---");
			System.out.print(		
				"\n1. Registra um dependente" +
				"\n2. Listar todos os dependentes" +
				"\n3. Volte a HOME" +
				"\nOpção (Zero p/sair): ");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					RegDep();
					break;
				case 2:
					SelectDep();
					break;
				case 3:
					HomeController.main(null);
				default:
					if(opcao != 0) System.out.println("Opção Inválida.");
			}
		} while(opcao != 0) ;	
	}
	
	//op��o 1
	private static void RegDep() {
		Dependente dependente = new Dependente();
		System.out.println("\n++++++ Cadastro de dependente ++++++");
        System.out.print("Digite seu nome: ");
        dependente.setNome_dep(input.nextLine());
        System.out.print("Digite o grau de parentesco:");
        dependente.setParentesco(input.nextLine());
        System.out.print("Digite o email:");
        dependente.setEmail_dep(input.nextLine());
        System.out.print("Digite o nro de cartao do socio: ");
        dependente.setSocio(input.nextLine());
        input.nextLine(); //limpa o input
       
        if(DependenteDAO.RegDep(dependente)) {
        	System.out.println("\nDependente salvo com sucesso." + dependente.getCartao_dep());
        	//nao esta pegando o dado de Cartao_socio.
        }else {
        	System.out.println("\nHouve um erro ao salvar o dependente. Por favor, contate o administrador do sistema.");
        }
    }
	//op��o 2
	private static void SelectDep() {
		System.out.println("\nLista de dependentes cadastrados no banco de dados:\n" + DependenteDAO.selectDep());
	}
}//fim classe