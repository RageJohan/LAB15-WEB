package com.tecsup.lab15v2.model.documents;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "alumnos")
public record Alumno(String id, String nombre, Integer nota) {
}

