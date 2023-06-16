package co.edu.uco.transformate.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.transformate.api.model.TipoDocumento;
import co.edu.uco.transformate.api.service.TipoDocumentoService;

@RestController
@RequestMapping("tipodocumento")
public class TipoDocumentoREST {
	
	@Autowired
	private TipoDocumentoService documentoService;
	
	@GetMapping
	private ResponseEntity<List<TipoDocumento>> getAllTipoDocumentos(){
		return ResponseEntity.ok(documentoService.findAll());
	}
}
