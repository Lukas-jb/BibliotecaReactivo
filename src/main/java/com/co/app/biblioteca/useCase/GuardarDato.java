package com.co.app.biblioteca.useCase;

import com.co.app.biblioteca.dto.RecursoDTO;
import reactor.core.publisher.Mono;

public interface GuardarDato {
    public Mono<String> apply(RecursoDTO datoDTO);


}
