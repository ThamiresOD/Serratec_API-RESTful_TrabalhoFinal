package org.serratec.ecommerce.api.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.serratec.ecommerce.api.domain.dto.PedidoInserirDTO;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "ID do pedido")
	@Column(name = "ped_cd_id")
	private Long id;

	@NotNull
	@ApiModelProperty(value = "Data do pedido")
	@Column(name = "ped_dt_data_pedido", nullable = false)
	private LocalDate dataPedido;

	@ApiModelProperty(value = "Data de entrega do pedido")
	@Column(name = "ped_dt_data_entrega")
	private LocalDate dataEntrega;

	@ApiModelProperty(value = "Data de envio do pedido")
	@Column(name = "ped_dt_data_envio")
	private LocalDate dataEnvio;

	@NotBlank(message = "Preencha o status")
	@ApiModelProperty(value = "Status do pedido")
	@Column(name = "ped_tx_status", length = 1, nullable = false)
	private StatusPedido status = StatusPedido.CONFIRMADO;

	@NotNull
	@ApiModelProperty(value = "Valor total do pedido")
	@Column(name = "ped_nm_valor_total", nullable = false)
	private Double valorTotal;

	@ManyToOne
	@JoinColumn(name = "cli_cd_id", nullable = false)
	private Cliente cliente;

	public Pedido() {
		super();
	}

	public Pedido(Long id, @NotNull LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataEnvio,
			@NotBlank(message = "Preencha o status") StatusPedido status, @NotNull Double valorTotal, Cliente cliente) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
	}

	public Pedido(PedidoInserirDTO novoPedido, Double valorTotal) {
		this.dataPedido = novoPedido.getDataPedido();
		this.dataEnvio = novoPedido.getDataEnvio();
		this.dataEntrega = novoPedido.getDataEntrega();
		this.status = novoPedido.getStatus();
		this.cliente = novoPedido.getCliente();
		this.valorTotal = valorTotal;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
