/**
 * 
 */
package com.complejoeducaciona.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.complejoeducaciona.models.Curso;

/**
 * @author Pablo
 * @JpaRepository: Traer todos los métodos que trea por defecto Sprin para
 *                 cuando se realicen las consultas a la base de datos. Aqui se
 *                 pueden crear consultas mas especificas.
 */
@Repository
public interface ICursoRepository extends CrudRepository<Curso, Long> {
	List<Curso> findAll();
}
