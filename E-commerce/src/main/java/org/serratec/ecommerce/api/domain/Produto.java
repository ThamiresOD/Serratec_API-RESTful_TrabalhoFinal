package org.serratec.ecommerce.api.domain;

import java.time.LocalDateTime;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.serratec.ecommerce.api.domain.dto.ProdutoInserirDTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id do produto")
	@Column(name = "prd_cd_id")
	private Long id;

	@NotBlank(message = "Preencha o nome")
	@ApiModelProperty(value = "Nome do produto")
	@Column(name = "prd_tx_nome", length = 30, nullable = false, unique = true)
	private String nomeProduto;

	@ApiModelProperty(value = "Descricao do produto")
	@Column(name = "prd_tx_descricao", length = 200)
	private String descricaoProduto;

	@ApiModelProperty(value = "Quantidade em estoque do produto")
	@Column(name = "prd_int_quantidade_estoque", nullable = true)
	private Integer quantidadeEstoqueProduto;

	@ApiModelProperty(value = "Data de cadastro do produto")
	@Column(name = "prd_dt_data_cadastro")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDateTime dataCadastroProduto;

	@NotNull
	@ApiModelProperty(value = "Valor unitario do produto")
	@Column(name = "prd_nm_valor_unitario", nullable = false)
	private Double valorUnitarioProduto;

	@ManyToOne(fetch= FetchType.EAGER) 
	@JoinColumn(name = "cat_cd_id", nullable = false)
	private Categoria categoria;

	public Produto() {
		super();
	}

	public Produto(Long id, @NotBlank(message = "Preencha o nome") String nomeProduto, String descricaoProduto,
			Integer quantidadeEstoqueProduto, LocalDateTime dataCadastroProduto, @NotNull Double valorUnitarioProduto,
			 Categoria categoria) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
		this.dataCadastroProduto = dataCadastroProduto;
		this.valorUnitarioProduto = valorUnitarioProduto;
		this.categoria = categoria;
	}

	public Produto(ProdutoInserirDTO produtoDTO) {
		this.nomeProduto=produtoDTO.getNome();
		this.descricaoProduto=produtoDTO.getDescricao();
		this.quantidadeEstoqueProduto=produtoDTO.getQtdEstoque();
		this.dataCadastroProduto=LocalDateTime.now();
		this.valorUnitarioProduto=produtoDTO.getValorUnitario();
		this.categoria=produtoDTO.getCategoria();
		
	}
	public Produto(ProdutoInserirDTO produtoDTO, Long id) {
		this.id = id;
		this.nomeProduto=produtoDTO.getNome();
		this.descricaoProduto=produtoDTO.getDescricao();
		this.quantidadeEstoqueProduto=produtoDTO.getQtdEstoque();
		this.dataCadastroProduto=LocalDateTime.now();
		this.valorUnitarioProduto=produtoDTO.getValorUnitario();
		this.categoria=produtoDTO.getCategoria();
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public LocalDateTime getDataCadastroProduto() {
		return dataCadastroProduto;
	}

	public void setDataCadastroProduto(LocalDateTime dataCadastroProduto) {
		this.dataCadastroProduto = dataCadastroProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getQuantidadeEstoqueProduto() {
		return quantidadeEstoqueProduto;
	}

	public void setQuantidadeEstoqueProduto(Integer quantidadeEstoqueProduto) {
		this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
	}

	public Double getValorUnitarioProduto() {
		return valorUnitarioProduto;
	}

	public void setValorUnitarioProduto(Double valorUnitarioProduto) {
		this.valorUnitarioProduto = valorUnitarioProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
