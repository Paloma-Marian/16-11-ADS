package com.contato.aula1611.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contato.aula1611.entities.Contato;
import com.contato.aula1611.repository.ContatoRepository;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {
	@Autowired
	ContatoRepository repositorio;
	
	@GetMapping()
	public ResponseEntity<List<Contato>> getContato(){
		return ResponseEntity.status(HttpStatus.OK).body(repositorio.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<Contato> inserirContato(@RequestBody Contato contato){
		Contato contatoaux = repositorio.save(contato);
		return ResponseEntity.status(HttpStatus.CREATED).body(contatoaux);
	}
	
	@PutMapping("/{idcontato}")
	public ResponseEntity<Contato> alterarContato(@PathVariable("idcontato")Long idcontato, @RequestBody Contato contato){
		Optional<Contato> optionalContato = repositorio.findById(idcontato);
		try {
			Contato contatoaux = optionalContato.get();
			contatoaux.setNome(contato.getNome());
			contatoaux.setEmail(contato.getEmail());
			repositorio.save(contato);
			return ResponseEntity.status(HttpStatus.OK).body(contatoaux);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contato> getInserirContato(@PathVariable("id") long id) {
		Optional<Contato> opContato = repositorio.findById(id);
		try {
			Contato contatoaux = opContato.get();		
			return ResponseEntity.status(HttpStatus.OK).body(contatoaux);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Contato> excluirUmContato(@PathVariable("id") long id) {
		Optional<Contato> opContato = repositorio.findById(id);
		try {
			Contato contatoaux = opContato.get();	
			repositorio.delete(contatoaux);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
