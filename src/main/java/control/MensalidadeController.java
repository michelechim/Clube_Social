package control;

import java.util.Scanner;

import DAO.MensalidadeDAO;
import model.Mensalidade;

public class MensalidadeController{
	private static final Scanner input  = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcao = 0;
		do {
			System.out.println("\n*** Menu - Mensalidade ***\n"
					+ "\n1. Consulta"
					+ "\n2. Busca situacao"
					+ "\n3. Calcula Juros"
					+ "\nOpção (Zero p/ sair):");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					ConsMens();
					break;
				case 2:
					SelectMensalidade();
					break;
				default:
					if(opcao != 0 ) System.out.println("Opção inválida!");
			}
		}while(opcao != 0);
	}
	//opcao 1
	private static void ConsMens() {
		System.out.print("\nDigite o codigo: ");
		Mensalidade mensalidade = MensalidadeDAO.ConsMens(input.nextLong());
        input.nextLine();
        if(mensalidade != null){
            System.out.println(mensalidade);
        }else{
            System.out.println("Não encontrado.");
        }
	}
	
	//opcao 2
	private static void SelectMensalidade() {
		System.out.println("\nLista das mensalidades:\n" + MensalidadeDAO.SelectMensalidade());
	}
}