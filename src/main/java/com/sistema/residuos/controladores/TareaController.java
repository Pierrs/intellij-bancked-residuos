package com.sistema.residuos.controladores;


import com.sistema.residuos.modelo.Categoria;
import com.sistema.residuos.modelo.Tarea;
import com.sistema.residuos.servicios.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tarea")
@CrossOrigin("*")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping("/")
    public ResponseEntity<Tarea> guardarTarea(@RequestBody Tarea tarea){
        return ResponseEntity.ok(tareaService.agregarTarea(tarea));
    }

    @PutMapping("/")
    public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea tarea){
        return ResponseEntity.ok(tareaService.actualizarTarea(tarea));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarTareas(){
        return ResponseEntity.ok(tareaService.obtenerTareas());
    }

    @GetMapping("/{tareaId}")
    public Tarea listarTarea(@PathVariable("tareaId") Long tareaId){
        return tareaService.obtenerTarea(tareaId);
    }

    @DeleteMapping("/{tareaId}")
    public void eliminarTarea(@PathVariable("tareaId") Long tareaId){
        tareaService.eliminarTarea(tareaId);
    }
    @GetMapping("/categoria/{categoriaId}")
    public List<Tarea> listarTareaDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId){
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return tareaService.listarTareasDeUnaCategoria(categoria);
    }

    @GetMapping("/activo")
    public List<Tarea> listarTareasActivos(){
        return tareaService.obtenerTareasActivos();
    }

    @GetMapping("/categoria/activo/{categoriaId}")
    public List<Tarea> listarTareasActivosDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId){
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return tareaService.obtenerTareasActivosDeUnaCategoria(categoria);
    }


}
