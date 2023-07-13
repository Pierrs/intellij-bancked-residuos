package com.sistema.residuos.repositorios;

import com.sistema.residuos.modelo.Categoria;
import com.sistema.residuos.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository  extends JpaRepository<Tarea,Long> {
    List<Tarea> findByCategoria(Categoria categoria);

    List<Tarea> findByActivo(Boolean estado);

    List<Tarea> findByCategoriaAndActivo(Categoria categoria,Boolean estado);

}
