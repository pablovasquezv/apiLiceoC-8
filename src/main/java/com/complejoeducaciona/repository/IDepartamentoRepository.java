/**
 * 
 */
package com.complejoeducaciona.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.complejoeducaciona.modelosIngope.Departamento;

/**
 * @author Pablo
 * @JpaRepository: Traer todos los métodos que trea por defecto Sprin para
 *                 cuando se realicen las consultas a la base de datos. Aqui se
 *                 pueden crear consultas mas especificas.
 */
@Repository
public interface IDepartamentoRepository extends CrudRepository<Departamento, Long> {
	List<Departamento> findAll();
	//Este método encuentra un Departamento por su descripción
    //List<Departamento> findByDescripcionContaining(String search);
    //Este método cuenta cuántos Departamentos contiene cierta cadena en el título
    //Long countByNombre_DepartamentoContaining(String search);
    //Este método borra un Departamento que empieza con un nombre en específico
    //Long deleteByNombre_DepartamentoStartingWith(String search);
    
}
