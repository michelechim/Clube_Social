package control;

import java.util.Scanner;

import DAO.CategoriaDAO;
import model.Categoria;

public class CategoriaController {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao = 0;
		do {
			System.out.print("\n\"-------  MENU Categoria -------\"");
			System.out.print(		
				"\n1. Inserir nova categoria" +
				"\n2. Listar todas as categorias" +
				"\nOpção (Zero p/sair): ");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					inserir();
					break;
				case 2:
					selectCategoria();
					break;
				default:
					if(opcao != 0) System.out.println("Opção inválida.");
			}
		} while(opcao != 0) ;	
	}
	
	//opção 1
	private static void inserir() {
		Categoria Categoria = new Categoria();
        System.out.println("\n++++++ Cadastro de novo Categoria ++++++");
        System.out.print("\nDigite a descrição do Categoria: ");
        Categoria.setDes_cat(input.nextLine());
        input.nextLine(); //limpa o input
        if(CategoriaDAO.insertCategoria(Categoria)) {
        	System.out.println("\nCategoria salvo com sucesso." + Categoria.getDes_cat());
        }else {
        	System.out.println("\nHouve um erro ao salvar o Categoria. Por favor, contate o administrador do sistema.");
        }     
    }
	
	//opção 2
	private static void selectCategoria() {
		System.out.println("\nLista de Categorias cadastrados no banco de dados:\n" + CategoriaDAO.selectCategoria());
	}
}//fim classe