package com.tareas.tareas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tareas.tareas.interfaceService.ItareaService;
import com.tareas.tareas.interfaces.Itarea;
import com.tareas.tareas.models.tarea;

@Service
public class tareaService implements ItareaService {
    
    @Autowired
    private Itarea data;

    @Override
    public String save(tarea tarea) {
        data.save(tarea);
        return tarea.getIdTarea();
    }

    @Override
    public List <tarea> findAll() {
        List <tarea> listaTarea = (List<tarea>) data.findAll();
        return listaTarea;
    }

    @Override
    public Optional<tarea> findOne(String id) {
        Optional<tarea> tarea = data.findById(id);
        return tarea;
    }

    @Override
    public int deleteForever(String id) {
        data.deleteById(id);
        return 1;
    }
}
