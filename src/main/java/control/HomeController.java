package control;

import java.util.Scanner;

public class HomeController {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 0;
		do {
			System.out.print("--- HOME ---");
			System.out.print(		
				"\n1. Sócio" +
				"\n2. Dependente" +
				"\n3. Mensalidade" +
				"\n4. Volte a HOME" +
				"\nOpção (Zero p/sair): ");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
                    SocioController.main(null);
					break;
				case 2:
					DependenteController.main(null);
					break;
				case 3:
					MensalidadeController.main(null);
					break;	
				case 4:
					HomeController.main(null);
					break;
				default:
					if(opcao != 0) System.out.println("Opção inválida.");
			}
		} while(opcao != 0) ;
		System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
		input.close(); //libera o recurso
	}
}//fim classe