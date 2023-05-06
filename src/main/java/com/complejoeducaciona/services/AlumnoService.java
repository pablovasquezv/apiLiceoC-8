/**
 *
 */
package com.complejoeducaciona.services;

import java.util.List;
import java.util.Optional;

import com.complejoeducaciona.impl.IAlumnoImplementServices;
import com.complejoeducaciona.modelosIngope.Apoderado;
import com.complejoeducaciona.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.complejoeducaciona.modelosIngope.Alumno;
import com.complejoeducaciona.repository.IAlumnoRepository;
import com.complejoeducaciona.repository.IApoderadoRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Pablo
 */
@Service
@Slf4j
public class AlumnoService implements IAlumnoImplementServices {
    @Autowired
    private IAlumnoRepository iAlumnoRepository;
    @Autowired
    private IApoderadoRepository iApoderadoRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Utils utils;

    // Método para obtener un Alumno en Específico
    public Alumno findById(Long id_alumno) {
        return iAlumnoRepository.findById(id_alumno).get();
    }

    // Método para Crear un Alumno
    @Override
    @Transactional(readOnly = false)
    public Alumno save(Alumno alumno) throws JsonProcessingException {
        Alumno respuesta = null;
        try {
            respuesta = new Alumno();
            Apoderado apoderado = iApoderadoRepository.findById(alumno.getApoderado().getId_apoderado()).orElse(null);
            alumno.setApoderado(apoderado);
            log.info("---Inicio de creción Alumno----" + objectMapper.writeValueAsString(alumno));
            respuesta = iAlumnoRepository.save(alumno);
            log.info("Alumno creado =>" + objectMapper.writeValueAsString(alumno));
        } catch (Exception e) {
            log.error("Falló en la creación del  Alumno", e);
        }
        return respuesta;

    }

    @Override
    @Transactional(readOnly = false)
    public Alumno update(Long id, Alumno alumno) throws Exception {
        try {
            Optional<Alumno> optionalAlumno = iAlumnoRepository.findById(id);
            Alumno alumnoUpdate = optionalAlumno.get();
            alumnoUpdate = iAlumnoRepository.save(alumno);
            log.info("---Actualización Alumno----" + objectMapper.writeValueAsString(iAlumnoRepository.save(alumno)));
            return alumno;
        } catch (Exception e) {
            log.error("Falló al actualización del  Alumno");
        }
        return alumno;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findAll(Sort sort) {

        return iAlumnoRepository.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Alumno> findAll(Pageable pageable) {
        return iAlumnoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Alumno findById(long id) {

        return iAlumnoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Object deleteAlumnoById(Long id) throws Exception {
        try {
            log.error("Método deleteAlumnoById eliminar el Alumno =>");
            iAlumnoRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Ocurrio un erro en Método deleteAlumnoById al eliminar el Alumno =>" + e);
        }
        return null;
    }

}
