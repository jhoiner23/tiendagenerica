package com.misiontic.tiendagenerica.repository;

import com.misiontic.tiendagenerica.model.VentasDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends CrudRepository<VentasDTO, Long> {
}
