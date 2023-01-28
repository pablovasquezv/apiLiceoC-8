package com.complejoeducaciona.modelosIngope;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Pablo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesor")
public class Profesor {
    /***
     * @GeneratedValue genera automaticamente el id
     * @Column Personalización para las columnas
     * @Size: Solo para String o Char.
     * @NotEmpty: Campo obligatorío.
     * @Min: validación del valor mínimo para ingresar en el campo.
     * @Max: validación del valor máximo para ingresar en el campo.
     * @PrePersist: Ejecuta el método justo antes que el objeto sea creado.
     * @PreUpdate: Ejecuta el método cuando el objeto es modificado.
     * @OneToMany:
     * fetch = FetchType.LAZY,
     * cascade = CascadeType.MERGE,
     * mappedBy = "profesor"
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long id_profesor;

    @NotEmpty(message = "¡El Rut no debe estar vacío!")
    @Size(min = 9, max = 12, message = "¡El campo Rut debe ser ingresado mínimo 9 y máximo 10 dígitos!")
    @Column(name = "rut_profesor")
    private String rut_profesor;

    @NotEmpty(message = "¡El campo del Nombre no debe ser vacío!")
    @Size(min = 4, max = 30, message = "¡El campo nombre debe tener enter 4 y 30 carácteres!")
    @Column(name = "nombres_profesor")
    private String nombres_profesor;

    @NotEmpty(message = "¡El campo del Apellido Paterno no debe ser vacío!")
    @Size(min = 4, max = 20, message = "El Apellido Paterno debe tener enter 4 y 20 carácteres!")
    @Column(name = "apellido_paterno_profesor")
    private String apellido_paterno_profesor;

    @NotEmpty(message = "¡El campo del Apellido Paterno no debe ser vacío!")
    @Size(min = 4, max = 20, message = "¡El Apellido Materno debe tener enter 4 y 20 carácteres!")
    @Column(name = "apellido_materno_profesor")
    private String apellido_materno_profesor;

    @Column(name = "fecha_nacimiento_profesor")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_nacimiento_profesor;

    @NotEmpty(message = "¡El campo Género no puede ser vacío!")
    @Size(min = 2, max = 20, message = "El campo Genero debe tener enter 4 y 20 carácteres!")
    @Column(name = "genero_profesor")
    private String genero_profesor;

    @NotEmpty(message = "¡El campo del celular no debes ser vacío!")
    @Size(min = 2, max = 12, message = "¡El campo Población debe tener enter 4 y 120 carácteres!")
    @Column(name = "celular_profesor")
    private String celular_profesor;

    @NotEmpty(message = "¡El email_profesor no debe ser vacía!")
    @Size(min = 4, max = 120, message = "¡El campo email_apoderadoo Condominío debe tener enter 4 y 120 carácteres!")
    @Column(name = "email_profesor")
    private String email_profesor;

    /**
     * CascadeType.ALL: de está forma permite la persistencia,actualización eliminación a través
     * de la misma persona
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull(message = "¡El id del domicilio no debe ser nulo!")
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@NotNull(message = "¡El id del Curso no debe ser nulo!")
    @JoinColumn(name = "id_curso")
    private Curso cursos;


    // Esto no permitirá que el campo createdAt sea modificado después de su
    // creación.
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // Otros getters y setters fueron removidos para resumir
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}
