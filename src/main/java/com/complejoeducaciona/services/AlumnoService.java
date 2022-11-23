/**
 *
 */
package com.complejoeducaciona.services;

import java.util.List;

import com.complejoeducaciona.impl.IAlumnoImplementServices;
import com.complejoeducaciona.models.Apoderado;
import com.complejoeducaciona.models.Matriculas;
import com.complejoeducaciona.repository.IMatriculasRepository;
import com.complejoeducaciona.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.complejoeducaciona.models.Alumno;
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
    private IMatriculasRepository iMatriculasRepository;
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
        Alumno respuesta = new Alumno();
        Apoderado apoderado= iApoderadoRepository.findById(alumno.getApoderado().getId_apoderado()).orElse(null);
        alumno.setApoderado(apoderado);
        /*
        Matriculas  matriculas= iMatriculasRepository.findById(alumno.getMatriculas().getId_matricula()).orElse(null);
        alumno.setMatriculas(matriculas);*/
        log.info("---Inicio de creción Alumno----"+utils.imprimirLogEntrada(alumno));
        respuesta = iAlumnoRepository.save(alumno);
        log.info("Json de Salida =>"+utils.imprimirLogSalida(alumno));
        log.info("----Fin de método Creación Alumno----");
        log.info("Alumno creado =>" + objectMapper.writeValueAsString(alumno));
        return respuesta;

    }

    @Override
    @Transactional(readOnly = false)
    public Alumno update(Alumno alumno) {
        /** Apoderado apoderado = apoderadoRepository.findById
         (alumno.getApoderado().getId_apoderado()).orElse(null);
         alumno.setApoderado(apoderado);
         return iAlumnoRepository.save(alumno);*/
        return null;
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
    public void deleteById(long id) {
        iAlumnoRepository.deleteById(id);
    }
}
