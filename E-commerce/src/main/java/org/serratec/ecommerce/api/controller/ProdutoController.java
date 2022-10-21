package org.serratec.ecommerce.api.controller;

import java.util.List;

import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> getProdutos(){
		return produtoService.findAll();
	}
}
