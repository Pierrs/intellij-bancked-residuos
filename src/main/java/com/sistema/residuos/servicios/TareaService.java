package com.sistema.residuos.servicios;

import com.sistema.residuos.modelo.Categoria;
import com.sistema.residuos.modelo.Tarea;

import java.util.List;
import java.util.Set;

public interface TareaService {
    Tarea agregarTarea(Tarea tarea);
    Tarea actualizarTarea(Tarea tarea);

    Set<Tarea> obtenerTareas( );
    Tarea obtenerTarea(Long tareaId);

    void eliminarTarea(Long tareaId);

    List<Tarea> listarTareasDeUnaCategoria(Categoria categoria);

    List<Tarea> obtenerTareasActivos();

    List<Tarea> obtenerTareasActivosDeUnaCategoria(Categoria categoria);



}
