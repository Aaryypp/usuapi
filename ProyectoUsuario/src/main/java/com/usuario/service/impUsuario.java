package com.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usuario.dao.daoUsuario;
import com.usuario.entity.Usuario;

@Service
public class impUsuario implements serUsuario {
	
	@Autowired
	private daoUsuario dao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) dao.findAll();
	}

	@Override
	@Transactional
	public Usuario Save(Usuario usuario) {
		// TODO Auto-generated method stub
		return dao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return dao.findById(id).orElse(null);
	}	

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);
		
	}

}
