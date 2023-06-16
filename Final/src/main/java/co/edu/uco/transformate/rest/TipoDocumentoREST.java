package co.edu.uco.transformate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.transformate.model.Gimnasio;
import co.edu.uco.transformate.model.TipoDocumento;
import co.edu.uco.transformate.service.TipoDocumentoService;


@RestController
@RequestMapping ("/documento/")
public class TipoDocumentoREST {

	
	@Autowired
	private TipoDocumentoService documentoService;
	
	@GetMapping
	private ResponseEntity<List<TipoDocumento>> getAllDocumento (){
		return ResponseEntity.ok(documentoService.findAll());
	}
	
	
}
