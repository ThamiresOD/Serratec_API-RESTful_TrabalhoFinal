package org.serratec.ecommerce.api.exception;

public class PedidoNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String titulo;
	
	public PedidoNotFoundException() {
		super();
	}
	public PedidoNotFoundException(Integer status, String titulo) {
		super();
		this.status = status;
		this.titulo = titulo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
