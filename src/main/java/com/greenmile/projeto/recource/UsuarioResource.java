package com.greenmile.projeto.recource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario){
		return usuarios.findById(id).map(record -> 
						{
							BeanUtils.copyProperties(usuario, record, "id");
							usuarios.save(record);
							return ResponseEntity.ok().body(record);
						})
		           .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id){
		return usuarios.findById(id).map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		return usuarios.findById(id)
		           .map(record -> {
		        	   usuarios.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}
}
