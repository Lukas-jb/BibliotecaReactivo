package com.co.app.biblioteca.useCase;

import com.co.app.biblioteca.dto.RecursoDTO;
import com.co.app.biblioteca.mapper.RecursoMapper;
import com.co.app.biblioteca.repository.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseObtenerPorId implements ObtenerPorId {

    private final RepositorioRecurso repositorio;
    private final RecursoMapper mapper;

    public UseCaseObtenerPorId(RepositorioRecurso repositorio, RecursoMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Mono<RecursoDTO> get(String id) {
        return repositorio.findById(id).map(mapper.mapRecursoToDTO());
    }

}
