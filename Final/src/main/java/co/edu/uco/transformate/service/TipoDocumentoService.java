package co.edu.uco.transformate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uco.transformate.model.TipoDocumento;
import co.edu.uco.transformate.repository.TipoDocumentoRepository;

import java.util.List;

@Service
public class TipoDocumentoService {
	

	@Autowired
	private TipoDocumentoRepository documentoRepository;


	public List<TipoDocumento> findAll() {
		return documentoRepository.findAll();
	}


}
