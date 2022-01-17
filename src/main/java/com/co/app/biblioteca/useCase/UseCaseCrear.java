package com.co.app.biblioteca.useCase;


import com.co.app.biblioteca.collections.Recursor;
import com.co.app.biblioteca.dto.DatoDTO;
import com.co.app.biblioteca.mappers.MapperUtils;
import com.co.app.biblioteca.repositories.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrear implements GuardarDato {

    private final Repositorio repositorio;
    private final MapperUtils mapperUtils;

    @Autowired
    public UseCaseCrear(Repositorio repositorio, MapperUtils mapperUtils) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(DatoDTO datoDTO){
        return repositorio.save(mapperUtils.mapperToDato(null).apply(datoDTO)).map(Recursor::getId);
    }

}
