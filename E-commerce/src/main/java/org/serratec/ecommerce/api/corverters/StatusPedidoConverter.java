package org.serratec.ecommerce.api.corverters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.serratec.ecommerce.api.domain.StatusPedido;

@Converter(autoApply = true)
public class StatusPedidoConverter implements AttributeConverter<StatusPedido, String> {

	@Override
	public String convertToDatabaseColumn(StatusPedido statusPedido) {
		if (statusPedido == null) {
			return null;
		}
		return statusPedido.getCodigo();
	}

	@Override
	public StatusPedido convertToEntityAttribute(String codigo) {
		if(codigo == null) {
			return null;
		}
		return StatusPedido.verifica(codigo);
	}

}
