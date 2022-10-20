package org.serratec.ecommerce.api.domain;

import org.serratec.ecommerce.api.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusPedido {
	CONFIRMADO("0", "Confirmado"), ENVIADO("1", "Enviado"), RECEBIDO("2", "Recebido"), CANCELADO("3", "Cancelado");

	private String codigo;
	private String tipo;

	private StatusPedido(String codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@JsonCreator
	public static StatusPedido verifica(String value) throws EnumValidationException {
		for (StatusPedido s : values()) {
			if (value.equals(s.getCodigo())) {
				return s;
			}
		}
		throw new EnumValidationException("Categoria" + value + " não existe");
	}
}
