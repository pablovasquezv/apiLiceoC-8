/**
 *
 */
package com.complejoeducaciona.services;

import java.util.List;
import java.util.Optional;

import com.complejoeducaciona.impl.IApoderadoImplementServices;
import com.complejoeducaciona.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.complejoeducaciona.models.Apoderado;
import com.complejoeducaciona.repository.IApoderadoRepository;
import org.springframework.transaction.annotation.Transactional;


import lombok.extern.slf4j.Slf4j;

/**
 * @author Pablo
 */
@Slf4j
@Service
public class ApoderadoService implements IApoderadoImplementServices {
    @Autowired
    private IApoderadoRepository iApoderadoRepository;

    @Autowired
    private Utils utils;

    @Override
    @Transactional(readOnly = false)
    public Apoderado save(Apoderado apoderado) {
        Apoderado repuest= new Apoderado();
        log.info("---Inicio de creción Apoderador----");
        log.info("---Inicio de creción Apoderador----"+utils.imprimirLogEntrada(apoderado));
        repuest=iApoderadoRepository.save(apoderado);
        log.info("Json de Salida =>"+utils.imprimirLogSalida(repuest));
        log.info("----Fin de método Creación Cliente----");
        return repuest;
    }

    @Override
    @Transactional(readOnly = false)
    public Apoderado update(Apoderado apoderado) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Apoderado> findAll(Sort sort) {
        return iApoderadoRepository.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Apoderado> findAll(Pageable pageable) {
        return iApoderadoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Apoderado findById(long id) {
        return iApoderadoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteById(long id) {
        iApoderadoRepository.deleteById(id);
    }

}