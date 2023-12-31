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

import com.contato.aula1611.entities.Local;
import com.contato.aula1611.repository.LocalRepository;

@RestController
@RequestMapping(value = "/locais")
public class LocalController {
	@Autowired
	LocalRepository repositorio;
	
	@GetMapping()
	public ResponseEntity<List<Local>> getLocais() {
		return ResponseEntity.status(HttpStatus.OK).body(repositorio.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<Local> inserirLocal(@RequestBody Local local){
		Local localaux = repositorio.save(local);
		return ResponseEntity.status(HttpStatus.CREATED).body(localaux);
	}
	
	@PutMapping("/{idlocal}")
	public ResponseEntity<Local> alterarLocal(@PathVariable("idlocal")Long idlocal, @RequestBody Local local){
		Optional<Local> optionalLocal = repositorio.findById(idlocal);
		try {
			Local localaux = optionalLocal.get();
			localaux.setNome(local.getNome());
			localaux.setRua(local.getRua());
			localaux.setNumero(local.getNumero());
			localaux.setBairro(local.getBairro());
			localaux.setCep(local.getCep());
			localaux.setCidade(local.getCidade());
			repositorio.save(localaux);
			return ResponseEntity.status(HttpStatus.OK).body(localaux);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Local> getBuscaLocal(@PathVariable("id") long id){
		Optional<Local> optionalLocal = repositorio.findById(id);
		try {
			Local localaux = optionalLocal.get();
			return ResponseEntity.status(HttpStatus.OK).body(localaux);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Local> excluirLocal(@PathVariable("id") long id){
		Optional<Local> optionalLocal = repositorio.findById(id);
		try {
			Local localaux = optionalLocal.get();
			repositorio.delete(localaux);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
