package org.serratec.ecommerce.api.domain.dto;

import java.time.LocalDate;
import java.util.List;

import org.serratec.ecommerce.api.domain.Cliente;
import org.serratec.ecommerce.api.domain.Pedido;
import org.serratec.ecommerce.api.domain.StatusPedido;

public class PedidoInserirDTO {
	private LocalDate dataPedido;
	private LocalDate dataEntrega;
	private LocalDate dataEnvio;
	private StatusPedido status;
	private Cliente cliente;
	private List<ItemInserirDTO> items;

	public PedidoInserirDTO(Pedido pedido) {
		this.dataPedido=pedido.getDataPedido();
		this.dataEntrega=pedido.getDataEntrega();
		this.dataEnvio=pedido.getDataEnvio();
		this.status=pedido.getStatus();
		this.cliente=pedido.getCliente();
	}
	public PedidoInserirDTO(LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataEnvio, StatusPedido status,
			Cliente cliente, List<ItemInserirDTO> items) {
		super();
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.cliente = cliente;
		this.items = items;
	}

	public PedidoInserirDTO() {
		super();
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemInserirDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemInserirDTO> items) {
		this.items = items;
	}

}
