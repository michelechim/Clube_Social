package model;

public class Socio {
	private Long cartao_socio;
	private String nome_socio;
	private String end_socio;
	private String tel_socio;
	private String email_socio;
	private String des_cat;

	// M�todos construtores
	public Socio() {
		super();
	}

	// Construtor parametrizado
	public Socio(Long cartao_socio, String nome_socio, String end_socio, String tel_socio, String email_socio,
			String des_cat) {
		this.cartao_socio = cartao_socio;
		this.nome_socio = nome_socio;
		this.end_socio = end_socio;
		this.tel_socio = tel_socio;
		this.email_socio = email_socio;
		this.des_cat = des_cat;
	}

	public Long getCartao_socio() {
		return cartao_socio;
	}

	public void setCartao_socio(Long cartao_socio) {
		this.cartao_socio = cartao_socio;
	}

	public String getNome_socio() {
		return nome_socio;
	}

	public void setNome_socio(String nome_socio) {
		this.nome_socio = nome_socio;
	}

	public String getEnd_socio() {
		return end_socio;
	}

	public void setEnd_socio(String end_socio) {
		this.end_socio = end_socio;
	}

	public String getTel_socio() {
		return tel_socio;
	}

	public void setTel_socio(String tel_socio) {
		this.tel_socio = tel_socio;
	}

	public String getEmail_socio() {
		return email_socio;
	}

	public void setEmail_socio(String email_socio) {
		this.email_socio = email_socio;
	}

	public String getDes_cat() {
		return des_cat;
	}

	public void setDes_cat(String des_cat) {
		this.des_cat = des_cat;
	}

	@Override
	public String toString() {
		return "\nCartao:" + cartao_socio + "		Nome:" + nome_socio + "\nEndereço= " + end_socio
				+ "		Telefone= " + tel_socio + "\nEmail:" + email_socio + "		Categoria:" + des_cat + "\n";
	}
}