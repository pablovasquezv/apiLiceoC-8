/**
 * 
 */
package com.complejoeducaciona.controller;

import java.util.List;

import com.complejoeducaciona.impl.ICursoImpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.complejoeducaciona.models.Curso;
import com.complejoeducaciona.services.CursoService;

import javax.validation.Valid;

/**
 * @author Pablo
 *
 */
@RestController
@RequestMapping(value = ("/colegio/curso"))
public class CursoController {
	/*
	 * Autowired:es Para decirle al servicio que estÃ¡ conectado con el repositorio
	 * que esta haciendo uso de la base de datos y de los objetos. Además, crea la
	 * inyecion de la Interfaz importada del paquete Repositorio, lo que evita la
	 * creacion de una instancia de esta.
	 **/
	@Autowired
	private ICursoImpleService iCursoImpleService;
	//private CursoService cursoService;
	
	// Método para crear un Curso
	@ResponseBody
	@PostMapping("/create")
	public Curso addNewCurso(@Valid @RequestBody Curso curso) {
		// TODO Auto-generated method stub
		//return cursoService.create(curso);
		return iCursoImpleService.save(curso);
	}
	
	// Método para actualizar un Curso
	@PutMapping("/update")
	public void  updateCurso(@RequestBody Curso curso) {
		 //cursoService.update(curso);
	}
	
	// Listar Todos los Cursos
	/**@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<List<Curso>> listAllCursos(){
		return ResponseEntity.ok(cursoService.getAllCursos());
	}*/
	
	
}
