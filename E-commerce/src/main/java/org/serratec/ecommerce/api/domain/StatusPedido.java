package org.serratec.ecommerce.api.domain;

import java.util.stream.Stream;

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
	public static StatusPedido verifica(String codigo) throws IllegalArgumentException {
		return Stream.of(StatusPedido.values())
				.filter( s -> s.getCodigo().equals(codigo))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
