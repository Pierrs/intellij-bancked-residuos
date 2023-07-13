package com.sistema.residuos.servicios.impl;

import com.sistema.residuos.modelo.Categoria;
import com.sistema.residuos.modelo.Tarea;
import com.sistema.residuos.repositorios.TareaRepository;
import com.sistema.residuos.servicios.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Tarea agregarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea actualizarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Set<Tarea> obtenerTareas() {
        return new LinkedHashSet<>(tareaRepository.findAll());
    }

    @Override
    public Tarea obtenerTarea(Long tareaId) {
        return tareaRepository.findById(tareaId).get();
    }

    @Override
    public void eliminarTarea(Long tareaId) {
        Tarea tarea = new Tarea();
        tarea.setTareaId(tareaId);
        tareaRepository.delete(tarea);

    }

    @Override
    public List<Tarea> listarTareasDeUnaCategoria(Categoria categoria) {
        return this.tareaRepository.findByCategoria(categoria);
    }

    @Override
    public List<Tarea> obtenerTareasActivos() {
        return tareaRepository.findByActivo(true);
    }

    @Override
    public List<Tarea> obtenerTareasActivosDeUnaCategoria(Categoria categoria) {
        return tareaRepository.findByCategoriaAndActivo(categoria,true);
    }
}
