package com.complejoeducaciona.impl;

import com.complejoeducaciona.modelosIngope.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ICursoImpleService {
    public Curso save(Curso curso) throws Exception;
    public Curso update(Long id, Curso curso) throws Exception;
    public List<Curso> findAllCursoSort(Sort sort) throws Exception;
    public Page<Curso> findAllCursoPageable(Pageable page) throws Exception;
    public Curso findById(long id) throws Exception;

    public Object deleteCursoById(Long id) throws Exception;

}
