package com.tareas.tareas.interfaceService;

import java.util.List;
import java.util.Optional;

import com.tareas.tareas.models.tarea;

public interface ItareaService {
    
    public String save(tarea tarea);

    public List<tarea> findAll();

    public Optional<tarea> findOne(String id);

    public int deleteForever(String id);
}
