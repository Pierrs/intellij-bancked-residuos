package com.sistema.residuos.repositorios;
import com.sistema.residuos.modelo.Pregunta;
import com.sistema.residuos.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PreguntaRepository extends JpaRepository<Pregunta,Long>{
    Set<Pregunta> findAllByTarea(Tarea tarea);
}
