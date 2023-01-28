/**
 * 
 */
package com.complejoeducaciona.repository;

import com.complejoeducaciona.modelosIngope.Apoderado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pablo
 *
 */
@Repository
public interface IApoderadoRepository extends JpaRepository<Apoderado, Long> {
	// Seleccionar todas la instancias desde la BD y haciendo un Join con la tabla Apoderado

    // Seleccionar todas la instancias desde la BD y haciendo un Join con la tabla Apoderado
    @Query(value = "select a from Apoderado a left join fetch a.domicilio")
    public List<Apoderado> findAll(Sort sort);

    // Contar la cantidad de Apoderados que vienen en la búsqueda y páginarlos
    @Query(value = "select a from Apoderado a left join fetch a.domicilio",
            countQuery = "select count(a) from Apoderado a left join a.domicilio")
    public Page<Apoderado> findAll(Pageable pageable);

    @Query(value = "select a from Apoderado a left join a.domicilio where a.id=:id")
    public Apoderado findById(long id);
}
