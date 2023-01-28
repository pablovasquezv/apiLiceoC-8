package com.complejoeducaciona.impl;

import com.complejoeducaciona.modelosIngope.Apoderado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IApoderadoImplementServices {

    public Apoderado save(Apoderado apoderado);

    public Apoderado update(Apoderado apoderado);

    public List<Apoderado> findAll(Sort sort);

    public Page<Apoderado> findAll(Pageable pageable);

    public Apoderado findById(long id);

    public void deleteById(long id);
}
