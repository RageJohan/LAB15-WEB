package com.tecsup.lab15v2.model.documents;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cursos")
public record Curso(String id, String nombre, Integer creditos) {
}
