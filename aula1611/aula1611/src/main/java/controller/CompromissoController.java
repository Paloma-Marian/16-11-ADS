package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repository.CompromissoRepository;
import entities.Compromisso;

@RestController
@RequestMapping(value = "/compromisso")
public class CompromissoController {
	@Autowired
	private CompromissoRepository repositorio;
	
	@GetMapping
	public List<Compromisso> findAll(){
		return repositorio.findAll();
	}
}
