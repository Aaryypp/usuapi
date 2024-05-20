package com.usuario.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.usuario.entity.Usuario;
import com.usuario.service.serUsuario;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/usuario")
public class ctrlUsuario {
	
	@Autowired
	private serUsuario ser;
	
	@GetMapping("/usuarios")
	public List<Usuario> listar(){
		return ser.findAll();
	}
	
	
	@GetMapping("/usuarios/{id}")
	public Usuario buscar(@PathVariable Long id) {
		return ser.findById(id);
	}
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario body) {
		return ser.Save(body);
	}
	
	@PutMapping("/alquileres/{id}")
	public Usuario actualizar(@RequestBody Usuario body, @PathVariable Long id) {
		Usuario rpd = ser.findById(id);
	rpd.setNombre(body.getNombre());
	rpd.setEmail(body.getEmail());
	rpd.setClave(body.getClave());
	rpd.setEstado(body.isEstado());
	return ser.Save(rpd);
	
	}
	
	
	

}
