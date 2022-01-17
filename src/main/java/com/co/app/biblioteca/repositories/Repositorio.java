package com.co.app.biblioteca.repositories;

import com.co.app.biblioteca.collections.Recursor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Repositorio extends ReactiveMongoRepository<Recursor,String> {
}
