package com.co.app.biblioteca.useCase;


import com.co.app.biblioteca.dto.RecursoDTO;
import reactor.core.publisher.Mono;

public interface ObtenerPorId {
    Mono<RecursoDTO> get(String id);
}
