package co.edu.uco.transformate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.transformate.model.Gimnasio;
import co.edu.uco.transformate.service.GimnasioService;
import co.edu.uco.transformate.service.TipoDocumentoService;


@RestController
@RequestMapping ("/gimnasio/")
public class GimnasioREST {

	
	@Autowired
	private GimnasioService gimnasioService;
	
	@GetMapping
	private ResponseEntity<List<Gimnasio>> getAllGimnasio (){
		return ResponseEntity.ok(gimnasioService.findAll());
	}
	
	
}
