package com.co.app.biblioteca.useCase;

import com.co.app.biblioteca.dto.RecursoDTO;
import com.co.app.biblioteca.mapper.RecursoMapper;
import com.co.app.biblioteca.repositories.Repositorio;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

public class UseCaseListar implements Supplier<Flux<RecursoDTO>> {

    private final Repositorio repositorio;
    private final RecursoMapper mapperUtils;

    public UseCaseListar(RecursoMapper mapperUtils, Repositorio repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<RecursoDTO> get() {
        return repositorio.findAll().map(mapperUtils.mapDatoToDTO());
    }

}