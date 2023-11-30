package com.example.Aula.controller;

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

import com.example.Aula.entities.Contato;
import com.example.Aula.entities.Local;
import com.example.Aula.repository.LocalRepository;

@RestController
@RequestMapping("/locais")
public class LocalController {
	@Autowired
	LocalRepository repo;
	
	@GetMapping()
	public ResponseEntity<List<Local>> getLocais() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
		
	@PostMapping()
	public ResponseEntity<Local> inserirContato(@RequestBody Local local) {
		Local ct = repo.save(local);
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}
	
	@PutMapping("/{idlocal}")
	public ResponseEntity<Local> alterarContato(@PathVariable("idlocal") Long idcontato, 
			@RequestBody Local local) {
		Optional<Local> opLocal = repo.findById(idcontato);
		try {
			Local ct = opLocal.get();		
			/*ct.setNome(local.getNome());
			ct.setEmail(local.getEmail());
			repo.save(ct);*/
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Local> getUmContato(@PathVariable("id") long id) {
		Optional<Local> opLocal = repo.findById(id);
		try {
			Local ct = opLocal.get();		
			return ResponseEntity.status(HttpStatus.OK).body(ct);
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Local> excluirUmContato(@PathVariable("id") long id) {
		Optional<Local> opLocal = repo.findById(id);
		try {
			Local ct = opLocal.get();	
			repo.delete(ct);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
