package org.farmaciagrupo2.farmaciaGrupo2.repository;

import java.util.List;

import org.farmaciagrupo2.farmaciaGrupo2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String produto);

}

