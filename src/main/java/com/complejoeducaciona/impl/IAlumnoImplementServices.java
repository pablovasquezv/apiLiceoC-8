package com.complejoeducaciona.impl;

import com.complejoeducaciona.models.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IAlumnoImplementServices {

    public Alumno save(Alumno alumno);

    public Alumno update(Alumno alumno);

    public List<Alumno> findAll(Sort sort);

    public Page<Alumno> findAll(Pageable pageable);

    public Alumno findById(long id);

    public void deleteById(long id);
}
