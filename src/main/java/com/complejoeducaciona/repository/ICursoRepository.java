/**
 * 
 */
package com.complejoeducaciona.repository;

import java.util.List;

import com.complejoeducaciona.models.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Pablo
 * @JpaRepository: Traer todos los métodos que trea por defecto Sprin para
 *                 cuando se realicen las consultas a la base de datos. Aqui se
 *                 pueden crear consultas mas especificas.
 */
@Repository
public interface ICursoRepository extends JpaRepository <Curso, Long> {
	// Seleccionar todas la instancias desde la BD y haciendo un Join con la tabla
	@Query(value = "select c from Curso c")
	public List<Curso> findAllCursoSort(Sort sort);

	// Contar la cantidad de Cursos que vienen en la búsqueda y páginarlos
	@Query(value = "select c from Curso c",
			countQuery = "select count(c) from Curso c")
	public Page<Curso> findAllCursoPage(Pageable pageable);

	//Buscar por id
	@Query(value = "select c from Curso c where id=:id")
	public Curso findById(long id);
}
