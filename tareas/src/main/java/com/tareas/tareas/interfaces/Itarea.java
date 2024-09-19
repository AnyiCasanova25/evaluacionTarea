package com.tareas.tareas.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tareas.tareas.models.tarea;

@Repository
public interface Itarea extends CrudRepository<tarea, String>{
    
}
