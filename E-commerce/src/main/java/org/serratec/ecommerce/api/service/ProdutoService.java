package org.serratec.ecommerce.api.service;

import java.util.List;

import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired 
	private ProdutoRepository prodRepo;
	
	public List<Produto> findAll(){
		return prodRepo.findAll();
	}
	
}
