package model;

public class Categoria {
	private String des_cat;
	
	
	/* Métodos construtores */
	public Categoria(){
		super();
	}
	
	//Construtor Parametrizado
	public Categoria(String des_cat){	
		this.des_cat= des_cat;
	}	
	
	/*Métodos acessores*/
	public String getDes_cat() {
		return des_cat;
	}
	public void setDes_cat(String des_cat) {
		this.des_cat = des_cat;
	}
	@Override
	public String toString() {
		return "\nDescrição= " + des_cat + "\n";
	}
}