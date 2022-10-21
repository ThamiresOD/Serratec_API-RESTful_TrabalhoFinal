package org.serratec.ecommerce.api.controller
;

import java.util.List;

import org.serratec.ecommerce.api.domain.Cliente;
import org.serratec.ecommerce.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired 
	ClienteRepository cliRepo;

	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes(){
		return ResponseEntity.ok(cliRepo.findAll());
	}
}
