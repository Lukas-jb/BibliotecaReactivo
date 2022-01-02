package com.co.app.biblioteca.repositories;

import com.sofka.biblioteca.model.Recurso;
import com.co.app.biblioteca.utils.Area;
import com.co.app.biblioteca.utils.Tipo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RepositorioRecurso extends MongoRepository<Recurso, String> {

    List<Recurso> findByArea(String area);
    List<Recurso> findByTipo(String tipo);
    List<Recurso> findByAreaAndTipo(String area, String tipo);

}