package com.misiontic.tiendagenerica.repository;

import com.misiontic.tiendagenerica.model.ProductosDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends CrudRepository<ProductosDTO, Long> {
}
