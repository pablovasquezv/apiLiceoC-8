/**
 *
 */
package com.complejoeducaciona.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.complejoeducaciona.impl.IAlumnoImplementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.complejoeducaciona.models.Alumno;

/**
 * @author Pablo
 */
@RestController
@RequestMapping(value = ("/colegio/alumnos"))
public class AlumnoController {
    @Autowired
    private IAlumnoImplementServices iAlumnoImplementServices;

    @PostMapping("/create")
    @ResponseBody()
    private ResponseEntity<Map<String, Object>> addNewAlummo1(@Valid @RequestBody Alumno alumno, BindingResult result) {
        Map<String, Object> responseAsMap = new HashMap<String, Object>();
        ResponseEntity<Map<String, Object>> reponseEntity = null;
        List<String> errores = null;
        if (result.hasErrors()) {
            errores = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            responseAsMap.put("Errores", errores);
            reponseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.BAD_REQUEST);
            return reponseEntity;
        }
        try {
            Alumno alumnFromDB = iAlumnoImplementServices.save(alumno);
            if (alumnFromDB != null) {
                responseAsMap.put("alumno", alumno);
                responseAsMap.put("Mensaje", "El Alumno con Id" + alumno.getId_alumno() + " se creó correctamente");
                reponseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            } else {
                responseAsMap.put("Mensaje", "No se creo el Alumno");
                reponseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap,
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (DataAccessException e) {
            responseAsMap.put("Mensaje", "No se creo el Alumno" + e.getMostSpecificCause().toString());
            reponseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return reponseEntity;

    }

    // Método para Modificar un Departamento
    @PutMapping("/update/{id}")
    @ResponseBody()
    private void updateAumno(@PathVariable long id, @Valid @RequestBody Alumno alumno) {
        iAlumnoImplementServices.update(alumno);
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<Alumno>> findAllAlumnos(@RequestParam(required = false) Integer page,
                                                        @RequestParam(required = false) Integer size) {
        //Para ordenar la búsqueda
        Sort sortByName = Sort.by("nombres_alumno");
        ResponseEntity<List<Alumno>> responseEntity = null;
        List<Alumno> alumnos = null;
        if (page != null & size != null) {
            Pageable pageable = PageRequest.of(page, size, sortByName);
            alumnos = iAlumnoImplementServices.findAll(pageable).getContent();
        } else {
            alumnos = iAlumnoImplementServices.findAll(sortByName);
        }

        // Validación sí tiene Alumnos la lista
        if (alumnos.size() > 0) {
            responseEntity = new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

}

