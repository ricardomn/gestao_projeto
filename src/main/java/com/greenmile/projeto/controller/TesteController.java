package com.greenmile.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {

	@GetMapping("/teste")
	public String listar() {
		return "ListaTeste";
	}
	
}
