/**
 * Clase de Servicio Departamento
 */
package com.complejoeducaciona.services;
//Para listar los datos
import java.util.List;
//Para realizar una búsqueda.
import java.util.Optional;
/*para decirle al servicio que esta conectado con el repositorio y
* **/
import org.springframework.beans.factory.annotation.Autowired;
//Para decir que es un Servicio
import org.springframework.stereotype.Service;

import com.complejoeducaciona.models.Departamento;
import com.complejoeducaciona.repository.IDepartamentoRepository;

/**
 * @author Pablo
 *
 */
@Service
public class DepartamentoService {
	/*
	 * Autowired:es Para decirle al servicio que estÃ¡ conectado con el repositorio
	 * que esta haciendo uso de la base de datos y de los objetos. Además, crea la
	 * inyecion de la Interfaz importada del paquete Repositorio, lo que evita la
	 * creacion de una instancia de esta.
	 **/
	@Autowired
	private IDepartamentoRepository iDepartamentoRepository;

	// Método para Crear un Departamento
	public Departamento create(Departamento departamento) {
		return iDepartamentoRepository.save(departamento);
	}

	// Método para Actualizar un Departamento
	public Departamento modificar(Departamento departamento) {
		return iDepartamentoRepository.save(departamento);
	}

	// Método para Crear listar todas los Departamentos
	public List<Departamento> getAllDepartamentos() {
		return iDepartamentoRepository.findAll();
	}

	// Método para Eliminar un Departamento
	public void deleteDepartamento(Departamento departamento) {
		iDepartamentoRepository.delete(departamento);
	}
	
	// Método para obtener una Departamento en Específico
	public Optional<Departamento> findById(Long id_Departamentos) {
		return iDepartamentoRepository.findById(id_Departamentos);
	}
	
}
