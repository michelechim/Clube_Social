package control;

import java.util.Scanner;

import DAO.DependenteDAO;
import model.Dependente;

public class DependenteController {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao = 0;
		do {
			System.out.print("\n\"-------  MENU Dependente -------\"");
			System.out.print(		
				"\n1. Registra dependente" +
				"\n2. Listar todos dependente" +
				"\nOp��o (Zero p/sair): ");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					RegDep();
					break;
				default:
					if(opcao != 0) System.out.println("Op��o inv�lida.");
			}
		} while(opcao != 0) ;	
	}
	
	//op��o 1
	private static void RegDep() {
		Dependente dependente= new Dependente();
        System.out.println("\n++++++ Cadastro de dependente ++++++");
        System.out.print("\nDigite seu nome: ");
        dependente.setNome_dep(input.nextLine());
        System.out.print("\nDigite o parentesco:");
        dependente.setParentesco(input.nextLine());
        System.out.print("\nDigite o email:");
        dependente.setEmail_dep(input.nextLine());
        System.out.print("\nDigite o nro do cart�o de s�cio:");
        dependente.setCartao_socio(null);
        input.nextLine(); //limpa o inpu

        if(DependenteDAO.RegDep(dependente)) {
        	System.out.println("\nCategoria salvo com sucesso." + dependente.getCartao_dep());
        	//nao esta pegando o dado de Cartao_dependente.
        }else {
        	System.out.println("\nHouve um erro ao salvar o Categoria. Por favor, contate o administrador do sistema.");
        }
    }
}//fim classe