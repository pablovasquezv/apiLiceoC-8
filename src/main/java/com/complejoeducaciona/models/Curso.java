/**
 *
 */
package com.complejoeducaciona.models;

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
public class Curso {
    /**
     * unique = true(no se repita el valor ingresado)
     *
     */
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

    /**
     *
     */
    public Curso() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param id_curso
     * @param nombre_curso
     * @param descripcion_curso
     * @param createdAt
     * @param updatedAt
     */
    public Curso(
            @NotEmpty(message = "¡El campo no puede estar vacío!") @Size(min = 1, max = 180, message = "¡El campo nombre_curso no debe tener como mínimo 2 y máximo 200 carácteres!") String nombre_curso,
            @NotEmpty(message = "¡El campo no puede estar vacío!") @Size(min = 1, max = 180, message = "¡El campo descripcion_curso no debe tener como mínimo 2 y máximo 200 carácteres!") String descripcion_curso
    ) {
        this.nombre_curso = nombre_curso;
        this.descripcion_curso = descripcion_curso;
    }

    /**
     * @return the id_curso
     */
    public Long getId_curso() {
        return id_curso;
    }

    /**
     * @param id_curso the id_curso to set
     */
    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    /**
     * @return the nombre_curso
     */
    public String getNombre_curso() {
        return nombre_curso;
    }

    /**
     * @param nombre_curso the nombre_curso to set
     */
    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    /**
     * @return the descripcion_curso
     */
    public String getDescripcion_curso() {
        return descripcion_curso;
    }

    /**
     * @param descripcion_curso the descripcion_curso to set
     */
    public void setDescripcion_curso(String descripcion_curso) {
        this.descripcion_curso = descripcion_curso;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

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
