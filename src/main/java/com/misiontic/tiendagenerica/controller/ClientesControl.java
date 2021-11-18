package com.misiontic.tiendagenerica.controller;

import com.misiontic.tiendagenerica.model.ClienteDTO;
import com.misiontic.tiendagenerica.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Clientes")
public final class ClientesControl {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listar")
    public ArrayList<ClienteDTO> listaClientes(){
        ArrayList<ClienteDTO> list = (ArrayList<ClienteDTO>) clienteRepository.findAll();
       list.removeIf( cliente -> (cliente.getDisabled()) );
        return list;
    }

    @PostMapping("/registrar")
    public ClienteDTO crearUsuarios(@RequestBody ClienteDTO Cliente) {
        return this.clienteRepository.save(Cliente);
    }

    @DeleteMapping( path = "eliminar/{cedula_usuario}")
    public void eliminarPorId(@PathVariable("cedula_usuario") Long cedula_usuario){
        ClienteDTO cliente = clienteRepository.findById(cedula_usuario).get();
        cliente.setDisabled(true);
        actualizar(cliente);
    }

    @PutMapping("/actualizar")
    public ClienteDTO actualizar(@RequestBody ClienteDTO cliente) {
        return this.clienteRepository.save(cliente);
    }

/*
 	@GetMapping( path = "/search/{cedula_cliente}")
    public ArrayList<ClienteDTO> obtenerclientes( String cedula_cliente) {
        return this.repository.findAllById(cedula_cliente+"");

    }*/


}
