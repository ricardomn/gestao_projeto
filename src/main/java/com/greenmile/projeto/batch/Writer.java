package com.greenmile.projeto.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.greenmile.projeto.model.Importacao;
import com.greenmile.projeto.repository.Importacoes;


@Component
public class Writer implements ItemWriter {

	@Autowired
	private Importacoes userRepository;

	@Override
	public void write(List items) throws Exception {
		System.out.println("Data saved for users: " + items);
		
		for (Object object : items) {
			Importacao objeto = (Importacao) object;
			userRepository.save(objeto);
		}
		
	}

}