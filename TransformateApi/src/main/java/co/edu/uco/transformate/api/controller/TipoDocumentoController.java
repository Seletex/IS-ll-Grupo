package co.edu.uco.transformate.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.transformate.api.controller.response.Response;
import co.edu.uco.transformate.business.facade.TipoDocumentoFacade;
import co.edu.uco.transformate.crosscutting.exception.TransformateApiException;
import co.edu.uco.transformate.crosscutting.exception.TransformateException;
import co.edu.uco.transformate.dto.TipoDocumentoDTO;


@RestController
@RequestMapping("transformate/api/v1/tipodocumento")
public class TipoDocumentoController {

	private final Logger log = LoggerFactory.getLogger(TipoDocumentoController.class);

	private TipoDocumentoFacade facade;

	@GetMapping("/dummy")

	public TipoDocumentoDTO dummy() {
		return TipoDocumentoDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<TipoDocumentoDTO>> list(
			@RequestBody TipoDocumentoDTO dto) {
		final List<TipoDocumentoDTO> list = new ArrayList<>();
		list.add(TipoDocumentoDTO.create());
		list.add(TipoDocumentoDTO.create());
		list.add(TipoDocumentoDTO.create());
		list.add(TipoDocumentoDTO.create());

		final List<String> messages = new ArrayList<>();
		messages.add("Estado de tipo relacion institucion consultados existosamente");
		final Response<TipoDocumentoDTO> response = new Response<>(list, messages);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Response<TipoDocumentoDTO>> listById(@RequestBody TipoDocumentoDTO dto) {
		var statusCode = HttpStatus.OK;
		final var response = new Response<TipoDocumentoDTO>();
		
		try {
			//final var result = RegistrarEstadoTipoRelacionInstitucionValidation.validate(dto);
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
}
