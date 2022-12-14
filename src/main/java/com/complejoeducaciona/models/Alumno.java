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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "alumnos")
public class Alumno {
	/***
	 * @GeneratedValue genera automaticamente el id.
	 * @Column Personalización para las columnas.
	 * @Size: Solo para String o Char.
	 * @NotEmpty: Campo obligatorío.
	 * @Min: validación del valor mínimo del campo.
	 * @Max: validación del valor mínimo del campo.
	 * @PrePersist: Ejecuta el método justo antes que el objeto sea creado.
	 * @PreUpdate: Ejecuta el método cuando el objeto es modificado.
	 * @NotNull: que debe ser nullo nunca.
	 * @JoinColumn: el campo que unirá las tablas
	 * @ManyToOne: relación uni direccional. 
	 * fetch = FetchType.LAZY= no carga todos apoderados solo trae el
	 *             alumno (no carga objetos en memoría).
	 * cascade = CascadeType.PERSIST:  
	 *   
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_alumno")
	private Long id_alumno;

	//@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@NotNull(message = "¡El id del apoderado no debe ser nulo!")
	@JoinColumn(name = "id_apoderado")
	private Apoderado apoderado;
	
	@NotEmpty(message = "¡El campo del Rut no debe estar vacío!")
	@Size(min = 9, max = 12, message = "¡El Rut debe ser ingresado mínimo 9 y máximo 10 dígitos!")
	@Column(name = "rut_alumno")
	private String rut_alumno;

	@NotEmpty(message = "¡El campo del Nombre no debe ser vacío!")
	@Size(min = 4, max = 30, message = "¡El nombre debe tener enter 4 y 30 carácteres!")
	@Column(name = "nombres_alumno")
	private String nombres_alumno;

	@NotEmpty(message = "¡El campo del Apellido Paterno no debe ser vacío!")
	@Size(min = 4, max = 20, message = "El Apellido Paterno debe tener enter 4 y 20 carácteres!")
	@Column(name = "apellido_paterno_alumno")
	private String apellido_paterno_alumno;

	@NotEmpty(message = "¡El campo del Apellido Paterno no debe ser vacío!")
	@Size(min = 4, max = 20, message = "¡El Apellido Materno debe tener enter 4 y 20 carácteres!")
	@Column(name = "apellido_materno_alumno")
	private String apellido_materno_alumno;

	
	@Column(name = "fecha_nacimiento_alumno")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_nacimiento_alumno;

	@NotEmpty(message = "¡El campo Género no puede ser vacío!")
	@Size(min = 2, max = 20, message = "El campo Genero debe tener enter 4 y 20 carácteres!")
	@Column(name = "genero_alumno")
	private String genero_alumno;

	@Min(value = 0, message = "¡La edad deber se mayor a 0 años!")
	@Max(value = 120, message = "¡La edad no deber mayor a 120 años!")
	@Column(name = "edad_alumno")
	private Integer edad_alumno;
	

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
