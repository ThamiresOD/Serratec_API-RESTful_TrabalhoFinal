package org.serratec.ecommerce.api.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.serratec.ecommerce.api.domain.dto.ItemInserirDTO;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "pedido_item")
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id do item pedido")
	@Column(name = "pdt_cd_id")
	private Long id;
	
	@NotNull
	@ApiModelProperty(value = "Quantidade do item pedido")
	@Column(name = "pdt_int_quantidade", nullable = false)
	private Integer quantidade;
	
	@NotNull
	@ApiModelProperty(value = "Preco de venda do item pedido")
	@Column(name = "pdt_nm_preco_venda", nullable = false)
	private Double precoVenda;
	
	@NotNull
	@ApiModelProperty(value = "Percentual do desconto do item pedido")
	@Column(name = "pdt_nm_percentual_desconto", nullable = false)
	private Double percentualDesconto;
	
	@NotNull
	@ApiModelProperty(value = "Valor bruto do produto")
	@Column(name = "pdt_nm_valor_bruto", nullable = false)
	private Double valorBruto;
	
	@NotNull
	@ApiModelProperty(value = "Valor liquido do produto")
	@Column(name = "pdt_nm_valor_liquido", nullable = false)
	private Double valorLiquido;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "prd_cd_id", nullable = false)
	private Produto produto;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "ped_cd_id", nullable = false)
	private Pedido pedido;

	public ItemPedido() {
		super();
	}

	public ItemPedido(Long id, @NotNull Integer quantidade, @NotNull Double precoVenda,
			@NotNull Double percentualDesconto, @NotNull Double valorBruto, @NotNull Double valorLiquido,
			Produto produto, Pedido pedido) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
		this.produto = produto;
		this.pedido = pedido;
	}
	public ItemPedido(ItemInserirDTO itemDTO, Double valorBruto, Double valorLiquido, Produto produto) {
		this.quantidade=itemDTO.getQuantidade();
		this.percentualDesconto=itemDTO.getPercentualDesconto();
		this.produto=produto;
		this.precoVenda=valorLiquido;
		this.valorBruto=valorBruto;
		this.valorLiquido=valorLiquido;
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
