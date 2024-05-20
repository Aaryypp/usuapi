package com.usuario.service;

import java.util.List;

import com.usuario.entity.Usuario;

public interface serUsuario {
	public List<Usuario> findAll();
	public Usuario Save(Usuario id);
	public Usuario findById(Long id);
	public void delete(Long id);

}
