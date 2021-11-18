package com.misiontic.tiendagenerica.service;

import com.misiontic.tiendagenerica.model.UsuariosDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public final class CustomUserDetails implements UserDetails {
    private UsuariosDTO usuariosDTO;

    public CustomUserDetails(UsuariosDTO usuariosDTO) {
        this.usuariosDTO = usuariosDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return usuariosDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return usuariosDTO.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return usuariosDTO.getNombre_usuario();
    }
}
