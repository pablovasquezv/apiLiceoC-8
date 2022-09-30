package com.complejoeducaciona.impl;

import com.complejoeducaciona.models.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IAlumnoImplementServices {

    public Alumno save(Alumno alumno) throws Exception;

    public Alumno update(Alumno alumno) throws Exception;

    public List<Alumno> findAll(Sort sort) throws Exception;

    public Page<Alumno> findAll(Pageable pageable) throws Exception;

    public Alumno findById(long id) throws Exception;

    public void deleteById(long id) throws Exception;
}
