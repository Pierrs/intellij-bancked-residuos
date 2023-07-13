package com.sistema.residuos.controladores;

import com.sistema.residuos.modelo.Pregunta;
import com.sistema.residuos.modelo.Tarea;
import com.sistema.residuos.servicios.PreguntaService;
import com.sistema.residuos.servicios.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/pregunta")
@CrossOrigin("*")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @Autowired
    private TareaService tareaService;

    @PostMapping("/")
    public ResponseEntity<Pregunta> guardarPregunta(@RequestBody Pregunta pregunta) {
        return ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
    }

    @PutMapping("/")
    public ResponseEntity<Pregunta> actualizarPregunta(@RequestBody Pregunta pregunta) {
        return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta));
    }

    @GetMapping("/tarea/{tareaId}")
    public ResponseEntity<?> listarPreguntasDelaTarea(@PathVariable("tareaId") Long tareaId) {
        Tarea tarea = tareaService.obtenerTarea(tareaId);
        Set<Pregunta> preguntas = tarea.getPreguntas();

        List tareas = new ArrayList(preguntas);
        if (tareas.size() > Integer.parseInt(tarea.getNumeroDePreguntas())) {
            tareas = tareas.subList(0, Integer.parseInt(tarea.getNumeroDePreguntas() + 1));
        }

        Collections.shuffle(tareas);
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{preguntaId}")
    public Pregunta listarPreguntaPorId(@PathVariable("preguntaId") Long preguntaId) {
        return preguntaService.obtenerPregunta(preguntaId);
    }

    @DeleteMapping("/{preguntaId}")
    public void eliminarPregunta(@PathVariable("preguntaId") Long preguntaId) {
        preguntaService.eliminarPregunta(preguntaId);
    }
    @GetMapping("/tarea/todos/{tareaId}")
    public ResponseEntity<?> listarPreguntaDelaTareaComoAdministrador(@PathVariable("tareaId") Long tareaId){
        Tarea tarea = new Tarea();
        tarea.setTareaId(tareaId);
        Set<Pregunta> preguntas = preguntaService.obtenerPreguntasDelaTarea(tarea);
        return ResponseEntity.ok(preguntas);
    }

    @PostMapping("/evaluar-tarea")
    public ResponseEntity<?> evaluarExamen(@RequestBody List<Pregunta> preguntas){
        double puntosMaximos = 0;
        Integer respuestasCorrectas = 0;


        for(Pregunta p : preguntas){
            Pregunta pregunta = this.preguntaService.listarPregunta(p.getPreguntaId());
            if(pregunta.getRespuesta().equals(p.getRespuestaDada())){
                respuestasCorrectas ++;
                double puntos = Double.parseDouble(preguntas.get(0).getTarea().getPuntosMaximos())/preguntas.size();
                puntosMaximos += puntos;
            }

        }

        Map<String,Object> respuestas = new HashMap<>();
        respuestas.put("puntosMaximos",puntosMaximos);
        respuestas.put("respuestasAlcanzadas",respuestasCorrectas);
        return ResponseEntity.ok(respuestas);
    }

}