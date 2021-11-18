package com.misiontic.tiendagenerica.service;

import com.misiontic.tiendagenerica.model.ClienteDTO;
import com.misiontic.tiendagenerica.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public final class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ArrayList<ClienteDTO> listar(){
        return (ArrayList<ClienteDTO>) clienteRepository.findAll();
    }
    public ClienteDTO createRegister(ClienteDTO clientes) {
        return clienteRepository.save(clientes);
    }
    public Optional<ClienteDTO> getRegisterForID(Long id){
        return clienteRepository.findById(id);
    }
    public boolean deleteRegister(Long id) {
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    public ClienteDTO updateRegister(ClienteDTO clienteRepo) {
        return clienteRepository.save(clienteRepo);
    }
}
