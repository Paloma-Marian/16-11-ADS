package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {

}
