package com.tecsup.lab15v2.model.daos;

import com.tecsup.lab15v2.model.documents.Curso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CursoDao extends ReactiveMongoRepository<Curso, String> {
}
