/**
 *
 */
package com.complejoeducaciona.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Pablo
 * @Entity: para decir a JPA Y HIBERANTE que esta será una entidad y se tiene
 * que guardar como tal en la BD
 * @Table: Para indicar que está será una tabla en la BD.
 * @Data: Para crear los gett y sett
 * @AllArgsConstructor: Constructor con parámetros
 * @NoArgsConstructor:Constructor sin parámetros
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apoderados")
public class Apoderado implements Serializable {
    /**
     * Serializable:para hacer la persistencia del objeto y convertilo en una
     * secuencia de Bytes para poder almacenarlo en algún medio de almacenamiento en
     * esta caso una BD.
     *
     * @GeneratedValue genera automaticamente el id.
     * @Column Personalización para las columnas. unique = true(no se repita el
     * valor ingresado)
     * @Size: Solo para String o Char.
     * @NotEmpty: Campo obligatorío.
     * @Min: validación del valor mínimo del campo.
     * @Max: validación del valor máximo del campo.
     * @PrePersist: Ejecuta el método justo antes que el objeto sea creado.
     * @PreUpdate: Ejecuta el método cuando el objeto es modificado.
     * @NotNull: que nunca debe ser null.
     * @JoinColumn: el campo que unirá las tablas
     * @OneToMany: fetch = FetchType.LAZY,
     * cascade = CascadeType.ALL(cuando se cree un Apd se cree su domicilio y cuando se elimine también se borre)
     * mappedBy = "apoderado"
     */
    private static final long serialVersionUID = 1L;
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
     * cascade = CascadeType.ALL(cuando se cree un Apd se cree su domicilio y cuando se elimine también se borre)
     * mappedBy = "apoderado"
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apoderado")
    private Long id_apoderado;

    @NotEmpty(message = "¡El Rut no debe estar vacío!")
    @Size(min = 9, max = 12, message = "¡El campo Rut debe ser ingresado mínimo 9 y máximo 10 dígitos!")
    @Column(name = "rut_apoderado")
    private String rut_apoderado;

    @NotEmpty(message = "¡El campo del Nombre no debe ser vacío!")
    @Size(min = 4, max = 30, message = "¡El campo nombre debe tener enter 4 y 30 carácteres!")
    @Column(name = "nombres_apoderado")
    private String nombres_apoderado;

    @NotEmpty(message = "¡El campo del Apellido no debe ser vacío!")
    @Size(min = 4, max = 60, message = "El campo Apellido Paterno debe tener enter 4 y 20 carácteres!")
    @Column(name = "apellidos_apoderado")
    private String apellidos_apoderado;

    @NotEmpty(message = "¡El campo del celular no debes ser vacío!")
    @Size(min = 2, max = 12, message = "¡El campo Población debe tener enter 4 y 120 carácteres!")
    @Column(name = "celular_apoderado")
    private String celular_apoderado;

    @NotEmpty(message = "¡El email_apoderado no debe ser vacía!")
    @Size(min = 4, max = 120, message = "¡El campo email_apoderadoo Condominío debe tener enter 4 y 120 carácteres!")
    @Column(name = "email_apoderado")
    private String email_apoderado;

    @Min(value = 18, message = "¡El campo Edad deber se mayor a 18 años!")
    @Max(value = 120, message = "¡El campo edad no deber mayor a 120 años!")
    @Column(name = "edad_apoderado")
    private Integer edad_apoderado;

    /**
     * CascadeType.ALL: de está forma permite la persistencia,actualización eliminación a través
     * de la misma persona
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull(message = "¡El id del domicilio no debe ser nulo!")
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;

    @JsonIgnore
    @OneToMany(mappedBy = "apoderado", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Alumno> alumno = new ArrayList<>();

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
