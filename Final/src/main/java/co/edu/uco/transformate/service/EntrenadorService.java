package co.edu.uco.transformate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.edu.uco.transformate.model.Entrenador;
import co.edu.uco.transformate.repository.EntrenadorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {
	
	
	@Autowired
	private EntrenadorRepository personaRepository;

	public List<Entrenador> findAll() {
		return personaRepository.findAll();
	}

	public List<Entrenador> findAll(Sort sort) {
		return personaRepository.findAll(sort);
	}


	public Page<Entrenador> findAll(Pageable pageable) {
		return personaRepository.findAll(pageable);
	}

	public <S extends Entrenador> S save(S entity) {
		return personaRepository.save(entity);
	}

	public Optional<Entrenador> findById(Long id) {
		return personaRepository.findById(id);
	}


	public Boolean deleteById(Long id) {
		if (personaRepository.existsById(id)) {
			personaRepository.deleteById(id);
			return !personaRepository.existsById(id);
		}
		return false;
	}

	public void delete(Entrenador entity) {
		personaRepository.delete(entity);
	}


	

}
