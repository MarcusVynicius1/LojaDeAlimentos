package br.edu.iff.LojaDeAlimentos.controller.apirest;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class MainRestController {
	
	@GetMapping
	@ResponseBody
	public String initial() {
		return "teste";
	}
	
	/*
	@GetMapping("/{id}")
	public String page (@PathVariable("id") int id) {
		return "teste " + id;
	}
	
	
	@GetMapping("/{id}")
	public String page2 (@PathVariable("id") int id, @RequestParam("nome") String nome) {
		return "teste " + id + " nome " + nome;
	}
	*/
	
	@PostMapping("/new")
	@ResponseBody
	public String addItem(@RequestParam Map<String, String> allParams) {
		return "Os parametros foram " + allParams.entrySet();
	}
}
