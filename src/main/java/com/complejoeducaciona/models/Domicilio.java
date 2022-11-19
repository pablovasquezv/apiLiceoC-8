package com.complejoeducaciona.models;
import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "domicilio")
public class Domicilio implements Serializable {
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
     * mappedBy = "domicilio"
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domicilio")
    private Long id_domicilio;

    @Min(value = 0, message = "¡El campo número deber se mayor a 0!")
    @Max(value = 10000, message = "¡El campo número no deber mayor a 10000!")
    @Column(name = "numero_domicilio")
    private Integer numero_domicilio;

    @NotEmpty(message = "¡La calle del domicilio no debe estar vacío!")
    @Size(min =4, max = 120, message = "¡El campo calle del domicilio debe ser ingresado mínimo 4 y máximo 230 dígitos!")
    @Column(name = "nombre_calle_domicilio")
    private String nombre_calle_domicilio;

    @NotEmpty(message = "¡El campo del Secto no debe ser vacío!")
    @Size(min = 4, max = 130, message = "¡El campo sector debe tener enter 4 y 230 carácteres!")
    @Column(name = "sector_domicilio")
    private String sector_domicilio;

    @NotEmpty(message = "¡El campo del Ciudad no debe ser vacío!")
    @Size(min = 2, max = 20, message = "¡El campo Ciudad debe tener enter 2 y 20 carácteres!")
    @Column(name = "ciudad_domicilio")
    private String ciudad_domicilio;


    // Esto no permitirá que el campo createdAt sea modificado después de su
    // creación.
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // Otros getters y setters fueron removidos para resumir
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
