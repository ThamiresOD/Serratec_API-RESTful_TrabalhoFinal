package org.serratec.ecommerce.api.exception;

public class ClienteNotFoundException extends Exception{
	private Integer status;
	private String titulo;
	
	
	public ClienteNotFoundException() {
		super();
	}
	public ClienteNotFoundException(Integer status, String titulo) {
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
