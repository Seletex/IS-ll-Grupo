package co.edu.uco.transformate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.transformate.model.Gimnasio;
import co.edu.uco.transformate.repository.GimnasioRepository;
import co.edu.uco.transformate.repository.TipoDocumentoRepository;

import java.util.List;

@Service
public class GimnasioService {
	

	@Autowired
	private GimnasioRepository gimnasioRepository;


	public List<Gimnasio> findAll() {
		return gimnasioRepository.findAll();
	}


}
