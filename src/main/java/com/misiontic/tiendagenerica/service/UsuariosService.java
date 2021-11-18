package com.misiontic.tiendagenerica.service;

import com.misiontic.tiendagenerica.model.UsuariosDTO;
import com.misiontic.tiendagenerica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public final class UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public ArrayList<UsuariosDTO> listar(){
        return (ArrayList<UsuariosDTO>) usuarioRepository.findAll();
    }
    public UsuariosDTO crearUsuarios(UsuariosDTO usuarios) {
        return usuarioRepository.save(usuarios);
    }
    public UsuariosDTO ActualizarUsuarios(UsuariosDTO usuarios) {
        return usuarioRepository.save(usuarios);
    }

    public Optional<UsuariosDTO> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
