/**
 *
 */
package com.complejoeducaciona.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author Pablo
 * @Entity: para decir a JPA Y HIBERANTE que esta será una entidad y se tiene
 *          que guardar como tal en la BD
 * @Table: Para indicar que está será una tabla en la BD.
 * @Data: Para crear los gett y sett
 * @AllArgsConstructor: Constructor con parámetros
 * @NoArgsConstructor:Constructor sin parámetros
 */
@Data
@Entity
@Table(name = "curso")
public class Curso implements Serializable {
    /**
     * unique = true(no se repita el valor ingresado)
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long id_curso;

    @NotEmpty(message = "¡El campo nombre_curso no puede estar vacío!")
    @Size(min = 1, max = 180, message = "¡El campos no debe tener como mínimo 2 y máximo 200 carácteres!")
    @Column(name = "nombre_curso", unique = true)
    private String nombre_curso;

    @NotEmpty(message = "¡El campo  descripción curso no puede estar vacío!")
    @Size(min = 1, max = 180, message = "¡El campos no debe tener como mínimo 2 y máximo 200 carácteres!")
    @Column(name = "descripcion_curso")
    private String descripcion_curso;
/**
 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
 @JoinColumn(name = "id_profesor", referencedColumnName ="id_profesor")
 @Column(name = "id_profesor")
 private Profesor profesor;*/
    /**
     @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
     @JoinColumn(name = "id_alumno", referencedColumnName ="id_alumno")
     @Column(name = "id_alumno")
     private Alumno alumno;*/

    // Esto no permitirá que el campo createdAt sea modificado después de su
    // creación.
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;



    // Methods
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();

    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}
