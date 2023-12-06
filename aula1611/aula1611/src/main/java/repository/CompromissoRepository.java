package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Compromisso;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {

}
