package org.serratec.ecommerce.api.exception;

import java.time.LocalDateTime;

public class MensagemErro {
	private Integer status;
	private String mensagem;
	private LocalDateTime dataHora;
	
	public MensagemErro(Integer status, String titulo, LocalDateTime dataHora) {
		super();
		this.status = status;
		this.mensagem = titulo;
		this.dataHora = dataHora;
	}
	public Integer getStatus() {
		return status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}

	
}
