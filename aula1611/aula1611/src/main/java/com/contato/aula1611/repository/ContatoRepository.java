package com.contato.aula1611.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contato.aula1611.entities.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
