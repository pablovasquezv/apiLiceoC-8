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
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
import org.springframework.web.bind.annotation.DeleteMapping;

import com.complejoeducaciona.modelosIngope.Alumno;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pablo
 */
@Slf4j
@RestController
@RequestMapping(value = ("/colegio/alumnos"))
public class AlumnoController {

    @Autowired
    private IAlumnoImplementServices iAlumnoImplementServices;

    @PostMapping("/create")
    @ResponseBody()
    private ResponseEntity<Map<String, Object>> addNewAlummo1(@Valid @RequestBody Alumno alumno, BindingResult result) {
        Map<String, Object> responseAsMap = new HashMap<String, Object>();
        ResponseEntity<Map<String, Object>> responseEntity = null;
        List<String> errores = null;
        if (result.hasErrors()) {
            errores = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            responseAsMap.put("Errores", errores);
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        try {
            Alumno alumnFromDB = iAlumnoImplementServices.save(alumno);
            if (alumnFromDB != null) {
                responseAsMap.put("alumno", alumno);
                responseAsMap.put("Mensaje", "El Alumno con Id" + alumno.getId_alumno() + " se creó correctamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            } else {
                responseAsMap.put("Mensaje", "No se creo el Alumno");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap,
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (DataAccessException dataAccessException) {
            responseAsMap.put("Mensaje", "No se creo el Alumno" + dataAccessException.getMostSpecificCause().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception exception) {
            log.error("Ocurrio un Error =>" + exception.getMessage().toString());
        }

        return responseEntity;

    }

    // Método para Modificar un Departamento
    @PutMapping("/update/{id}")
    @ResponseBody()
    private void updateAumno(@PathVariable long id, @Valid @RequestBody Alumno alumno) {
        try {
            iAlumnoImplementServices.update(id, alumno);
        } catch (Exception e) {
            log.error("Ocurrio un Error =>" + e);
        }

    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<Alumno>> findAllAlumnos(@RequestParam(required = false) Integer page,
                                                        @RequestParam(required = false) Integer size) {
        //Para ordenar la búsqueda
        Sort sortByName = Sort.by("nombres_alumno");
        ResponseEntity<List<Alumno>> responseEntity = null;
        List<Alumno> alumnos = null;
        try {
            if (page != null & size != null) {
                Pageable pageable = PageRequest.of(page, size, sortByName);
                alumnos = iAlumnoImplementServices.findAllPageableAlumno (pageable).getContent();
            } else {
                alumnos = iAlumnoImplementServices.findAllSortAlumno(sortByName);
            }

            // Validación sí tiene Alumnos la lista
            if (alumnos.size() > 0) {
                responseEntity = new ResponseEntity<List<Alumno>>(alumnos, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.error("Ocurrio un error =>" + e);
        }
        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Alumno> findById(@PathVariable int id) {
        // TODO Auto-generated method stub
        Alumno alumnos = null;
        ResponseEntity<Alumno> responseEntity = null;
        try {
            alumnos = iAlumnoImplementServices.findByIdAlumno(id);
            // si exite
            if (alumnos != null) {
                // retorna un 200
                responseEntity = new ResponseEntity<Alumno>(alumnos, HttpStatus.OK);
            } else {
                // retorna un 202
                responseEntity = new ResponseEntity<Alumno>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.error("Ocurrio un error =>" + e);
        }

        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Alumno> deleteById(@PathVariable("id") Long id) {
        // TODO Auto-generated method stub
        ResponseEntity<Alumno> responseEntity = null;
        try {
            if (iAlumnoImplementServices.findByIdAlumno(id) != null) {
                log.info("Se va a eliminar");
                iAlumnoImplementServices.deleteAlumnoById(id);
                log.info("Se elimino");
                responseEntity = new ResponseEntity<>(HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.error("Ocurrio un error en el controlador al eliminar el Alumno de => " + e);
        }
        return responseEntity;
    }
}

