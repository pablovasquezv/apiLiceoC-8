/**
 * 
 */
package com.complejoeducaciona.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.complejoeducaciona.models.Apoderado;

/**
 * @author Pablo
 *
 */
@Repository
public interface IApoderadoRepository extends CrudRepository<Apoderado, Long> {
	List<Apoderado> findAll();
}
