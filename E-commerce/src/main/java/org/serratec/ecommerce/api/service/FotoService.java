package org.serratec.ecommerce.api.service;

import java.io.IOException;
import java.util.Optional;

import org.serratec.ecommerce.api.domain.Foto;
import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoService {
	@Autowired
	private FotoRepository fotoRepository;

	public Foto inserir(Produto produto, MultipartFile file) throws IOException {
		Foto foto = new Foto();
		foto.setProduto(produto);
		foto.setNome(file.getName());
		foto.setTipo(file.getContentType());
		foto.setDados(file.getBytes());
		foto = fotoRepository.save(foto);
		return foto;
	}

	public Optional<Foto> buscarPorIdProduto(Long id){
		Optional<Foto> fotoEncontrada = fotoRepository.findByIdProduto(id);
		return fotoEncontrada;
	}
//	@Transactional
//	public Foto buscarPorIdProduto(Long id) {
//		Produto produto = new Produto();
//		produto.setId(id);
//		Optional<Foto> foto = fotoRepository.findByProduto(produto);
//		if (foto.isPresent()) {
//			return null;
//		}
//		return foto.get();
//	}
//	
	public void deleteFoto(Long id) {
		fotoRepository.deleteById(id);;
	}

}
