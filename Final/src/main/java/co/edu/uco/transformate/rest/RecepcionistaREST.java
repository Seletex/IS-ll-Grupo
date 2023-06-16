package co.edu.uco.transformate.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.transformate.model.Entrenador;
import co.edu.uco.transformate.service.EntrenadorService;
@RestController
@RequestMapping("/recepcionista/")
public class RecepcionistaREST {
	@Autowired
	private EntrenadorService entrenadorService;
	
	@GetMapping
	private ResponseEntity<List<Entrenador>> getAllEntrenador (){
		return ResponseEntity.ok(entrenadorService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Entrenador> saveEntrenador (@RequestBody Entrenador entrenador){
		try {
			Entrenador entrenadorGuardado = entrenadorService.save(entrenador);		
		return ResponseEntity.created(new URI("/personas/"+entrenadorGuardado.getId())).body(entrenadorGuardado );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteEntrenador (@PathVariable ("id") Long id){
		return ResponseEntity.ok(entrenadorService.deleteById(id));
	}
}
