package model;

public class Dependente {
	private Long cartao_dep;
	private String nome_dep;
	private String parentesco;
	private String email_dep;
	// private Long cartao_socio;
	private String socio;

	/* M�todos construtores */
	public Dependente() {
		super();
	}

	// Construtor Parametrizado
	public Dependente(Long cartao_dep, String nome_dep, String parentesco, String email_dep, String socio) {
		this.cartao_dep = cartao_dep;
		this.nome_dep = nome_dep;
		this.parentesco = parentesco;
		this.email_dep = email_dep;
		this.socio = socio;
	}

	/* M�todos acessores */
	public Long getCartao_dep() {
		return cartao_dep;
	}

	public void setCartao_dep(Long cartao_dep) {
		this.cartao_dep = cartao_dep;
	}

	public String getNome_dep() {
		return nome_dep;
	}

	public void setNome_dep(String nome_dep) {
		this.nome_dep = nome_dep;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getEmail_dep() {
		return email_dep;
	}

	public void setEmail_dep(String email_dep) {
		this.email_dep = email_dep;
	}

	public String getSocio() {
		return socio;
	}

	public void setSocio(String socio) {
		this.socio = socio;
	}

	@Override
	public String toString() {
		return "\nN° cartão= " + cartao_dep + "\nNome= " + nome_dep + "		Parentesco= " + parentesco + "\nEmail= "
				+ email_dep + "		N° Sócio= " + socio + "\n";
	}
}