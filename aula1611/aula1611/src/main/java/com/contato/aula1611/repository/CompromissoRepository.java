package com.contato.aula1611.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.contato.aula1611.entities.Compromisso;
import com.contato.aula1611.entities.Contato;
import com.contato.aula1611.entities.Local;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {
	@Query("SELECT comp FROM Compromisso comp WHERE comp.local = :local AND comp.contato = :contato")
    List<Compromisso> getFiltraCompromisso(@Param("local") Local local,@Param("contato") Contato contato);
	
	@Query("SELECT c FROM Compromisso c WHERE c.data BETWEEN :data_inicial AND :data_final")
    List<Compromisso> getFiltrarCompromissoPorData(@Param("data_inicial") LocalDate data_inicial, @Param("data_final") LocalDate data_final);
}
