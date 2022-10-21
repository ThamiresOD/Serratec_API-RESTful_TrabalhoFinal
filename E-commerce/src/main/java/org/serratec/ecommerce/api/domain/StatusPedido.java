package org.serratec.ecommerce.api.domain;

import org.serratec.ecommerce.api.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusPedido {
	CONFIRMADO("C"), ENVIADO("E"), RECEBIDO("R"), CANCELADO("A");

	private String codigo;

	private StatusPedido(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@JsonCreator
	public static StatusPedido verifica(String codigo) throws EnumValidationException {
		for (StatusPedido s : StatusPedido.values()) {
			if (s.getCodigo() == codigo) {
				return s;
			}
		}
		throw new EnumValidationException("Categoria" + codigo + " não existe");
	}
}
