package com.complejoeducaciona.models;

import java.io.Serializable;
import java.util.AbstractList;
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

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matriculas")
public class Matriculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long id_matricula;

    @NotEmpty(message = "¡La matricula no debe estar vacío!")
    @Size(min = 2, max = 120, message = "¡El campo calle del matricula debe ser ingresado mínimo 4 y máximo 230 dígitos!")
    @Column(name = "codigo_matricula")
    private String codigo_matricula;

    @Min(value = 0, message = "¡El campo valot matrícula deber se mayor a 0!")
    @Max(value = 1000000, message = "¡El campo matrícula no deber mayor a 10000!")
    @Column(name = "valor_matricula")
    private Integer valor_matricula;

    @Column(name = "fecha_ingreso_matricula")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_ingreso_matricula;

    @Column(name = "fecha_termino_matricula")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_termino_matricula;
/**
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull(message = "¡El id del Curso no debe ser nulo!")
    @JoinColumn(name = "id_curso")
    private List<Curso> cursos = new ArrayList<Curso>();*/

}