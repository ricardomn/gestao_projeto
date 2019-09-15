package com.greenmile.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenmile.projeto.model.Projeto;

public interface Projetos extends JpaRepository<Projeto, Long> {
	List<Projeto> findByAtivoTrue();
}
