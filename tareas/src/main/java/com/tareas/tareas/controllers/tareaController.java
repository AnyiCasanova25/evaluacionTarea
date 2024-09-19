package com.tareas.tareas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tareas.tareas.interfaceService.ItareaService;
import com.tareas.tareas.models.tarea;
import com.tareas.tareas.service.emailService;

@RestController
@RequestMapping("/api/v1/tarea")
public class tareaController {
    
    @Autowired
    private ItareaService tareaService;

     @Autowired
    private emailService emailService;

    @PostMapping("/tasks")
    public ResponseEntity<Object> save(@RequestBody tarea tarea) {
        
        if (tarea.getTitle().equals("")) {
            return new ResponseEntity<>("El campo title es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (tarea.getDueDate().equals("")) {
            return new ResponseEntity<>("El campo title es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (tarea.getAssignedTo().equals("")) {
            return new ResponseEntity<>("El campo title es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (tarea.getStatus().equals("")) {
            return new ResponseEntity<>("El campo title es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        tareaService.save(tarea);
        emailService.enviarCorreoRegistro(tarea.getAssignedTo());
        return new ResponseEntity<>(tarea,HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public ResponseEntity<Object> findAll() {
        var listaTarea = tareaService.findAll();
        return new ResponseEntity<>(listaTarea, HttpStatus.OK);
    }

     @GetMapping("/tasks/{id}")
    public ResponseEntity<Object> findOne(@PathVariable String id) {
        var tarea = tareaService.findOne(id);
        return new ResponseEntity<>(tarea,HttpStatus.OK);
    }

    @DeleteMapping("/eliminarPermanente/{id}")
    public ResponseEntity<Object> deleteForever(@PathVariable String id) {
        tareaService.deleteForever(id);
        return new ResponseEntity<>("Registro eliminado Permanentemente", HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody tarea tareaUpdate) {
        var tarea = tareaService.findOne(id).get();

        if (tarea != null) {
            
            tarea.setTitle(tareaUpdate.getTitle());
            tarea.setDueDate(tareaUpdate.getDueDate());
            tarea.setAssignedTo(tareaUpdate.getAssignedTo());
            tarea.setStatus(tareaUpdate.getStatus());

            tareaService.save(tarea);

            return new ResponseEntity<>(tarea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error tarea NO encontrada ", HttpStatus.BAD_REQUEST);
        }
    }
}
