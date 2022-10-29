package org.serratec.ecommerce.api.service;

import java.util.Optional;

import org.serratec.ecommerce.api.domain.Endereco;
import org.serratec.ecommerce.api.domain.dto.EnderecoViaCepDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

	public Endereco buscar(String cep, String numero) {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "http://viacep.com.br/ws/" + cep + "/json";
			//Busca o cep na ViaCep e retorna um objeto que vira uma instância de EnderecoViaCepDTO
			Optional<EnderecoViaCepDTO> novoEnderecoViaCep = Optional.ofNullable(restTemplate.getForObject(uri, EnderecoViaCepDTO.class));
			if (novoEnderecoViaCep != null) {
				//enderecoViaCep é convertido em uma instância de Endereco 
				Endereco novoEndereco = new Endereco(novoEnderecoViaCep.get(), numero); 
				//Insere Endereco no banco de dados
				return novoEndereco;
			} else {
				return null;
			}
		
	}


}