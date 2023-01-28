package com.complejoeducaciona.controller;

import com.complejoeducaciona.impl.IProfesorImplementServices;
import com.complejoeducaciona.modelosIngope.Profesor;
import lombok.extern.slf4j.Slf4j;
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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = ("/colegio/profesor"))
public class ProfesorController {
    @Autowired
    private IProfesorImplementServices iProfesorImplementServices;

    @PostMapping(value = "/create")
    private ResponseEntity<Map<String, Object>> addNewProfesor(@Valid @RequestBody Profesor profesor, BindingResult bindingResult) {
        Map<String, Object> responseAsMap = new HashMap<>();
        ResponseEntity<Map<String, Object>> responseEntity = null;
        List<String> errores = null;
        if (bindingResult.hasErrors()) {
            errores = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            responseAsMap.put("Errore: ", errores);
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        try {
            Profesor profesorFromDB = iProfesorImplementServices.save(profesor);
            if (profesorFromDB != null) {
                responseAsMap.put("Profesor", profesor);
                responseAsMap.put("Mensaje", "El Profesor con ID" + profesor.getId_profesor() + "se creó correctamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            } else {
                responseAsMap.put("Mensaje", "No se creo el Profesor");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap,
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (DataAccessException dataAccessException) {
            responseAsMap.put("Mensaje", "No se creó el Profesor" + dataAccessException.getMostSpecificCause().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception exception) {
            log.error("Ocurrio un Error =>" + exception.getMessage().toString());
        }
        return responseEntity;
    }

    @PutMapping(value = "/udpadate/{id}")
    private ResponseEntity<Map<String, Object>> updateProfesor(@PathVariable("id") Long id, @Valid @RequestBody Profesor profesor, BindingResult bindingResult) {
        Map<String, Object> responseAsMap = new HashMap<>();
        ResponseEntity<Map<String, Object>> responseEntity = null;
        List<String> errores = null;
        if (bindingResult.hasErrors()) {
            errores = new ArrayList<String>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            responseAsMap.put("Errores", errores);
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
         Profesor profesorFromDB = iProfesorImplementServices.update(id, profesor);
         if (profesorFromDB !=null){
             responseAsMap.put("Profesor", profesor);
             responseAsMap.put("Mensaje", "EL profesor con ID"+ profesor.getId_profesor() + " ¡Sé Actualizo exitosamente!");
             responseEntity= new ResponseEntity<Map<String,Object>>(responseAsMap,HttpStatus.OK);
         }else{
             responseAsMap.put("Mensaje", "No sé Actualizo el Profesor");
             responseEntity= new ResponseEntity<Map<String,Object>>(responseAsMap,HttpStatus.BAD_REQUEST);
         }
        } catch (DataAccessException dataAccessException) {
            responseAsMap.put("Mensaje", "No se Actualizo el Profesor " + dataAccessException.getMostSpecificCause().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception exception) {
            log.error("Ocurrio un Error al Actualizar el Profesor  =>" + exception.getMessage().toString());
        }
        return responseEntity;
    }

    @GetMapping(value = "/get/all")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<Profesor>> listAllPofesores(@RequestParam(required = false) Integer page,
                                                            @RequestParam(required = false) Integer size) {
        Sort sortByName = Sort.by("nombres_profesor");
        ResponseEntity<List<Profesor>> responseEntity = null;
        List<Profesor> profesores = null;
        try {
            profesores = getProfesors(page, size, sortByName);

            // Validación sí la lista tiene
            responseEntity = (profesores.size() > 0) ?
                    new ResponseEntity<List<Profesor>>(profesores, HttpStatus.OK)
                    :
                    new ResponseEntity<List<Profesor>>(profesores, HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            // TODO: handle exception
            log.error("Ocurrio un error =>" + e);
        }

        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Profesor> buscarPorId(@PathVariable long id) {
        Profesor profesor = null;
        ResponseEntity<Profesor> responseEntity = null;
        try {
            profesor = iProfesorImplementServices.findById(id);
            // Sí exite
            responseEntity = (profesor != null) ?
                    new ResponseEntity<Profesor>(profesor, HttpStatus.OK)
                    :// No exite
                    new ResponseEntity<Profesor>(profesor, HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            log.error("Ocurrio un error =>" + e);
        }
        return responseEntity;
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Profesor> deleteById(@PathVariable("id") Long id) {
        ResponseEntity<Profesor> responseEntity = null;

        try {
            if (iProfesorImplementServices.findById(id) != null) {
                iProfesorImplementServices.deleteProfesorById(id);
                log.info("¡Se eliminó correctamente!");
                responseEntity = new ResponseEntity<>(HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<Profesor>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.error("Ocurrio un error en el controlador al eliminar el Profesor de => " + e);
        }
        return responseEntity;
    }

    private List<Profesor> getProfesors(Integer page, Integer size, Sort sortByName) throws Exception {
        List<Profesor> profesores;
        if (page != null && size != null) {
            Pageable pageable = PageRequest.of(page, size, sortByName);
            profesores = iProfesorImplementServices.findAllProfesorPageable(pageable).getContent();
        } else {
            profesores = iProfesorImplementServices.findAllProfesorSort(sortByName);
        }
        return profesores;
    }
}
