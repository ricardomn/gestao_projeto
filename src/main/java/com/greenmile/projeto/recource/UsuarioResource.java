package com.greenmile.projeto.recource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenmile.projeto.model.Usuario;
import com.greenmile.projeto.repository.Usuarios;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private Usuarios usuarios;
	
	@PostMapping
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
		return usuarios.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> listar(){
		return usuarios.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id){
		Usuario usuario = usuarios.getOne(id);
		
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Usuario usuario = usuarios.getOne(id);
		
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		usuarios.delete(usuario);
		
		return ResponseEntity.noContent().build();
	}
}
