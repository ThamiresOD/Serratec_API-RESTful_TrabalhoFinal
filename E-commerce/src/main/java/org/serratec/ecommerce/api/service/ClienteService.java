package org.serratec.ecommerce.api.service;

import java.util.List;
import java.util.Optional;

import org.serratec.ecommerce.api.config.MailConfig;
import org.serratec.ecommerce.api.domain.Cliente;
import org.serratec.ecommerce.api.domain.dto.ClienteInserirDTO;
import org.serratec.ecommerce.api.exception.ClienteNotFoundException;
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
	@Autowired
	MailConfig mailConfig;

	public Cliente inserir(ClienteInserirDTO novoClienteDTO) throws CpfException, EmailException {
		if (!clienteRepo.findByCpf(novoClienteDTO.getCpf()).isEmpty()) {
			throw new CpfException(400, "O cpf " + novoClienteDTO.getCpf() + " já existe!");
		}
		if (!findByEmail(novoClienteDTO.getEmail()).isEmpty()) {
			throw new EmailException(400, "O email já está registrado");
		}

		Cliente novoClienteDB = new Cliente();
		novoClienteDB.setNomeCompleto(novoClienteDTO.getNomeCompleto());
		novoClienteDB.setCpf(novoClienteDTO.getCpf());
		novoClienteDB.setDataNascimento(novoClienteDTO.getDataNascimento());
		novoClienteDB.setTelefone(novoClienteDTO.getTelefone());
		novoClienteDB.setEmail(novoClienteDTO.getEmail());
		novoClienteDB.setEndereco(enderecoService.buscar(novoClienteDTO.getCep(), novoClienteDTO.getNumero()));
		
		mailConfig.sendMail(novoClienteDB.getEmail(), "Pedido foi cadastrado com sucesso!", 
		"Cliente: " + novoClienteDB.getNomeCompleto() + "\nCadastrado com o cpf: " + novoClienteDB.getCpf());
		
		return clienteRepo.save(novoClienteDB);
	}

	public void deletarCliente(Long id) throws ClienteNotFoundException {
		if (clienteRepo.findById(id).isEmpty()) {
			throw new ClienteNotFoundException(404, "Cliente não encontrado");
		} else {
			clienteRepo.deleteById(id);
		}

	}

	public Cliente updateCliente(Cliente updateCliente) throws ClienteNotFoundException, CpfException, EmailException {
		Optional<Cliente> clienteDB = clienteRepo.findById(updateCliente.getId());

		if (!clienteDB.isPresent()) {
			throw new ClienteNotFoundException(404, "Cliente não encontrado");
		}
		return clienteRepo.save(updateCliente);

	}

	public List<Cliente> findAll() {
		return clienteRepo.findAll();
	}

	public Cliente findById(Long id) throws ClienteNotFoundException {
		Optional<Cliente> clienteDB = clienteRepo.findById(id);
		if (!clienteDB.isPresent()) {
			throw new ClienteNotFoundException(404, "Cliente não encontrado");
		}
		return clienteDB.get();
	}

	public List<Cliente> findByEmail(String email) {
		return clienteRepo.findByEmail(email);
	}

}
