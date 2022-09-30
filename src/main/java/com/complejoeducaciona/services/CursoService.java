/**
 * 
 */
package com.complejoeducaciona.services;

import java.util.List;
import java.util.Optional;

import com.complejoeducaciona.impl.ICursoImpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.complejoeducaciona.models.Curso;
import com.complejoeducaciona.repository.ICursoRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Pablo
 *
 */
@Service
public class CursoService implements ICursoImpleService {
	/*
	 * Autowired:es Para decirle al servicio que estÃ¡ conectado con el repositorio
	 * que esta haciendo uso de la base de datos y de los objetos. Además, crea la
	 * inyecion de la Interfaz importada del paquete Repositorio, lo que evita la
	 * creacion de una instancia de esta.
	 **/
	@Autowired
	private ICursoRepository iCursoRepository;

	// Método para Crear un Curso
	/**public Curso create(Curso curso) {
		return iCursoRepository.save(curso);
	}*/
	@Override
	@Transactional(readOnly = false)
	public Curso save(Curso curso) {
		return iCursoRepository.save(curso);
	}

	// Método para Actualizar un Curso
	public Curso update(Curso curso) {
		return iCursoRepository.save(curso);
	}

	// Método para Crear listar todas los Cursos
	public List<Curso> getAllCursos() {
		return iCursoRepository.findAll();
	}

	// Método para Eliminar un Departamento
	public void deleteCurso(Curso curso) {
		iCursoRepository.delete(curso);
	}

	// Método para obtener una Departamento en Específico
	public Optional<Curso> findById(Long id_curso) {
		return iCursoRepository.findById(id_curso);
	}


}
