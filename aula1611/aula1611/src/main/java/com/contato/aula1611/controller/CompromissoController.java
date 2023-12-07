package com.contato.aula1611.controller;

import java.time.LocalDate;
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

import com.contato.aula1611.entities.Compromisso;
import com.contato.aula1611.entities.Contato;
import com.contato.aula1611.entities.Local;
import com.contato.aula1611.repository.CompromissoRepository;
import com.contato.aula1611.repository.ContatoRepository;
import com.contato.aula1611.repository.LocalRepository;

@RestController
@RequestMapping(value = "/compromisso")
public class CompromissoController {
	@Autowired
	private CompromissoRepository repositorio;
	
	@Autowired
	private LocalRepository localRepositorio;
	
	@Autowired
	private ContatoRepository contatoRepositorio;
	
	@GetMapping
	public List<Compromisso> MostraTodosCompromissos(){
		return repositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public Compromisso getBuscaCompromisso(@PathVariable("id") long id) {
		Optional<Compromisso> opCompromisso = repositorio.findById(id);
        if (opCompromisso.isPresent()) {
            return opCompromisso.get();
        }
        return null;
	}
	
	@PostMapping
	public ResponseEntity<Compromisso> inserirCompromisso(@RequestBody Compromisso compromisso){
		Compromisso compromissoaux = repositorio.save(compromisso);
		return ResponseEntity.status(HttpStatus.CREATED).body(compromissoaux);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Compromisso> excluirCompromisso(@PathVariable("id") long id) {
		Optional<Compromisso> optionalCompromisso = repositorio.findById(id);
		try {
			Compromisso compromissoaux = optionalCompromisso.get();	
			repositorio.delete(compromissoaux);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{idcompromisso}")
	public ResponseEntity<Compromisso> alterarCompromisso(@PathVariable("idcompromisso")Long idcompromisso, @RequestBody Compromisso compromisso){
		Optional<Compromisso> optionalCompromisso = repositorio.findById(idcompromisso);
		try {
			Compromisso compromissoaux = optionalCompromisso.get();
			compromissoaux.setLocal(compromisso.getLocal());
			compromissoaux.setContato(compromisso.getContato());
			compromissoaux.setData(compromisso.getData());
			compromissoaux.setHora(compromisso.getHora());
			compromissoaux.setStatus(compromisso.getStatus());
			repositorio.save(compromisso);
			return ResponseEntity.status(HttpStatus.OK).body(compromissoaux);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
	}
	
    @GetMapping("/{local_id}/{contato_id}")
    public List<Compromisso> getFiltraCompromisso(@PathVariable("local_id") long idLocal, 
    		@PathVariable("contato_id") long idContato) {
    	Optional<Local> local = localRepositorio.findById(idLocal);
    	Optional<Contato> contato = contatoRepositorio.findById(idContato);
        if (local.isPresent()) {
            return repositorio.getFiltraCompromisso(local.get(),contato.get());
        }
        return null;
    }
    
    @GetMapping("/data/{inicial}/{fim}")
    public List<Compromisso> getCompromissoPorData(@PathVariable("inicial") LocalDate inicial, 
    		@PathVariable("fim") LocalDate fim) {
        return repositorio.getFiltrarCompromissoPorData(inicial, fim);
    }
    
    @PutMapping("/cancelar/{id}")
    public Compromisso cancelarCompromisso(@PathVariable("id") long id) {
    	Compromisso compromissoaux = getBuscaCompromisso(id);
        if (compromissoaux != null) {
            compromissoaux.setStatus("CANCELADO");
            return repositorio.save(compromissoaux);
        }
        return null;
    }
}
