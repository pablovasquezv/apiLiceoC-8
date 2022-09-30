/**
 *
 */
package com.complejoeducaciona.repository;

import com.complejoeducaciona.models.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pablo
 */
@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
    // Seleccionar todas la instancias desde la BD y haciendo un Join con la tabla Apoderado
    @Query(value = "select a from Alumno a left join fetch a.apoderado e left join a.domicilio")
    public List<Alumno> findAll(Sort sort);

    // Contar la cantidad de Alumnos que vienen en la búsqueda y páginarlos
    @Query(value = "select a from Alumno a left join fetch a.apoderado e left join a.domicilio",
            countQuery = "select (a) from Alumno a left join a.apoderado e left join a.domicilio")
    public Page<Alumno> findAll(Pageable pageable);

    @Query(value = "select a from Alumno a left join a.apoderado e left join a.domicilio where a.id=:id")
    public Alumno findById(long id);
}
