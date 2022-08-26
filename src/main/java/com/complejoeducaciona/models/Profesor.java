package com.complejoeducaciona.models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Pablo
 *
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

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<Curso> cursos;
    @NotEmpty(message = "¡El Rut no debe estar vacío!")
    @Size(min = 9, max = 12, message = "¡El campo Rut debe ser ingresado mínimo 9 y máximo 10 dígitos!")
    @Column(name = "rut_profesor")
    private String rut_profesor;

    @NotEmpty(message = "¡El campo del Nombre no debe ser vacío!")
    @Size(min = 4, max = 30, message = "¡El campo nombre debe tener enter 4 y 30 carácteres!")
    @Column(name = "nombre_profesor")
    private String nombre_profesor;

    @NotEmpty(message = "¡El campo del Apellido no debe ser vacío!")
    @Size(min = 4, max = 60, message = "El campo Apellido Paterno debe tener enter 4 y 20 carácteres!")
    @Column(name = "apellido_profesor")
    private String apellido_profesor;

    @NotEmpty(message = "¡El campo del celular no debes ser vacío!")
    @Size(min = 2, max = 12, message = "¡El campo Población debe tener enter 4 y 120 carácteres!")
    @Column(name = "celular_profesor")
    private String celular_profesor;

    @NotEmpty(message = "¡La calle no debe ser vacía!")
    @Size(min = 4, max = 120, message = "¡El campo Población o Condominío debe tener enter 4 y 120 carácteres!")
    @Column(name = "poblacion_profesor")
    private String poblacion_profesor;

    @NotEmpty(message = "¡La calle no debe ser vacía!")
    @Size(min = 4, max = 120, message = "¡El Apellido Paterno debe tener enter 4 y 120 carácteres!")
    @Column(name = "calle_profesor")
    private String calle_profesor;

    @NotEmpty(message = "¡El campo número de la calle no debe ser vacío!")
    @Size(min = 3, max = 6, message = "¡El número mínimo es 3 dígitos para la dirección!")
    @Column(name = "numero_casa_profesor")
    private String numero_casa_profesor;

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
