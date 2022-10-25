package org.serratec.ecommerce.api.corverters;

import javax.persistence.AttributeConverter;

import org.serratec.ecommerce.api.domain.StatusPedido;

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
		 if (codigo == null) {
	            return null;
	        }

	        for(StatusPedido status: StatusPedido.values()) {
	            if (status.getCodigo() == codigo) {
	                return status;
	            }
	        }
	        throw new IllegalArgumentException();
	}

}
