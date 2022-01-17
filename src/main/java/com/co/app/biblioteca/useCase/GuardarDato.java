package com.co.app.biblioteca.useCase;

import com.co.app.biblioteca.dto.DatoDTO;
import reactor.core.publisher.Mono;

public interface GuardarDato {
    public Mono<String> apply(DatoDTO datoDTO);


}
