package com.complejoeducaciona.impl;

import com.complejoeducaciona.modelosIngope.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IAlumnoImplementServices {

    public Alumno save(Alumno alumno) throws Exception;

    public Alumno update(Long id, Alumno alumno) throws Exception;

    public List<Alumno> findAllSortAlumno(Sort sort) throws Exception;

    public Page<Alumno> findAllPageableAlumno(Pageable pageable) throws Exception;

    public Alumno findByIdAlumno(long id) throws Exception;

    public Object deleteAlumnoById(Long id) throws Exception;
}
