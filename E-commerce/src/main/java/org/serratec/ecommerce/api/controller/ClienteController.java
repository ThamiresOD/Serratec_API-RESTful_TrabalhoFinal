package org.serratec.ecommerce.api.controller
;

import java.util.List;

import org.serratec.ecommerce.api.domain.Cliente;
import org.serratec.ecommerce.api.domain.dto.ClienteInserirDTO;
import org.serratec.ecommerce.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired 
	ClienteService clienteService;

	@GetMapping
	@ApiOperation(value="Listagem de todos os clientes")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna a lista de clientes"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
	public ResponseEntity<List<Cliente>> getClientes(){
		return ResponseEntity.ok(clienteService.findAll());
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value="Inserção de Cliente")
    @ApiResponses(value= {
    @ApiResponse(code=201, message="Cliente criado com sucesso"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
	public Cliente inserirCliente(@RequestBody ClienteInserirDTO novoCliente){
		return clienteService.inserir(novoCliente);
				
	}
}
