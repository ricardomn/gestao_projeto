package com.greenmile.projeto.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenmile.projeto.model.UsuariosDoProjeto;
import com.greenmile.projeto.repository.UsuariosDosProjetos;

@RestController
@RequestMapping("/usuarios_do_projeto")
public class UsuariosDoProjetoResource {
	
	@Autowired
	private UsuariosDosProjetos usuarios;
	
	@PostMapping
	public UsuariosDoProjeto adicionar(@Valid @RequestBody UsuariosDoProjeto projeto) {
		return usuarios.save(projeto);
	}
}
