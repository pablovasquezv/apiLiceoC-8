/**
 * 
 */
package com.complejoeducaciona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.complejoeducaciona.models.Apoderado;
import com.complejoeducaciona.services.ApoderadoService;

/**
 * @author Pablo
 *
 */
@RestController
@RequestMapping(value = ("/colegio/apoderados"))
public class ApoderadoController {
	/*
	 * Autowired:es Para decirle al servicio que estÃ¡ conectado con el repositorio
	 * que esta haciendo uso de la base de datos y de los objetos. Además, crea la
	 * inyecion de la Interfaz importada del paquete Repositorio, lo que evita la
	 * creacion de una instancia de esta.
	 **/
	@Autowired
	private ApoderadoService apoderadoService;

	@ResponseBody()
	@PostMapping("/create")
	public Apoderado addNewApoderado(@RequestBody Apoderado apoderado) {
		return apoderadoService.create(apoderado);
	}

	@GetMapping("/get/all")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<List<Apoderado>> listAllApoderados() {
		return ResponseEntity.ok(apoderadoService.getAllApoderado());
	}

}
