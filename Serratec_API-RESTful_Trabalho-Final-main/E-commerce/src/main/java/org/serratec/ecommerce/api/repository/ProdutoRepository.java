package org.serratec.ecommerce.api.repository;

import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.domain.dto.ProdutoInserirDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findById(Produto produto);

	ProdutoInserirDTO save(ProdutoInserirDTO produto);

}
