package com.misiontic.tiendagenerica.controller;

import com.misiontic.tiendagenerica.model.UsuariosDTO;
import com.misiontic.tiendagenerica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/usuarios")
public final class UsuarioController {


    @Autowired
    private UsuarioRepository repository;

    //consultar_la_lista_usuarios
    @RequestMapping("/listar")
    public ArrayList<UsuariosDTO> listar(){
        ArrayList<UsuariosDTO> list = (ArrayList<UsuariosDTO>) repository.findAll();
        list.removeIf( user -> (user.getDisabled()) );
        return list;
    }

    @PostMapping("/registrar")
    public UsuariosDTO cregistrar(@RequestBody UsuariosDTO usuarios) {
        return this.repository.save(usuarios);
    }

    @RequestMapping("/save")
    public String save(UsuariosDTO usuariosDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(usuariosDTO.getPassword());
        usuariosDTO.setPassword(encodedPassword);
        repository.save(usuariosDTO);

        return "register_success";
    }

    @DeleteMapping( path = "/eliminar/{cedula_usuario}")
    public void eliminar(@PathVariable("cedula_usuario") Long id){
        UsuariosDTO user = repository.findById(id).get();
        user.setDisabled(true);
        actualizar(user);
    }


    @PutMapping("/actualizar")
    public void actualizar(@RequestBody UsuariosDTO usuarios) {
        this.repository.save(usuarios);
    }
}
