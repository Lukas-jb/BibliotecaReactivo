package com.co.app.biblioteca.useCase;


import com.co.app.biblioteca.collections.Recurso;
import com.co.app.biblioteca.dto.RecursoDTO;
import com.co.app.biblioteca.mapper.RecursoMapper;
import com.co.app.biblioteca.repositories.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrear implements GuardarDato {

    private final Repositorio repositorio;
    private final RecursoMapper mapperUtils;

    @Autowired
    public UseCaseCrear(Repositorio repositorio, RecursoMapper mapperUtils) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(RecursoDTO datoDTO){
        return repositorio.save(mapperUtils.mapperToDato(null).apply(datoDTO)).map(Recurso::getId);
    }

}
