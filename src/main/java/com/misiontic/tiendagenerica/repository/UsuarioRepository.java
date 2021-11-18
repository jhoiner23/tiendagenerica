package com.misiontic.tiendagenerica.repository;

import com.misiontic.tiendagenerica.model.UsuariosDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuariosDTO, Long> {
    @Query("SELECT u FROM UsuariosDTO u WHERE u.usuario = ?1")
    public UsuariosDTO findByUser(String email);
}
