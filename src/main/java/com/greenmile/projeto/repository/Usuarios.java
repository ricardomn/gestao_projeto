package com.greenmile.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenmile.projeto.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{

}
