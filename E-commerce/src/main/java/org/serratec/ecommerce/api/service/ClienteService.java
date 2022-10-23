package org.serratec.ecommerce.api.service;

import java.util.List;

import org.serratec.ecommerce.api.domain.Cliente;
import org.serratec.ecommerce.api.domain.dto.ClienteInserirDTO;
import org.serratec.ecommerce.api.exception.UniqueCpfException;
import org.serratec.ecommerce.api.exception.UniqueEmailException;
import org.serratec.ecommerce.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	EnderecoService enderecoService;
	
	public Cliente inserir(ClienteInserirDTO novoClienteDTO) throws UniqueCpfException, UniqueEmailException{
		if(!findByCpf(novoClienteDTO.getCpf()).isEmpty()) {
			throw new UniqueCpfException(400,"O cpf " + novoClienteDTO.getCpf() + " já existe!");
		}
		if(!findByEmail(novoClienteDTO.getEmail()).isEmpty()) {
			throw new UniqueEmailException(400, "O email já está registrado");
		}
		Cliente novoClienteDB = new Cliente();
		novoClienteDB.setNomeCompleto(novoClienteDTO.getNomeCompleto());
		novoClienteDB.setCpf(novoClienteDTO.getCpf());
		novoClienteDB.setDataNascimento(novoClienteDTO.getDataNascimento());
		novoClienteDB.setTelefone(novoClienteDTO.getTelefone());
		novoClienteDB.setEmail(novoClienteDTO.getEmail());
		novoClienteDB.setEndereco(enderecoService.buscar(novoClienteDTO.getCep(), novoClienteDTO.getNumero()));
		return clienteRepo.save(novoClienteDB);
	}
	
	public List<Cliente> findAll(){
		return clienteRepo.findAll();
	}
	
	public List<Cliente> findByCpf(String cpf){
		return clienteRepo.findByCpf(cpf);
	}
	
	public List<Cliente> findByEmail(String email){
		return clienteRepo.findByEmail(email);
	}
}
