package com.greenmile.projeto.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenmile.projeto.model.Projeto;
import com.greenmile.projeto.repository.Projetos;

@RestController
@RequestMapping("/projetos")
public class ProjetoResource {

	@Autowired
	private Projetos projetos;
	
	@PostMapping
	public Projeto adicionar(@Valid @RequestBody Projeto projeto) {
		return projetos.save(projeto);
	}

	@GetMapping
	public List<Projeto> listar(){
		return projetos.findAll();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Projeto> atualizar(@PathVariable Long id, @RequestBody Projeto projeto){
		return projetos.findById(id).map(record -> {
			BeanUtils.copyProperties(projeto, record, "id");
			projetos.save(record);
			return ResponseEntity.ok().body(record);
		}).orElse(ResponseEntity.notFound().build());
		
	}
	
	@PutMapping("/arquivar/{/id}")
	public ResponseEntity<Projeto> arquivar(@PathVariable Long id){
		return projetos.findById(id).map(record -> {
			record.setAtivo(false);
			projetos.save(record);
			return ResponseEntity.ok().body(record);
		}).orElse(ResponseEntity.notFound().build());
	}
	
}
