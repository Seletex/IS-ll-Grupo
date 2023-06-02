package co.edu.uco.transformate.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.transformate.api.controller.response.Response;

import co.edu.uco.transformate.api.validator.entrenador.RegisterEntrenadorValidation;
import co.edu.uco.transformate.business.facade.EntrenadorFacade;
import co.edu.uco.transformate.business.facade.impl.EntrenadorFacadeImpl;
import co.edu.uco.transformate.crosscutting.exception.TransformateApiException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.dto.EntrenadorDTO;

@RestController
@RequestMapping("transformate/api/v1/entrenador")
public class EntrenadorController {

	private final Logger log = LoggerFactory.getLogger(EntrenadorController.class);

	private EntrenadorFacade facade;

	@GetMapping("/dummy")

	public EntrenadorDTO dummy() {
		return EntrenadorDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<EntrenadorDTO>> list(
			@RequestBody EntrenadorDTO dto) {
		final List<EntrenadorDTO> list = new ArrayList<>();
		list.add(EntrenadorDTO.create());
		list.add(EntrenadorDTO.create());
		list.add(EntrenadorDTO.create());
		list.add(EntrenadorDTO.create());

		final List<String> messages = new ArrayList<>();
		messages.add("Estado de tipo relacion institucion consultados existosamente");
		final Response<EntrenadorDTO> response = new Response<>(list, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Response<EntrenadorDTO>> listById(@RequestBody EntrenadorDTO dto) {
		var statusCode = HttpStatus.OK;
		final var response = new Response<EntrenadorDTO>();
		
		try {
	
			throw TransformateApiException.create("Se ha consultado con exito");
			
			}catch (final TransformateException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessageStrings().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat("-").concat(exception.getTechnicalMessage()));

		} catch (final Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessageStrings().add("Se ha presentado un problema inesperado.Porfavor intentar de nuevo");
			log.error("Se ha presntado un problem inesperado. Porfavor validar la consola");
		}
		return new ResponseEntity<>(response,statusCode);
	}
	
	@PostMapping
	public ResponseEntity<Response<EntrenadorDTO>> create(
			@RequestBody EntrenadorDTO dto) {
		var statusCode = HttpStatus.OK;
		final var response = new Response<EntrenadorDTO>();

		try {
			final	var result = RegisterEntrenadorValidation.validate(dto);
			if (result.getMessages().isEmpty()) {
				facade = new EntrenadorFacadeImpl();
				facade.create(dto);
				response.getMessageStrings()
						.add("El nuevo estado tipo relacion institucion se ha registrado de forma satisfacoria");

			} else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessageStrings(( result).getMessages());
			}
		} catch (final TransformateException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessageStrings().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat("-").concat(exception.getTechnicalMessage()));

		} catch (final Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessageStrings().add("Se ha presentado un problema inesperado.Porfavor intentar de nuevo");
			log.error("Se ha presntado un problem inesperado. Porfavor validar la consola");
		}
		return new ResponseEntity<>(response, statusCode);
	}
	
	@PutMapping("/{id}")
	public EntrenadorDTO update(@PathVariable UUID id,
			@RequestBody EntrenadorDTO dto) {
		return dto.setIdentificador(id);
	}

	@DeleteMapping("/{id}")
	public EntrenadorDTO update(@PathVariable UUID id) {
		return EntrenadorDTO.create().setIdentificador(id);
	}
}
