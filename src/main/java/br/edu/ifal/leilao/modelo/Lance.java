package br.edu.ifal.leilao.modelo;

public class Lance {
	private Usuario ususario;
	private double valor;
	
	
	public Lance(Usuario ususario, double valor) {
		super();
		this.ususario = ususario;
		this.valor = valor;
	}
	
	public Usuario getUsusario() {
		return ususario;
	}
	public void setUsusario(Usuario ususario) {
		this.ususario = ususario;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
