package com.sistema.residuos.servicios;

import com.sistema.residuos.modelo.Pregunta;
import com.sistema.residuos.modelo.Tarea;

import java.util.Set;

public interface PreguntaService {
    Pregunta agregarPregunta(Pregunta pregunta);
    Pregunta actualizarPregunta(Pregunta pregunta);
    Set<Pregunta> obtenerPreguntas();
    Pregunta obtenerPregunta(Long preguntaId);
    Set<Pregunta> obtenerPreguntasDelaTarea(Tarea tarea);

    void eliminarPregunta(Long preguntaId);
    Pregunta listarPregunta(Long preguntaId);
}
