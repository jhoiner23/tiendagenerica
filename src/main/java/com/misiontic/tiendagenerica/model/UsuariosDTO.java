package com.misiontic.tiendagenerica.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuarios")
public final class UsuariosDTO {
    @Id
    private Long cedula_usuario;

    private String email_usuario;
    private String nombre_usuario;
    private String password;
    private String usuario;
    private Boolean disabled = false;
	public Long getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(Long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}



}
