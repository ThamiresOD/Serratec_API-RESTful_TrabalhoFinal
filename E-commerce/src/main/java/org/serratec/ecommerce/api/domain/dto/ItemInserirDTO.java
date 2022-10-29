package org.serratec.ecommerce.api.domain.dto;

public class ItemInserirDTO {
	private Integer quantidade;
	private Double percentualDesconto;
	private Long idProduto;

	public ItemInserirDTO() {
		super();
	}

	public ItemInserirDTO(Integer quantidade, Double percentualDesconto, Long idProduto) {
		super();
		this.quantidade = quantidade;
		this.percentualDesconto = percentualDesconto;
		this.idProduto = idProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

}
