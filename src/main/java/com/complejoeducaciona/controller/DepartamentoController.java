/**
 * 
 */
package com.complejoeducaciona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.complejoeducaciona.modelosIngope.Departamento;
import com.complejoeducaciona.services.DepartamentoService;

/**
 * @author Pablo
 *
 */
@RestController
@RequestMapping(value = ("/colegio/departamento"))
public class DepartamentoController {
	/*
	 * Autowired:es Para decirle al servicio que estÃ¡ conectado con el repositorio
	 * que esta haciendo uso de la base de datos y de los objetos. Además, crea la
	 * inyecion de la Interfaz importada del paquete Repositorio, lo que evita la
	 * creacion de una instancia de esta.
	 **/
	@Autowired
	private DepartamentoService departamentoService;

	// Método para crear un Departamento
	@PostMapping("/create")
	@ResponseBody()
	public Departamento addNewDepartamento(@RequestBody Departamento medicionGlucosa) {
		return departamentoService.create(medicionGlucosa);
	}

	// Método para Modificar un Departamento
	@PutMapping("/update")
	@ResponseBody()
	private void updateDepartamento(@RequestBody Departamento departamento) {
		// TODO Auto-generated method stub
		departamentoService.modificar(departamento);
	}

	// Listar Todos los departamentos
	@GetMapping("/get/all")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<List<Departamento>> listAllDepartametos() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(departamentoService.getAllDepartamentos());
	}

	// Eliminar los Departamentos
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	private boolean deleteById(@PathVariable("id") Long id) {
		// TODO Auto-generated method stub
		departamentoService.findById(id).ifPresent(o -> departamentoService.deleteDepartamento(o));
		return true;
	}

	// Buscar por id
	@GetMapping(value = "/buscar/{id}")
	private ResponseEntity<Optional<Departamento>> listDepartamentoPorId(@PathVariable("id") Long id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(departamentoService.findById(id));
	}

}
