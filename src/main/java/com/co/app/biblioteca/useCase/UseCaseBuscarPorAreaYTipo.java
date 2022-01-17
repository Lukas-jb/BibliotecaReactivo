package com.co.app.biblioteca.useCase;

import com.co.app.biblioteca.dto.RecursoDTO;
import com.co.app.biblioteca.mapper.RecursoMapper;
import com.co.app.biblioteca.repository.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class UseCaseBuscarPorAreaYTipo implements ObtenerPorAreaYTipo{

    private final RepositorioRecurso repositorio;
    private final RecursoMapper mapper;

    public UseCaseBuscarPorAreaYTipo(RepositorioRecurso repositorio, RecursoMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Flux<RecursoDTO> get(String area, String tipo) {
        return repositorio.findByAreaAndTipo(area, tipo).map(mapper.mapRecursoToDTO());
    }
}