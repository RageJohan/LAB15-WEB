package com.tecsup.lab15v2.model.daos;

import com.tecsup.lab15v2.model.documents.Alumno;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AlumnoDao extends ReactiveMongoRepository<Alumno, String> {
}
