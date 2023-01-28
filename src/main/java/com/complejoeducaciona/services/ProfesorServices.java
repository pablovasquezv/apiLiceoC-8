package com.complejoeducaciona.services;

import com.complejoeducaciona.impl.IProfesorImplementServices;
import com.complejoeducaciona.modelosIngope.Profesor;
import com.complejoeducaciona.repository.IProfesorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProfesorServices implements IProfesorImplementServices {
    @Autowired
    private IProfesorRepository iProfesorRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    @Transactional(readOnly = false)
    public Profesor save(Profesor profesor) throws Exception {
        Profesor respuest = new Profesor();
        log.info("---Inicio de creción Profesor----" + objectMapper.writeValueAsString(profesor));
        respuest = iProfesorRepository.save(profesor);
        log.info("---Profesor creado----" + objectMapper.writeValueAsString(profesor));
        return respuest;
    }

    @Override
    @Transactional(readOnly = false)
    public Profesor update(Long id, Profesor profesor) throws Exception {
        try {
            Optional<Profesor> optionalProfesor = iProfesorRepository.findById(id);
            Profesor profesorUpdate = optionalProfesor.get();
            profesorUpdate = iProfesorRepository.save(profesor);
            log.info("---Actualización Alumno----" + objectMapper.writeValueAsString(iProfesorRepository.save(profesor)));
            return profesor;
        } catch (Exception e) {
            log.error("Falló al actualización del Profesor!");
        }
        return profesor;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Profesor> findAllProfesorSort(Sort sort) throws Exception {
        return iProfesorRepository.findAllSortProfersores(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Profesor> findAllProfesorPageable(Pageable pageable) throws Exception {
        return iProfesorRepository.findAllPageableProfesor(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor findById(long id) throws Exception {
        return iProfesorRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Object deleteProfesorById(Long id) throws Exception {
        try {
            iProfesorRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Ocurrio un erro en Método deleteAlumnoById al eliminar el Alumno =>" + e);
        }
        return null;
    }
}
