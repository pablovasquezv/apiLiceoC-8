/**
 * 
 */
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
@Table(name = "apoderados")
public class Apoderado {
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
	 * mappedBy = "apoderado"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_apoderado")
	private Long id_apoderado;

	@NotEmpty(message = "¡El Rut no debe estar vacío!")
	@Size(min = 9, max = 12, message = "¡El campo Rut debe ser ingresado mínimo 9 y máximo 10 dígitos!")
	@Column(name = "rut_apoderado")
	private String rut_apoderado;

	@NotEmpty(message = "¡El campo del Nombre no debe ser vacío!")
	@Size(min = 4, max = 30, message = "¡El campo nombre debe tener enter 4 y 30 carácteres!")
	@Column(name = "nombre_apoderado")
	private String nombre_apoderado;

	@NotEmpty(message = "¡El campo del Apellido no debe ser vacío!")
	@Size(min = 4, max = 60, message = "El campo Apellido Paterno debe tener enter 4 y 20 carácteres!")
	@Column(name = "apellido_apoderado")
	private String apellido_apoderado;

	@NotEmpty(message = "¡El campo del celular no debes ser vacío!")
	@Size(min = 2, max = 12, message = "¡El campo Población debe tener enter 4 y 120 carácteres!")
	@Column(name = "celular_apoderado")
	private String celular_apoderado;

	@NotEmpty(message = "¡La calle no debe ser vacía!")
	@Size(min = 4, max = 120, message = "¡El campo Población o Condominío debe tener enter 4 y 120 carácteres!")
	@Column(name = "poblacion_apoderado")
	private String poblacion_apoderado;

	@NotEmpty(message = "¡La calle no debe ser vacía!")
	@Size(min = 4, max = 120, message = "¡El Apellido Paterno debe tener enter 4 y 120 carácteres!")
	@Column(name = "calle_apoderado")
	private String calle_apoderado;

	@NotEmpty(message = "¡El campo número de la calle no debe ser vacío!")
	@Size(min = 3, max = 6, message = "¡El número mínimo es 3 dígitos para la dirección!")
	@Column(name = "numero_casa_apoderado")
	private String numero_casa_apoderado;

	@Min(value = 18, message = "¡El campo Edad deber se mayor a 18 años!")
	@Max(value = 120, message = "¡El campo edad no deber mayor a 120 años!")
	@Column(name = "edad_apoderado")
	private Integer edad_apoderado;

	@JsonIgnore
	@OneToMany(mappedBy = "apoderado",fetch = FetchType.EAGER, cascade = CascadeType.MERGE )
	private List<Alumno> alumno= new ArrayList<>();
	
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
