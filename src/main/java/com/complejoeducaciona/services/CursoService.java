/**
 *
 */
package com.complejoeducaciona.services;

import java.util.List;
import java.util.Optional;

import com.complejoeducaciona.impl.ICursoImpleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.complejoeducaciona.modelosIngope.Curso;
import com.complejoeducaciona.repository.ICursoRepository;

/**
 * @author Pablo
 */
@Slf4j
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

    @Autowired
    private ObjectMapper objectMapper;

    // Método para Crear un Curso
    @Override
    @Transactional(readOnly = false)
    public Curso save(Curso curso) {
        try {
            log.info("---");
            curso = iCursoRepository.save(curso);
            log.info("Creación Curso =>" + objectMapper.writeValueAsString(iCursoRepository.save(curso)));
        } catch (Exception e) {
            log.error("Ocurrior un erro al Crear el Curso =>" + e);

        }
        return curso;
    }

    @Override
    @Transactional(readOnly = false)
    public Curso update(Long id, Curso curso) throws Exception {
        try {
            Optional<Curso> optionalCurso = iCursoRepository.findById(id);
            Curso cursoUpdate = optionalCurso.get();
            cursoUpdate = iCursoRepository.save(curso);
            return curso;
        } catch (Exception e) {
            log.error("Ocurrio un Errror al actualizar el Curso =>" + e);
        }
        return curso;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAllCursoSort(Sort sort) throws Exception {
        return iCursoRepository.findAllCursoSort(sort);
    }

    @Override
    @Transactional(readOnly = false)
    public Page<Curso> findAllCursoPageable(Pageable page) throws Exception {
        return iCursoRepository.findAllCursoPage(page);
    }

    @Override
    @Transactional(readOnly = false)
    public Curso findById(long id) throws Exception {
        return iCursoRepository.findById(id);
    }

    @Override
    public Object deleteCursoById(Long id) throws Exception {
        try {
            iCursoRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Ocurrio un Errror al actualizar el Curso =>" + e);
        }
        return null;
    }

}
