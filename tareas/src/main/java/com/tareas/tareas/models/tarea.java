package com.tareas.tareas.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tarea")
public class tarea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idTarea",nullable = false, length = 36)
    private String idTarea;

    @Column(name = "title", nullable = false,length = 100)
    private String title;

    @Column(name = "dueDate", nullable = false, length = 10)
    private Date dueDate;

    @Column(name = "assignedTo", nullable = false, length = 500)
    private String assignedTo;

    @Enumerated(EnumType.STRING)
    private status status;
    
}
