package org.serratec.ecommerce.api.repository;

import java.util.Optional;

import org.serratec.ecommerce.api.domain.Foto;
import org.serratec.ecommerce.api.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

	Optional<Foto> findByProduto(Produto produto);

}
