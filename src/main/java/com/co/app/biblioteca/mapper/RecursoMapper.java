package com.co.app.biblioteca.mappers;

import com.co.app.biblioteca.collections.Recurso;
import com.co.app.biblioteca.dto.RecursoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {

    public Function<RecursoDTO, Recurso> mapperToDato(String id) {
        return updateDato -> {
            var dato = new Recurso();
            dato.setId(id);
            dato.setInformacion(updateDato.getInformacion());
            return dato;
        };
    }

    public Function<Recurso, RecursoDTO> mapDatoToDTO() {
        return entity -> new RecursoDTO(entity.getId(), entity.getInformacion());

    }
}

