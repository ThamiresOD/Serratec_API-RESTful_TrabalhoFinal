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

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "ID do pedido")
	@Column(name = "idPedido")
	private Long id;
	
	@NotNull
	@ApiModelProperty(value = "Data do pedido")
	@Column(name = "dataPedido", nullable = false)
	private LocalDate dataPedido;
	
	@ApiModelProperty(value = "Data de entrega do pedido")
	@Column(name = "dataEntrega")
	private LocalDate dataEntrega;
	
	@ApiModelProperty(value = "Data de envio do pedido")
	@Column(name = "dataEnvio")
	private LocalDate dataEnvio;
	
	@NotBlank(message = "Preencha o status")
	@ApiModelProperty(value = "Status do pedido")
	@Column(name = "status", length = 1, nullable = false)
	private String status;
	
	@NotNull
	@ApiModelProperty(value = "Valor total do pedido")
	@Column(name = "valorTotal", nullable = false)
	private Double valorTotal;
	
	@ManyToOne
	@JoinColumn(name = "idCliente", nullable = false)
	private Cliente cliente;
	
	public Pedido() {
		super();
	}

	
	public Pedido(Long id, @NotNull LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataEnvio,
			@NotBlank(message = "Preencha o status") String status, @NotNull Double valorTotal, Cliente cliente) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
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

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
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
