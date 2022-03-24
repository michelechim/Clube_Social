package model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Mensalidade {
	private Long nro_mens;
	private Long cartao_socio;
	private Calendar data_mens;
	private Double valor_mens;
	private Calendar data_pgto_mens;
	private Double juros_mens;
	private Double valor_pago;
	private Boolean quit_mens;

	/* Métodos construtores */
	public Mensalidade(){
		super();
	}
	
	//Construtor Parametrizado
	public Mensalidade(Long nro_mens, Long cartao_socio, Calendar data_mens, double valor_mens, 
			Calendar data_pgto_mens, Double juros_mens, double valor_pago, boolean quit_mens){
		this.nro_mens = nro_mens;
		this.cartao_socio = cartao_socio;
		this.data_mens = data_mens;
		this.valor_mens = valor_mens;
		this.data_pgto_mens = data_pgto_mens;
		this.juros_mens = juros_mens;
		this.valor_pago = valor_pago;
		this.quit_mens = quit_mens;
	}
	
	/*Métodos acessores*/	
	public Long getNro_mens() {
		return nro_mens;
	}

	public void setNro_mens(Long nro_mens) {
		this.nro_mens = nro_mens;
	}

	public Long getCartao_socio() {
		return cartao_socio;
	}

	public void setCartao_socio(Long cartao_socio) {
		this.cartao_socio = cartao_socio;
	}

	public Calendar getData_mens() {
		return data_mens;
	}

	public void setData_mens(Calendar data_mens) {
		this.data_mens = data_mens;
	}

	public double getValor_mens() {
		return valor_mens;
	}

	public void setValor_mens(double valor_mens) {
		this.valor_mens = valor_mens;
	}

	public Calendar getData_pgto_mens() {
		return data_pgto_mens;
	}

	public void setData_pgto_mens(Calendar data_pgto_mens) {
		this.data_pgto_mens = data_pgto_mens;
	}

	public double getJuros_mens() {
		return juros_mens;
	}

	public void setJuros_mens(double juros_mens) {
		this.juros_mens = juros_mens;
	}

	public double getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(double valor_pago) {
		this.valor_pago = valor_pago;
	}

	public boolean isQuit_mens() {
		return quit_mens;
	}

	public void setQuit_mens(boolean quit_mens) {
		this.quit_mens = quit_mens;
	}
	@Override
	public String toString() {
		return "\n******* Mensalidade ******" +
				"\nNumero= " + nro_mens + 
				"\nCartao socio= " + cartao_socio + 
				"\nData= " + calendarToString1(data_mens) + 
				"\nValor= " + NumberFormat.getCurrencyInstance().format(valor_mens) + 
				"\nData de pagamento= " + calendarToString2(data_pgto_mens) + 
				"\nJuros= " + NumberFormat.getCurrencyInstance().format(juros_mens) + 
				"\nValor pago=" + NumberFormat.getCurrencyInstance().format(valor_pago) + 
				"\nQuitação=" + quit_mens + "\n";
	}
	
	//métodos utilitários para conversão de Calendar para String formatada
	private static String calendarToString1(Calendar data_mens) {
		if(data_mens != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			return sdf.format(data_mens.getTime());
		}
		return "00/00/0000";
	}
	
	private static String calendarToString2(Calendar data_pgto_mens) {
		if(data_pgto_mens != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			return sdf.format(data_pgto_mens.getTime());
		}
		return "00/00/0000";
	}
}