package org.serratec.ecommerce.api.exception;

import java.time.LocalDateTime;

public class UniqueCpfException extends Throwable {
	private Integer status;
	private String titulo;
	private LocalDateTime dataHora;

	public UniqueCpfException(String message) {
		super(message);
	}

	public UniqueCpfException() {
		super();
	}

	public UniqueCpfException(Integer status, String titulo, LocalDateTime dataHora) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.dataHora = dataHora;
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

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

}
