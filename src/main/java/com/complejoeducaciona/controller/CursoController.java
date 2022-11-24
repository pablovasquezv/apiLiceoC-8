/**
 *
 */
package com.complejoeducaciona.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.complejoeducaciona.impl.ICursoImpleService;
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

import com.complejoeducaciona.models.Curso;

import javax.validation.Valid;

/**
 * @author Pablo
 */
@Slf4j
@RestController
@RequestMapping(value = ("/colegio/curso"))
public class CursoController {
    /*
     * Autowired:es Para decirle al servicio que estÃ¡ conectado con el repositorio
     * que esta haciendo uso de la base de datos y de los objetos. Además, crea la
     * inyecion de la Interfaz importada del paquete Repositorio, lo que evita la
     * creacion de una instancia de esta.
     **/
    @Autowired
    private ICursoImpleService iCursoImpleService;
    //private CursoService cursoService;

    // Método para crear un Curso
    @ResponseBody
    @PostMapping(value = "/create")
    private ResponseEntity<Map<String, Object>> addNewCurso(@Valid @RequestBody Curso curso, BindingResult bindingResult) {
        Map<String, Object> responseAsMap = new HashMap<>();
        ResponseEntity<Map<String, Object>> responseEntity = null;
        List<String> errores = null;
        if (bindingResult.hasErrors()) {
            errores = new ArrayList<String>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            responseAsMap.put("Errores", errores);
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        try {
            Curso cursoFromDB = iCursoImpleService.save(curso);
            if (cursoFromDB != null) {
                responseAsMap.put("curso", curso);
                responseAsMap.put("Mensaje", "El Curso con ID " + curso.getId_curso() + " se creó correctamente");
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
            log.error("Ocurrio un Error a Crear el Curso =>" + exception.getMessage().toString());
        }
        return responseEntity;
    }

    // Método para actualizar un Curso
    @PutMapping(value = "/update/{id}")
    private ResponseEntity<Map<String, Object>> updateCurso(@PathVariable long id, @Valid @RequestBody Curso curso, BindingResult bindingResult) {
        Map<String, Object> responseAsMap = new HashMap<>();
        ResponseEntity<Map<String, Object>> responseEntity = null;
        List<String> errores = null;
        if (bindingResult.hasErrors()) {
            errores = new ArrayList<String>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            responseAsMap.put("Erorres", errores);
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            return responseEntity;
        }
        try {
            Curso cursoFromDB = iCursoImpleService.update(id, curso);
            if (cursoFromDB != null) {
                responseAsMap.put("curso", curso);
                responseAsMap.put("Mensaje", "El Curso con ID: " + curso.getId_curso() + " ¡Sé Actualizo exitosamente!");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            } else {
                responseAsMap.put("Mensaje", "No se creo el Curso");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap,
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (DataAccessException dataAccessException) {
            responseAsMap.put("Mensaje", "No se creo el Curso" + dataAccessException.getMostSpecificCause().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception exception) {
            log.error("Ocurrio un Error al Actualizar el Curso  =>" + exception.getMessage().toString());
        }
        return responseEntity;
    }

    // Listar Todos los Cursos
    @GetMapping(value = "/get/all")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<Curso>> findAllCursos(@RequestParam(required = false) Integer page,
                                                      @RequestParam(required = false) Integer size) {
        Sort sortByName = Sort.by("nombre_curso");
        ResponseEntity<List<Curso>> responseEntity = null;
        List<Curso> cursos = null;
        try {
            if (page != null & size != null) {
                Pageable pageable = PageRequest.of(page, size, sortByName);
                cursos = iCursoImpleService.findAllCursoPageable(pageable).getContent();
            } else {
                cursos = iCursoImpleService.findAllCursoSort(sortByName);
            }
            // Validación sí la lista tiene elementos
            responseEntity = (cursos.size() > 0) ?
                    new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK)
                    :
                    new ResponseEntity<List<Curso>>(cursos, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("Ocurrio un error a Listar los cursos => " + e);
        }
        return responseEntity;
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<Curso> findById(@PathVariable long id) {
        Curso curso = null;
        ResponseEntity<Curso> responseEntity = null;
        try {
            curso = iCursoImpleService.findById(id);
            // si exite
            responseEntity = (curso != null) ?
                    new ResponseEntity<Curso>(curso, HttpStatus.OK)
                    :
                    new ResponseEntity<Curso>(curso, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("Ocurrio un error al buscar un curso => " + e);
        }
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Curso> deleteById(@PathVariable("id") Long id) {
        // TODO Auto-generated method stub
        ResponseEntity<Curso> responseEntity = null;
        try {
            if (iCursoImpleService.findById(id) !=null){
                iCursoImpleService.deleteCursoById(id);
                responseEntity= new ResponseEntity <>( HttpStatus.OK);
            }else {
                responseEntity= new ResponseEntity <>( HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            log.error("Ocurrio un error al eliminar el curso => " + e);
        }
        return responseEntity;
    }

}
