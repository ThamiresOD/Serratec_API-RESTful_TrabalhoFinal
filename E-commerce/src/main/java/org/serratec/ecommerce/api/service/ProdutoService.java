package org.serratec.ecommerce.api.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.domain.dto.ProdutoInserirDTO;
import org.serratec.ecommerce.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository prodRepo;

	@Autowired
	private FotoService fotoService;

	public List<Produto> findAll() {
		return prodRepo.findAll();
	}

	public Produto inserir(Produto produto) {
		return prodRepo.save(produto);
	}

	public Optional<Produto> findById(Long id) {
		return prodRepo.findById(id);
	}

	public void deleteById(Long id) {
		prodRepo.deleteById(id);
	}

	public List<ProdutoInserirDTO> listar() {
		List<ProdutoInserirDTO> produtoDTOs = prodRepo.findAll().stream().map(f -> adicionarImagemUri(f))
				.collect(Collectors.toList());
		return produtoDTOs;
	}

	public ProdutoInserirDTO adicionarImagemUri(Produto produto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produtos/{id}/foto")
				.buildAndExpand(produto.getId()).toUri();
		ProdutoInserirDTO dto = new ProdutoInserirDTO(produto);
		dto.setNome(produto.getNomeProduto());
		dto.setDescricao(produto.getDescricaoProduto());
		dto.setQtdEstoque(produto.getQuantidadeEstoqueProduto());
		dto.setCategoria(produto.getCategoria());
		dto.setUrlProduto(uri.toString());
		return dto;
	}

	public ProdutoInserirDTO buscar(Long id) {
		Optional<Produto> produto = prodRepo.findById(id);
		return adicionarImagemUri(produto.get());
	}

	public ProdutoInserirDTO inserir(Produto produto, MultipartFile file) throws IOException {
		produto = prodRepo.save(produto);
		fotoService.inserir(produto, file);
		return adicionarImagemUri(produto);
	}

	public Produto findById(Produto produto) {
		return prodRepo.findById(produto);
	}

	public Produto save(Produto produto) {
		return prodRepo.save(produto);
		
	}
}
