package com.programacion.web.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.web.service.IVehiculoService;
import com.programacion.web.service.to.VehiculoTO;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoController {

	@Autowired
	private IVehiculoService iVehiculoService;
	
	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTO> buscarPorPlaca(@PathVariable String placa){
		return ResponseEntity.status(HttpStatus.OK).body(this.iVehiculoService.buscarPlaca(placa));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTO>> buscarTodos(){
		List<VehiculoTO> v = this.iVehiculoService.buscarTodos();
		for(VehiculoTO v1 : v) {
			Link miLink = linkTo(methodOn(VehiculoController.class).buscarPorPlaca(v1.getPlaca())).withSelfRel();
			v1.add(miLink);
		}
		return new ResponseEntity(v,null,200);
	} 
}
