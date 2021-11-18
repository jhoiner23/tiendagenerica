package com.misiontic.tiendagenerica.controller;

import com.misiontic.tiendagenerica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class AppInicioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping({"/", "/login"})
    public String index() {
        return "index";
    }
    @GetMapping("/usuarios/registrar") // http:localhost:8080/usuarios/create
    public String create() {
        return "index";
    }
}
