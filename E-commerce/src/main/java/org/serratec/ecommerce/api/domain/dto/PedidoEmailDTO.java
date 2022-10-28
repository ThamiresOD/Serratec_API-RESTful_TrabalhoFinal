package org.serratec.ecommerce.api.domain.dto;

import java.time.LocalDate;
import java.util.List;

public class PedidoEmailDTO {
	private Long idPedido;
	private LocalDate dataPedido;
	private List<ItemDTO> items;
	
	public PedidoEmailDTO() {
		super();
	}
	public PedidoEmailDTO(Long idPedido, LocalDate dataPedido, List<ItemDTO> items) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.items = items;
	}
	
	@Override
	public String toString() {
		String itemsString = "";
		for(ItemDTO item : items) {
			itemsString = itemsString + item.toString();
		}
		return "O seu pedido foi registrado com sucesso!\n" + 
				"Id do pedido:" + idPedido.toString() +
				"\nData do Pedido: " + dataPedido.toString() + 
				"\n Items :" + itemsString;
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
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	
	
}
