package com.misiontic.tiendagenerica.service;
import com.misiontic.tiendagenerica.model.UsuariosDTO;
import com.misiontic.tiendagenerica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService  {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        UsuariosDTO usuariosDTO = usuarioRepository.findByUser(usuario);
        if (usuariosDTO == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(usuariosDTO);
    }
}
