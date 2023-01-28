package com.complejoeducaciona.impl;

import com.complejoeducaciona.modelosIngope.Profesor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IProfesorImplementServices {

    public Profesor save(Profesor profesor) throws Exception;

    public Profesor update(Long id, Profesor profesor) throws Exception;

    public List<Profesor> findAllProfesorSort(Sort sort) throws Exception;

    public Page<Profesor> findAllProfesorPageable(Pageable pageable) throws Exception;

    public Profesor findById(long id) throws Exception;

    public Object deleteProfesorById(Long id) throws Exception;

}
