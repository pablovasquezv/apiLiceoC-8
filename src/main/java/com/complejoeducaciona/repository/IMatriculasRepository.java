package com.complejoeducaciona.repository;

import com.complejoeducaciona.models.Alumno;
import com.complejoeducaciona.models.Matriculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IMatriculasRepository extends JpaRepository<Matriculas,Long> {

    @Query(value = "select m from Matriculas m where m.id=:id")
    public Alumno findById(long id);
}