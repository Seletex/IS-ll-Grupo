package co.edu.uco.transformate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import co.edu.uco.transformate.model.Recepcionista;
import co.edu.uco.transformate.repository.RecepcionistaRepository;

public class RecepcionistaService {
	@Autowired
	private RecepcionistaRepository personaRepository;

	public List<Recepcionista> findAll() {
		return personaRepository.findAll();
	}

	public List<Recepcionista> findAll(Sort sort) {
		return personaRepository.findAll(sort);
	}


	public Page<Recepcionista> findAll(Pageable pageable) {
		return personaRepository.findAll(pageable);
	}

	public <S extends Recepcionista> S save(S entity) {
		return personaRepository.save(entity);
	}

	public Optional<Recepcionista> findById(Long id) {
		return personaRepository.findById(id);
	}


	public Boolean deleteById(Long id) {
		if (personaRepository.existsById(id)) {
			personaRepository.deleteById(id);
			return !personaRepository.existsById(id);
		}
		return false;
	}

	public void delete(Recepcionista entity) {
		personaRepository.delete(entity);
	}
}
