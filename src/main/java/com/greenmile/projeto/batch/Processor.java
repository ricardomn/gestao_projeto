package com.greenmile.projeto.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.greenmile.projeto.model.Importacao;

@Component
public class Processor implements ItemProcessor<Importacao, Importacao> {
	private static final Logger log = LoggerFactory.getLogger(Processor.class);

	@Override
	public Importacao process(Importacao registro) throws Exception {
		log.info("Converting (" + registro + ")" );
		return registro;
	}
}