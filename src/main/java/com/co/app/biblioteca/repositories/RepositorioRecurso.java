package com.co.app.biblioteca.repositories;

import com.co.app.biblioteca.collections.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RepositorioRecurso extends ReactiveMongoRepository<Recurso,String> {
    Flux<Recurso> findByArea(String area);
    Flux<Recurso> findByTipo(String tipo);
    Flux<Recurso> findByAreaandTipo(String area, String tipo);

}
