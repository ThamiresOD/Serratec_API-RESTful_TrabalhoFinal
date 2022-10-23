package org.serratec.ecommerce.api.service;

import java.util.List;

import org.serratec.ecommerce.api.config.MailConfig;
import org.serratec.ecommerce.api.domain.Cliente;
import org.serratec.ecommerce.api.domain.dto.ClienteInserirDTO;
import org.serratec.ecommerce.api.exception.CpfException;
import org.serratec.ecommerce.api.exception.EmailException;
import org.serratec.ecommerce.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	EnderecoService enderecoService;
	
	public Cliente inserir(ClienteInserirDTO novoClienteDTO) throws EmailException, throws CpfException{ 
		Cliente clienteBanco = clienteRepository.findByEmail(novoClienteDTO.getEmail());
		if (clienteBanco!=null) {
			throw new EmailException("Já existe um cliente com esse mesmo e-mail registrado!" + novoClienteDTO.getEmail());
		}
		Cliente clienteCpf = clienteRepository.findByCpf(novoClienteDTO.getCpf());
		if (clienteCpf!=null) {
			throw new CpfException("Já existe um cliente com esse mesmo cpf registrado!" + novoClienteDTO.getCpf());
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
}
