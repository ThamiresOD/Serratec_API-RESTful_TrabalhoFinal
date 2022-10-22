package org.serratec.ecommerce.api.service;

import java.util.List;
import java.util.Optional;

import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository prodRepo;

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

}
