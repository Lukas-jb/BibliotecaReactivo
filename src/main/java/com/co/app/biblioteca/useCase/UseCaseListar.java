package com.co.app.biblioteca.useCase;

import com.co.app.biblioteca.dto.DatoDTO;
import com.co.app.biblioteca.mappers.MapperUtils;
import com.co.app.biblioteca.repositories.Repositorio;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

public class UseCaseListar implements Supplier<Flux<DatoDTO>> {

    private final Repositorio repositorio;
    private final MapperUtils mapperUtils;

    public UseCaseListar(MapperUtils mapperUtils, Repositorio repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<DatoDTO> get() {
        return repositorio.findAll().map(mapperUtils.mapDatoToDTO());
    }

}