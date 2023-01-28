package com.complejoeducaciona.repository;

import com.complejoeducaciona.modelosIngope.Profesor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProfesorRepository extends JpaRepository<Profesor, Long> {
    @Query(value = "select p from Profesor p left join fetch p.domicilio")
    public List<Profesor> findAllSortProfersores(Sort sort);

    @Query(value = "select p from Profesor p left join fetch p.domicilio",
            countQuery = "select count(p) from Profesor p left join p.domicilio")
    public Page<Profesor> findAllPageableProfesor(Pageable pageable);

    @Query(value = "select p from Profesor p left join p.domicilio where p.id=:id")
    public Profesor findById(long id);
}
