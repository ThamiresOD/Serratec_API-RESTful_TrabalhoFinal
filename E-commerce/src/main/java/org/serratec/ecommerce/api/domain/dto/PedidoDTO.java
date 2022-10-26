package org.serratec.ecommerce.api.domain.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.ecommerce.api.domain.Cliente;
import org.serratec.ecommerce.api.domain.Pedido;
import org.serratec.ecommerce.api.domain.StatusPedido;

public class PedidoDTO {
	Long idPedido;
	LocalDate dataPedido;
	LocalDate dataEntrega;
	LocalDate dataEnvio;
	StatusPedido status;
	Cliente cliente;
	List<ItemDTO> items = new ArrayList<>();

	public PedidoDTO(Long idPedido, LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataEnvio,
			StatusPedido status, Cliente cliente, List<ItemDTO> items) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.cliente = cliente;
		this.items = items;
	}
	
	public PedidoDTO(Pedido pedido) {
		this.idPedido=pedido.getId();
		this.dataPedido=pedido.getDataPedido();
		this.dataEntrega=pedido.getDataEntrega();
		this.dataEnvio=pedido.getDataEnvio();
		this.status=pedido.getStatus();
		this.cliente=pedido.getCliente();		
	}

	public PedidoDTO() {
		super();
	}
	
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
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

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	
	public void addItems(ItemDTO item) {
		this.items.add(item);
	}
}
