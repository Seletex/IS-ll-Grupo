package co.edu.uco.transformate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import co.edu.uco.transformate.model.Entrenador;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long>{

}
