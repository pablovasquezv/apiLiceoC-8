/**
 *
 */
package com.complejoeducaciona.controller;

import java.util.*;

import javax.validation.Valid;


import com.complejoeducaciona.modelosIngope.Alumno;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.complejoeducaciona.impl.IApoderadoImplementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.complejoeducaciona.modelosIngope.Apoderado;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pablo
 */
@Slf4j
@RestController
@RequestMapping(value = ("/colegio/v1"))
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
    @PostMapping("apoderado/create")
    public Apoderado addNewApoderado(@Valid @RequestBody Apoderado apoderado) {
        /*Domicilio domicilio= new Domicilio();
        domicilio = iDomicilioImplementServices.save(domicilio);
        apoderado.setDomicilio(domicilio);*/
        return iApoderadoImplementServices.save(apoderado);
    }

    // Método para Modificar un Departamento
    @PutMapping("/update/{id}")
    @ResponseBody()
    private void updateApoderado(@PathVariable long id, @Valid @RequestBody Apoderado apoderado){
        try {
            iApoderadoImplementServices.update(id,apoderado);
        }catch (Exception e){
            log.error("¡Ocurrió un error =>!"+e);
        }
    }
    @GetMapping("apoderado/get/all")
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
    @GetMapping(value = "apoderado/{id}")
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

    @DeleteMapping("apoderado/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Alumno> deleteById(@PathVariable("id") Long id) {
        // TODO Auto-generated method stub
        ResponseEntity<Alumno> responseEntity = null;
        try {
            if (iApoderadoImplementServices.findById(id) != null) {
                log.info("Se va a eliminar");
                iApoderadoImplementServices.deleteApoderadoById(id);
                log.info("Se elimino");
                responseEntity = new ResponseEntity<>(HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.error("Ocurrio un error en el controlador al eliminar el Apoderado de => " + e);
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
