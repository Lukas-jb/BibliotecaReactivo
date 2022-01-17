package com.co.app.biblioteca.useCase;


import com.co.app.biblioteca.collections.Recurso;
import com.co.app.biblioteca.dto.RecursoDTO;
import com.co.app.biblioteca.mapper.RecursoMapper;
import com.co.app.biblioteca.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrear implements GuardarRecurso {

    private final RepositorioRecurso repositorio;
    private final RecursoMapper mapper;

    @Autowired
    public UseCaseCrear(RecursoMapper mapper, RepositorioRecurso repositorio) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO) {
        return repositorio.save(mapper.mapperToRecurso(null).apply(recursoDTO)).map(mapper.mapRecursoToDTO());
    }
}
