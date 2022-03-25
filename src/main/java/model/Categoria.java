package model;

public class Categoria {
	private Long id_cat;
	private String des_cat;
	
	
	/* M�todos construtores */
	public Categoria(){
		super();
	}
	
	//Construtor Parametrizado
	public Categoria(Long id_cat, String des_cat){	
		this.id_cat = id_cat;
		this.des_cat= des_cat;
	}	
	
	/*M�todos acessores*/
	public String getDes_cat() {
		return des_cat;
	}
	public Long getId_cat() {
		return id_cat;
	}

	public void setId_cat(Long id_cat) {
		this.id_cat = id_cat;
	}

	public void setDes_cat(String des_cat) {
		this.des_cat = des_cat;
	}
	@Override
	public String toString() {
		return "\nDescrição= " + des_cat + "\n";
	}
}