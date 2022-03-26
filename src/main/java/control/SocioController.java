package control;

import java.util.Scanner;

import DAO.CategoriaDAO;
import DAO.SocioDAO;
import model.Categoria;
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
				"\n3. Buscar socio pelo c�digo" +
				"\nOp��o (Zero p/sair): ");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					RegSocio();
					break;
				case 2:
					SelectSocio();
					break;
				case 3:
					ConsSocio();
					break;
				default:
					if(opcao != 0) System.out.println("Op��o inv�lida.");
			}
		} while(opcao != 0) ;	
	}
	
	//op��o 1
	private static void RegSocio() {
		Socio Socio= new Socio();
        System.out.println("\n++++++ Cadastro de Socio ++++++");
        System.out.print("\nDigite seu nome: ");
        Socio.setNome_socio(input.nextLine());
        System.out.print("\nDigite o endere�o:");
        Socio.setEnd_socio(input.nextLine());
        System.out.print("\nDigite o telefone:");
        Socio.setTel_socio(input.nextLine());
        System.out.print("\nDigite o email:");
        Socio.setEmail_socio(input.nextLine());
        System.out.print("Digite o nome da categoria: ");
        String des_cat = null;
		Socio.setCategoria((Categoria) CategoriaDAO.selectCategoriaByDes(des_cat));
		
        input.nextLine(); //limpa o input
        if(SocioDAO.RegSocio(Socio)) {
        	System.out.println("\nCategoria salvo com sucesso." + Socio.getCartao_socio());
        	//nao esta pegando o dado de Cartao_socio.
        }else {
        	System.out.println("\nHouve um erro ao salvar o Categoria. Por favor, contate o administrador do sistema.");
        }
    }
	//op��o 2
	private static void SelectSocio() {
		System.out.println("\nLista de socios cadastrados no banco de dados:\n" + SocioDAO.selectSocio());
	}
	
	//op��o 3
	private static void ConsSocio() {
		System.out.print("\nDigite o c�digo do socio: ");
        Socio socio = SocioDAO.ConsSocio(input.nextLong());
        input.nextLine();
        if(socio != null){
            System.out.println(socio);
        }else{
            System.out.println("C�digo n�o localizado.");
        }
	}
}//fim classe