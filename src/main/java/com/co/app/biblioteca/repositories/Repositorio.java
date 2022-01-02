package com.co.app.biblioteca.repositories;

import com.co.app.biblioteca.Collections.Dato;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Repositorio extends ReactiveMongoRepository<Dato,String> {
}
