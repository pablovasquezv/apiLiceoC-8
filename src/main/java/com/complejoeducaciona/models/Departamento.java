/**
 * 
 */
package com.complejoeducaciona.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author Pablo
 *
 */
@Data
@Entity
@Table(name = "departamento")

public class Departamento implements Serializable {
	/***
	 * @GeneratedValue genera automaticamente el id
	 * @Column Personalización para las columnas
	 * @Size: Solo para String o Char.
	 * @NotEmpty: Campo obligatorío.
	 * @Min: validación del valor mínimo del campo.
	 * @Max: validación del valor mínimo del campo. 
	 * @PrePersist: Ejecuta el método justo antes que el objeto sea creado. 
	 * @PreUpdate: Ejecuta el método  cuando el objeto es modificado.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
	private Long id_departamento;
	
	@NotEmpty(message = "¡El campo no puede estar vacío!")
	@Size(min =1, max = 200, message = "¡El campos no debe tener como mínimo 2 y máximo 200 carácteres!")
	@Column(name = "nombre_Departamento")
	private String nombre_Departamento;
	
    // Esto no permitirá que el campo createdAt sea modificado después de su creación.
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

	public Departamento() {
		// TODO Auto-generated constructor stub
	}

	public Departamento(String nombre_Departamento) {
		this.nombre_Departamento= nombre_Departamento;
	}

	/**
	 * @return the id_departamento
	 */
	public Long getId_departamento() {
		return id_departamento;
	}

	/**
	 * @param id_departamento the id_departamento to set
	 */
	public void setId_departamento(Long id_departamento) {
		this.id_departamento = id_departamento;
	}

	/**
	 * @return the nombre_Departamento
	 */
	public String getNombre_Departamento() {
		return nombre_Departamento;
	}

	/**
	 * @param nombre_Departamento the nombre_Departamento to set
	 */
	public void setNombre_Departamento(String nombre_Departamento) {
		this.nombre_Departamento = nombre_Departamento;
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