/**
 *
 */
package com.complejoeducaciona.controller;

import java.util.*;

import javax.validation.Valid;


import com.complejoeducaciona.models.Departamento;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.complejoeducaciona.impl.IApoderadoImplementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.complejoeducaciona.models.Apoderado;

import javax.validation.Valid;

/**
 * @author Pablo
 */
@RestController
@RequestMapping(value = ("/colegio/apoderados"))
public class ApoderadoController {
    /*
     * Autowired:es Para decirle al servicio que estÃ¡ conectado con el repositorio
     * que esta haciendo uso de la base de datos y de los objetos. Además, crea la
     * inyecion de la Interfaz importada del paquete Repositorio, lo que evita la
     * creacion de una instancia de esta.
     **/
    @Autowired
    private IApoderadoImplementServices iApoderadoImplementServices;

    @ResponseBody()
    @PostMapping("/create")
    public Apoderado addNewApoderado(@Valid @RequestBody Apoderado apoderado) {
        /*Domicilio domicilio= new Domicilio();
        domicilio = iDomicilioImplementServices.save(domicilio);
        apoderado.setDomicilio(domicilio);*/
        return iApoderadoImplementServices.save(apoderado);
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<Apoderado>> listAllApoderados(@RequestParam(required = false) Integer page,
                                                              @RequestParam(required = false) Integer size) {

        Sort sortByName = Sort.by("nombres_apoderado");
        ResponseEntity<List<Apoderado>> responseEntity = null;
        List<Apoderado> apoderados = null;
        if (page != null && size != null) {
            Pageable pageable = PageRequest.of(page, size, sortByName);
            apoderados = iApoderadoImplementServices.findAll(pageable).getContent();
        } else {
            apoderados = iApoderadoImplementServices.findAll(sortByName);
        }

        if (apoderados.size() > 0) {
            responseEntity = new ResponseEntity<List<Apoderado>>(apoderados, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<List<Apoderado>>(apoderados, HttpStatus.NO_CONTENT);
        }

        return responseEntity;
    }

    // Buscar un producto
    @GetMapping(value = "/{id}")
    public ResponseEntity<Apoderado> findById(@PathVariable("id") Long id) {
        // TODO Auto-generated method stub
        Apoderado apoderado = iApoderadoImplementServices.findById(id);

        ResponseEntity<Apoderado> responseEntity = null;

        // si exite
        if (apoderado != null) {
            // retorna un 200
            responseEntity = new ResponseEntity<Apoderado>(apoderado, HttpStatus.OK);
        } else {
            // retorna un 202
            responseEntity = new ResponseEntity<Apoderado>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    /**
     * @GetMapping(value = "/buscar/{id}")
    private ResponseEntity<Optional<Apoderado>> listDepartamentoPorId(@PathVariable("id") Long id) {
    // TODO Auto-generated method stub
    return ResponseEntity.ok(iApoderadoImplementServices.findById(id));
    }*/
}
